package com.service;

import com.entity.TbUserInfo;

/**
 * Created by Administrator on 2017/11/6.
 */
public interface TbUserService {


    //登录
    public TbUserInfo doLogin(TbUserInfo users);

    //添加用户信息
    public boolean AddTbUsersInfo(TbUserInfo userInfo);


    //修改用户信息
    public boolean updateTbUserInfo(TbUserInfo userInfo);


    //根据id查询
    public  TbUserInfo findTbUserInfoListById(int id);

}
