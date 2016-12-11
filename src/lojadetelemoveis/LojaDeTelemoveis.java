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
        System.out.print("Introduza a quantidade em stock:");
        p.setQuantity(umInt());
        System.out.print("Introduza o identificador:");
        p.setId(umLong());
        return p;
    }

    /*public static ArrayList<Produto> modificarProduto(Loja l) {
        int auxint, auxint2 = 0;
        long auxlong;
        double auxdouble;
        String auxstring;
        int opcao = menu5();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.print("Introduza o identificador do telemóvel a ser modificado:");
                    auxlong = umLong();
                    if (l.verificarTelemovel(auxlong) == true) {
                        for (int i = 0; i < l.getTelemovel().size(); i++) {
                            if (l.getTelemovel().get(i).getId() == auxlong) {
                                System.out.print("Introduza o novo preço do telemóvel:");
                                auxdouble = umDouble();
                                l.getTelemovel().get(i).setPreco(auxdouble);
                                System.out.println("Preço modificado com sucesso!");
                            }
                        }
                    } else {
                        System.out.println("O identificador não foi encontrado!");
                    }
                    break;
                case 2:
                    System.out.print("Introduza o identificador do telemóvel a ser modificado:");
                    auxlong = umLong();
                    if (l.verificarTelemovel(auxlong) == true) {
                        for (int i = 0; i < l.getTelemovel().size(); i++) {
                            if (l.getTelemovel().get(i).getId() == auxlong) {
                                System.out.print("Introduza valor a ser aumentado no stock:");
                                auxint = umInt();
                                l.getTelemovel().get(i).aumentarEstoque(auxint);
                                System.out.println("Valor aumentado com sucesso!");
                                break;
                            }
                        }
                    } else {
                        System.out.println("O identificador não foi encontrado!");
                    }
                    break;
            }
            opcao = menu5();
        }
        return l.getTelemovel();
    }
     */
    public static ArrayList<Produto> modificarProduto(Loja l) {
        int auxint, auxint2 = 0;
        long auxlong;
        auxlong = 0;
        double auxdouble;
        auxdouble = 0;
        String auxstring;
        System.out.print("Introduzir o número identificador do telemóvel a modificar:");
        auxint = 0;
        for (int i = 0; i < l.getTelemovel().size(); i++) {
            if (l.getTelemovel().get(i).getId() == auxlong) {
                auxint++;
                if (auxint == 1) {
                    auxint2 = i;
                }
            }
        }
        if (auxint == 1) {
            System.out.println("Telemóvel encontrado.");
        } else {
            System.out.println("Telemóvel não encontrado!");
        }
        if (auxint == 1) {
            int opcao = menu10();
            while (opcao != 0) {
                switch (opcao) {
                    case 1:
                        System.out.print("Introduza modificação:");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setMarca(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 2:
                        System.out.print("Introduza modificação:");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setModelo(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 3:
                        System.out.print("Introduza modificação:");
                        auxint = umInt();
                        l.getTelemovel().get(auxint2).setAno(auxint);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 4:
                        System.out.print("Introduza modificação:");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setProcessador(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 5:
                        System.out.print("Introduza modificação:");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setBateria(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 6:
                        System.out.print("Introduza modificação:");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setMinterna(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 7:
                        System.out.print("Introduza modificação:");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setRam(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 8:
                        System.out.print("Introduza modificação:");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setTraseira(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 9:
                        System.out.print("Introduza modificação:");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setFrontal(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 10:
                        System.out.print("Introduza modificação:");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setEcra(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 11:
                        System.out.print("Introduza modificação:");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setSo(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 12:
                        System.out.print("Introduza modificação:");
                        auxdouble = umDouble();
                        l.getTelemovel().get(auxint2).setPreco(auxdouble);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 13:
                        System.out.print("Introduza modificação:");
                        auxint = umInt();
                        l.getTelemovel().get(auxint2).setQuantity(auxint);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                }
                opcao = menu10();
            }
        }
        return l.getTelemovel();
    }

    public static ArrayList<Produto> removerProduto(Loja l) {
        long auxlong;
        int opcao = menu6();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.print("Intoduza o identificador do telemóvel a ser removido:");
                    auxlong = umLong();
                    if (l.verificarTelemovel(auxlong) == true) {
                        l.removerTelemovel(auxlong);
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("O produto não foi encontrado!");
                    }
                    break;
            }
            opcao = menu6();
        }
        return l.getTelemovel();
    }

    public static Cliente adicionarCliente() {
        Cliente c = new Cliente();
        System.out.print("Introduza o nome:");
        c.setNome(umaString());
        System.out.print("Introduza a data de nascimento:");
        c.setDatanascimento(umaString());
        System.out.print("Introduza o NIF:");
        long auxlong = umLong();
        long length = (long) (Math.log10(auxlong) + 1);
        if (length < 9 || length > 9) {
            while (length < 9 || length > 9) {
                System.out.println("O NIF tem de ter 9 dígitos. Por favor introduza de novo o NIF:");
                auxlong = umLong();
                length = (long) (Math.log10(auxlong) + 1);
            }
            c.setNIF(auxlong);
        } else {
            c.setNIF(auxlong);
        }
        System.out.println("Introduza o contacto:");
        auxlong = umLong();
        length = (long) (Math.log10(auxlong) + 1);
        if (length < 9 || length > 9) {
            while (length < 9 || length > 9) {
                System.out.println("O contacto tem de ter 9 dígitos. Por favor introduza de novo o contacto:");
                auxlong = umLong();
                length = (long) (Math.log10(auxlong) + 1);
            }
            c.setContacto(auxlong);
        } else {
            c.setContacto(auxlong);
        }
        System.out.print("Introduza a morada:");
        c.setMorada(umaString());
        return c;
    }

    public static ArrayList<Cliente> modificarCliente(Loja l) {
        int auxint, auxint2 = 0;
        long auxlong;
        String auxstring;
        System.out.print("Intoduza o nome do cliente:");
        auxstring = umaString();
        auxint = 0;
        for (int i = 0; i < l.getClientes().size(); i++) {
            if (l.getClientes().get(i).getNome().equals(auxstring)) {
                auxint++;
                if (auxint == 1) {
                    auxint2 = i;
                }
            }
        }
        if (auxint == 1) {
            System.out.println("Cliente encontrado.");
        } else if (auxint > 1) {
            System.out.println("Existe clientes com o mesmo nome, deve pesquisar pelo NIF!");
            System.out.println("Introduza o NIF do cliente:");
            auxlong = umLong();
            auxint = 0;
            if (l.verificarCliente(auxlong) == true) {
                for (int i = 0; i < l.getClientes().size(); i++) {
                    if (l.getClientes().get(i).getNIF() == auxlong) {
                        auxint++;
                        if (auxint == 1) {
                            auxint2 = i;
                        }
                    }
                }
            }
            if (auxint == 1) {
                System.out.println("Cliente encontrado.");
            } else {
                System.out.println("O cliente não foi encontrado!");
            }
        } else {
            System.out.println("O cliente não foi encontrado!");
        }

        if (auxint == 1) {
            int opcao = menu8();
            while (opcao != 0) {
                switch (opcao) {
                    case 1:
                        System.out.print("Introduza modificação:");
                        auxstring = umaString();
                        l.getClientes().get(auxint2).setNome(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 2:
                        System.out.print("Introduza modificação:");
                        auxstring = umaString();
                        l.getClientes().get(auxint2).setDatanascimento(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 3:
                        System.out.print("Introduza modificação:");
                        auxint = umInt();
                        l.getClientes().get(auxint2).setNIF(auxint);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 4:
                        System.out.print("Introduza modificação:");
                        auxstring = umaString();
                        l.getClientes().get(auxint2).setMorada(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 5:
                        System.out.print("Introduza modificação:");
                        auxlong = umLong();
                        l.getClientes().get(auxint2).setContacto(auxlong);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                }
                opcao = menu8();
            }
        }
        return l.getClientes();
    }

    public static ArrayList<Cliente> removerCliente(Loja l) {
        int auxint;
        long auxlong = 0;
        String auxstring;
        int opcao = menu9();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.print("Intoduza o nome do cliente:");
                    auxstring = umaString();
                    auxint = 0;
                    for (int i = 0; i < l.getClientes().size(); i++) {
                        if (l.getClientes().get(i).getNome().equals(auxstring)) {
                            auxint++;
                            if (auxint == 1) {
                                auxlong = l.getClientes().get(i).getNIF();
                            }
                        }
                    }
                    if (auxint == 1) {
                        l.removerCliente(auxlong);
                        System.out.println("Cliente removido com sucesso!");
                    } else if (auxint > 1) {
                        System.out.println("Existe clientes com o mesmo nome, deve pesquisar pelo NIF!");
                    } else {
                        System.out.println("O cliente não foi encontrado!");
                    }
                    break;
                case 2:
                    System.out.print("Intoduza o NIF do cliente:");
                    auxlong = umLong();
                    if (l.verificarCliente(auxlong) == true) {
                        l.removerCliente(auxlong);
                        System.out.println("Cliente removido com sucesso!");
                    } else {
                        System.out.println("O cliente não foi encontrado!");
                    }
                    break;
            }
            opcao = menu9();
        }
        return l.getClientes();
    }
}
