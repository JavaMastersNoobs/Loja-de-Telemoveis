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
        System.out.println("Bem vindo á loja de telemóveis\n\n");/*give another name*/

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter an inventory filename: ");
        String fname = keyboard.nextLine();
        ArrayList<Produto> telemoveis = loadTelemoveis(fname);
        System.out.println(telemoveis.toString());

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
