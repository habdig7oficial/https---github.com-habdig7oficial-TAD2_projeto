package tokens.highLevel;

import java.util.Arrays;

import lib.Searcher;
import lib.DataStructs.LinkedList;
import lib.DataStructs.Node;
import tokens.BaseToken;
import tokens.asm.*;


public class Insert extends BaseHighLevel {
    public Insert(String name, short argsMin, short argsMax, LinkedList<Instruction> asmList){
        super(name, argsMin, argsMax, asmList);
    }

    @Override
    protected void callMethod(String... args) {
        for (String string : args) {
            System.out.println(string);
        }
        Searcher<Instruction, String> s = new Searcher<Instruction, String>();

        short location = s.search(InstructionSet.instructionSet, args[1].trim().toUpperCase());
        int lineNumber = Integer.parseInt(args[0]);
        if(location != -1){
            try {
                Instruction newInstruction = null;
                switch (InstructionSet.instructionSet[location]) {
                    case Mov n:
                            newInstruction = new Mov(n.getName(), lineNumber, Arrays.copyOfRange(args, 2, args.length));
                        break;
                    case Inc n:
                            newInstruction = new Inc(n.getName(), lineNumber, Arrays.copyOfRange(args, 2, args.length));
                        break;
                    case Dec n:
                            newInstruction = new Dec(n.getName(), lineNumber, Arrays.copyOfRange(args, 2, args.length));
                        break;
                    case Add n:
                            newInstruction = new Add(n.getName(), lineNumber, Arrays.copyOfRange(args, 2, args.length));
                        break;
                    case Sub n:
                            newInstruction = new Sub(n.getName(), lineNumber, Arrays.copyOfRange(args, 2, args.length));
                        break;
                    case Mul n:
                            newInstruction = new Mul(n.getName(), lineNumber, Arrays.copyOfRange(args, 2, args.length));
                        break;
                    case Div n:
                            newInstruction = new Div(n.getName(), lineNumber, Arrays.copyOfRange(args, 2, args.length));
                        break;
                    case Jnz n:
                            newInstruction = new Jnz(n.getName(), lineNumber, Arrays.copyOfRange(args, 2, args.length));
                        break;
                    case Out n:
                            newInstruction = new Out(n.getName(), lineNumber, Arrays.copyOfRange(args, 2, args.length));
                        break;
                    default:
                }
                Node<Instruction> e = getAsmList().getFirst();

                while (e.getNext() != null && e.getElement().getLineNumber() < e.getNext().getElement().getLineNumber())
                    e = e.getNext();

                if (e.getNext() != null && e.getElement().getLineNumber() == e.getNext().getElement().getLineNumber()){
                    e.setElement(newInstruction);
                    System.out.println("Line updated");
                }


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
