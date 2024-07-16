package com.sxt.pojo;

/**
 * exams   com.sxt.pojo
 * 2022-06-19  10:56
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/6/19  10:56
 */
public class Users {
    private Integer userid;
    private String username;
    private String usermail;
    private String usertel;
    private String userpwd;
    private String truename;
    private Integer classid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsertel() {return usertel;}

    public void setUsertel(String usertel) {this.usertel = usertel;}

    public String getUsermail() {return usermail;}

    public void setUsermail(String usermail) {this.usermail = usermail;}

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }
}
