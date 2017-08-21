/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controllers.Statistics;
import Controllers.Swimmer;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefanie
 */
public class FrmSwim extends javax.swing.JFrame {

    private Timer timer;
    private LinkedList<Models.Swimmer> lSwimmer;
    private Timer cronom;
    private int empates;
    private TimerTask taskCronom;
    private TimerTask taskRun;
    private DefaultListModel model;
    boolean open;
    private LinkedList<Models.Swimmer> lSend;
    private LinkedList<Models.Swimmer> lSwimming;
    private int posicion;
    private Models.Statistics statisticas;
    private Controllers.Statistics statis;

    /**
     * Creates new form FrmSwim
     */
    public FrmSwim() {
        initComponents();
        this.setSize(890, 420);
        setLocationRelativeTo(null);
        timer = new Timer();
        cronom = new Timer();
        model = new DefaultListModel();
        lSwimmers.setModel(model);
        lSend = new LinkedList<>();
        lSwimming = new LinkedList<>();
        System.out.println(pPool.getWidth() + pPool.getX());
        lChoose.setModel(model);
        statisticas = new Models.Statistics();
        statis = new Statistics();
        pPool.setSize(740, 250);
        open = false;
        empates = 0;
        posicion = 1;
        loadSwimmers();
        hideBtn(false);
        sta();
    }

    /**
     * loads  the list of swimmers
     */
    private void loadSwimmers() {
        Controllers.Swimmer s = new Swimmer();
        lSwimmer = s.select();
        showSwimers();
    }

    /**
     * shows the swimmer on the screen
     */
    private void showSwimers() {
        model.clear();
        for (int i = 0; i < lSwimmer.size(); i++) {
            model.addElement(lSwimmer.get(i).toString());
        }
    }

    /**
     * adds a new swimmer
     */
    private void addSwimmer() {
        Models.Swimmer swimmer = new Models.Swimmer();
        swimmer.setName(txtName.getText().trim());
        swimmer.setLastName(txtLastName.getText().trim());
        swimmer.setCode(getCode());
        swimmer.setGanadas(0);
        swimmer.setPerdidas(0);
        Controllers.Swimmer s = new Swimmer(swimmer);
        s.add();
        loadSwimmers();
    }

    /**
     * delete a swimmer
     */
    private void deleteSwimmer() {
        int select = lSwimmers.getSelectedIndex();
        if (select > -1) {
            Controllers.Swimmer s = new Swimmer(lSwimmer.get(select));
            s.delete();
            loadSwimmers();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una persona");
        }
        loadSwimmers();
    }

    /**
     * gets a random code to a new swimmer
     * @return 
     */
    private String getCode() {
        String code = "";
        for (int i = 0; i < 6; i++) {
            code += (int) (Math.random() * 9 + 1);
        }
        return code;
    }

    /**
     * hides and shows the buttons
     * @param ver (true or false)
     */
    private void hideBtn(boolean ver) {
        lblJug1.setVisible(ver);
        btnJug1Info.setVisible(ver);
        lblJug2.setVisible(ver);
        btnJug2Info.setVisible(ver);
        lblJug3.setVisible(ver);
        btnJug3Info.setVisible(ver);
        lblJug4.setVisible(ver);
        btnJug4Info.setVisible(ver);
        lblJug5.setVisible(ver);
        btnJug5Info.setVisible(ver);
    }

    /**
     * update the swimmer information
     * @param swimmer 
     */
    private void update(Models.Swimmer swimmer) {
        Controllers.Swimmer s = new Swimmer(swimmer);
        s.update();
    }

    /**
     * disables the buttons
     * @param ifA 
     */
    private void bloquearBtn(boolean ifA) {
        btnAdd.setEnabled(ifA);
        btnRandom.setEnabled(ifA);
        btnStart.setEnabled(ifA);
        btnClean.setEnabled(ifA);
    }

