/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojadetelemoveis;
import static lojadetelemoveis.Ler.*;
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

        //Scanner keyboard = new Scanner(System.in);
        /*System.out.print("Enter an inventory filename: ");
        String fname = keyboard.nextLine();
        ArrayList<Produto> telemoveis = loadTelemoveis(fname);
        System.out.println(telemoveis.toString());*/
        long auxlong;
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
                    auxlong = umLong();
                    if(l.verificarTelemovel(auxlong) == true)
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
                case 5://done
                    l.setTelemovel(modificarProduto(l));
                    break;
                case 6://done
                    l.removerTelemovel(removerProduto(l));
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
        long auxlong;
        int auxint, opcao = -1;
        double auxdouble;
        System.out.print("Introduza o identificador do telemóvel a ser modificado:");
        auxlong = umLong();
        while(l.verificarTelemovel(auxlong) != true)
        {
            System.out.println("Identificador não encontrado!");
            System.out.println("1 - Modificar produto");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Introduza uma das opções:");
            opcao = umInt();
            if(opcao == 0)
            {
                return (l.getTelemovel());
            }
            else if(opcao >1 || opcao <0)
            {
                System.out.println("Deve introduzir uma das opções listadas!");
            }
            else
            {
                System.out.print("Introduza o identificador do telemovel a ser modificado:");
                auxlong = umLong();
            }  
        }
        for(int i=0; i<l.getTelemovel().size(); i++)
        {
            if(l.getTelemovel().get(i).getId() == auxlong)
            {
                opcao = -1;
                while(opcao <0 || opcao >2)
                {
                    System.out.println("1 - Modificar preço");
                    System.out.println("2 - Aumentar quantidade em stock");
                    System.out.println("0 - Voltar ao menu principal");
                    System.out.print("Introduza uma das opções:");
                    opcao = umInt();
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
                        System.out.print("Introduza o novo preço do telemóvel:");
                        auxdouble = umDouble();
                        l.getTelemovel().get(i).setPreco(auxdouble);
                        System.out.println("Preço modificado com sucesso!");
                    }
                    else
                    {
                        System.out.print("Introduza valor a ser aumentado no stock:");
                        auxint = umInt();
                        l.getTelemovel().get(i).aumentarEstoque(auxint);
                        System.out.println("Valor aumentado com sucesso!");
                    }
                }
            }
        }
        return l.getTelemovel();          
    }
    
    public static long removerProduto(Loja l)
    {
        System.out.print("Intoduza o identificador do telemóvel a ser removido:");
        long auxlong = umLong();
        if(l.verificarTelemovel(auxlong) == true)
        {
            System.out.println("Produto removido com sucesso!");
        }
        else
        {
            System.out.println("O produto não foi encontrado!");
        }
        return auxlong;
    }
    
    public static int menu (){
        System.out.println("==============================================================");
	System.out.println("1 - Telemóveis");
	System.out.println("2 - Comprar telemóvel");
	System.out.println("3 - Factura");
        System.out.println("4 - Adicionar telemóvel");
        System.out.println("5 - Modificar telemóvel");
        System.out.println("6 - Remover telemóvel");
        System.out.println("0 - Sair");
        System.out.print("Introduza uma das opções:");
        int opcao = umInt();
        System.out.println("==============================================================");
        if(opcao<0 || opcao>6)
        {
            System.out.println("Deve introduzir uma das opções listadas!");
        }
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
