package me.dmitriy.server.data;

/**
 * Класс, представляющий поле venue.
 */

public class Venue{
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long capacity; //Поле не может быть null, Значение поля должно быть больше 0
    private VenueType type; //Поле может быть null

    public Venue(int id, String name, Long capacity, VenueType type){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    /**
     * @return Venue's id.
     */

    public int getId(){
        return id;
    }

    /**
     * @return Venue's name.
     */

    public String getName(){
        return name;
    }

    /**
     * @return Venue's capacity.
     */

    public Long getCapacity(){
        return capacity;
    }

    /**
     * @return Venue's type.
     */

    public VenueType getType(){
        return type;
    }

    /**
     * @return Возврщает данные об объекте Venue.
     */

    @Override
    public String toString(){
        return "Venue: " + "VENUE_ID - " +  getId() + ", " + "VENUE_NAME - " + getName() + ", " + "VENUE_CAPACITY - " + getCapacity()
                + ", " + "VENUE_TYPE - " + getType();
    }
}
