package com.sxt.dao;

import com.sxt.pojo.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * exams   com.sxt.dao
 * 2022-07-17  10:16
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/17  10:16
 */
@Mapper
public interface ExamDao {
    Integer addExam(Exam exam);

    //查询所有考试信息
    List<Exam> getAllExam();
    //根据id查询
    Exam getExam(Integer eid);

    //修改考试
    Integer updExam(Exam exam);
    //删除考试
    Integer delExam(Integer eid);
    //通过班级id查询考试信息
    List<Exam> getExamClassid(Integer classid);
}
