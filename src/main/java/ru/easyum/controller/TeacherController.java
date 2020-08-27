package ru.easyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.easyum.MyUserPrincipal;
import ru.easyum.domain.Course;
import ru.easyum.domain.Teacher;
import ru.easyum.repository.TeacherRepository;
import ru.easyum.service.TeacherService;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherService service;
    @Autowired
    TeacherRepository repository;

    @GetMapping(path = "/teachers")
    public String allteacher(@RequestParam(defaultValue = "0")Integer pageNo, @RequestParam(defaultValue = "5")Integer pageSize, Model model)
    {
        Long total = repository.count();
        List<Teacher> teachers = service.getPage(pageNo,pageSize);
        model.addAttribute("teachers", teachers);
        int size = (int) Math.ceil((double) total / 5);
       // MyUserPrincipal principal=(MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      //  model.addAttribute("user",principal.getUsername());
        model.addAttribute("pages", new Integer[size]);
        return "teachers";
    }
    @GetMapping(path = "/teacher/add")
    public String addTeacher(Model model){return "teacherAdd";}

    @Secured("ROLE_ADMIN")
    @PostMapping("/teacher/save")
    public String saveCourse(@RequestParam String fio, @RequestParam String about) {
        service.saveTeacher(new Teacher(fio,about));
        return "redirect:/teachers";
    }
}
