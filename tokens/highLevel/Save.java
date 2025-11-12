package tokens.highLevel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
        if(args[0] != null){
            path.setLength(0);
            path.append(args[0]);
        }
        
        PrintWriter writer;
        try {
            writer = new PrintWriter(new File(this.path.toString()));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(String.format("File %s was not find\nSearch on dir %s", args[0], System.getProperty("user.dir")));
        }

        for (Instruction asmInstruction : getAsmList()) {
            writer.println(asmInstruction);
        }

        writer.close();
    }

}
