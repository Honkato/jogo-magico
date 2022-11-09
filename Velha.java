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
    int[] getLine(int line){
        if (line == 0){
//            First line
            return new int[]{
                    cube[0][0],
                    cube[0][1],
                    cube[0][2]};
        }else if (line == 1){
//            Second line
            return new int[]{
                    cube[1][0],
                    cube[1][1],
                    cube[1][2]};
        }else{
//            Third line
            return new int[]{
                    cube[2][0],
                    cube[2][1],
                    cube[2][2]};
        }

    }


//    GET COLUMNS
    int[] getColumn(int column){
        if (column == 0){
//            First column
            return new int[]{
                    cube[0][0],
                    cube[1][0],
                    cube[2][0]};
        }else if (column == 1){
//            Second column
            return new int[]{
                    cube[0][1],
                    cube[1][1],
                    cube[2][1]};
        }else{
//            Third column
            return new int[]{
                    cube[0][2],
                    cube[1][2],
                    cube[2][2]};
        }
    }


//    GET DIAGONALS
    int[] getDiagonal(int diagonal){
        if (diagonal == 0){
            return new int[]{
//                    Diagonal left right \
                    cube[0][0],
                    cube[1][1],
                    cube[2][2]};
        }else{
            return new int[]{
//                    Diagonal right left /
                    cube[2][0],
                    cube[1][1],
                    cube[0][2]};
        }

    }


//    SETTERS
//    SET LINES
    void setLine(int line,int[] set){
        if (line == 0){
//            First line
            cube[0][0] = set[0];
            cube[0][1] = set[1];
            cube[0][2] = set[2];
        }else if (line == 1){
//            Second line
            cube[1][0] = set[0];
            cube[1][1] = set[1];
            cube[1][2] = set[2];
        }else{
//            Third line
            cube[2][0] = set[0];
            cube[2][1] = set[1];
            cube[2][2] = set[2];
        }
    }


//    SET COLUMNS
    void setColumn(int column,int[] set){
        if (column == 0){
//            First column
            cube[0][0] = set[0];
            cube[1][0] = set[1];
            cube[2][0] = set[2];
        }else if (column == 1){
//            Second column
            cube[0][1] = set[0];
            cube[1][1] = set[1];
            cube[2][1] = set[2];
        }else{
//            Third column
            cube[0][2] = set[0];
            cube[1][2] = set[1];
            cube[2][2] = set[2];
        }
    }



    public boolean verifyWinner(){

        int[] c0 = getColumn(0);
        int[] c1 = getColumn(1);
        int[] c2 = getColumn(2);

        int[] l0 = getLine(0);
        int[] l1 = getLine(1);
        int[] l2 = getLine(2);

        int[] d0 = getDiagonal(0);
        int[] d1 = getDiagonal(1);

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
    }
//int[][] upCubo, int[][] downCubo, int[][] leftCubo, int[][] rightCubo,
    void showCube(){
        String formated = Arrays.deepToString(cube);
        formated = formated.replace("[","")
                           .replace("], ","\n")
                           .replace("]","")
                           .replace(", ","  ");

        formated = formated.replace("10", "X")
                           .replace("20","O");

        System.out.println(formated);
    }

}
