package main;

import java.util.Scanner;

public class Main2 {
 public static void main(String[] args) {
    System.out.println("Digiti uma senha valida com ao menos 8 caractees:");
    var scan = new Scanner(System.in);
    
    try{
        String senha = scan.nextLine();
        validarSenha(senha);
    }catch(SenhaInvalidaException e){
        System.out.println(e.getMessage());
    }
    
 }

 public static void validarSenha(String senha){
    if(!(senha.length() >= 8))
    throw new SenhaInvalidaException("Senha menor do que 8.");
 }
}
