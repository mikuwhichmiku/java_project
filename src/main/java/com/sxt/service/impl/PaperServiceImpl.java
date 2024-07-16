package com.sxt.service.impl;

import com.sxt.dao.PaperDao;
import com.sxt.pojo.Paper;
import com.sxt.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * exams   com.sxt.service.impl
 * 2022-07-17  11:12
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/17  11:12
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    PaperDao paperDao;
    @Override
    public Integer addPaper(Paper paper) {
        return paperDao.addPaper(paper);
    }

    @Override
    public List<Paper> getByEid(Integer eid) {
        return paperDao.getByEid(eid);
    }
}
