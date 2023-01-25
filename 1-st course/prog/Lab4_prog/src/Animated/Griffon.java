package Animated;

import Abstract.Bird;
public class Griffon extends Bird{

    public Griffon(String name, String colorOfFeathers, int size){
        super(name, colorOfFeathers, size);
    }

    @Override
    public String fly() {
        if(this.getSize() <= 50 && this.getColorOfFeathers() == null){
            return "Не высоко";
        }
        return null;
    }
}
