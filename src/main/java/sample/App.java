package sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"sample.common", "sample.product"})
@Slf4j
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


//    @Bean
//    DataSourceInitializer initializer(DataSource dataSource) {
//
//        DataSourceInitializer initializer = new DataSourceInitializer();
//        initializer.setDataSource(dataSource);
//
//        ClassPathResource script = new ClassPathResource("schema.sql");
//        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(script);
//        initializer.setDatabasePopulator(populator);
//
//        return initializer;
//    }
}
