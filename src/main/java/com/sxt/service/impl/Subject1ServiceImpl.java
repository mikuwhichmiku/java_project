package com.sxt.service.impl;
import com.sxt.dao.Subject1Dao;
import com.sxt.pojo.Subject1;
import com.sxt.service.Subject1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Subject1ServiceImpl implements Subject1Service {
    @Autowired
    Subject1Dao subject1Dao;
    @Override
    public List<Subject1> getAllSubject1() {
        return subject1Dao.getAllSubject1();
    }

    @Override
    public Integer addTrueOrFalse(Subject1 subject) {
        return subject1Dao.addSubject1(subject);
    }

    @Override
    public Integer updateTrueOrFalse(Subject1 subject) {
        return subject1Dao.updateTrueOrFalse(subject);
    }

    @Override
    public Subject1 geiBySid1(Integer sid) {
        return subject1Dao.getBySid1(sid);
    }

    @Override
    public Integer delTrueOrFalse(Integer sid) {
        return subject1Dao.delTrueOrFalse(sid);
    }

    @Override
    public List<Subject1> getSubject1(Integer cno,Integer cno1) {
        return subject1Dao.getSubject1(cno,cno1);
    }
}
