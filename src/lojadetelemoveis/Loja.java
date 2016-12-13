package lojadetelemoveis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Loja implements Serializable {

    private String nome;
    private ArrayList<Produto> telemovel;
    private ArrayList<Cliente> clientes;
    private ArrayList<Factura> facturas;

    public Loja(String nome) {
        this.nome = nome;
        telemovel = new ArrayList<Produto>();
        clientes = new ArrayList<Cliente>();
        facturas = new ArrayList<Factura>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Produto> getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(ArrayList<Produto> telemovel) {
        this.telemovel = (ArrayList<Produto>) telemovel.clone();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = (ArrayList) clientes.clone();
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = (ArrayList) facturas.clone();
    }

    public boolean verificarTelemovel(long id) {    //Função que verifica no array Telemovel se existe um dado ID
        boolean x;
        x = false;                                  //Caso exista, atribui-se "true" à variável x
        for (int i = 0; i < telemovel.size(); i++) {
            x |= telemovel.get(i).getId() == id;
        }
        return x;                                   //Se não existe, retorna "fasle" se não existe e "true" se existe

    }

    public void adicionarTelemovel(Produto p) {     //Função que adiciona um novo Telemóvel ao array Telemovel
        if (!verificarTelemovel(p.getId())) {       //Verifica se não existe Telemóvel com o mesmo ID
            telemovel.add(p);
            System.out.println("Produto adicionado com sucesso!");
        } else {                                    //Já existe um Telemóvel com o mesmo ID
            System.out.println("O produto não pode ser adicionado!");
        }
    }

    public void removerTelemovel(int i) {          //Função que remove um Telemóvel do array Telemovel, dado o endereço "i"
        telemovel.remove(i);
    }

    public int consultarTelemovel(long id) {        //Função que procura no array Telemóvel através do ID
        int auxint = -1;
        for (int i = 0; i < telemovel.size(); i++) {  //Retorna o endereço "i" do Telemóvel, caso seja encontrado
            if (telemovel.get(i).getId() == id) {
                return i;
            }
        }
        return auxint;                              //Se não for encontrado retorna "-1"
    }

    public boolean verificarCliente(long NIF) {     //Função que verifica no array Clientes se existe um dado NIF
        boolean x;
        x = false;
        for (int i = 0; i < clientes.size(); i++) {  //Caso exista, atribui-se "true" à variável x
            x |= clientes.get(i).getNIF() == NIF;
        }
        return x;                                   //Se não existe, retorna "fasle" se não existe e "true" se existe

    }

    public void adicionarCliente(Cliente c) {       //Função que adiciona ao array Clientes, se não existir, um novo Cliente
        if (!verificarCliente(c.getNIF())) {        //Verifica se não existe um Cliente com o mesmo NIF
            clientes.add(c);
            System.out.println("Cliente adicionado com sucesso!");
        } else {                                    //Já existe um Cliente com o mesmo NIF
            System.out.println("Cliente não pode ser adicionado!");
        }
    }

    public void removerCliente(int i) {              //Função que remove um Cliente do array Clientes, dado o endereço "i"
        clientes.remove(i);
    }

    public int consultarCliente(String nome) {       //Função que procura no array Clientes através do Nome
        int aux = 0, auxint = -1;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNome().equals(nome)) {       //Se o nome dado pertence ao array de clientes, então
                aux++;                                          //adiciona 1 à variavel aux e iguala auxint ao
                auxint = i;                                      //endereço "i" de um cliente com o nome pesquisado
            }
        }
        if (aux == 1) {                                         //Se "aux == 1" significa que existe um cliente com o nome pesquisado (retorna o endereço do mesmo)
            return auxint;
        }                                                       //Se "aux > 1" significa que existe mais de um cliente com o mesmo nome
        if (aux > 1) {
            return -1;                                           //Se "aux < 1 / else" significa que não existe nenhum cliente com o nome pesquisado
        } else {
            return -2;
        }

    }

    public int consultarCliente(long NIF) {                     //Função que procura no array Clientes através do Nome
        int auxint = -1;
        for (int i = 0; i < clientes.size(); i++) {             //Pesquisar no array Clientes, o NIF pesquisado

            if (clientes.get(i).getNIF() == NIF) {
                return i;                                       //Se encontra o NIF, retorna o endereço do mesmo
            }
        }
        return auxint;                                          //No caso de não existir retorna "-1"
    }

    public boolean verificarFactura(long id) {                  //Função que verifica no array Facturas se existe um dado ID
        boolean x;
        x = false;
        for (int i = 0; i < facturas.size(); i++) {
            x |= facturas.get(i).getId() == id;                 //Caso exista, atribui-se "true" à variável x
        }
        return x;                                               //Se não existe, retorna "fasle" se não existe e "true" se existe
    }

    public void adicionarFactura(Factura c) {                   //Função que adiciona ao array Facturas uma nova Factura
        if (!verificarFactura(c.getId())) {                     //Caso não exista, adiciona ao array
            facturas.add(c);

        }
    }

    public int consultarFactura(long id) {                       //Função que serve para retornar o endereço, no array Facturas, do ID dado
        int auxint = -1;
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getId() == id) {
                return i;
            }
        }
        return auxint;                                          //Se não existir retorna o valor "-1"
    }

    public int vendasDia(Data d) // quantidade de vendas num dia específico.
    {
        int count = 0;
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getData().equals(d.getData())) {
                for (int j = 0; j < facturas.get(i).getQuantidade().size(); j++) {
                    count += facturas.get(i).getQuantidade().get(j);
                }
            }
        }
        return count;
    }

    public int vendasPeriodo(Data dinicio, Data dfim) //quantidade total de vendas num período.
    {
        int count = 0;
        boolean b = dinicio.formatDate().before(dfim.formatDate());
        if (dinicio.getData().equals(dfim.getData())) {
            for (int i = 0; i < facturas.size(); i++) {
                if (dinicio.getData().equals(dfim.getData())) {
                    for (int j = 0; j < facturas.get(i).getQuantidade().size(); j++) {
                        count += facturas.get(i).getQuantidade().get(j);
                    }
                }
            }
        } else if (b == true) {
            for (int i = 0; i < facturas.size(); i++) {
                if ((facturas.get(i).formatDate().after(dinicio.formatDate()) && facturas.get(i).formatDate().before(dfim.formatDate()))
                        || ((facturas.get(i).getData().equals(dinicio.getData())) || (facturas.get(i).getData().equals(dfim.getData())))) {
                    for (int j = 0; j < facturas.get(i).getQuantidade().size(); j++) {
                        count += facturas.get(i).getQuantidade().get(j);
                    }
                }
            }
        }
        return count;
    }
}
