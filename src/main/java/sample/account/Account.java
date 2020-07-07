package sample.account;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Account {
    @CreatedDate
    private final LocalDateTime openTime;
    @Id
    private Long id;
    private String description;

    public Account(String description) {
        this.description = description;
        openTime = LocalDateTime.now();
    }
}
