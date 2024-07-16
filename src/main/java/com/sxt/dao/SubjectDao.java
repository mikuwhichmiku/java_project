package com.sxt.dao;

import com.sxt.pojo.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * exams   com.sxt.dao
 * 2022-07-10  10:35
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/10  10:35
 */
@Mapper
public interface SubjectDao {
    //查询全部题
    List<Subject> getAllSubject();
    //添加题
    Integer addSubject(Subject subject);
    //修改
    Integer updateSingle(Subject subject);

    //id查询
    Subject getBySid(Integer sid);

    //删除题-----id删除
    Integer delSingle(Integer sid);

    //通过课程id查询题
    List<Subject> getSubject(Integer cno, Integer cno1);
}
