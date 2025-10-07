package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private float hoursWorked;
    private double payRate;

    public Employee(int employeeId, String name, float hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getGrossPay(){
        if (hoursWorked > 40){
            return (40 * payRate) + ((hoursWorked - 40) * payRate * 1.5);
        }
        else{
            return hoursWorked * payRate;
        }
    }

}
