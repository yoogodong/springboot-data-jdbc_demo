package sample.legoset.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


/*
 *表示乐高积木的使用手册
 *对积木之间的 one2one
 */
@Data
@Table("HANDBUCH")
public class Manual {
    @Column("HANDBUCH_ID")
    @Id
    private Long id;
    private String author, text;

    public Manual(String text, String author) {
        this.id = null;
        this.author = author;
        this.text = text;
    }
}
