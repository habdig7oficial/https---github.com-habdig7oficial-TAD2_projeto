package tokens;

public class Load extends BaseToken {
    public Load(String name, short argsMin, short argsMax){
        super(name, argsMax, argsMax);
    }

    @Override
    void callMethod(String... args) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'callMethod'");
        System.out.println("Hello");
    }
}
