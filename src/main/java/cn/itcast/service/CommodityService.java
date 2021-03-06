package cn.itcast.service;

import cn.itcast.domain.Commodity;

import java.util.List;


public interface CommodityService {
    //查所有的接口
    List<Commodity> getCommodities();

    //添加接口
    boolean inputCommodity(Commodity commodity);

    //查询-根据输入的商品条码ID查询
    Commodity getCommodityID(int commodityID);

    //删除-删除商品
    void removeBoughtCommodity(String id);

    //现金结账-把库存表总的库存数更新下
    void updateCommodityStock(int id,int stock);

}