    /**
     * starts the game and doesn't stop until the game over
     */
    private void go() {
        velocityRandom();
        posicion = 1;
        timer = new Timer();
        cronom();
        taskRun = new TimerTask() {
            @Override
            public void run() {
                LinkedList<Models.Swimmer> s = new LinkedList<>();
                String time = lblTime.getText();
                if ((lblJug1.getX() + lblJug1.getWidth()) >= (pPool.getX() + pPool.getWidth() - lblJug1.getWidth())) {
                    if (!lSwimming.get(0).isFinish()) {
                        lSwimming.get(0).setTime(time);
                        lSend.add(lSwimming.get(0));
                        lSwimming.get(0).setFinish(true);
                        s.add(lSwimming.get(0));
                    }
                }
                if ((lblJug2.getX() + lblJug2.getWidth()) >= (pPool.getX() + pPool.getWidth() - lblJug2.getWidth())) {
                    if (!lSwimming.get(1).isFinish()) {
                        lSwimming.get(1).setTime(time);
                        lSend.add(lSwimming.get(1));
                        lSwimming.get(1).setFinish(true);
                        s.add(lSwimming.get(1));
                    }
                }
                if ((lblJug3.getX() + lblJug3.getWidth()) >= (pPool.getX() + pPool.getWidth() - lblJug3.getWidth())) {
                    if (!lSwimming.get(2).isFinish()) {
                        lSwimming.get(2).setTime(time);
                        lSend.add(lSwimming.get(2));
                        lSwimming.get(2).setFinish(true);
                        s.add(lSwimming.get(2));
                    }
                }
                if ((lblJug4.getX() + lblJug4.getWidth()) >= (pPool.getX() + pPool.getWidth() - lblJug4.getWidth())) {
                    if (!lSwimming.get(3).isFinish()) {
                        lSwimming.get(3).setTime(time);
                        lSend.add(lSwimming.get(3));
                        lSwimming.get(3).setFinish(true);
                        s.add(lSwimming.get(3));
                    }
                }
                if ((lblJug5.getX() + lblJug5.getWidth()) >= (pPool.getX() + pPool.getWidth() - lblJug5.getWidth())) {
                    if (!lSwimming.get(4).isFinish()) {
                        lSwimming.get(4).setTime(time);
                        lSend.add(lSwimming.get(4));
                        lSwimming.get(4).setFinish(true);
                        s.add(lSwimming.get(4));
                    }
                }
                if (lblJug1.isVisible() && !lSwimming.get(0).isFinish()) {
                    if (lblJug1.getX() + lSwimming.get(0).getVelocity() + lblJug1.getWidth() > (pPool.getX() + pPool.getWidth())) {
                        lblJug1.move((pPool.getX() + pPool.getWidth()) - lblJug1.getWidth(), lblJug1.getY());
                    } else {
                        lblJug1.move(lblJug1.getX() + lSwimming.get(0).getVelocity(), lblJug1.getY());
                    }
                }
                if (lblJug2.isVisible() && !lSwimming.get(1).isFinish()) {
                    if (lblJug2.getX() + lSwimming.get(1).getVelocity() + lblJug2.getWidth() > (pPool.getX() + pPool.getWidth())) {
                        lblJug2.move((pPool.getX() + pPool.getWidth()) - lblJug2.getWidth(), lblJug2.getY());
                    } else {
                        lblJug2.move(lblJug2.getX() + lSwimming.get(1).getVelocity(), lblJug2.getY());
                    }
                }
                if (lblJug3.isVisible() && !lSwimming.get(2).isFinish()) {
                    if (lblJug3.getX() + lSwimming.get(2).getVelocity() + lblJug3.getWidth() > (pPool.getX() + pPool.getWidth())) {
                        lblJug3.move((pPool.getX() + pPool.getWidth()) - lblJug3.getWidth(), lblJug3.getY());
                    } else {
                        lblJug3.move(lblJug3.getX() + lSwimming.get(2).getVelocity(), lblJug3.getY());
                    }
                }
                if (lblJug4.isVisible() && !lSwimming.get(3).isFinish()) {
                    if (lblJug4.getX() + lSwimming.get(3).getVelocity() + lblJug4.getWidth() > (pPool.getX() + pPool.getWidth())) {
                        lblJug4.move((pPool.getX() + pPool.getWidth()) - lblJug4.getWidth(), lblJug4.getY());
                    } else {
                        lblJug4.move(lblJug1.getX() + lSwimming.get(3).getVelocity(), lblJug4.getY());
                    }
                }
                if (lblJug5.isVisible() && !lSwimming.get(4).isFinish()) {
                    if (lblJug5.getX() + lSwimming.get(4).getVelocity() + lblJug5.getWidth() > (pPool.getX() + pPool.getWidth())) {
                        lblJug5.move((pPool.getX() + pPool.getWidth()) - lblJug5.getWidth(), lblJug5.getY());
                    } else {
                        lblJug5.move(lblJug5.getX() + lSwimming.get(4).getVelocity(), lblJug5.getY());
                    }
                }
                boolean fin = true;
                for (int i = 0; i < lSwimming.size(); i++) {
                    if (!lSwimming.get(i).isFinish()) {
                        fin = false;
                    }
                }
                if (s.size() > 0) {
                    winner(s);
                }
                if (fin) {
                    cronom.cancel();
                    taskCronom.cancel();
                    timer.cancel();
                    taskRun.cancel();
                    empates();
                    statisticas.setRaces(statisticas.getRaces() + 1);
                    statisticas.setEmpates(statisticas.getEmpates() + empates);
                    updateStatistics();
                    bloquearBtn(true);
                }
            }
        };
        timer.schedule(taskRun, 100, 100);
    }

