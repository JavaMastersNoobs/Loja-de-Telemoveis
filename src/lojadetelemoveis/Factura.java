package lojadetelemoveis;

import java.io.*;
import java.util.*;

public class Factura implements Serializable {

    public static String separator = System.getProperty("line.separator");

    private static long ultimo = 0;
    private long id;

    public Factura() {
        ultimo++;
        this.id = ultimo;
    }

    public static long getUltimo() {
        return ultimo;
    }

    public static void setUltimo(long u) {
        ultimo = u;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void print(Cliente c, ArrayList<Produto> p, ArrayList<Integer> quant) throws IOException {
        String texto = "";
        Data d = new Data();
        texto += "================================================" + separator;
        texto += "               LOJA DE TELEMÓVEIS               " + separator;
        texto += "================================================" + separator;
        texto += " Cliente: " + c.getNome() + separator;
        texto += " Data de Nascimento: " + c.getDatanascimento() + "\n";
        texto += " NIF: " + c.getNIF() + separator;
        texto += " Morada: " + c.getMorada() + separator;
        texto += "------------------------------------------------" + separator;
        double total = 0.0;
        for (int i = 0; i < p.size(); i++) {
            texto += " " + p.get(i).getMarca() + ", " + p.get(i).getModelo() + separator;
            texto += "      " + (p.get(i).getPreco()) + separator;
            texto += " Quantidade: " + quant.get(i) + separator;
            texto += separator;
            total += (p.get(i).getPreco()) * quant.get(i);
            //addData(d.getData());
        }

        texto += " TOTAL A PAGAR" + separator;
        texto += "      " + total + separator;
        texto += " IVA INCLUIDO" + separator;
        texto += "------------------------------------------------" + separator;
        texto += " DATA: " + d.getData() + separator;
        texto += " ID da Factura: " + this.getId() + separator;
        texto += separator;
        System.out.print(texto);
    }

    /*public static void addData (String data) throws IOException
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
    }*/
}
