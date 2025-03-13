package app.src.cli;

import app.src.models.Pessoa;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    Scanner scan = new Scanner(System.in);
    ArrayList<Pessoa> pessoas = new ArrayList<>();
    Pessoa pessoaExe = new Pessoa();

    public boolean  menu() {
        int op;
        System.out.println("--MENU--");
        System.out.println("1- Cadastrar pessoa");
        System.out.println("2- Editar pessoa");
        System.out.println("3- Visualizar pessoa");
        System.out.println("4- Excluir pessoa");
        System.out.println("5- Sair");
        System.out.println("Digite sua operação: ");
        op = scan.nextInt();
        scan.nextLine();
        switch (op) {
            case 1:
                pessoas = pessoaExe.cadastrarPessoa(pessoas);
                break;
            case 2:
                pessoas = pessoaExe.editarPessoa(pessoas);
                break;
            case 3:
                pessoaExe.visualizarPessoas(pessoas);
                break;
            case 4:
                pessoas = pessoaExe.excluirPessoa(pessoas);
                break;
            case 5:
                String sair;
                do {
                    System.out.println("Deseja realmente sair ? S/N");
                    sair = scan.nextLine().toUpperCase();
                    switch (sair) {
                        case "S":
                            return false;
                        case "N":
                            return true;
                    }
                } while (!sair.equals("S") || !sair.equals("N"));
            break;
            default:
                System.out.println("Opção inválida");
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        boolean exe = true;
        while (exe) {
            exe = main.menu();
        }
    }
}
