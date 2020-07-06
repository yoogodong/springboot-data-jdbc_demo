package sample.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sample.common.Out;

@RestController("/product")
@Slf4j
public class ProductController {

    @PutMapping()
    public Out add(@RequestBody ProductIN productIN) {
        log.info("添加商品{}", productIN);


        return Out.OK;
    }
}
