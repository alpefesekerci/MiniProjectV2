package com.mini.project.v2.service;

import com.mini.project.v2.model.Student;
import com.mini.project.v2.exception.StudentAlreadyExistsException;
import com.mini.project.v2.exception.StudentNotFoundException;
import com.mini.project.v2.repository.StudentRepository;
import java.util.List;

public class StudentManager {

    private final StudentRepository repository = new StudentRepository();

    public void addStudent(int id, String name, String surname, double grade) {
        if (repository.existsById(id)) {
            throw new StudentAlreadyExistsException("Servis Hatası: " + id + " ID'li öğrenci zaten sisteme kayıtlı!");
        }
        Student newStudent = new Student(id, name, surname, grade);
        repository.save(newStudent);
    }

    public void removeStudent(int id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException("Hata: Silinmek istenen " + id + " ID'li öğrenci bulunamadı.");
        }

        repository.deleteById(id);
    }

    public Student updateStudent(int id, String newName, String newSurname, double newGrade) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException("Hata: Güncellenecek " + id + " ID'li öğrenci bulunamadı.");
        }

        for (Student student : repository.findAll()) {
            if (student.getId() == id) {
                student.setName(newName);
                student.setSurname(newSurname);
                student.setGrade(newGrade);
                return student;
            }
        }
        throw new StudentNotFoundException("Hata: Beklenmeyen bir durum oluştu, öğrenci güncellenemedi.");
    }

    public double calculateAverage() {
        List<Student> students = repository.findAll();

        if (students.isEmpty()) {
        throw new IllegalStateException("Listede öğrenci olmadığı için ortalama hesaplanamaz.");
        }

        double total = 0;
        for (Student student : students) {
            total += student.getGrade();
        }
        return total / students.size();
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }
}