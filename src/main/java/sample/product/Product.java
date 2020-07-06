package sample.product;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@ToString
@AllArgsConstructor
public class Product {
    @Id
    private final Long id;
    private final String name;
    private final int quantity;
}
