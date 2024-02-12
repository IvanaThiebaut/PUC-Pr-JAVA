package model;

import java.io.Serializable;
import java.text.DecimalFormat;

public abstract class Financiamento implements Serializable {

    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public double getValorImovel() { //criei para conseguir calcular o total dos valores dos imoveis
        return valorImovel;
    }

    public Financiamento(double taxaJurosAnual, double valorImovel, int prazoFinanciamento){
        this.taxaJurosAnual = taxaJurosAnual;
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
    }
// a formula que é fornecida na descriçao do trabalho eu vi que estava dando resultado errado.
    //fiz modificações para que ela funcionasse.

    public double pagamentoMensal() {
        double pagMensal = ((valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12)));
        return pagMensal;
    }

    public double totalPagamento() {
        double pagTotal = pagamentoMensal() * (prazoFinanciamento * 12);
        return pagTotal;
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00"); // Define o formato com duas casas decimais
        String pagamentoMensalFormat = df.format(pagamentoMensal()); // Formata o pagamento mensal
        String totalPagamentoFormat = df.format(totalPagamento()); // Formata o pagamento total
        return "O valor mensal a ser pago será de: R$"
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
