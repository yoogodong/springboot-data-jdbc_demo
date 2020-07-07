package sample.account;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor(onConstructor_ = {@PersistenceConstructor})
@Data
public class Account {
    private final LocalDateTime openTime;
    @Id
    private Long id;
    private String description;

    public Account(String description) {
        this.description = description;
        openTime = LocalDateTime.now();
    }
}
