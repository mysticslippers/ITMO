package me.dmitriy.client;

import me.dmitriy.server.data.Coordinates;
import me.dmitriy.server.data.TicketType;
import me.dmitriy.server.data.Venue;
import me.dmitriy.server.data.VenueType;

import java.time.LocalDateTime;

/**
 * Класс, реализующий пользовательский ввод и нахождение в нём ошибок.
 */

public class UserInputManager{

    /**
     * Валидатор для поля name.
     * @param name
     * @return Возврощает true, если имя валидно.
     */

    public static boolean isNameValid(String name){
        return (name != null && !name.isEmpty());
    }

    /**
     * Валидатор для поля coordinates.
     * @param coordinates
     * @return Возвращает true, если x, y - валидные значения.
     */

    public static boolean isCoordinatesValid(Coordinates coordinates){
        return (coordinates.getX() > -390.0 && coordinates.getY() != 0);
    }

    /**
     * Валидатор для поля creationDate.
     * @param creationDate
     * @return Возврщает true, если creationDate - валидное значение.
     */

    public static boolean isCreationDateValid(LocalDateTime creationDate){
        return creationDate != null;
    }

    /**
     * Валидатор для поля price.
     * @param price
     * @return Возврщает true, если price - валидное значение.
     */

    public static boolean isPriceValid(float price){
        return (price > 0);
    }

    /**
     * Валидатор для поля comment.
     * @param comment
     * @return Возврщает true, если comment - валидное значение.
     */

    public static boolean isCommentValid(String comment){
        return (comment.length() <= 404 && comment != null);
    }

    /**
     * Валидатор для поля refundable.
     * @param refundable
     * @return Возврщает true, если refundable - валидное значение.
     */

    public static boolean isRefundableValid(String refundable){
        return refundable != null && (refundable.equalsIgnoreCase("true") || refundable.equalsIgnoreCase("false"));
    }

    /**
     * Валидатор для поля ticketType.
     * @param userInputTicketType
     * @return Возвращает true, если ticketType - валидное значение.
     */

    public static boolean isTicketTypeValid(String userInputTicketType){
        boolean exist = true;
        try{
            TicketType.valueOf(userInputTicketType);
        }catch(IllegalArgumentException exception){
            exist = false;
        }
        return userInputTicketType != null && exist;
    }

    /**
     * Валидатор для поля venue.
     * @param venue
     * @return Возвращает true, если venueName, venueCapacity, venueType - валидные значения.
     */

    public static boolean isVenueValid(Venue venue){

        return (venue.getName() != null && !venue.getName().isEmpty() && venue.getCapacity() != null && venue.getCapacity() > 0);
    }

    /**
     * Валидатор для поля VenueType.
     * @param userInputVenueType
     * @return
     */

    public static boolean isVenueTypeValid(String userInputVenueType){
        boolean exist = true;
        try{
            VenueType.valueOf(userInputVenueType);
        }catch(IllegalArgumentException exception){
            exist = false;
        }
        return userInputVenueType != null && exist;
    }

    /**
     * Валидатор для определения исходного файла.
     * @return Возвращает true, если путь до переменной окружения с именем Collection указан верно.
     */

    public static boolean isFileNotNull(){
        return System.getenv().get("Collection") != null;
    }
}
