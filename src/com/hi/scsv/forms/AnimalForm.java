
package com.hi.scsv.forms;

import com.hi.scsv.models.enums.AnimalClass;
import com.hi.scsv.services.AnimalServices;
import com.hi.scsv.forms.tables.AnimalTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class AnimalForm extends javax.swing.JInternalFrame {
    
    private long idSelectedRow;
    
    public AnimalForm() {
        initComponents();
        idSelectedRow = 0;
        this.cbo_anClass.setModel(new DefaultComboBoxModel(AnimalClass.values()));        
        loadTable();
   
    }
    
    private void loadTable() {
        TableModel model = new AnimalTableModel(new AnimalServices().getData(this.txt_anSearch.getText()));
        this.tblAnimals.setModel(model);
    }
    
    private void loadFieldsToEdit() {
        int row = this.tblAnimals.getSelectedRow();

        idSelectedRow = (long)this.tblAnimals.getValueAt(row, 0);
        this.txt_anName.setText(this.tblAnimals.getValueAt(row, 1).toString());
        this.txt_anOrigin.setText(this.tblAnimals.getValueAt(row, 2).toString());
        this.txt_anPaws.setText(this.tblAnimals.getValueAt(row, 3).toString());
        this.cbo_anClass.setSelectedItem(AnimalClass.valueOf(this.tblAnimals.getValueAt(row, 4).toString()));
    }
    
    private void saveData() {
        JOptionPane.showMessageDialog(null, new AnimalServices().saveData(
                idSelectedRow,
                this.txt_anName.getText(), 
                this.txt_anOrigin.getText(), 
                this.txt_anPaws.getText(),
                this.cbo_anClass.getSelectedItem().toString()));
        idSelectedRow = 0;        
    }
    
    private void deleteData(long id) {        
        String msg = new AnimalServices().removeData(id);
        refreshComponents();
        JOptionPane.showMessageDialog(null, msg);        
        
    }
    
    private void refreshComponents() {
        
        //TODO - verificar o motivo da falha no loop através dos componentes
        txt_anName.setText(null);
        txt_anOrigin.setText(null);
        txt_anPaws.setText(null);
        cbo_anClass.setSelectedIndex(0);
        loadTable();
    }
          
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_anName = new javax.swing.JTextField();
        lbl_anName = new javax.swing.JLabel();
        txt_anOrigin = new javax.swing.JTextField();
        lbl_anOrigin = new javax.swing.JLabel();
        txt_anPaws = new javax.swing.JTextField();
        lbl_anPaws = new javax.swing.JLabel();
        lbl_anClass = new javax.swing.JLabel();
        cbo_anClass = new javax.swing.JComboBox<>();
        btn_anSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnimals = new javax.swing.JTable();
        txt_anSearch = new javax.swing.JTextField();
        lbl_anSearch = new javax.swing.JLabel();
        btn_anEdit = new javax.swing.JButton();
        btn_anDelete = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Animais");

        lbl_anName.setText("Nome");

        lbl_anOrigin.setText("Origem");

        lbl_anPaws.setText("Qtd. de patas");

        lbl_anClass.setText("Classe");

        cbo_anClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_anSave.setText("Salvar");
        btn_anSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anSaveActionPerformed(evt);
            }
        });

        tblAnimals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblAnimals);

        txt_anSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_anSearchKeyReleased(evt);
            }
        });

        lbl_anSearch.setText("Pesquisar");

        btn_anEdit.setText("Editar");
        btn_anEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anEditActionPerformed(evt);
            }
        });

        btn_anDelete.setText("Excluir");
        btn_anDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_anSave))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_anOrigin)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_anPaws, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_anPaws, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(cbo_anClass, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_anClass, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(txt_anName)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_anName)
                                    .addComponent(lbl_anOrigin))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(246, 246, 246))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_anDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_anEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_anSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_anSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_anName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_anName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_anOrigin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_anOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_anPaws)
                    .addComponent(lbl_anClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_anPaws, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_anClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btn_anSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_anSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btn_anEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_anDelete))))
                    .addComponent(lbl_anSearch))
                .addGap(16, 16, 16))
        );

        setBounds(0, 0, 790, 565);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_anSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anSaveActionPerformed
        saveData();      
        refreshComponents();
    }//GEN-LAST:event_btn_anSaveActionPerformed

    private void txt_anSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anSearchKeyReleased
        loadTable();
    }//GEN-LAST:event_txt_anSearchKeyReleased

    private void btn_anEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anEditActionPerformed
        loadFieldsToEdit();        
    }//GEN-LAST:event_btn_anEditActionPerformed

    private void btn_anDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anDeleteActionPerformed
        int row = this.tblAnimals.getSelectedRow();
        deleteData((long)this.tblAnimals.getValueAt(row, 0));
    }//GEN-LAST:event_btn_anDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anDelete;
    private javax.swing.JButton btn_anEdit;
    private javax.swing.JButton btn_anSave;
    private javax.swing.JComboBox<String> cbo_anClass;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_anClass;
    private javax.swing.JLabel lbl_anName;
    private javax.swing.JLabel lbl_anOrigin;
    private javax.swing.JLabel lbl_anPaws;
    private javax.swing.JLabel lbl_anSearch;
    private javax.swing.JTable tblAnimals;
    private javax.swing.JTextField txt_anName;
    private javax.swing.JTextField txt_anOrigin;
    private javax.swing.JTextField txt_anPaws;
    private javax.swing.JTextField txt_anSearch;
    // End of variables declaration//GEN-END:variables
}
