package com.github.aler86.fantacalcio;

import com.github.aler86.fantacalcio.exception.FieldValidationException;
import com.github.aler86.fantacalcio.model.League;
import com.github.aler86.fantacalcio.model.Team;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * Created by ADMIN on 04/11/2014.
 */
public class IscrizioneResource extends Controller {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            League l =League.validate(League.class, request.getParameter("lid"));
            Team t =Team.validate(Team.class,request.getParameter("tid"));
            l.getTeam().add(t);
            l.update();
            PrintWriter writer = response.getWriter();
            writer.println(l.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }
/*
        System.out.println("Metodo Post");

        String json=this.readBody(request.getReader());

        Autore autore=Autore.fromJson(Autore.class,json);

        System.out.println(autore.getNome());

*/





    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("Metodo Delete");
        try {
            League l =League.validate(League.class, request.getParameter("lid"));
            Team t =Team.validate(Team.class,request.getParameter("tid"));
            Set<Team> teams= l.getTeam();
            for (Team current : teams){
                if(current.getId().equals(t.getId())){
                    teams.remove(current);
                }
            }
            l.update();
            PrintWriter writer = response.getWriter();
            writer.println(l);
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}
