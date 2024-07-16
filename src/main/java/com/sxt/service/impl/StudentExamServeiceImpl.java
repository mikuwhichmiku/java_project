package com.sxt.service.impl;

import com.sxt.dao.StudentExamDao;
import com.sxt.pojo.Studentexam;
import com.sxt.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * exams   com.sxt.service.impl
 * 2022-07-31  16:23
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/31  16:23
 */
@Service
public class StudentExamServeiceImpl implements StudentExamService {
    @Autowired
    StudentExamDao studentExamDao;
    @Override
    public Integer addStudentExam(Studentexam studentexam) {
        return studentExamDao.addStudentExam(studentexam);
    }

    @Override
    public List<Studentexam> getstuExamList(Integer userid) {
        return studentExamDao.getStuPaperList(userid);
    }

    @Override
    public List<Studentexam> getIsPaper(Integer userid, Integer eid) {
        return studentExamDao.getIsPaper(userid,eid);
    }

    @Override
    public List<Studentexam> getAllStuScore(Integer classid) {
        return studentExamDao.getAllStuScore(classid);
    }
}
