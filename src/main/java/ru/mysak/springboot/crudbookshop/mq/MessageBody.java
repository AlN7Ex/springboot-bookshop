package ru.mysak.springboot.crudbookshop.mq;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mysak.springboot.crudbookshop.entity.Orders;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class MessageBody implements Serializable {
    private String text;
    private String title;
}
