package com.revature.controller;

import com.revature.models.Employee;
import com.revature.models.ReimbursementTicket;
import com.revature.service.ReimbursementTicketService;
import io.javalin.http.Context;
import io.javalin.http.HttpCode;
import org.eclipse.jetty.http.HttpStatus;

import java.util.List;
import java.util.Objects;

public class ReimbursementTicketController {

    private ReimbursementTicketController() {
        throw new IllegalStateException("Utility class");
    }

    public static void submitReimbursementTicket(Context context) {
        Employee employee = AuthenticationController.verifyEmployee(context);
        ReimbursementTicketService rbService = new ReimbursementTicketService();

        if (employee != null) {
            if (rbService.isFinanceManager(employee)) {
                context.result("Finance Managers are unable to submit requests, please message your immediate superior.");
                context.status(HttpStatus.NOT_ACCEPTABLE_406);
            } else {
                String stringAmount = context.formParam("amount");
                String category = context.formParam("category");

                if (rbService.missingFields(stringAmount, category)) {
                    context.result("Missing fields, please ensure all fields have been entered.");
                    context.status(HttpStatus.NOT_ACCEPTABLE_406);
                } else {
                    double amount = Double.parseDouble(stringAmount);
                    if (rbService.createReimbursementTicket(employee, amount, category)) {
                        context.result("Reimbursement Ticket submitted");
                        context.status(HttpStatus.CREATED_201);
                    } else {
                        context.result("Unable to submit reimbursement with negative money.");
                        context.status(HttpStatus.NOT_ACCEPTABLE_406);
                    }
                }
            }
        } else {
            context.result("Unable to verify credentials while submitting ticket.");
            context.status(HttpStatus.FORBIDDEN_403);
        }
    }

    public static void viewOwnReimbursementTickets(Context context) {
        Employee employee = AuthenticationController.verifyEmployee(context);
        ReimbursementTicketService rbService = new ReimbursementTicketService();

        if (employee != null) {
            List<ReimbursementTicket> rbList = rbService.getEmployeeReimbursementTickets(employee);
            context.json(rbList);
            context.status(HttpCode.ACCEPTED);
        } else {
            context.result("Unable to verify credentials while viewing reimbursement history.");
            context.status(HttpStatus.FORBIDDEN_403);
        }
    }

    public static void viewAllReimbursementTickets(Context context) {
        Employee employee = AuthenticationController.verifyEmployee(context);
        ReimbursementTicketService rbService = new ReimbursementTicketService();

        if (employee != null && employee.getPosition().equals("Finance Manager")) {
            List<ReimbursementTicket> rbList = rbService.getAllReimbursementTickets();
            context.json(rbList);
            context.status(HttpCode.ACCEPTED);
        } else {
            context.result("Unable to verify credentials while viewing reimbursement history.");
            context.status(HttpStatus.FORBIDDEN_403);
        }
    }

    public static void viewReimbursementTicketsByStatus(Context context) {
        Employee employee = AuthenticationController.verifyEmployee(context);
        ReimbursementTicketService rbService = new ReimbursementTicketService();

        if (employee != null && employee.getPosition().equals("Finance Manager")) {
            String status = context.pathParam("status");
            List<ReimbursementTicket> rbList = rbService.getReimbursementTicketByStatus(status);
            context.json(rbList);
            context.status(HttpCode.ACCEPTED);
        } else {
            context.result("Unable to verify credentials while viewing reimbursement history.");
            context.status(HttpStatus.FORBIDDEN_403);
        }
    }

    public static void updateReimbursementTicket(Context context) {
        Employee employee = AuthenticationController.verifyEmployee(context);
        ReimbursementTicketService rbService = new ReimbursementTicketService();

        if (employee != null && employee.getPosition().equals("Finance Manager")) {
            int reimbursementTicketID = Integer.parseInt(context.formParam("ticket_id"));
            String status = context.formParam("status");
            rbService.updateReimbursementTicket(reimbursementTicketID, employee.getEmployeeID(), status);
            context.status(HttpCode.ACCEPTED);
        } else {
            context.result("Unable to verify credentials while viewing reimbursement history.");
            context.status(HttpStatus.FORBIDDEN_403);
        }

    }


}
