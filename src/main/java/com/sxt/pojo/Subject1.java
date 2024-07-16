package com.sxt.pojo;

public class Subject1 {
    private Integer sid;
    private Integer cno;
    private String scontent;
    private String strue;
    private String sfalse;
    private  String skey;
    private Course course;


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getScontent() {
        return scontent;
    }

    public void setScontent(String scontent) {
        this.scontent = scontent;
    }

    public String getStrue() {
        return strue;
    }

    public void setStrue(String strue) {
        this.strue = strue;
    }

    public String getSfalse() {
        return sfalse;
    }

    public void setSfalse(String sfalse) { this.sfalse = sfalse; }

    public String getSkey() { return skey; }

    public void setSkey(String skey) {
        this.skey = skey;
    }
}
