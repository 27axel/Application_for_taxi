package com.example.taxiapp.entity;

public class CarEntity {
    private String date;
    private String income_d;
    private String income_n;
    private String fuel_d;
    private String fuel_n;
    private String wash_d;
    private String wash_n;
    private String other_d;
    private String other_n;
    private String salary_d;
    private String salary_n;
    private String repair;
    private String spare;
    private String profit;
    private String dispatcher_d;
    private String dispatcher_n;
    private String yes;

    public CarEntity(String date, String income_d, String fuel_d, String wash_d, String other_d, String salary_d, String repair, String spare, String profit, String dispatcher_d) {
        this.date = date;
        this.income_d = income_d;
        this.fuel_d = fuel_d;
        this.wash_d = wash_d;
        this.other_d = other_d;
        this.salary_d = salary_d;
        this.repair = repair;
        this.spare = spare;
        this.profit = profit;
        this.dispatcher_d = dispatcher_d;
    }

    public CarEntity(String date, String income_n, String fuel_n, String wash_n, String other_n, String salary_n, String repair, String spare, String profit, String dispatcher_n, String yes) {
        this.date = date;
        this.income_n = income_n;
        this.fuel_n = fuel_n;
        this.wash_n = wash_n;
        this.other_n = other_n;
        this.salary_n = salary_n;
        this.repair = repair;
        this.spare = spare;
        this.profit = profit;
        this.dispatcher_n = dispatcher_n;
        this.yes = yes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIncome_d() {
        return income_d;
    }

    public void setIncome_d(String income_d) {
        this.income_d = income_d;
    }

    public String getIncome_n() {
        return income_n;
    }

    public void setIncome_n(String income_n) {
        this.income_n = income_n;
    }

    public String getFuel_d() {
        return fuel_d;
    }

    public void setFuel_d(String fuel_d) {
        this.fuel_d = fuel_d;
    }

    public String getFuel_n() {
        return fuel_n;
    }

    public void setFuel_n(String fuel_n) {
        this.fuel_n = fuel_n;
    }

    public String getWash_d() {
        return wash_d;
    }

    public void setWash_d(String wash_d) {
        this.wash_d = wash_d;
    }

    public String getWash_n() {
        return wash_n;
    }

    public void setWash_n(String wash_n) {
        this.wash_n = wash_n;
    }

    public String getOther_d() {
        return other_d;
    }

    public void setOther_d(String other_d) {
        this.other_d = other_d;
    }

    public String getOther_n() {
        return other_n;
    }

    public void setOther_n(String other_n) {
        this.other_n = other_n;
    }

    public String getSalary_d() {
        return salary_d;
    }

    public void setSalary_d(String salary_d) {
        this.salary_d = salary_d;
    }

    public String getSalary_n() {
        return salary_n;
    }

    public void setSalary_n(String salary_n) {
        this.salary_n = salary_n;
    }

    public String getRepair() {
        return repair;
    }

    public void setRepair(String repair) {
        this.repair = repair;
    }

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getDispatcher_d() {
        return dispatcher_d;
    }

    public void setDispatcher_d(String dispatcher_d) {
        this.dispatcher_d = dispatcher_d;
    }

    public String getDispatcher_n() {
        return dispatcher_n;
    }

    public void setDispatcher_n(String dispatcher_n) {
        this.dispatcher_n = dispatcher_n;
    }

    public String getYes() {
        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }
}
