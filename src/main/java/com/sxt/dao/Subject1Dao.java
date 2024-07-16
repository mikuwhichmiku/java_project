package com.sxt.dao;

import com.sxt.pojo.Subject1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Subject1Dao {
    //查询全部题
    List<Subject1> getAllSubject1();
    //添加题
    Integer addSubject1(Subject1 subject);
    //修改
    Integer updateTrueOrFalse(Subject1 subject);

    //id查询
    Subject1 getBySid1(Integer sid);

    //删除题-----id删除
    Integer delTrueOrFalse(Integer sid);

    //通过课程id查询题
    List<Subject1> getSubject1(Integer cno, Integer cno1);
}
