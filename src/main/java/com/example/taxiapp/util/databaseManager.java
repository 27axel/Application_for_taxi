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

    public static void addDriver(String name) throws SQLException {
        try(Connection c = getConnection()) {
            String sql = "INSERT INTO Driver (name) VALUES (?)";
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

    public static ObservableList<String> getDrivers() throws SQLException{
        try(Connection c = getConnection()){
            String sql = "SELECT name FROM Driver";
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

    public static void deleteDriver(String name) throws SQLException {
        try (Connection c = getConnection()){
            String sql = "DELETE FROM Driver WHERE name=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }

    public static void addDispatch(String name) throws SQLException {
        try(Connection c = getConnection()) {
            String sql = "INSERT INTO Dispatcher (name) VALUES (?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }

    public static void deleteDispatcher(String name) throws SQLException {
        try (Connection c = getConnection()){
            String sql = "DELETE FROM Dispatcher WHERE name=?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();
        }
    }

    public static ObservableList<String> getDispatcher() throws SQLException {
        try (Connection c = getConnection()) {
            String sql = "SELECT name FROM Dispatcher";
            Statement s =c.createStatement();
            ResultSet resultSet = s.executeQuery(sql);

            ObservableList<String> dispatcherList = FXCollections.observableArrayList();
            while(resultSet.next()) {
                dispatcherList.add(
                        resultSet.getString("name")
                );
            }
            return dispatcherList;
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
