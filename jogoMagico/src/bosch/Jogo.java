package bosch;

import java.util.Arrays;
import java.util.Scanner;

public class Jogo {
    Jogo(){
    }
    void jogar(){

        Scanner scan = new Scanner(System.in);

        Velha centerCube = new Velha();
        Velha upCube = new Velha();
        Velha backCube = new Velha();
        Velha downCube = new Velha();
        Velha leftCube = new Velha();
        Velha rightCube = new Velha();

        setCubeSide(centerCube, 2);
        setCubeSide(upCube, 1);
        setCubeSide(backCube, 4);
        setCubeSide(downCube, 3);
        setCubeSide(leftCube, 5);
        setCubeSide(rightCube,6);

        upCube.showCube();
        System.out.println("\u001B[00m -------|");
        leftCube.showCube();
        centerCube.showCube();
        rightCube.showCube();
        backCube.showCube();
        System.out.println("\u001B[00m -------|");
        downCube.showCube();
        int spin;
        boolean a;
        while (true) {
            System.out.print("\u001B[00m");
            System.out.println(
                    """
                    =========Cube=========
                    10 - 0 lines to right
                    11 - 0 lines to  left
                    20 - 1 lines to right
                    22 - 1 lines to  left
                    30 - 2 lines to right
                    33 - 2 lines to  left
                    ----------------------
                    40 - 0 columns to down
                    44 - 0 columns to  up
                    50 - 1 columns to down
                    55 - 1 columns to  up
                    60 - 2 columns to down
                    66 - 2 columns to  up""");
            spin = scan.nextInt();
            System.out.println("\u001B[00m -------|");
            if (spin == 10)
            {
//                upCube.showCube();
                turnLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, 0, false);
//                downCube.showCube();
            }
            else if (spin == 11)
            {
//                upCube.showCube();
                turnLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, 0, true);
//                downCube.showCube();
            }
            else if (spin == 20)
            {
//                upCube.showCube();
                turnLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, 1, false);
//                downCube.showCube();
            }
            else if (spin == 22)
            {
//                upCube.showCube();
                turnLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, 1, true);
//                downCube.showCube();
            }
            else if (spin == 30)
            {
//                upCube.showCube();
                turnLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, 2, false);
//                downCube.showCube();
            }
            else if (spin == 33)
            {
//                upCube.showCube();
                turnLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, 2, true);
//                downCube.showCube();
            }
            else if (spin == 40)
            {
//                leftCube.showCube();
                turnLineToDown(leftCube, centerCube, rightCube, backCube, upCube, downCube, 0, false);
//                rightCube.showCube();
            }
            else if (spin == 44)
            {
//                leftCube.showCube();
                turnLineToDown(leftCube, centerCube, rightCube, backCube, upCube, downCube, 0, true);
//                rightCube.showCube();
            }
            else if (spin == 50)
            {
//                leftCube.showCube();
                turnLineToDown(leftCube, centerCube, rightCube, backCube, upCube, downCube, 1, false);
//                rightCube.showCube();
            }
            else if (spin == 55)
            {
//                leftCube.showCube();
                turnLineToDown(leftCube, centerCube, rightCube, backCube, upCube, downCube, 1, true);
//                rightCube.showCube();
            }
            else if (spin == 60)
            {
//                leftCube.showCube();
                turnLineToDown(leftCube, centerCube, rightCube, backCube, upCube, downCube, 2, false);
//                rightCube.showCube();
            }
            else if (spin == 66)
            {
//                leftCube.showCube();
                turnLineToDown(leftCube, centerCube, rightCube, backCube, upCube, downCube, 2, true);
//                rightCube.showCube();
            }
            else if (spin == 0){break;}

//            MODO FIXO
            System.out.println("    U");
            upCube.showCube();
            System.out.println("\u001B[00m -------|");
            System.out.println("    L");
            leftCube.showCube();
            System.out.println("    C");
            centerCube.showCube();
            System.out.println("    R");
            rightCube.showCube();
            System.out.println("    B");
            backCube.showCube();
            System.out.println("\u001B[00m -------|");
            System.out.println("    D");
            downCube.showCube();
        }


//        INVERTE A LINHA
    }
    public int[] reverse(int[] vetorDe3){
        vetorDe3 = new int[]{vetorDe3[2], vetorDe3[1], vetorDe3[0]};
        return vetorDe3;
    }


