package com.revature.controller;

import io.javalin.Javalin;

public class RequestMapping {



    public static void configureRoutes(Javalin app) {

        app.post("/login", context -> {
            AuthenticationController.authenticateByFormParam(context);
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
