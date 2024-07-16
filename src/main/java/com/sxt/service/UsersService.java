package com.sxt.service;

import com.sxt.pojo.Users;

import java.util.List;

/**
 * exams   com.sxt.service
 * 2022-06-19  11:17
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/6/19  11:17
 */
public interface UsersService {
    Users login(String username, String userpwd);

    Integer addUsers(Users users);

    Users getByName(String username);

    List<Users> pageByClassid(Integer classid);

    Integer updateUsers(Users users);

    Users getByUserid(Integer userid);

    Integer delUserid(Integer userid);

    Integer delClassid(Integer classid);

    Integer updUserPwd(String userpwd,Integer userid);

    Integer updUserEmail(String usermail,Integer userid);

    Integer  updUserPhone(String usertel,Integer userid);

    Integer getByNameid(String username);

    String getTrueName(String username);

    Integer getByClass(String username);
}
