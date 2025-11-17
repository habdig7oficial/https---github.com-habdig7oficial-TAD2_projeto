package tokens.asm;

import java.util.Iterator;

import lib.DataStructs.LinkedList;

public class Jnz extends Instruction {
    public Jnz(String name, int lineNumber, String ...args) {
        super(name, (short) 2, (short) 2, lineNumber, args);
    }

    @Override
    protected void callMethod(String... args) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'callMethod'");
    }

    @Override
    public void exec(int[] memory, int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exec'");
    }
    public void exec(int index, LinkedList<Instruction> list, Iterator<Instruction> iter) {
        iter = list.iterateToIndex(index);
    }
}
