package lojadetelemoveis;

import static lojadetelemoveis.Ler.*;
import static lojadetelemoveis.Menus.*;
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

    public static void main(String[] args) 
    {
        System.out.println("Bem vindo à loja de telemóveis\n\n");
        long auxlong;
        Produto p = new Produto();
        Produto q = new Produto();
        q.setId(25);
        Loja l = new Loja("Telemóveis");
        try //para ler o ficheiro
        {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\UBI\\test.dat"));

            l = (Loja) is.readObject();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        int opcao = menu();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.println(l.getTelemovel().toString());
                    break;
                case 2:
                    System.out.print("Introduza o identificador do telemóvel:");
                    auxlong = umLong();
                    if (l.verificarTelemovel(auxlong) == true) {
                        l.getTelemovel().get(0).descidaEstoque(1);
                    }
                    break;
                case 3:
                    //l.getFatura();
                    break;
                case 4: //done (maybe change it)
                    l.adicionarTelemovel(q);
                    //l.adicionarTelemovel(adicionarProduto());
                    break;
                case 5://done
                    l.setTelemovel(modificarProduto(l));
                    break;
                case 6://done
                    l.setTelemovel(removerProduto(l));
                    break;
                case 7:
                    l.adicionarCliente(adicionarCliente());
                    break;
                case 8:
                    l.setClientes(modificarCliente(l));
                    break;
                case 9:
                    l.setClientes(removerCliente(l));
                    break;
            }
            opcao = menu();
        }
        try //para guardar no ficheiro
        {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\UBI\\test.dat"));
            os.writeObject(l);
            os.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
   
    public static Produto adicionarProduto() 
    {
        Produto p = new Produto();
        System.out.print("Introduza a marca:");
        p.setMarca(umaString());
        System.out.print("Introduza o modelo:");
        p.setModelo(umaString());
        System.out.print("Introduza o ano:");
        p.setAno(umInt());
        System.out.print("Introduza o processador:");
        p.setProcessador(umaString());
        System.out.print("Introduza a bateria:");
        p.setBateria(umaString());
        System.out.print("Introduza a memória interna:");
        p.setMinterna(umaString());
        System.out.print("Introduza a memória RAM:");
        p.setRam(umaString());
        System.out.print("Introduza a câmara traseira:");
        p.setTraseira(umaString());
        System.out.print("Introduza a câmara frontal :");
        p.setFrontal(umaString());
        System.out.print("Introduza a ecrã:");
        p.setEcra(umaString());
        System.out.print("Introduza o sistema operativo:");
        p.setSo(umaString());
        System.out.print("Introduza o preço:");
        p.setPreco(umDouble());
        System.out.print("Introduza a quantidade em estoque:");
        p.setQuantity(umInt());
        System.out.print("Introduza o identificador:");
        p.setId(umLong());
        return p;
    }

    public static ArrayList<Produto> modificarProduto(Loja l) 
    {
        long auxlong;
        int auxint;
        double auxdouble;
        int opcao = menu5();
        while(opcao != 0)
        {
            switch(opcao)
            {
                case 1:
                    System.out.print("Introduza o identificador do telemóvel a ser modificado:");
                    auxlong = umLong();
                    if(l.verificarTelemovel(auxlong) == true) 
                    {
                        for (int i = 0; i < l.getTelemovel().size(); i++) 
                        {
                            if (l.getTelemovel().get(i).getId() == auxlong) 
                            {
                                System.out.print("Introduza o novo preço do telemóvel:");
                                auxdouble = umDouble();
                                l.getTelemovel().get(i).setPreco(auxdouble);
                                System.out.println("Preço modificado com sucesso!");
                            } 
                        }
                    }
                    else
                    {
                        System.out.println("O identificador não foi encontrado!");
                    }
                    break;
                case 2:
                    System.out.print("Introduza o identificador do telemóvel a ser modificado:");
                    auxlong = umLong();
                    if(l.verificarTelemovel(auxlong) == true) 
                    {
                        for (int i = 0; i < l.getTelemovel().size(); i++) 
                        {
                            if(l.getTelemovel().get(i).getId() == auxlong) 
                            {
                                System.out.print("Introduza valor a ser aumentado no stock:");
                                auxint = umInt();
                                l.getTelemovel().get(i).aumentarEstoque(auxint);
                                System.out.println("Valor aumentado com sucesso!");
                                break;
                            }
                        }
                    }
                    else
                    {
                        System.out.println("O identificador não foi encontrado!");
                    }
                    break;
            }
            opcao = menu5();      
        }
        return l.getTelemovel();
    }

    public static ArrayList<Produto> removerProduto(Loja l) 
    {
        long auxlong;
        int opcao = menu6();
        while(opcao != 0)
        {
            switch(opcao)
            {
                case 1:
                    System.out.print("Intoduza o identificador do telemóvel a ser removido:");
                    auxlong = umLong();
                    if (l.verificarTelemovel(auxlong) == true) 
                    {
                        l.removerTelemovel(auxlong);
                        System.out.println("Produto removido com sucesso!");
                    } 
                    else
                    {
                        System.out.println("O produto não foi encontrado!");
                    }
                    break;
            }
            opcao = menu6();      
        }      
        return l.getTelemovel();
    }
    
    public static Cliente adicionarCliente() 
    {
        Cliente c = new Cliente();
        System.out.print("Introduza o nome:");
        c.setNome(umaString());
        System.out.print("Introduza a idade:");
        c.setIdade(umInt());
        System.out.print("Introduza o NIF:");
        c.setNIF(umLong());
        System.out.print("Introduza o processador:");
        c.setMorada(umaString());
        return c;
    }
    
    public static ArrayList<Cliente> modificarCliente(Loja l)
    {
        long auxlong;
        String auxstring = "";
        int opcao = menu5();
        while(opcao != 0)
        {
            switch(opcao)
            {
                case 1:
                    System.out.print("Introduza o NIF do cliente:");
                    auxlong = umLong();
                    if(l.verificarCliente(auxlong) == true) 
                    {
                        for (int i = 0; i < l.getClientes().size(); i++) 
                        {
                            if (l.getClientes().get(i).getNIF() == auxlong) 
                            {
                                System.out.print("Introduza a nova morada:");
                                auxstring = umaString();
                                l.getClientes().get(i).setMorada(auxstring);
                                System.out.println("Preço modificado com sucesso!");
                                break;
                            } 
                        }
                    }
                    else
                    {
                        System.out.println("O NIF do cliente não foi encontrado!");
                    }
                    break;
            }
            opcao = menu8();      
        }      
        return l.getClientes();
    }
    public static ArrayList<Cliente> removerCliente(Loja l) 
    {
        int auxint;
        long auxlong = 0;
        String auxstring;
        int opcao = menu9();
        while(opcao != 0)
        {
            switch(opcao)
            {
                case 1:
                    System.out.print("Intoduza o nome do cliente:");
                    auxstring = umaString();
                    auxint = 0;
                    for(int i=0; i<l.getClientes().size(); i++)
                    {
                        if(l.getClientes().get(i).getNome().equals(auxstring))
                        {
                            auxint ++;
                            if(auxint == 1)
                            {
                                auxlong = l.getClientes().get(i).getNIF();
                            }
                        }
                    }
                    if(auxint == 1) 
                    {
                        l.removerCliente(auxlong);
                        System.out.println("Cliente removido com sucesso!");
                        
                    }
                    else if(auxint >1)
                    {
                        System.out.println("Existe clientes com o mesmo nome, deve remover pelo NIF!");
                    }
                    else 
                    {
                        System.out.println("O cliente não foi encontrado!");
                    }
                    break;
                case 2:
                    System.out.print("Intoduza o NIF do cliente:");
                    auxlong = umLong();
                    if(l.verificarCliente(auxlong) == true) 
                    {
                        l.removerCliente(auxlong);
                        System.out.println("Cliente removido com sucesso!");
                    } 
                    else 
                    {
                        System.out.println("O cliente não foi encontrado!");
                    }
                    break;
            }
            opcao = menu9();      
        }      
        return l.getClientes();
    }
}
