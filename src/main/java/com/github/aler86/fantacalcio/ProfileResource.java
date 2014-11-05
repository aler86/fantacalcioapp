package com.github.aler86.fantacalcio;

import com.github.aler86.fantacalcio.exception.FieldValidationException;

import com.github.aler86.fantacalcio.model.Profile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ADMIN on 15/10/2014.
 */

public class ProfileResource extends Controller {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Profile newProfile = Profile.validate(Profile.class, request.getParameter("id"));
            if(newProfile == null)
                throw new FieldValidationException();

            PrintWriter writer = response.getWriter();
            writer.println(newProfile.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }


       /* System.out.println("Metodo Get");
        Profile profilo = new Profile();
        profilo.setNome("Alessandro");
        profilo.setCognome("Riccio");
        profilo.setIndirizzo("Via col vento");
        PrintWriter writer = response.getWriter();
        writer.println(profilo.toJson()); */
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        System.out.println("Metodo Post");
        try {
            String json = this.readBody(request.getReader());
            Profile newProfile = Profile.fromJson(Profile.class, json);
            System.out.println(newProfile.toJson());
            newProfile.save();

            PrintWriter writer = response.getWriter();
            writer.println(newProfile.toJson());
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
            Profile theProfile = Profile.fromJson(Profile.class, json);
            System.out.println(theProfile.toJson());
            theProfile.update();

            PrintWriter writer = response.getWriter();
            writer.println(theProfile.toJson());
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Metodo Delete");
        try {
            Profile theProfile = Profile.validate(Profile.class, request.getParameter("id"));
            theProfile.delete();
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}

