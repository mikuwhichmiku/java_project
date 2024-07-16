package com.sxt.pojo;

import java.util.Date;

/**
 * exams   com.sxt.pojo
 * 2022-07-17  10:06
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/17  10:06
 */
public class Exam {
    private Integer eid;
    private String pname;
    private Integer cno;
    private Integer cno1;
    private Integer userid;
    private Integer classid;
    private Integer singlenumber;
    private Integer singlecore;
    private Integer multiplenumber;
    private Integer multiplecore;
    private Integer judgmentnumber;
    private Integer judgmentcore;
    private Date examdate;
    private  Date examtime;
    private Integer testtime;
    private Course course;
    private Course course1;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public Integer getCno1() {
        return cno1;
    }

    public void setCno1(Integer cno1) {
        this.cno1 = cno1;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getSinglenumber() {
        return singlenumber;
    }

    public void setSinglenumber(Integer singlenumber) {
        this.singlenumber = singlenumber;
    }

    public Integer getSinglecore() {
        return singlecore;
    }

    public void setSinglecore(Integer singlecore) {
        this.singlecore = singlecore;
    }

    public Integer getMultiplenumber() {
        return multiplenumber;
    }//here

    public void setMultiplenumber(Integer multiplenumber) {
        this.multiplenumber = multiplenumber;
    }

    public Integer getMultiplecore() {
        return multiplecore;
    }

    public void setMultiplecore(Integer multiplecore) { this.multiplecore = multiplecore; }

    public Integer getJudgmentnumber() { return judgmentnumber; }

    public void setJudgmentnumber(Integer judgmentnumber) { this.judgmentnumber = judgmentnumber; }

    public Integer getJudgmentcore() { return judgmentcore; }

    public void setJudgmentcore(Integer judgmentcore) { this.judgmentcore = judgmentcore; }

    public Date getExamdate() {
        return examdate;
    }

    public void setExamdate(Date examdate) {
        this.examdate = examdate;
    }

    public Date getExamtime() {
        return examtime;
    }

    public void setExamtime(Date examtime) {
        this.examtime = examtime;
    }

    public Integer getTesttime() {
        return testtime;
    }

    public void setTesttime(Integer testtime) {
        this.testtime = testtime;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse1() {
        return course1;
    }

    public void setCourse1(Course course1) {
        this.course1 = course1;
    }

    public void setSinglecore() {
    }
}
