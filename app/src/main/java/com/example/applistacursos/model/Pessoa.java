package com.example.applistacursos.model;

public class Pessoa {
    private String primeiroNome;
    private String sobrenome;
    private String cursoDesejado;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(String primeiroNome, String telefone, String cursoDesejado, String sobrenome) {
        this.primeiroNome = primeiroNome;
        this.telefone = telefone;
        this.cursoDesejado = cursoDesejado;
        this.sobrenome = sobrenome;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cursoDesejado='" + cursoDesejado + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
