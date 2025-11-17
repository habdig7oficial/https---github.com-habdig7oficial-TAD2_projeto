/*
 * Mateus Felipe da Silveira Vieira - 10723904
 * Rayana Pimentel Lopes - 10435370
 */

import java.util.Arrays;
import java.util.Scanner;

import lib.DataStructs.LinkedList;
import lib.Searcher;
import tokens.*;
import tokens.asm.Instruction;
import tokens.highLevel.*;

import java.util.Arrays.*;
import java.io.File;

public class Program {
    private static Scanner io = new Scanner(System.in);

    private static LinkedList<Instruction> asmList = new LinkedList<>();

    private static StringBuilder filePtr = new StringBuilder();

    private static BaseHighLevel tokens[] = {
        new Load("LOAD", (short) 1,(short) 1, asmList, filePtr),
        new List("LIST", (short) 0, (short) 0, asmList),
        new Run("RUN", (short) 0, (short) 0, asmList),
        new Insert("INS", (short) 2, (short) 2, asmList),
        new Delete("DEL", (short) 1, (short) 2, asmList),
        new Save("SAVE", (short) 0, (short) 1, asmList, filePtr),
        new Exit("EXIT", (short) 0, (short) 0, asmList)
    };

    public static void main(String[] args) {
       while (true) {
            System.out.print("> ");
            String input[] = io.nextLine().split("\s");

            Searcher<BaseToken, String> s = new Searcher<BaseToken, String>();

            short location = s.search(tokens, input[0].trim().toUpperCase()); 
            if(location != -1){
                try {
                    tokens[location].call(Arrays.copyOfRange(input, 1, input.length));
                } catch (Exception e) {
                    System.out.println("--- ERROR ---\n" + e.getMessage());
                }
            }
            else 
                System.out.println("--- ERROR ---\nInvalid Command!");
            
       }
    }
}