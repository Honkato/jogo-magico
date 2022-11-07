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


    public static void turnCenterToRight(Velha center, Velha up, Velha down, Velha left, Velha right, boolean reverse) {
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
