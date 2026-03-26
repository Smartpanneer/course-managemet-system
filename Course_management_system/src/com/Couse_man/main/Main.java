package com.Couse_man.main;

import java.util.Scanner;
import com.Couse_man.model.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== COURSE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Department");
            System.out.println("2. Add Course");
            System.out.println("3. Add Student");
            System.out.println("4. Enroll Student");
            System.out.println("5. View Departments");
            System.out.println("6. View Courses");
            System.out.println("7. View Students");
            System.out.println("8. Update Student");
            System.out.println("9. Update Course");
            System.out.println("10. Delete Department");
            System.out.println("11. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1: Department.insertDept(); break;
                case 2: Course.insertCourse(); break;
                case 3: Student.insertStudent(); break;
                case 4: Enrollment.enrollStudent(); break;
                case 5: Department.viewDept(); break;
                case 6: Course.viewCourses(); break;
                case 7: Student.viewStudents(); break;
                case 8: Student.updateStudent(); break;
                case 9: Course.updateCourse(); break;
                case 10: Department.deleteDept(); break;

                case 11:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid ❌");
            }

        } while (true);
    }
}