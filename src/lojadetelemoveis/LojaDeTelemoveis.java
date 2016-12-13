package lojadetelemoveis;

import static lojadetelemoveis.Ler.*;
import static lojadetelemoveis.Menus.*;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class LojaDeTelemoveis {

    public static void main(String[] args) throws IOException {

        System.out.println("Bem vindo à loja de telemóveis\n\n");
        Loja l = new Loja("Telemóveis");
        try //para ler o ficheiro.
        {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("teste.dat"));
            long ult = is.readLong();
            Factura.setUltimo(ult);
            l = (Loja) is.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        int opcao = menu();
        while (opcao != 0) {
            switch (opcao) {
                case 1://done
                    printProdutos(l.getTelemovel());
                    break;
                case 2://done
                    printClientes(l.getClientes());
                    break;
                case 3: //done (quase done)
                    comprar(l);
                    break;
                case 4:
                    consultarFactura(l);
                    break;
                case 5://done
                    l.adicionarTelemovel(adicionarProduto());
                    break;
                case 6://done
                    l.setTelemovel(modificarProduto(l));
                    break;
                case 7://done
                    l.setTelemovel(removerProduto(l));
                    break;
                case 8://done
                    l.adicionarCliente(adicionarCliente());
                    break;
                case 9://done
                    l.setClientes(modificarCliente(l));
                    break;
                case 10://done
                    l.setClientes(removerCliente(l));
                    break;
                case 11:
                    totalVendas(l);
                    break;
            }
            opcao = menu();
        }
        try //para guardar no ficheiro
        {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("teste.dat"));
            os.writeLong(Factura.getUltimo());
            os.writeObject(l);
            os.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Loja comprar(Loja l) throws IOException {
        long auxlong;
        int auxint = 0;
        String auxstring = "";
        int opcao = menu3();
        Cliente c = null;
        while (opcao != 0) {
            ArrayList<Produto> compras = new ArrayList<Produto>();
            ArrayList<Integer> quantidade = new ArrayList<Integer>();
            Factura f = null;
            switch (opcao) {
                case 1:
                    l.adicionarCliente(adicionarCliente());
                    break;
                case 2:
                    System.out.print("Intoduza o nome do cliente: ");
                    auxstring = umaString();
                    auxint = l.consultarCliente(auxstring);
                    if (auxint >= 0) {
                        c = (Cliente) l.getClientes().get(auxint).clone();
                        System.out.println("Cliente encontrado com sucesso!");
                    } else if (auxint == -1) {
                        System.out.println("Existe clientes com o mesmo nome, deve pesquisar pelo NIF!");
                        System.out.print("Introduza o NIF do cliente: ");
                        auxlong = umLong();
                        auxint = l.consultarCliente(auxlong);
                        if (auxint != -1) {
                            c = (Cliente) l.getClientes().get(auxint).clone();
                            System.out.println("Cliente encontrado com sucesso!");
                        } else {
                            System.out.println("O cliente não foi encontrado, deve registar-se!");
                            break;
                        }
                    } else {
                        System.out.println("O cliente não foi encontrado,deve registar-se!");
                        break;
                    }
                    int valor = -1;
                    while (valor != 0) {
                        System.out.print("Introduza o identificador do telemóvel: ");
                        auxlong = umLong();
                        int auxint2 = l.consultarTelemovel(auxlong);
                        if (auxint2 != -1) {
                            int auxint3 = 0;
                            while (auxint3 < 1) {
                                System.out.println("Qual a quantidade que deseja comprar?");
                                auxint3 = umInt();
                                if (auxint3 < 1) {
                                    System.out.println("Quantidade não permitida, introduza novamente!");
                                }
                            }
                            if (l.getTelemovel().get(auxint2).getQuantity() >= auxint3) {
                                l.getTelemovel().get(auxint2).descidaEstoque(auxint3);
                                compras.add((Produto) l.getTelemovel().get(auxint2).clone());
                                quantidade.add(auxint3);
                                System.out.println("Adicionado a lista de compras!");
                            } else if (l.getTelemovel().get(auxint2).getQuantity() == 0) {
                                System.out.println("Stock esgotado!");
                            } else {
                                while (l.getTelemovel().get(auxint2).getQuantity() < auxint3) {
                                    System.out.println("Não há telemóveis suficientes.");
                                    System.out.println("Quantidade disponível em stock:" + l.getTelemovel().get(auxint2).getQuantity());
                                    System.out.print("Introduza outra quantidade: ");
                                    auxint3 = umInt();
                                }
                                l.getTelemovel().get(auxint2).descidaEstoque(auxint3);
                                compras.add((Produto) l.getTelemovel().get(auxint2).clone());
                                quantidade.add(auxint3);
                                System.out.println("Adicionado a lista de compras!");
                            }
                        } else {
                            System.out.println("O identificador do telemóvel não foi encontrado!");
                        }
                        System.out.println("===============================================================");
                        System.out.println("1 - Comprar mais produtos");
                        System.out.println("0 - Encerrar compra");
                        System.out.print("Introduza uma das opções: ");
                        valor = umInt();
                        System.out.println("===============================================================");
                        while (valor < 0 || valor > 1) {
                            System.out.println("Deve introduzir uma das opções listadas!");
                            System.out.println("===============================================================");
                            System.out.println("1 - Comprar mais produtos");
                            System.out.println("0 - Encerrar compra");
                            System.out.print("Introduza uma das opções: ");
                            valor = umInt();
                            System.out.println("===============================================================");
                        }
                    }
                    break;
            }
            //Emitir fatura
            if (!compras.isEmpty()) {
                Data data = new Data();
                f = new Factura(data, c, compras, quantidade);
                l.adicionarFactura(f);
                l.getClientes().get(auxint).getFacturas().add(f);
                f.print();
            }
            opcao = menu3();
        }
        return l;
    }

    public static void consultarFactura(Loja l) {
        long auxlong;
        int auxint, auxint2 = -1;
        String auxstring = "";
        int opcao = menu4();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.print("Introduza o identificador da factura: ");
                    auxlong = umLong();
                    auxint = l.consultarFactura(auxlong);
                    if (auxint >= 0) {
                        System.out.println("Fatura encontrada com sucesso");
                        l.getFacturas().get(auxint).print();
                    } else {
                        System.out.println("Fatura não encontrada");
                    }
                    break;
                case 2:
                    System.out.print("Intoduza o nome do cliente: ");
                    auxstring = umaString();
                    auxint = l.consultarCliente(auxstring);
                    if (auxint >= 0) {
                        System.out.println("Cliente encontrado com sucesso!");
                    } else if (auxint == -1) {
                        System.out.println("Existe clientes com o mesmo nome, deve pesquisar pelo NIF!");
                        System.out.print("Introduza o NIF do cliente: ");
                        auxlong = umLong();
                        auxint = l.consultarCliente(auxlong);
                        if (auxint != -1) {
                            System.out.println("Cliente encontrado com sucesso!");
                        } else {
                            System.out.println("O cliente não foi encontrado!");
                            break;
                        }
                    } else {
                        System.out.println("O cliente não foi encontrado!");
                        break;
                    }

                    int valor = -1;
                    while (valor != 0) {
                        System.out.print("Introduza o identificador da factura: ");
                        auxlong = umLong();
                        for (int i = 0; i < l.getClientes().get(auxint).getFacturas().size(); i++) {
                            if (l.getClientes().get(auxint).getFacturas().get(i).getId() == auxlong) {
                                auxint2 = i;
                            }
                        }
                        if (auxint2 >= 0) {
                            System.out.println("Fatura encontrada com sucesso");
                            l.getFacturas().get(auxint2).print();
                        } else {
                            System.out.println("Fatura não encontrada");
                        }
                        System.out.println("===============================================================");
                        System.out.println("1 - Consultar outra factura");
                        System.out.println("0 - Voltar ao menu anterior");
                        System.out.print("Introduza uma das opções: ");
                        valor = umInt();
                        System.out.println("===============================================================");
                        while (valor < 0 || valor > 1) {
                            System.out.println("Deve introduzir uma das opções listadas!");
                            System.out.println("===============================================================");
                            System.out.println("1 - Consultar outra factura");
                            System.out.println("0 - Voltar ao menu anterior");
                            System.out.print("Introduza uma das opções: ");
                            valor = umInt();
                            System.out.println("===============================================================");
                        }
                    }
                    break;
            }
            opcao = menu4();
        }
    }

    public static Produto adicionarProduto() {
        Produto p = new Produto();
        System.out.print("Introduza a marca: ");
        p.setMarca(umaString());
        System.out.print("Introduza o modelo: ");
        p.setModelo(umaString());
        System.out.print("Introduza o ano: ");
        p.setAno(umInt());
        System.out.print("Introduza o processador: ");
        p.setProcessador(umaString());
        System.out.print("Introduza a bateria: ");
        p.setBateria(umaString());
        System.out.print("Introduza a memória interna: ");
        p.setMinterna(umaString());
        System.out.print("Introduza a memória RAM: ");
        p.setRam(umaString());
        System.out.print("Introduza a câmara traseira: ");
        p.setTraseira(umaString());
        System.out.print("Introduza a câmara frontal: ");
        p.setFrontal(umaString());
        System.out.print("Introduza a ecrã: ");
        p.setEcra(umaString());
        System.out.print("Introduza o sistema operativo: ");
        p.setSo(umaString());
        System.out.print("Introduza o preço: ");
        p.setPreco(umDouble());
        System.out.print("Introduza a quantidade em stock: ");
        p.setQuantity(umInt());
        System.out.print("Introduza o identificador: ");
        p.setId(umLong());
        return p;
    }

    public static ArrayList<Produto> modificarProduto(Loja l) {
        int auxint, auxint2 = 0;
        long auxlong;
        auxlong = 0;
        double auxdouble;
        auxdouble = 0;
        String auxstring;
        System.out.print("Introduzir o número identificador do telemóvel a modificar: ");
        auxlong = umLong();
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
            int opcao = menu6();
            while (opcao != 0) {
                switch (opcao) {
                    case 1:
                        System.out.print("Introduza modificação: ");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setMarca(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 2:
                        System.out.print("Introduza modificação: ");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setModelo(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 3:
                        System.out.print("Introduza modificação: ");
                        auxint = umInt();
                        l.getTelemovel().get(auxint2).setAno(auxint);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 4:
                        System.out.print("Introduza modificação: ");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setProcessador(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 5:
                        System.out.print("Introduza modificação: ");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setBateria(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 6:
                        System.out.print("Introduza modificação: ");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setMinterna(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 7:
                        System.out.print("Introduza modificação: ");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setRam(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 8:
                        System.out.print("Introduza modificação: ");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setTraseira(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 9:
                        System.out.print("Introduza modificação: ");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setFrontal(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 10:
                        System.out.print("Introduza modificação: ");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setEcra(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 11:
                        System.out.print("Introduza modificação: ");
                        auxstring = umaString();
                        l.getTelemovel().get(auxint2).setSo(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 12:
                        System.out.print("Introduza modificação: ");
                        auxdouble = umDouble();
                        l.getTelemovel().get(auxint2).setPreco(auxdouble);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 13:
                        System.out.print("Introduza modificação: ");
                        auxint = umInt();
                        l.getTelemovel().get(auxint2).setQuantity(auxint);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                }
                opcao = menu6();
            }
        }
        return l.getTelemovel();
    }

    public static ArrayList<Produto> removerProduto(Loja l) {
        long auxlong;
        int auxint;
        int opcao = menu7();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.print("Intoduza o identificador do telemóvel a ser removido: ");
                    auxlong = umLong();
                    auxint = l.consultarTelemovel(auxlong);
                    if (auxint != -1) {
                        l.removerTelemovel(auxint);
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("O produto não foi encontrado!");
                    }
                    break;
            }
            opcao = menu7();
        }
        return l.getTelemovel();
    }

    public static Cliente adicionarCliente() {
        Cliente c = new Cliente();
        System.out.print("Introduza o nome: ");
        c.setNome(umaString());
        System.out.print("Introduza a data de nascimento 'dd/MM/yyyy': ");
        c.setDatanascimento(lerDatas());
        System.out.print("Introduza o NIF: ");
        long auxlong = umLong();
        long length = (long) (Math.log10(auxlong) + 1);
        if (length < 9 || length > 9) {
            while (length < 9 || length > 9) {
                System.out.print("O NIF tem de ter 9 dígitos. Por favor introduza de novo o NIF: ");
                auxlong = umLong();
                length = (long) (Math.log10(auxlong) + 1);
            }
            c.setNIF(auxlong);
        } else {
            c.setNIF(auxlong);
        }
        System.out.print("Introduza o contacto:");
        auxlong = umLong();
        length = (long) (Math.log10(auxlong) + 1);
        if (length < 9 || length > 9) {
            while (length < 9 || length > 9) {
                System.out.print("O contacto tem de ter 9 dígitos. Por favor introduza de novo o contacto: ");
                auxlong = umLong();
                length = (long) (Math.log10(auxlong) + 1);
            }
            c.setContacto(auxlong);
        } else {
            c.setContacto(auxlong);
        }
        System.out.print("Introduza a morada: ");
        c.setMorada(umaString());
        return c;
    }

    public static ArrayList<Cliente> modificarCliente(Loja l) {
        int auxint, auxint2 = 0;
        long auxlong;
        String auxstring;
        System.out.print("Intoduza o nome do cliente: ");
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
            System.out.println("Introduza o NIF do cliente: ");
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
            int opcao = menu9();
            while (opcao != 0) {
                switch (opcao) {
                    case 1:
                        System.out.print("Introduza modificação: ");
                        auxstring = umaString();
                        l.getClientes().get(auxint2).setNome(auxstring);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 2:
                        System.out.print("Introduza modificação: ");
                        Data dnasc = lerDatas();
                        l.getClientes().get(auxint2).setDatanascimento(dnasc);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 3:
                        System.out.print("Introduza modificação:");
                        auxint = umInt();
                        l.getClientes().get(auxint2).setNIF(auxint);
                        System.out.println("Modificação feita com sucesso.");
                        break;
                    case 4:
                        System.out.print("Introduza modificação: ");
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
                opcao = menu9();
            }
        }
        return l.getClientes();
    }

    public static ArrayList<Cliente> removerCliente(Loja l) {
        int auxint;
        long auxlong = 0;
        String auxstring;
        int opcao = menu10();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.print("Intoduza o nome do cliente: ");
                    auxstring = umaString();
                    auxint = l.consultarCliente(auxstring);
                    if (auxint >= 0) {
                        l.removerCliente(auxint);
                        System.out.println("Cliente removido com sucesso!");

                    } else if (auxint == -1) {
                        System.out.println("Existe clientes com o mesmo nome, deve pesquisar pelo NIF!");
                    } else {
                        System.out.println("O cliente não foi encontrado!");
                    }
                    break;
                case 2:
                    System.out.print("Intoduza o NIF do cliente: ");
                    auxlong = umLong();
                    auxint = l.consultarCliente(auxlong);
                    if (auxint != -1) {
                        l.removerCliente(auxint);
                        System.out.println("Cliente removido com sucesso!");
                    } else {
                        System.out.println("O cliente não foi encontrado!");
                    }
                    break;
            }
            opcao = menu10();
        }
        return l.getClientes();
    }

    public static Data lerDatas() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                String a = umaString();
                Date dateA = format.parse(a);
                Data d = new Data(dateA);
                return d;
            } catch (Exception e) {
                System.out.println("A data deve ser no formato 'dd/MM/yyyy'");
            }
        }
    }

    public static void printProdutos(ArrayList<Produto> telemovel) {
        System.out.println("Lista de produtos\n");
        for (int i = 0; i < telemovel.size(); i++) {
            System.out.println("Marca: " + telemovel.get(i).getMarca());
            System.out.println("Modelo: " + telemovel.get(i).getModelo());
            System.out.println("Ano: " + telemovel.get(i).getAno());
            System.out.println("Processador: " + telemovel.get(i).getProcessador());
            System.out.println("Bateria: " + telemovel.get(i).getBateria());
            System.out.println("Memória Interna: " + telemovel.get(i).getMinterna());
            System.out.println("Memória RAM: " + telemovel.get(i).getRam());
            System.out.println("Câmara traseira: " + telemovel.get(i).getTraseira());
            System.out.println("Câmara frontal: " + telemovel.get(i).getFrontal());
            System.out.println("Sistema Operativo: " + telemovel.get(i).getSo());
            System.out.println("Preço: " + telemovel.get(i).getPreco() + "\u20AC");
            System.out.println("Quantidade: " + telemovel.get(i).getQuantity());
            System.out.println("Identificador: " + telemovel.get(i).getId() + "\n");

        }
    }

    public static void printClientes(ArrayList<Cliente> clientes) {
        System.out.println("Lista de clientes\n");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("Nome: " + clientes.get(i).getNome());
            System.out.println("Data de nascimento: " + clientes.get(i).getDatanascimento());
            System.out.println("NIF: " + clientes.get(i).getNIF());
            System.out.println("Contacto: " + clientes.get(i).getContacto());
            System.out.println("Morada: " + clientes.get(i).getMorada() + "\n");

        }
    }

    public static void totalVendas(Loja l) {
        long auxlong = 0;
        int opcao = menu11();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.print("Introduza a data (dd/mm/yyyy): ");
                    Data d = lerDatas();
                    System.out.println(l.vendasDia(d));
                    break;
                case 2:
                    System.out.print("Introduza a data de inicio (dd/mm/yyyy): ");
                    Data i = lerDatas();
                    System.out.print("Introduz a data de fim (dd/mm/yyyy): ");
                    Data f = lerDatas();
                    System.out.println(l.vendasPeriodo(i, f));
                    break;
            }
            opcao = menu11();
        }
    }

}
