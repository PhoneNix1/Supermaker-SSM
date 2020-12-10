package cn.itcast.dao;

import cn.itcast.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {
    //查询结账表
    @Select("select * from tb_order where id = #{id}")
    Order getOrder(int id);

    //将现金结账插入到表中
    @Insert("insert into tb_order(id,order_number,sum,user_id,member_id,checkout_type,checkout_time)values(#{id},#{orderNumber},#{sum},#{userId},#{memberId},#{checkoutType},#{checkoutTime})")
    void insertOrder(Order order);
}
