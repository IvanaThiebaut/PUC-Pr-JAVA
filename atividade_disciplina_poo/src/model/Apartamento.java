package model;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Apartamento extends Financiamento {

    private double aptoTaxaMensal = this.taxaJurosAnual / 12 ;
    private double aptoMeses = this.prazoFinanciamento * 12;
    private int vagasGaragem;
    private int numeroAndar;


    public Apartamento(double taxaJurosAnual, double valorImovel, int prazoFinanciamento, int vagasGaragem, int numeroAndar) {
        super(taxaJurosAnual, valorImovel, prazoFinanciamento);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }


    public double pagamentoMensal() {
        double pagMensal = ((this.getValorImovel() * aptoTaxaMensal) * (Math.pow((1 + aptoTaxaMensal), (aptoMeses)))) / (Math.pow((1 + aptoTaxaMensal), aptoMeses) - 1);
        return pagMensal;
    }

    // le a quantidade de vagas que o apartamento possui e verifica o valor inserido pelo usuário
    public static int lerVagasGaragem() {
        Scanner sc6 = new Scanner(System.in);
        int vagasGaragem = 0;
        while (true) {
            try {
                System.out.println("Digite o numero de vagas do apartamento: ");
                vagasGaragem = sc6.nextInt();

                if (vagasGaragem < 0) {
                    System.out.println("Valor inválido. Numero de vagas não pode ter valor negativo, digite outro valor.");
                } else {
                    System.out.println("O número de vagas do apartamento é: " + vagasGaragem);
                    break;
                }
            } catch (InputMismatchException e){
                System.out.println("Entrada inválida. Digite um valor numérico válido.");
                sc6.next();
            }
        }
        return vagasGaragem;
    }

    // le o andar do apartamento e verifica o valor inserido pelo usuário
    public static int lerNumeroAndar() {
        Scanner sc7 = new Scanner(System.in);
        int numeroAndar = 0;
        while (true) {
            try {
                System.out.println("Digite o número do andar: ");
                numeroAndar = sc7.nextInt();

                if (numeroAndar < 0) {
                    System.out.println("Valor inválido. Andar não pode ter valor negativo, digite outro valor.");
                } else {
                    System.out.println("O número do andar do apartamento é: " + numeroAndar);
                    break;
                }
            } catch (InputMismatchException e){
                System.out.println("Entrada inválida. Digite um valor válido.");
                sc7.next();
            }
        }
        return numeroAndar;
    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00"); // Define o formato com duas casas decimais
        String pagamentoMensalFormat = df.format(pagamentoMensal()); // Formata o pagamento mensal
        String totalPagamentoFormat = df.format(totalPagamento()); // Formata o pagamento total
        return "Para imóvel apartamento, com "
                + vagasGaragem
                + " vagas de garagem e localizado no "
                + numeroAndar
                + "° andar, o valor mensal a ser pago será de: R$"
                + pagamentoMensalFormat
                + " e o pagamento total será de: R$ "
                + totalPagamentoFormat
                + ". "
                + "O valor do imóvel a ser financiado é: R$"
                + valorImovel
                + " e o prazo de financiamento é de "
                + prazoFinanciamento
                + " anos.";
    }
}
