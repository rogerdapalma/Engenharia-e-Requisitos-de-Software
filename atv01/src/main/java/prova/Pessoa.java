package prova;

public class Pessoa {

    public String nome;
    public String sobrenome;
    public String cpf;
    public String cidade;
    public String email;
    public String celular;

    @Override
    public String toString() {
        return "nome:" + nome + "," + "sobrenome: " + sobrenome + "," + "cpf:" + cpf + "," + "cidade: " + cidade ;

    }
}