    /**
     * checks if there are draws in the game
     */
    private void empates() {
        LinkedList<Models.Swimmer> s = lSwimming;
        empates = 0;
        boolean hay = false;
        for (int i = 0; i < s.size(); i++) {
            for (int j = i + 1; j < s.size(); j++) {
                if (s.get(i).getTime().equals(s.get(j).getVelocity())) {
                    hay = true;
                    s.remove(j);
                }
            }
            if (hay) {
                empates++;
            }
        }
    }

    /**
     * updates the game statistics
     */
    private void updateStatistics() {

        loadSwimmers();
        statisticas.setSwimmer(lSwimmer);
        statis = new Statistics(statisticas);
        statis.update();
    }

    /**
     * cleans the game statistics
     */
    private void cleanStatistics() {
        statisticas = new Models.Statistics();
        statisticas.setSwimmer(lSwimmer);
        statis = new Statistics(statisticas);
        statis.clean();
        loadSwimmers();
        for (int i = 0; i < lSwimmer.size(); i++) {
            lSwimmer.get(i).setGanadas(0);
            lSwimmer.get(i).setPerdidas(0);
            lSwimmer.get(i).update();
        }
    }

    /**
     * reloads the game statistics
     */
    private void sta() {
        loadSwimmers();
        statisticas.setSwimmer(lSwimmer);
        statis = new Statistics(statisticas);
    }

