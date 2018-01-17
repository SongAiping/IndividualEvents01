package com.dao.Impl;

import com.dao.TbProductDao;
import com.entity.TbProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
@SuppressWarnings("ALL")
@Repository("productDao")
public class TbProductDaoImpl extends BaseDao implements TbProductDao {
    //添加
    @Override
    public boolean addProduct(TbProduct product) {
        getSession().save(product);
        return true;
    }

    //查询
    @Override
    public List findTbProduct(String hql) {
        return getSession().createQuery(hql).list();
    }

    //根据id查询
    @Override
    public TbProduct findTbProductById(int id) {
        return getSession().get(TbProduct.class,id);
    }

    //修改
    @Override
    public boolean updateTbProduct(TbProduct product) {
        getSession().update(product);
        return true;
    }
    //处理商品上架下架
    public boolean updateTbProduct(String sql){
        int n=getSession().createSQLQuery(sql).executeUpdate();
        if(n>1){
            return true;
        }
        return  false;
    }
    //删除
    @Override
    public boolean deleteTbProduct(TbProduct product) {
        getSession().delete(product);
        return true;
    }
}
