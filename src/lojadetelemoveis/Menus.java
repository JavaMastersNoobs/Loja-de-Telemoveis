package lojadetelemoveis;

import static lojadetelemoveis.Ler.umInt;

public class Menus {

    public static int menu() {
        System.out.println("================================================================");
        System.out.println("1 - Listar telemóveis");
        System.out.println("2 - Comprar");
        System.out.println("3 - Consultar fatura");
        System.out.println("4 - Adicionar um telemóvel");
        System.out.println("5 - Modificar telemóve");
        System.out.println("6 - Remover telemóvel");
        System.out.println("7 - Adicionar um cliente");
        System.out.println("8 - Modficar dados do cliente");
        System.out.println("9 - Remover um cliente");
        System.out.println("0 - Sair");
        System.out.print("Introduza uma das opções:");
        int opcao = umInt();
        System.out.println("================================================================");
        if (opcao < 0 || opcao > 9) {
            System.out.println("Deve introduzir uma das opções listadas!");
        }
        return opcao;
    }

    public static int menu5() {
        System.out.println("===============================================================");
        System.out.println("1 - Modificar preço do produto");
        System.out.println("2 - Aumentar quantidade em stock");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Introduza uma das opções:");
        int opcao = umInt();
        System.out.println("===============================================================");
        if (opcao < 0 || opcao > 2) {
            System.out.println("Deve introduzir uma das opções listadas!");
        }
        return opcao;
    }

    public static int menu6() {
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

    public static int menu8() {
        System.out.println("===============================================================");
        System.out.println("1 - Modificar morada pesquisando pelo nome do cliente");
        System.out.println("2 - Modificar morada pesquisando pelo NIF do cliente");
        System.out.println("0 - Voltar ao menu principal");
        System.out.print("Introduza uma das opções:");
        int opcao = umInt();
        System.out.println("===============================================================");
        if (opcao < 0 || opcao > 2) {
            System.out.println("Deve introduzir uma das opções listadas!");
        }
        return opcao;
    }

    public static int menu9() {
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

}
