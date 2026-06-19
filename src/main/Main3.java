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
        }catch (IOException | InterruptedException e){
            System.out.println("Deu erro");
        }
    }
}
