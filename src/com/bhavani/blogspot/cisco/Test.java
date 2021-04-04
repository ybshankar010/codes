package com.bhavani.blogspot.cisco;

import java.util.*;

class InvalidInputException extends Exception {
    public InvalidInputException(String errMsg) {
        super(errMsg);
    }
}

class Employee {

    private int id = 0;
    private String name = null;
    private boolean male = true;

    Employee(int id, String name,  boolean male) {
        super();
        this.id = id;
        this.name = name;
        this.male = male;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ",  male=" + male + "]";
    }

    @Override
    public boolean equals(Object obj) {
        boolean idEqual = this.id == ((Employee)obj).id;
        return idEqual;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

public class Test {

    /*
     * Validate the input and create Employee object
     * If any of the given input is not valid throw InvalidInputException();
     */
    public Employee createEmployee(String record) throws InvalidInputException{
        if(record.isEmpty()) {
            return null;
        }

        String[] tokens = record.split(",");
        if(tokens.length != 3) {
            throw new InvalidInputException("InvalidInputException");
        }

        return new Employee(Integer.parseInt(tokens[0]), tokens[1], Boolean.parseBoolean(tokens[2]));
    }

    public static void main(String[] str) {
        //Input is expected as comma separated values for Employee object like id(int), name (String),isMale(boolean)"
        // 1,John,true
        Scanner scan = new Scanner(System.in);
        try {
            Set<Employee> employeeSet = new HashSet<>();

            /*Process each line and create Employee object using the "createEmployee" method add in employeeSet*/
            Test parser = new Test();
            while (true) {

                try {
                    //Complete the code
                    String record = scan.nextLine();
                    Employee emp = parser.createEmployee(record);
                    if(emp == null) {
                        break;
                    }
                    employeeSet.add(emp);
                } catch(Exception e) {
                    System.out.println(e.getClass().getName());
                    System.exit(0);
                }
            }

            //Don't delete or modify this print statement
            System.out.println("Employees info : "+ employeeSet);
        } finally {
            scan.close();
        }
    }
/*
1,Ram,true
2,Seetha,false
1,Ram,true
* */
}