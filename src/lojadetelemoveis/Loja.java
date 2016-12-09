package lojadetelemoveis;

import java.io.Serializable;
import java.util.ArrayList;

public class Loja implements Serializable {

    private String nome;
    private ArrayList<Produto> telemovel;
    private ArrayList<Cliente> clientes;
    private ArrayList<Factura> facturas;

    public Loja(String nome) {
        this.nome = nome;
        telemovel = new ArrayList<Produto>();
        clientes = new ArrayList<Cliente>();
        facturas = new ArrayList<Factura>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Produto> getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(ArrayList<Produto> telemovel) {
        this.telemovel = (ArrayList<Produto>) telemovel.clone();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = (ArrayList) clientes.clone();
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public boolean verificarTelemovel(long id) {
        boolean x;
        x = false;
        for (int i = 0; i < telemovel.size(); i++) {
            x |= telemovel.get(i).getId() == id;
        }
        return x;

    }

    public void adicionarTelemovel(Produto p) {
        if (!verificarTelemovel(p.getId())) {
            telemovel.add(p);
        }
    }

    public void removerTelemovel(long id) {
        for (int i = 0; i < telemovel.size(); i++) {
            if (telemovel.get(i).getId() == id) {
                telemovel.remove(i);
            }
        }
    }
}