    /**
     * shows the statistics report
     */
    private void report() {
        sta();
        JOptionPane.showMessageDialog(null, statis.report(), "Reporte", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * When there is a draw, it gets randomly the order
     * @param s 
     */
    private void winner(LinkedList<Models.Swimmer> s) {
        int aux = posicion;
        for (int i = s.size(); i >= 0; i--) {
            try {
                int random = (int) (Math.random() * (s.size() - 1) * 0);
                JButton b = null;
                if (aux == 1) {
                    s.get(random).setGanadas(s.get(random).getGanadas() + 1);
                } else {
                    s.get(random).setPerdidas(s.get(random).getPerdidas() + 1);
                }
                for (int j = 0; j < lSwimming.size(); j++) {
                    if (lSwimming.get(j).getCode().equals(s.get(random).getCode())) {
                        b = btn(j);
                        b.setText(String.valueOf(aux));
                        aux++;
                    }
                }
                update(s.get(random));
                s.remove(random);
            } catch (Exception e) {
            }
        }
        posicion = aux;
    }

    /**
     * searchs for a button with the number
     * @param num (number of the button)
     * @return the button
     */
    private JButton btn(int num) {
        switch (num) {
            case 0:
                return this.btnJug1Info;
            case 1:
                return this.btnJug2Info;
            case 2:
                return this.btnJug3Info;
            case 3:
                return this.btnJug4Info;
            case 4:
                return this.btnJug5Info;
        }
        return null;
    }

    /**
     * shows on the screen the time of the game
     */
    private void cronom() {
        cronom = new Timer();
        taskCronom = new TimerTask() {
            int mili = 0;
            int seg = 0;
            int min = 0;
            int hour = 0;

            @Override
            public void run() {
                mili++;
                if (mili == 999) {
                    seg++;
                    mili = 0;
                }
                if (seg == 59) {
                    min++;
                    seg = 0;
                }
                if (min == 59 && seg == 59 && mili == 999) {
                    hour++;
                    min = 0;
                    seg = 0;
                    mili = 0;
                }
                String time = hour + ":" + min + ":" + seg + ":" + mili;
                lblTime.setText("Time: " + time);
            }
        };
        cronom.schedule(taskCronom, 0, 1);
    }

    /**
     * it adds automatically swimmers to the race
     */
    private void chooseSwimmers() {
        int count = Integer.parseInt(spCount.getValue().toString());
        if (count <= lSwimmer.size()) {
            for (int i = 0; i < count; i++) {
                int random = (int) (Math.random() * (lSwimmer.size() - 1) + 0);
                lSwimming.add(lSwimmer.get(random));
                lSwimmer.remove(random);
                generateSwimmers(i);
            }
            loadSwimmers();
        } else {
            JOptionPane.showMessageDialog(null, "No hay tantos competidores!");
        }
    }

    /**
     * sets an image in the swimmer button
     * @param count (number of the button)
     */
    private void generateSwimmers(int count) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("swimming2.jpg"));
        } catch (IOException e) {
        }
        Image dimg = img.getScaledInstance(lblJug1.getWidth(), lblJug1.getHeight(),
        Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        for (int i = 0; i < lSwimming.size(); i++) {
            String texto = "";
            switch (i) {
                case 0:
                    texto = "Name: " + lSwimming.get(0).getName() + " "
                            + lSwimming.get(0).getLastName();
                    btnJug1Info.setToolTipText(texto);
                    lblJug1.setVisible(true);
                    lblJug1.setIcon(imageIcon);
                    btnJug1Info.setVisible(true);
                    break;
                case 1:
                    texto = "Name: " + lSwimming.get(1).getName() + " "
                            + lSwimming.get(1).getLastName();
                    btnJug2Info.setToolTipText(texto);
                    lblJug2.setVisible(true);
                    lblJug2.setIcon(imageIcon);
                    btnJug2Info.setVisible(true);
                    break;
                case 2:
                    texto = "Name: " + lSwimming.get(2).getName() + " "
                            + lSwimming.get(2).getLastName();
                    btnJug3Info.setToolTipText(texto);
                    lblJug3.setVisible(true);
                    lblJug3.setIcon(imageIcon);
                    btnJug3Info.setVisible(true);
                    break;
                case 3:
                    texto = "Name: " + lSwimming.get(3).getName() + " "
                            + lSwimming.get(3).getLastName();
                    btnJug4Info.setToolTipText(texto);
                    lblJug4.setVisible(true);
                    lblJug4.setIcon(imageIcon);
                    btnJug4Info.setVisible(true);
                    break;
                case 4:
                    texto = "Name: " + lSwimming.get(4).getName() + " "
                            + lSwimming.get(4).getLastName();
                    btnJug5Info.setToolTipText(texto);
                    lblJug5.setVisible(true);
                    lblJug5.setIcon(imageIcon);
                    btnJug5Info.setVisible(true);
                    break;
            }
        }
    }

