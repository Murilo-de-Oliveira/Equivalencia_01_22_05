package org.example;

public class Cliente implements Comparable<Cliente> {
    //Atributos do cliente
    String nome;
    String cpf;
    String endereco;
    int idade;

    //Getters e Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdade() {
        return idade;
    }

    //Sobrescria do método compareTo de Comparable
    @Override
    public int compareTo(Cliente o) {
        return nome.compareTo(o.nome);
    }
}
