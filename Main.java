import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    Scanner scan = new Scanner(System.in);
    ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    public void menu(){
        int op;
            do{
                System.out.println("--MENU--");
                System.out.println("1- Cadastrar pessoa");
                System.out.println("2- Editar pessoa");
                System.out.println("3- Visualizar pessoa");
                System.out.println("4- Excluir pessoa");
                System.out.println("5- Sair");
                System.out.println("Digite sua operação: ");
                op = scan.nextInt();
                scan.nextLine();
                switch (op){
                    case 1:
                        cadastrarPessoa();
                    break;
                    case 2:
                        editarPessoa();
                    break;
                    case 3:
                        visualizarPessoas();
                    break;
                    case 4:
                        excluirPessoa();
                    break;
                    case 5:
                        String sair;
                        do{
                            System.out.println("Deseja realmente sair ? S/N");
                            sair = scan.nextLine().toUpperCase();
                            switch (sair){
                                case "S":
                                break;
                                case "N":
                                    menu();
                                break;
                            }
                        } while (sair.equals("S") || sair.equals("N"));
                    break;
                    default:
                        System.out.println("Opção inválida");
                        menu();
                }
            }while(op > 5 || op < 1);
    }
}