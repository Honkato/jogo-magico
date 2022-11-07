package bosch;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        Velha centerCube = new Velha();
        Velha upCube = new Velha();
        Velha backCube = new Velha();
        Velha downCube = new Velha();
        Velha leftCube = new Velha();
        Velha rightCube = new Velha();

        boolean a = centerCube.verifyWinner();

        turnCenterToRight(centerCube, upCube, downCube, leftCube, rightCube, true);

        a = centerCube.verifyWinner();
    }


    public static void turnCenterToRight(Velha center, Velha up, Velha left, Velha right, Velha down, boolean reverse) {

        int[] centerL0 = center.getLine0();
        int[] centerL1 = center.getLine1();
        int[] centerL2 = center.getLine2();

        int[] centerC0 = center.getColumn0();
        int[] centerC1 = center.getColumn1();
        int[] centerC2 = center.getColumn2();


        if (reverse) {
//            center.cube = new int[][]{
//                    {center.cube[0][2], center.cube[1][2], center.cube[2][2]},
//                    {center.cube[0][1], center.cube[1][1], center.cube[2][1]},
//                    {center.cube[0][0], center.cube[1][0], center.cube[2][0]}};

            center.setColumn0();
            center.setColumn1();
            center.setColumn2();

            System.out.println(Arrays.deepToString(center.cube));

        } else {
            center.cube = new int[][]{
                    {center.cube[2][0], center.cube[1][0], center.cube[0][0]},
                    {center.cube[2][1], center.cube[1][1], center.cube[0][1]},
                    {center.cube[2][2], center.cube[1][2], center.cube[0][2]}};
            System.out.println(Arrays.deepToString(center.cube));
        }
    }
    public static void turnCenterToUp(Velha center, Velha up, Velha back, Velha down, boolean reverse) {
        if (reverse) {
            center.cube = new int[][]{
                    {center.cube[0][2], center.cube[1][2], center.cube[2][2]},
                    {center.cube[0][1], center.cube[1][1], center.cube[2][1]},
                    {center.cube[0][0], center.cube[1][0], center.cube[2][0]}};
            System.out.println(Arrays.deepToString(center.cube));

        } else {
            center.cube = new int[][]{
                    {center.cube[2][0], center.cube[1][0], center.cube[0][0]},
                    {center.cube[2][1], center.cube[1][1], center.cube[0][1]},
                    {center.cube[2][2], center.cube[1][2], center.cube[0][2]}};
            System.out.println(Arrays.deepToString(center.cube));
        }
    }

}
