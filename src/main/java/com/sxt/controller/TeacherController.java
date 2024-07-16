package com.sxt.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sxt.pojo.*;
import com.sxt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;

import javax.jws.soap.SOAPBinding;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * exams   com.sxt.controller
 * 2022-07-03  09:43
 *
 * @author sxt  Administrator
 * description : 不可描述
 * @date 2022/7/3  9:43
 */
@Controller
public class TeacherController {
    @Autowired
    PClassService pClassService;
    @Autowired
    UsersService usersService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    Subject1Service subject1Service;
    @Autowired
    Subject2Service subject2Service;
    @Autowired
    CourseService courseService;
    @Autowired
    ExamService examService;
    @Autowired
    PaperService paperService;
    @Autowired
    StudentExamService studentExamService;
    private HandshakeCompletedEvent request;
    private Model model;


    //查询学生列表
    @GetMapping("/StudentList")
    public String findStuUsers(HttpServletRequest request, Model model, @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum){
        //获取班级id
        Integer teaClassid = (Integer) request.getSession().getAttribute("TeaClassid");
        //查看教师所在班级
        PClass classid = pClassService.getClassid(teaClassid);
        model.addAttribute("pj",classid);

        //设置分页
        PageHelper.startPage(pageNum,5);
        //查询学生列表
        List<Users> users = usersService.pageByClassid(teaClassid);
        PageInfo<Users> usersPageInfo = new PageInfo<>(users);
        model.addAttribute("pageInfo",usersPageInfo);
        model.addAttribute("liss",users);

        //获取所有班级信息
        List<PClass> allPClass = pClassService.getAllPClass();
        model.addAttribute("list",allPClass);

        return "teacher/StudentList";
    }
    //添加学生
    @PostMapping("/addStu")
    public  String addStuUsers(String username,String userpwd,String truename, Integer classid,String email,String phone ){
       //查询学生是否存在
        Users byName = usersService.getByName(username);
        Users users = new Users();
        if(byName==null){
            users.setUsername(username);
            users.setUserpwd(userpwd);
            users.setTruename(truename);
            users.setClassid(classid);
            users.setUsermail(email);
            users.setUsertel(phone);
            usersService.addUsers(users);
        }else {
            System.out.println("该学生已存在");
        }

        return "redirect:/StudentList";
    }
//查询所有班级
    @ResponseBody
    @PostMapping("/findAllClass")
    public List<PClass> pClassList(){
        List<PClass> allPClass = pClassService.getAllPClass();
        return allPClass;
    }
//获取用户信息
    @ResponseBody
    @PostMapping("/StuEdit")
    public  Users stuEdit(@RequestBody Users users){
        Users byUserid = usersService.getByUserid(users.getUserid());
        if (byUserid!=null){
            return byUserid;
        }else {
            return null;
        }
    }

    //修改学生
    @PostMapping("/updateStu")
    public String updStuUser(Users users){
        usersService.updateUsers(users);
        return "redirect:/StudentList";
    }
    //删除单个学生
    @GetMapping("/DeleteStu")
    public String deleteUsers(HttpServletRequest request){
        Integer userid = Integer.valueOf(request.getParameter("userid"));
        usersService.delUserid(userid);
        return "redirect:/StudentList";
    }
    //删除教师所在班级的全部学生
    @GetMapping("/deleteAll")
    public String deleteUsersAll(HttpServletRequest request){
        Integer teaClassid = (Integer) request.getSession().getAttribute("TeaClassid");
        usersService.delClassid(teaClassid);
        return "redirect:/StudentList";
    }

    //查询题目
    @GetMapping("/finddanxuan")
    public String findSingle(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,Model model){
        PageHelper.startPage(pageNum,5);
        List<Subject> allSubject = subjectService.getAllSubject();
        for (Subject subject:allSubject){
            Course allById = courseService.getAllById(subject.getCno());
            subject.setCourse(allById);
        }
        PageInfo<Subject> subjectPageInfo = new PageInfo<>(allSubject);
        model.addAttribute("pageInfo",subjectPageInfo);
        model.addAttribute("subjectlist",allSubject);
        return "teacher/Single";
    }

