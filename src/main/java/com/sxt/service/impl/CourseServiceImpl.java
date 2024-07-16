package com.sxt.service.impl;

import com.sxt.dao.CourseDao;
import com.sxt.pojo.Course;
import com.sxt.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * exams   com.sxt.service.impl
 * 2022-07-10  10:59
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/10  10:59
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;
    @Override
    public Course getAllById(Integer cno) {
        return courseDao.getAllById(cno);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }
}
