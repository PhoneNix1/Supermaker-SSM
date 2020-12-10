package cn.itcast.service.impl;

import cn.itcast.dao.CommodityMapper;
import cn.itcast.domain.Commodity;
import cn.itcast.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    CommodityMapper commodityMapper;
    @Override
    public List<Commodity> getCommodities(){
        return commodityMapper.getCommodities();
    }
    // 插入仓库功能
    @Override
    public boolean inputCommodity(Commodity commodity) {
        // 先查询一下仓库表的数据
        Commodity commodity1 = commodityMapper.getCommodity(commodity.getId());
        // 如果相同进行更新
        if (commodity1 != null) {
            commodityMapper.updateCommodity(commodity);
            return false;
        }
        // 商品条码不同直接进行添加
        else {
            commodityMapper.insertCommodity(commodity);
            return true;
        }
    }
    // 根据输入商品条码ID查询数据
    @Override
    public Commodity getCommodityID(int commodityID){
        return commodityMapper.getCommodityID(commodityID);
    }

    //删除-删除商品
    @Override
    public void removeBoughtCommodity(String id){
        commodityMapper.removeBoughtCommodity(id);
    }

    //现金结账-把库存表总的库存数更新下
    @Override
    public void updateCommodityStock(int id,int stock){
        commodityMapper.updateCommodityStock(id, stock);
    }
}
