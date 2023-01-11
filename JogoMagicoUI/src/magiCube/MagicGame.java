package magiCube;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MagicGame extends JFrame implements ActionListener {
    private JPanel gameScreen;
    private JButton c1,c2,c3,c4,c5,c6,c7,c8,c9,r1,r2,r3,r4,r5,r6,r7,r8,r9,l1,l2,l3,l4,l5,l6,l7,l8,l9;
    private JButton u1,u2,u3,u4,u5,u6,u7,u8,u9,d1,d2,d3,d4,d5,d6,d7,d8,d9,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    private JButton centerLineRight0,centerLineRight1,centerLineRight2;
    private JButton centerLineLeft0,centerLineLeft1, centerLineLeft2;
    private JButton centerColumnDown0,centerColumnDown1,centerColumnDown2;
    private JButton centerColumnUpper0,centerColumnUpper1,centerColumnUpper2;
    private JButton centerRollRight,centerRollLeft;
    private JButton middleRollRight,middleRollLeft;
    private JButton backRollRight,backRollLeft;
    private JButton rulesButton;
    private JButton resetButton;
    private JTextField scoreTextField;
    private JTextField pointsX;
    private JTextField pointsO;

    JButton[] centerLineRight = {centerLineRight0,centerLineRight1,centerLineRight2};
    JButton[] centerLineLeft = {centerLineLeft0,centerLineLeft1,centerLineLeft2};
    JButton[] centerColumnDown = {centerColumnDown0,centerColumnDown1,centerColumnDown2};
    JButton[] centerColumnUpper = {centerColumnUpper0,centerColumnUpper1,centerColumnUpper2};
    JButton[] rollButtons = {centerRollRight,centerRollLeft, middleRollRight,middleRollLeft, backRollRight,backRollLeft};

    JButton[][] btnFunctions = {centerLineRight, centerLineLeft, centerColumnDown, centerColumnUpper, rollButtons};

    JButton[] btnCenter = {c1,c2,c3,c4,c5,c6,c7,c8,c9};
    JButton[] btnUpper = {u1,u2,u3,u4,u5,u6,u7,u8,u9};
    JButton[] btnDown = {d1,d2,d3,d4,d5,d6,d7,d8,d9};
    JButton[] btnLeft = {l1,l2,l3,l4,l5,l6,l7,l8,l9};
    JButton[] btnRight = {r1 ,r2,r3,r4,r5,r6,r7,r8,r9};
    JButton[] btnBack = {b1,b2,b3,b4,b5,b6,b7,b8,b9};
    JButton[][] btnAllCubes = {
            btnCenter, btnUpper, btnDown, btnLeft, btnRight, btnBack
    };
    String xo = "O";

    Velha centerCube = new Velha();
    Velha upCube = new Velha();
    Velha backCube = new Velha();
    Velha downCube = new Velha();
    Velha leftCube = new Velha();
    Velha rightCube = new Velha();
    Velha[] allCubes = {centerCube, upCube, downCube, leftCube, rightCube, backCube};

    public MagicGame(){
        setContentPane(gameScreen);
        setSize(1000,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
//        c1.setBorder(new LineBorder(Color.BLACK));
        //                   Center(red),   Upper(green),   Down(purple),   Left(yellow),   Right(Blue), Back(Gray)
        String[] coresTom = {"#B12141",     "#89EB34",      "#6824D4",      "#F6C72A",      "#2EF5E9",   "#DFDFDF"};
//        String[] coresTom = {"#FF5C00",     "#0066FF",      "#5CD000",      "#4E00F2",      "#FA00FF",   "#FFE925"};
        String[] nomes = {"20","21","22","10","11","12","00","01","02"};
        int color = 0;
        for (JButton[] buttons: btnAllCubes){
            for (int a = 0; a < 9; a++) {
                buttons[a].addActionListener(this);
                buttons[a].setBorder(BorderFactory.createLineBorder(Color.decode(coresTom[color]), 5));
                buttons[a].setName(nomes[a]);
            }
            color += 1;
        }
        btnBack[1].setBorder(BorderFactory.createLineBorder(Color.decode(coresTom[2]), 5));
        btnBack[3].setBorder(BorderFactory.createLineBorder(Color.decode(coresTom[3]), 5));
        btnBack[5].setBorder(BorderFactory.createLineBorder(Color.decode(coresTom[4]), 5));
        btnBack[7].setBorder(BorderFactory.createLineBorder(Color.decode(coresTom[1]), 5));


        centerLineRight0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, 0, false);
                functionalFunction();
            }
        });
        centerLineRight1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, 1, false);
                functionalFunction();
            }
        });
        centerLineRight2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, 2, false);
                functionalFunction();
            }
        });

        // CENTER LEFT
        centerLineLeft0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, 0, true);
                functionalFunction();
            }
        });
        centerLineLeft1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, 1, true);
                functionalFunction();
            }
        });
        centerLineLeft2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterLineToRight(leftCube, centerCube, rightCube, backCube, upCube, downCube, 2, true);
                functionalFunction();
            }
        });

        // CENTER DOWN
        centerColumnDown0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterLineToDown(leftCube,centerCube,rightCube,backCube,upCube,downCube, 0, false);
                functionalFunction();
            }
        });
        centerColumnDown1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterLineToDown(leftCube,centerCube,rightCube,backCube,upCube,downCube, 1, false);
                functionalFunction();
            }
        });
        centerColumnDown2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterLineToDown(leftCube,centerCube,rightCube,backCube,upCube,downCube, 2, false);
                functionalFunction();
            }
        });

        // CENTER UPPER
        centerColumnUpper0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterLineToDown(leftCube,centerCube,rightCube,backCube,upCube,downCube, 0, true);
                functionalFunction();
            }
        });
        centerColumnUpper1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterLineToDown(leftCube,centerCube,rightCube,backCube,upCube,downCube, 1, true);
                functionalFunction();
            }
        });
        centerColumnUpper2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterLineToDown(leftCube,centerCube,rightCube,backCube,upCube,downCube, 2, true);
                functionalFunction();
            }
        });
        centerRollRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterToRight( centerCube,  upCube,  downCube,  leftCube,  rightCube,false);
            }
        });
        middleRollRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterToRight( upCube,  downCube,  leftCube,  rightCube,false);
            }
        });
        backRollRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterToRight( backCube,  downCube,  upCube,  rightCube,  leftCube,false);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Velha cube: allCubes) {
                    cube.setLine(0, new int[]{0, 0, 0});
                    cube.setLine(1, new int[]{0, 0, 0});
                    cube.setLine(2, new int[]{0, 0, 0});
                }
                functionalFunction();
                for (JButton[] btnCubes:btnAllCubes) {
                    for (JButton btn : btnCubes){
                        btn.setEnabled(true);
                    }
                }
                for (JButton[] btnFuncs: btnFunctions) {
                    for (JButton btn: btnFuncs) {
                        btn.setEnabled(true);
                    }
                }
            }
        });
        centerRollLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterToRight( centerCube,  upCube,  downCube,  leftCube,  rightCube,true);
            }
        });
        middleRollLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterToRight( upCube,  downCube,  centerCube,  backCube, false);
            }
        });
        backRollLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnCenterToRight( backCube,  downCube,  upCube,  rightCube,  leftCube,true);
            }
        });
    }

    public void vencer(){
        for(JButton[] buttons : btnAllCubes){
            for (JButton i : buttons){
                i.setEnabled(false);
            }
        }
        for (JButton[] btnFuncs: btnFunctions) {
            for (JButton btn: btnFuncs) {
                btn.setEnabled(false);
            }
        }
    }
    public void showBack(){
        boolean caiu = false;
        for (int i = 0; i < (btnAllCubes.length - 1); i++) {
            for (int j = 0; j < 9; j++) {
                if (btnAllCubes[i][j].getText().equals("")){
                    caiu = true;
                }
            }
        }
        if (!caiu){
            for(JButton btn : btnBack){
                btn.setBackground(new Color(27,27,27));
                btn.setEnabled(true);
            }
        }

    }

    public void functionalFunction(){
        if (Objects.equals(xo, "O")) {
            xo = "X";
        } else {
            xo = "O";
        }

        for (int i = 0; i < btnAllCubes.length; i++) {
            for (int j = 0; j < 9; j++) {
                if (allCubes[i].getCoord(btnAllCubes[i][j].getName()) == 1){
                    btnAllCubes[i][j].setText("X");
                }else
                if (allCubes[i].getCoord(btnAllCubes[i][j].getName()) == 2){
                    btnAllCubes[i][j].setText("O");
                }else{
                    btnAllCubes[i][j].setText("");
                }
            }
        }
        if(centerCube.verifyWinner()){
            vencer();
        }
    }


    // ==================
    // FUNÇÕES GIRAR CUBO
    // ==================

    // ==================
    //  COLUNAS E LINHAS
    // ==================
    public void turnCenterLineToRight(Velha left, Velha center, Velha right, Velha back, Velha up, Velha down, int line, boolean reverse) {

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
        }else {
//            Turn to right
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    sides[i].setLine(line, linesList[3]);
                } else {
                    sides[i].setLine(line, linesList[i - 1]);
                }
            }
        }

        if (line == 0){
            turnCenterToRight(up, !reverse);
        }else if (line == 2){
            turnCenterToRight(down, reverse);
        }

    }


    //    FAZ A MESMA COISA QUE O ANTERIOR MAS PARA BAIXO
    public void turnCenterLineToDown(Velha left, Velha center, Velha right, Velha back, Velha up, Velha down, int column, boolean reverse) {

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
        }else {
//            Turn to right
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    sides[i].setColumn(column, columnsList[3]);
                } else {
                    sides[i].setColumn(column, columnsList[i - 1]);
                }
            }
        }

        if (column == 0){
            turnCenterToRight(left, reverse);
        }else if (column == 2){
            turnCenterToRight(right, !reverse);
        }

    }
    public void turnCenterToRight(Velha center, boolean reverse) {

        int[][] centerLine = {center.getLine(0),center.getLine(1),center.getLine(2)};

        if (reverse) {
            for (int i = 0; i < centerLine.length; i++){
                centerLine[i] = reverse(centerLine[i]);
                center.setColumn(i, centerLine[i]);
            }
            /*
            centerLine[2] = reverse(centerLine[2]);
            centerLine[1] = reverse(centerLine[1]);
            centerLine[0] = reverse(centerLine[0]);
            center.setColumn(2, centerLine[2]);
            center.setColumn(1, centerLine[1]);
            center.setColumn(0, centerLine[0]);
            */
        } else {
            for(int i = -2; i <= 0; i++){
                center.setColumn(i*-1, centerLine[i+2]);
                center.setColumn(i*-1, centerLine[i+2]);
                center.setColumn(i*-1, centerLine[i+2]);
            }
        }
    }


    // ==================
    //  COLUNAS E LINHAS
    // ==================
        public int[] reverse(int[] vetorDe3){
            vetorDe3 = new int[]{vetorDe3[2], vetorDe3[1], vetorDe3[0]};
            return vetorDe3;
        }

        public void turnCenterToRight(Velha center, Velha up, Velha down, Velha left, Velha right, boolean reverse){
//            Velha[] allCubes = {centerCube, upCube, downCube, leftCube, rightCube, backCube};
            int[][] centerLine = {center.getLine(0),center.getLine(1),center.getLine(2)};

            int[] upLine = up.getLine(2);
            int[] downLine = down.getLine(0);
            int[] leftColumn = left.getColumn(2);
            int[] rightColumn = right.getColumn(0);

            if (reverse){
                leftColumn = reverse(right.getColumn(0));
                upLine = reverse(down.getLine(0));
                rightColumn = reverse(left.getColumn(2));
                downLine = reverse(up.getLine(2));

                centerLine[2] = reverse(centerLine[0]);
                centerLine[1] = reverse(centerLine[1]);
                centerLine[0] = reverse(centerLine[2]);
            }

            center.setColumn(2, centerLine[0]);
            center.setColumn(1, centerLine[1]);
            center.setColumn(0, centerLine[2]);

            up.setLine(2, reverse(leftColumn));
            right.setColumn(0, upLine);
            down.setLine(0, reverse(rightColumn));
            left.setColumn(2, downLine);

            functionalFunction();
        }

    public void turnCenterToRight(Velha up, Velha down, Velha left, Velha right,boolean reverse){
        int[] upLine = up.getLine(1);
        int[] downLine = down.getLine(1);
        int[] leftColumn = left.getColumn(1);
        int[] rightColumn = right.getColumn(1);


        if (reverse){
            leftColumn = reverse(right.getColumn(1));
            upLine = reverse(down.getLine(1));
            rightColumn = reverse(left.getColumn(1));
            downLine = reverse(up.getLine(1));
        }


        up.setLine(1, reverse(leftColumn));
        right.setColumn(1, upLine);
        down.setLine(1, reverse(rightColumn));
        left.setColumn(1, downLine);

        functionalFunction();
    }
        //    FUNÇÃO AUXILIAR PARA TROCAR OS LADOS DOS CUBOS
        public void setCubeSide(Velha cubo, int definir){
            int[] set = {definir, definir, definir};
            cubo.setLine(0, set);
            cubo.setLine(1, set);
            cubo.setLine(2, set);
        }

    // ==================
    // FUNÇÕES GIRAR CUBO
    // ==================

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = 0;
        for (JButton[] btnVelhas : btnAllCubes) {
            for (JButton btnPressed : btnVelhas) {
                if ((e.getSource() == btnPressed) && (btnPressed.getText().equals(""))) {
                    int marca;
                    if (Objects.equals(xo, "O")) {
                        xo = "X";
                        marca = 1;
                    } else {
                        xo = "O";
                        marca = 2;
                    }
                    btnPressed.setText(xo);
                    System.out.println("name: "+btnPressed.getName());
                    String[] num= btnPressed.getName().split("");
                    allCubes[index].cube[Integer.parseInt(num[0])][Integer.parseInt(num[1])] = marca;
                    System.out.println(btnPressed.getText());
                    allCubes[index].showCube();
                    if(centerCube.verifyWinner()){
                        vencer();
                    }
                    showBack();
                }
            }

//            allCubes[index]
            System.out.println("Index: "+index);
            System.out.println(allCubes[index]);
            index += 1;
            if (index > 6){
                index = 0;
            }
        }

    }
}
