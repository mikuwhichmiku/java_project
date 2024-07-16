package com.sxt.service.impl;

import com.sxt.dao.Subject2Dao;
import com.sxt.pojo.Subject2;
import com.sxt.service.Subject2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * exams   com.sxt.service.impl
 * 2022-07-10  10:39
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/10  10:39
 */
@Service
public class Subject2SerivceImpl implements Subject2Service {
    @Autowired
    Subject2Dao subject2Dao;
    @Override
    public List<Subject2> getAllSubject2() {
        return subject2Dao.getAllSubject2();
    }

    @Override
    public Integer addMultiple(Subject2 subject) {
        return subject2Dao.addSubject2(subject);
    }

    @Override
    public Integer updateMultiple(Subject2 subject) {
        return subject2Dao.updateMultiple(subject);
    }

    @Override
    public Subject2 geiBySid2(Integer sid) {
        return subject2Dao.getBySid2(sid);
    }

    @Override
    public Integer delMultiple(Integer sid) {
        return subject2Dao.delMultiple(sid);
    }

    @Override
    public List<Subject2> getSubject2(Integer cno,Integer cno1) {
        return subject2Dao.getSubject2(cno,cno1);
    }


}
