package com.revature.controller;

import com.revature.service.AuthenticationService;
import io.javalin.http.Context;

public class AuthenticationController {



    public static void authenticateByFormParam(Context context) {

        String username = context.formParam("username");
        String password = context.formParam("password");

        boolean authenticated = AuthenticationService.employeeAuthentication(username, password);

    }


}
