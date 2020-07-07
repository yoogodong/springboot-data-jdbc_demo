package sample.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.common.Out;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PutMapping
    public Out add(@RequestBody Product product) {
        log.info("添加商品{}", product);

        service.addProduct(product);

        return Out.OK;
    }
}
