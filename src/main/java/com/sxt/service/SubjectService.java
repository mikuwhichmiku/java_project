package com.sxt.service;

import com.sxt.pojo.Subject;

import java.util.List;

/**
 * exams   com.sxt.service
 * 2022-07-10  10:38
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/10  10:38
 */
public interface SubjectService {
    List<Subject> getAllSubject();

    Integer addSingle(Subject subject);
    Integer updateSingle(Subject subject);

    Subject geiBySid(Integer sid);

    Integer delSingle(Integer sid);

    List<Subject> getSubject(Integer cno, Integer cno1);

}
