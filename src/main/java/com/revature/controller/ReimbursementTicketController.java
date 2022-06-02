package com.revature.controller;

import com.revature.models.Employee;
import com.revature.service.ReimbursementTicketService;
import io.javalin.http.Context;
import org.eclipse.jetty.http.HttpStatus;

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
        }
    }
}
