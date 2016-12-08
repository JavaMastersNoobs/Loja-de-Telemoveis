/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadetelemoveis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class LojaDeTelemoveis {

    public static void main(String[] args) {
        System.out.println("Bem vindo à loja de telemóveis\n\n");/*give another name*/

        Scanner keyboard = new Scanner(System.in);
        /*System.out.print("Enter an inventory filename: ");
        String fname = keyboard.nextLine();
        ArrayList<Produto> telemoveis = loadTelemoveis(fname);
        System.out.println(telemoveis.toString());*/
        long auxlong;
        int auxint;
        Produto p = new Produto();
        Produto q = new Produto(); q.setId(25);
        Loja l = new Loja("TELEMOVEIS");
        int opcao = menu();
        while(opcao != 0){
            switch(opcao){
                case 1:
                    System.out.println(l.getTelemovel().toString());
                    break;
                case 2:
                    System.out.print("Introduza o identificador do telemóvel:");
                    auxlong = keyboard.nextLong();
                    if(l.verificar(auxlong) == true)
                    {
                        l.getTelemovel().get(0).descidaEstoque(1);
                    }
                    break;
                case 3:
                    //l.getFatura();
                    break;
                case 4: 
                    l.adicionarTelemovel(p);
                    l.adicionarTelemovel(q);
                    break;
                case 5:
                    l.setTelemovel(modificarProduto(l));
                    break;
                case 6:
                    System.out.print("Intoduza o identificador do telemóvel a ser removido:");
                    auxlong = keyboard.nextLong();
                    try{
                        l.removerTelemovel(auxlong);
                    }
                    catch (NumberFormatException e){
                    System.out.println("Não é um valor inteiro!");
                    }
                    break;
            }
            opcao = menu();
        }
        
    }
    
    

    public static ArrayList<Produto> loadTelemoveis(String fname) {
        ArrayList<Produto> telemoveis = new ArrayList<Produto>();
        try {
            Scanner inFile = new Scanner(new File(fname));
            while (inFile.hasNext()) {
                Produto pr = new Produto(); //"samsung", "arroz", 2014, "lol", 12, 16, 3, 16, 13, "toto", 100
                pr.setMarca(inFile.next());
                pr.setModelo(inFile.next());
                pr.setAno(inFile.nextInt());
                pr.setProcessador(inFile.nextLine());
                pr.setBateria(inFile.nextLine());
                pr.setMinterna(inFile.nextLine());
                pr.setRam(inFile.nextLine());
                pr.setTraseira(inFile.nextLine());
                pr.setFrontal(inFile.nextLine());
                pr.setEcra(inFile.nextLine());
                pr.setSo(inFile.nextLine());
                pr.setPreco(inFile.nextDouble());
                pr.setQuantity(inFile.nextInt());
                pr.setId(inFile.nextInt());

                /*while (inFile.hasNext()) {
                    pr.addUserRating(inFile.nextInt());
                }*/
                telemoveis.add(pr);
            }
            inFile.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e);
        }
        return telemoveis;
    }
    
    public static ArrayList<Produto> modificarProduto(Loja l)
    {
        Scanner keyboard = new Scanner(System.in);
        long auxlong;
        int auxint, opcao= -1;
        double auxdouble;
        System.out.print("Introduza o identificador do telemovel a ser modificado:");
        auxlong = keyboard.nextLong();
        while(l.verificar(auxlong) != true)
        {
            System.out.println("1 - Modificar produto");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("Introduza uma das opções:");
            opcao = keyboard.nextInt();
            if(opcao == 0)
            {
                return (l.getTelemovel());
            }
            else if(opcao >1 || opcao <0)
            {
                System.out.println("Deve introuzir uma das opções listadas!");
            }
            else
            {
                System.out.print("Introduza o identificador do telemovel a ser modificado:");
                auxlong = keyboard.nextLong();
            }  
        }
        for(int i=0; i<l.getTelemovel().size(); i++)
        {
            if(l.getTelemovel().get(i).getId() == auxlong)
            {
                opcao = -1;
                while (opcao <0 || opcao >2)
                {
                    System.out.println("1 - Modificar preço");
                    System.out.println("2 - Aumentar quantidade em stock");
                    System.out.println("0 - Voltar ao menu principal");
                    System.out.println("Introduza uma das opções:");
                    opcao = keyboard.nextInt();
                    if(opcao == 0)
                    {
                        return (l.getTelemovel());
                    }
                    else if(opcao >2 || opcao <0)
                    {
                        System.out.println("Deve introuzir uma das opções listadas!");
                    }
                     else if(opcao == 1)
                    {
                        System.out.println("Introduza o novo valor do telemóvel:");
                        auxdouble = keyboard.nextDouble();
                        l.getTelemovel().get(i).setPreco(auxdouble);
                        System.out.println("Valor modificado com sucesso!");
                    }
                    else
                    {
                        System.out.println("Introduza valor a ser aumentado no stock:");
                        auxint = keyboard.nextInt();
                        l.getTelemovel().get(i).aumentarEstoque(auxint);
                        System.out.println("Valor aumentado com sucesso!");
                    }
                    
                }
            }
            return l.getTelemovel();
        }
        return l.getTelemovel();          
    }
    
    public static int menu (){
        Scanner keyboard = new Scanner(System.in);
	System.out.println("1 - Telemóveis");
	System.out.println("2 - Comprar telemóvel");
	System.out.println("3 - Factura");
        System.out.println("4 - Adicionar telemóvel");
        System.out.println("5 - Modificar telemóvel");
        System.out.println("6 - Remover telemóvel");
        System.out.println("0 - Sair");
        System.out.print("Introduza uma das opções:");
        int opcao = keyboard.nextInt();
	return opcao;
    }
    
    
    
    
    
    /* Produto Tech = new Produto("samsung", "arroz", 2014, "lol", 12,16, 3,16,13, "toto", 100);
        Tech.setMarca("wt");
        Tech.setModelo("arroz");
        Tech.setAno(2014);
        Tech.setProcessador("SD 801");
        Tech.setRom(16);
        Tech.setRam(2);
        Tech.setTraseira(13);
        Tech.setFrontal(5);
        Tech.setSo("Android 4.4 KitKat");
        Tech.setPreco(199);
     */
}
