
package main;

public class ErroConsultaGitHubException extends RuntimeException{
    String message;

    public ErroConsultaGitHubException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
