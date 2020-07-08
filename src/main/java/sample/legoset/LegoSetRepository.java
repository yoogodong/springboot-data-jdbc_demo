package sample.legoset;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
interface LegoSetRepository extends CrudRepository<LegoSet, Integer> {

    /**
     * 通过 query 实现更新
     */
    @Modifying
    @Query("UPDATE model set name = lower(name) WHERE name <> lower(name)")
    int lowerCaseMapKeys();
}
