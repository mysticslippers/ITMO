package Animated;

import Actions.Existable;
public class Crowd implements Existable{

    class Birdies{
        private final String name;

        public Birdies(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    class LittleAnimals{
        private final String name;

        public LittleAnimals(String name){
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    class Cards{
        private final String name;

        public Cards(String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    Birdies birdies = new Birdies("пичужки");
    LittleAnimals littleAnimals = new LittleAnimals("зверюшки всех пород");
    Cards cards = new Cards("карты всех мастей");

    @Override
    public String exist(){
        return "а кругом собралась огромная толпа: " + birdies.getName() + ", " + littleAnimals.getName() + ", " + "не говоря уже о " + cards.getName().replace("карты", "картах") + ".";
    }
}
