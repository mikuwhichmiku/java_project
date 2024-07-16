package com.sxt.service;

import com.sxt.pojo.Paper;

import java.util.List;

/**
 * exams   com.sxt.service
 * 2022-07-17  11:12
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/17  11:12
 */
public interface PaperService {
    Integer addPaper(Paper paper);
    List<Paper> getByEid(Integer eid);
}
