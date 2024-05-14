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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksidatabase.Koneksi;
import raven.table.TableGradientCell;

/**
 *
 * @author USER
 */
public class Pelanggan extends javax.swing.JFrame {

    /**
     * Creates new form DaftarItem
     */
    private static Connection con;

    public Pelanggan() {
        initComponents();
        tabelPelanggan.setDefaultRenderer(Object.class, new TableGradientCell());
        jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
        tabelPelanggan.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
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

    private void inisialisasiTabel() {
        DefaultTableModel tmodel = (DefaultTableModel) tabelPelanggan.getModel();
        tabelPelanggan.setAutoCreateRowSorter(true);
        try {
            String query = "SELECT * FROM pelanggan";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idPelanggan = resultSet.getInt("idPelanggan");
                String namaPelanggan = resultSet.getString("nama");
                String alamat = resultSet.getString("alamat");
                String kota = resultSet.getString("kota");
                String provinsi = resultSet.getString("provinsi");
                String nomorTelpon = resultSet.getString("nomortelpon");
                ArrayList myPelanggan = new ArrayList();
                myPelanggan.add(idPelanggan);
                myPelanggan.add(namaPelanggan);
                myPelanggan.add(alamat);
                myPelanggan.add(kota);
                myPelanggan.add(provinsi);
                myPelanggan.add(nomorTelpon);
                tmodel.addRow(myPelanggan.toArray());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println(ex + "gagal inisialisasi tabel suplier");
        }
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
        pencarianInputan = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inp3 = new javax.swing.JTextField();
        inp1 = new javax.swing.JTextField();
        inp2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        inp4 = new javax.swing.JTextField();
        inp6 = new javax.swing.JTextField();
        inp5 = new javax.swing.JTextField();
        butTambah = new button.MyButton();
        butDel = new button.MyButton();
        jPanel1 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tabelPelanggan = new javax.swing.JTable();
        myButton1 = new button.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setText("---------------------DATA PELANGGAN------------------");

        pencarianInputan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Masukan ID Pelanggan");
        pencarianInputan.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel6.setText("Nama Pelanggan");
        pencarianInputan.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel7.setText("Alamat");
        pencarianInputan.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 30));
        pencarianInputan.add(inp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 670, -1));
        pencarianInputan.add(inp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 200, -1));
        pencarianInputan.add(inp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 200, -1));

        jLabel8.setText("Kota");
        pencarianInputan.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        jLabel9.setText("Provinsi");
        pencarianInputan.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        jLabel10.setText("Nomor Telpon");
        pencarianInputan.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, -1, -1));
        pencarianInputan.add(inp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, 130, -1));
        pencarianInputan.add(inp6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 130, -1));
        pencarianInputan.add(inp5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 130, -1));

        butTambah.setBackground(new java.awt.Color(0, 0, 0));
        butTambah.setForeground(new java.awt.Color(255, 255, 255));
        butTambah.setText("Tambah");
        butTambah.setBorderColor(new java.awt.Color(255, 255, 255));
        butTambah.setColor(new java.awt.Color(0, 0, 0));
        butTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butTambahActionPerformed(evt);
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

        tabelPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idPelanggan", "nama", "alamat", "kota", "provinsi", "nomortelpon"
            }
        ));
        scroll.setViewportView(tabelPelanggan);

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
                .addGap(40, 40, 40)
                .addComponent(butTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(butDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(pencarianInputan, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jLabel1)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pencarianInputan, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(butTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(butDel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_myButton1ActionPerformed

    private void butTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butTambahActionPerformed
        if (inp1.getText().isEmpty() || inp2.getText().isEmpty() || inp3.getText().isEmpty() || inp6.getText().isEmpty()) {

        } else {
            int idPelanggan = Integer.parseInt(inp1.getText());
            String namaPelanggan = inp2.getText();
            String alamat = inp3.getText();
            String kota = inp4.getText();
            String provinsi = inp5.getText();
            String nomorTelpon = inp6.getText();
            if (cekIDPelanggan(idPelanggan)) {
                JOptionPane.showMessageDialog(null, "Tidak dapat menambahkan, ID Pelanggan sudah ada", "Notif", JOptionPane.INFORMATION_MESSAGE);
            } else {
                DefaultTableModel tmodel = (DefaultTableModel) tabelPelanggan.getModel();
                try {
                    String query = "INSERT INTO pelanggan (idPelanggan, nama, alamat, kota, provinsi, nomortelpon) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setInt(1, idPelanggan);
                    preparedStatement.setString(2, namaPelanggan);
                    preparedStatement.setString(3, alamat);
                    preparedStatement.setString(4, kota);
                    preparedStatement.setString(5, provinsi);
                    preparedStatement.setString(6, nomorTelpon);
                    int hasil = preparedStatement.executeUpdate();
                    if (hasil > 0) {
                        System.out.println("Data berhasil ditambahkan ke dalam tabel pelanggan");
                    } else {
                        System.out.println("Gagal menambahkan data ke dalam tabel pelanggan");
                    }
                    preparedStatement.close();
                } catch (SQLException ex) {
                    System.out.println(ex + "gagal inisialisasi tabel suplier");
                }
                tmodel.setRowCount(0);
                inisialisasiTabel();
            }
        }
    }//GEN-LAST:event_butTambahActionPerformed

    private void butDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDelActionPerformed
        int row = tabelPelanggan.getSelectedRow();
        int value = Integer.parseInt(tabelPelanggan.getModel().getValueAt(row, 0).toString());
        try {
            Statement statement = con.createStatement();
            String query = "DELETE FROM pelanggan WHERE idPelanggan = '" + value + "'";
            int hasil = statement.executeUpdate(query);
            if (hasil > 0) {
                System.out.println("Data berhasil didelete pada tabel pelanggan");
            } else {
                System.out.println("Gagal mendelete data pada tabel pelanggan");
            }
        } catch (SQLException ex) {
            System.out.println("Gagal delete baris yang dipilih pada tabel pelanggan");
        }
        DefaultTableModel tmodel = (DefaultTableModel) tabelPelanggan.getModel();
        tmodel.setRowCount(0);
        inisialisasiTabel();
    }//GEN-LAST:event_butDelActionPerformed

    private boolean cekIDPelanggan(int value) {
        try {
            Statement statement = con.createStatement();
            String query = "SELECT COUNT(*) FROM pelanggan WHERE idPelanggan = '" + value + "';";
            ResultSet hasil = statement.executeQuery(query);
            int count = 0;
            while (hasil.next()) {
                count = hasil.getInt(1);
            }
            statement.close();
            hasil.close();

            return count > 0;
        } catch (SQLException ex) {
            System.out.println("gagal cek id pelanggan");
        }
        return false;
    }

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
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.MyButton butDel;
    private button.MyButton butTambah;
    private javax.swing.JTextField inp1;
    private javax.swing.JTextField inp2;
    private javax.swing.JTextField inp3;
    private javax.swing.JTextField inp4;
    private javax.swing.JTextField inp5;
    private javax.swing.JTextField inp6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private button.MyButton myButton1;
    private javax.swing.JPanel pencarianInputan;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tabelPelanggan;
    // End of variables declaration//GEN-END:variables
}
