package com.revature.dao;

import com.revature.models.ReimbursementTicket;

import java.util.List;

public interface ReimbursementTicketDaoInterface {


    List<ReimbursementTicket> getReimbursementByEmployeeID(int employeeID);

    List<ReimbursementTicket> getReimbursementByCategory(String category);

    List<ReimbursementTicket> getAllReimbursementTickets();


}
