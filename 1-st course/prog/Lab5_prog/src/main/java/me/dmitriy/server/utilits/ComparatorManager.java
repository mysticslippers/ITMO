package me.dmitriy.server.utilits;

import me.dmitriy.server.data.Ticket;

import java.util.Comparator;

/**
 * Класс, устанавливающий правила сортировки.
 */

public class ComparatorManager implements Comparator<Ticket>{

    /**
     * Метод для сортировки коллекции по полю price в порядке убывания.
     * @param ticket1 the first object to be compared.
     * @param ticket2 the second object to be compared.
     * @return Результат сравнения.
     */

    @Override
    public int compare(Ticket ticket1, Ticket ticket2){
        if(ticket1.getPrice() > ticket2.getPrice()){
            return -1;
        }
        else if(ticket1.getPrice() == ticket2.getPrice()){
            return 0;
        }
        else{
            return 1;
        }
    }
}
