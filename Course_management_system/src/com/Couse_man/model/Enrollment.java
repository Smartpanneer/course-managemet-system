package com.Couse_man.model;

import java.sql.*;
import java.util.Scanner;
import com.Couse_man.util.DBconnection;

public class Enrollment {

    static Scanner sc = new Scanner(System.in);

    public static void enrollStudent() {
        try {
            System.out.print("Enroll ID: ");
            int id = sc.nextInt();

            System.out.print("Student ID: ");
            int sid = sc.nextInt();

            System.out.print("Course ID: ");
            int cid = sc.nextInt();

            Connection con = DBconnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement("INSERT INTO Enrollment (enroll_id, s_id, course_id) VALUES (?, ?, ?)");

            ps.setInt(1, id);
            ps.setInt(2, sid);
            ps.setInt(3, cid);

            ps.executeUpdate();

            System.out.println("✅ Enrolled");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewEnrollments() {
        try {
            Connection con = DBconnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement("SELECT * FROM Enrollment");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getInt(2) + " " +
                    rs.getInt(3)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}