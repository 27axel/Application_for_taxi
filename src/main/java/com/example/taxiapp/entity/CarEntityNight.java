package com.example.taxiapp.entity;

public class CarEntityNight {
    private String date;
    private String income_n;
    private String fuel_n;
    private String wash_n;
    private String other_n;
    private String salary_n;
    private String repair;
    private String spare;
    private String profit;
    private String dispatcher_n;

    public CarEntityNight(String date, String income_n, String fuel_n, String wash_n, String other_n, String salary_n, String repair, String spare, String profit, String dispatcher_n) {
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
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIncome_n() {
        return income_n;
    }

    public void setIncome_n(String income_n) {
        this.income_n = income_n;
    }

    public String getFuel_n() {
        return fuel_n;
    }

    public void setFuel_n(String fuel_n) {
        this.fuel_n = fuel_n;
    }

    public String getWash_n() {
        return wash_n;
    }

    public void setWash_n(String wash_n) {
        this.wash_n = wash_n;
    }

    public String getOther_n() {
        return other_n;
    }

    public void setOther_n(String other_n) {
        this.other_n = other_n;
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

    public String getDispatcher_n() {
        return dispatcher_n;
    }

    public void setDispatcher_n(String dispatcher_n) {
        this.dispatcher_n = dispatcher_n;
    }
}
