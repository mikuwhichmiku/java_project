package com.sxt.dao;

import com.sxt.pojo.Paper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * exams   com.sxt.dao
 * 2022-07-17  11:07
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/17  11:07
 */
@Mapper
public interface PaperDao {
    Integer addPaper(Paper paper);
    //根据考试信息id查询试卷
    List<Paper> getByEid(Integer eid);
    //删除试卷信息----eid
    Integer deleteByEid(Integer eid);
}
