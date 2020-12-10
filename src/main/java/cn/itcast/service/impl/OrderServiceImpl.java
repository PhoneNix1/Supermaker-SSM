package cn.itcast.service.impl;

import cn.itcast.dao.OrderMapper;
import cn.itcast.domain.Order;
import cn.itcast.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public boolean addOrder(Order order){
        // 查询是否有相同ID
        Order order1 = orderMapper.getOrder(order.getId());
        if(order1 !=null){
            return false;
        }else {
            orderMapper.insertOrder(order);
            return true;
        }
    }

}
