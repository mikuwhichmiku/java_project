package com.sxt.dao;

import com.sxt.pojo.Studentexam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * exams   com.sxt.dao
 * 2022-07-31  16:16
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/31  16:16
 */
@Mapper
public interface StudentExamDao {
    Integer addStudentExam(Studentexam studentexam);

    //查询学生成绩
    List<Studentexam> getStuPaperList(Integer userid);

    //查询是否做过该试卷
    List<Studentexam> getIsPaper(Integer userid,Integer eid);

    //教师查询试卷信息
    List<Studentexam> getAllStuScore(Integer classid);
    //清空考试信息
    Integer deleteByUser(Integer userid);
    //删除考试信息相关联的内容
    Integer deleteEid(Integer eid);
}
