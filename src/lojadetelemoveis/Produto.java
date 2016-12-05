package lojadetelemoveis;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.*;

public class Produto /*implements Serializable*/ {

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
    private ArrayList<Integer> userRatings;

    public Produto() { //String marca, String modelo, int ano, String processador, int rom, int ram, int traseira, int frontal, int ecra, String so, int preco
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
        userRatings = new ArrayList<Integer>();

        /*this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.processador = processador;
        this.rom = rom;
        this.ram = ram;
        this.traseira = traseira;
        this.frontal = frontal;
        this.ecra = ecra;
        this.so = so;
        this.preco = preco;
        userRatings = new ArrayList<Integer>();
    }*/
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

    /*
     * addUserRating
     * NOTE: Each individual rating is stored with the product, so you need to maintain a list
     * of user ratings.  This method should append a new rating to the end of that list
     * @param rating - the new rating to add to this product
     */
    public void addUserRating(int rating) {
        userRatings.add(rating);
    }

    /*
     * getUserRating
     *  NOTE:  See note on addUserRating above.  This method should be written to allow you
     *  to access an individual value from the list of user ratings
     * @param index - the index of the rating we want to see
     * @return the rating indexed by the value index
     */
    public int getUserRating(int index) {
        return userRatings.get(index);
    }

    /*
     * getUserRatingCount
     *  NOTE: See note on addUserRating above.  This method should be written to return
     *  the total number of ratings this product has associated with it
     * @return the number of ratings associated with this product
     */
    public int getUserRatingCount() {
        return userRatings.size();
    }

    /*
     * getAvgUserRating
     *  NOTE: see note on addUserRating above.  This method should be written to compute
     *  the average user rating on demand from a stored list of ratings.
     * @return the average rating for this product as a whole integer value (use integer math)
     */
    public int getAvgUserRating() {
        int sum = 0;
        if (userRatings.size() > 0) {
            for (int i = 0; i < userRatings.size(); i++) {
                sum += userRatings.get(i);
            }
            return sum / userRatings.size();
        } else {
            return 0;
        }
    }

    public String toString() {
        String s = "";
        s += "Marca:" + marca + "\n";
        s += "Modelo:" + modelo + "\n";
        s += "Ano:" + ano + "\n";
        s += "Processador" + processador + "\n";
        s += "Bateria" + bateria + "\n";
        s += "Memória Interna:" + minterna + "\n";
        s += "RAM:" + ram + "\n";
        s += "Traseira:" + traseira + "\n";
        s += "Frontal:" + frontal + "\n";
        s += "Ecrã:" + ecra + "\n";
        s += "SO:" + so + "\n";
        s += "Preço:" + preco + "\n";
        s += "Quantidade:" + quantity + "\n";
        s += "UserRatings:" + userRatings.toString() + "\n";
        return s;
    }
}
