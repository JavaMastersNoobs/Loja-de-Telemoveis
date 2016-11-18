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
    String marca;
    String modelo;
    int ano;
    String processador;
    int rom;
    int ram;
    int traseira;
    int frontal;
    int ecra; 
    String so;
    double preco;

    public Produto(String marca, String modelo)
            {
            marca="";
            modelo="";
            ano=0;
            processador="";
            rom=0;
            ram=0;
            traseira=0;
            frontal=0;
            ecra=0;
            so="";
            preco=0;                 
            }
}
    