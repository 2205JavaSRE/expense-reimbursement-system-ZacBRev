package com.revature.controller;

import com.revature.models.Employee;
import com.revature.service.AuthenticationService;
import io.javalin.http.Context;
import org.eclipse.jetty.http.HttpStatus;

public class AuthenticationController {



    public static void authenticateLogin(Context context) {

        String username = context.formParam("username");
        String password = context.formParam("password");

        boolean authenticated = AuthenticationService.employeeAuthentication(username, password);
        if (authenticated) {
            Employee employee = AuthenticationService.getEmployee(username);
            context.result("Access granted");
            context.status(HttpStatus.ACCEPTED_202);

            context.sessionAttribute("Employee", employee);

        } else {
            context.status(HttpStatus.FORBIDDEN_403);
            context.result("Unable to verify login");
        }

    }

    public static Employee verifyEmployee (Context context) {

        Employee employee = context.sessionAttribute("Employee");

        if (employee == null) return null;
        else return employee;
    }

    public static boolean logout (Context context) {
        Employee employee = verifyEmployee(context);
        if (employee != null) {
            context.consumeSessionAttribute("Employee");
            context.result("Session consumed");
            context.status(HttpStatus.OK_200);
        } else {
            context.status(HttpStatus.NOT_ACCEPTABLE_406);
            context.result("No session to consume");
        }

        return true;
    }


}
