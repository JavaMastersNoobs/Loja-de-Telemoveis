package lojadetelemoveis;

import static lojadetelemoveis.Ler.umInt;

public class Menus {

    public static int menu()
    {
        System.out.println("================================================================");
        System.out.println("1 - Listar telemóveis");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Comprar");
        System.out.println("4 - Consultar fatura");
        System.out.println("5 - Adicionar um telemóvel");
        System.out.println("6 - Modificar telemóvel");
        System.out.println("7 - Remover telemóvel");
        System.out.println("8 - Adicionar um cliente");
        System.out.println("9 - Modficar dados do cliente");
        System.out.println("10 - Remover um cliente");
        System.out.println("11 - Informações sobre vendas");
        System.out.println("0 - Sair");
        System.out.print("Introduza uma das opções:");
        int opcao = umInt();
        System.out.println("================================================================");
        if (opcao < 0 || opcao > 11) 
        {
            System.out.println("Deve introduzir uma das opções listadas!");
        }
        return opcao;
    }
    
    public static int menu3()
    {
        System.out.println("================================================================");
        System.out.println("1 - Adicionar novo cliente");
        System.out.println("2 - Realizar compra");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Introduza uma das opções:");
        int opcao = umInt();
        System.out.println("================================================================");
        if (opcao < 0 || opcao > 2) {
            System.out.println("Deve introduzir uma das opções listadas!");
        }
        return opcao;
    }
    
    
    public static int menu4()
    {
        System.out.println("================================================================");
        System.out.println("1 - Consultar factura pelo numero de identificador");
        System.out.println("2 - Consutar factura através do nome de um cliente");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Introduza uma das opções:");
        int opcao = umInt();
        System.out.println("================================================================");
        if (opcao < 0 || opcao > 2) {
            System.out.println("Deve introduzir uma das opções listadas!");
        }
        return opcao;
    }

    public static int menu6() 
    {
        System.out.println("===============================================================");
        {
            System.out.println("1 - Marca");
            System.out.println("2 - Modelo");
            System.out.println("3 - Ano");
            System.out.println("4 - Processador");
            System.out.println("5 - Bateria");
            System.out.println("6 - Memória Interna");
            System.out.println("7 - Memória RAM");
            System.out.println("8 - Câmara Traseira");
            System.out.println("9 - Câmara Frontal");
            System.out.println("10 - Ecrã");
            System.out.println("11 - Sistema Operativo");
            System.out.println("12 - Preço");
            System.out.println("13 - Quantidade");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Introduza uma das opções:");
            int opcao = umInt();
            System.out.println("===============================================================");
            if (opcao < 0 || opcao > 13) {
                System.out.println("Deve introduzir uma das opções listadas!");
            }
            return opcao;
        }
    }


    public static int menu7() {
        System.out.println("===============================================================");
        System.out.println("1 - Remover produto pelo seu identificador");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Introduza uma das opções:");
        int opcao = umInt();
        System.out.println("===============================================================");
        if (opcao < 0 || opcao > 1) {
            System.out.println("Deve introduzir uma das opções listadas!");
        }
        return opcao;
    }

    public static int menu9() {
        System.out.println("===============================================================");
        System.out.println("1 - Modificar nome");
        System.out.println("2 - Modificar data de nascimento");
        System.out.println("3 - Modificar NIF");
        System.out.println("4 - Modificar morada");
        System.out.println("5 - Modificar contacto");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Introduza uma das opções:");
        int opcao = umInt();
        System.out.println("===============================================================");
        if (opcao < 0 || opcao > 9) {
            System.out.println("Deve introduzir uma das opções listadas!");
        }
        return opcao;
    }

    public static int menu10() {
        System.out.println("===============================================================");
        System.out.println("1 - Remover cliente pelo nome");
        System.out.println("2 - Remover cliente pelo NIF");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Introduza uma das opções:");
        int opcao = umInt();
        System.out.println("===============================================================");
        if (opcao < 0 || opcao > 2) {
            System.out.println("Deve introduzir uma das opções listadas!");
        }
        return opcao;
    }
    
    public static int menu11()
    {
        System.out.println("===============================================================");
        System.out.println("1 - Número de vendas num determinado dia");
        System.out.println("2 - Número de vendas total num determinado período");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Introduza uma das opções:");
        int opcao = umInt();
        System.out.println("===============================================================");
        if (opcao < 0 || opcao > 2) {
            System.out.println("Deve introduzir uma das opções listadas!");
        }
        return opcao;

    }
}


