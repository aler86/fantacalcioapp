package com.github.aler86.fantacalcio;

import com.github.aler86.fantacalcio.exception.FieldValidationException;
import com.github.aler86.fantacalcio.model.Player;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ADMIN on 30/10/2014.
 */
public class PlayerResource extends Controller {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Metodo Get");
        try {
            Player newPlayer = Player.validate(Player.class, request.getParameter("id"));
            if(newPlayer == null)
                throw new FieldValidationException();

            PrintWriter writer = response.getWriter();
            writer.println(newPlayer.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            String json = this.readBody(request.getReader());
            Player newPlayer = Player.fromJson(Player.class, json);
            System.out.println(newPlayer.toJson());
            newPlayer.save();

            PrintWriter writer = response.getWriter();
            writer.println(newPlayer.toJson());
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }



    }
    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws  IOException{

        System.out.println("Metodo Put");
        try {
            String json = this.readBody(request.getReader());
            Player thePlayer = Player.fromJson(Player.class, json);
            thePlayer.update();

            PrintWriter writer = response.getWriter();
            writer.println(thePlayer.toJson());
        } catch(FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }



    }



    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Metodo Delete");
        try {
            Player thePlayer = Player.validate(Player.class, request.getParameter("id"));
            thePlayer.delete();
        } catch (FieldValidationException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}