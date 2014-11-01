package com.github.aler86.fantacalcio;

import com.github.aler86.fantacalcio.exception.FieldValidationException;
import com.github.aler86.fantacalcio.model.League;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ADMIN on 30/10/2014.
 */
public class LeagueResource extends Controller {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            League newLeague = League.validate(League.class, request.getParameter("id"));
            if(newLeague == null)
                throw new FieldValidationException();

            PrintWriter writer = response.getWriter();
            writer.println(newLeague.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }


     /*   System.out.println("Metodo Get");
        League league = new League();
        league.setNome("Leo");
        league.setId(8);

        PrintWriter writer = response.getWriter();
        writer.println(league.toJson()); */


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            String json = this.readBody(request.getReader());
            League newLeague = League.fromJson(League.class, json);
            System.out.println(newLeague.toJson());
            newLeague.save();

            PrintWriter writer = response.getWriter();
            writer.println(newLeague.toJson());
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
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{

        System.out.println("Metodo Put");
        try {
            String json = this.readBody(request.getReader());
            League theLeague = League.fromJson(League.class, json);
            System.out.println(theLeague.toJson());
            theLeague.update();

            PrintWriter writer = response.getWriter();
            writer.println(theLeague.toJson());
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }



    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Metodo Delete");
        try {
            League theLeague = League.validate(League.class, request.getParameter("id"));
            theLeague.delete();
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
