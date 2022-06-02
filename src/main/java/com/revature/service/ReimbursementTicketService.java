package com.revature.service;

import com.revature.dao.ReimbursementTicketDao;
import com.revature.dao.ReimbursementTicketDaoInterface;
import com.revature.models.Employee;
import com.revature.models.ReimbursementTicket;

public class ReimbursementTicketService {

    public boolean createReimbursementTicket(Employee employee, double amount, String category) {

        if (amount >= 0) {
            ReimbursementTicket rt = new ReimbursementTicket(-1, employee.getEmployeeID(),
                    -1, "Pending", amount, category);

            ReimbursementTicketDaoInterface rbDao = new ReimbursementTicketDao();
            rbDao.createReimbursement(rt);
            return true;
        }

        return false;
    }

    public boolean isFinanceManager(Employee employee) {
        return employee.getPosition().trim().equals("Finance Manager");
    }

    public boolean missingFields(String amount, String category) {
        return amount.isEmpty() || category.isEmpty();
    }



}
