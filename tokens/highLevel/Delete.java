package tokens.highLevel;

import lib.DataStructs.*;
import tokens.BaseToken;
import tokens.asm.Instruction;

public class Delete extends BaseHighLevel {
    public Delete(String name, short argsMin, short argsMax, LinkedList<Instruction> asmList){
        super(name, argsMin, argsMax, asmList);
    }

    @Override
    protected void callMethod(String... args) throws Exception {
        
        if (args.length == 1) {
            int line = Integer.parseInt(args[0]);

            if (getAsmList().getLength() == 0) {
                throw new Exception("File empty!");
            } else if (line > getAsmList().getLast().getElement().getLineNumber())
                throw new Exception("Invalid line!");

            Node<Instruction> firstLine = this.getAsmList().getFirst();            
            if (line == firstLine.getElement().getLineNumber()) {
                if (firstLine.getNext() == null) {                    
                    getAsmList().clean(); 
                }{
                    var next = firstLine.getNext();
                    firstLine.setElement(next.getElement());
                    firstLine.setNext(next.getNext());
                }
            }

             Node<Instruction> lastLine = this.getAsmList().getLast();
             if (line == lastLine.getElement().getLineNumber()) {
               //(lastLine.getElement().getLineNumber() - 1)
                //getAsmList().setLeaf(getAsmList().getElement().getNext());

             }

        } /*else if(args.length == 2) {

        }*/
    }
}
