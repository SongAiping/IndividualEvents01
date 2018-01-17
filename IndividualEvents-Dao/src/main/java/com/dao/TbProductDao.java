package com.dao;

import com.entity.TbProduct;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
public interface TbProductDao {
    //添加商品
    public boolean addProduct(TbProduct product);
    //查询商品列表
    public List findTbProduct(String hql);

    //处理商品上架下架
    public boolean updateTbProduct(String sql);

    //根据id查询
    public TbProduct findTbProductById(int id);
    //修改商品
    public boolean updateTbProduct(TbProduct product);

    //删除商品
    public boolean deleteTbProduct(TbProduct product);
}
