package me.dmitriy;

import me.dmitriy.server.data.Ticket;
import me.dmitriy.server.utilits.*;

import java.util.ArrayList;

/**
 * @author Михайлов Дмитрий Андреевич
 * Группа P3118
 * Вариант №31191
 */

public class LaunchApp{

    public static void main(String[] args){
        ArrayList<Ticket> tickets = FileManager.readFile();
        for(Ticket ticket : tickets){
            System.out.println(ticket.toString());
        }
    }
}