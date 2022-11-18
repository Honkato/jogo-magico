package dados;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int parar = 0;
        int a = 0;
        Velha L1 = new Velha();
        Jogadores J1 = new Jogadores();
        Jogadores J2 = new Jogadores();
        Scanner scan = new Scanner(System.in);
        // para ambos nao deixar ele ir em outro(isso la no codigo da classe)
        System.out.println("DIGITE UM NUMERO PARA ESCOLHER O MARCADOR DO JOGADOR 1: ");
        System.out.println("Emojis disponiveis\n" +
                "1. X\n" +
                "2. O\n" +
                "3. 😂\n" +
                "4. 👽\n");
        String j1Marcador = J1.Emojis(scan.nextInt());
        System.out.println("DIGITE UM NUMERO PARA ESCOLHER O MARCADOR DO JOGADOR 2: ");
        System.out.println("Emojis disponiveis\n" +
                "1. X\n" +
                "2. O\n" +
                "3. 😂\n" +
                "4. 👽\n");
        //if j1Marcador == j2Marcador faz dnv
        String j2Marcador = J2.Emojis(scan.nextInt());

        while (parar == 0) {
            while (parar == 0) {
                System.out.println("DIGITE ONDE VOCE QUER MARCAR");
                a = scan.nextInt();
                int b = L1.marcar(a, 10, j1Marcador, j2Marcador);
                if (b == 0) {
                    break;
                }else if (b == 1){
                    parar = 1;
                }else {
                    System.out.println("POR FAVOR DIGITE O NUMERO NOVAMENTE!!!");
                }
            }
            while (parar == 0) {
                System.out.println("DIGITE ONDE VOCE QUER MARCAR");
                a = scan.nextInt();
                int b = L1.marcar(a, 20, j1Marcador, j2Marcador);
                if (b == 0) {
                    break;
                }else if (b == 1){
                    parar = 1;
                } else {
                    System.out.println("POR FAVOR DIGITE O NUMERO NOVAMENTE!!!");
                }
            }
        }

    }
}
