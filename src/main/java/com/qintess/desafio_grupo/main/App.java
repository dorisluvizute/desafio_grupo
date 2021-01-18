package com.qintess.desafio_grupo.main;

import java.util.Scanner;

import com.qintess.desafio_grupo.dao.ActorDao;
import com.qintess.desafio_grupo.dao.CustomerDao;
import com.qintess.desafio_grupo.dao.FilmDao;
import com.qintess.desafio_grupo.dao.Film_actorDao;
import com.qintess.desafio_grupo.entities.Actor;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        Film_actorDao fad = new Film_actorDao();
    	FilmDao fd = new FilmDao();
        ActorDao actor = new ActorDao();
    	CustomerDao cust = new CustomerDao();

    	Integer result_fd = fd.insert("teste", "teste", 2008, 2, 250,
                4.50, 150, 6.99);

    	Integer result_actor = actor.insert("Robson", "Almeida");

    	fad.insert(result_actor, result_fd);

    	
    	
    }
}
