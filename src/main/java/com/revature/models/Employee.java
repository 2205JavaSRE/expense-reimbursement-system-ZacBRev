package com.revature.models;

import java.util.List;

public class Employee {
    private int employeeID;
    private String username;
    private String password;
    private String position;
    private String firstName;
    private String lastName;
    List<ReimbursementTicket> reimbursementTicketList;

    public Employee(int employeeID, String username, String password, String position, String firstName, String lastName) {
        this.employeeID = employeeID;
        this.username = username;
        this.password = password;
        this.position = position;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ReimbursementTicket> getReimbursementTicketList() {
        return reimbursementTicketList;
    }

    public void setReimbursementTicketList(List<ReimbursementTicket> reimbursementTicketList) {
        this.reimbursementTicketList = reimbursementTicketList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
