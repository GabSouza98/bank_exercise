import lombok.*;
@Getter
public abstract class Conta implements IConta{

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;


    private static int SEQUENCIAL = 1;
    protected static int AGENCIA_PADRAO = 1;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(IConta contaDestino, double valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Numero: %d", numero));
        System.out.println(String.format("Saldo: %.2f", saldo));
    }
}
