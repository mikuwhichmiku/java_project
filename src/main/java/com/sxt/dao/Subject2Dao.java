package com.sxt.dao;

import com.sxt.pojo.Subject2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Subject2Dao {//查询全部题
    List<Subject2> getAllSubject2();
    //添加题
    Integer addSubject2(Subject2 subject);
    //修改
    Integer updateMultiple(Subject2 subject);

    //id查询
    Subject2 getBySid2(Integer sid);

    //删除题-----id删除
    Integer delMultiple(Integer sid);

    //通过课程id查询题
    List<Subject2> getSubject2(Integer cno,Integer cno1);
}
