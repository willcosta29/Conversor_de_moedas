package principal;

import service.ConverteMoeda;

import java.util.Scanner;

public class Principal {
    private final Scanner leitor = new Scanner(System.in);
    private Integer opcao;
    private double valor;

    public void exibeMenu() {
        while (true) {
            opcao = 0;
            System.out.println("***************************************************");
            System.out.println("Seja bem-vindo(a) ao Conversor de Moeda!");
            System.out.println(
                    """
                            [1] DOLAR -> REAL
                            [2] REAL -> DOLAR
                            [3] EURO -> REAL
                            [4] REAL -> EURO
                            [5] DOLAR AUSTRALIANO -> REAL
                            [6] REAL -> DOLAR AUSTRALIANO
                            [7] DOLAR CANADENSE -> REAL
                            [8] REAL -> DOLAR CANADENSE
                            [9] SAIR
                            """
            );
            System.out.println("***************************************************");


            int contador = 0;
            while (opcao < 1 || opcao > 9) {

                if(contador >= 1) {
                    System.out.println("[" + contador + "]" + "Valor incorreto!!!");
                }

                System.out.println("Selecione uma opção válida: ");
                opcao = leitor.nextInt();

                contador++;
            }
            if(opcao.equals(9)) {
                break;
            }
            System.out.println("Digite o valor que deseja converter: ");
            valor = leitor.nextDouble();

            ConverteMoeda converteMoeda = new ConverteMoeda(opcao);
            converteMoeda.selecionarMoedas();
            converteMoeda.converterMoeda();
            converteMoeda.setValor(valor);
            converteMoeda.calcular();
            }
        }
    }
