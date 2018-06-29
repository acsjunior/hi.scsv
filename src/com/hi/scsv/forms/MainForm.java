
package com.hi.scsv.forms;

import com.hi.scsv.dao.ExportDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainForm extends javax.swing.JFrame {

    private final AnimalForm animalForm;
    private final VegetableForm vegetableForm;
    
    public MainForm() {
        initComponents();
        animalForm = new AnimalForm();
        animalForm.setVisible(false);
        this.main_pane.add(animalForm);
        vegetableForm = new VegetableForm();
        vegetableForm.setVisible(false);
        this.main_pane.add(vegetableForm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_pane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnu_Cad = new javax.swing.JMenu();
        mnu_Cad_Animais = new javax.swing.JMenuItem();
        mnu_Cad_Vegetais = new javax.swing.JMenuItem();
        mnu_Exp = new javax.swing.JMenu();
        mnu_Exp_Comp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCSV - Sistema para Cadastro de Seres Vivos");
        setResizable(false);

        mnu_Cad.setText("Cadastro");

        mnu_Cad_Animais.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        mnu_Cad_Animais.setText("Animais");
        mnu_Cad_Animais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_Cad_AnimaisActionPerformed(evt);
            }
        });
        mnu_Cad.add(mnu_Cad_Animais);

        mnu_Cad_Vegetais.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        mnu_Cad_Vegetais.setText("Vegetais");
        mnu_Cad_Vegetais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_Cad_VegetaisActionPerformed(evt);
            }
        });
        mnu_Cad.add(mnu_Cad_Vegetais);

        jMenuBar1.add(mnu_Cad);

        mnu_Exp.setText("Exportação");

        mnu_Exp_Comp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        mnu_Exp_Comp.setText("Completa (txt)");
        mnu_Exp_Comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnu_Exp_CompActionPerformed(evt);
            }
        });
        mnu_Exp.add(mnu_Exp_Comp);

        jMenuBar1.add(mnu_Exp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main_pane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main_pane)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(800, 622));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnu_Cad_AnimaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_Cad_AnimaisActionPerformed
        vegetableForm.setVisible(false);
        animalForm.setVisible(true);
    }//GEN-LAST:event_mnu_Cad_AnimaisActionPerformed

    private void mnu_Cad_VegetaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_Cad_VegetaisActionPerformed
        animalForm.setVisible(false);
        vegetableForm.setVisible(true);
    }//GEN-LAST:event_mnu_Cad_VegetaisActionPerformed

    private void mnu_Exp_CompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnu_Exp_CompActionPerformed
        try {
            new ExportDAO().exportTxt();
        } catch (IOException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnu_Exp_CompActionPerformed


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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JDesktopPane main_pane;
    private javax.swing.JMenu mnu_Cad;
    private javax.swing.JMenuItem mnu_Cad_Animais;
    private javax.swing.JMenuItem mnu_Cad_Vegetais;
    private javax.swing.JMenu mnu_Exp;
    private javax.swing.JMenuItem mnu_Exp_Comp;
    // End of variables declaration//GEN-END:variables
}
