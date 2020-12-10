package cn.itcast.service;

import cn.itcast.domain.Order;
import org.springframework.stereotype.Component;

@Component
public interface OrderService {
    // 现金结账
    boolean addOrder(Order order);
}
