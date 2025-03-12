import java.util.ArrayList;
import java.util.Scanner;
public class Pessoa {
    private Scanner scan = new Scanner(System.in);

    public String nome;
    public int idade;
    private String email;

    public Pessoa(String nome, int idade, String email){
        this.nome = nome;
        this.idade = idade;
        setEmail(email);
    }

    public Pessoa (){};

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email.toLowerCase();
    }

    public ArrayList<Pessoa> cadastrarPessoa(ArrayList<Pessoa> pessoas){
        
        System.out.println("Digite o nome da pessoa: ");
        String nome = scan.nextLine();
        scan.nextLine();
        System.out.println("Digite a idade da peessoa");
        int idade = scan.nextInt();
        System.out.println("Digite o email da pessoa");
        String email = scan.nextLine();

        
        boolean loop = true;
        while(loop){
            System.out.println("Os dados estão corretos ? (S/N)");
            System.err.println("Nome: "+nome);
            System.err.println("Idade: "+idade);
            System.err.println("Email: "+email);
            String resposta = scan.nextLine().toLowerCase();
            switch (resposta){
                case "s":
                    loop = false;
                break;
                case "n":
                    cadastrarPessoa(pessoas);
                break;
                default:
                    System.out.println("Resposta inválida");
            }
        }

        Pessoa pessoa = new Pessoa(nome,idade,email);

        pessoas.add(pessoa);

        return pessoas;
    }

    public ArrayList<Pessoa> editarPessoa(ArrayList<Pessoa> pessoas){

        int contador = 1;
        System.out.println("Qual pessoa deseja editar ?\n Digite o índice(ex: 1,2,3...)");
        System.err.println("Nomes: ");
        for (Pessoa pessoa : pessoas){
            System.out.printf("%d- %s\n",contador,pessoa.nome);
            contador++;
        }
        int indicePessoaSelecionado = scan.nextInt() - 1;
        boolean loop = true;
        do { 
            System.out.println("\nO que deseja editar?\n Digite o índice(ex: 1,2,3...) ");
            System.out.printf("1- Nome: %s \n",pessoas.get(indicePessoaSelecionado).nome);
            System.out.printf("2- Idade: %d \n",pessoas.get(indicePessoaSelecionado).idade);
            System.out.printf("3- Email: %s \n",pessoas.get(indicePessoaSelecionado).email);
            int indiceAtributo = scan.nextInt();
            String continuador = " ";
            switch (indiceAtributo){
                case 1:
                    System.out.println("Digite o novo nome: ");
                    pessoas.get(indicePessoaSelecionado).nome = scan.nextLine();
                    System.out.print("Deseja editar outra informação ? (S/N)");
                    continuador = scan.nextLine().toLowerCase();
                break;
                case 2:
                    System.out.println("Digite a nova idade: ");
                    pessoas.get(indicePessoaSelecionado).idade = scan.nextInt();
                    System.out.print("Deseja editar outra informação ? (S/N)");
                    continuador = scan.nextLine().toLowerCase();
                break;
                case 3:
                    System.out.println("Digite o novo email: ");
                    pessoas.get(indicePessoaSelecionado).email = scan.nextLine();
                    System.out.print("Deseja editar outra informação ? (S/N)");
                    continuador = scan.nextLine().toLowerCase();
                break;
                default:
                    System.out.println("Opção inválida\n");
                break;
            }
            while (true) { 
                if(continuador.equals("s")){
                    break;
                }else if(continuador.equals("n")){
                    loop = false;
                    break;
                }else{
                    System.out.println("Opção inválida\n");
                    System.out.print("Deseja editar outra informação ? (S/N)");
                    continuador = scan.nextLine().toLowerCase();
                }
            }
        } while (loop);

        while (true) { 
            System.out.println("Deseja editar outra pessoa ? (S/N)");
            String resposta = scan.nextLine().toLowerCase();
            if(resposta.equals("s")){
                editarPessoa(pessoas);
            }else if(resposta.equals("n")){
                break;
            }else{
                System.out.println("Opção inválida\n");
            }
        }

        return pessoas;
    }
}
