//Um banco oferece aos seus clientes dois tipos de contas (corrente e poupança), as quais possuem as funcionalidades de depósito, saque e transferência (entre contas da própria instituição).
public class Banco extends Conta{
    public static void main(String[] args) {
        Conta contaCorrente = new Conta(100, TipoDeConta.CORRENTE);
        Conta contaPoupanca = new Conta(150, TipoDeConta.POUPANCA);
        Cliente cliente = new Cliente("Gabriel", 19, "Brasília", contaCorrente, contaPoupanca);

        adicionar(200, cliente, contaCorrente);
        adicionar(3400, cliente, contaPoupanca);
        retirar(20, cliente,contaCorrente);
        retirar(300, cliente,contaPoupanca);
        mostrarInformacoes(cliente);
    }
    public static double adicionar(double dinheiro, Cliente cliente, Conta conta){
        if(conta.tipoDeConta == TipoDeConta.CORRENTE){
            dinheiro *= 0.99;
        }
        System.out.println("adicionado " + dinheiro + "$ na conta "+ conta.tipoDeConta.toString() + " de " + cliente.getNome());
        return conta.saldo += dinheiro;
    }

    public static double retirar(double dinheiro, Cliente cliente, Conta conta){
        if (conta.tipoDeConta == TipoDeConta.POUPANCA){
            dinheiro *= 0.99;
        }
        System.out.println("retirado " + dinheiro + "$ na conta "+ conta.tipoDeConta.toString() + " de " + cliente.getNome());
        return conta.saldo -= dinheiro;
    }
    public static void mostrarInformacoes(Cliente cliente){
        System.out.println(cliente.toString());
    }
}
