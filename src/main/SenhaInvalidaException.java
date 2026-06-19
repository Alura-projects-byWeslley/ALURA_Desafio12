package main;

public class SenhaInvalidaException extends RuntimeException{
    private String message;

    public SenhaInvalidaException(String message){
        super(message);
    }

}
