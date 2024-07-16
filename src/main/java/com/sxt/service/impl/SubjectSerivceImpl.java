package com.sxt.service.impl;

import com.sxt.dao.SubjectDao;
import com.sxt.pojo.Subject;
import com.sxt.service.SubjectService;
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
public class SubjectSerivceImpl implements SubjectService {
    @Autowired
    SubjectDao subjectDao;
    @Override
    public List<Subject> getAllSubject() {
        return subjectDao.getAllSubject();
    }

    @Override
    public Integer addSingle(Subject subject) {
        return subjectDao.addSubject(subject);
    }

    @Override
    public Integer updateSingle(Subject subject) {
        return subjectDao.updateSingle(subject);
    }

    @Override
    public Subject geiBySid(Integer sid) {
        return subjectDao.getBySid(sid);
    }

    @Override
    public Integer delSingle(Integer sid) {
        return subjectDao.delSingle(sid);
    }

    @Override
    public List<Subject> getSubject(Integer cno, Integer cno1) {
        return subjectDao.getSubject(cno,cno1);
    }


}
