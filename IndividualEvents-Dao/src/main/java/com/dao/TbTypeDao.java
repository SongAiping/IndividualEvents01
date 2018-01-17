package com.dao;

import com.entity.TbType;

import java.util.List;

/**
 * Created by Administrator on 2017/12/3.
 */
public interface TbTypeDao {

    //查询
    public List findTbType(String hql);

    //添加类型
    public boolean addTbType(TbType type);

    //删除
    public boolean deleteTbType(TbType type);

}
