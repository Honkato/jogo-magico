package bosch;

import java.util.Arrays;

public class Teste {

    public static void main(String[] args) {
        Velha teste = new Velha();
        Velha testa0 = new Velha();
        Velha[] tudo = {teste, testa0};
        int[] linha = {1,2,3};
        System.out.println(Arrays.toString(teste.getLine(0)));
        tudo[0].setLine(0,linha);
        System.out.println(Arrays.toString(tudo[0].getLine(0)));
        System.out.println(Arrays.toString(teste.getLine(0)));


    }
}