    /**
     * it adds manually a swimmer to the race
     */
    private void addChoose() {
        int select = lChoose.getSelectedIndex();
        int count = Integer.parseInt(spCount.getValue().toString());
        if (select > -1 && (lSwimming.size() < count)) {
            lSwimming.add(lSwimmer.get(select));
            lSwimmer.remove(select);
            model.remove(select);
            generateSwimmers(lSwimming.size() - 1);
        }
    }

    /**
     * cleans the interface
     */
    private void clean() {
        loadSwimmers();
        hideBtn(false);
        posicion = 1;
        lSwimming = new LinkedList<>();
        lblTime.setText("Time");
        btnJug1Info.setText("...");
        btnJug2Info.setText("...");
        btnJug3Info.setText("...");
        btnJug4Info.setText("...");
        btnJug5Info.setText("...");
        btnJug1Info.setToolTipText("");
        btnJug2Info.setToolTipText("");
        btnJug3Info.setToolTipText("");
        btnJug4Info.setToolTipText("");
        btnJug5Info.setToolTipText("");
        lblJug1.move(10, lblJug1.getY());
        lblJug2.move(10, lblJug2.getY());
        lblJug3.move(10, lblJug3.getY());
        lblJug4.move(10, lblJug4.getY());
        lblJug5.move(10, lblJug5.getY());
    }

