package tokens.highLevel;

import java.lang.reflect.Constructor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import lib.Searcher;
import lib.DataStructs.LinkedList;
import tokens.BaseToken;
import tokens.asm.*;

public class Load extends BaseHighLevel {
    private StringBuilder path;
    public Load(String name, short argsMin, short argsMax, LinkedList<Instruction> asmList, StringBuilder path){
        super(name, argsMax, argsMax, asmList);
        this.path = path;
    }

    @Override
    protected void callMethod(String... args) throws Exception {
        String currentDir = System.getProperty("user.dir");

        Scanner scanFile;
        try {
            this.path.append(args[0]);
            scanFile = new Scanner(new File(this.path.toString()));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(String.format("File %s was not find\nSearch on dir %s", args[0], currentDir));
        }


        for (int i = 0; scanFile.hasNextLine(); i++) {
            String line = scanFile.nextLine();
            if (!line.isEmpty()) {

                String asmCommands[] = line.split("\s");

                Searcher<Instruction, String> s = new Searcher<Instruction, String>();

                short location = s.search(InstructionSet.instructionSet, asmCommands[0].trim().toUpperCase());
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
                    } catch (Exception e) {
                        System.out.println("--- ERROR ---\n" + e.getMessage());
                    }
                }
                else 
                    System.out.println("--- ERROR ---\nInvalid Command!");

                System.out.println(asmCommands[0].trim());

                //this.getAsmList().append();
            }
                
            //System.out.println(scanFile.nextLine());
        }

        System.out.println(this.getAsmList());
        System.out.println(currentDir + args[0]);

        scanFile.close();
    }
}
