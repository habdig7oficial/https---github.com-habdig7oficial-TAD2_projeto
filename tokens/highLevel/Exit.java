package tokens.highLevel;

import lib.DataStructs.LinkedList;
import tokens.BaseToken;
import tokens.asm.Instruction;

public class Exit extends BaseHighLevel {
    public Exit(String name, short argsMin, short argsMax, LinkedList<Instruction> asmList){
        super(name, argsMin, argsMax, asmList);
    }

    @Override
    protected void callMethod(String... args) {
        System.out.println("Danke Schön!\nAuf wiedersehen");
        System.exit(0);
    }
}
