package per.cache.demo.controller;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.cache.demo.pojo.Student;
import per.cache.demo.service.StudentService;

import java.util.List;

@RestController
@RequestMapping(value = "/cache")
public class UserController {

    private final StudentService studentService;


    public UserController(StudentService userService) {
        this.studentService = userService;
    }





    @GetMapping("/count")
    public Integer getStudentCount() {
       return studentService.getAllStudent().size();
    }


    @GetMapping("/products")
    public List<Student> getAllStudent() {
        return  studentService.getAllStudent();

    }



    @GetMapping("update/{id}")
    public void deleteStudent(@PathVariable Integer id) {
         studentService.updateStudentById(id);
    }



}
