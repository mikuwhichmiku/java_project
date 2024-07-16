package com.sxt.service;

import com.sxt.pojo.Exam;

import java.util.List;

/**
 * exams   com.sxt.service
 * 2022-07-17  10:23
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/17  10:23
 */
public interface ExamService {
    Integer addExam(Exam exam);

    List<Exam> getAllExam();
    Exam getExam(Integer eid);

    Integer updExam(Exam exam);

    Integer delExam(Integer eid);

    List<Exam> getExamClassid(Integer classid);
}
