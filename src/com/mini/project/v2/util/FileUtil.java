package com.mini.project.v2.util;

import com.mini.project.v2.model.Student;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class FileUtil {
    private static final String FILE_NAME = "students.txt";

    public static List<Student> readStudentsFromFile() {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return students;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String surname = data[2];
                    double grade = Double.parseDouble(data[3]);
                    students.add(new Student(id, name, surname, grade));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Dosya okunurken hata oluştu: " + e.getMessage());
        }
        return students;
    }

    public static void writeStudentsToFile(List<Student> students) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                bw.write(student.getId() + "," + student.getName() + "," + student.getSurname() + "," + student.getGrade());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Dosyaya yazılırken hata oluştu: " + e.getMessage());
        }
    }
}
