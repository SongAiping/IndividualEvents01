package com.web;

import com.entity.TbProduct;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.TbProductService;
import com.service.TbTypeService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/27.
 */
@Controller("productAction")
@Scope("prototype")
public class TbProductAction extends ActionSupport {
    private TbProduct product;
    private int msg;
    private ArrayList<Integer> pno; //需要上下加的物品
    private int pstatus; //状态

    private File productImage;
    private String productImageFileName;

    @Resource(name="productService")
    private TbProductService productService;

    @Resource(name="typeService")
    private TbTypeService typeService;


    //跳到添加商品页面
    public String toAddProduct(){
        ActionContext.getContext().put("productList", typeService.findTbType());
      return "toAddproduct";
    };

    //添加商品
    public String addProduct(){
        uploadImge();
        if(productService.addProduct(product)){
            msg = 1;
        }else{
            msg = 0;
        }
        return "doaddproduct";
    }

    //执行图像上传操作
    private void uploadImge(){
        if(productImage!=null&&productImageFileName!=null){
            ServletContext ctx= ServletActionContext.getServletContext();
            String path=ctx.getRealPath("/upload");
            String filePath=path+"/"+productImageFileName;//获取文件要上传的路径
            try {
                FileUtils.copyFile(productImage, new File(filePath));//执行上传
                //记录文件路径
                product.setPimg("upload/"+productImageFileName);//记录图片路径
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //查询商品信息
    public String findproductList(){
        ActionContext.getContext().put("productList",productService.findTbProduct());
        return "showProduct";
    }

    //删除
    public String deleteproduct(){
        if (productService.deleteTbProduct(product)){
            msg=1;
        }else {
            msg=0;
        }
        return "deleteproduct";
    }

    //跳到修改商品信息页面
    public String toUpdateProduct(){
        product = productService.findTbProductById(product.getPno());
        ActionContext.getContext().put("productList",typeService.findTbType());
        return "toupdateProduct";
    }

    //修改商品信息
    public String UpdateProduct(){
        if(productService.updateTbProduct(product)){
            msg = 1;
        }else{
            msg = 0;
        }
        return "updateProduct";
    }

    //处理商品上架下架
    @ResponseBody
    public String headelProduct() {
      for(int i=0;i<pno.size();i++){
          if(product.getPno() !=1){

          }
            productService.updateTbProduct(pno.get(i),pstatus);
        }
        msg=1;
        return "headelProduct";
    }





    //-------------------------------------------------


    public TbProduct getProduct() {
        return product;
    }

    public void setProduct(TbProduct product) {
        this.product = product;
    }

    public File getProductImage() {
        return productImage;
    }

    public void setProductImage(File productImage) {
        this.productImage = productImage;
    }

    public String getProductImageFileName() {
        return productImageFileName;
    }

    public void setProductImageFileName(String productImageFileName) {
        this.productImageFileName = productImageFileName;
    }

    public void setProductService(TbProductService productService) {
        this.productService = productService;
    }

    public void setTypeService(TbTypeService typeService) {
        this.typeService = typeService;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public ArrayList<Integer> getPno() {
        return pno;
    }

    public void setPno(ArrayList<Integer> pno) {
        this.pno = pno;
    }

    public int getPstatus() {
        return pstatus;
    }

    public void setPstatus(int pstatus) {
        this.pstatus = pstatus;
    }
}
