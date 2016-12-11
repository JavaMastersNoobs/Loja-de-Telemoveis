package lojadetelemoveis;
import java.io.*;
import java.util.*;

public class Factura {
    
    public static String separator = System.getProperty("line.separator");
    
    public static void main (String[] args) throws IOException 
    {
        Produto p = new Produto();
        Cliente c = new Cliente("nome", 19, 15121421, "Covilhã");       
        print (c, p, 0, "");
        String s = "10 de Dezembro de 2016";
        getFactura (1002);
        System.out.println (getVendas (s));
        topVendas();
    }
       
    public static void  print (Cliente c, Produto p, int i, String t) throws IOException
    {
        String texto = t;
        FileWriter arq = new FileWriter("C:\\Users\\Diogo Dias\\Desktop\\Loja-de-Telemoveis\\teste.txt", true);
        PrintWriter gravarArq = new PrintWriter(arq);
        Data d = new Data();
        
        switch (i) 
        {
            case 0:
                texto += "================================================" + separator;
                texto += "               LOJA DE TELEMÓVEIS               " + separator;
                texto += "================================================" + separator;
                texto += " Cliente: " + c.getNome() + separator;
              /*  texto = " Data de Nascimento: " + c.getDatanascimento() + "\n";
                texto += texto;
                gravarArq.println(texto); */
                texto += " NIF: " + c.getNIF() + separator;
                texto += " Morada: " + c.getMorada() + separator;
                texto += "------------------------------------------------" + separator;
                texto += " " + p.getMarca() + ", " + p.getModelo() + separator;
                texto += "      " + p.getPreco() + separator;
                texto += separator;
                mais (c, p, texto);
                addData(d.getData());
                break;
            case 1:
                addData(d.getData());
                texto += " " + p.getMarca() + ", " + p.getModelo() + separator;
                texto += "      " + p.getPreco() + separator;
                texto += separator;
                mais (c, p, texto);
                break;
            case 2:
                texto += " TOTAL A PAGAR" + separator; 
                texto += "      " + p.getPreco() + separator;
                texto += " IVA INCLUIDO" + separator;
                texto += "------------------------------------------------" + separator;
                texto += " DATA: " + d.getData() + separator;
                texto += " ID da Factura: " + getID() + separator;
                texto += separator;
                gravarArq.format(texto);
                System.out.print(texto);
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
    
    public static void addData (String data) throws IOException
    {
        String arquivo = "C:\\Users\\Diogo Dias\\Desktop\\Loja-de-Telemoveis\\datas.txt";
        String s = "";
        String s1 = "";
        String s2 = "";
        int n = 0;
        int i = 0;
        String separator = System.getProperty("line.separator");
        
        InputStream is = new FileInputStream(arquivo);                          // Ficheiro a ler
        InputStreamReader isr = new InputStreamReader(is);                      // Ficheiro a ler
        BufferedReader br = new BufferedReader(isr);                            // Leitor
        
        s = br.readLine();
        while (s != null)
        {
            if (s.equals(data))                                                 // Verifica a data
            {
                s1 = s1 + s + separator;
                s = br.readLine();
                n = Integer.parseInt(s) + 1;
                s2 = Integer.toString(n);
                s = s.replace(s, s2);
                s1 = s1 + s + separator; 
                i = 1;
            }
            else
            {
                s1 = s1 + s + separator;
                s = br.readLine();
                s1 = s1 + s + separator;  
            }
            s = br.readLine();
        }
        
        if (i == 0)
        {
            s1 = s1 + data + separator + "1" + separator;
            System.out.print(data);
        }
        
        try (FileWriter arq1 = new FileWriter(arquivo))                         // Escritor
        {
            PrintWriter gravarArq = new PrintWriter(arq1);
            gravarArq.format(s1);
            arq1.close();
        }
    }
    
    public static String getVendas (String data) throws IOException
    {
        String s = "";
        
        InputStream is = new FileInputStream("C:\\Users\\Diogo Dias\\Desktop\\Loja-de-Telemoveis\\datas.txt");                          // Ficheiro a ler
        InputStreamReader isr = new InputStreamReader(is);                      // Ficheiro a ler
        BufferedReader br = new BufferedReader(isr);                            // Leitor
        
        s = br.readLine();
        while (s != null)
        {
            if (s.equals(data))                                                 // Verifica a data
            {
                s = br.readLine();
                return s;
            }
            s = br.readLine();
        }
        return null;
    }
    
    public static long getID () throws IOException
    {
        String arquivo = "C:\\Users\\Diogo Dias\\Desktop\\Loja-de-Telemoveis\\IDs.txt";
        String s = "";
        String s1 = "";
        String s2 = "";    
        long ID;
        
        InputStream is = new FileInputStream(arquivo);                          // Ficheiro a ler
        InputStreamReader isr = new InputStreamReader(is);                      // Ficheiro a ler
        BufferedReader br = new BufferedReader(isr);                            // Leitor
        
        do 
        {
            s = br.readLine();
            if (s != null)
            {
                s1 = s;
                s2 = s2 + s + separator;
            }
        } while (s != null);
        ID = Integer.parseInt(s1) + 1;
        s2 = s2 + ID;
        
        try (FileWriter arq1 = new FileWriter(arquivo))                         // Escritor
        {
            PrintWriter gravarArq = new PrintWriter(arq1);
            gravarArq.format(s2);
            arq1.close();
        }
        return (ID);
    }
    
    public static void getFactura (long ID) throws IOException
    {
        String arquivo = "C:\\Users\\Diogo Dias\\Desktop\\Loja-de-Telemoveis\\teste.txt";
        String s = ""; 
        
        InputStream is = new FileInputStream(arquivo);                          // Ficheiro a ler
        InputStreamReader isr = new InputStreamReader(is);                      // Ficheiro a ler
        BufferedReader br = new BufferedReader(isr);                            // Leitor
           
        s = br.readLine();  
        
        while (s != null) 
        {
            if ((" ID da Factura: " + Integer.toString((int) (ID - 1))).equals(s))
            {
                br.readLine();
                s = br.readLine();
                while (!s.equals(" ID da Factura: " + Integer.toString((int) (ID))))
                {
                    System.out.println(s);
                    s = br.readLine();
                }
                System.out.println(s + separator);
            }
            else
            {
                s = br.readLine();
            }
        }
    }
    
    public static void topVendas () throws IOException 
    {
        String arquivo = "C:\\Users\\Diogo Dias\\Desktop\\Loja-de-Telemoveis\\datas.txt";
        String s = "", s1 = "", S = ""; 
        int M = 0;
        int i = 0;
        
        InputStream is = new FileInputStream(arquivo);                          // Ficheiro a ler
        InputStreamReader isr = new InputStreamReader(is);                      // Ficheiro a ler
        BufferedReader br = new BufferedReader(isr);                            // Leitor
        
        s = br.readLine(); 
        
        while (s != null) 
        {
            s1 = br.readLine();
            i = Integer.parseInt(s1);
            if (i > M)
            {
                M = i;
                S = s;
            }
            s = br.readLine(); 
        }
        System.out.println("Data: " + S);
        System.out.println("Vendas: " + M);        
    }
    
}