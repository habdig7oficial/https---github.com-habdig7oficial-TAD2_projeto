package tokens.highLevel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import lib.DataStructs.LinkedList;
import tokens.BaseToken;
import tokens.asm.Instruction;

public class Save extends BaseHighLevel {
    private StringBuilder path;
    public Save(String name, short argsMin, short argsMax, LinkedList<Instruction> asmList, StringBuilder path){
        super(name, argsMin, argsMax, asmList);
        this.path = path;
    }

    @Override
    protected void callMethod(String... args) throws Exception {
        if(args.length > 0){
            path.setLength(0);
            path.append(args[0]);
        }
        else{
            if (path.length() == 0)
                throw new Exception("No file provided");

            Scanner io = new Scanner(System.in);
            do {
                System.out.print("Overwrite file y/n: ");
                char line = io.next().charAt(0);
                if (line == 'y') {
                    System.out.println("Writing File...");
                    break;
                }
                else if (line == 'n'){
                    System.out.println("File not Modified");
                    return;
                }
                System.out.println(line);
            } while (true);
        }
        
        PrintWriter writer;
        try {
            writer = new PrintWriter(new File(this.path.toString()));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(String.format("File %s was not find\nSearch on dir %s", args[0], System.getProperty("user.dir")));
        }

        Instruction last = null;
        for (Instruction asmInstruction : getAsmList()) {
            int blankSpace = asmInstruction.getLineNumber() - (last != null? last.getLineNumber() : 0);
            while (blankSpace > 1) {
                writer.print("\n");
                blankSpace--;
            }
            writer.println(asmInstruction);
            last = asmInstruction;
        }

        writer.close();
    }
}
