        package dados;

        import java.util.Arrays;

public class Velha {

    int[][] velha = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};

    String vencedor(int[][] velhaV) {
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
        int x = 0;
        int resto = 0;
//            for x in range(0, len(tudo)):
//            print(tudo[x])
//            if tudo[x] == [1, 1, 1]:
//            print('JOGADOR 1 GANHOU')
//            break
        int i = 0;
        for (i = 0; i < 8; i++) {
            //System.out.println(Arrays.toString(tudo[i]));
            if (Arrays.equals(tudo[i], valorO)) {
                return "JOGADOR 2 GANHOU";
            }else if (Arrays.equals(tudo[i], valorX)) {
                return "JOGADOR 1 GANHOU";
            }}
        i = 0;
        for (i = 0; i < 8; i++){
            {
                for (int y = 0; y < 3; y++) {
                    if (!(tudo[x][y] == 10 || tudo[x][y] == 20)) {
                        resto = 1;
                        break;
                    }
                }if (resto == 1){
                    break;
                }
            }
            x += 1;
        }
        if (resto == 1) {
            return "Nada aconteceu";
        }else{
            return "Velha";
        }
    }
//                    elif tudo[x] == [1, 1, 1]:
//            print('JOGADOR 2 GANHOU')
//            break

//            for y in range(0, 3):
//            print(tudo[x][y])
//            if tudo[x][y] != 1:
//            if tudo[x][y] != 0:
//            resto = 1

    public int marcar(int position, int marcador, String x, String o){


        if (position == 7 && (!(velha[0][0] == 10 || velha[0][0]== 20))){
            velha[0][0] = marcador;
        }
        if (position == 8 && (!(velha[0][1] == 10 || velha[0][1]== 20))){
            velha[0][1] = marcador;
        }
        if (position == 9 && (!(velha[0][2] == 10 || velha[0][2]== 20))){
            velha[0][2] = marcador;
        }
        if (position == 4 && (!(velha[1][0] == 10 || velha[1][0]== 20))){
            velha[1][0] = marcador;
        }
        if (position == 5 && (!(velha[1][1] == 10 || velha[1][1]== 20))){
            velha[1][1] = marcador;
        }
        if (position == 6 && (!(velha[1][2] == 10 || velha[1][2]== 20))){
            velha[1][2] = marcador;
        }
        if (position == 1 && (!(velha[2][0] == 10 || velha[2][0]== 20))){
            velha[2][0] = marcador;
        }
        if (position == 2 && (!(velha[2][1] == 10 || velha[2][1]== 20))){
            velha[2][1] = marcador;
        }
        if (position == 3 && (!(velha[2][2] == 10 || velha[2][2]== 20))){
            velha[2][2] = marcador;
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

    void mostrar(int[][] mostra, String x, String o){
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
