package com.revature.service;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoInterface;
import com.revature.models.Employee;

import java.util.Locale;

public class AuthenticationService {

    public static boolean employeeAuthentication(String username, String password) {

        EmployeeDaoInterface employeeDao = new EmployeeDao();
        Employee employee = employeeDao.findEmployeeByUsername(username.toLowerCase(Locale.ROOT).trim());

        //Verify employee account was returned to avoid NullPointerException.
        if (employee == null) return false;

        if (employee.getUsername().equalsIgnoreCase(username) && employee.getPassword().equals(password))
            return true;

        return false;
    }

    public static Employee getEmployee(String username) {
        EmployeeDaoInterface employeeDao = new EmployeeDao();
        Employee employee = employeeDao.findEmployeeByUsername(username.toLowerCase(Locale.ROOT).trim());

        return employee;
    }

}
