package ru.mysak.springboot.crudbookshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.mysak.springboot.crudbookshop.entity.Product;
import ru.mysak.springboot.crudbookshop.service.ProductService;

@SpringBootApplication
public class CrudBookshopApplication {    private static final Logger log = LoggerFactory.getLogger(CrudBookshopApplication.class);
    static void updateAsync(ProductService service) {

        Product product = service.getProductById(5);
        product.setName("product");

        for (int i = 0; i < 5; i++) {
            new Thread(() -> service.update(product)).start();
        }
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CrudBookshopApplication.class, args);

    }
}
