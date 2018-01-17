package com.web;

import com.entity.TbType;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.TbTypeService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2017/11/6.
 */
@Controller("typeAction")
@Scope("prototype")
public class TbTypeAction extends ActionSupport{
    private TbType type;
    private int msg;


    @Resource(name="typeService")
    private TbTypeService typeService;



    //添加类型
    public String AddTbType(){
        if( typeService.addTbType(type)){
            msg = 1;
        }else {
            msg = 0;
        }
        return "AddType";
    }

    //查询类型
    public String findTbType(){
        ActionContext.getContext().put("typeList",typeService.findTbType());
        return "showType";
    }

    //删除类型信息
    public String deleteTbType(){
        if(typeService.deleteTType(type)){
            msg = 1;
        }else{
           msg = 0;
        }
        return "deleteType";
    }



    //---------------------------------------------------------

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public TbType getType() {
        return type;
    }

    public void setType(TbType type) {
        this.type = type;
    }

    public void setTypeService(TbTypeService typeService) {
        this.typeService = typeService;
    }
}
