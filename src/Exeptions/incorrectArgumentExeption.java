package Exeptions;

public class incorrectArgumentExeption {
    private String argument;

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return "incorrectArgumentExeption{" +
                "argument='" + argument + '\'' +
                '}';
    }
}
