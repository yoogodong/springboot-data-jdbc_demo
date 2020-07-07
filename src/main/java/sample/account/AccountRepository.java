package sample.account;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query("select * from account where description=:desc")
    List<Account> findAccountByDescription(@Param("desc") String desc);


    @Modifying
    @Query("update account set description=concat(description,:append) where id%2=0")
    int batchUpdateDesc(String append);
}
