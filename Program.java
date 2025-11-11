import java.util.Scanner;
import tokens.*;

public class Program {
    private static Scanner io = new Scanner(System.in);

    private static boolean search(BaseToken arr[], String element){
        for (BaseToken i : arr) {
            //System.out.println(element);
            if(i.equals(element))
                return true;
        }
        return false;
    }

    private static BaseToken tokens[] = {
        new Load("LOAD"),
        new List("LIST"),
        new Run("RUN"),
        new Insert("INS"),
        new Delete("DEL"),
        new Save("SAVE"),
        new Exit("EXIT")
    };

    public static void main(String[] args) {
       while (true) {
            System.out.print("> ");
            String input[] = io.nextLine().toUpperCase().split("\s");

            for (String i : input) {
               if(search(tokens, i.trim())){
                    System.out.println("true");
               }
               else 
                    System.out.println("false");
            }
       }
    }
}