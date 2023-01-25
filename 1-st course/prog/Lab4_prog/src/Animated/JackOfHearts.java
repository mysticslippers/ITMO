package Animated;

import Actions.Stayable;
public class JackOfHearts implements Stayable{
    private final String name;

    public JackOfHearts(String name){
        this.name = name;
    }
    public class FirstSecurityGuard implements Stayable{
        private final String name;

        public FirstSecurityGuard(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        @Override
        public String stay(){
            return " справа, ";
        }
    }

    public static class SecondSecurityGuard{
        private static final String name = "другой";

        public static String getName() {
            return name;
        }

        public static String protect(){
            return " - слева - ";
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String stay(){
        return "Перед судейским троном стоял в цепях под охраной двух солдат - ";
    }
}