    @GetMapping("/findpanduan")
    public String findTrueOrFalse(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,Model model){
        PageHelper.startPage(pageNum,5);
        List<Subject1> allSubject = subject1Service.getAllSubject1();
        for (Subject1 subject:allSubject){
            Course allById = courseService.getAllById(subject.getCno());
            subject.setCourse(allById);
        }
        PageInfo<Subject1> subjectPageInfo = new PageInfo<>(allSubject);
        model.addAttribute("pageInfo",subjectPageInfo);
        model.addAttribute("subjectlist",allSubject);
        return "teacher/TrueOrFalse";
    }

    @GetMapping("/findduoxuan")
    public String findMultiple(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,Model model){
        PageHelper.startPage(pageNum,5);
        List<Subject2> allSubject = subject2Service.getAllSubject2();
        for (Subject2 subject:allSubject){
            Course allById = courseService.getAllById(subject.getCno());
            subject.setCourse(allById);
        }
        PageInfo<Subject2> subjectPageInfo = new PageInfo<>(allSubject);
        model.addAttribute("pageInfo",subjectPageInfo);
        model.addAttribute("subjectlist",allSubject);
        return "teacher/Multiple";
    }
    //获取所有课程
    @ResponseBody
    @GetMapping("/findAllCourse")
    public List<Course> courseList(){
        List<Course> allCourse = courseService.getAllCourse();
        return allCourse;
    }
    //添加题
    @PostMapping("/addSingle")
    public String addSingle(Integer cno,String scontent,String sa,String sb,String sc,String sd,String skey){

        Subject subject = new Subject();
        subject.setCno(cno);
        subject.setScontent(scontent);
        subject.setSa(sa);
        subject.setSb(sb);
        subject.setSc(sc);
        subject.setSd(sd);
        subject.setSkey(skey);
        subjectService.addSingle(subject);
        return "redirect:/finddanxuan";
    }

    @PostMapping("/addTrueOrFalse")
    public String addTrueOrFalse(Integer cno,String scontent,String strue,String sfalse,String skey){

        Subject1 subject = new Subject1();
        subject.setCno(cno);
        subject.setScontent(scontent);
        subject.setStrue(strue);
        subject.setSfalse(sfalse);
        subject.setSkey(skey);
        subject1Service.addTrueOrFalse(subject);
        return "redirect:/findpanduan";
    }

    @PostMapping("/addMultiple")
    public String addMultiple(Integer cno,String scontent,String sa,String sb,String sc,String sd,String skey){

        Subject2 subject = new Subject2();
        subject.setCno(cno);
        subject.setScontent(scontent);
        subject.setSa(sa);
        subject.setSb(sb);
        subject.setSc(sc);
        subject.setSd(sd);
        subject.setSkey(skey);
        subject2Service.addMultiple(subject);
        return "redirect:/findduoxuan";
    }
    //获取题数据
    @ResponseBody
    @PostMapping("/findBySid")
    public Subject findBySid(@RequestBody Subject subject){
        Subject subject10 = subjectService.geiBySid(subject.getSid());
        if (subject10!=null){
            return subject10;
        }else {
            return null;
        }
    }

    @ResponseBody
    @PostMapping("/findBySid1")
    public Subject1 findBySid1(@RequestBody Subject1 subject){
        Subject1 subject10 = subject1Service.geiBySid1(subject.getSid());
        if (subject10!=null){
            return subject10;
        }else {
            return null;
        }
    }

    @ResponseBody
    @PostMapping("/findBySid2")
    public Subject2 findBySid2(@RequestBody Subject1 subject){
        Subject2 subject10 = subject2Service.geiBySid2(subject.getSid());
        if (subject10!=null){
            return subject10;
        }else {
            return null;
        }
    }
    //修改题
    @PostMapping("/updateSingle")
    public String updSingle(Subject subject){
        subjectService.updateSingle(subject);
        return "redirect:/finddanxuan";
    }

    @PostMapping("/updateTrueOrFalse")
    public String updTrueOrFalse(Subject1 subject){
        subject1Service.updateTrueOrFalse(subject);
        return "redirect:/findpanduan";
    }

