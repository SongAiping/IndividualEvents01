package com.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/11/6.
 */
@Entity
@Table(name="tb_type")
public class TbType {
    private int tno;
    private String tname;

    public TbType() {
    }

    public TbType(int tno, String tname) {
        this.tno = tno;
        this.tname = tname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
