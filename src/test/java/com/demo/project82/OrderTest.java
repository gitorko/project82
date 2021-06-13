package com.demo.project82;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.demo.project82.order.Item;
import com.demo.project82.order.ItemType;
import com.demo.project82.order.Order;
import com.demo.project82.order.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void test() {
        Item item1 = Item.builder()
                .itemName("item1")
                .itemPrice(3.45f)
                .itemType(ItemType.P1)
                .createdOn(new Date())
                .build();
        Order order = new Order();
        Map<String, Item> product = new HashMap<>();
        product.put("item1", item1);
        order.setItemMap(product);

        orderRepository.save(order);
        orderRepository.findAll().forEach(System.out::println);
    }
}