    @PostMapping("/updateMultiple")
    public String updMultiple(Subject2 subject){
        subject2Service.updateMultiple(subject);
        return "redirect:/findduoxuan";
    }
    //删除题
    @PostMapping("/deleteSingle")
    public String delSingle(@RequestParam Integer sid){
        subjectService.delSingle(sid);
        return "redirect:/finddanxuan";
    }

    @PostMapping("/deleteTrueOrFalse")
    public String delTrueOrFalse(@RequestParam Integer sid){
        subject1Service.delTrueOrFalse(sid);
        return "redirect:/findpanduan";
    }

    @PostMapping("/deleteMultiple")
    public String delMultiple(@RequestParam Integer sid){
        subject2Service.delMultiple(sid);
        return "redirect:/findduoxuan";
    }

    //查询考试信息
    @GetMapping("/selectexam")
    public String selectExam(@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,Model model){
        PageHelper.startPage(pageNum,5);
        List<Exam> allExam = examService.getAllExam();
        PageInfo<Exam> examPageInfo = new PageInfo<>(allExam);
        model.addAttribute("examlist",allExam);
        model.addAttribute("pageInfo",examPageInfo);
        return "teacher/SelectExam";
    }
    //查询考试信息
    @GetMapping("/selectexames")
    public String selectExames(@RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,Model model){
        PageHelper.startPage(pageNum,5);
        List<Exam> allExam = examService.getAllExam();
        PageInfo<Exam> examPageInfo = new PageInfo<>(allExam);
        model.addAttribute("examlist",allExam);
        model.addAttribute("pageInfo",examPageInfo);
        return "student/StuMan";
    }
    //跳转到添加考试页面
    @GetMapping("/addexam")
    public String toAddExam(){return "student/addexam";}

