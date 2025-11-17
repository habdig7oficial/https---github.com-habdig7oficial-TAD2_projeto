package tokens.asm;

public class Mov extends Instruction {
    public Mov(String name, int lineNumber, String ...args) {
        super(name, (short) 2, (short) 2, lineNumber, args);
    }
    @Override
    protected void callMethod(String... args) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'callMethod'");
    }
    @Override
    public void exec(int[] memory, int index) throws Exception {
        memory[index] = translateArg(1, memory);
    }
}
