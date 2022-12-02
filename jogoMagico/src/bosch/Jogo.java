package bosch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Jogo {
    Jogo() {
    }
    Jogo(boolean testMode){
        setCubeSide(centerCube, 2);
        setCubeSide(upCube, 1);
        setCubeSide(backCube, 4);
        setCubeSide(downCube, 3);
        setCubeSide(leftCube, 5);
        setCubeSide(rightCube,6);
    }
    Velha centerCube = new Velha();
    Velha upCube = new Velha();
    Velha backCube = new Velha();
    Velha downCube = new Velha();
    Velha leftCube = new Velha();
    Velha rightCube = new Velha();

    Scanner scan= new Scanner(System.in);

//    FuncoesUsuais f = new FuncoesUsuais();

    void jogar(){
        int count = 0;
        FuncoesUsuais f = new FuncoesUsuais();//     flushed,        quiss,           why?neglass
        ArrayList<String> jogadores = new ArrayList<>(Arrays.asList("X ", "O ", "😂", "👽", "\uD83D\uDE33", "\uD83D\uDC8B", "\uD83C\uDF77"));

        System.out.println("DIGITE UM NUMERO PARA ESCOLHER O MARCADOR DO JOGADOR 1: ");
        for (String emoji : jogadores){
            count +=1;
            System.out.println(count+".  "+emoji);
        }
        count = f.pegarInt(1, jogadores.size());
        String j1Marcador = jogadores.get(count - 1);
        jogadores.remove(count-1);
        System.out.println("DIGITE UM NUMERO PARA ESCOLHER O MARCADOR DO JOGADOR 2: ");
        count = 0;
        for (String emoji : jogadores){
            count +=1;
            System.out.println(count+".  "+emoji+"  ");
        }
        count = f.pegarInt(1, jogadores.size());
        //if j1Marcador == j2Marcador faz dnv
        String j2Marcador = jogadores.get(count - 1);
        jogadores.clear();

        int parar = 0;
        while (true) {
            parar = L1.marcar(10, j1Marcador, j2Marcador);
            if (parar == 1){break;}
            parar = L1.marcar(20, j1Marcador, j2Marcador);
            if (parar == 1){break;}
        }
    }
    int tratamento(){

    }

    void girar(){
        showAllCube(leftCube, centerCube, rightCube, backCube, upCube, downCube);
        int spin;

            System.out.print("\u001B[00m");
            System.out.println(
                    "=========Cube=========\n" +
                            "10 - 0 lines to right\n" +
                            "11 - 0 lines to  left\n" +
                            "20 - 1 lines to right\n" +
                            "22 - 1 lines to  left\n" +
                            "30 - 2 lines to right\n" +
                            "33 - 2 lines to  left\n" +
                            "----------------------\n" +
                            "40 - 0 columns to down\n" +
                            "44 - 0 columns to  up\n" +
                            "50 - 1 columns to down\n" +
                            "55 - 1 columns to  up\n" +
                            "60 - 2 columns to down\n" +
                            "66 - 2 columns to  up\n");
            Object[] lista;
            ArrayList<Object[]> intBool = new ArrayList<>();
            boolean reverse = false;
            int num = -1;
            int index = 0;
            for (int i = 0; i < 6; i++) {
                if (i % 2 == 0) {
                    reverse = false;
                    num += 1;
                    index += 1;
                } else {
                    reverse = true;
                }
                lista = new Object[]{num, reverse};
                intBool.add(lista);
//                System.out.println(Arrays.toString(intBool.get(i)));
            }
            System.out.print("Move: ");
            int[][] setMode = {
                    {10, 0}, {11, 1}, {20, 2}, {22, 3}, {30, 4}, {33, 5},
                    {40, 0}, {44, 1}, {50, 2}, {55, 3}, {60, 4}, {66, 5}
            };
            spin = scan.nextInt();

            for (int[] ints : setMode) {
                if (ints[0] == spin) {
                    lista = intBool.get(ints[1]);
                    num = (int) lista[0];
                    reverse = (boolean) lista[1];
                }
            }
            if (spin == 0){

            }
            if (spin < 35) {
                turnLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, num, reverse);
            }else{
                turnLineToDown(leftCube, centerCube, rightCube, backCube, upCube, downCube, num, reverse);
            }

            System.out.println("\u001B[00m -------|");
            showAllCube(leftCube, centerCube, rightCube, backCube, upCube, downCube);

    }
    public void showAllCube(Velha left, Velha center, Velha right, Velha back, Velha up, Velha down){
        Velha[] cube = {up, back, left, center, right, down};
        String getCube = "";
        getCube =
                "tabs|-U-----|%$"+
                "tabs| "+Arrays.toString(cube[0].getLine(0))+" |%$"+
                "tabs| "+Arrays.toString(cube[0].getLine(1))+" |%$"+
                "tabs| "+Arrays.toString(cube[0].getLine(2))+" |%$"+
                "B-----|-L-----|-C-----|-R-----|%$"+
                Arrays.toString(cube[1].getLine(0))+" | "+ Arrays.toString(cube[2].getLine(0))+" | "+Arrays.toString(cube[3].getLine(0))+" | "+ Arrays.toString(cube[4].getLine(0))+" |%$"+
                Arrays.toString(cube[1].getLine(1))+" | "+ Arrays.toString(cube[2].getLine(1))+" | "+Arrays.toString(cube[3].getLine(1))+" | "+ Arrays.toString(cube[4].getLine(1))+" |%$"+
                Arrays.toString(cube[1].getLine(2))+" | "+ Arrays.toString(cube[2].getLine(2))+" | "+Arrays.toString(cube[3].getLine(2))+" | "+ Arrays.toString(cube[4].getLine(2))+" |%$"+
                "tabs|-D-----|%$"+
                "tabs| "+Arrays.toString(cube[5].getLine(0))+" |%$"+
                "tabs| "+Arrays.toString(cube[5].getLine(1))+" |%$"+
                "tabs| "+Arrays.toString(cube[5].getLine(2))+" |%$";
        getCube = getCube
                .replace("]",",")
                .replace("[","")
                .replace("%$","\n")
                .replace("tabs","              ")
                .replace("1,", "\u001B[34m1\u001B[00m")
                .replace("2,", "\u001B[35m2\u001B[00m")
                .replace("3,", "\u001B[36m3\u001B[00m")
                .replace("4,", "\u001B[31m4\u001B[00m")
                .replace("5,", "\u001B[33m5\u001B[00m")
                .replace("6,", "\u001B[32m6\u001B[00m")
        ;
        System.out.println(getCube);
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
            turnCenterToRight(up, !reverse);
        }else if (line == 2){
            turnCenterToRight(down, reverse);
        }

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
            turnCenterToRight(right, !reverse);
        }

    }
}
