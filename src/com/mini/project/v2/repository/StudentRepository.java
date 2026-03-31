package com.mini.project.v2.repository;

import com.mini.project.v2.model.Student;
import com.mini.project.v2.util.FileUtil;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class StudentRepository {
    private final Map<Integer, Student> studentMap = new HashMap<>();

    public boolean existsById(int id) {
        return studentMap.containsKey(id);
    }

    public void save(Student student) {
        studentMap.put(student.getId(), student);
    }

    public Student findById(int id) {
        return studentMap.get(id);
    }

    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    public void deleteById(int id) {
        studentMap.remove(id);
    }

    public void loadData() {
        List<Student> loadedStudents = FileUtil.readStudentsFromFile();
        loadedStudents.forEach(student -> studentMap.put(student.getId(), student));
    }

    public void saveData() {
        FileUtil.writeStudentsToFile(new ArrayList<>(studentMap.values()));
    }
}



