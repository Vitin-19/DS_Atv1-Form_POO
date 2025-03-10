public class Pessoa {
    String nome;
    int idade;
    private String email;

    public Pessoa(String nome, int idade, String email){
        this.nome = nome;
        this.idade = idade;
        setEmail(email);
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email.toLowerCase();
    }
}
