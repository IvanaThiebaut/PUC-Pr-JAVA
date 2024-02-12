// Trabalho POO - Ivana Thiebaut

package main;

import model.*;
import utilities.InterfaceUsuario;
import model.Casa;
import model.Financiamento;


public class Main {

    public static void main(String[] args) {

        InterfaceUsuario inter = new InterfaceUsuario();

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("FINANCIAMENTOS");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("DIGITE OS DADOS DO PRIMEIRO IMÓVEL: "); //pedi o primeiro imovel como solicitado no enunciado.
        System.out.println();

        double valorImovel = inter.lerValorImovel();
        System.out.println("--------------------------");
        double taxaJurosAnual = inter.lerTaxaJuros();
        System.out.println("--------------------------");
        int prazoFinanciamento = inter.lerPrazoFinanciamento();
        System.out.println("--------------------------");
        System.out.println();

        //primeiro imovel inserido via teclado e o usuario escolhe o tipo de financiamento.

        Financiamento imovel1 = null;

        int x = inter.selecionarTipo();
        if (x == 1) {
            double areaConstruida = inter.lerareaConstruida();
            double tamanhoTerreno = inter.lertamanhoTerreno();
            imovel1 = new Casa(taxaJurosAnual, valorImovel, prazoFinanciamento, areaConstruida, tamanhoTerreno);
            imovel1.pagamentoMensal();
            imovel1.totalPagamento();
        } else if (x == 2) {
            int vagasGaragem = Apartamento.lerVagasGaragem();
            int numeroAndar = Apartamento.lerNumeroAndar();
            imovel1 = new Apartamento(taxaJurosAnual, valorImovel, prazoFinanciamento, vagasGaragem, numeroAndar);
            imovel1.pagamentoMensal();
            imovel1.totalPagamento();
        } else if (x == 3) {
            String zona = Terreno.lerZona();
            imovel1 = new Terreno(taxaJurosAnual, valorImovel, prazoFinanciamento, zona);
            imovel1.pagamentoMensal();
            imovel1.totalPagamento();
        } else {
            System.out.println("Digite um tipo válido.");
        }

        //os proximos imoveis são inseridos diretamente no codigo

        Casa casa2 = new Casa(10,250000,20, 300, 1000);
        casa2.pagamentoMensal();
        casa2.totalPagamento();

        Apartamento apto1 = new Apartamento(5,350000,23, 1,5);
        apto1.pagamentoMensal();
        apto1.totalPagamento();

        Apartamento apto2 = new Apartamento(6,400000,30, 2,10);
        apto2.pagamentoMensal();
        apto2.totalPagamento();

        Terreno trrn1 = new Terreno(8,60000,15, "Rural");
        trrn1.pagamentoMensal();
        trrn1.totalPagamento();

        System.out.println();
        System.out.println("--------------------------");
        System.out.println("TODOS OS FINANCIAMENTOS CADASTRADOS: ");
        System.out.println("--------------------------");
        System.out.println();

        ColecaoFinanciamentos financiamentos = new ColecaoFinanciamentos();
        if (imovel1 != null) {
            financiamentos.adicionaFinanciamento(imovel1);
        }
        financiamentos.adicionaFinanciamento(casa2);
        financiamentos.adicionaFinanciamento(apto1);
        financiamentos.adicionaFinanciamento(apto2);
        financiamentos.adicionaFinanciamento(trrn1);

        double totalValorImoveis =  imovel1.getValorImovel() + casa2.getValorImovel() + apto1.getValorImovel() + apto2.getValorImovel() + trrn1.getValorImovel();
        double totalValorFinanciamentos = imovel1.totalPagamento() + casa2.totalPagamento() + apto1.totalPagamento() + apto2.totalPagamento() + trrn1.totalPagamento();

        financiamentos.listarFinanciamentos();
        System.out.println();
        String totalValorImoveisFormat = String.format("%.2f", totalValorImoveis);
        String totalValorFinanciamentosFormat = String.format("%.2f",totalValorFinanciamentos);
        System.out.println("O valor total dos imóveis cadastrados é: R$" + totalValorImoveisFormat + " e o total de todos os financiamentos é de R$" + totalValorFinanciamentosFormat + ".");


        financiamentos.escreverCarac();
        financiamentos.lerCarac();
        financiamentos.gravarFinanciamentos();
        System.out.println();
        financiamentos.excluirFinanciamentos();
        System.out.println();
        financiamentos.resgatarFinanciamentos();

        }
    }