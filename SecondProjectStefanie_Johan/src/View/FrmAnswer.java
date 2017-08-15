/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controllers.Question;
import java.awt.Color;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefanie
 */
public class FrmAnswer extends javax.swing.JFrame {

    private final JButton[][] game;
    private LinkedList<Models.Question> question;
    private int rowActual;
    private int columnactual;
    private int puntosGanados;
    private boolean delete;
    private boolean go;
    private int puntosPerdidos;

    /**
     * Creates new form FrmAnswer
     */
    public FrmAnswer() {
        initComponents();
        setLocationRelativeTo(null);
        game = new JButton[8][5];
        question = new LinkedList<>();
        loadButton();
        go=true;
        delete=false;
        rowActual = 0;
        columnactual = 0;
        troubles();
        loadQuestions();
        delete();
    }

    private void play(int row, int column) {
        if (game[row][column].getText().equals("x") && delete) {
            game[row][column].setText("");
            game[row][column].setBackground(Color.black);
            delete=false;
            delete();
        } else if (go){
            if (((row == (rowActual + 1)) && (column == (columnactual)))
                    || ((row == (rowActual)) && (column == (columnactual + 1)))) {
                int answer = 0;
                game[rowActual][columnactual].setBackground(Color.black);
                rowActual=row;
                columnactual=column;
                game[row][column].setBackground(Color.yellow);
                do {
                    answer = ask();
                    if (answer == 0) {
                        puntosGanados++;
                        JOptionPane.showMessageDialog(null, "Puede eliminar un obstaculo"
                                + "o elegir\nel comdín y avanzar una posición");
                        delete = true;
                        delete();
                        go=true;
                    } else {
                        puntosPerdidos++;
                        go=false;
                        delete = false;
                        delete();
                        newTrouble();
                    }
                } while (answer != 0);
            }
        }
    }

