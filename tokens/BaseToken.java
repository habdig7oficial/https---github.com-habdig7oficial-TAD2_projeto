package tokens;

public abstract class BaseToken{
    private String name;

    BaseToken(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.printf("%s - %s\n", obj, this.name);
        if (obj == this) {
            return true;
        }
        else if (this.name.equals((String) obj)) {
            return true;
        }
        else if (!(obj instanceof BaseToken)) {
            return false;
        }
        else if (BaseToken.class.cast(obj).getName() == this.name) {
            return true;
        }
        else {
            return false;
        }
    }
}