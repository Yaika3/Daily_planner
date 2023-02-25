package Exeptions;

 public class IncorrectArgumentExeption extends Exception {

     private String argument;

    public IncorrectArgumentExeption(String argument) {
        this.argument = argument;
    }
    public String getArgument(){return argument;}

     @Override
     public String toString() {
         return "IncorrectArgumentExeption{" +
                 "argument='" + argument + '\'' +
                 '}';
     }
 }
