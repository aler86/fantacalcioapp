package com.github.aler86.fantacalcio;


import com.github.aler86.fantacalcio.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ADMIN on 15/10/2014.
 */
public class UsersResource extends Controller {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Metodo Get");
        User person = new User();
        person.setUsername("Aler86");
        person.setPassword("sirio");
        person.setId(3);
        PrintWriter writer = response.getWriter();
        writer.println(person.toJson());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Metodo Post");
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Metodo Put");
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Metodo Delete");
    }
}


