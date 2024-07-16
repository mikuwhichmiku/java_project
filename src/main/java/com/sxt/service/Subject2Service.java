package com.sxt.service;

import com.sxt.pojo.Subject2;

import java.util.List;

public interface Subject2Service {
    List<Subject2> getAllSubject2();

    Integer addMultiple(Subject2 subject);
    Integer updateMultiple(Subject2 subject);

    Subject2 geiBySid2(Integer sid);

    Integer delMultiple(Integer sid);

    List<Subject2> getSubject2(Integer cno, Integer cno1);
}
