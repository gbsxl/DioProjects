import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conta extends Cliente{
    double saldo;
    TipoDeConta tipoDeConta;
}
