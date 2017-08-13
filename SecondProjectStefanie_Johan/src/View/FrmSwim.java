/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controllers.Swimmer;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Tefa-PC
 */
public class FrmSwim extends javax.swing.JFrame {
    
    private Timer timer;
    private LinkedList<Models.Swimmer> lSwimmer;
    private Timer cronom;
    private TimerTask taskCronom;
    private TimerTask taskRun;
    private DefaultListModel model;
    boolean open;
    private LinkedList<Models.Swimmer> lSend;
    private LinkedList<Models.Swimmer> lSwimming;
    private int posicion;

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
        lChoose.setModel(model);
        pPool.setSize(740, 250);
        open = false;
        posicion = 1;
        loadSwimmers();
        hideBtn(false);
    }
    
    private void loadSwimmers() {
        Controllers.Swimmer s = new Swimmer();
        lSwimmer = s.select();
        showSwimers();
    }
    
    private void showSwimers() {
        model.clear();
        for (int i = 0; i < lSwimmer.size(); i++) {
            model.addElement(lSwimmer.get(i).toString());
        }
    }
    
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
    
    private String getCode() {
        String code = "";
        for (int i = 0; i < 6; i++) {
            code += (int) (Math.random() * 9 + 1);
        }
        return code;
    }
    
    private void hideBtn(boolean ver){
        btnJug1.setVisible(ver);
        btnJug1Info.setVisible(ver);
        btnJug2.setVisible(ver);
        btnJug2Info.setVisible(ver);
        btnJug3.setVisible(ver);
        btnJug3Info.setVisible(ver);
        btnJug4.setVisible(ver);
        btnJug4Info.setVisible(ver);
        btnJug5.setVisible(ver);
        btnJug5Info.setVisible(ver);
    }
    
    private void update(int value){
        Controllers.Swimmer s = new Swimmer(lSwimming.get(value-1));
        s.update();
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
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        btnJug5 = new javax.swing.JButton();
        btnJug1 = new javax.swing.JButton();
        btnJug2 = new javax.swing.JButton();
        btnJug3 = new javax.swing.JButton();
        btnJug4 = new javax.swing.JButton();
        btnJug1Info = new javax.swing.JButton();
        btnJug2Info = new javax.swing.JButton();
        btnJug3Info = new javax.swing.JButton();
        btnJug4Info = new javax.swing.JButton();
        btnPrepare = new javax.swing.JButton();
        pChoose = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lChoose = new javax.swing.JList<>();
        btnAdd = new javax.swing.JButton();
        btnAdd1 = new javax.swing.JButton();
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
        pFinal = new javax.swing.JPanel();
        btnClean = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        pPool.setBackground(new java.awt.Color(102, 153, 255));
        pPool.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pPool.setLayout(null);
        pPool.add(jSeparator2);
        jSeparator2.setBounds(375, 5, 0, 2);
        pPool.add(jSeparator3);
        jSeparator3.setBounds(10, 200, 730, 10);
        pPool.add(jSeparator4);
        jSeparator4.setBounds(10, 50, 730, 10);
        pPool.add(jSeparator5);
        jSeparator5.setBounds(10, 50, 730, 10);
        pPool.add(jSeparator6);
        jSeparator6.setBounds(10, 100, 730, 10);
        pPool.add(jSeparator7);
        jSeparator7.setBounds(10, 150, 730, 10);

        btnJug5.setBackground(new java.awt.Color(255, 102, 102));
        btnJug5.setFont(new java.awt.Font("Comic Sans MS", 0, 8)); // NOI18N
        pPool.add(btnJug5);
        btnJug5.setBounds(10, 210, 70, 30);

        btnJug1.setBackground(new java.awt.Color(255, 102, 102));
        btnJug1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        pPool.add(btnJug1);
        btnJug1.setBounds(10, 10, 70, 30);

        btnJug2.setBackground(new java.awt.Color(255, 102, 102));
        btnJug2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        pPool.add(btnJug2);
        btnJug2.setBounds(10, 60, 70, 30);

        btnJug3.setBackground(new java.awt.Color(255, 102, 102));
        btnJug3.setFont(new java.awt.Font("Comic Sans MS", 0, 8)); // NOI18N
        pPool.add(btnJug3);
        btnJug3.setBounds(10, 110, 70, 30);

        btnJug4.setBackground(new java.awt.Color(255, 102, 102));
        btnJug4.setFont(new java.awt.Font("Comic Sans MS", 0, 8)); // NOI18N
        pPool.add(btnJug4);
        btnJug4.setBounds(10, 160, 70, 30);

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

        btnAdd1.setBackground(new java.awt.Color(255, 102, 102));
        btnAdd1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnAdd1.setText("Random");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
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
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnAdd1))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pChooseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(spCount, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        pChooseLayout.setVerticalGroup(
            pChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pChooseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spCount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pChooseLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(5, 5, 5)
                        .addComponent(btnAdd1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        getContentPane().add(pChoose);
        pChoose.setBounds(470, 390, 280, 180);

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
                .addGap(29, 29, 29)
                .addGroup(pSwimmers1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(txtName)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addContainerGap())
        );
        pSwimmers1Layout.setVerticalGroup(
            pSwimmers1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pSwimmers1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pSwimmers1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pSwimmers1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pSwimmers1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pSwimmers1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete))))
                .addContainerGap())
        );

        getContentPane().add(pSwimmers1);
        pSwimmers1.setBounds(50, 390, 370, 180);

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
        btnInfo.setText("Statistics");
        getContentPane().add(btnInfo);
        btnInfo.setBounds(700, 30, 99, 29);
        getContentPane().add(pFinal);
        pFinal.setBounds(800, 80, 10, 250);

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
        if (lSwimming.size()>0) {
            go();
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        chooseSwimmers();
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addChoose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
        clean();
    }//GEN-LAST:event_btnCleanActionPerformed

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
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnJug1;
    private javax.swing.JButton btnJug1Info;
    private javax.swing.JButton btnJug2;
    private javax.swing.JButton btnJug2Info;
    private javax.swing.JButton btnJug3;
    private javax.swing.JButton btnJug3Info;
    private javax.swing.JButton btnJug4;
    private javax.swing.JButton btnJug4Info;
    private javax.swing.JButton btnJug5;
    private javax.swing.JButton btnJug5Info;
    private javax.swing.JButton btnPrepare;
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
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JList<String> lChoose;
    private javax.swing.JList<String> lSwimmers;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel pChoose;
    private javax.swing.JPanel pFinal;
    private javax.swing.JPanel pPool;
    private javax.swing.JPanel pSwimmers1;
    private javax.swing.JSpinner spCount;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
