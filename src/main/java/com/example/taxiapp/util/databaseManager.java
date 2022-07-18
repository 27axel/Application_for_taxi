package com.example.taxiapp.util;

import com.example.taxiapp.entity.CarEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class databaseManager {

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:sqlite:taxi.db");
    }

    public static void addCar(String name) throws SQLException {
        try (Connection c = getConnection()) {
            String sql = "INSERT INTO Car(name) values (?)";
            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, name);
            ps.executeUpdate();
        }
    }

    public static ObservableList<String> getCar() throws SQLException{
        try(Connection c = getConnection()){
            String sql = "SELECT name FROM Car";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            ObservableList<String> carList = FXCollections.observableArrayList();
            while (resultSet.next()){
                carList.add(
                        resultSet.getString("name")
                );
            }
            return carList;
        }
    }

    public static void deleteCar(String name) throws SQLException {
        try (Connection c = getConnection()){
            String sql = "DELETE FROM Car WHERE name=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }

    public static void insert(String name, String date, String income_d, String income_n, String fuel_d, String fuel_n, String wash_d, String wash_n, String other_d, String other_n, String salary_d, String salary_n, String repair, String repair_date, String spare, String comment, String profit, String disp_d, String disp_n) throws SQLException{
        try (Connection c = getConnection()){
            String sql = "insert into \"" + name + "\"(\n" +
                    "date,\n" +
                    "income_d,\n" +
                    "income_n,\n" +
                    "fuel_d,\n" +
                    "fuel_n,\n" +
                    "wash_d,\n" +
                    "wash_n,\n" +
                    "other_d,\n" +
                    "other_n,\n" +
                    "salary_d,\n" +
                    "salary_n,\n" +
                    "repair,\n" +
                    "repair_date,\n" +
                    "spare,\n" +
                    "comment,\n" +
                    "profit,\n" +
                    "dispatcher_d,\n" +
                    "dispatcher_n\n" +
                    ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, date);
            ps.setInt(2, Integer.parseInt(income_d));
            ps.setInt(3, Integer.parseInt(income_n));
            ps.setInt(4, Integer.parseInt(fuel_d));
            ps.setInt(5, Integer.parseInt(fuel_n));
            ps.setInt(6, Integer.parseInt(wash_d));
            ps.setInt(7, Integer.parseInt(wash_n));
            ps.setInt(8, Integer.parseInt(other_d));
            ps.setInt(9, Integer.parseInt(other_n));
            ps.setInt(10, Integer.parseInt(salary_d));
            ps.setInt(11, Integer.parseInt(salary_n));
            ps.setInt(12, Integer.parseInt(repair));
            ps.setString(13, repair_date);
            ps.setInt(14, Integer.parseInt(spare));
            ps.setString(15, comment);
            ps.setInt(16, Integer.parseInt(profit));
            ps.setInt(17, Integer.parseInt(disp_d));
            ps.setInt(18, Integer.parseInt(disp_n));

            ps.executeUpdate();
        }

    }

    public static void create(String name) throws SQLException{
        try (Connection c = getConnection()){
            String sql = "CREATE TABLE \"" + name + "\" (\n" +
                    "\t\"date\"\tTEXT NOT NULL,\n" +
                    "\t\"income_d\"\tINTEGER,\n" +
                    "\t\"income_n\"\tINTEGER,\n" +
                    "\t\"fuel_d\"\tINTEGER,\n" +
                    "\t\"fuel_n\"\tINTEGER,\n" +
                    "\t\"wash_d\"\tINTEGER,\n" +
                    "\t\"wash_n\"\tINTEGER,\n" +
                    "\t\"other_d\"\tINTEGER,\n" +
                    "\t\"other_n\"\tINTEGER,\n" +
                    "\t\"salary_d\"\tINTEGER,\n" +
                    "\t\"salary_n\"\tINTEGER,\n" +
                    "\t\"repair\"\tINTEGER,\n" +
                    "\t\"repair_date\"\tTEXT,\n" +
                    "\t\"spare\"\tINTEGER,\n" +
                    "\t\"comment\"\tTEXT,\n" +
                    "\t\"profit\"\tINTEGER,\n" +
                    "\t\"dispatcher_d\"\tINTEGER,\n" +
                    "\t\"dispatcher_n\"\tINTEGER,\n" +
                    "\tPRIMARY KEY(\"date\")\n" +
                    ");";


            PreparedStatement ps = c.prepareStatement(sql);
            ps.executeUpdate();
        }
    }



    public static ObservableList<CarEntity> getInfo(String name) throws SQLException{
        try(Connection c = getConnection()){
            String sql = "SELECT * FROM \"" + name +"\"";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            CarEntity car;
            ObservableList<CarEntity> carList = FXCollections.observableArrayList();
            while (resultSet.next()){

            }
            return carList;
        }
    }



    public static List<String> tables() throws SQLException{
        try(Connection c = getConnection()){
            String sql = "SELECT name FROM sqlite_master WHERE name;";
            Statement s = c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            List<String> list = new ArrayList<>();
            while(resultSet.next()) {
                list.add(
                        resultSet.getString("name")
                );
            }
            return list;
        }
    }


}
