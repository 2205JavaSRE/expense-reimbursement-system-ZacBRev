package com.revature.controller;

import io.javalin.Javalin;

public class RequestMapping {



    public static void configureRoutes(Javalin app) {

        app.post("/api/login", context -> {
            AuthenticationController.authenticateLogin(context);
        });

        app.get("/api/logout", context -> {
            AuthenticationController.logout(context);
        });

        app.post("/api/submit-reimbursement-ticket", context -> {
            ReimbursementTicketController.submitReimbursementTicket(context);
        });
//
//        app.get("", context -> {
//
//        });
//
//        app.get("", context -> {
//
//        });
//
//        app.get("", context -> {
//
//        });
//
//        app.get("", context -> {
//
//        });

    }



}
