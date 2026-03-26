package com.Couse_man.model;

import java.sql.*;
import java.util.Scanner;
import com.Couse_man.util.DBconnection;

public class Department {

    static Scanner sc = new Scanner(System.in);

    public static void insertDept() {
        try {
            System.out.print("Dept ID: ");
            int id = sc.nextInt();

            sc.nextLine();
            System.out.print("Dept Name: ");
            String name = sc.nextLine();

            Connection con = DBconnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement("INSERT INTO Department (dept_id, dept_name) VALUES (?, ?)");

            ps.setInt(1, id);
            ps.setString(2, name);

            ps.executeUpdate();

            System.out.println("✅ Department Added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewDept() {
        try {
            Connection con = DBconnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement("SELECT * FROM Department");

            ResultSet rs = ps.executeQuery();

            System.out.println("\nID\tNAME");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteDept() {
        try {
            System.out.print("Enter Dept ID: ");
            int id = sc.nextInt();

            Connection con = DBconnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement("DELETE FROM Department WHERE dept_id=?");

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("✅ Deleted");
            else
                System.out.println("❌ Not Found");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}