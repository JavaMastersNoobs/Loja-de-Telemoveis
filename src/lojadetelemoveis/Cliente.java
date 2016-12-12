package lojadetelemoveis;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

    private String nome;
    private Data datanascimento;
    private long NIF;
    private String morada;
    private long contacto;
    private ArrayList<Factura> facturas;

    public Cliente() {
        this.nome = "";
        this.datanascimento = new Data();
        this.NIF = 0;
        this.morada = "";
        this.contacto = 0;
        facturas = new ArrayList<Factura>();
    }

    public Cliente(String nome, Data datanascimento, long NIF, String morada, long contacto) {
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.NIF = NIF;
        this.morada = morada;
        this.contacto = contacto;
        facturas = new ArrayList<Factura>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDatanascimento(Data datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getDatanascimento() {
        return datanascimento.getData();
    }

    public void setNIF(long NIF) {
        this.NIF = NIF;
    }

    public long getNIF() {
        return NIF;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getMorada() {
        return morada;
    }

    public void setContacto(long contacto) {
        this.contacto = contacto;
    }

    public long getContacto() {
        return contacto;
    }

    public void setFacturas(ArrayList<Factura> f) {
        facturas = (ArrayList<Factura>) f.clone();
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }
    public Object clone()
    {
        Cliente copia = new Cliente(this.nome, this.datanascimento, this.NIF, this.morada, this.contacto);
        copia.facturas = (ArrayList) this.facturas.clone();
        return copia;
    }
    
    public String toString()
    {
        String s = "";
        s += "Nome:" + nome + "\n";
        s += "Data de nascimento:" + datanascimento.getData() + "\n";
        s += "NIF:" + NIF + "\n";
        s += "Morada:" + morada + "\n"; 
        s += "Contacto:"+contacto+"\n";
        return s;
    }
}
