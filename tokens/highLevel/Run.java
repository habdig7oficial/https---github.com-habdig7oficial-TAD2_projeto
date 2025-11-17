package tokens.highLevel;

import java.util.Iterator;

import lib.DataStructs.LinkedList;
import tokens.BaseToken;
import tokens.asm.Instruction;

public class Run extends BaseHighLevel {
    public Run(String name, short argsMin, short argsMax, LinkedList<Instruction> asmList){
        super(name, argsMax, argsMax, asmList);
    }

    private final int regNum = 26;

    @Override
    protected void callMethod(String... args) {

        int[] memory = new int[this.regNum];
        int ptr;

        Iterator<Instruction> iter = getAsmList().iterator();
        for (int i = 0; iter.hasNext(); i++) {
            Instruction e = iter.next();
            try {
                ptr = Instruction.translateAddr(e.getArgs()[0].charAt(0));
                e.exec(memory, ptr);
                System.out.println(ptr);
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            System.out.println(e);
            for (int j : memory) 
                System.out.print(j + " ");
                        System.out.println("\n");
        }

        for (int i : memory) 
            System.out.print(i + " ");
        System.out.println("\n");
        
    }
}
