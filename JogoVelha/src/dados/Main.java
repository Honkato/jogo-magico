package dados;


public class Main {

    public static void main(String[] args) {
        int cond = 0;
        FuncoesUsuais f = new FuncoesUsuais();
        Jogadores J1 = new Jogadores();
        Jogadores J2 = new Jogadores();
        // para ambos nao deixar ele ir em outro(isso la no codigo da classe)
        System.out.println("DIGITE UM NUMERO PARA ESCOLHER O MARCADOR DO JOGADOR 1: ");
        System.out.println("Emojis disponiveis\n" +
                "1. X\n" +
                "2. O\n" +
                "3. 😂\n" +
                "4. 👽\n");
        String j1Marcador = J1.Emojis(f.pegarInt(1,4));
        System.out.println("DIGITE UM NUMERO PARA ESCOLHER O MARCADOR DO JOGADOR 2: ");
        System.out.println("Emojis disponiveis\n" +
                "1. X\n" +
                "2. O\n" +
                "3. 😂\n" +
                "4. 👽\n");
        //if j1Marcador == j2Marcador faz dnv
        String j2Marcador = J2.Emojis(f.pegarInt(1,4));

        Velha L1 = new Velha();

        while (true){

            cond = L1.marcar(f.pegarInt(1,9,"DIGITE ONDE VOCE QUER MARCAR: "), 10, j1Marcador, j2Marcador);
            cond = L1.marcar(f.pegarInt(1,9,"DIGITE ONDE VOCE QUER MARCAR: "), 20, j1Marcador, j2Marcador);
// 2== velha, 0 == nada, 1 == fim
        }
        /*
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
        }*/

    }
}