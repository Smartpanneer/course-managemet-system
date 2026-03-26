package com.Couse_man.model;

import java.sql.*;
import java.util.Scanner;
import com.Couse_man.util.DBconnection;

public class Course {

    static Scanner sc = new Scanner(System.in);

    public static void insertCourse() {
        try {
            System.out.print("Course ID: ");
            int id = sc.nextInt();

            sc.nextLine();
            System.out.print("Course Name: ");
            String name = sc.nextLine();

            System.out.print("Dept ID: ");
            int dept = sc.nextInt();

            Connection con = DBconnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement("INSERT INTO Course (course_id, course_name, dept_id) VALUES (?, ?, ?)");

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, dept);

            ps.executeUpdate();

            System.out.println("✅ Course Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewCourses() {
        try {
            Connection con = DBconnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement("SELECT * FROM Course");

            ResultSet rs = ps.executeQuery();

            System.out.println("\nID\tNAME\tDEPT");

            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + "\t" +
                    rs.getString(2) + "\t" +
                    rs.getInt(3)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateCourse() {
        try {
            System.out.print("Course ID: ");
            int id = sc.nextInt();

            sc.nextLine();
            System.out.print("New Name: ");
            String name = sc.nextLine();

            Connection con = DBconnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement("UPDATE Course SET course_name=? WHERE course_id=?");

            ps.setString(1, name);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("✅ Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}