package dados;

import java.util.Arrays;

public class Velha {

    Velha(){
        mostrar(velha,"" ,"");
    }

    private FuncoesUsuais f = new FuncoesUsuais();

    int[][] velha = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};

    private String vencedor(int[][] velhaV) {
        int[] l0 = velhaV[0];
        int[] l1 = velhaV[1];
        int[] l2 = velha[2];
        int[] c0 = {velha[0][0], velha[1][0], velha[2][0]};
        int[] c1 = {velha[0][1], velha[1][1], velha[2][1]};
        int[] c2 = {velha[0][2], velha[1][2], velha[2][2]};
        int[] d0 = {velha[0][0], velha[1][1], velha[2][2]};
        int[] d1 = {velha[0][2], velha[1][1], velha[2][0]};
        int[][] tudo = {l0, l1, l2, c0, c1, c2, d0, d1};
        int[] valorX = {10, 10, 10};
        int[] valorO = {20, 20, 20};
//        int x = 0;
        int resto = 0;
//            for x in range(0, len(tudo)):
//            print(tudo[x])
//            if tudo[x] == [1, 1, 1]:
//            print('JOGADOR 1 GANHOU')
//            break
        int pontX = 0;
        int pontO = 0;
        for (int[] i : tudo) {
            if (Arrays.equals(i, valorO)) {
                pontO += 1;
            }else if (Arrays.equals(i, valorX)) {
                pontX += 1;
            }}
        if (pontO > pontX){
            return "JOGADOR 2 GANHOU";
        }else if (pontO < pontX) {
            return "JOGADOR 1 GANHOU";
        }else{
            if (pontO != 0){
                return "EMPATE";
            }
        }

        for (int[] ints : velhaV){
            for (int ver : ints) {
                if (!(ver == 10 || ver == 20)){
                    resto += 1;
                }
            }
        }
//        System.out.println(resto);
        if (resto == 0){
            return "DEU VELHA";
        }
        return "Nada aconteceu";
    }


    public int marcar(int position, int marcador, String x, String o){
        int[][] hashPosition = {
                {2,0},{2,1},{2,2},
                {1,0},{1,1},{1,2},
                {0,0},{0,1},{0,2}
                                };
        int X = hashPosition[position-1][0];
        int Y = hashPosition[position-1][1];

        if (!(velha[X][Y] == 10 || velha[X][Y] == 20)){
            velha[X][Y] = marcador;
        }else{
            return 2;
        }

        mostrar(velha, x, o);
        String a = vencedor(velha);
        if (a.equals("Nada aconteceu")){
            return 0;
        }else {
            System.out.println(a);
            return 1;
        }

    }

    private void mostrar(int[][] mostra, String x, String o){
        String velhaS = Arrays.deepToString(mostra);
        velhaS = velhaS.replace(", [","\n");
        velhaS = velhaS.replace("]","");
        velhaS = velhaS.replace("[","");
        velhaS = velhaS.replace(",","   ");
        velhaS = velhaS.replace("10",x);
        velhaS = velhaS.replace("20",o);
        System.out.println(velhaS);
    }

}
// -----------------------------------------------daki pra baixo e o main
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

