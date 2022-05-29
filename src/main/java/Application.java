public class Application {

    public static void main(String[] args) {

        Cliente teste = Cliente.builder().nome("Josue").build();

        Conta cc = new ContaCorrente(teste);
        Conta cp = new ContaPoupanca(teste);

        cc.depositar(100);
        cc.transferir(cp,50);

        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }

}
