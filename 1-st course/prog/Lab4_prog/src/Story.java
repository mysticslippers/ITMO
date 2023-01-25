import Animated.*;
import Exceptions.JudgeNotFoundException;
import Inanimated.*;
import Enums.Paws;
import Actions.Lookable;

public class Story{
    public static void main(String[] args) throws JudgeNotFoundException {
        King king = new King("Король", false, 100);
        Queen queen = new Queen("Королева", true, 100);
        Alice alice = new Alice("Алиса", true, 100);
        JackOfHearts jackOfHearts = new JackOfHearts("Червонный Валет");
        JackOfHearts.FirstSecurityGuard firstSecurityGuard = jackOfHearts.new FirstSecurityGuard("один");
        Crowd crowd = new Crowd();
        WhiteRabbit whiteRabbit = new WhiteRabbit("Кролик", "Коричневый");
        Griffon griffon = new Griffon("Грифон", "коричневый", 100);
        Table table = new Table("стол");
        Dish dish = new Dish("блюдо");
        Pies pies = new Pies("пирожки");

        king.waiting();
        alice.waiting();

        /*
        #1
        Lookable lookable;
        lookable = () -> ", и вид у них был такой аппетитный, что у ";
         */

        /*
        #2
        Lookable lookable;
        lookable = pie::look;
         */

        System.out.println(alice.arrive() + griffon.getName().replace("Грифон", "Грифоном") + " прибежали.");
        System.out.println(king.getName() + " и " + queen.getName() + queen.sit() + crowd.exist());
        System.out.println(jackOfHearts.stay() + firstSecurityGuard.getName() + firstSecurityGuard.stay() + JackOfHearts.SecondSecurityGuard.getName() + JackOfHearts.SecondSecurityGuard.protect() + jackOfHearts.getName() + ".");
        System.out.println(king.exist() + king.getName().replace("ь", "я") + whiteRabbit.exist() + whiteRabbit.changeFur() + " " + whiteRabbit.getName() + ", " + Paws.Right.hold() + Paws.Right.getName() + Paws.Left.hold() + Paws.Left.getName() + ".");
        System.out.println(table.stay() + table.getName() + "," + dish.stay() + dish.getName() + " с " + pies.getName().replace("ки", "ками") + pies.look() + alice.getName().replace("а", "ы") + alice.getCondition());
        System.out.println(alice.Dream());
        System.out.println(alice.timeSkip() + alice.consider());
        System.out.println(alice.notToBe() + alice.learn());
        try{
            alice.guessJudge();
        }
        catch(JudgeNotFoundException exception){
            System.out.println("После того как судья переодел парик, " + alice.getName() + " поняла. " + alice.guessJudge());
        }
    }
}
