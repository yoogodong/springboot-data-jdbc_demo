package sample.account;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query("select * from account where description=:desc")
    List<Account> findAccountByDescription(@Param("desc") String desc);

}
