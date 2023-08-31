package org.example.dao;

import org.example.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentMGDao extends CrudRepository<Student,String> {


//    public Student findByFirstName(String firstName);
//    public List<Student> findByLastName(String lastName);
}



