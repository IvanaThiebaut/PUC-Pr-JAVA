package model;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Terreno extends Financiamento {

    private String zona;

    public Terreno(double taxaJurosAnual, double valorImovel, int prazoFinanciamento, String zona) {
        super(taxaJurosAnual, valorImovel, prazoFinanciamento);
        this.zona = zona;
    }

    public static String lerZona() {
        Scanner sc9 = new Scanner(System.in);
        String zona;
        System.out.println("Em que zona está localizado o terreno? (RURAL/URBANA) ");
        zona = sc9.next();
        return zona;
    }

    @Override
    public double totalPagamento() {
        return super.totalPagamento();
    }

    public double pagamentoMensal() {
        return super.pagamentoMensal() * 1.02;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00"); // Define o formato com duas casas decimais
        String pagamentoMensalFormat = df.format(pagamentoMensal()); // Formata o pagamento mensal
        String totalPagamentoFormat = df.format(totalPagamento()); // Formata o pagamento total
        return "Para imóvel terreno, localizado em área de zona "
                + zona
                + ", o valor mensal a ser pago será de: R$"
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
