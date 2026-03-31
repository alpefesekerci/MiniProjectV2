package com.mini.project.v4;

import com.mini.project.v4.repository.StudentRepository;
import com.mini.project.v4.service.StudentManager;
import com.mini.project.v4.ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {

        StudentRepository repository = new StudentRepository();

        StudentManager manager = new StudentManager(repository);

        ConsoleMenu consoleMenu = new ConsoleMenu(manager);

        consoleMenu.startMenu();
    }
}
