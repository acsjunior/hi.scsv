
package com.hi.scsv.forms;

import com.hi.scsv.models.enums.VegetableSize;
import com.hi.scsv.services.VegetableServices;
import com.hi.scsv.forms.tables.VegetableTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class VegetableForm extends javax.swing.JInternalFrame {
    
    private long idSelectedRow;
    
    public VegetableForm() {
        initComponents();
        idSelectedRow = 0;
        this.cbo_vgSize.setModel(new DefaultComboBoxModel(VegetableSize.values()));        
        loadTable();
   
    }
    
    private void loadTable() {
        TableModel model = new VegetableTableModel(new VegetableServices().getData(this.txt_vgSearch.getText()));
        this.tblVegetables.setModel(model);
    }
    
    private void loadFieldsToEdit() {
        int row = this.tblVegetables.getSelectedRow();

        idSelectedRow = (long)this.tblVegetables.getValueAt(row, 0);
        this.txt_vgName.setText(this.tblVegetables.getValueAt(row, 1).toString());
        this.txt_vgOrigin.setText(this.tblVegetables.getValueAt(row, 2).toString());
        this.cbo_vgSize.setSelectedItem(VegetableSize.valueOf(this.tblVegetables.getValueAt(row, 3).toString()));
        this.chk_vgFruitful.setSelected((boolean)this.tblVegetables.getValueAt(row, 4));
        
    }
    
    private void saveData() {
        JOptionPane.showMessageDialog(null, new VegetableServices().saveData(
                idSelectedRow, 
                this.txt_vgName.getText(), 
                this.txt_vgOrigin.getText(), 
                this.cbo_vgSize.getSelectedItem().toString(), 
                this.chk_vgFruitful.isSelected()));
    }
    
     private void deleteData(long id) {        
        String msg = new VegetableServices().removeData(id);
        refreshComponents();
        JOptionPane.showMessageDialog(null, msg);        
        
    }
    
    private void refreshComponents() {
        
         //TODO - verificar o motivo da falha no loop através dos componentes
        this.txt_vgName.setText(null);
        this.txt_vgOrigin.setText(null);
        this.chk_vgFruitful.setSelected(false);
        this.cbo_vgSize.setSelectedIndex(0);
        loadTable();
    }
          
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_vgName = new javax.swing.JTextField();
        lbl_vgName = new javax.swing.JLabel();
        txt_vgOrigin = new javax.swing.JTextField();
        lbl_vgOrigin = new javax.swing.JLabel();
        lbl_vgSize = new javax.swing.JLabel();
        cbo_vgSize = new javax.swing.JComboBox<>();
        btn_vgSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVegetables = new javax.swing.JTable();
        txt_vgSearch = new javax.swing.JTextField();
        lbl_vgSearch = new javax.swing.JLabel();
        btn_vgEdit = new javax.swing.JButton();
        btn_vgDelete = new javax.swing.JButton();
        chk_vgFruitful = new javax.swing.JCheckBox();

        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Vegetais");

        lbl_vgName.setText("Nome");

        lbl_vgOrigin.setText("Origem");

        lbl_vgSize.setText("Tamanho");

        cbo_vgSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_vgSave.setText("Salvar");
        btn_vgSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vgSaveActionPerformed(evt);
            }
        });

        tblVegetables.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblVegetables);

        txt_vgSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_vgSearchKeyReleased(evt);
            }
        });

        lbl_vgSearch.setText("Pesquisar");

        btn_vgEdit.setText("Editar");
        btn_vgEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vgEditActionPerformed(evt);
            }
        });

        btn_vgDelete.setText("Excluir");
        btn_vgDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vgDeleteActionPerformed(evt);
            }
        });

        chk_vgFruitful.setText("Frutífera");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_vgSave))
                    .addComponent(txt_vgOrigin, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(chk_vgFruitful)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cbo_vgSize, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_vgSize, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_vgName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_vgOrigin, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_vgName, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(246, 246, 246))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_vgDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_vgEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_vgSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_vgSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_vgName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_vgName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_vgOrigin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_vgOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_vgSize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_vgSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_vgFruitful))
                .addGap(26, 26, 26)
                .addComponent(btn_vgSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_vgSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btn_vgEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_vgDelete))))
                    .addComponent(lbl_vgSearch))
                .addGap(16, 16, 16))
        );

        setBounds(0, 0, 790, 565);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_vgSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vgSaveActionPerformed
        saveData();      
        refreshComponents();
    }//GEN-LAST:event_btn_vgSaveActionPerformed

    private void txt_vgSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vgSearchKeyReleased
        loadTable();
    }//GEN-LAST:event_txt_vgSearchKeyReleased

    private void btn_vgEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vgEditActionPerformed
        loadFieldsToEdit();        
    }//GEN-LAST:event_btn_vgEditActionPerformed

    private void btn_vgDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vgDeleteActionPerformed
        int row = this.tblVegetables.getSelectedRow();
        deleteData((long)this.tblVegetables.getValueAt(row, 0));
    }//GEN-LAST:event_btn_vgDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_vgDelete;
    private javax.swing.JButton btn_vgEdit;
    private javax.swing.JButton btn_vgSave;
    private javax.swing.JComboBox<String> cbo_vgSize;
    private javax.swing.JCheckBox chk_vgFruitful;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_vgName;
    private javax.swing.JLabel lbl_vgOrigin;
    private javax.swing.JLabel lbl_vgSearch;
    private javax.swing.JLabel lbl_vgSize;
    private javax.swing.JTable tblVegetables;
    private javax.swing.JTextField txt_vgName;
    private javax.swing.JTextField txt_vgOrigin;
    private javax.swing.JTextField txt_vgSearch;
    // End of variables declaration//GEN-END:variables
}
