package bosch;

import java.util.Arrays;

public class Velha {

    int[][] cube = {
            {7, 8, 9},
            {4, 5, 6},
            {1, 2, 3}
    };
//    GETTERS
//    GET LINES
    int[] getLine0(){
        return new int[]{cube[0][0], cube[0][1], cube[0][2]};
    }

    int[] getLine1(){
        return new int[]{cube[1][0], cube[1][1], cube[1][2]};
    }

    int[] getLine2(){
        return new int[]{cube[2][0], cube[2][1], cube[2][2]};
    }

//    GET COLUMNS
    int[] getColumn0(){
        return new int[]{cube[0][0], cube[1][0], cube[2][0]};
    }

    int[] getColumn1(){
        return new int[]{cube[0][1], cube[1][1], cube[2][1]};
    }

    int[] getColumn2(){
        return new int[]{cube[0][2], cube[1][2], cube[2][2]};
    }

//    GET DIAGONALS
    int[] getDiagonal0(){
        return new int[]{cube[0][0], cube[1][1], cube[2][2]};
    }

    int[] getDiagonal1(){
        return new int[]{cube[2][0], cube[1][1], cube[0][2]};
    }
//    SETTERS
//    SET LINES
    void setLine0(int[] set){
        cube[0][0] = set[0];
        cube[0][1] = set[1];
        cube[0][2] = set[2];
    }
    void setLine1(int[] set){
        cube[1][0] = set[0];
        cube[1][1] = set[1];
        cube[1][2] = set[2];
    }
    void setLine2(int[] set){
        cube[2][0] = set[0];
        cube[2][1] = set[1];
        cube[2][2] = set[2];
    }

//    SET COLUMNS
    void setColumn0(int[] set){
        cube[0][0] = set[0];
        cube[1][0] = set[1];
        cube[2][0] = set[2];
    }
    void setColumn1(int[] set){
        cube[0][1] = set[0];
        cube[1][1] = set[1];
        cube[2][1] = set[2];
    }
    void setColumn2(int[] set){
        cube[0][2] = set[0];
        cube[1][2] = set[1];
        cube[2][2] = set[2];
    }


    public boolean verifyWinner(){

        int[] c0 = getColumn0();
        int[] c1 = getColumn1();
        int[] c2 = getColumn2();

        int[] l0 = getLine0();
        int[] l1 = getLine1();
        int[] l2 = getLine2();

        int[] d0 = getDiagonal0();
        int[] d1 = getDiagonal1();

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
