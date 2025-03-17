package app.src.models;
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

    public Pessoa (){}

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email.toLowerCase();
    }

    public ArrayList<Pessoa> cadastrarPessoa(ArrayList<Pessoa> pessoas){
        boolean loop = true;
        while(loop){
            System.out.println("Digite o nome da pessoa: ");
            String nome = scan.nextLine();
            System.out.println("Digite a idade da pessoa: ");
            int idade = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite o email da pessoa: ");
            String email = scan.nextLine();

            boolean loop2  = true;
            while(loop2){
                System.out.println("Os dados estão corretos ? (S/N)");
                System.out.printf("Nome: %s\n",nome);
                System.out.printf("Idade: %d\n",idade);
                System.out.printf("Email: %s\n",email.toLowerCase());
                String resposta = scan.nextLine().toLowerCase();
                switch (resposta){
                    case "s":
                        loop2 = false;
                        loop = false;
                        Pessoa pessoa = new Pessoa(nome,idade,email);
                        pessoas.add(pessoa);
                    break;
                    case "n":
                        loop2 = false;
                    break;
                    default:
                        System.out.println("Resposta inválida");
                }
            }
        }

        return pessoas;
    }

    public ArrayList<Pessoa> editarPessoa(ArrayList<Pessoa> pessoas){
        if(pessoas.isEmpty()){
            System.out.println("Nehuma pessoa foi cadastrada");
            return pessoas;
        }else{
            boolean loop = true;
            do {
                int contador = 1;
                System.out.println("Qual pessoa deseja editar ?\n Digite o índice(ex: 1,2,3...)");
                System.err.println("Nomes: ");
                for (Pessoa pessoa : pessoas){
                    System.out.printf("%d- %s\n",contador,pessoa.nome);
                    contador++;
                }
                boolean loop2 = true;
                int indicePessoaSelecionado = scan.nextInt() - 1;
                scan.nextLine();
                do{
                    System.out.println("\nO que deseja editar?\n Digite o índice(ex: 1,2,3...) ");
                    System.out.printf("1- Nome: %s \n",pessoas.get(indicePessoaSelecionado).nome);
                    System.out.printf("2- Idade: %d \n",pessoas.get(indicePessoaSelecionado).idade);
                    System.out.printf("3- Email: %s \n",pessoas.get(indicePessoaSelecionado).email);
                    int indiceAtributo = scan.nextInt();
                    scan.nextLine();
                    String continuador = " ";
                    switch (indiceAtributo){
                        case 1:
                            System.out.println("Digite o novo nome: ");
                            pessoas.get(indicePessoaSelecionado).nome = scan.nextLine();
                            System.out.println("Deseja editar outra informação ? (S/N)");
                            continuador = scan.nextLine().toLowerCase();
                        break;
                        case 2:
                            System.out.println("Digite a nova idade: ");
                            pessoas.get(indicePessoaSelecionado).idade = scan.nextInt();
                            scan.nextLine();
                            System.out.println("Deseja editar outra informação ? (S/N)");
                            continuador = scan.nextLine().toLowerCase();
                        break;
                        case 3:
                            System.out.println("Digite o novo email: ");
                            pessoas.get(indicePessoaSelecionado).email = scan.nextLine();
                            System.out.println("Deseja editar outra informação ? (S/N)");
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
                            loop2 = false;
                            break;
                        }else{
                            System.out.println("Opção inválida\n");
                            System.out.println("Deseja editar outra informação ? (S/N)");
                            continuador = scan.nextLine().toLowerCase();
                        }
                    }
                } while (loop2);
    
                while (true) { 
                    System.out.println("Deseja editar outra pessoa ? (S/N)");
                    String resposta = scan.nextLine().toLowerCase();
                    if(resposta.equals("s")){
                        break;
                    }else if(resposta.equals("n")){
                        loop = false;
                        break;
                    }else{
                        System.out.println("Opção inválida\n");
                    }
                }
    
            
            }while(loop);
            return pessoas;
        }
    }

    public void visualizarPessoas(ArrayList<Pessoa> pessoas){
       if(pessoas.isEmpty()){
            System.out.println("Nehuma pessoa foi cadastrada");
       }else{
            System.out.println("Escolha uma pessoa: Exemplo: 1,2,3...\n");
            int contador = 1;
            for (Pessoa pessoa : pessoas){
                System.out.printf("%d- %s\n",contador,pessoa.nome);
                contador++;
            }
            int pessoaSelecionada = scan.nextInt() - 1;
            scan.nextLine();

            System.out.printf("Nome: %s\n",pessoas.get(pessoaSelecionada).nome);
            System.out.printf("Idade: %d\n",pessoas.get(pessoaSelecionada).idade);
            System.out.printf("Email: %s\n",pessoas.get(pessoaSelecionada).email);
       }
    }
    
    public ArrayList<Pessoa> excluirPessoa(ArrayList<Pessoa> pessoas){
        if(pessoas.isEmpty()){
            System.out.println("Nehuma pessoa foi cadastrada");
            return pessoas;
        }else{
            boolean loop = true;
            do {
            System.out.println("Qual pessoa deseja excluir? Ex 1,2,3...");
            int contador = 1;
            for(Pessoa pessoa : pessoas){
                System.out.printf("%d- %s\n",contador,pessoa.nome);
                contador++;
            }
            int pessoaSelecionada = scan.nextInt() - 1;
            scan.nextLine();
             
            System.out.printf("Deseja realmente excluir %s S/N \n",pessoas.get(pessoaSelecionada).nome);
            String resposta = scan.nextLine().toLowerCase();
            switch(resposta){
                case "s":
                    pessoas.remove(pessoaSelecionada);
                    System.out.println("Pessoa excluída com sucesso");
                break;
                case "n":
                    System.out.println("Operação cancelada");
                break;
                default:
                    System.out.println("Respota inválida");
                break;
            }
            while (true) { 
                System.out.println("Deseja excluir outra pessoa ? S/N");
                resposta = scan.nextLine().toLowerCase();
                if(resposta.equals("s")){
                    loop = true;
                    break;
                }else if(resposta.equals("n")){
                    loop = false;
                    break;
                }else{
                    System.out.println("Respota inválida");
                }
            }
            } while (loop);
           
            return pessoas;
        }      
    } 
}
