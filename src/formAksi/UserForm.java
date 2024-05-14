/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formAksi;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksidatabase.Koneksi;
import raven.table.TableGradientCell;

/**
 *
 * @author USER
 */
public class UserForm extends javax.swing.JFrame {

    /**
     * Creates new form DaftarItem
     */
    private static Connection con;

    public UserForm() {
        initComponents();
        tabelUser.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tabelUser.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background");
        scroll.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,0,3,0,$Table.background,10,10");
        scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverTrackColor:null");
        con = Koneksi.createKoneksi();
        inisialisasiTabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        butEdit = new button.MyButton();
        butDel = new button.MyButton();
        jPanel1 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tabelUser = new javax.swing.JTable();
        myButton1 = new button.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setText("-----------------------------------------DATA USER-----------------------------------------");

        butEdit.setBackground(new java.awt.Color(0, 0, 0));
        butEdit.setForeground(new java.awt.Color(255, 255, 255));
        butEdit.setText("Edit Pass");
        butEdit.setBorderColor(new java.awt.Color(255, 255, 255));
        butEdit.setColor(new java.awt.Color(0, 0, 0));
        butEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEditActionPerformed(evt);
            }
        });

        butDel.setBackground(new java.awt.Color(0, 0, 0));
        butDel.setForeground(new java.awt.Color(255, 255, 255));
        butDel.setText("Delete");
        butDel.setBorderColor(new java.awt.Color(255, 255, 255));
        butDel.setColor(new java.awt.Color(0, 0, 0));
        butDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDelActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        tabelUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Pass", "NomorPegawai"
            }
        ));
        scroll.setViewportView(tabelUser);

        jPanel1.add(scroll, java.awt.BorderLayout.CENTER);

        myButton1.setForeground(new java.awt.Color(255, 255, 255));
        myButton1.setText("EXIT");
        myButton1.setColor(new java.awt.Color(0, 0, 0));
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(butEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(butDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(butDel, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addComponent(butEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inisialisasiTabel() {
        DefaultTableModel tmodel = (DefaultTableModel) tabelUser.getModel();
        tmodel.setRowCount(0);
        tabelUser.setAutoCreateRowSorter(true);
        try {
            Statement statement = con.createStatement();
            String query = "SELECT username, pass, nomor_pegawai FROM pengguna";
            ResultSet hasil = statement.executeQuery(query);
            while (hasil.next()) {
                String usernamePengguna = hasil.getString("username");
                String passwordPengguna = hasil.getString("pass");
                String nomorPegawai = hasil.getString("nomor_pegawai");
                ArrayList myUser = new ArrayList();
                myUser.add(usernamePengguna);
                myUser.add(passwordPengguna);
                myUser.add(nomorPegawai);
                tmodel.addRow(myUser.toArray());
            }
            statement.close();
            hasil.close();
        } catch (SQLException ex) {
            System.out.println(ex + "gagal inisialisasi tabel user");
        }
    }

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_myButton1ActionPerformed

    private void butEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEditActionPerformed
        int row = tabelUser.getSelectedRow();
        String value = tabelUser.getModel().getValueAt(row, 0).toString();
        String input = JOptionPane.showInputDialog("Masukan password baru");
        if (input != null) {
            try {
                Statement statement = con.createStatement();
                String query = "UPDATE pengguna SET pass = '"+input+"' WHERE username = '"+value+"'";
                int hasil = statement.executeUpdate(query);
                if(hasil>0){
                    JOptionPane.showConfirmDialog(null, "Update password berhasil");
                }
                statement.close();
            } catch (SQLException ex) {
                System.out.println(ex + "gagal inisialisasi tabel user");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "gagal merubah password");
        }
    }//GEN-LAST:event_butEditActionPerformed

    private void butDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDelActionPerformed
        int row = tabelUser.getSelectedRow();
        String value = tabelUser.getModel().getValueAt(row, 0).toString();
        try {
            Statement statement = con.createStatement();
            String getSql = "SELECT nomor_pegawai, detail_akses FROM pengguna WHERE username = '"+value+"';";
            ResultSet has = statement.executeQuery(getSql);
            String noAdm = null;
            int detailAk = 0;
            if(has.next()){
                noAdm = has.getString("nomor_pegawai");
                detailAk = has.getInt("detail_akses");
            }
            System.out.println(noAdm);
            String sql = "DELETE FROM `pengguna` WHERE username = '" + value + "';";
            String query1 = "DELETE FROM `detailuser` WHERE nomor_pegawai = '"+noAdm+"';";
            String query2 = "DELETE FROM akses WHERE id_akses = '"+detailAk+"';";
            int hasil = statement.executeUpdate(sql);
            if(hasil>0){
                System.out.println("berhasil delete di pengguna");
            }
            hasil = statement.executeUpdate(query1);
            if(hasil>0){
                System.out.println("berhasil delete di detailuser");
            }
            hasil = statement.executeUpdate(query2);
            if(hasil>0){
                System.out.println("berhasil delete di akses");
            }
            inisialisasiTabel();
            statement.close();
            has.close();
        } catch (SQLException ex) {
            System.out.println(ex + "gagal delete username");
        }
    }//GEN-LAST:event_butDelActionPerformed

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
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.MyButton butDel;
    private button.MyButton butEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private button.MyButton myButton1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tabelUser;
    // End of variables declaration//GEN-END:variables
}
