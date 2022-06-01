package com.revature.dao;

import com.revature.models.Employee;

public interface EmployeeDaoInterface {

    Employee findEmployeeByUsername(String username);
    Employee findEmployeeByEmployeeID(int employeeID);

}
