package tokens.asm;

import java.util.Iterator;

import lib.DataStructs.LinkedList;
import lib.DataStructs.Node;

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
    public Iterator<Instruction> exec(int[] memory, int index, LinkedList<Instruction> list, Iterator<Instruction> iter) {
        if (memory[index] == 0) 
            return iter;
        System.out.println(String.format("i: %d\n arg1: %d", memory[index], Integer.parseInt(getArgs()[1])));
        Iterator<Instruction> newIterator = list.iterator();
        for (int i = 0; newIterator.hasNext() && i < Integer.parseInt(getArgs()[1]) - 1; i++){
            var a = newIterator.next();
           // System.out.println("\t" + a + "\t" + i);
        } 
            


        return newIterator;
    }
}
