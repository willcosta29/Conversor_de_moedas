package consumoApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverteDados {

    public void obterDados {
        String chaveApi = "205b89d08d532047dc335e7f";
        String endereco = "https://v6.exchangerate-api.com/v6/" + chaveApi + "/latest/" + moeda;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()  //Requisição de dados da API
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = null;

        try {
            response = client       //Resposta de dados da API
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();  //tratamento do json com a biblioteca GSON
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        System.out.println(json);

        Moeda moeda = new Moeda();
        Moeda moeda0 = gson.fromJson(json, Moeda.class);
    }
}
