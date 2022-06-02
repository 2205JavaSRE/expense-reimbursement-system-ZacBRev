package com.revature.dao;

import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

import javax.sql.PooledConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao implements EmployeeDaoInterface {

    @Override
    public Employee findEmployeeByUsername(String username) {
        PooledConnection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM employee WHERE username = ?";

        try (PreparedStatement ps = connection.getConnection().prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee employee = new Employee(rs.getInt("employee_id"),
                        rs.getString("username"), rs.getString("empl_password"),
                        rs.getString("empl_position"), rs.getString("first_name"),
                        rs.getString("last_name"));
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee findEmployeeByEmployeeID(int employeeID) {
        PooledConnection connection = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM employee WHERE employee_id = ?";

        try (PreparedStatement ps = connection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, employeeID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee employee = new Employee(rs.getInt("employee_id"),
                        rs.getString("username"), rs.getString("empl_password"),
                        rs.getString("empl_position"), rs.getString("first_name"),
                        rs.getString("last_name"));
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
