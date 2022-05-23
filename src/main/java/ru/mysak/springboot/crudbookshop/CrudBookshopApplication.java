package ru.mysak.springboot.crudbookshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import ru.mysak.springboot.crudbookshop.entity.Orders;
import ru.mysak.springboot.crudbookshop.mq.MessageSender;
import ru.mysak.springboot.crudbookshop.service.OrdersService;
import ru.mysak.springboot.crudbookshop.user.UserService;

import java.util.List;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CrudBookshopApplication {    private static final Logger log = LoggerFactory.getLogger(CrudBookshopApplication.class);
//    static void updateAsync(ProductService service) {
//
//        Product product = service.getProductById(5);
//        product.setName("product");
//
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> service.update(product)).start();
//        }
//    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CrudBookshopApplication.class, args);
//
//        List<Orders> allOrders = context.getBean(OrdersService.class).getAllOrders();
//        String msg = "Orders ";
//        for (Orders orders : allOrders) {
//            msg += ", " + orders.getOrders_id().toString();
//        }
//
//        MessageSender bean = context.getBean(MessageSender.class);

//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> bean.sendMessage(msg).start();
//        }


    }
}
