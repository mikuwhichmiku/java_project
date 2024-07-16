package com.sxt.service;

import com.sxt.pojo.Subject1;

import java.util.List;

public interface Subject1Service {
    List<Subject1> getAllSubject1();

    Integer addTrueOrFalse(Subject1 subject);
    Integer updateTrueOrFalse(Subject1 subject);

    Subject1 geiBySid1(Integer sid);

    Integer delTrueOrFalse(Integer sid);

    List<Subject1> getSubject1(Integer cno, Integer cno1);
}
