package sample.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public void addProduct(Product in) {
        repository.insert(in);
    }


}
