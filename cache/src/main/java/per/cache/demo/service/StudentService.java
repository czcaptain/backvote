package per.cache.demo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Service;
import per.cache.demo.pojo.Student;

import java.util.List;

@Service
@Slf4j
//@CacheConfig(cacheNames = "student")
public class StudentService {



    private final JdbcTemplate jdbcTemplate;

    public StudentService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


//    @Cacheable("student")
//    public Student getStudentById(Integer id) {
//        String sql = "select *  from student where id = ?" ;
//        return jdbcTemplate.queryForObject(sql,new Object[]{id},(rs,rownum) -> new Student(rs.getInt("id"),rs.getString("name"),rs.getString("age")));
//    }

    // 只要应用程序符合“经常读取但很少写入数据”的模式  惰性缓存
    @Cacheable("students")
    public List<Student> getAllStudent() {
        log.info("invoke getAllStudent method");
        String sql = "select *  from student";
        return jdbcTemplate.query(sql,(rs,rownum) -> new Student(rs.getInt("id"),rs.getString("name"),rs.getString("age")));
    }



    @CacheEvict("students")
    public void insertStudent(Student student) {
        String sql = "delete  from student where id = ?";
        jdbcTemplate.update(sql,(ps) -> {
            ps.setString(1,student.getName());
            ps.setString(2,student.getAge());
        });
    }



    @CacheEvict(value = "students",allEntries = true)
    public void deleteStudent(Integer id) {
        String sql = "delete  from student where id = ?";
        jdbcTemplate.update(sql,new Object[]{id});
    }

    @CacheEvict(value = "students",allEntries = true)
    public void updateStudentById(Integer id) {
        String sql = "update  student set name = 'updateName'  where id = ?";
        jdbcTemplate.update(sql,new Object[]{id});
    }
}
