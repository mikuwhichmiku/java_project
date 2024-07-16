package com.sxt.dao;

import com.sxt.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * exams   com.sxt.dao
 * 2022-07-10  10:55
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/10  10:55
 */
@Mapper
public interface CourseDao {
    //通过id查询课程
    Course getAllById(Integer cno);
    //查询全部
    List<Course> getAllCourse();
}
