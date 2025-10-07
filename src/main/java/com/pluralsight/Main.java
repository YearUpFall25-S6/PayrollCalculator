package com.pluralsight;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        try{
            FileReader fileReader = new FileReader("payroll.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            String line;
            while((line = bufReader.readLine()) != null){
                Employee emp = makeEmployeeFromCode(line);
                displayEmployee(emp);
            }

        }
        catch(Exception e){
            System.out.println("There was an error!");
        }
    }

    public static Employee makeEmployeeFromCode(String code){

        String[] parts = code.split("\\|");

        int employeeId  = Integer.parseInt(parts[0]) ;
        String name = parts[1];
        float hoursWorked = Float.parseFloat(parts[2]) ;
        double payRate = Double.parseDouble(parts[3]) ;

        return new Employee(employeeId, name, hoursWorked, payRate);
    }

    public static void displayEmployee(Employee e){
        System.out.printf("%d %s worked %.1f hours at a rate of $%.2f and earned $%.2f\n",e.getEmployeeId(), e.getName(), e.getHoursWorked(), e.getPayRate(), e.getGrossPay());
    }
}