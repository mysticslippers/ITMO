package me.dmitriy.server.data;

/**
 * Класс, представляющий поле coordinates.
 */
public class Coordinates{
    private Float x; //Значение поля должно быть больше -390, Поле не может быть null
    private int y;

    public Coordinates(float x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return значение координаты x.
     */

    public Float getX(){
        return x;
    }

    /**
     * @return значение координаты y.
     */

    public int getY(){
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates: " + "X - " + getX() + ", " + "Y - " + getY();
    }
}
