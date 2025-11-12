package tokens.asm;

public class InstructionSet {
    public static final Instruction instructionSet[] = {
        new Mov("MOV", 0),
        new Inc("INC", 0),
        new Dec("DEC", 0),
        new Add("ADD", 0),
        new Sub("SUB", 0),
        new Mul("MUL", 0),
        new Div("DIV", 0),
        new Jnz ("JNZ", 0),
        new Out("OUT", 0),
    };
}
