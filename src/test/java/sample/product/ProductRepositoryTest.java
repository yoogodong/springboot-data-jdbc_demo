package sample.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import sample.App;

@SpringBootTest(classes = App.class)
class ProductRepositoryTest {

    @Autowired
    ProductRepository repository;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    JdbcAggregateTemplate aggregateTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Test
    void name() {
//        Product mate = new Product(5L, "mate", 100);
//        repository.insert(mate);
//        Product vivo = new Product(2L, "vivo", 1000);
//        repository.insert(vivo);


        Iterable<Product> all = repository.findAll();

    }
}