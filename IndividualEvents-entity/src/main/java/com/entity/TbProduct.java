package com.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/11/6.
 */
@Entity
@Table(name="tb_Product")
public class TbProduct {
    private int pno;
    private String pimg;             //图片
    private String pname;           //名称
    private String psize;              //尺码
    private double pprice;          //价格
    private String ppackage;        //包邮
    private int pstatus;            //是否上架

    //类型
    private TbType type;

    public TbProduct() {
    }

    public TbProduct(int pno, String pimg, String pname, String psize, double pprice, String ppackage, int pstatus) {
        this.pno = pno;
        this.pimg = pimg;
        this.pname = pname;
        this.psize = psize;
        this.pprice = pprice;
        this.ppackage = ppackage;
        this.pstatus = pstatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getPimg() {
        return pimg;
    }

    public void setPimg(String pimg) {
        this.pimg = pimg;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPsize() {
        return psize;
    }

    public void setPsize(String psize) {
        this.psize = psize;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    public String getPpackage() {
        return ppackage;
    }

    public void setPpackage(String ppackage) {
        this.ppackage = ppackage;
    }

     public int getPstatus(){return pstatus;}

     public void setPstatus(int pstatus){this.pstatus = pstatus;}

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name = "ptype")
    public TbType getType() {
        return type;
    }

    public void setType(TbType type) {
        this.type = type;
    }
}
