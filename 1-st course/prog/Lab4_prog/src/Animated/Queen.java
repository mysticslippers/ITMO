package Animated;

import Abstract.Human;
import Actions.Sitable;
public class Queen extends Human{
    public Queen(String name, boolean gender, int appetite){
        super(name, gender, appetite);
    }

    @Override
    public void waiting(){
        this.setAppetite(0);
    }

    public void anonymousSitable(Sitable instance){
        instance.sit();
    }

    public String sit(){
        anonymousSitable(new Sitable() {
            @Override
            public void sit() {
                waiting();
            }
        });
        return " уже сидели на троне, ";
    }
}
