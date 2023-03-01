package me.dmitriy.server.data;

import java.time.LocalDateTime;

/**
 * Главный класс, представляющий элементы коллекции.
 */

public class Ticket{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float price; //Поле не может быть null, Значение поля должно быть больше 0
    private String comment; //Строка не может быть пустой, Поле не может быть null
    private Boolean refundable; //Поле не может быть null
    private TicketType type; //Поле может быть null
    private Venue venue; //Поле не может быть null

    public Ticket(Long id, String name, Coordinates coordinates, LocalDateTime creationDate, float price, String comment, Boolean refundable, TicketType type, Venue venue){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.price = price;
        this.comment = comment;
        this.refundable = refundable;
        this.type = type;
        this.venue = venue;
    }

    /**
     * @return Ticket's id.
     */

    public Long getId(){
        return this.id;
    }

    /**
     * @return Ticket's name.
     */

    public String getName(){
        return this.name;
    }

    /**
     * @return Ticket's coordinates.
     */

    public Coordinates getCoordinates(){
        return this.coordinates;
    }

    /**
     * @return Ticket's creationDate.
     */

    public LocalDateTime getCreationDate(){
        return this.creationDate;
    }

    /**
     * @return Ticket's price.
     */

    public float getPrice(){
        return this.price;
    }

    /**
     * @return Ticket's comment.
     */

    public String getComment(){
        return this.comment;
    }

    /**
     * @return Ticket's refundable.
     */

    public Boolean getRefundable(){
        return this.refundable;
    }

    /**
     * @return Ticket's type.
     */

    public TicketType getType(){
        return this.type;
    }

    /**
     * @return Ticket's venue.
     */

    public Venue getVenue(){
        return this.venue;
    }

    /**
     * @return Возврщает данные об объекте Ticket.
     */

    @Override
    public String toString(){
        return "Ticket: " + "ID - " + getId() + " || " + "NAME - " + getName() + " || " + getCoordinates().toString()
                + " || " + "LocalDateTime - " + getCreationDate() + " || " + "PRICE - " + getPrice()
                + " || " + "COMMENT - " + getComment() + " || " + "REFUNDABLE - " + getRefundable()
                + " || " + "TICKET_TYPE - " + getType() + " || " + getVenue().toString();
    }
}
