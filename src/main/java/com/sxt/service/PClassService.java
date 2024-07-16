package com.sxt.service;

import com.sxt.pojo.PClass;

import java.util.List;

/**
 * exams   com.sxt.service
 * 2022-06-26  11:33
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/6/26  11:33
 */
public interface PClassService {
    List<PClass> getAllPClass();

    PClass getClassid(Integer classid);
}
