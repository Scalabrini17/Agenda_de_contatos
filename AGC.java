import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class AGC{

    //Scanner
    public static Scanner sc = new Scanner(System.in);

    //Banco de Dados contatos
    static int[] idContato = new int[101];
    static String[] nomeContato = new String[101];
    static String[] numContato = new String[101];
    static String[] emailContato = new String[101];
    static int totalCadastros = 0;
    static boolean start = true;

    //Classe Principal de
    public static void main(String[] args){

        System.out.println("Seja Bem-Vindo a Agenda de Contatos!");

        while(start){
            //Menu inicial do programa
            System.out.print("Menu inicial \n"+
                    "1. Cadastro de Contatos \n"+
                    "2. Listagem de Contatos \n"+
                    "3. Busca, atualização e remoção de Contatos \n"+
                    "4. Sair \n"+
                    "Escolha a opção que deseja (digite o número):");
                    //Validação do menu e entrada do Swicth
                    while (!sc.hasNextInt()) {
                        System.out.println("Digite apenas números.");
                        sc.next();
                        System.out.print("Escolha um opção: ");
                    }
                    int escolha = sc.nextInt();

                    switch(escolha){
                        case 1 -> {cadContacts();}
                        case 2 -> {listContacts();}
                        //TERMINAR O ITEM 2 E 3
                        case 4 -> {terminarPrograma();}
                    }

        }
    }

    // Classe de cadastro de contatos
    public static void cadContacts(){

        System.out.print("Quantos Cadastros você desejá fazer:");
        int quantCadastro = sc.nextInt();
        sc.nextLine();

        int limite = totalCadastros + quantCadastro;

        try {
            for (int i = totalCadastros; i < limite; i++) {

                System.out.println("Cadastro de contatos \n" + "Digite as informações");
                totalCadastros++;

                //Gerar id aleatorio
                int aleatorio = ThreadLocalRandom.current().nextInt(1, 101);

                // Validação das ID's cadastradas
                for(int j = 0; j > totalCadastros; j++){
                    while(idContato[j] == aleatorio){
                        aleatorio = ThreadLocalRandom.current().nextInt(1, 101);
                        break;
                    }
                }

                idContato[i] = aleatorio;
                System.out.printf("O id do contato que você está cadastrando é: %d \n", idContato[i]);

                //Nome contato
                System.out.print("Nome do contato: ");
                nomeContato[i] = sc.nextLine().toUpperCase();

                //número contato
                System.out.print("Número de celular: ");
                numContato[i] = sc.nextLine();

                //e-mail contato
                System.out.print("E-mail: ");
                emailContato[i] = sc.nextLine().toLowerCase();
            }
        } catch (Exception e) {
            System.out.printf("Erro: %s", e);
        }
    }

    // Classe de Listagem de contatos
    public static void listContacts(){
        System.out.println("Listagem de contatos");

        if(totalCadastros == 0){
            System.out.println("Não há nenhum registro de Contato :(");
        }else{
            for(int i = 0; i < totalCadastros; i++){
                System.out.printf("ID: %d | Nome: %s | Número: %s | E-mail: %s \n", idContato[i], nomeContato[i], numContato[i], emailContato[i]);
            }
        }
    }

    // Classe de busca, atualização e remoção de contatos
    public static void buscContacts(){

    }

    public static void terminarPrograma(){
        System.out.println("Você escolheu sair do programa. Obrigado pela preferencia!");
        System.out.println("Até a proxima :)");
        start = false;
    }

}