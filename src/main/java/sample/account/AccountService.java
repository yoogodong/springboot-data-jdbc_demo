package sample.account;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository repository;


    public Long open(String description) {
        Account save = repository.save(new Account(description));
        return save.getId();
    }


}
