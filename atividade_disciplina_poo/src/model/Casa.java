package model;

import java.text.DecimalFormat;

public class Casa extends Financiamento {

    private int seguroObrigatorio = 80;
    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double taxaJurosAnual, double valorImovel, int prazoFinanciamento, double areaConstruida, double tamanhoTerreno) {
        super(taxaJurosAnual, valorImovel, prazoFinanciamento);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public double pagamentoMensal() {
        return super.pagamentoMensal() + seguroObrigatorio;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00"); // Define o formato com duas casas decimais
        String pagamentoMensalFormat = df.format(pagamentoMensal()); // Formata o pagamento mensal
        String totalPagamentoFormat = df.format(totalPagamento()); // Formata o pagamento total
        return "Para imóvel casa, com área construída de "
                + areaConstruida
                + " e terreno de tamanho "
                + tamanhoTerreno
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