package main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        var scan = new Scanner(System.in);
        System.out.println("Digite o usuario a ser pesquisado:");
        String usuario = scan.nextLine();

        String url = "https://api.github.com/users/"+usuario.replace(" ", "+");

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); 
            System.out.println(response.body());

            //fiquei confuso pq repeteiu isso mas faz sentido
            //primeiro ele gera a mensagem e ai da o erro, ai pra aplicacao n parar
            //ele boa no catch, assim da o erro e continua funcionando.
            if (response.statusCode() == 404){
                throw new ErroConsultaGitHubException("Usuario inexistente.");
            }
        }catch (IOException | InterruptedException e){
            System.out.println("Deu erro");
        }catch (ErroConsultaGitHubException e){
            System.out.println(e.getMessage());
        }
    }
}
