package com.pluralsight;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try{
            FileReader fileReader = new FileReader("payroll.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);


        }
        catch(Exception e){
            System.out.println("There was an error!");
        }
    }
}