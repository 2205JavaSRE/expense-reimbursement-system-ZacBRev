package com.revature.controller;

import io.javalin.Javalin;
import io.micrometer.prometheus.PrometheusMeterRegistry;

public class RequestMapping {



    public static void configureRoutes(Javalin app, PrometheusMeterRegistry registry) {

        app.post("/api/login", AuthenticationController::authenticateLogin);

        app.get("/api/logout", AuthenticationController::logout);

        app.post("/api/employee/submit-reimbursement-ticket", ReimbursementTicketController::submitReimbursementTicket);

        app.get("/api/employee/view-reimbursement-tickets", ReimbursementTicketController::viewOwnReimbursementTickets);

        app.get ("/api/employee/view-{status}-reimbursement-tickets", ReimbursementTicketController::viewEmployeeReimbursementTicketsByStatus);

        app.get("/api/manager/view-all-reimbursement-tickets", ReimbursementTicketController::viewAllReimbursementTickets);

        app.get("/api/manager/view-employee-reimbursement-tickets/{id}", ReimbursementTicketController::viewReimbursementTicketsByUserID);

        app.get("/api/manager/view-{status}-reimbursement-tickets", ReimbursementTicketController::viewReimbursementTicketsByStatus);

        app.post("/api/manager/update-reimbursement-tickets", ReimbursementTicketController::updateReimbursementTicket);

        app.get("/metrics", context -> {
            context.result(registry.scrape());
        });

    }



}
