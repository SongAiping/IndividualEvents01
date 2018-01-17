package com.service;

import com.entity.TbType;

import java.util.List;

/**
 * Created by Administrator on 2017/12/3.
 */
public interface TbTypeService {

    //查询
    public List<TbType> findTbType();

    //添加
    public boolean addTbType(TbType type);

    //删除
    public  boolean deleteTType(TbType type);

}
