package com.github.aler86.fantacalcio;

import com.github.aler86.fantacalcio.exception.FieldValidationException;
import com.github.aler86.fantacalcio.model.Team;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ADMIN on 15/10/2014.
 */



public class TeamResource extends Controller {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Metodo Get");
        try {
            Team newTeam = Team.validate(Team.class, request.getParameter("id"));
            if(newTeam == null)
                throw new FieldValidationException();

            PrintWriter writer = response.getWriter();
            writer.println(newTeam.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            String json = this.readBody(request.getReader());
            Team newTeam = Team.fromJson(Team.class, json);
            System.out.println(newTeam.toJson());
            newTeam.save();

            PrintWriter writer = response.getWriter();
            writer.println(newTeam.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
/*
        System.out.println("Metodo Post");

        String json=this.readBody(request.getReader());

        Autore autore=Autore.fromJson(Autore.class,json);

        System.out.println(autore.getNome());

*/
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws  IOException{

        System.out.println("Metodo Put");
        try {
            String json = this.readBody(request.getReader());
            Team theTeam = Team.fromJson(Team.class, json);
            theTeam.update();

            PrintWriter writer = response.getWriter();
            writer.println(theTeam.toJson());
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }



    }



    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Metodo Delete");
        try {
            Team theTeam = Team.validate(Team.class, request.getParameter("id"));
            theTeam.delete();
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}

