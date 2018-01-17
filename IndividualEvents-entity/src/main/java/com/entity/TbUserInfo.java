package com.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/11/6.
 */

@Entity
@Table(name = "tb_UserInfo")
public class TbUserInfo {
    private int ino;
    private String ipwd;
    private String iimg;
    private String iname;
    private String ibirthday;
    private String isex;
    private String iemail;
    private String itab;

    public TbUserInfo() {
    }

    public TbUserInfo(int ino, String ipwd, String iimg, String iname, String ibirthday, String isex, String iemail, String itab) {
        this.ino = ino;
        this.ipwd = ipwd;
        this.iimg = iimg;
        this.iname = iname;
        this.ibirthday = ibirthday;
        this.isex = isex;
        this.iemail = iemail;
        this.itab = itab;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIno() {
        return ino;
    }

    public void setIno(int ino) {
        this.ino = ino;
    }

    public String getIpwd() {
        return ipwd;
    }

    public void setIpwd(String ipwd) {
        this.ipwd = ipwd;
    }

    public String getIimg() {
        return iimg;
    }

    public void setIimg(String iimg) {
        this.iimg = iimg;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getIbirthday() {
        return ibirthday;
    }

    public void setIbirthday(String ibirthday) {
        this.ibirthday = ibirthday;
    }

    public String getIsex() {
        return isex;
    }

    public void setIsex(String isex) {
        this.isex = isex;
    }

    public String getIemail() {
        return iemail;
    }

    public void setIemail(String iemail) {
        this.iemail = iemail;
    }

    public String getItab() {
        return itab;
    }

    public void setItab(String itab) {
        this.itab = itab;
    }
}
