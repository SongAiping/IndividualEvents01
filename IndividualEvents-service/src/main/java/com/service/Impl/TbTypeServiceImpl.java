package com.service.Impl;

import com.dao.TbTypeDao;
import com.entity.TbType;
import com.service.TbTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/3.
 */
@Service("typeService")
@Transactional(propagation = Propagation.REQUIRED)
public class TbTypeServiceImpl implements TbTypeService {

    @Resource(name="typeDao")
    private TbTypeDao typeDao;

    //查询
    @Override
    public List<TbType> findTbType() {
        return typeDao.findTbType("from TbType");
    }

    //添加
    @Override
    public boolean addTbType(TbType type) {
        return typeDao.addTbType(type);
    }

    //删除
    @Override
    public boolean deleteTType(TbType type) {
        return typeDao.deleteTbType(type);
    }

    //--------------------------------+

    public void setTypeDao(TbTypeDao typeDao) {
        this.typeDao = typeDao;
    }


}
