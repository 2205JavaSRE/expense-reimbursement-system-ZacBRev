package com.revature;

import com.revature.controller.RequestMapping;
import io.javalin.Javalin;

public class MainDriver {


    public static void main(String[] args) {

        Javalin serverInstance = Javalin.create().start(8500);

        //Setting up the Request Mapping

        RequestMapping.configureRoutes(serverInstance);




    }

}
