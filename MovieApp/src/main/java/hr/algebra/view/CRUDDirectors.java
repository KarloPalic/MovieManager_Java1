/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hr.algebra.view;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.model.Director;
import hr.algebra.model.User;
import hr.algebra.tableModel.DirectorTableModel;
import hr.algebra.utilities.MessageUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author wExzEk
 */
public class CRUDDirectors extends javax.swing.JPanel {

    /**
     * Creates new form CRUDDirectors
     */
    private List<JTextComponent> validationFields;
    private List<JLabel> errorLabels;

    private Repository repository;

    private DirectorTableModel directorTableModel;

    private Director selectedDirector;

    public CRUDDirectors(User user) {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUpdate = new javax.swing.JButton();
        btnAdd1 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDirectors = new javax.swing.JTable();
        tfDirectorName = new javax.swing.JTextField();
        lbNameError = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd1.setText("Add");
        btnAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd1ActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 0, 102));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        tbDirectors.setModel(new javax.swing.table.DefaultTableModel(
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
        tbDirectors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDirectorsMouseClicked(evt);
            }
        });
        tbDirectors.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbDirectorsKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbDirectors);

        lbNameError.setForeground(new java.awt.Color(204, 0, 51));
        lbNameError.setText("X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfDirectorName, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDirectorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNameError, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnAdd1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (selectedDirector == null) {
                MessageUtils.showInformationMessage("Info", "Select");
                return;
            }
            if (!formValid()) {
                return;
            }
            selectedDirector.setFullName(tfDirectorName.getText().trim());

            repository.updateDirector(selectedDirector.getId(), selectedDirector);
            directorTableModel.setDirectors(repository.selectDirectors());

            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(ManageUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        if (!formValid()) {
            return;
        }
        try {
            Director director = new Director(
                    tfDirectorName.getText().trim()
            );
            repository.createDirector(director);
            directorTableModel.setDirectors(repository.selectDirectors());

            clearForm();
        } catch (Exception ex) {
            Logger.getLogger(CRUDMovies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (selectedDirector == null) {
            MessageUtils.showInformationMessage("Info", "Select");
            return;
        }

        if (MessageUtils.showConfirmDialog("Delete", "Really delete?")) {
            try {

                repository.deleteDirector(selectedDirector.getId());
                directorTableModel.setDirectors(repository.selectDirectors());
                clearForm();
            } catch (Exception ex) {
                Logger.getLogger(CRUDMovies.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbDirectorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDirectorsMouseClicked
        selectDirector();
    }//GEN-LAST:event_tbDirectorsMouseClicked

    private void tbDirectorsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbDirectorsKeyPressed
        selectDirector();
    }//GEN-LAST:event_tbDirectorsKeyPressed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNameError;
    private javax.swing.JTable tbDirectors;
    private javax.swing.JTextField tfDirectorName;
    // End of variables declaration//GEN-END:variables

    private boolean formValid() {
        hideErrors();
        boolean ok = true;

        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().trim().isEmpty();
            errorLabels.get(i).setVisible(validationFields.get(i).getText().trim().isEmpty());
        }
        return ok;
    }

    private void clearForm() {
        hideErrors();
        tfDirectorName.setText("");
        selectedDirector = null;
    }

    private void selectDirector() {
        clearForm();
        int selectedRow = tbDirectors.getSelectedRow();
        int rowIndex = tbDirectors.convertRowIndexToModel(selectedRow);

        int id = (int) directorTableModel.getValueAt(rowIndex, 0);

        try {
            Optional<Director> optDirector = repository.selectDirector(id);
            if (optDirector.isPresent()) {
                fillForm(optDirector.get());
            }
        } catch (Exception ex) {
            Logger.getLogger(CRUDMovies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void init() {
        try {
            initValidation();
            hideErrors();
            initRepository();
            initTable();
        } catch (Exception ex) {
            Logger.getLogger(CRUDMovies.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void fillForm(Director director) {
        selectedDirector = director;
        tfDirectorName.setText(director.getFullName());
    }

    private void hideErrors() {
        errorLabels.forEach(e -> e.setVisible(false));
    }

    private void initValidation() {
        validationFields = Arrays.asList(
                tfDirectorName
        );
        errorLabels = Arrays.asList(
                lbNameError
        );
    }

    private void initRepository() {
        repository = RepositoryFactory.getRepository();
    }

    private void initTable() {
        try {
            tbDirectors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tbDirectors.setAutoCreateRowSorter(true);
            tbDirectors.setRowHeight(25);

            directorTableModel = new DirectorTableModel(repository.selectDirectors());
            tbDirectors.setModel(directorTableModel);
        } catch (Exception ex) {
            Logger.getLogger(ManageUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
