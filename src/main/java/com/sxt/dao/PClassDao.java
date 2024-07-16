package com.sxt.dao;

import com.sxt.pojo.PClass;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.ManagedBean;
import java.util.List;

/**
 * exams   com.sxt.dao
 * 2022-06-26  10:58
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/6/26  10:58
 */
@Mapper
public interface PClassDao {
    //查询班级列表
    List<PClass> getAllClass();
    //查询班级id
    PClass GetClassId(Integer classid);
}
