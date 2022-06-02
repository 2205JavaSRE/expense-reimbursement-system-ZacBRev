package com.revature.dao;

import com.revature.models.ReimbursementTicket;

import java.util.List;

public interface ReimbursementTicketDaoInterface {

    void createReimbursement(ReimbursementTicket rt);

    List<ReimbursementTicket> getReimbursementByEmployeeID(int employeeID);

    List<ReimbursementTicket> getReimbursementByStatus(String status);

    List<ReimbursementTicket> getAllReimbursementTickets(int limit);

    void updateReimbursementStatus(ReimbursementTicket rt);


}
