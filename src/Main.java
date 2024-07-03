import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exceptions.ErroConsultaGitHubException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Consulta Usuário Github!");

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do usuário: ");
        String user = sc.nextLine();
        sc.close();

        user = user.replace(" ", "").toLowerCase().trim();

        String endereco = "https://api.github.com/users/" + user;
        System.out.println(endereco);

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .header("Accept", "application/vnd.github+json")
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            if (response.statusCode() == 404){
                throw new ErroConsultaGitHubException("Não foi possível consultar este usuário!");
            }
            System.out.println(json);
            System.out.println();

            Gson gson = new GsonBuilder().setLenient().create();
            UserRecord userRecord = gson.fromJson(json, UserRecord.class);
            System.out.println(userRecord);

        } catch (ErroConsultaGitHubException e){
            System.out.println(e.getMessage());
        } catch (IOException | InterruptedException e) {
            System.out.println("Opss... Houve um erro durante a consulta à API do Github.");
        }
    }
}