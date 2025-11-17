package tokens.asm;

public class Dec extends Instruction {
    public Dec(String name, int lineNumber, String ...args) {
        super(name, (short) 2, (short) 2, lineNumber, args);
    }

    @Override
    protected void callMethod(String... args) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'callMethod'");
    }

    @Override
    public void exec(int[] memory, int index) {
        memory[index]--;
    }
}
