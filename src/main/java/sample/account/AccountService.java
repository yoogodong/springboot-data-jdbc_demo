package sample.account;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository repository;


    public Long open(String description) {
        Account save = repository.save(new Account(description));
        return save.getId();
    }


    public Iterable<Account> listAll() {
        return repository.findAll();
    }


    public List<Account> findAccountByDescription(String desc) {
        return repository.findAccountByDescription(desc);
    }

    public int batchAppendDesc(String append) {
        return repository.batchUpdateDesc(append);
    }

}
