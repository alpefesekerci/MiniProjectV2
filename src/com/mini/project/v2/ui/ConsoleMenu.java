package com.mini.project.v2.ui;

import com.mini.project.v2.model.Student;
import com.mini.project.v2.service.StudentManager;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ConsoleMenu {
    private Scanner scanner = new Scanner(System.in);
    private StudentManager studentManager = new StudentManager();

    public void startMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== ÖĞRENCİ YÖNETİM SİSTEMİ ===");
            System.out.println("1");
            System.out.println("2");
            System.out.println("3");
            System.out.println("4");
            System.out.println("5");
            System.out.println("0");
            System.out.println("Yapmak istediğiniz işlemi seçiniz: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Eklenecek Öğrencinin Okul Numarası: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Öğrencinin Adı: ");
                        String name = scanner.nextLine();

                        System.out.println("Öğrencinin Soyadı: ");
                        String surname = scanner.nextLine();

                        System.out.println("Öğrencinin Notu: ");
                        double grade = scanner.nextDouble();
                        scanner.nextLine();

                        studentManager.addStudent(new Student(id, name, surname, grade));
                        break;

                    case 2:
                        System.out.println("Silmek İstediğiniz Öğrencinin ID'si: ");
                        int removeId = scanner.nextInt();
                        scanner.nextLine();
                        studentManager.removeStudent(removeId);
                        break;

                    case 3:
                        System.out.println("Güncellenecek Öğrencinin ID'si: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Yeni Ad: ");
                        String newName = scanner.nextLine();
                        System.out.println("Yeni Soyad: ");
                        String newSurname = scanner.nextLine();
                        System.out.println("Yeni Not: ");
                        double newGrade = scanner.nextDouble();
                        scanner.nextLine();
                        studentManager.updateStudent(updateId, newName, newSurname, newGrade);
                        break;

                    case 4:
                        studentManager.listStudents();
                        break;

                    case 5:
                        studentManager.calculateAverage();
                        break;

                    case 0:
                        System.out.println("Sistemden Çıkılıyor...");
                        running = false;
                        break;

                    default:
                        System.out.println("Hatalı Giriş! Lütfen tekrar deneyin.");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("KRİTİK HATA: Lütfen harf değil, sadece geçerli bir rakam giriniz!");
                scanner.nextLine();
            }catch (Exception e){
                System.out.println("Beklenmeyen bir hata oluştu: " + e.getMessage());
            }
        }
    }
}

