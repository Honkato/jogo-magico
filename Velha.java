package bosch;

import java.util.Arrays;

public class Velha {

    int[][] cube = {
            {7, 8, 9},
            {4, 5, 6},
            {1, 2, 3}
    };

    public boolean verifyWinner(){

        int[] c0 = {cube[0][0], cube[1][0], cube[2][0]};
        int[] c1 = {cube[0][1], cube[1][1], cube[2][1]};
        int[] c2 = {cube[0][2], cube[1][2], cube[2][2]};

        int[] l0 = {cube[0][0], cube[0][1], cube[0][2]};
        int[] l1 = {cube[1][0], cube[1][1], cube[1][2]};
        int[] l2 = {cube[2][0], cube[2][1], cube[2][2]};

        int[] d0 = {cube[0][0], cube[1][1], cube[2][2]};
        int[] d1 = {cube[2][0], cube[1][1], cube[0][2]};

        int[][] tudo = {l0,l1,l2, c0,c1,c2, d0,d1};


        int[] j1 = {10,10,10};
        int[] j2 = {20,20,20};

        int j1Score = 0;
        int j2Score = 0;

        for (int[] i:tudo) {
            System.out.println(Arrays.toString(i));
            if (i == j1){
              j1Score +=1;
            }
            if (i == j2){
                j2Score +=1;
            }
        }

//        VERIFICA SE O J1 OU O J2 GANHOU
        if (j1Score == j2Score){
            System.out.println("Nothing happened");
        }else if (j1Score > j2Score){
            System.out.println("J1 Wins");
            return true;
        }else{
            System.out.println("J2 Wins");
            return true;
        }
//        SE NINGUÉM GANHOU VERIFICA SE DEU VELHA
        /*
        NÃO VERIFICA PQ NÃO PODE DAR VELHA
        */
      return false;
    };
//int[][] upCubo, int[][] downCubo, int[][] leftCubo, int[][] rightCubo,

}
