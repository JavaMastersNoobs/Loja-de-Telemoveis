/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadetelemoveis;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Cliente {
    private String nome;
    private int idade;
    private long NIF;
    private String morada;
    private ArrayList<Produto> compras;
 
    public Cliente(String nome, int idade, long NIF, String morada)
    {
        this.nome = nome;
        this.idade = idade;
        this.NIF = NIF;
        this.morada = morada;
        compras = new ArrayList<Produto> ();
    }
    
    public String getNome()
    {
        return nome;
    }
    public int getIdade()
    {
        return idade;
    }
    public long getNIF()
    {
        return NIF;
    }
    public String getMorada()
    {
        return morada;
    }
    public ArrayList<Produto> getCompras()
    {
        return compras;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
     public void setIdade(int idade)
    {
        this.idade = idade;
    }
    public void setNIF(long NIF)
    {
        this.NIF = NIF;
    }
    public void setMorada(String morada)
    {
        this.morada = morada;
    }
     public void setCompras(ArrayList<Produto> c)
    {
        compras = (ArrayList<Produto>) c.clone();
    }
}
