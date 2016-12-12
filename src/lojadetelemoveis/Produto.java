package lojadetelemoveis;

import java.io.Serializable;

public class Produto implements Serializable {

    private String marca;
    private String modelo;
    private int ano;
    private String processador;
    private String bateria;
    private String minterna;
    private String ram;
    private String traseira;
    private String frontal;
    private String ecra;
    private String so;
    private double preco;
    private int quantity;
    private long id;

    public Produto() {
        marca = "";
        modelo = "";
        ano = 0;
        processador = "";
        bateria = "";
        minterna = "";
        ram = "";
        traseira = "";
        frontal = "";
        ecra = "";
        so = "";
        preco = 0.0;
        quantity = 0;
        id = 0;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getProcessador() {
        return processador;
    }

    public void setBateria(String bateria) {
        this.bateria = bateria;
    }

    public String getBateria() {
        return bateria;
    }

    public void setMinterna(String minterna) {
        this.minterna = minterna;
    }

    public String getMinterna() {
        return minterna;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRam() {
        return ram;
    }

    public void setTraseira(String traseira) {
        this.traseira = traseira;
    }

    public String getTraseira() {
        return traseira;
    }

    public void setFrontal(String frontal) {
        this.frontal = frontal;
    }
    
    public String getFrontal() {
        return frontal;
    }

    public void setEcra(String ecra) {
        this.ecra = ecra;
    }

    public String getEcra() {
        return ecra;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getSo() {
        return so;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void descidaEstoque(int quantity) {
        this.quantity -= quantity;
    }

    public void aumentarEstoque(int quantity) {
        this.quantity += quantity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    
     public Object clone()
    {
        Produto p = new Produto();
        p.marca = this.marca;
        p.modelo = this.modelo;
        p.ano = this.ano;
        p.processador = this.processador;
        p.bateria = this.bateria;
        p.minterna = this.minterna;
        p.ram = this.ram;
        p.traseira = this.traseira;
        p.frontal = this.frontal;
        p.ecra = this.ecra;
        p.so = this.so;
        p.preco = this.preco;
        p.quantity = this.quantity;
        p.id = this.id;
        return p;
    }
     
     
    public String toString() {
        String s = "";
        s += "Marca:" + marca + "\n";
        s += "Modelo:" + modelo + "\n";
        s += "Ano:" + ano + "\n";
        s += "Processador:" + processador + "\n";
        s += "Bateria:" + bateria + "\n";
        s += "Memória Interna:" + minterna + "\n";
        s += "Memória RAM:" + ram + "\n";
        s += "Câmara Traseira:" + traseira + "\n";
        s += "Câmara Frontal:" + frontal + "\n";
        s += "Ecrã:" + ecra + "\n";
        s += "Sistema Operativo:" + so + "\n";
        s += "Preço:" + preco + "\n";
        s += "Quantidade:" + quantity + "\n";
        s += "Identificador:" + id + "\n";
        return s;
    }
}
