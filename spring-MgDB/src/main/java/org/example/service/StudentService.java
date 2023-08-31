package org.example.service;

import org.example.dao.StudentMGDao;
import org.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    @Autowired
    private StudentMGDao studentMGDao;



    public void insert() {
        studentMGDao.save(new Student("1","Bob", Student.Type.HIGH));
        studentMGDao.save(new Student("2","Duo", Student.Type.MIDDLE));
    }



    public Student queryStudent() {

        for (Student student : studentMGDao.findAll()) {
            System.out.println(student);
        }

        return null;
    }



}
