import java.util.Scanner;

public class Main {
    private static int numero = 1021;
    private static String agencia = "067-8";
    private static double saldo = 237;

    private static String nomeDaConta;

    public static void main(String[] args){
        comandos();
    }

    private static void comandos(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Escolha o seu comando: ");
        System.out.print("--criarconta\n");
        System.out.print("--info\n");
        System.out.print("--sacar\n");
        System.out.print("--depositar\n\n");

        switch(scan.nextLine()){
            case "--criarconta":
                criarConta();
                break;
            case "--info":
                info();
                break;
            case "--sacar":
                sacar();
                break;
            case "--depositar":
                depositar();
                break;
            default:
                System.out.println("Comando não encontrado");
                comandos();
        }
    }

    private static void depositar(){
        Scanner scan = new Scanner(System.in);

        if(nomeDaConta == null){
            System.out.println("Crie uma conta para fazer deposito.");
            comandos();
        }

        System.out.println("Coloque um valor para depositar: ");
        double deposito = scan.nextDouble();

        

        if(deposito > 10000){
            System.out.println("Deposite um valor maior que 10.000");
            depositar();
        }

        saldo += deposito;
        comandos();
    }

    private static void sacar() {
        Scanner scan = new Scanner(System.in);

        if(nomeDaConta.isEmpty() || nomeDaConta == null){
            System.out.println("Você precisa criar a conta antes de sacar");
            comandos();
            return;
        }else{
            System.out.println("Qual valor que você quer sacar? ");

            double saque = scan.nextDouble();
    
            if(saque > saldo){
                System.out.println("Você não tem saldo suficiente. Seu saldo "+saldo);
                comandos();
            }
    
            System.out.println(saque + " retirados na conta.");
            saldo-=saque;
            comandos();
        }
    }

    private static void info(){
        if(nomeDaConta != null) {
            System.out.print("Numero de conta: "+ numero +"\nAgencia: "+agencia +"\nNome da conta: " + nomeDaConta +"\nDinheiro na conta: " + saldo + "\n\n--info");
            comandos();
        }
        else {System.out.println("Você precisa criar uma conta. Use o comando --criarconta"); comandos();}
        
            
    }

    private static void criarConta() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Faça um nome para sua conta: ");
        
        String nome = scan.nextLine();
        nomeDaConta = nome;

        System.out.print("Numero de conta: "+ numero +"\nAgencia: "+agencia +"\nNome da Conta: " + nome +"\nDinheiro na conta: " + saldo);

        System.out.println("\nProximo comando:\n");
        comandos();
    }
}
