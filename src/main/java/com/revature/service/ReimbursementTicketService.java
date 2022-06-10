package com.revature.service;

import com.revature.dao.ReimbursementTicketDao;
import com.revature.dao.ReimbursementTicketDaoInterface;
import com.revature.models.Employee;
import com.revature.models.ReimbursementTicket;

import java.util.List;

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

    public List<ReimbursementTicket> getEmployeeReimbursementTickets(Employee employee) {
        ReimbursementTicketDaoInterface rbDao = new ReimbursementTicketDao();
        return rbDao.getReimbursementByEmployeeID(employee.getEmployeeID());
    }

    public List<ReimbursementTicket> getEmployeeReimbursementTickets(int employeeID) {
        ReimbursementTicketDaoInterface rbDao = new ReimbursementTicketDao();
        return rbDao.getReimbursementByEmployeeID(employeeID);
    }


    public List<ReimbursementTicket> getAllReimbursementTickets() {
        ReimbursementTicketDaoInterface rbDao = new ReimbursementTicketDao();
        return rbDao.getAllReimbursementTickets();
    }

    public List<ReimbursementTicket> getReimbursementTicketByStatus(String status) {
        ReimbursementTicketDaoInterface rbDao = new ReimbursementTicketDao();
        return rbDao.getReimbursementByStatus(status);
    }

    public List<ReimbursementTicket> getReimbursementTicketByStatus(String status, int employeeid) {
        ReimbursementTicketDaoInterface rbDao = new ReimbursementTicketDao();
        return rbDao.getReimbursementByStatus(status, employeeid);
    }


    public void updateReimbursementTicket (int reimbursementTicketID,  int managerID, String status) {
        ReimbursementTicketDaoInterface rbDao = new ReimbursementTicketDao();
        rbDao.updateReimbursementStatus(reimbursementTicketID, managerID, status);
    }

}
