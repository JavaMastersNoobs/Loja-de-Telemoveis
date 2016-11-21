/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadetelemoveis;

/**
 *
 * @author andra
 */
public class Produto {
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
   }
   public void setmarca(String marca)
        {
            this.marca=marca;
        }
   public String getmarca()
        {
            return this.marca;
        }
   public void setmodelo(String modelo)
        {
            this.modelo=modelo;
        }
   public String getmodelo()
        {
            return this.modelo;
        }
   public void setano(int ano)
        {
            this.ano=ano;
        }
   public int getano()
        {
            return this.ano;
        }
   public void setprocessador(String processador)
        {
            this.processador=processador;
        }
   public String getprocessador()
        {
            return this.processador;
        }
   public void setrom(int rom)
        {
            this.rom=rom;
        }
   public int getrom()
        {
            return this.rom;
        }
   public void setram(int ram)
        {
            this.ram=ram;
        }
   public int getram()
        {
            return this.ram;
        }
   public void settraseira(int traseira)
        {
            this.traseira=traseira;
        }
   public int gettraseira()
        {
            return this.traseira;
        }
   public void setfrontal(int frontal)
        {
            this.frontal=frontal;
        }
   public int getecra()
        {
            return this.ecra;
        }
   public void setso(String so)
        {
            this.so=so;
        }
   public String getso()
        {
            return this.so;
        }
   public void setpreco(double preco)
        {
            this.preco=preco;
        }
   public double getpreco()
        {
            return this.preco;
        }
   
   
}
    