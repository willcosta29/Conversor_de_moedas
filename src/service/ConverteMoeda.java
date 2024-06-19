package service;

import com.google.gson.Gson;
import model.Moeda;
import model.Moedas;

public class ConverteMoeda {

    private final String ENDERECO = "https://v6.exchangerate-api.com/v6/";
    private final String API_KEY = "205b89d08d532047dc335e7f";
    private final Integer OPCAO;
    private String primeiraMoedaURL;
    private String primeiraMoeda;
    private String segundaMoeda;
    private double valor;


    public ConverteMoeda (Integer opcao) {
        this.OPCAO = opcao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    Moeda moeda = new Moeda();

    public void selecionarMoedas() {
        Moedas moedas;

       switch (OPCAO) {
           case 1:
                primeiraMoedaURL = moeda.getUSD();
                moedas = converterMoeda();
                primeiraMoeda = moedas.conversion_rates().getUSD();
                segundaMoeda = moedas.conversion_rates().getBRL();
                break;
           case 2:
                primeiraMoedaURL = moeda.getBRL();
                moedas = converterMoeda();
                primeiraMoeda = moedas.conversion_rates().getBRL();
                segundaMoeda = moedas.conversion_rates().getUSD();
                break;
           case 3:
                primeiraMoedaURL = moeda.getEUR();
                moedas = converterMoeda();
                primeiraMoeda = moedas.conversion_rates().getEUR();
                segundaMoeda = moedas.conversion_rates().getBRL();
                break;
           case 4:
                primeiraMoedaURL = moeda.getBRL();
                moedas = converterMoeda();
                primeiraMoeda = moedas.conversion_rates().getBRL();
                segundaMoeda = moedas.conversion_rates().getEUR();
                break;
           case 5:
                primeiraMoedaURL = moeda.getAUD();
                moedas = converterMoeda();
                primeiraMoeda = moedas.conversion_rates().getAUD();
                segundaMoeda = moedas.conversion_rates().getBRL();
                break;
           case 6:
                primeiraMoedaURL = moeda.getBRL();
                moedas = converterMoeda();
                primeiraMoeda = moedas.conversion_rates().getBRL();
                segundaMoeda = moedas.conversion_rates().getAUD();
                break;
           case 7:
                primeiraMoedaURL = moeda.getCAD();
                moedas = converterMoeda();
                primeiraMoeda = moedas.conversion_rates().getCAD();
                segundaMoeda = moedas.conversion_rates().getBRL();
                break;
           case 8:
                primeiraMoedaURL = moeda.getBRL();
                moedas = converterMoeda();
                primeiraMoeda = moedas.conversion_rates().getBRL();
                segundaMoeda = moedas.conversion_rates().getCAD();
                break;
           default:
                System.out.println("Valor Incorreto!!!");
       }
    }

    public Moedas converterMoeda() {

        ConsumoApi consumo = new ConsumoApi();
        Gson gson = new Gson();
        String json = consumo.obterDados(ENDERECO + API_KEY + "/latest/" + primeiraMoedaURL);
        return gson.fromJson(json, Moedas.class);


    }

    public void calcular() {
        double resultado = valor * (Double.parseDouble(primeiraMoeda) * Double.parseDouble(segundaMoeda));
        System.out.println(resultado);
    }
}
