package tokens.asm;

import tokens.BaseToken;

abstract public class Instruction extends BaseToken {
    private int lineNumber;
    private String args[];
    public Instruction(String name, short argsMin, short argsMax, int lineNumber, String... args){
        super(name, argsMin, argsMax);
        this.lineNumber = lineNumber;
        this.args = args;
    }
    
    public int getLineNumber() {
        return lineNumber;
    }
    public String[] getArgs() {
        return args;
    }

    public int translateArg(int index, int[] memory) throws Exception{
        int value;
        try {
            value = Integer.parseInt(getArgs()[1]);
        }
        catch(NumberFormatException err){
            value = Instruction.translateAddr(getArgs()[1].charAt(0));
            value = memory[value];
        }
        return value;
    }

    public static int translateAddr(char reg) throws Exception {
        int addr = (int) reg - (int) 'a';

        if (addr < 0) {
            throw new Exception(String.format("Register %c in addr %d is invalid", reg, addr));
        }

        return addr;
    }

    abstract public void exec(int[] memory, int index) throws Exception;

    @Override
    public String toString() {
        String strBuilder = getName();

        for (String string : args) {
            strBuilder = String.format("%s %s", strBuilder, string);
        }

        return strBuilder;
    }
}
