package sample.legoset.domain;

import lombok.Data;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;


/**
 * 表示一套乐高积木
 */
@Data
public class LegoSet {

    @Id
    private int id;
    private String name;
    @Transient
    /**使用 @Transient 标记不做持久化的字段*/
    private Period minimumAge, maximumAge;
    /**
     * 乐高的手册， one2one 关联
     */
    @Column("HANDBUCH_ID")
    private Manual manual;

    /**
     * 可以搭建的模型，这个属性不能 Set, 为了能让 spring 设置其值，有两种选择，一是包含在构造方法参数中，二是提供 with 方法--spring 会自动找这个方法
     */
    @MappedCollection(keyColumn = "NAME")
    private final Map<String, Model> models;

    /**
     * 给应用使用
     */
    LegoSet() {
        this.models = new HashMap<>();
    }

    /**
     * 因为有不持久化的属性，所以不能直接使用 @AllArgsConstructor 来做为持久化使用的构造方法
     */
    @PersistenceConstructor
    public LegoSet(int id, String name, Manual manual, Map<String, Model> models) {
        this.id = id;
        this.name = name;
        this.manual = manual;
        this.models = models;
    }

    private static int toInt(Period period) {
        return (int) (period == null ? 0 : period.get(ChronoUnit.YEARS));
    }

    private static Period toPeriod(int years) {
        return Period.ofYears(years);
    }

    /**
     * 必须通过 get/set 来实现这个属性的持久化操作，
     * 这两个属性的 get/set 为了给 Spring 使用
     */
    @Column("MIN_AGE")
    @AccessType(Type.PROPERTY) //通过 @AccessType 标记持节化使用（字段/属性）哪种访问方式
    public int getIntMinimumAge() {
        return toInt(this.minimumAge);
    }

    public void setIntMinimumAge(int years) {
        minimumAge = toPeriod(years);
    }

    @Column("MAX_AGE")
    @AccessType(Type.PROPERTY)
    public int getIntMaximumAge() {
        return toInt(this.maximumAge);
    }

    public void setIntMaximumAge(int years) {
        maximumAge = toPeriod(years);
    }

    public void addModel(String name, String description) {
        Model model = new Model(name, description);
        models.put(name, model);
    }
}
