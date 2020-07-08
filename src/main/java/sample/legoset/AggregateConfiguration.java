package sample.legoset;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.relational.core.conversion.AggregateChange;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;
import org.springframework.lang.Nullable;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.asList;


/**
 * 1。 演示如何自定义类型转化
 * 2。 演示如何通过事件监听器实现自增主键策略，从而不使用 DB 完成自增主键
 */
@Configuration
public class AggregateConfiguration extends AbstractJdbcConfiguration {
    final AtomicInteger id = new AtomicInteger(0);

    @Override
    public JdbcCustomConversions jdbcCustomConversions() {

        return new JdbcCustomConversions(asList(new Converter<Clob, String>() {
            @Nullable
            @Override
            public String convert(Clob clob) {
                try {
                    return Math.toIntExact(clob.length()) == 0 //
                            ? "" //
                            : clob.getSubString(1, Math.toIntExact(clob.length()));
                } catch (SQLException e) {
                    throw new IllegalStateException("不能将Clob 转化成 String.", e);
                }
            }
        }));
    }

    @Bean
    public BeforeSaveCallback beforeSaving() {
        return new BeforeSaveCallback<LegoSet>() {
            @Override
            public LegoSet onBeforeSave(LegoSet legoSet, AggregateChange<LegoSet> aggregateChange) {
                if (legoSet.getId() == 0) {
                    legoSet.setId(id.incrementAndGet());
                }
                Manual manual = legoSet.getManual();

                if (manual != null) {
                    manual.setId((long) legoSet.getId());
                }
                return legoSet;
            }
        };
    }

}
