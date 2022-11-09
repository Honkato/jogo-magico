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
//        setCubeSide(upCube, 2);
        setCubeSide(backCube, 4);
//        setCubeSide(downCube, 4);
        setCubeSide(leftCube, 1);
        setCubeSide(rightCube,3);

        System.out.println("\n\n");
        int spin;
        boolean a;
        while (true) {
            spin = scan.nextInt();
            if (spin == 1) {
                upCube.showCube();
                turnLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, 2, false);
                downCube.showCube();
            }else if (spin == 2) {
                upCube.showCube();
                turnLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, 2, true);
                downCube.showCube();
            }else if (spin == 0){
                break;
            }
        }
        /*
//        while (true) {
//            spin = scan.nextInt();
//            if (spin == 1) {
//                turnCenterToRight(centerCube, true);
//            }else if (spin == 2){
//                turnCenterToRight(centerCube, false);
//            }else if (spin == 0){
//                break;
//            }
//        }
        */


    }
    public int[] reverse(int[] vetorDe3){
        vetorDe3 = new int[]{vetorDe3[2], vetorDe3[1], vetorDe3[0]};
        return vetorDe3;
    }

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
            System.out.println("<<=!");
        } else {
            center.setColumn(2, centerLine0);
            center.setColumn(1, centerLine1);
            center.setColumn(0, centerLine2);
            System.out.println("\n\n");
            System.out.println("!=>>");
        }

        center.showCube();
    }
    public void setCubeSide(Velha cubo, int definir){
        int[] set = {definir, definir, definir};
        cubo.setLine(0, set);
        cubo.setLine(1, set);
        cubo.setLine(2, set);
    }
    public void turnLineToRight(Velha left, Velha center, Velha right, Velha back, Velha up, Velha down, int line, boolean reverse) {

        int[][] linesList = {{},{},{},{}};
        Velha[] sides = {left, center, right, back};

//        Getting lines
        for (int i = 0; i < 4; i++) {
            linesList[i] = sides[i].getLine(line);
        }

//        System.out.println(Arrays.deepToString(linesList));

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



        System.out.println("L");
        left.showCube();
        System.out.println("C");
        center.showCube();
        System.out.println("R");
        right.showCube();
        System.out.println("B");
        back.showCube();
        System.out.println("-------|");

//        System.out.println(Arrays.deepToString(linesList));
    }
}
