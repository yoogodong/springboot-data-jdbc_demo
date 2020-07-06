package sample.product;

import org.springframework.data.repository.CrudRepository;
import sample.common.DirectInsert;


public interface ProductRepository extends CrudRepository<Product, Long>, DirectInsert<Product> {

}
