package com.dao.Impl;

import com.dao.TbUserDao;
import com.entity.TbUserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */

@SuppressWarnings("ALL")
@Repository("userDao")
public class TbUserDaoImpl extends BaseDao implements TbUserDao{



    //添加用户信息
    @Override
    public boolean AddTbUsersInfo(TbUserInfo userInfo) {
        getSession().save(userInfo);
        return true;
    }

    //查询用户所有信息
    @Override
    public List findTbUserListInfo(String hql) {
        return getSession().createQuery(hql).list();
    }

    //修改个人《用户》信息
    @Override
    public boolean updateTbUserInfo(TbUserInfo userInfo) {
        getSession().update(userInfo);
        return true;
    }

    //根据id查询
    @Override
    public TbUserInfo findTbUserInfoListById(int id) {
        return getSession().get(TbUserInfo.class,id);
    }
}
