package com.yc.blog.bean;

import java.util.Date;

public class User {
    private Integer uid;

    private String unamme;

    private String nickname;

    private String passsword;

    private String uphone;

    private String uemail;

    private String head;

    private Date createtime;

    private Integer ustatus;

    private Integer utype;

    private String utemp;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUnamme() {
        return unamme;
    }

    public void setUnamme(String unamme) {
        this.unamme = unamme == null ? null : unamme.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword == null ? null : passsword.trim();
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone == null ? null : uphone.trim();
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail == null ? null : uemail.trim();
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head == null ? null : head.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUstatus() {
        return ustatus;
    }

    public void setUstatus(Integer ustatus) {
        this.ustatus = ustatus;
    }

    public Integer getUtype() {
        return utype;
    }

    public void setUtype(Integer utype) {
        this.utype = utype;
    }

    public String getUtemp() {
        return utemp;
    }

    public void setUtemp(String utemp) {
        this.utemp = utemp == null ? null : utemp.trim();
    }
}