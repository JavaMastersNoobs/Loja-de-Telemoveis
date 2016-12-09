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
                    l.removerTelemovel(removerProduto(l));
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

    public static Produto adicionarProduto() {
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
        System.out.print("Introduza a câmera traseira:");
        p.setTraseira(umaString());
        System.out.print("Introduza a câmera frontal :");
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

    public static ArrayList<Produto> modificarProduto(Loja l) {
        long auxlong;
        int auxint;
        int opcao;
        double auxdouble;
        System.out.print("Introduza o identificador do telemóvel a ser modificado:");
        auxlong = umLong();
        while (l.verificarTelemovel(auxlong) != true) {
            System.out.println("Identificador não encontrado!");
            System.out.println("1 - Modificar produto");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Introduza uma das opções:");
            opcao = umInt();
            if (opcao == 0) {
                return (l.getTelemovel());
            } else if (opcao > 1 || opcao < 0) {
                System.out.println("Deve introduzir uma das opções listadas!");
            } else {
                System.out.print("Introduza o identificador do telemovel a ser modificado:");
                auxlong = umLong();
            }
        }
        for (int i = 0; i < l.getTelemovel().size(); i++) 
        {
            if (l.getTelemovel().get(i).getId() == auxlong) 
            {
                opcao = -1;
                while (opcao < 0 || opcao > 2) 
                {
                    System.out.println("1 - Modificar preço");
                    System.out.println("2 - Aumentar quantidade em stock");
                    System.out.println("0 - Voltar ao menu principal");
                    System.out.print("Introduza uma das opções:");
                    opcao = umInt();
                    if (opcao == 0) 
                    {
                        return (l.getTelemovel());
                    } else if (opcao > 2 || opcao < 0) 
                    {
                        System.out.println("Deve introuzir uma das opções listadas!");
                    } else if (opcao == 1) 
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

    public static long removerProduto(Loja l) {
        System.out.print("Intoduza o identificador do telemóvel a ser removido:");
        long auxlong = umLong();
        if (l.verificarTelemovel(auxlong) == true) {
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("O produto não foi encontrado!");
        }
        return auxlong;
    }

    public static int menu() {
        System.out.println("==============================================================");
        System.out.println("1 - Listar telemóveis");
        System.out.println("2 - Comprar");
        System.out.println("3 - Consultar fatura");
        System.out.println("4 - Adicionar telemóvel");
        System.out.println("5 - Modificar telemóvel");
        System.out.println("6 - Remover telemóvel");
        System.out.println("0 - Sair");
        System.out.print("Introduza uma das opções:");
        int opcao = umInt();
        System.out.println("==============================================================");
        if (opcao < 0 || opcao > 6) {
            System.out.println("Deve introduzir uma das opções listadas!");
        }
        return opcao;
    }
}
