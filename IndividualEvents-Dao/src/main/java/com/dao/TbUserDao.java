package com.dao;

import com.entity.TbUserInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
public interface TbUserDao {

    //添加用户信息
    public boolean AddTbUsersInfo(TbUserInfo userInfo);

    //查看用户信息
    public List findTbUserListInfo(String hql);

    //修改用户信息
    public boolean updateTbUserInfo(TbUserInfo userInfo);


    //根据id查询
    public  TbUserInfo findTbUserInfoListById(int id);


}
