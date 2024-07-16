package com.sxt.service;

import com.sxt.pojo.Course;

import java.util.List;

/**
 * exams   com.sxt.service
 * 2022-07-10  10:58
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/10  10:58
 */
public interface CourseService {
    Course getAllById(Integer cno);
    List<Course> getAllCourse();
}
