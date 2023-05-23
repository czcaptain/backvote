package com.example.function;

import com.example.entity.Student;

import java.util.Arrays;
import java.util.List;

/**
 * 行为参数化
 */

public class FunctionDemo {

    private static List<Student> studentList;

    static {
        Student duo = new Student("duo", "22", "1");
        Student bob = new Student("bob", "22", "2");
        Student ab = new Student("ab", "22", "3");
        Student cop = new Student("cop", "22", "4");
        studentList = Arrays.asList(duo, bob, ab, cop);
    }
    /**
     *
     */
    public static void main(String[] args) {
        //String name = "duo";
        Student student = queryByName("duo");
        Student duo1 = query(new StudentPredicateName());
        Student query = query(new StudentPredicate() {
            @Override
            public boolean test(Student t) {
                return "duo".equals(t.getName());
            }
        });
        Student duo = query((Student s) -> "duo".equals(s.getName()));
        Student cap = query((Student s) -> "cop".equals(s.getName()));
    }

    /**
     * 按名字查询
     * @param name
     * @return
     */
    public static Student  queryByName(String name) {
        for (Student student : studentList) {
            if(name.equals(student.getName())) {
                return student;
            }
        }
        return null;
    }

    /**
     * 按id查询
     * @param id
     * @return
     */
    public Student queryById(String id) {
        for(Student student : studentList) {
            if(id.equals(student.getId())) {
                return student;
            }
        }
        return null;
    }

    public static Student query(StudentPredicate studentPredicate) {
        for(Student student : studentList) {
            if (studentPredicate.test(student)) {
                return student;
            }
        }
        return null;
    }
}


interface StudentPredicate {


   boolean test(Student t);
}

class StudentPredicateName implements StudentPredicate{

    @Override
    public boolean test(Student t) {
        return "duo".equals(t.getName());
    }
}

class StudentPredocateId implements StudentPredicate {

    @Override
    public boolean test(Student t) {
        return "1".equals(t.getId());
    }
}








