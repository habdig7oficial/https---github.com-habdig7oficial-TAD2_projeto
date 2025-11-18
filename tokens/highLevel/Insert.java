package tokens.highLevel;

import java.util.Arrays;

import lib.Searcher;
import lib.DataStructs.LinkedList;
import tokens.BaseToken;
import tokens.asm.Add;
import tokens.asm.Dec;
import tokens.asm.Div;
import tokens.asm.Inc;
import tokens.asm.Instruction;
import tokens.asm.InstructionSet;
import tokens.asm.Jnz;
import tokens.asm.Mov;
import tokens.asm.Mul;
import tokens.asm.Out;
import tokens.asm.Sub;

public class Insert extends BaseHighLevel {
    public Insert(String name, short argsMin, short argsMax, LinkedList<Instruction> asmList){
        super(name, argsMax, argsMax, asmList);
    }

    @Override
    protected void callMethod(String... args) {
        Searcher<Instruction, String> s = new Searcher<Instruction, String>();

        short location = s.search(InstructionSet.instructionSet, args[0].trim().toUpperCase());
        if(location != -1){
            try {
                Instruction newInstruction = null;
                switch (InstructionSet.instructionSet[location]) {
                    case Mov n:
                            newInstruction = new Mov(n.getName(), i, Arrays.copyOfRange(asmCommands, 1, asmCommands.length));
                        break;
                    case Inc n:
                            newInstruction = new Inc(n.getName(), i, Arrays.copyOfRange(asmCommands, 1, asmCommands.length));
                        break;
                    case Dec n:
                            newInstruction = new Dec(n.getName(), i, Arrays.copyOfRange(asmCommands, 1, asmCommands.length));
                        break;
                    case Add n:
                            newInstruction = new Add(n.getName(), i, Arrays.copyOfRange(asmCommands, 1, asmCommands.length));
                        break;
                    case Sub n:
                            newInstruction = new Sub(n.getName(), i, Arrays.copyOfRange(asmCommands, 1, asmCommands.length));
                        break;
                    case Mul n:
                            newInstruction = new Mul(n.getName(), i, Arrays.copyOfRange(asmCommands, 1, asmCommands.length));
                        break;
                    case Div n:
                            newInstruction = new Div(n.getName(), i, Arrays.copyOfRange(asmCommands, 1, asmCommands.length));
                        break;
                    case Jnz n:
                            newInstruction = new Jnz(n.getName(), i, Arrays.copyOfRange(asmCommands, 1, asmCommands.length));
                        break;
                    case Out n:
                            newInstruction = new Out(n.getName(), i, Arrays.copyOfRange(asmCommands, 1, asmCommands.length));
                        break;
                    default:
                }
                this.getAsmList().append(newInstruction);
                System.out.println(newInstruction);
            } 
            catch (Exception e) {
                        System.out.println("--- ERROR ---\n" + e.getMessage());
            }
        }
        else
            System.out.println("--- ERROR ---\nInvalid Command!");
    }
}
