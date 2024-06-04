package org.example;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {

    // Métodos que podemos realizar com o arquivo
    public void escrever(Cliente func) {
        // Instanciando os objetos que permitirão a escrita de dados
        OutputStream os = null; // fluxo de entrada
        OutputStreamWriter osw = null; //leitor de fluxo de entrada
        BufferedWriter bw = null; //buffer entrada

        // Variável auxiliar
        String linha;

        try {
            // Abrindo a saída de dados
            os = new FileOutputStream("Clientes.txt", true); // Nome do arquivo onde será salvo
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            // Flag que indica onde começa as informações do Funcionário
            bw.write("++ Clientes ++\n");
            bw.write(func.getNome() + "\n");
            bw.write(func.getCpf() + "\n");
            bw.write(func.getEndereco() + "\n");
            bw.write(func.getIdade() + "\n");

        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        } finally {
            // Fechando a entrada de dados
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    // 2. Método ler
    public ArrayList<Cliente> ler() {

        // ArrayList auxiliar para salvar funcionários encontrados no arquivo
        ArrayList<Cliente> encontreiNoArquivo = new ArrayList<>();

        // Classes que permitem leitura de dados do arquivo
        InputStream is = null; //fluxo saida
        InputStreamReader isr = null; //gerador de fluxo de saida
        BufferedReader br = null; // buffer de saida

        // Variável auxiliar que servirá de flag para o while
        String linhaLer;

        try {
            // Instanciando os objetos
            is = new FileInputStream("Clientes.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            // Colocando o cursor no inicio do arquivo
            linhaLer = br.readLine();

            while (linhaLer != null) {
                // Comparando se o que está em linhaLer é igual a minha flag
                if (linhaLer.contains("++ Clientes ++")) {
                    // Variável auxiliar de funcionario
                    Cliente cliente = new Cliente();
                    cliente.setNome(br.readLine());
                    cliente.setCpf(br.readLine());
                    cliente.setEndereco(br.readLine());
                    cliente.setIdade(Integer.parseInt(br.readLine()));

                    // Adicionando o funcionario no array
                    encontreiNoArquivo.add(cliente);
                }
                linhaLer = br.readLine();
            }
        } catch (Exception e) {
            System.out.println("Algo deu errado: " + e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
        return encontreiNoArquivo;
    }
}