    private void delete() {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j].getText().equals("x")) {
                    game[i][j].setEnabled(delete);
                } else {
                    game[i][j].setEnabled(!delete);
                }
            }
        }
    }

    private void newTrouble() {
        boolean pass = true;
        do {
            int row = (int) (Math.random() * 7 + 0);
            int column = (int) (Math.random() * 4 + 0);
            String position = row + "_" + column;
            if (("".equals(game[row][column].getText())) && (!position.equals("0_0")) && (!position.equals("7_5"))) {
                game[row][column].setText("x");
                pass = false;
                game[row][column].setBackground(Color.red);
            }
        } while (pass);
        delete();
    }

    private int ask() {
        int rdm = (int) (Math.random() * (question.size() - 1) + 0);
        String message = question.get(rdm).getQuestion();
        String uno = question.get(rdm).getAnswerOne();
        String dos = question.get(rdm).getAnswerTwo();
        Object[] botones = {uno, dos};
        int answer = JOptionPane.showOptionDialog(null, message, "Pregunta", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
        question.remove(rdm);
        return answer;
    }

    private void loadButton() {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                JButton b = getButton(i + "_" + j);
                game[i][j] = b;
            }
        }
    }

    private void loadQuestions() {
        Controllers.Question q = new Question();
        question = q.select();
    }

    private void troubles() {
        int count = 0;
        while (count < 10) {
            int row = 0;
            int column = 0;
            boolean pass = true;
            do {
                row = (int) (Math.random() * 7 + 0);
                column = (int) (Math.random() * 4 + 0);
                String position = row + "_" + column;
                if (("".equals(game[row][column].getText())) && (!position.equals("0_0")) && (!position.equals("7_5"))) {
                    game[row][column].setText("x");
                    pass = false;
                    game[row][column].setBackground(Color.red);
                    count++;
                }
            } while (pass);
        }
        comodin();
    }

    private void comodin() {
        boolean fin = true;
        do {
            int row = (int) (Math.random() * 7 + 0);
            int column = (int) (Math.random() * 4 + 0);
            String position = row + "_" + column;
            if (("".equals(game[row][column].getText())) && (!position.equals("0_0")) && (!position.equals("7_5"))) {
                game[row][column].setText("c");
                game[row][column].setBackground(Color.blue);
                fin = false;
            }
        } while (fin);
    }

    private JButton getButton(String position) {
        switch (position) {
            case "0_0":
                return this.btn0_0;
            case "0_1":
                return this.btn0_1;
            case "0_2":
                return this.btn0_2;
            case "0_3":
                return this.btn0_3;
            case "0_4":
                return this.btn0_4;
            case "1_0":
                return this.btn1_0;
            case "1_1":
                return this.btn1_1;
            case "1_2":
                return this.btn1_2;
            case "1_3":
                return this.btn1_3;
            case "1_4":
                return this.btn1_4;
            case "2_0":
                return this.btn2_0;
            case "2_1":
                return this.btn2_1;
            case "2_2":
                return this.btn2_2;
            case "2_3":
                return this.btn2_3;
            case "2_4":
                return this.btn2_4;
            case "3_0":
                return this.btn3_0;
            case "3_1":
                return this.btn3_1;
            case "3_2":
                return this.btn3_2;
            case "3_3":
                return this.btn3_3;
            case "3_4":
                return this.btn3_4;
            case "4_0":
                return this.btn4_0;
            case "4_1":
                return this.btn4_1;
            case "4_2":
                return this.btn4_2;
            case "4_3":
                return this.btn4_3;
            case "4_4":
                return this.btn4_4;
            case "5_0":
                return this.btn5_0;
            case "5_1":
                return this.btn5_1;
            case "5_2":
                return this.btn5_2;
            case "5_3":
                return this.btn5_3;
            case "5_4":
                return this.btn5_4;
            case "6_0":
                return this.btn6_0;
            case "6_1":
                return this.btn6_1;
            case "6_2":
                return this.btn6_2;
            case "6_3":
                return this.btn6_3;
            case "6_4":
                return this.btn6_4;
            case "7_0":
                return this.btn7_0;
            case "7_1":
                return this.btn7_1;
            case "7_2":
                return this.btn7_2;
            case "7_3":
                return this.btn7_3;
            case "7_4":
                return this.btn7_4;
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn1_0 = new javax.swing.JButton();
        btn1_1 = new javax.swing.JButton();
        btn1_2 = new javax.swing.JButton();
        btn1_3 = new javax.swing.JButton();
        btn1_4 = new javax.swing.JButton();
        btn0_0 = new javax.swing.JButton();
        btn0_1 = new javax.swing.JButton();
        btn0_2 = new javax.swing.JButton();
        btn0_3 = new javax.swing.JButton();
        btn0_4 = new javax.swing.JButton();
        btn2_0 = new javax.swing.JButton();
        btn2_1 = new javax.swing.JButton();
        btn2_2 = new javax.swing.JButton();
        btn2_3 = new javax.swing.JButton();
        btn2_4 = new javax.swing.JButton();
        btn3_0 = new javax.swing.JButton();
        btn3_1 = new javax.swing.JButton();
        btn3_2 = new javax.swing.JButton();
        btn3_3 = new javax.swing.JButton();
        btn3_4 = new javax.swing.JButton();
        btn4_0 = new javax.swing.JButton();
        btn4_1 = new javax.swing.JButton();
        btn4_2 = new javax.swing.JButton();
        btn4_3 = new javax.swing.JButton();
        btn4_4 = new javax.swing.JButton();
        btn5_0 = new javax.swing.JButton();
        btn5_1 = new javax.swing.JButton();
        btn5_2 = new javax.swing.JButton();
        btn5_3 = new javax.swing.JButton();
        btn5_4 = new javax.swing.JButton();
        btn6_0 = new javax.swing.JButton();
        btn6_1 = new javax.swing.JButton();
        btn6_2 = new javax.swing.JButton();
        btn6_3 = new javax.swing.JButton();
        btn6_4 = new javax.swing.JButton();
        btn7_0 = new javax.swing.JButton();
        btn7_1 = new javax.swing.JButton();
        btn7_2 = new javax.swing.JButton();
        btn7_3 = new javax.swing.JButton();
        btn7_4 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btn1_0.setBackground(new java.awt.Color(0, 0, 0));
        btn1_0.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn1_0.setForeground(new java.awt.Color(255, 255, 255));
        btn1_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1_0ActionPerformed(evt);
            }
        });

        btn1_1.setBackground(new java.awt.Color(0, 0, 0));
        btn1_1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn1_1.setForeground(new java.awt.Color(255, 255, 255));
        btn1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1_1ActionPerformed(evt);
            }
        });

        btn1_2.setBackground(new java.awt.Color(0, 0, 0));
        btn1_2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn1_2.setForeground(new java.awt.Color(255, 255, 255));
        btn1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1_2ActionPerformed(evt);
            }
        });

        btn1_3.setBackground(new java.awt.Color(0, 0, 0));
        btn1_3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn1_3.setForeground(new java.awt.Color(255, 255, 255));
        btn1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1_3ActionPerformed(evt);
            }
        });

        btn1_4.setBackground(new java.awt.Color(0, 0, 0));
        btn1_4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn1_4.setForeground(new java.awt.Color(255, 255, 255));
        btn1_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1_4ActionPerformed(evt);
            }
        });

        btn0_0.setBackground(new java.awt.Color(0, 153, 153));
        btn0_0.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn0_0.setForeground(new java.awt.Color(255, 255, 255));
        btn0_0.setText("Inicio");
        btn0_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0_0ActionPerformed(evt);
            }
        });

        btn0_1.setBackground(new java.awt.Color(0, 0, 0));
        btn0_1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn0_1.setForeground(new java.awt.Color(255, 255, 255));
        btn0_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0_1ActionPerformed(evt);
            }
        });

        btn0_2.setBackground(new java.awt.Color(0, 0, 0));
        btn0_2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn0_2.setForeground(new java.awt.Color(255, 255, 255));
        btn0_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0_2ActionPerformed(evt);
            }
        });

        btn0_3.setBackground(new java.awt.Color(0, 0, 0));
        btn0_3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn0_3.setForeground(new java.awt.Color(255, 255, 255));
        btn0_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0_3ActionPerformed(evt);
            }
        });

        btn0_4.setBackground(new java.awt.Color(0, 0, 0));
        btn0_4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn0_4.setForeground(new java.awt.Color(255, 255, 255));
        btn0_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0_4ActionPerformed(evt);
            }
        });

        btn2_0.setBackground(new java.awt.Color(0, 0, 0));
        btn2_0.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn2_0.setForeground(new java.awt.Color(255, 255, 255));
        btn2_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2_0ActionPerformed(evt);
            }
        });

        btn2_1.setBackground(new java.awt.Color(0, 0, 0));
        btn2_1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn2_1.setForeground(new java.awt.Color(255, 255, 255));
        btn2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2_1ActionPerformed(evt);
            }
        });

        btn2_2.setBackground(new java.awt.Color(0, 0, 0));
        btn2_2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn2_2.setForeground(new java.awt.Color(255, 255, 255));
        btn2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2_2ActionPerformed(evt);
            }
        });

        btn2_3.setBackground(new java.awt.Color(0, 0, 0));
        btn2_3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn2_3.setForeground(new java.awt.Color(255, 255, 255));
        btn2_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2_3ActionPerformed(evt);
            }
        });

        btn2_4.setBackground(new java.awt.Color(0, 0, 0));
        btn2_4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn2_4.setForeground(new java.awt.Color(255, 255, 255));
        btn2_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2_4ActionPerformed(evt);
            }
        });

        btn3_0.setBackground(new java.awt.Color(0, 0, 0));
        btn3_0.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn3_0.setForeground(new java.awt.Color(255, 255, 255));
        btn3_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3_0ActionPerformed(evt);
            }
        });

        btn3_1.setBackground(new java.awt.Color(0, 0, 0));
        btn3_1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn3_1.setForeground(new java.awt.Color(255, 255, 255));
        btn3_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3_1ActionPerformed(evt);
            }
        });

        btn3_2.setBackground(new java.awt.Color(0, 0, 0));
        btn3_2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn3_2.setForeground(new java.awt.Color(255, 255, 255));
        btn3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3_2ActionPerformed(evt);
            }
        });

        btn3_3.setBackground(new java.awt.Color(0, 0, 0));
        btn3_3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn3_3.setForeground(new java.awt.Color(255, 255, 255));
        btn3_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3_3ActionPerformed(evt);
            }
        });

        btn3_4.setBackground(new java.awt.Color(0, 0, 0));
        btn3_4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn3_4.setForeground(new java.awt.Color(255, 255, 255));
        btn3_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3_4ActionPerformed(evt);
            }
        });

        btn4_0.setBackground(new java.awt.Color(0, 0, 0));
        btn4_0.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn4_0.setForeground(new java.awt.Color(255, 255, 255));
        btn4_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4_0ActionPerformed(evt);
            }
        });

        btn4_1.setBackground(new java.awt.Color(0, 0, 0));
        btn4_1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn4_1.setForeground(new java.awt.Color(255, 255, 255));
        btn4_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4_1ActionPerformed(evt);
            }
        });

        btn4_2.setBackground(new java.awt.Color(0, 0, 0));
        btn4_2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn4_2.setForeground(new java.awt.Color(255, 255, 255));
        btn4_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4_2ActionPerformed(evt);
            }
        });

        btn4_3.setBackground(new java.awt.Color(0, 0, 0));
        btn4_3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn4_3.setForeground(new java.awt.Color(255, 255, 255));
        btn4_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4_3ActionPerformed(evt);
            }
        });

        btn4_4.setBackground(new java.awt.Color(0, 0, 0));
        btn4_4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn4_4.setForeground(new java.awt.Color(255, 255, 255));
        btn4_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4_4ActionPerformed(evt);
            }
        });

        btn5_0.setBackground(new java.awt.Color(0, 0, 0));
        btn5_0.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn5_0.setForeground(new java.awt.Color(255, 255, 255));
        btn5_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5_0ActionPerformed(evt);
            }
        });

        btn5_1.setBackground(new java.awt.Color(0, 0, 0));
        btn5_1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn5_1.setForeground(new java.awt.Color(255, 255, 255));
        btn5_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5_1ActionPerformed(evt);
            }
        });

        btn5_2.setBackground(new java.awt.Color(0, 0, 0));
        btn5_2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn5_2.setForeground(new java.awt.Color(255, 255, 255));
        btn5_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5_2ActionPerformed(evt);
            }
        });

        btn5_3.setBackground(new java.awt.Color(0, 0, 0));
        btn5_3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn5_3.setForeground(new java.awt.Color(255, 255, 255));
        btn5_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5_3ActionPerformed(evt);
            }
        });

        btn5_4.setBackground(new java.awt.Color(0, 0, 0));
        btn5_4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn5_4.setForeground(new java.awt.Color(255, 255, 255));
        btn5_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5_4ActionPerformed(evt);
            }
        });

        btn6_0.setBackground(new java.awt.Color(0, 0, 0));
        btn6_0.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn6_0.setForeground(new java.awt.Color(255, 255, 255));
        btn6_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6_0ActionPerformed(evt);
            }
        });

        btn6_1.setBackground(new java.awt.Color(0, 0, 0));
        btn6_1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn6_1.setForeground(new java.awt.Color(255, 255, 255));
        btn6_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6_1ActionPerformed(evt);
            }
        });

        btn6_2.setBackground(new java.awt.Color(0, 0, 0));
        btn6_2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn6_2.setForeground(new java.awt.Color(255, 255, 255));
        btn6_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6_2ActionPerformed(evt);
            }
        });

        btn6_3.setBackground(new java.awt.Color(0, 0, 0));
        btn6_3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn6_3.setForeground(new java.awt.Color(255, 255, 255));
        btn6_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6_3ActionPerformed(evt);
            }
        });

        btn6_4.setBackground(new java.awt.Color(0, 0, 0));
        btn6_4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn6_4.setForeground(new java.awt.Color(255, 255, 255));
        btn6_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6_4ActionPerformed(evt);
            }
        });

        btn7_0.setBackground(new java.awt.Color(0, 0, 0));
        btn7_0.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn7_0.setForeground(new java.awt.Color(255, 255, 255));
        btn7_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7_0ActionPerformed(evt);
            }
        });

        btn7_1.setBackground(new java.awt.Color(0, 0, 0));
        btn7_1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn7_1.setForeground(new java.awt.Color(255, 255, 255));
        btn7_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7_1ActionPerformed(evt);
            }
        });

        btn7_2.setBackground(new java.awt.Color(0, 0, 0));
        btn7_2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn7_2.setForeground(new java.awt.Color(255, 255, 255));
        btn7_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7_2ActionPerformed(evt);
            }
        });

        btn7_3.setBackground(new java.awt.Color(0, 0, 0));
        btn7_3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn7_3.setForeground(new java.awt.Color(255, 255, 255));
        btn7_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7_3ActionPerformed(evt);
            }
        });

        btn7_4.setBackground(new java.awt.Color(255, 153, 51));
        btn7_4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btn7_4.setForeground(new java.awt.Color(255, 255, 255));
        btn7_4.setText("Fin");
        btn7_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7_4ActionPerformed(evt);
            }
        });

        jMenu1.setText("Reiniciar");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salir");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn5_0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn6_0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn7_0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn5_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn6_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn7_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1_2ActionPerformed
        play(1,2);
    }//GEN-LAST:event_btn1_2ActionPerformed

    private void btn1_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1_3ActionPerformed
        play(1,3);
    }//GEN-LAST:event_btn1_3ActionPerformed

    private void btn1_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1_4ActionPerformed
       play(1,4);
    }//GEN-LAST:event_btn1_4ActionPerformed

    private void btn0_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0_2ActionPerformed
        play(0, 2);
    }//GEN-LAST:event_btn0_2ActionPerformed

    private void btn0_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0_3ActionPerformed
        play(0, 3);
    }//GEN-LAST:event_btn0_3ActionPerformed

    private void btn0_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0_4ActionPerformed
        play(0, 4);
    }//GEN-LAST:event_btn0_4ActionPerformed

    private void btn2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2_2ActionPerformed
        play(2,2);
    }//GEN-LAST:event_btn2_2ActionPerformed

    private void btn2_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2_3ActionPerformed
        play(2,3);
    }//GEN-LAST:event_btn2_3ActionPerformed

    private void btn2_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2_4ActionPerformed
        play(2,4);
    }//GEN-LAST:event_btn2_4ActionPerformed

    private void btn3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3_2ActionPerformed
        play(3,2);
    }//GEN-LAST:event_btn3_2ActionPerformed

    private void btn3_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3_3ActionPerformed
        play(3,3);
    }//GEN-LAST:event_btn3_3ActionPerformed

    private void btn3_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3_4ActionPerformed
        play(3,4);
    }//GEN-LAST:event_btn3_4ActionPerformed

    private void btn4_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4_2ActionPerformed
       play(4,2);
    }//GEN-LAST:event_btn4_2ActionPerformed

    private void btn4_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4_3ActionPerformed
        play(4,3);
    }//GEN-LAST:event_btn4_3ActionPerformed

    private void btn4_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4_4ActionPerformed
        play(4,4);
    }//GEN-LAST:event_btn4_4ActionPerformed

    private void btn5_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5_2ActionPerformed
        play(5,2);
    }//GEN-LAST:event_btn5_2ActionPerformed

    private void btn5_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5_3ActionPerformed
        play(5,3);
    }//GEN-LAST:event_btn5_3ActionPerformed

    private void btn5_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5_4ActionPerformed
        play(5,4);
    }//GEN-LAST:event_btn5_4ActionPerformed

    private void btn6_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6_2ActionPerformed
        play(6,2);
    }//GEN-LAST:event_btn6_2ActionPerformed

    private void btn6_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6_3ActionPerformed
       play(6,3);
    }//GEN-LAST:event_btn6_3ActionPerformed

    private void btn6_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6_4ActionPerformed
        play(6,4);
    }//GEN-LAST:event_btn6_4ActionPerformed

    private void btn7_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7_2ActionPerformed
        play(7,2);
    }//GEN-LAST:event_btn7_2ActionPerformed

    private void btn7_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7_3ActionPerformed
        play(7,3);
    }//GEN-LAST:event_btn7_3ActionPerformed

    private void btn7_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7_4ActionPerformed
        play(7,4);
    }//GEN-LAST:event_btn7_4ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        FrmAnswer oAnswer = new FrmAnswer();
        oAnswer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void btn0_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0_0ActionPerformed
        
    }//GEN-LAST:event_btn0_0ActionPerformed

    private void btn0_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0_1ActionPerformed
        play(0, 1);
    }//GEN-LAST:event_btn0_1ActionPerformed

    private void btn1_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1_0ActionPerformed
        play(1,0);
    }//GEN-LAST:event_btn1_0ActionPerformed

    private void btn1_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1_1ActionPerformed
         play(1,1);
    }//GEN-LAST:event_btn1_1ActionPerformed

    private void btn2_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2_0ActionPerformed
         play(2,0);
    }//GEN-LAST:event_btn2_0ActionPerformed

    private void btn2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2_1ActionPerformed
         play(2,1);
    }//GEN-LAST:event_btn2_1ActionPerformed

    private void btn3_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3_0ActionPerformed
         play(3,0);
    }//GEN-LAST:event_btn3_0ActionPerformed

    private void btn3_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3_1ActionPerformed
         play(3,1);
    }//GEN-LAST:event_btn3_1ActionPerformed

    private void btn4_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4_0ActionPerformed
         play(4,0);
    }//GEN-LAST:event_btn4_0ActionPerformed

    private void btn4_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4_1ActionPerformed
         play(4,1);
    }//GEN-LAST:event_btn4_1ActionPerformed

    private void btn5_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5_0ActionPerformed
         play(5,0);
    }//GEN-LAST:event_btn5_0ActionPerformed

    private void btn5_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5_1ActionPerformed
         play(5,1);
    }//GEN-LAST:event_btn5_1ActionPerformed

    private void btn6_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6_0ActionPerformed
         play(6,0);
    }//GEN-LAST:event_btn6_0ActionPerformed

    private void btn6_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6_1ActionPerformed
         play(6,1);
    }//GEN-LAST:event_btn6_1ActionPerformed

    private void btn7_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7_0ActionPerformed
         play(7,0);
    }//GEN-LAST:event_btn7_0ActionPerformed

    private void btn7_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7_1ActionPerformed
         play(7,1);
    }//GEN-LAST:event_btn7_1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmAnswer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAnswer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAnswer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAnswer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAnswer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0_0;
    private javax.swing.JButton btn0_1;
    private javax.swing.JButton btn0_2;
    private javax.swing.JButton btn0_3;
    private javax.swing.JButton btn0_4;
    private javax.swing.JButton btn1_0;
    private javax.swing.JButton btn1_1;
    private javax.swing.JButton btn1_2;
    private javax.swing.JButton btn1_3;
    private javax.swing.JButton btn1_4;
    private javax.swing.JButton btn2_0;
    private javax.swing.JButton btn2_1;
    private javax.swing.JButton btn2_2;
    private javax.swing.JButton btn2_3;
    private javax.swing.JButton btn2_4;
    private javax.swing.JButton btn3_0;
    private javax.swing.JButton btn3_1;
    private javax.swing.JButton btn3_2;
    private javax.swing.JButton btn3_3;
    private javax.swing.JButton btn3_4;
    private javax.swing.JButton btn4_0;
    private javax.swing.JButton btn4_1;
    private javax.swing.JButton btn4_2;
    private javax.swing.JButton btn4_3;
    private javax.swing.JButton btn4_4;
    private javax.swing.JButton btn5_0;
    private javax.swing.JButton btn5_1;
    private javax.swing.JButton btn5_2;
    private javax.swing.JButton btn5_3;
    private javax.swing.JButton btn5_4;
    private javax.swing.JButton btn6_0;
    private javax.swing.JButton btn6_1;
    private javax.swing.JButton btn6_2;
    private javax.swing.JButton btn6_3;
    private javax.swing.JButton btn6_4;
    private javax.swing.JButton btn7_0;
    private javax.swing.JButton btn7_1;
    private javax.swing.JButton btn7_2;
    private javax.swing.JButton btn7_3;
    private javax.swing.JButton btn7_4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
