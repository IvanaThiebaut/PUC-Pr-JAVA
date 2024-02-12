package model;

import java.io.*;
import java.util.ArrayList;

public class ColecaoFinanciamentos {

    private ArrayList<Financiamento> financiamentos;

    public ColecaoFinanciamentos() {
        this.financiamentos = new ArrayList<Financiamento>();
    }

    public void adicionaFinanciamento(Financiamento item) {
        this.financiamentos.add(item);
    }

    public void listarFinanciamentos() {
        int cont = 0;
        for (Financiamento item : financiamentos) {
            cont++;
            System.out.println("Imovel " + cont + " - " + item.toString());
        }
    }

    public void excluirFinanciamentos(){
        financiamentos.clear();
        System.out.println("Financiamentos excluidos com sucesso");
    }

    //metodo para eu escrever meus financiamentos em arquivo .txt
    public void escreverCarac() {
        String texto = "";
        FileWriter out = null;
        int contLetra = 0;
        try {
            out = new FileWriter("Financiamentostexto.txt");
            for (Financiamento f : financiamentos) {
                texto = texto + "\n" + f.toString() + "\n";
            }
            while (contLetra < texto.length()) {
                out.write(texto.charAt(contLetra));
                contLetra++;
            }
            out.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //metodo para eu ler o arquivo .txt
    public void lerCarac() {
        FileReader in = null;
        System.out.println();
        System.out.println("----------------------");
        System.out.println(" DADOS DO ARQUIVO ");
        System.out.println("----------------------");
        try {
            in = new FileReader("Financiamentostexto.txt");
            int c;
            while ((c = in.read()) != -1)
                System.out.print((char) c);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // metodo para escrever os objetos em arquivo .dat
    public void gravarFinanciamentos() {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("financiamentoobjetos.dat"));
            for (Financiamento f : financiamentos) {
                outputStream.writeObject(f);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void resgatarFinanciamentos() {
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream("financiamentoobjetos.dat"));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Casa)
                    this.financiamentos.add((Casa) obj);
                else if (obj instanceof Apartamento)
                    this.financiamentos.add((Apartamento) obj);
                else if (obj instanceof Terreno)
                    this.financiamentos.add((Terreno) obj);
            }
        } catch (EOFException e) {
            System.out.println("Fim do arquivo.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}