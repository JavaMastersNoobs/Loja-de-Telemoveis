package lojadetelemoveis;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

    private String nome;
    private String datanascimento;
    private long NIF;
    private String morada;
    private long contacto;
    private ArrayList<Factura> facturas;

    public Cliente() {
        this.nome = "";
        this.datanascimento = "";
        this.NIF = 0;
        this.morada = "";
        this.contacto = 0;
        facturas = new ArrayList<Factura>();
    }

    public Cliente(String nome, String datanascimento, long NIF, String morada, long contacto) {
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

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getDatanascimento() {
        return datanascimento;
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
}
