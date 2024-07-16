package com.sxt.service.impl;

import com.sxt.dao.PClassDao;
import com.sxt.pojo.PClass;
import com.sxt.service.PClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * exams   com.sxt.service.impl
 * 2022-06-26  11:34
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/6/26  11:34
 */
@Service
public class PClassServiceIpml implements PClassService {
    @Autowired
    PClassDao pClassDao;
    @Override
    public List<PClass> getAllPClass() {
        return pClassDao.getAllClass();
    }

    @Override
    public PClass getClassid(Integer classid) {
        return pClassDao.GetClassId(classid);
    }
}
