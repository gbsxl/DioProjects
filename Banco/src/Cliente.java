import lombok.*;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cliente {
    String nome;
    int idade;
    String cidade;
    Conta conta;
    Conta conta2;

    public Cliente(String nome, int idade, String cidade, Conta conta) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
        this.conta = conta;
    }
}
