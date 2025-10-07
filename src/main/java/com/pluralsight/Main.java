package com.pluralsight;

import com.sun.tools.jconsole.JConsoleContext;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        //ask the user which filenames to use.
        String inputFilename = ConsoleHelper.promptForString("Enter the name of the employee file to process");
        String outputFilename = ConsoleHelper.promptForString("Enter the name of the payroll file to create");


        try{
            //open the read file
            // open the write file

            FileReader fileReader = new FileReader(inputFilename);
            BufferedReader bufReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(outputFilename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("id|name|gross pay\n");

            // begin reading through it one line at a time.
            String input;
            while((input = bufReader.readLine()) != null){
                Employee emp = makeEmployeeFromCode(input);
                bufferedWriter.write(emp.getEmployeeId() + "|" + emp.getName() + "|" + emp.getGrossPay() + "\n");
            }


            //close both files...
            bufReader.close();
            fileReader.close();
            bufferedWriter.close();
            fileWriter.close();

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