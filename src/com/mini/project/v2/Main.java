package com.mini.project.v2;

import com.mini.project.v2.repository.StudentRepository;
import com.mini.project.v2.service.StudentManager;
import com.mini.project.v2.ui.ConsoleMenu;

public class Main {
    public static void main(String[] args) {

        StudentRepository repository = new StudentRepository();

        StudentManager manager = new StudentManager(repository);

        ConsoleMenu consoleMenu = new ConsoleMenu(manager);

        consoleMenu.startMenu();
    }
}
