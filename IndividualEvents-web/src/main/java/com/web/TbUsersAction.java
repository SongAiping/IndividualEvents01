package com.web;

import com.entity.TbUserInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.TbUserService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.io.File;


/**
 * Created by Administrator on 2017/11/6.
 */
@Controller("userAction")
@Scope("prototype")
public class TbUsersAction extends ActionSupport{
    private TbUserInfo userInfo;        //用户消息
    private int msg;                    //定义传到前台的消息
    private File userImage;             //文件路径
    private String userImageFileName;  //图片路径


    @Resource(name="userService")
    private TbUserService userService;


    //处理登录操作
    public String doLogin(){
        userInfo = userService.doLogin(userInfo);                                //调用服务层方法处理登录
        if (userInfo==null){
            addActionError("用户名和密码错误！");
            return "input";
        }else {
            ActionContext.getContext().getSession().put("LoginUser",userInfo);   //如果登录成功，保持登录状态
        }
        return "main";
    }

    //添加用户信息
    public String AddUserInfo(){
        uploadImge();
        userService.AddTbUsersInfo(userInfo);
        return "main";
    }

    //执行图像上传操作
    private void uploadImge(){
        if(userImage!=null&&userImageFileName!=null){
            ServletContext ctx= ServletActionContext.getServletContext();
            String path=ctx.getRealPath("/upload");
            String filePath=path+"/"+userImageFileName;           //获取文件要上传的路径
            try {
                FileUtils.copyFile(userImage, new File(filePath)); //执行上传
                userInfo.setIimg("upload/"+userImageFileName);  // //记录文件路径和图片路径
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //查询个人信息
    public String findUserInfoList(){
        userInfo=userService.findTbUserInfoListById(userInfo.getIno());
        return "userInfo";
    }

    //------------------------------------------------------------
    //去到修改用户页面
    public  String toupdateinfo(){
        userInfo = userService.findTbUserInfoListById(userInfo.getIno());
        System.out.println(userInfo.getIname());
        return "update";
    }

    //修改个人信息
    public String updateTbUserInfo(){
        uploadImge();
        if(userService.updateTbUserInfo(userInfo)){
            msg = 1;
        }else{
            msg= 0;
        }
        return "doUpdateTbUser";
    }

    //--------------------------
    //去到修改密码页面
    public  String toUpdatePassword(){
        userInfo = userService.findTbUserInfoListById(userInfo.getIno());
        return "updatepssrld";
    }

    //修改密码
    public String UpdatePassword(){
        if(userService.updateTbUserInfo(userInfo)){
            msg = 1;
        }else{
            msg= 0;
        }
        return "doUpdatepssrld";
    }




    //---------------------------------------------------------

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public void setUserService(TbUserService userService) {
        this.userService = userService;
    }

    public TbUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(TbUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public File getUserImage() {
        return userImage;
    }

    public void setUserImage(File userImage) {
        this.userImage = userImage;
    }

    public String getUserImageFileName() {
        return userImageFileName;
    }

    public void setUserImageFileName(String userImageFileName) {
        this.userImageFileName = userImageFileName;
    }
}
