package com.mini.project.v2.repository;

import com.mini.project.v2.model.Student;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class StudentRepository {
    private final List<Student> studentList = new ArrayList<>();

    public boolean existsById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void save(Student student) {
        studentList.add(student);
    }

    public List<Student> findAll() {
        return studentList;
    }

    public void deleteById(int id) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
                return;
            }
        }
    }

}
