package com.sxt.controller;


import com.sxt.pojo.Course;
import com.sxt.pojo.Exam;
import com.sxt.pojo.Paper;
import com.sxt.pojo.Studentexam;
import com.sxt.service.CourseService;
import com.sxt.service.ExamService;
import com.sxt.service.PaperService;
import com.sxt.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * exams   com.sxt.controller
 * 2022-07-31  10:02
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/31  10:02
 */
@Controller
public class ExamController {
    @Autowired
    ExamService examService;
    @Autowired
    CourseService courseService;
    @Autowired
    PaperService paperService;
    @Autowired
    StudentExamService studentExamService;

    //查询考试信息
    @GetMapping("/examList")
    public String examList(HttpServletRequest request, Model model){
        Integer classid = (Integer) request.getSession().getAttribute("classid");
        List<Exam> examClassid = examService.getExamClassid(classid);
        for (Exam exam : examClassid) {
            Course allById = courseService.getAllById(exam.getCno());
            Course allById1 = courseService.getAllById(exam.getCno1());
            exam.setCourse(allById);
            exam.setCourse1(allById1);
        }
        model.addAttribute("examslenth",examClassid.size());
        model.addAttribute("exams",examClassid);
        //调试
        System.out.println("examClassid = " + examClassid);
        return "student/examList";
    }
    //查询数据
    @ResponseBody
    @PostMapping("/findExamByEid")
    public Exam findExamById(@RequestBody Exam exam){
        Exam exam1 = examService.getExam(exam.getEid());
        if (exam1!=null){
            return exam1;
        }else {
            return null;
        }
    }
    //查询试卷
    @GetMapping("/paper")
    public String findPaper(Integer eid, HttpServletRequest request, Model model){
        List<Paper> papers = paperService.getByEid(eid);
        List<Paper> singleChoiceQuestions = new ArrayList<>();
        List<Paper> multipleChoiceQuestions = new ArrayList<>();
        List<Paper> judgmentQuestions = new ArrayList<>();

        for (Paper paper : papers) {
            if (paper.getStype() == 1) {
                singleChoiceQuestions.add(paper);
            } else if (paper.getStype() == 2) {
                judgmentQuestions.add(paper);
            } else if (paper.getStype() == 3) {
                multipleChoiceQuestions.add(paper);
            }
        }

        Exam exam = examService.getExam(eid);
        request.getSession().setAttribute("single", singleChoiceQuestions);
        request.getSession().setAttribute("multiple", multipleChoiceQuestions);
        request.getSession().setAttribute("judgment", judgmentQuestions);

        model.addAttribute("cont", singleChoiceQuestions.size());
        model.addAttribute("cont1", multipleChoiceQuestions.size());
        model.addAttribute("cont2", judgmentQuestions.size());
        model.addAttribute("exam", exam);

        return "student/papers";
    }
    @PostMapping("/PaperScore")
    public String paperScore(HttpServletRequest request, Model model) {
        String[] stuArr = null;
        Integer score = 0;

        Integer eid = Integer.valueOf(request.getParameter("eid"));
        Exam exam = examService.getExam(eid);
        Integer singlecore = exam.getSinglecore();
        Integer judgmentcore = exam.getJudgmentcore();
        Integer multiplecore = exam.getMultiplecore();

        // 获取试卷问题列表并计算单选题成绩
        List<Paper> single = (List<Paper>) request.getSession().getAttribute("single");
        for (Paper paper : single) {
            stuArr = request.getParameterValues("single_" + paper.getSid());
            if (stuArr != null) {
                System.out.println("单选题学生答案: " + Arrays.toString(stuArr));
                String stuKeys = String.join("", stuArr);
                if (stuKeys.equalsIgnoreCase(paper.getSkey())) {
                    score += singlecore;
                }
            } else {
                return "redirect:/examList";
            }
        }

        // 获取试卷问题列表并计算多选题成绩
        List<Paper> multiple = (List<Paper>) request.getSession().getAttribute("multiple");
        for (Paper paper : multiple) {
            stuArr = request.getParameterValues("multiple_" + paper.getSid());
            if (stuArr != null) {
                Arrays.sort(stuArr);
                System.out.println("多选题学生答案: " + Arrays.toString(stuArr));
                String stuKeys = String.join("", stuArr);
                if (stuKeys.equalsIgnoreCase(paper.getSkey())) {
                    score += multiplecore;
                }
            } else {
                return "redirect:/examList";
            }
        }

        // 获取试卷问题列表并计算判断题成绩
        List<Paper> judgment = (List<Paper>) request.getSession().getAttribute("judgment");
        for (Paper paper : judgment) {
            stuArr = request.getParameterValues("judgment_" + paper.getSid());
            if (stuArr != null) {
                String stuKeys = String.join("", stuArr);
                System.out.println("判断题学生答案: " + Arrays.toString(stuArr));
                System.out.println("判断题标准答案: " + paper.getSkey());
                if (stuKeys.equalsIgnoreCase(paper.getSkey())) {
                    score += judgmentcore;
                }
            } else {
                return "redirect:/examList";
            }
        }

        // 计算总成绩
        int zscore = single.size() * singlecore + multiple.size() * multiplecore + judgment.size() * judgmentcore;

        // 学生成绩
        model.addAttribute("score", score);
        String pname = request.getParameter("pname");
        String tjtime = request.getParameter("tjtime");
        Integer classid = (Integer) request.getSession().getAttribute("classid");
        Integer userid = (Integer) request.getSession().getAttribute("lis");

        Studentexam studentexam = new Studentexam();
        studentexam.setEid(eid);
        studentexam.setPname(pname);
        studentexam.setScore(score);
        studentexam.setClassid(classid);
        studentexam.setUserid(userid);
        studentexam.setTitime(tjtime);
        studentexam.setZscore(zscore);
        studentExamService.addStudentExam(studentexam);

        return "student/paperScore";
    }




    //查询学生成绩
    @GetMapping("/findAllStuPaper")
    public String findStuPaperList(HttpServletRequest request,Model model){
        Integer userid = (Integer) request.getSession().getAttribute("lis");
        List<Studentexam> studentexams = studentExamService.getstuExamList(userid);
        model.addAttribute("stuexamlist",studentexams);
        return "student/stuPaperList";
    }
    //是否做过该试卷
    @ResponseBody
    @PostMapping("/findOneStuExam")
    public List<Studentexam> findIsPaper(HttpServletRequest request,@RequestBody Exam exam){
        //学生id
        Integer userid = (Integer) request.getSession().getAttribute("lis");
        //考试信息id
        Integer eid = exam.getEid();
        List<Studentexam> isPaper = studentExamService.getIsPaper(userid, eid);
        return isPaper;
    }
    //解决点击在线考试报错
    @GetMapping("/StuMan")
    public String getStuMan(){
        return "student/StuMan";
    }


}
