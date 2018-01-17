package com.service.Impl;

import com.dao.TbProductDao;
import com.entity.TbProduct;
import com.service.TbProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
@Service("productService")
@Transactional(propagation = Propagation.REQUIRED)
public class TbProductServiceImpl implements TbProductService {

    @Resource( name="productDao")
    private TbProductDao productDao;


    //添加
    @Override
    public boolean addProduct(TbProduct product) {
        return productDao.addProduct(product);
    }

    //查询
    @Override
    public List findTbProduct() {
        return productDao.findTbProduct("from TbProduct p inner join p.type t order by t.tno");
    }

    //根据id查询
    @Override
    public TbProduct findTbProductById(int id) {
        return productDao.findTbProductById(id);
    }

    //修改
    @Override
    public boolean updateTbProduct(TbProduct product) {
        return productDao.updateTbProduct(product);
    }

    //处理商品上架下架
    public boolean updateTbProduct(int id, int pstatus) {
        return productDao.updateTbProduct("update tb_product set pstatus ="+pstatus+" where pno="+ id );
    }


    //删除
    @Override
    public boolean deleteTbProduct(TbProduct product) {
        return productDao.deleteTbProduct(product);
    }

    //------------------------------------------------------------

    public void setProductDao(TbProductDao productDao) {
        this.productDao = productDao;
    }
}
