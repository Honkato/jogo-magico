package dados;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        FuncoesUsuais f = new FuncoesUsuais();
        f.stringInt();
        /*
        // INICIALIZAR
        int cond = 0;
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

        // VELHA JOGO
        Velha L1 = new Velha();
//        Velha L2 = new Velha();

int parar = 0;
            while (true) {
                parar = L1.marcar(10, j1Marcador, j2Marcador);
                if (parar == 1){break;}
                parar = L1.marcar(20, j1Marcador, j2Marcador);
                if (parar == 1){break;}
            }
    }*/
}
}