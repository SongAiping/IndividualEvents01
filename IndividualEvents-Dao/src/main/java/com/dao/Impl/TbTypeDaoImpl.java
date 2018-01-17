package com.dao.Impl;

import com.dao.TbTypeDao;
import com.entity.TbType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/12/3.
 */
@SuppressWarnings("ALL")
@Repository("typeDao")
public class TbTypeDaoImpl extends BaseDao implements TbTypeDao {

    //查询商品类型
    @Override
    public List findTbType(String hql) {
        return getSession().createQuery(hql).list();
    }


    //添加商品类型
    @Override
    public boolean addTbType(TbType type) {
        getSession().save(type);
        return true;
    }

    @Override
    public boolean deleteTbType(TbType type) {
        getSession().delete(type);
        return true;
    }
}
