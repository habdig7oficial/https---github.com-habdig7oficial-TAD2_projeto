package tokens.asm;

public class Add extends Instruction {
    public Add(String name, int lineNumber, String ...args) {
        super(name, (short) 2, (short) 2, lineNumber, args);
    }

    @Override
    protected void callMethod(String... args) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'callMethod'");
    }
}