    //创建考试
    @PostMapping("/addexames")
    public String addExam(String pname, Integer userid, Integer cno,Integer cno1,
                          Integer classid, Integer singlenumber, Integer singlecore, Integer multiplenumber,
                          Integer multiplecore, Integer judgmentnumber, Integer judgmentcore, Date examdate,
                          Date examtime,Integer testtime){

        //生成考试信息
        Exam exam=new Exam();
        exam.setPname(pname);
        exam.setUserid(userid);
        exam.setCno(cno);
        exam.setCno1(cno1);
        exam.setClassid(classid);
        exam.setSinglenumber(singlenumber);
        exam.setSinglecore(singlecore);
        exam.setMultiplenumber(multiplenumber);
        exam.setMultiplecore(multiplecore);
        exam.setJudgmentnumber(judgmentnumber);//改过
        exam.setJudgmentcore(judgmentcore);
        exam.setExamdate(examdate);
        exam.setExamtime(examtime);
        exam.setTesttime(testtime);
        examService.addExam(exam);



        //通过课程查询

        //第一课
        List<Subject> subject = subjectService.getSubject(cno,cno1);
        List<Subject1> subject_1 = subject1Service.getSubject1(cno,cno1);
        List<Subject2> subject_2 = subject2Service.getSubject2(cno,cno1);

        //题的随机生成
        //判题还没改
        //单选
        ArrayList<Subject> subjects = new ArrayList<>();
        Random random = new Random();
        if (singlenumber>0){
            for (int i=1;i<=singlenumber;i++){
                int s = random.nextInt(subject.size());

                Subject subject1 = subject.get(s);


                if (i==subject.size()){
                    break;
                }else {
                    if (subjects.contains(subject1)){
                        i--;
                    }else {
                        subjects.add(subject.get(s));
                        Paper paper = new Paper();
                        paper.setEid(exam.getEid());
                        paper.setCno(subject1.getCno());
                        paper.setSid(subject1.getSid());
                        paper.setScontent(subject1.getScontent());
                        paper.setSa(subject1.getSa());
                        paper.setSb(subject1.getSb());
                        paper.setSc(subject1.getSc());
                        paper.setSd(subject1.getSd());
                        paper.setSkey(subject1.getSkey());
                        paper.setStype(1);
                        paperService.addPaper(paper);
                    }
                }
            }
        }

        //判断
        ArrayList<Subject1> subjects1 = new ArrayList<>();
        Random random1 = new Random();
        if (judgmentnumber>0){
            for (int i=1;i<=judgmentnumber;i++){
                int s = random1.nextInt(subject_1.size());

                Subject1 subject1 = subject_1.get(s);


                if (i==subject_1.size()){
                    break;
                }else {
                    if (subjects1.contains(subject1)){
                        i--;
                    }else {
                        subjects1.add(subject_1.get(s));
                        Paper paper = new Paper();
                        paper.setEid(exam.getEid());
                        paper.setCno(subject1.getCno());
                        paper.setSid(subject1.getSid());
                        paper.setScontent(subject1.getScontent());
                        paper.setSa(subject1.getStrue());
                        paper.setSb(subject1.getSfalse());
                        paper.setSc(null);
                        paper.setSd(null);
                        paper.setSkey(subject1.getSkey());
                        paper.setStype(2);
                        paperService.addPaper(paper);
                    }
                }
            }
        }

        //多选
        ArrayList<Subject2> subjects2 = new ArrayList<>();
        Random random2 = new Random();
        if (multiplenumber>0){
            for (int i=1;i<=multiplenumber;i++){
                int s = random2.nextInt(subject_2.size());

                Subject2 subject1 = subject_2.get(s);


                if (i==subject_2.size()){
                    break;
                }else {
                    if (subjects2.contains(subject1)){
                        i--;
                    }else {
                        subjects2.add(subject_2.get(s));
                        Paper paper = new Paper();
                        paper.setEid(exam.getEid());
                        paper.setCno(subject1.getCno());
                        paper.setSid(subject1.getSid());
                        paper.setScontent(subject1.getScontent());
                        paper.setSa(subject1.getSa());
                        paper.setSb(subject1.getSb());
                        paper.setSc(subject1.getSc());
                        paper.setSd(subject1.getSd());
                        paper.setSkey(subject1.getSkey());
                        paper.setStype(3);
                        paperService.addPaper(paper);

                    }
                }
            }
        }


        return "redirect:/selectexames";
    }

//查询试卷信息
    @GetMapping("/paperDetails")
    public  String paperDetails(Integer eid,Model model){
        List<Paper> byEid = paperService.getByEid(eid);
        model.addAttribute("tm",byEid);
        Exam exam = examService.getExam(eid);
        model.addAttribute("exam",exam);
        return "teacher/paperDetails";
    }
    //查询一场考试
    @ResponseBody
    @PostMapping("/findByOneExam")
    public  Exam findByOneExam(@RequestBody Exam exam){
        Exam exam1 = examService.getExam(exam.getEid());
        if (exam1==null) {
            return null;
        }else {
            return exam1;
        }
    }
    //获取所有班级
    @ResponseBody
    @GetMapping("/findAllClasses")
    public List<PClass> findAllClasses(){
        List<PClass> allPClass = pClassService.getAllPClass();
        return allPClass;
    }
    //修改考试信息
    @PostMapping("/updateExam")
    public String updateExam(Exam exam){
        examService.updExam(exam);
        return "redirect:/selectexam";
    }
    //删除考试信息
    @GetMapping("/deleteExam")
    public String deleteExam(Integer eid){
        examService.delExam(eid);
        return "redirect:/selectexam";
    }

    //查询学生成绩
    @GetMapping("/findAllScore")
    public String findAllScore(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,HttpServletRequest request,Model model){
       PageHelper.startPage(pageNum,5);
        //获取教师班级id
        Integer teaClassid = (Integer) request.getSession().getAttribute("TeaClassid");
        PClass classes = pClassService.getClassid(teaClassid);
        model.addAttribute("cs",classes);
        List<Studentexam> allStuScore = studentExamService.getAllStuScore(teaClassid);
        for (Studentexam studentexam : allStuScore) {
            Users byUserid = usersService.getByUserid(studentexam.getUserid());
            studentexam.setUsers(byUserid);
        }
        PageInfo<Studentexam> studentexamPageInfo = new PageInfo<>(allStuScore);
        model.addAttribute("pageInfo",studentexamPageInfo);
        model.addAttribute("score",allStuScore);
        return "teacher/studentScore";
    }

}