//          VIRA UMA FACE DO CUBO
    public void turnCenterToRight(Velha center, boolean reverse) {

        int[] centerLine0 = center.getLine(0);
        int[] centerLine1 = center.getLine(1);
        int[] centerLine2 = center.getLine(2);

        if (reverse) {
            centerLine2 = reverse(centerLine2);
            centerLine1 = reverse(centerLine1);
            centerLine0 = reverse(centerLine0);
            center.setColumn(2, centerLine2);
            center.setColumn(1, centerLine1);
            center.setColumn(0, centerLine0);
            System.out.println("\n\n");
            System.out.println("\u001B[00m<<=!");
        } else {
            center.setColumn(2, centerLine0);
            center.setColumn(1, centerLine1);
            center.setColumn(0, centerLine2);
            System.out.println("\n\n");
            System.out.println("\u001B[00m!=>>");
        }
        //            TIRAR
//        center.showCube();
    }


//    FUNÇÃO AUXILIAR PARA TROCAR OS LADOS DOS CUBOS
    public void setCubeSide(Velha cubo, int definir){
        int[] set = {definir, definir, definir};
        cubo.setLine(0, set);
        cubo.setLine(1, set);
        cubo.setLine(2, set);
    }


//    VIRA MEXE EM TODAS AS FACES, EM UMA LINHA ESPECIFICA, TAMBEM CHAMA turnCenterToRight SE NECESSARIO
    public void turnLineToRight(Velha left, Velha center, Velha right, Velha back, Velha up, Velha down, int line, boolean reverse) {

        int[][] linesList = {{},{},{},{}};
        Velha[] sides = {left, center, right, back};

//        Getting lines
        for (int i = 0; i < 4; i++) {
            linesList[i] = sides[i].getLine(line);
        }

//        Setting lines
        if (reverse) {
//            Turn to left
            for (int i = 0; i < 4; i++) {
                if (i == 3) {
                    sides[i].setLine(line, linesList[0]);
                } else {
                    sides[i].setLine(line, linesList[i + 1]);
                }
            }
                System.out.println("<<<---");
        }else {
//            Turn to right
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    sides[i].setLine(line, linesList[3]);
                } else {
                    sides[i].setLine(line, linesList[i - 1]);
                }
            }
            System.out.println("--->>>");
        }

        if (line == 0){
            turnCenterToRight(up, reverse);
        }else if (line == 2){
            turnCenterToRight(down, reverse);
        }
//            TIRAR

        System.out.println("\u001B[00mL");
//        left.showCube();
        System.out.println("\u001B[00mC");
//        center.showCube();
        System.out.println("\u001B[00mR");
//        right.showCube();
        System.out.println("\u001B[00mB");
//        back.showCube();
        System.out.println("\u001B-------|");
    }


//    FAZ A MESMA COISA QUE O ANTERIOR MAS PARA BAIXO
    public void turnLineToDown(Velha left, Velha center, Velha right, Velha back, Velha up, Velha down, int column, boolean reverse) {

        int[][] columnsList = {{},{},{},{}};
        Velha[] sides = {center, down, back, up};

//        Getting lines
        for (int i = 0; i < 4; i++) {
            columnsList[i] = sides[i].getColumn(column);
        }

//        Setting lines
        if (reverse) {
//            Turn to left
            for (int i = 0; i < 4; i++) {
                if (i == 3) {
                    sides[i].setColumn(column, columnsList[0]);
                } else {
                    sides[i].setColumn(column, columnsList[i + 1]);
                }
            }
            System.out.println("A A A");
            System.out.println("| | |");
        }else {
//            Turn to right
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    sides[i].setColumn(column, columnsList[3]);
                } else {
                    sides[i].setColumn(column, columnsList[i - 1]);
                }
            }
            System.out.println("| | |");
            System.out.println("V V V");
        }

        if (column == 0){
            turnCenterToRight(left, reverse);
        }else if (column == 2){
            turnCenterToRight(right, reverse);
        }

        //            TIRAR

        System.out.println("\u001B[00mL");
//        left.showCube();
        System.out.println("\u001B[00mC");
//        center.showCube();
        System.out.println("\u001B[00mR");
//        right.showCube();
        System.out.println("\u001B[00mB");
//        back.showCube();
        System.out.println("\u001B[00m -------|");

    }
}
