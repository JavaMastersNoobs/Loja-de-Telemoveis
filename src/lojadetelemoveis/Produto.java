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
   
   public Produto()
   {
        this.marca="";
        this.modelo="";
        this.ano=0;
        this.processador="";
        this.rom=0;
        this.ram=0;
        this.traseira=0;
        this.frontal=0;
        this.ecra=0;
        this.so="";
        this.preco=0.0;   
   }
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
   public int getFrontal()
        {
            return this.frontal;
        }
   public void setEcra(int ecra)
        {
           this.ecra=ecra;
        }
   public int getEcra()
        {
            return this.ecra;
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
        
   
}
    