    /**
     * generates a random velocity
     */
    private void velocityRandom() {
        for (int i = lSwimming.size() - 1; i >= 0; i--) {
            int random = (int) (Math.random() * 5 + 1);
            lSwimming.get(i).setVelocity(random);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner2 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        btnSwimmers = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        btnJug5Info = new javax.swing.JButton();
        pPool = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        lblJug2 = new javax.swing.JLabel();
        lblJug1 = new javax.swing.JLabel();
        lblJug3 = new javax.swing.JLabel();
        lblJug4 = new javax.swing.JLabel();
        lblJug5 = new javax.swing.JLabel();
        btnJug1Info = new javax.swing.JButton();
        btnJug2Info = new javax.swing.JButton();
        btnJug3Info = new javax.swing.JButton();
        btnJug4Info = new javax.swing.JButton();
        btnPrepare = new javax.swing.JButton();
        pChoose = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lChoose = new javax.swing.JList<>();
        btnAdd = new javax.swing.JButton();
        btnRandom = new javax.swing.JButton();
        spCount = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        pSwimmers1 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lSwimmers = new javax.swing.JList<>();
        btnDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        lblFinal = new javax.swing.JLabel();
        btnCleanSta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel1.setText("Swimming Pool");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(310, 20, 220, 40);

        btnSwimmers.setBackground(new java.awt.Color(255, 102, 102));
        btnSwimmers.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnSwimmers.setText("Swimmers");
        btnSwimmers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwimmersActionPerformed(evt);
            }
        });
        getContentPane().add(btnSwimmers);
        btnSwimmers.setBounds(50, 340, 101, 29);

        lblTime.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("time");
        getContentPane().add(lblTime);
        lblTime.setBounds(640, 340, 150, 36);

        btnJug5Info.setText("...");
        btnJug5Info.setToolTipText("");
        getContentPane().add(btnJug5Info);
        btnJug5Info.setBounds(10, 290, 40, 30);

        pPool.setBackground(new java.awt.Color(1, 0, 128));
        pPool.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pPool.setToolTipText("");
        pPool.setLayout(null);
        pPool.add(jSeparator2);
        jSeparator2.setBounds(375, 5, 0, 2);

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        pPool.add(jSeparator3);
        jSeparator3.setBounds(10, 200, 710, 10);

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        pPool.add(jSeparator5);
        jSeparator5.setBounds(10, 50, 710, 10);

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        pPool.add(jSeparator6);
        jSeparator6.setBounds(10, 100, 710, 10);

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        pPool.add(jSeparator7);
        jSeparator7.setBounds(10, 150, 710, 10);

        lblJug2.setBackground(new java.awt.Color(0, 0, 153));
        lblJug2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pPool.add(lblJug2);
        lblJug2.setBounds(10, 60, 60, 30);

        lblJug1.setBackground(new java.awt.Color(0, 0, 153));
        lblJug1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pPool.add(lblJug1);
        lblJug1.setBounds(10, 10, 60, 30);

        lblJug3.setBackground(new java.awt.Color(0, 0, 153));
        lblJug3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pPool.add(lblJug3);
        lblJug3.setBounds(10, 110, 60, 30);

        lblJug4.setBackground(new java.awt.Color(0, 0, 153));
        lblJug4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pPool.add(lblJug4);
        lblJug4.setBounds(10, 160, 60, 30);

        lblJug5.setBackground(new java.awt.Color(0, 0, 153));
        lblJug5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pPool.add(lblJug5);
        lblJug5.setBounds(10, 210, 60, 30);

        getContentPane().add(pPool);
        pPool.setBounds(60, 80, 740, 250);

        btnJug1Info.setText("...");
        btnJug1Info.setToolTipText("");
        getContentPane().add(btnJug1Info);
        btnJug1Info.setBounds(10, 90, 40, 30);

        btnJug2Info.setText("...");
        btnJug2Info.setToolTipText("");
        getContentPane().add(btnJug2Info);
        btnJug2Info.setBounds(10, 140, 40, 30);

        btnJug3Info.setText("...");
        btnJug3Info.setToolTipText("");
        getContentPane().add(btnJug3Info);
        btnJug3Info.setBounds(10, 190, 40, 30);

        btnJug4Info.setText("...");
        btnJug4Info.setToolTipText("");
        getContentPane().add(btnJug4Info);
        btnJug4Info.setBounds(10, 240, 40, 30);

        btnPrepare.setBackground(new java.awt.Color(255, 102, 102));
        btnPrepare.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnPrepare.setText("Settings");
        btnPrepare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrepareActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrepare);
        btnPrepare.setBounds(190, 340, 89, 29);

        pChoose.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane2.setViewportView(lChoose);

        btnAdd.setBackground(new java.awt.Color(255, 102, 102));
        btnAdd.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRandom.setBackground(new java.awt.Color(255, 102, 102));
        btnRandom.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnRandom.setText("Random");
        btnRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRandomActionPerformed(evt);
            }
        });

        spCount.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        spCount.setModel(new javax.swing.SpinnerNumberModel(2, 2, 5, 1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel2.setText("Number of swimmers");

        javax.swing.GroupLayout pChooseLayout = new javax.swing.GroupLayout(pChoose);
        pChoose.setLayout(pChooseLayout);
        pChooseLayout.setHorizontalGroup(
            pChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pChooseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pChooseLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addComponent(btnRandom)))
                    .addGroup(pChooseLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spCount, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pChooseLayout.setVerticalGroup(
            pChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pChooseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spCount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pChooseLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRandom))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        getContentPane().add(pChoose);
        pChoose.setBounds(450, 400, 250, 180);

        pSwimmers1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel3.setText("Name");

        txtLastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel4.setText("Lasname");

        btnSave.setBackground(new java.awt.Color(255, 102, 102));
        btnSave.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lSwimmers);

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnDelete.setText("-");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 255, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(10, 5));

        javax.swing.GroupLayout pSwimmers1Layout = new javax.swing.GroupLayout(pSwimmers1);
        pSwimmers1.setLayout(pSwimmers1Layout);
        pSwimmers1Layout.setHorizontalGroup(
            pSwimmers1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSwimmers1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pSwimmers1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(txtLastName)
                    .addComponent(jLabel3)
                    .addComponent(txtName)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pSwimmers1Layout.setVerticalGroup(
            pSwimmers1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pSwimmers1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pSwimmers1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSwimmers1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addGroup(pSwimmers1Layout.createSequentialGroup()
                        .addGroup(pSwimmers1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pSwimmers1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(pSwimmers1);
        pSwimmers1.setBounds(120, 400, 320, 180);

        btnStart.setBackground(new java.awt.Color(255, 102, 102));
        btnStart.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnStart.setText("Start game");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        getContentPane().add(btnStart);
        btnStart.setBounds(320, 340, 107, 29);

        btnInfo.setBackground(new java.awt.Color(255, 102, 102));
        btnInfo.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnInfo.setText("Show Statistics");
        btnInfo.setToolTipText("");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });
        getContentPane().add(btnInfo);
        btnInfo.setBounds(640, 10, 160, 29);

        btnClean.setBackground(new java.awt.Color(255, 102, 102));
        btnClean.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnClean.setText("Clean");
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });
        getContentPane().add(btnClean);
        btnClean.setBounds(460, 340, 67, 29);

        lblFinal.setBackground(new java.awt.Color(153, 0, 0));
        getContentPane().add(lblFinal);
        lblFinal.setBounds(800, 100, 10, 220);

        btnCleanSta.setBackground(new java.awt.Color(255, 102, 102));
        btnCleanSta.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnCleanSta.setText("Clean Statistics");
        btnCleanSta.setToolTipText("");
        btnCleanSta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanStaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCleanSta);
        btnCleanSta.setBounds(640, 40, 160, 29);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        addSwimmer();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteSwimmer();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSwimmersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwimmersActionPerformed
        if (!open) {
            this.setSize(890, (420 + pSwimmers1.getHeight() + 14));
            this.move(this.getX(), this.getY() - pSwimmers1.getHeight() + 3);
            open = true;
        } else {
            this.setSize(890, 420);
            this.move(this.getX(), this.getY() + pSwimmers1.getHeight() - 3);
            open = false;
        }
    }//GEN-LAST:event_btnSwimmersActionPerformed

    private void btnPrepareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrepareActionPerformed
        if (!open) {
            this.setSize(890, (420 + pSwimmers1.getHeight() + 14));
            this.move(this.getX(), this.getY() - pSwimmers1.getHeight() + 3);
            open = true;
        } else {
            this.setSize(890, 420);
            this.move(this.getX(), this.getY() + pSwimmers1.getHeight() - 3);
            open = false;
        }
    }//GEN-LAST:event_btnPrepareActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if (lSwimming.size() > 0) {
            bloquearBtn(false);
            go();
        } else {
            JOptionPane.showMessageDialog(this, "Debes esgoger los competidores primero");
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandomActionPerformed
        chooseSwimmers();
    }//GEN-LAST:event_btnRandomActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addChoose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        clean();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        report();
    }//GEN-LAST:event_btnInfoActionPerformed

    private void btnCleanStaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanStaActionPerformed
        cleanStatistics();
    }//GEN-LAST:event_btnCleanStaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSwim.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSwim.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSwim.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSwim.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSwim().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnCleanSta;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnJug1Info;
    private javax.swing.JButton btnJug2Info;
    private javax.swing.JButton btnJug3Info;
    private javax.swing.JButton btnJug4Info;
    private javax.swing.JButton btnJug5Info;
    private javax.swing.JButton btnPrepare;
    private javax.swing.JButton btnRandom;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnSwimmers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JList<String> lChoose;
    private javax.swing.JList<String> lSwimmers;
    private javax.swing.JLabel lblFinal;
    private javax.swing.JLabel lblJug1;
    private javax.swing.JLabel lblJug2;
    private javax.swing.JLabel lblJug3;
    private javax.swing.JLabel lblJug4;
    private javax.swing.JLabel lblJug5;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel pChoose;
    private javax.swing.JPanel pPool;
    private javax.swing.JPanel pSwimmers1;
    private javax.swing.JSpinner spCount;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
