/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package hr.algebra.view;

import hr.algebra.dal.Repository;
import hr.algebra.dal.RepositoryFactory;
import hr.algebra.dnd.ActorTransferable;
import hr.algebra.model.Actor;
import hr.algebra.model.Movie;
import hr.algebra.model.MovieActorRelationship;
import hr.algebra.model.User;
import hr.algebra.tableModel.MovieActorTableModel;
import hr.algebra.tableModel.MovieTableModel;
import hr.algebra.utilities.IconUtils;
import hr.algebra.utilities.MessageUtils;
import java.awt.datatransfer.Transferable;
import java.util.Set;
import java.util.TreeSet;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;

/**
 *
 * @author wExzEk
 */
public class CRUDMovieActorRelationship extends javax.swing.JPanel {

    /**
     * Creates new form CRUDMovieActorRelationship
     */
    private Repository repository;

    private Movie selectedMovie;

    private MovieActorTableModel movieActorTableModel;

    private MovieActorRelationship selectedMovieActor;

    private DefaultListModel<Actor> actorModel;

    private final Set<Actor> actors = new TreeSet<>();

    public CRUDMovieActorRelationship(User user) {
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

        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMovieActors = new javax.swing.JTable();
        tfMovie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lsActors = new javax.swing.JList<>();
        lbIcon = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lsAvailableActors = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
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

        jLabel1.setText("Movie");

        tbMovieActors.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMovieActors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMovieActorsMouseClicked(evt);
            }
        });
        tbMovieActors.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbMovieActorsKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbMovieActors);

        jLabel4.setText("Actor");

        jScrollPane2.setViewportView(lsActors);

        jScrollPane3.setViewportView(lsAvailableActors);

        jLabel2.setText("All actors");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)))
                .addGap(28, 28, 28)
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2))
                .addGap(41, 41, 41)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        selectedMovie.getId();
        if (selectedMovie != null) {
            int movieId = selectedMovie.getId();
            try {
                repository.deleteActorFromMovie(movieId);
                MessageUtils.showInformationMessage("Delete Successful", "Actors deleted from the movie successfully.");
                showActors(movieId);
                showAllActors();
            } catch (Exception ex) {
                Logger.getLogger(CRUDMovieActorRelationship.class.getName()).log(Level.SEVERE, null, ex);
                MessageUtils.showErrorMessage("Delete Error", "Error occurred while deleting the actor from the movie.");
            }
        } else {
            MessageUtils.showInformationMessage("Selection Required", "Please select a movie actor relationship to delete.");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tbMovieActorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMovieActorsMouseClicked
        selectMovieActor();
    }//GEN-LAST:event_tbMovieActorsMouseClicked

    private void tbMovieActorsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbMovieActorsKeyPressed
        selectMovieActor();
    }//GEN-LAST:event_tbMovieActorsKeyPressed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        init();
    }//GEN-LAST:event_formComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JList<Actor> lsActors;
    private javax.swing.JList<Actor> lsAvailableActors;
    private javax.swing.JTable tbMovieActors;
    private javax.swing.JTextField tfMovie;
    // End of variables declaration//GEN-END:variables

    private void selectMovieActor() {
        clearForm();
        int selectedRow = tbMovieActors.getSelectedRow();
        int rowIndex = tbMovieActors.convertRowIndexToModel(selectedRow);

        int movieId = (int) movieActorTableModel.getValueAt(rowIndex, 0);

        try {
            Optional<Movie> optMovie = repository.selectMovie(movieId);
            if (optMovie.isPresent()) {
                fillForm(optMovie.get());
            }
        } catch (Exception ex) {
            Logger.getLogger(CRUDMovies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearForm() {
        selectedMovieActor = null;
        selectedMovie = null;
    }

    private void init() {
        try {
            initRepository();
            initTable();
            initDragNDrop();
        } catch (Exception ex) {
            Logger.getLogger(CRUDMovies.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Unrecoverable error", "Cannot initiate the form");
            System.exit(1);
        }
    }

    private void initRepository() {
        repository = RepositoryFactory.getRepository();
    }

    private void initTable() {
        tbMovieActors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tbMovieActors.setAutoCreateRowSorter(true);
        tbMovieActors.setRowHeight(25);

        try {
            movieActorTableModel = new MovieActorTableModel(repository.selectMovies());
        } catch (Exception ex) {
            Logger.getLogger(CRUDMovieActorRelationship.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbMovieActors.setModel(movieActorTableModel);
    }

    private void showActors(int movieId) {
        try {
            actorModel = new DefaultListModel<>();
            List<Actor> actors = repository.getActorsForMovie(movieId);
            for (Actor actor : actors) {
                actorModel.addElement(actor);
            }
            lsActors.setModel(actorModel);
        } catch (Exception ex) {
            Logger.getLogger(CRUDMovieActorRelationship.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillForm(Movie movie) {
        selectedMovie = movie;
        tfMovie.setText(movie.getTitle());
        if (movie.getPicturePath() != null && Files.exists(Paths.get(movie.getPicturePath()))) {
            setIcon(lbIcon, new File(movie.getPicturePath()));
        }
        showActors(movie.getId());
        showAllActors();
    }

    private void setIcon(JLabel label, File file) {
        try {
            label.setIcon(IconUtils.createIcon(file, label.getWidth(), label.getHeight()));
        } catch (IOException ex) {
            Logger.getLogger(CRUDMovies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showAllActors() {
        try {
            actorModel = new DefaultListModel<>();
            List<Actor> allActors = repository.selectActors();

            allActors.stream()
                    .filter(actor -> !actors.contains(actor))
                    .forEach(actorModel::addElement);

            lsAvailableActors.setModel(actorModel);
        } catch (Exception ex) {
            Logger.getLogger(CRUDMovieActorRelationship.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initDragNDrop() {
        lsAvailableActors.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsAvailableActors.setDragEnabled(true);
        lsAvailableActors.setTransferHandler(new ExportHandler());

        lsActors.setDropMode(DropMode.ON);
        lsActors.setTransferHandler(new ImportHandler());
    }

    private class ExportHandler extends TransferHandler {

        @Override
        public int getSourceActions(JComponent c) {
            return COPY;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            return new ActorTransferable(lsAvailableActors.getSelectedValue());
        }
    }

    private class ImportHandler extends TransferHandler {

        @Override
        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(ActorTransferable.ACTOR_FLAVOR);
        }

        @Override
        public boolean importData(TransferSupport support) {
            Transferable transferable = support.getTransferable();

            try {
                Actor actor = (Actor) transferable.getTransferData(ActorTransferable.ACTOR_FLAVOR);

                if (isActorInList(actor, lsActors.getModel())) {
                    MessageUtils.showErrorMessage("Duplicate Actor", "Actor with the same name already exists in the list.");
                    return false;
                }

                if (actors.add(actor)) {
                    loadActorsModel();
                    updateDatabase();
                    actors.clear();
                    return true;
                }
            } catch (Exception ex) {
                Logger.getLogger(CRUDMovieActorRelationship.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }

        private void loadActorsModel() {
            try {
                actorModel = new DefaultListModel<>();
                List<Actor> allActors = repository.selectActors();

                allActors.stream()
                        .filter(actor -> !actors.contains(actor))
                        .forEach(actorModel::addElement);

                lsActors.setModel(actorModel);
                lsAvailableActors.setModel(actorModel);
            } catch (Exception ex) {
                Logger.getLogger(CRUDMovieActorRelationship.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void updateDatabase() {
            try {
                int movieId = selectedMovie.getId();

                for (Actor actor : actors) {
                    int actorId = actor.getId();
                    repository.insertActorToMovie(movieId, actorId);
                }

                showActors(movieId);

            } catch (Exception ex) {
                Logger.getLogger(CRUDMovieActorRelationship.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private boolean isActorInList(Actor actor, ListModel<Actor> model) {
            for (int i = 0; i < model.getSize(); i++) {
                Actor existingActor = model.getElementAt(i);
                if (existingActor.getFullName().equals(actor.getFullName())) {
                    return true;
                }
            }
            return false;
        }
    }
}