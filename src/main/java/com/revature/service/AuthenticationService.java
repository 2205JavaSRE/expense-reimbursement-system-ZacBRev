package com.revature.service;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoInterface;
import com.revature.models.Employee;

public class AuthenticationService {

    public static boolean employeeAuthentication(String username, String password) {

        EmployeeDaoInterface employeeDao = new EmployeeDao();
        Employee employee = employeeDao.findEmployeeByUsername(username);
        if (employee.getUsername().equals(username) && employee.getPassword().equals(password))
            return true;

        return false;
    }

}
