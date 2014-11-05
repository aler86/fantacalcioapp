package com.github.aler86.fantacalcio;


import com.github.aler86.fantacalcio.exception.FieldValidationException;
import com.github.aler86.fantacalcio.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ADMIN on 15/10/2014.
 */
public class UsersResource extends Controller {

   /* public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            User newUser = User.validate(User.class, request.getParameter("id"));
            if (newUser == null)
                throw new FieldValidationException();

            PrintWriter writer = response.getWriter();
            writer.println(newUser.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
/*

        System.out.println("Metodo Get");
        User person = new User();
        person.setUsername("Aler86");
        person.setPassword("sirio");
        person.setId(3);
        PrintWriter writer = response.getWriter();
        writer.println(person.toJson());

    }
*/

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("Metodo Post");
        try {
            String json = this.readBody(request.getReader());
            User newUser = User.fromJson(User.class, json);
            //System.out.println(newUser.toJson());
            newUser.save();

            PrintWriter writer = response.getWriter();
            writer.println(newUser.toJson());
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("Metodo Put");
        try {
            String json = this.readBody(request.getReader());
            User theUser = User.fromJson(User.class, json);
            System.out.println(theUser.toJson());
            theUser.update();

            PrintWriter writer = response.getWriter();
            writer.println(theUser.toJson());
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Metodo Delete");
        try {
            User theUser = User.validate(User.class, request.getParameter("id"));
            theUser.delete();
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }
}


