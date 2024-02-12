package utilities;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InterfaceUsuario {

    private double valorImovel;
    double taxaJurosAnual;
    int prazoFinanciamento;
    public double areaConstruida;
    public double tamanhoTerreno;


    //para meu valorImovel ser privado criei um get e set para acesso

    public void setValorImovel(double valorImovel) {

        this.valorImovel = valorImovel;
    }

    //ler valor do imóvel verificando se o valor digitado pelo usuário é válido (se não é negativo ou muito baixo)
    public double lerValorImovel() {
        Scanner sc = new Scanner(System.in);
        setValorImovel(0);
        while (true) {
            try {
                System.out.println("Digite o valor do imóvel: ");
                setValorImovel(sc.nextDouble());

                if (valorImovel < 0) {
                    System.out.println("Valor inválido. Financiamentos não podem ter valor negativo, digite outro valor.");
                } else if (valorImovel <= 20000) {
                    System.out.println("Valor inválido. Financiamentos tem valor mínimo de R$50.000,00. Digite outro valor: ");
                } else {
                    System.out.println("O valor do imovel a ser financiado é de: " + valorImovel);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor numérico válido.");
                sc.next(); // Limpar o buffer do scanner
            }
        }
        setValorImovel(valorImovel);
        return valorImovel;
    }

    //ler valor do prazo de finan. e verificando se o valor digitado pelo usuário é válido (se não é negativo ou alto demais)
    public int lerPrazoFinanciamento() {
        Scanner sc1 = new Scanner(System.in);
        int prazoFinanciamento = 0;
        while (true) {
            try {
                System.out.println("Digite o prazo do financiamento em anos: ");
                prazoFinanciamento = sc1.nextInt();

                if (prazoFinanciamento < 0) {
                    System.out.println("Valor inválido. Prazo não pode ter valor negativo, digite outro valor.");
                } else if (prazoFinanciamento > 30) {
                    System.out.println("Prazo inválido. O prazo máximo para financiamentos é de 30 anos. Digite outro prazo: ");
                } else {
                    System.out.println("O prazo do financiamento é de: " + prazoFinanciamento + " anos.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um valor numérico válido.");
                sc1.next(); //limpar o buffer do scanner
            }
        }
        return prazoFinanciamento;
    }

    //ler valor da taxa de juros e verificando se o valor digitado pelo usuário é válido
    public double lerTaxaJuros() {
        Scanner sc2 = new Scanner(System.in);
        double taxaJurosAnual = 0;
        while (true) {
            try {
                System.out.println("Digite a taxa de juros anual: ");
                taxaJurosAnual = sc2.nextDouble();

                if (taxaJurosAnual < 0) {
                    System.out.println("Valor inválido. Taxa de juros não pode ter valor negativo, digite outro valor.");
                } else if (taxaJurosAnual > 1000) {
                    System.out.println("Taxa abusiva. Digite uma taxa de juros anual válida: ");
                } else {
                    System.out.println("O valor de taxa de juros é de: " + taxaJurosAnual);
                    break;
                }
            } catch (InputMismatchException e){
                System.out.println("Entrada inválida. Digire um valor numérico válido.");
                sc2.next();
            }
        }
        return taxaJurosAnual / 100;
    }

    //ler area construída e verficando se o valor digitado pelo usuário é válido
    public double lerareaConstruida() {
        Scanner sc3 = new Scanner(System.in);
        double areaConstruida = 0;
        while (true) {
            try {
                System.out.println("Digite a área construída: ");
                areaConstruida = sc3.nextDouble();

                if (areaConstruida < 0) {
                    System.out.println("Valor inválido. Área construída não pode ter valor negativo, digite outro valor.");
                } else {
                    System.out.println("A área construída é de: " + areaConstruida);
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("Entrada inválida. Digite um valor numérico válido.");
                sc3.next();
            }
        }
        return areaConstruida;
    }

    //ler tamanho do terreno e verficando se o valor digitado pelo usuário é válido
    public double lertamanhoTerreno() {
        Scanner sc8 = new Scanner(System.in);
        double tamanhoTerreno = 0;
        while (true) {
            try {
                System.out.println("Digite o tamanho do terreno: ");
                tamanhoTerreno = sc8.nextDouble();

                if (tamanhoTerreno < 0) {
                    System.out.println("Valor inválido. Área do terreno não pode ter valor negativo, digite outro valor.");
                } else {
                    System.out.println("A área do terreno é de: " + tamanhoTerreno);
                    break;
                }
            } catch (InputMismatchException e){
                System.out.println("Entrada inválida. Digite um valor numérico válido.");
                sc8.next();
            }
        }
        return tamanhoTerreno;
    }

    // fiz um pequeno menu para o usuário escolher qual tipo de imovel ele deseja financiar
    public int selecionarTipo() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("SELECIONE O TIPO DO IMOVEL A SER FINANCIADO:\n" +
                "(1) - CASA\n" +
                "(2) - APARTAMENTO\n" +
                "(3) - TERRENO");
        System.out.println("OPÇÃO DESEJADA: ");

        Scanner sc5 = new Scanner(System.in);
        int tipoImovel = sc5.nextInt();
        return tipoImovel;
    }
}