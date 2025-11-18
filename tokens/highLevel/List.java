package tokens.highLevel;

import java.util.Iterator;
import java.util.Scanner;

import lib.DataStructs.LinkedList;
import tokens.BaseToken;
import tokens.asm.Instruction;

public class List extends BaseHighLevel {
    public List(String name, short argsMin, short argsMax, LinkedList<Instruction> asmList){
        super(name, argsMin, argsMax, asmList);
    }

    @Override
    protected void callMethod(String... args) {
        //System.out.println(this.getAsmList().getFirst().getElement());
        int c = 0;
        Scanner scanner = new Scanner(System.in);
        for (Instruction e : getAsmList()) {
            System.out.println(String.format("%d - %s", e.getLineNumber(), e));
            if (c == 20) {
                System.out.println("Digit any key to continue printing...");
                scanner.nextLine();
                c = 0;
            }
            c++;
        }
    }
}
