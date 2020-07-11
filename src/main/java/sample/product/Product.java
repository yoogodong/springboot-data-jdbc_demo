package sample.product;

import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Value
@Table("alarm.product")
@AllArgsConstructor(onConstructor_ = @PersistenceConstructor)
public class Product {
    @Id
    @With
    private final Long id;
    private final String name;
    private final int quantity;
}
