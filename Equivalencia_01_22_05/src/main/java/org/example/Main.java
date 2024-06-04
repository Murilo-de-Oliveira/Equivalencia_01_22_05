package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continuar = true; //flag para controlar continuidade do programa
        Scanner input = new Scanner(System.in); //declaração do scanner
        Arquivo arquivo = new Arquivo(); //declaração do arquivo
        Cliente cliente = new Cliente(); //cliente para inserção no arquivo
        ArrayList<Cliente> clientes = new ArrayList<>(); //declaração do arraylist de clientes
        System.out.println("Bem-vindo ao menu da GarroSerra");
        while(continuar){
            //Menu de opções
            System.out.println("1 - Cadastrar clientes");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Ordenar clientes (A-Z)");
            System.out.println("4 - Ordenar clientes (Z-A)");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");

            //input da opção
            int opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                //Cadastro do cliente
                case 1 :
                    System.out.print("Nome do cliente: ");
                    cliente.setNome(input.nextLine());
                    System.out.print("Cpf do cliente: ");
                    cliente.setCpf(input.nextLine());
                    System.out.print("Endereço do cliente: ");
                    cliente.setEndereco(input.nextLine());
                    System.out.print("Idade do cliente: ");
                    cliente.setIdade(input.nextInt());

                    //a função escrever é chamada para inserir o cliente no arquivo
                    arquivo.escrever(cliente);
                    break;

                //Lista de clientes
                case 2 :
                    clientes = arquivo.ler(); //a lista de clientes armazena a lista retornada da função

                    //mostra os clientes cadastrados
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println("INFORMACOES DO CLIENTE: ");
                        System.out.println(clientes.get(i).getNome());
                        System.out.println(clientes.get(i).getCpf());
                        System.out.println(clientes.get(i).getEndereco());
                        System.out.println(clientes.get(i).getIdade());
                    }
                    break;

                //Lista de A a Z
                case 3:
                    clientes = arquivo.ler(); //a lista de clientes armazena a lista retornada da função

                    Collections.sort(clientes); //ordena os clientes em ordem alfabética

                    //lista os clientes
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println("INFORMACOES DO CLIENTE: ");
                        System.out.println(clientes.get(i).getNome());
                        System.out.println(clientes.get(i).getCpf());
                        System.out.println(clientes.get(i).getEndereco());
                        System.out.println(clientes.get(i).getIdade());
                    }
                    break;

                //Lista de Z a A
                case 4:
                    clientes = arquivo.ler(); //a lista de clientes armazena a lista retornada da função

                    Collections.sort(clientes); //lista os clientes em ordem alfabética
                    Collections.reverse(clientes); //reverte a lista de trás pra frente

                    //lista os clientes de Z a A
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println("INFORMACOES DO CLIENTE: ");
                        System.out.println(clientes.get(i).getNome());
                        System.out.println(clientes.get(i).getCpf());
                        System.out.println(clientes.get(i).getEndereco());
                        System.out.println(clientes.get(i).getIdade());
                    }
                    break;

                //Sai do programa
                case 5:
                    continuar = false;
                    System.out.println("Saiu do programa");
                    break;
            }
        }
    }
}