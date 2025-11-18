package tokens.highLevel;

import lib.DataStructs.LinkedList;
import tokens.BaseToken;
import tokens.asm.Instruction;

public class Delete extends BaseHighLevel {
    public Delete(String name, short argsMin, short argsMax, LinkedList<Instruction> asmList){
        super(name, argsMax, argsMax, asmList);
    }

    @Override
    protected void callMethod(String... args) {
        /*
         * 
         *        
          int i = 0;
        if (args.length == 1) {
            int line = Integer.parseInt(args[0]);

            if (getAsmList().getLength() == 0) {
                throw new Exception(e.getMessage("File empty!"));
            }

            

        }
        else if (args.length == 2){
            
        }
         */
    }
}
