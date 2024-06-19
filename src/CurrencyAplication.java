import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitor = new Scanner(System.in);

        int opcao;
        String segundaMoeda;
        while (true) {
            System.out.println("***************************************************");
            System.out.println("Seja bem-vindo(a) ao Conversor de Moeda!");
            System.out.println(
                    """
                            [1] DOLAR (USD)
                            [2] EURO (EUR)
                            [3] REAL (BRL)
                            [4] DOLAR AUSTRALIANO (AUD)
                            [5] DOLAR CANADENSE (CAD)
                            [6] RUBLO (RUB)
                            [7] Sair
                            """
            );
            System.out.println("***************************************************");

            System.out.println("Selecione uma opção válida: ");
            opcao = leitor.nextInt();
            if (opcao == 7) {
                break;
            }
            String parMoeda = "";
            int resultado;
            switch (opcao) {
                case 1:
                parMoeda = "USD";
                case 2:
                parMoeda = "EUR";
                case 3:
                parMoeda = "BRL";
                case 4:
                parMoeda = "AUD";
                case 5:
                parMoeda = "CAD";
                case 6:
                parMoeda = "RUB";
            };

        }
    }
    }

