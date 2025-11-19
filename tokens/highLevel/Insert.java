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

Node<Instruction> newNode = new Node<>(newInstruction);
Node<Instruction> head = getAsmList().getFirst();

                if (head == null) {
                    getAsmList().setRoot(newNode);
                    return;
                }

                Node<Instruction> curr = head;
                Node<Instruction> prev = null;

                while (curr != null && curr.getElement().getLineNumber() < lineNumber) {
                    prev = curr;
                    curr = curr.getNext();
                }

                if (curr != null && curr.getElement().getLineNumber() == lineNumber) {
                    curr.setElement(newInstruction);
                    System.out.println("Line updated");
                    return;
                }

                if (prev == null) {
                    newNode.setNext(head);
                    getAsmList().setRoot(newNode);
                    System.out.println("Inserted at the beginning");
                    getAsmList().setLength(getAsmList().getLength() + 1);
                    return;
                }

                if (curr != null) {
                    prev.setNext(newNode);
                    newNode.setNext(curr);
                    System.out.println("Inserted in the middle");
                    getAsmList().setLength(getAsmList().getLength() + 1);
                    return;
                }

                if (curr == null) {
                    prev.setNext(newNode);
                    getAsmList().setLeaf(newNode);             
                    System.out.println("Inserted at the end");
                    getAsmList().setLength(getAsmList().getLength() + 1);
                    return;
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
