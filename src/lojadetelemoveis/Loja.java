package lojadetelemoveis;

import java.io.Serializable;
import java.util.ArrayList;

public class Loja implements Serializable {

    private String nome;
    private ArrayList<Produto> telemovel;
    private ArrayList<Cliente> clientes;

    public Loja(String nome) {
        this.nome = nome;
        telemovel = new ArrayList<Produto>();
        clientes = new ArrayList<Cliente>();
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public ArrayList<Produto> getTelemovel()
    {
        return telemovel;
    }

    public void setTelemovel(ArrayList<Produto> telemovel) 
    {
        this.telemovel = (ArrayList<Produto>) telemovel.clone();
    }

    public ArrayList<Cliente> getClientes() 
    {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = (ArrayList) clientes.clone();
    }

    public boolean verificarTelemovel(long id)
    {
        boolean x;
        x = false;
        for (int i = 0; i < telemovel.size(); i++) 
        {
            x |= telemovel.get(i).getId() == id;
        }
        return x;

    }

    public void adicionarTelemovel(Produto p) 
    {
        if (!verificarTelemovel(p.getId()))
        {
            telemovel.add(p);
            System.out.println("Produto adicionado com sucesso!");
        }
        else
        {
            System.out.println("O produto não pode ser adicionado!");
        }
    }

    public void removerTelemovel(int i) 
    {
        telemovel.remove(i);
    }
    
    public int consultarTelemovel(long id)
    {   
        int auxint = -1;
        for(int i=0; i<telemovel.size(); i++)
        {
            if(telemovel.get(i).getId() == id)
            {
                return i;
            }
        }
        return auxint;
    }
    
    
    public boolean verificarCliente(long NIF) 
    {
        boolean x;
        x = false;
        for (int i = 0; i < clientes.size(); i++)
        {
            x |= clientes.get(i).getNIF() == NIF;
        }
        return x;

    }
    public void adicionarCliente(Cliente c) 
    {
        if (! verificarCliente(c.getNIF())) 
        {
            clientes.add(c);
            System.out.println("Cliente adicionado com sucesso!");
        }
        else
        {
            System.out.println("Cliente não pode ser adicionado!");
        }
    }
    public void removerCliente(int i) 
    {
        clientes.remove(i);
    }
    
    public int consultarCliente(String nome)
    {   
        int aux=0, auxint=-1;
        for(int i=0; i<clientes.size(); i++)
        {
            if(clientes.get(i).getNome().equals(nome))
            {
                aux ++;
                auxint = i;
            }
        }
        if(aux == 1)
        {
            return auxint;
        }
        if(aux >1)
        {
            return -1;
        }
        else
        {
            return -2;
        }
        
    }
    public int consultarCliente(long NIF)
    {   
        int auxint = -1;
        for(int i=0; i<clientes.size(); i++)
        {
            if(clientes.get(i).getNIF() == NIF)
            {
                return i;
            }
        }
        return auxint;
    }
}
