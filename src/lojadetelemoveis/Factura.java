package lojadetelemoveis;

import java.io.*;
import java.util.*;

public class Factura implements Serializable {

    private static long ultimo = 0;
    private long id;
    private Data data;
    private Cliente c;
    private ArrayList<Produto> p;
    private ArrayList<Integer> quant;

    public Factura(Data data, Cliente c, ArrayList<Produto> p, ArrayList<Integer> quant) {
        ultimo++;
        this.id = ultimo;
        this.data = data;
        this.c = c;
        this.p = p;
        this.quant = quant;
    }

    public static long getUltimo() {
        return ultimo;
    }

    public static void setUltimo(long u) {
        ultimo = u;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return (data.getData());
    }

    public Date formatDate() {
        return (data.formatDate());
    }

    public ArrayList<Produto> getProdutos() {
        return p;
    }

    public void setProdutos(ArrayList<Produto> p) {
        this.p = (ArrayList<Produto>) p.clone();
    }

    public ArrayList<Integer> getQuantidade() {
        return quant;
    }

    public void setQuantidade(ArrayList<Integer> quant) {
        this.quant = (ArrayList<Integer>) quant.clone();
    }

    public void print() {
        String texto = "";
        texto += "================================================\n";
        texto += "               LOJA DE TELEMÓVEIS               \n";
        texto += "================================================\n";
        texto += " Cliente: " + c.getNome() + "\n";
        texto += " Data de Nascimento: " + c.getDatanascimento() + "\n";
        texto += " NIF: " + c.getNIF() + "\n";
        texto += " Morada: " + c.getMorada() + "\n";
        texto += "------------------------------------------------\n\n";
        double total = 0.0;
        for (int i = 0; i < p.size(); i++) {
            texto += " " + p.get(i).getMarca() + ", " + p.get(i).getModelo() + "\n";
            texto += " ID do telemóvel: " + p.get(i).getId() + "\n";
            texto += " Preço: " + (p.get(i).getPreco()) + "\u20AC" + "\n";
            texto += " Quantidade: " + quant.get(i) + "\n";
            texto += "\n";
            total += (p.get(i).getPreco()) * quant.get(i);
        }

        texto += " TOTAL A PAGAR" + "\n";
        texto += "    " + total + "\u20AC" + "\n";
        texto += " IVA INCLUIDO" + "\n";
        texto += "------------------------------------------------" + "\n";
        texto += " DATA: " + data.getData() + "\n";
        texto += " ID da Factura: " + this.id + "\n";
        texto += "\n";
        System.out.print(texto);
    }

}
