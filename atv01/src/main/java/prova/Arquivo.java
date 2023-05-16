package prova;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Arquivo {

    public boolean cadastrar(Pessoa pessoa) {
        boolean status = false;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Pessoas.txt", true));

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String dataHoraCadastro = dtf.format(now);

            bw.write("NOME |" + pessoa.nome  + "| SOBRENOME |" + pessoa.sobrenome  + "| EMAIL | " + pessoa.email + "| CELULAR | " + pessoa.celular  + "| CPF | " + pessoa.cpf + " | CIDADE | " + pessoa.cidade + "| DATA/HORA | " + dataHoraCadastro + "\n");
            bw.close();
            status = true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }


    public Pessoa consultar(String nome) {
        Pessoa pessoa = new Pessoa();
        String registro[] = new String[4];
        String linha;
        try {
            BufferedReader br = new BufferedReader(new FileReader("Pessoas.txt"));
            while ((linha = br.readLine()) != null) {
                registro = linha.split(";");
                if (registro[0].equals(nome)) {
                    pessoa.nome = registro[0];
                    pessoa.sobrenome = registro[1];
                    pessoa.email = registro[2];
                    pessoa.celular = registro[4];
                    pessoa.cpf = registro[5];
                    pessoa.cidade = registro[6];
                    break;
                } else {
                    registro = new String[11];
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return pessoa;
    }

}
