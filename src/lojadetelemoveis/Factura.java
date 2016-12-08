package lojadetelemoveis;
import java.text.DateFormat;
import java.util.Date;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;
import static lojadetelemoveis.Factura.print;

public class Factura implements Serializable{
    
    public static void main(String[] args) throws IOException 
    {
        Produto p = new Produto();
        Cliente c = new Cliente("nome", 19, 15121421, "Covilhã");       
        print (c, p, 0, "");
    }
       
    public static void  print (Cliente c, Produto p, int i, String t) throws IOException
    {
        String texto1 = "";
        String texto = t;
        Date date = new Date();
        String data = java.text.DateFormat.getDateInstance(DateFormat.LONG).format(date);
        String hora = java.text.DateFormat.getDateInstance(DateFormat.SHORT).format(date);
        FileWriter arq = new FileWriter("C:\\Users\\Diogo Dias\\Desktop\\Loja-de-Telemoveis\\teste.txt", true);
        PrintWriter gravarArq = new PrintWriter(arq);
        
        switch (i) 
        {
            case 0:
                texto1 = "================================================\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = "               LOJA DE TELEMÓVEIS               \n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = "================================================\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = " Cliente: " + c.getNome() + "\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = " Idade: " + c.getIdade() + "\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = " NIF: " + c.getNIF() + "\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = " Morada: " + c.getMorada() + "\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = "------------------------------------------------\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = " " + p.getMarca() + ", " + p.getModelo() + "\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = "      " + p.getPreco() + "\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = "\n";
                texto += texto1;
                gravarArq.println(texto1);
                arq.close();
                mais (c, p, texto);
                break;
            case 1:
                texto1 = " " + p.getMarca() + ", " + p.getModelo() + "\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = "      " + p.getPreco() + "\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = "\n";
                texto += texto1;
                gravarArq.println(texto1);
                arq.close();
                mais (c, p, texto);
                break;
            case 2:
                texto1 = " TOTAL A PAGAR\n"; 
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = "      " + p.getPreco() + "\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = " IVA INCLUIDO\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = "------------------------------------------------\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = " DATA: " + data + "\n";
                texto += texto1;
                gravarArq.println(texto1);
                texto1 = "\n";
                texto += texto1;
                gravarArq.println(texto1);
                System.out.println(texto);
                arq.close();
                break;
       }
    }
    
    public static void mais (Cliente c, Produto p, String t) throws IOException 
    {
        System.out.print ("Mais? (S ou N) --> "); 
        Scanner keyboard = new Scanner(System.in);
        String mais = keyboard.nextLine();
        
        if ("s".equals(mais) || "S".equals(mais))
        {
            Produto prod = new Produto();
            print (c, prod, 1, t); 
        }
        else
            print (c, p, 2, t);
    }
}