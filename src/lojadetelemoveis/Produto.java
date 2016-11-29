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
   private int rom;
   private int ram;
   private int traseira;
   private int frontal;
   private int ecra; 
   private String so;
   private double preco;
   private ArrayList<Integer> userRatings;

   public Produto(String marca, String modelo, int ano, String processador, int rom, int ram, int traseira, int frontal, int ecra, String so, int preco)
   {
    this.marca=marca;
    this.modelo=modelo;
    this.ano=ano;
    this.processador=processador;
    this.rom=rom;
    this.ram=ram;
    this.traseira=traseira;
    this.frontal=frontal;
    this.ecra=ecra;
    this.so=so;
    this.preco=preco;   
    userRatings = new ArrayList<Integer>();
   }
   public void setMarca(String marca)
        {
            this.marca=marca;
        }
   public String getMarca()
        {
            return this.marca;
        }
   public void setModelo(String modelo)
        {
            this.modelo=modelo;
        }
   public String getModelo()
        {
            return this.modelo;
        }
   public void setAno(int ano)
        {
            this.ano=ano;
        }
   public int getAno()
        {
            return this.ano;
        }
   public void setProcessador(String processador)
        {
            this.processador=processador;
        }
   public String getProcessador()
        {
            return this.processador;
        }
   public void setRom(int rom)
        {
            this.rom=rom;
        }
   public int getRom()
        {
            return this.rom;
        }
   public void setRam(int ram)
        {
            this.ram=ram;
        }
   public int getRam()
        {
            return this.ram;
        }
   public void setTraseira(int traseira)
        {
            this.traseira=traseira;
        }
   public int getTraseira()
        {
            return this.traseira;
        }
   public void setFrontal(int frontal)
        {
            this.frontal=frontal;
        }
   public int getEcra()
        {
            return this.ecra;
        }
   public void setEcra(int Ecra)
        {
            this.ecra=ecra;
        }
   public void setSo(String so)
        {
            this.so=so;
        }
   public String getSo()
        {
            return this.so;
        }
   public void setPreco(double preco)
        {
            this.preco=preco;
        }
   public double getPreco()
        {
            return this.preco;
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
        if(userRatings.size() > 0){
            for (int i = 0; i < userRatings.size(); i++){
                sum += userRatings.get(i);
            }
            return sum / userRatings.size();
        }

        else return 0;
    }


    }
