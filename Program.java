import java.util.Arrays;
import java.util.Scanner;
import tokens.*;
import java.util.Arrays.*;

public class Program {
    private static Scanner io = new Scanner(System.in);

    private static short search(BaseToken arr[], String element){
        for (short i = 0; i < arr.length; i++) {
            //System.out.println(element);
            if(arr[i].equals(element))
                return i;
        }
        return -1;
    }

    private static BaseToken tokens[] = {
        new Load("LOAD", (short) 1,(short) 1),
        new List("LIST", (short) 0, (short) 0),
        new Run("RUN", (short) 0, (short) 0),
        new Insert("INS", (short) 2, (short) 2),
        new Delete("DEL", (short) 1, (short) 2),
        new Save("SAVE", (short) 0, (short) 1),
        new Exit("EXIT", (short) 0, (short) 0)
    };

    // Nicht Vergiss die Exception im Main beseitigen
    public static void main(String[] args) {
       while (true) {
            System.out.print("> ");
            String input[] = io.nextLine().toUpperCase().split("\s");

            for (int i = 0; i < input.length; i++) {
               short location = search(tokens, input[i].trim());
               if(location != -1){
                    try {
                        tokens[location].call(Arrays.copyOfRange(input, i + 1, input.length));
                    } catch (Exception e) {
                        System.out.println("--- ERROR ---\n" + e.getMessage());
                    }
               }
               else 
                    System.out.println("false");
            }
       }
    }
}