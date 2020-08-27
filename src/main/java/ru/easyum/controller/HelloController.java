package ru.easyum.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController  {
    @GetMapping("/hello")
    public String helloWord(Model model){
        model.addAttribute("message","Hello from controller method!");
        return "/jsp/hello";
    }
}
/*
* @Controller
public class CourseController {

    @Autowired
    CourseService service;

    @RequestMapping(path = "/courses", method = RequestMethod.GET)
    public String allcourses(Model model){
        List<Course> courses = service.findAllCourses();
        model.addAttribute("courses",courses);
        return "/jsp/courses";
    }

    @RequestMapping(path = "/courses/{courseName}")
    public String getCourseTeachers(@PathVariable String courseName, Model model){
        List<Teacher> teachers = service.getTracherByCourseName(courseName);
        model.addAttribute("teachers",teachers);
        return "/jsp/teachers";
    }

    @RequestMapping(path = "/courses/add", method = RequestMethod.POST) /// не работает
    public void addCourse(@RequestBody Course course){
        service.saveCourse(course);
    }


    @RequestMapping(path = "/course/get")
    public String findCourse(@RequestParam("courseId") int courseId,Model model){
        Course course = service.findCourse(courseId);
        model.addAttribute("course",course);
        return "/jsp/course";
    }

    @GetMapping("/create")
    public String create() {
        return "/jsp/create";
    }

    @PostMapping("/course/save")
    public String save(@RequestParam String name, @RequestParam int duration) {
        Course course = service.saveCourse(new Course(name, duration));
        return "redirect:/course/get?courseId=" + course.getId();
    }

}*/
