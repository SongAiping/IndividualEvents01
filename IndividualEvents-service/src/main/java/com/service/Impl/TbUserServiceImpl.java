package com.service.Impl;

import com.dao.TbUserDao;
import com.entity.TbUserInfo;
import com.service.TbUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/6.
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class TbUserServiceImpl implements TbUserService {

    @Resource(name="userDao")
    private TbUserDao userDao;


    @Override
    public TbUserInfo doLogin(TbUserInfo users) {
       String hql = "from TbUserInfo u where u.iname='"+users.getIname()+"'";
        System.out.println(users.getIname());
       //取出同名所有用户
        List<TbUserInfo> list = userDao.findTbUserListInfo(hql);
        if (list != null&&list.size()>0) {
            for (TbUserInfo users1 : list) {
                if (users1.getIname().equals(users.getIname()) && users1.getIpwd().equals(users.getIpwd())) {
                    System.out.println(users.getIname());
                    return users1;
                }
            }
        }
        return null;
    }


    //添加用户信息
    @Override
    public boolean AddTbUsersInfo(TbUserInfo userInfo) {
        return userDao.AddTbUsersInfo(userInfo);
    }


    //修改个人信息
    @Override
    public boolean updateTbUserInfo(TbUserInfo userInfo) {
        return userDao.updateTbUserInfo(userInfo);
    }



    //根据id查询
    @Override
    public TbUserInfo findTbUserInfoListById(int id) {
        return userDao.findTbUserInfoListById(id);
    }


    //-------------------------------------------------------
    public void setUserDao(TbUserDao userDao) {
        this.userDao = userDao;
    }


}
