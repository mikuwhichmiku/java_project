package com.sxt.service;

import com.sxt.pojo.TeaUser;

/**
 * exams   com.sxt.service
 * 2022-06-26  16:34
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/6/26  16:34
 */
public interface TeaUserService {
    TeaUser teaLogin(String username,String userpwd);

    String getTeaTruename(String username);

    Integer getClassId(String username);

    Integer getUserid(String username);
}
