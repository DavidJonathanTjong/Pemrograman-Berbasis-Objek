/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framemenuutama;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.raven.main.Main;
import com.raven.model.ModelUser;
import formAksi.DaftarItem;
import formAksi.Laporan;
import formAksi.Pelanggan;
import formAksi.Supplier;
import formAksi.UserForm;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import koneksidatabase.Koneksi;

/**
 *
 * @author USER
 */
public class DashboardUtama extends javax.swing.JFrame {

    /**
     * Creates new form DashboardUtama
     */
    private ModelUser user;
    private static Connection con;

    public void setModelUser(ModelUser user) {
        this.user = user;
        inisialisasiUser();
        inisialisasiAkses();
    }

    public DashboardUtama() {
        initComponents();
        con = Koneksi.createKoneksi();
        FlatLaf.registerCustomDefaultsSource("formAksi");
        FlatMacDarkLaf.setup();
    }

    private void inisialisasiUser() {
        try {
            Statement statement = con.createStatement();
            String query = "SELECT du.nomor_pegawai, du.nama, du.posisibekerja \n"
                    + "FROM pengguna AS p JOIN detailuser AS du ON p.nomor_pegawai = du.nomor_pegawai \n"
                    + "WHERE p.username = '" + user.getUserName() + "';";
            ResultSet hasil = statement.executeQuery(query);
            while (hasil.next()) {
                String nomorPegawai = hasil.getString("nomor_pegawai");
                String nama = hasil.getString("nama");
                String posisiBekerja = hasil.getString("posisibekerja");
                workerNomor.setText(nomorPegawai);
                workerNama.setText(nama);
                workerJabatan.setText(posisiBekerja);
            }
            statement.close();
            hasil.close();
        } catch (SQLException ex) {
            System.out.println(ex + "gagal inisialisasi identitas user di dashboard utama");
        }
    }

    private void inisialisasiAkses() {
        try {
            Statement statement = con.createStatement();
            String query = "SELECT a.* FROM pengguna AS p JOIN akses AS a ON p.detail_akses = a.id_akses \n"
                    + "WHERE p.username = '" + user.getUserName() + "';";
            ResultSet hasil = statement.executeQuery(query);
            while (hasil.next()) {
                int panelPengguna = hasil.getInt("panelpengguna");
                if (panelPengguna != 1) {
                    butUser.setEnabled(false);
                }
                int daftarItem = hasil.getInt("daftaritem");
                if (daftarItem != 1) {
                    butDafItem.setEnabled(false);
                }
                int suplier = hasil.getInt("suplier");
                if (suplier != 1) {
                    butSupplier.setEnabled(false);
                }
                int pelanggan = hasil.getInt("pelanggan");
                if (pelanggan != 1) {
                    butPelanggan.setEnabled(false);
                }
                int sales = hasil.getInt("sales");
                if (sales != 1) {
                    butSales.setEnabled(false);
                }
                int settingKas = hasil.getInt("settingkas");
                if (settingKas != 1) {
//                    butDafItem.setEnabled(false);
                }
                int panelPembelian = hasil.getInt("panelpembelian");
                if (panelPembelian != 1) {
                    butBuyPesan.setEnabled(false);
                    butBuyDeal.setEnabled(false);
                }
                int panelPenjualan = hasil.getInt("panelpenjualan");
                if (panelPenjualan != 1) {
                    butSel.setEnabled(false);
                    butSellDeal.setEnabled(false);
                }
                int panelLaporan = hasil.getInt("panellaporan");
                if (panelLaporan != 1) {
                    butLaporan.setEnabled(false);
                }
                int panelPemeliharaanData = hasil.getInt("panelpemeliharaandata");
                if (panelPemeliharaanData != 1) {
//                    butDafItem.setEnabled(false);
                }
            }
            statement.close();
            hasil.close();
        } catch (SQLException ex) {
            System.out.println(ex + "gagal inisialisasi tabel user");
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

        panelMenuUtama = new javax.swing.JPanel();
        logOut = new button.MyButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        butDash = new button.MyButton();
        butBuyPesan = new button.MyButton();
        butSel = new button.MyButton();
        butBuyDeal = new button.MyButton();
        butSellDeal = new button.MyButton();
        myButton1 = new button.MyButton();
        panelIsi = new javax.swing.JPanel();
        panelKeteranganUser = new keeptoo.KGradientPanel();
        isiKeteranganUser = new javax.swing.JPanel();
        workerNama = new javax.swing.JLabel();
        workerNomor = new javax.swing.JLabel();
        workerJabatan = new javax.swing.JLabel();
        panelMenuMenu = new javax.swing.JPanel();
        dashboard = new keeptoo.KGradientPanel();
        butUser = new button.MyButton();
        butSales = new button.MyButton();
        butDafItem = new button.MyButton();
        butPelanggan = new button.MyButton();
        butLaporan = new button.MyButton();
        butSupplier = new button.MyButton();
        pembelian = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPesananBeli = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        butTambahPesan = new button.MyButton();
        butHapusPesan = new button.MyButton();
        listSuplier = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        nameSuplier = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        itemPesan = new javax.swing.JComboBox<>();
        jumlahBar = new javax.swing.JTextField();
        tglPesan = new com.toedter.calendar.JDateChooser();
        noPesan = new javax.swing.JTextField();
        penjualan = new keeptoo.KGradientPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPesananPenjualan = new javax.swing.JTable();
        namaBuyer = new javax.swing.JTextField();
        noPesanJual = new javax.swing.JTextField();
        tglPesananJual = new com.toedter.calendar.JDateChooser();
        pelangganJual = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        kodeItemJual = new javax.swing.JTextField();
        jumPesanJual = new javax.swing.JTextField();
        butTambahPesananJual = new button.MyButton();
        butHapusPesananJual = new button.MyButton();
        trBeli = new keeptoo.KGradientPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelTransaksiBeli = new javax.swing.JTable();
        butKonfirmTransaksiBeli = new button.MyButton();
        jLabel21 = new javax.swing.JLabel();
        nomorTransaksiBeli = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        inputanIDP = new javax.swing.JTextField();
        aksiPencarianTRbeli = new button.MyButton();
        delAdminTrBeli = new button.MyButton();
        jLabel27 = new javax.swing.JLabel();
        trJual = new keeptoo.KGradientPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelHistoriPesanan = new javax.swing.JTable();
        noPesananJual = new javax.swing.JComboBox<>();
        noTransaksiJual = new javax.swing.JTextField();
        butConfirmTRJual = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        totHargaJual = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        delOnlyAdmin = new button.MyButton();
        updateItemTR = new button.MyButton();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelMenuUtama.setBackground(new java.awt.Color(255, 255, 255));

        logOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framemenuutama/icons8-log-out-50.png"))); // NOI18N
        logOut.setText("LOG OUT");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framemenuutama/icons8-shop-96.png"))); // NOI18N
        jLabel1.setText("My Shop");

        jLabel2.setFont(new java.awt.Font("Segoe UI Variable", 0, 18)); // NOI18N
        jLabel2.setText("Pilihan Menu");

        butDash.setText("Dashboard");
        butDash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDashActionPerformed(evt);
            }
        });

        butBuyPesan.setText("Pesanan Pembelian");
        butBuyPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBuyPesanActionPerformed(evt);
            }
        });

        butSel.setText("Pesanan Penjualan");
        butSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSelActionPerformed(evt);
            }
        });

        butBuyDeal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framemenuutama/icons8-sales-30.png"))); // NOI18N
        butBuyDeal.setText("Transaksi Beli");
        butBuyDeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBuyDealActionPerformed(evt);
            }
        });

        butSellDeal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framemenuutama/icons8-sales-64.png"))); // NOI18N
        butSellDeal.setText("T Jual");
        butSellDeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSellDealActionPerformed(evt);
            }
        });

        myButton1.setText("EXIT");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuUtamaLayout = new javax.swing.GroupLayout(panelMenuUtama);
        panelMenuUtama.setLayout(panelMenuUtamaLayout);
        panelMenuUtamaLayout.setHorizontalGroup(
            panelMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuUtamaLayout.createSequentialGroup()
                .addGroup(panelMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuUtamaLayout.createSequentialGroup()
                        .addGroup(panelMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMenuUtamaLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2))
                            .addGroup(panelMenuUtamaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelMenuUtamaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(butDash, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butBuyPesan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butSel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butBuyDeal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butSellDeal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(panelMenuUtamaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuUtamaLayout.setVerticalGroup(
            panelMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuUtamaLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(butDash, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(butBuyPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(butBuyDeal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(butSel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(butSellDeal, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(myButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelMenuUtama, java.awt.BorderLayout.LINE_START);

        panelIsi.setLayout(new java.awt.BorderLayout());

        panelKeteranganUser.setkEndColor(new java.awt.Color(240, 240, 240));
        panelKeteranganUser.setkStartColor(new java.awt.Color(204, 204, 204));

        isiKeteranganUser.setBackground(new java.awt.Color(255, 255, 255));
        isiKeteranganUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workerNama.setText("Nama Pegawai");
        isiKeteranganUser.add(workerNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 7, 260, -1));

        workerNomor.setText("Nomor Pegawai");
        isiKeteranganUser.add(workerNomor, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 36, 250, -1));

        workerJabatan.setText("Jabatan");
        isiKeteranganUser.add(workerJabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 300, -1));

        javax.swing.GroupLayout panelKeteranganUserLayout = new javax.swing.GroupLayout(panelKeteranganUser);
        panelKeteranganUser.setLayout(panelKeteranganUserLayout);
        panelKeteranganUserLayout.setHorizontalGroup(
            panelKeteranganUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKeteranganUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(isiKeteranganUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelKeteranganUserLayout.setVerticalGroup(
            panelKeteranganUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKeteranganUserLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(isiKeteranganUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        panelIsi.add(panelKeteranganUser, java.awt.BorderLayout.PAGE_START);

        panelMenuMenu.setBackground(new java.awt.Color(255, 255, 255));
        panelMenuMenu.setLayout(new java.awt.CardLayout());

        dashboard.setkEndColor(new java.awt.Color(255, 182, 193));
        dashboard.setkStartColor(new java.awt.Color(255, 215, 0));

        butUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framemenuutama/icons8-user-100.png"))); // NOI18N
        butUser.setText("USER");
        butUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        butUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        butUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUserActionPerformed(evt);
            }
        });

        butSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framemenuutama/icons8-seller-64.png"))); // NOI18N
        butSales.setText("SALES");
        butSales.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        butSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSalesActionPerformed(evt);
            }
        });

        butDafItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framemenuutama/icons8-item-100.png"))); // NOI18N
        butDafItem.setText("Daftar Item");
        butDafItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDafItemActionPerformed(evt);
            }
        });

        butPelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framemenuutama/icons8-buyer-96.png"))); // NOI18N
        butPelanggan.setText("Pelanggan");
        butPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butPelangganActionPerformed(evt);
            }
        });

        butLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framemenuutama/icons8-item-100.png"))); // NOI18N
        butLaporan.setText("Laporan");
        butLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLaporanActionPerformed(evt);
            }
        });

        butSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/framemenuutama/icons8-supplier-64.png"))); // NOI18N
        butSupplier.setText("Supplier");
        butSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(butLaporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butDafItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(101, 101, 101)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(butPelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(butUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butSales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butDafItem, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butUser, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dashboardLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(butLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(butSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butSales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(214, Short.MAX_VALUE))
        );

        panelMenuMenu.add(dashboard, "card2");

        pembelian.setkEndColor(new java.awt.Color(255, 255, 204));
        pembelian.setkStartColor(new java.awt.Color(255, 255, 0));

        tabelPesananBeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No Pesanan", "Kode Item", "Tanggal Pesan", "Jumlah", "Harga"
            }
        ));
        jScrollPane1.setViewportView(tabelPesananBeli);

        jLabel3.setText("No. Pesan : ");

        jLabel4.setText("Tanggal Pesan :");

        jLabel5.setText("Suplier :");

        butTambahPesan.setText("Tambah");
        butTambahPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butTambahPesanActionPerformed(evt);
            }
        });

        butHapusPesan.setText("Hapus");
        butHapusPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butHapusPesanActionPerformed(evt);
            }
        });

        listSuplier.setMaximumRowCount(50);
        listSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listSuplierActionPerformed(evt);
            }
        });

        jLabel6.setText("Nama Suplier :");

        nameSuplier.setEditable(false);

        jLabel7.setText("Masukan Kode Item:");

        jLabel8.setText("Jumlah :");

        jLabel9.setText("Menu ini digunakan untuk isi ulang stok, jika ingin menambahkan");

        jLabel10.setText("barang/item baru maka tambahkan terlebih dulu di menu barang");

        itemPesan.setMaximumRowCount(50);

        javax.swing.GroupLayout pembelianLayout = new javax.swing.GroupLayout(pembelian);
        pembelian.setLayout(pembelianLayout);
        pembelianLayout.setHorizontalGroup(
            pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pembelianLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pembelianLayout.createSequentialGroup()
                        .addComponent(butTambahPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(butHapusPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pembelianLayout.createSequentialGroup()
                        .addGroup(pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pembelianLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18))
                            .addGroup(pembelianLayout.createSequentialGroup()
                                .addGroup(pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(noPesan)
                            .addComponent(itemPesan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tglPesan, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                        .addGroup(pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pembelianLayout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addGroup(pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pembelianLayout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addGroup(pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(listSuplier, 0, 151, Short.MAX_VALUE)
                            .addComponent(nameSuplier)
                            .addComponent(jumlahBar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        pembelianLayout.setVerticalGroup(
            pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pembelianLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(listSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)
                        .addComponent(nameSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tglPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(itemPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jumlahBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pembelianLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butTambahPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(butHapusPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pembelianLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addGap(2, 2, 2))
        );

        panelMenuMenu.add(pembelian, "card3");

        penjualan.setkEndColor(new java.awt.Color(102, 255, 204));
        penjualan.setkStartColor(new java.awt.Color(0, 128, 0));

        jLabel11.setText("No. Pesanan");

        jLabel12.setText("Tanggal");

        jLabel13.setText("Pelanggan");

        jLabel14.setText("Nama Pelanggan");

        tabelPesananPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomor Pesanan", "Kode Item", "Jumlah", "ID Pelanggan", "Tanggal Jual"
            }
        ));
        jScrollPane2.setViewportView(tabelPesananPenjualan);

        namaBuyer.setEditable(false);

        pelangganJual.setMaximumRowCount(50);
        pelangganJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelangganJualActionPerformed(evt);
            }
        });

        jLabel15.setText("Jumlah Pesanan");

        jLabel16.setText("Kode Item");

        butTambahPesananJual.setText("Tambah");
        butTambahPesananJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butTambahPesananJualActionPerformed(evt);
            }
        });

        butHapusPesananJual.setText("Hapus");
        butHapusPesananJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butHapusPesananJualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout penjualanLayout = new javax.swing.GroupLayout(penjualan);
        penjualan.setLayout(penjualanLayout);
        penjualanLayout.setHorizontalGroup(
            penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penjualanLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(penjualanLayout.createSequentialGroup()
                        .addComponent(butTambahPesananJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(butHapusPesananJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(penjualanLayout.createSequentialGroup()
                            .addGroup(penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13))
                            .addGap(18, 18, 18)
                            .addGroup(penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(namaBuyer, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(penjualanLayout.createSequentialGroup()
                                    .addGroup(penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tglPesananJual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pelangganJual, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(noPesanJual))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel16)
                                        .addComponent(jLabel15))
                                    .addGap(27, 27, 27)
                                    .addGroup(penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(kodeItemJual)
                                        .addComponent(jumPesanJual, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        penjualanLayout.setVerticalGroup(
            penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penjualanLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(noPesanJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(kodeItemJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(tglPesananJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(jumPesanJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(penjualanLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, penjualanLayout.createSequentialGroup()
                        .addComponent(pelangganJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(namaBuyer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butTambahPesananJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butHapusPesananJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        panelMenuMenu.add(penjualan, "card4");

        trBeli.setkEndColor(new java.awt.Color(102, 255, 102));

        tabelTransaksiBeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDPesanan", "TanggalPesanan", "StatusPembayaran"
            }
        ));
        jScrollPane4.setViewportView(tabelTransaksiBeli);

        butKonfirmTransaksiBeli.setText("KONFIRMASI PESANAN");
        butKonfirmTransaksiBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butKonfirmTransaksiBeliActionPerformed(evt);
            }
        });

        jLabel21.setText("Nomor Transaksi");

        jLabel24.setText("------------------------------------------------------------------------------------------------------------------------------------");

        jLabel25.setText("FITUR PENCARIAN");

        jLabel26.setText("CARI BERDASARKAN IDPesanan");

        inputanIDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputanIDPActionPerformed(evt);
            }
        });

        aksiPencarianTRbeli.setText("CARI");
        aksiPencarianTRbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aksiPencarianTRbeliActionPerformed(evt);
            }
        });

        delAdminTrBeli.setText("DELETE(ADMIN ONLY)");
        delAdminTrBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delAdminTrBeliActionPerformed(evt);
            }
        });

        jLabel27.setText("untuk konfirmasi pesanan dan delete");

        javax.swing.GroupLayout trBeliLayout = new javax.swing.GroupLayout(trBeli);
        trBeli.setLayout(trBeliLayout);
        trBeliLayout.setHorizontalGroup(
            trBeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trBeliLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(trBeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(trBeliLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addComponent(inputanIDP, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(aksiPencarianTRbeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addGroup(trBeliLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(18, 18, 18)
                        .addComponent(nomorTransaksiBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel27))
                    .addGroup(trBeliLayout.createSequentialGroup()
                        .addComponent(butKonfirmTransaksiBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(delAdminTrBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        trBeliLayout.setVerticalGroup(
            trBeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trBeliLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(trBeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(inputanIDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aksiPencarianTRbeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(trBeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(nomorTransaksiBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(trBeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(delAdminTrBeli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butKonfirmTransaksiBeli, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelMenuMenu.add(trBeli, "card5");

        trJual.setkEndColor(new java.awt.Color(204, 255, 0));

        jLabel17.setText("No. Transaksi");

        jLabel18.setText("No. Pesanan");

        tabelHistoriPesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Pelanggan", "Nama Item", "Jumlah", "Harga", "Status Pesanan"
            }
        ));
        jScrollPane3.setViewportView(tabelHistoriPesanan);

        noPesananJual.setMaximumRowCount(50);
        noPesananJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noPesananJualActionPerformed(evt);
            }
        });

        butConfirmTRJual.setText("KONFIRMASI ");
        butConfirmTRJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butConfirmTRJualActionPerformed(evt);
            }
        });

        jLabel19.setText("Menu untuk menentukan pesanan telah dipesan dan dibayar");

        jLabel20.setText("Total Harga :");

        totHargaJual.setEditable(false);

        jLabel22.setText("Jika sebelumnya sudah memesan maka pilih nomor pesanan");

        jLabel23.setText("JIKA INGIN MEMBATALKAN TRANSAKSI, hapus di menu pesanan");

        delOnlyAdmin.setText("DELETE (ADMIN ONLY)");
        delOnlyAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delOnlyAdminActionPerformed(evt);
            }
        });

        updateItemTR.setText("UPDATE ITEM");
        updateItemTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateItemTRActionPerformed(evt);
            }
        });

        jLabel28.setText("Tekan combobox untuk refresh");

        javax.swing.GroupLayout trJualLayout = new javax.swing.GroupLayout(trJual);
        trJual.setLayout(trJualLayout);
        trJualLayout.setHorizontalGroup(
            trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trJualLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(trJualLayout.createSequentialGroup()
                        .addGroup(trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addGap(24, 24, 24)
                        .addGroup(trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(noPesananJual, 0, 193, Short.MAX_VALUE)
                            .addComponent(noTransaksiJual))
                        .addGroup(trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(trJualLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addGroup(trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel22))
                                .addGap(32, 32, 32))
                            .addGroup(trJualLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(trJualLayout.createSequentialGroup()
                        .addGroup(trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(trJualLayout.createSequentialGroup()
                                .addComponent(butConfirmTRJual)
                                .addGap(48, 48, 48)
                                .addGroup(trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(trJualLayout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(totHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addGroup(trJualLayout.createSequentialGroup()
                                        .addComponent(updateItemTR, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(delOnlyAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        trJualLayout.setVerticalGroup(
            trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trJualLayout.createSequentialGroup()
                .addGroup(trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(trJualLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(noTransaksiJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(noPesananJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(trJualLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(trJualLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(butConfirmTRJual, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                    .addGroup(trJualLayout.createSequentialGroup()
                        .addGroup(trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(totHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(trJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delOnlyAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateItemTR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        panelMenuMenu.add(trJual, "card6");

        panelIsi.add(panelMenuMenu, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelIsi, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void butDashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDashActionPerformed
        panelMenuMenu.removeAll();
        panelMenuMenu.add(dashboard);
        panelMenuMenu.repaint();
        panelMenuMenu.revalidate();
    }//GEN-LAST:event_butDashActionPerformed

    private void butBuyPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBuyPesanActionPerformed
        panelMenuMenu.removeAll();
        panelMenuMenu.add(pembelian);
        panelMenuMenu.repaint();
        panelMenuMenu.revalidate();
        inisialisasiTabelPesananBeli();
        inisialisasiCBitem();
        inisialisasiCBsuplier();
    }//GEN-LAST:event_butBuyPesanActionPerformed

    private void inisialisasiCBitem() {
        String query = "SELECT kodeItem, namaItem FROM item";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                boolean cek = true;
                int kodeItem = resultSet.getInt("kodeItem");
                for (int i = 0; i < itemPesan.getItemCount(); i++) {
                    if (itemPesan.getItemAt(i).equals(Integer.toString(kodeItem))) {
                        cek = false;
                    }
                }
                if (cek) {
                    itemPesan.addItem(Integer.toString(kodeItem));
                }
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("inisialisasi combobox item gagal");
        }
    }

    private void inisialisasiCBsuplier() {
        String query = "SELECT idSuplier, nama FROM suplier";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                boolean cek = true;
                int idSuplier = resultSet.getInt("idSuplier");
                for (int i = 0; i < listSuplier.getItemCount(); i++) {
                    if (listSuplier.getItemAt(i).equals(Integer.toString(idSuplier))) {
                        cek = false;
                    }
                }
                if (cek) {
                    listSuplier.addItem(Integer.toString(idSuplier));
                }
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("inisialisasi combobox suplier gagal");
        }
    }

    private void inisialisasiCBPelanggan() {
        String query = "SELECT idPelanggan FROM pelanggan";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                boolean cek = true;
                int idCust = resultSet.getInt("idPelanggan");
                for (int i = 0; i < pelangganJual.getItemCount(); i++) {
                    if (pelangganJual.getItemAt(i).equals(Integer.toString(idCust))) {
                        cek = false;
                    }
                }
                if (cek) {
                    pelangganJual.addItem(Integer.toString(idCust));
                }
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("inisialisasi combobox pelanggan gagal");
        }
    }

    private void inisialisasiCBPesanan() {
        String query = "SELECT idPesananPenjualan FROM pesananpenjualan WHERE status_pesanan = 'Belum';";
        try {
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                boolean cek = true;
                int idPP = resultSet.getInt("idPesananPenjualan");
                for (int i = 0; i < noPesananJual.getItemCount(); i++) {
                    if (noPesananJual.getItemAt(i).equals(Integer.toString(idPP))) {
                        cek = false;
                    }
                }
                if (cek) {
                    noPesananJual.addItem(Integer.toString(idPP));
                }
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("inisialisasi combobox pesananpenjualan gagal");
        }
    }

    private void inisialisasiTabelPesananBeli() {
        DefaultTableModel tmodel = (DefaultTableModel) tabelPesananBeli.getModel();
        tabelPesananBeli.setAutoCreateRowSorter(true);
        tmodel.setRowCount(0);
        try {
            String selectSql = "SELECT idPesanan, kodeItem, tanggalpesan, jumlah, harga FROM pesananpembelian";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                int idPesanan = resultSet.getInt("idPesanan");
                int kodeItem = resultSet.getInt("kodeItem");
                Date tanggalPesan = resultSet.getDate("tanggalpesan");
                int jumlah = resultSet.getInt("jumlah");
                double harga = resultSet.getDouble("harga");
                ArrayList myPesananBeliTabel = new ArrayList();
                myPesananBeliTabel.add(idPesanan);
                myPesananBeliTabel.add(kodeItem);
                myPesananBeliTabel.add(tanggalPesan);
                myPesananBeliTabel.add(jumlah);
                myPesananBeliTabel.add(harga);
                tmodel.addRow(myPesananBeliTabel.toArray());
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil detail pesanan pembelian");
            e.printStackTrace();
        }
    }

    private void inisialisasiTabelTransaksiPembelian() {
        DefaultTableModel tmodel = (DefaultTableModel) tabelTransaksiBeli.getModel();
        tabelTransaksiBeli.setAutoCreateRowSorter(true);
        tmodel.setRowCount(0);
        try {
            String query = "SELECT idPesanan, tanggalpesan, status_pemebelian FROM pesananpembelian WHERE status_pemebelian = 'Belum';";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int idPesanan = resultSet.getInt("idPesanan");
                Date tanggalPesan = resultSet.getDate("tanggalpesan");
                String statusPembelian = resultSet.getString("status_pemebelian");
                ArrayList myPesananBeliTabel = new ArrayList();
                myPesananBeliTabel.add(idPesanan);
                myPesananBeliTabel.add(tanggalPesan);
                myPesananBeliTabel.add(statusPembelian);
                tmodel.addRow(myPesananBeliTabel.toArray());
            }
            statement.close();
            resultSet.close();
        } catch (SQLException ex) {
            System.out.println("Gagal inisialisasi data pesanan pembelian di panel transaksi");
        }
    }

    private void inisialisasiTabelPesananJual() {
        DefaultTableModel tmodel = (DefaultTableModel) tabelPesananPenjualan.getModel();
        tabelPesananPenjualan.setAutoCreateRowSorter(true);
        tmodel.setRowCount(0);
        try {
            String selectQuery = "SELECT idPesananPenjualan, kodeItem, jumlah, idPelanggan, tanggalPesan FROM pesananpenjualan WHERE status_pesanan = 'Belum';";
            PreparedStatement selectStatement = con.prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                int idPesananPenjualan = resultSet.getInt("idPesananPenjualan");
                int kodeItem = resultSet.getInt("kodeItem");
                int jumlah = resultSet.getInt("jumlah");
                int idPelanggan = resultSet.getInt("idPelanggan");
                String tanggalPesan = resultSet.getString("tanggalPesan");
                ArrayList myPesananPenjualan = new ArrayList();
                myPesananPenjualan.add(idPesananPenjualan);
                myPesananPenjualan.add(kodeItem);
                myPesananPenjualan.add(jumlah);
                myPesananPenjualan.add(idPelanggan);
                myPesananPenjualan.add(tanggalPesan);
                tmodel.addRow(myPesananPenjualan.toArray());
            }
            resultSet.close();
            selectStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void butBuyDealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBuyDealActionPerformed
        panelMenuMenu.removeAll();
        panelMenuMenu.add(trBeli);
        panelMenuMenu.repaint();
        panelMenuMenu.revalidate();
        inisialisasiTabelTransaksiPembelian();
    }//GEN-LAST:event_butBuyDealActionPerformed

    private void butSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSelActionPerformed
        panelMenuMenu.removeAll();
        panelMenuMenu.add(penjualan);
        panelMenuMenu.repaint();
        panelMenuMenu.revalidate();
        inisialisasiCBPelanggan();
        inisialisasiTabelPesananJual();
    }//GEN-LAST:event_butSelActionPerformed

    private void butSellDealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSellDealActionPerformed
        panelMenuMenu.removeAll();
        panelMenuMenu.add(trJual);
        panelMenuMenu.repaint();
        panelMenuMenu.revalidate();
        inisialisasiCBPesanan();
    }//GEN-LAST:event_butSellDealActionPerformed

    private void butDafItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDafItemActionPerformed
        DaftarItem a = new DaftarItem();
        a.setVisible(true);
    }//GEN-LAST:event_butDafItemActionPerformed

    private void butPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butPelangganActionPerformed
        Pelanggan a = new Pelanggan();
        a.setVisible(true);
    }//GEN-LAST:event_butPelangganActionPerformed

    private void butUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butUserActionPerformed
        UserForm a = new UserForm();
        a.setVisible(true);
    }//GEN-LAST:event_butUserActionPerformed

    private void butSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSupplierActionPerformed
        Supplier a = new Supplier();
        a.setVisible(true);
    }//GEN-LAST:event_butSupplierActionPerformed

    private void butSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSalesActionPerformed

    }//GEN-LAST:event_butSalesActionPerformed

    private void butLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLaporanActionPerformed
        Laporan a = new Laporan();
        a.setVisible(true);
    }//GEN-LAST:event_butLaporanActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        dispose();
        Main log = new Main();
        log.setVisible(true);
    }//GEN-LAST:event_logOutActionPerformed

    private void butTambahPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butTambahPesanActionPerformed
        if (itemPesan.getSelectedIndex() == -1 || listSuplier.getSelectedIndex() == -1
                || noPesan.getText().isEmpty() || tglPesan.getDate() == null || jumlahBar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi komponen yang kosong");
        } else {
            int noPesanan = Integer.parseInt(noPesan.getText());
            boolean cekSyarat = cekKodePesananBeli(noPesanan);
            if (cekSyarat) {
                JOptionPane.showMessageDialog(null, "nomor pesanan sudah ada, masukan nomor lain");
            } else {
                int kodeItem = Integer.parseInt((String) itemPesan.getSelectedItem());
                int idSuplier = Integer.parseInt((String) listSuplier.getSelectedItem());
                int jumlah = Integer.parseInt(jumlahBar.getText());
                double harga = 0;
                try {
                    String selectSql = "SELECT hargajual FROM item WHERE kodeItem = '" + kodeItem + "'";
                    Statement s = con.createStatement();
                    ResultSet val = s.executeQuery(selectSql);
                    if (val.next()) {
                        harga = val.getDouble("hargajual") * (double) jumlah;
                    } else {
                        System.out.println("gagal ambil harga pesanan beli");
                    }
                    s.close();
                    val.close();
                } catch (SQLException e) {
                    System.out.println("Gagal mengambil harga untuk pesanan pembelian");
                }
                Date tanggalPesan = new Date(tglPesan.getDate().getTime());
                String statusPembelian = "Belum";
                try {
                    String sql = "INSERT INTO pesananpembelian (idPesanan, kodeItem, idSuplier, jumlah, harga, tanggalpesan, status_pemebelian) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = con.prepareStatement(sql);
                    statement.setInt(1, noPesanan);
                    statement.setInt(2, kodeItem);
                    statement.setInt(3, idSuplier);
                    statement.setInt(4, jumlah);
                    statement.setDouble(5, harga);
                    statement.setDate(6, tanggalPesan);
                    statement.setString(7, statusPembelian);
                    int hasil = statement.executeUpdate();
                    if (hasil > 0) {
                        System.out.println("Data berhasil di-insert untuk pesanan pembelian");
                    } else {
                        System.out.println("Gagal melakukan insert data pesanan pembelian");
                    }
                    statement.close();
                    tambahStokBarangPesananBatal(kodeItem, jumlah);
                    inisialisasiTabelPesananBeli();
                } catch (SQLException e) {
                    System.out.println("Gagal menambahkan ke pesanan pembelian");
                }
            }
        }
    }//GEN-LAST:event_butTambahPesanActionPerformed

    private boolean cekKodePesananBeli(int idPesananBeli) {
        boolean cek = false;
        try {
            String query = "SELECT COUNT(*) AS count FROM pesananpembelian WHERE idPesanan = '" + idPesananBeli + "'";
            Statement statement = con.createStatement();
            ResultSet hasil = statement.executeQuery(query);
            if (hasil.next()) {
                int jumlah = hasil.getInt("count");
                if (jumlah > 0) {
                    cek = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal cek id ke pesanan pembelian");
        }

        return cek;
    }

    private void butHapusPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butHapusPesanActionPerformed
        int row = tabelPesananBeli.getSelectedRow();
        int value = Integer.parseInt(tabelPesananBeli.getModel().getValueAt(row, 0).toString());
        try {
            Statement statement = con.createStatement();
            String query = "DELETE FROM pesananpembelian WHERE idPesanan = '" + value + "'";
            int hasil = statement.executeUpdate(query);
            if (hasil > 0) {
                System.out.println("Data berhasil didelete pada tabel pesananpembelian");
            } else {
                System.out.println("Gagal mendelete data pada tabel pesananpembelian");
            }
            int kodeItem = Integer.parseInt(tabelPesananBeli.getModel().getValueAt(row, 1).toString());
            int jumlah = Integer.parseInt(tabelPesananBeli.getModel().getValueAt(row, 3).toString());
            kurangiStokBarang(jumlah, kodeItem);
        } catch (SQLException ex) {
            System.out.println("Gagal delete baris yang dipilih pada tabel pesanan beli");
        }
        DefaultTableModel tmodel = (DefaultTableModel) tabelPesananBeli.getModel();
        tmodel.setRowCount(0);
        inisialisasiTabelPesananBeli();
    }//GEN-LAST:event_butHapusPesanActionPerformed

    private boolean cekKetersediaanBarang(int jumlah, int codeBarang) {
        boolean cek = false;
        try {
            String selectSql = "SELECT stok FROM item WHERE kodeItem = '" + codeBarang + "'";
            Statement s = con.createStatement();
            ResultSet val = s.executeQuery(selectSql);
            if (val.next()) {
                int stokBarang = val.getInt("stok");
                if (stokBarang >= jumlah) {
                    cek = true;
                }
            }
            s.close();
            val.close();
        } catch (SQLException e) {
            System.out.println("Gagal cek ketersediaan barang untuk pesanan pembelian");
        }
        return cek;
    }

    private void kurangiStokBarang(int jumlah, int kodeItem) {
        try {
            String updateStokSql = "UPDATE item SET stok = stok - " + jumlah + " WHERE kodeItem = '" + kodeItem + "'";
            Statement s = con.createStatement();
            int hasil = s.executeUpdate(updateStokSql);
            if (hasil > 0) {
                System.out.println("stok item berhasil dikurangi");
            } else {
                System.out.println("stok item gagal dikurangi");
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Gagal mengurangi stok item untuk pesanan pembelian ketika berhasil pesan");
        }
    }

    private void tambahStokBarangPesananBatal(int kodeItem, int jumlah) {
        try {
            String updateStokSql = "UPDATE item SET stok = stok + " + jumlah + " WHERE kodeItem = '" + kodeItem + "'";
            Statement s = con.createStatement();
            int hasil = s.executeUpdate(updateStokSql);
            if (hasil > 0) {
                System.out.println("stok item berhasil ditambah");
            } else {
                System.out.println("stok item gagal ditambah");
            }
            s.close();
        } catch (SQLException e) {
            System.out.println("Gagal menambah stok item untuk tabel item ketika hapus pesanan pembelian");
        }
    }

    private void butKonfirmTransaksiBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butKonfirmTransaksiBeliActionPerformed
        // konfirmasi ubah status pesanan
        if (nomorTransaksiBeli.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi komponen yang kosong");
        } else {
            int nomorTrBeli = Integer.parseInt(nomorTransaksiBeli.getText());
            int row = tabelTransaksiBeli.getSelectedRow();
            int idPesananX = Integer.parseInt(tabelTransaksiBeli.getModel().getValueAt(row, 0).toString());
            boolean cek = false;
            try {
                String insertTransaksiQuery = "INSERT INTO transaksipembelian (idTransaksi, idPesanan, tanggaltransaksi) VALUES (?, ?, CURDATE())";
                PreparedStatement insertTransaksiStatement = con.prepareStatement(insertTransaksiQuery);
                insertTransaksiStatement.setInt(1, nomorTrBeli);
                insertTransaksiStatement.setInt(2, idPesananX);
                int cekInsert = insertTransaksiStatement.executeUpdate();
                if (cekInsert > 0) {
                    System.out.println("insert ke transaksi pembelian berhasil");
                    cek = true;
                } else {
                    System.out.println("insert ke transaksi pembelian gagal");
                    JOptionPane.showMessageDialog(null, "gagal konfirmasi pesanan pembelian");
                }
                if (cek) {
                    String updateStatusQuery = "UPDATE pesananpembelian SET status_pemebelian = 'Lunas' WHERE idPesanan = ?";
                    PreparedStatement updateStatusStatement = con.prepareStatement(updateStatusQuery);
                    updateStatusStatement.setInt(1, idPesananX);
                    int cekUpdate = updateStatusStatement.executeUpdate();
                    updateStatusStatement.close();
                    if (cekUpdate > 0) {
                        System.out.println("update status pembelian berhasil");
                    } else {
                        System.out.println("update status pembelian gagal");
                    }
                }
                insertTransaksiStatement.close();
                inisialisasiTabelTransaksiPembelian();
                System.out.println("Status pembayaran diubah menjadi 'lunas' dan data transaksi berhasil dimasukkan.");
            } catch (SQLException ex) {
                System.out.println("Gagal melakukan operasi update pada pesanan pembelian dan insert pada transaksi pembelian");
            }
        }

    }//GEN-LAST:event_butKonfirmTransaksiBeliActionPerformed

    private void listSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listSuplierActionPerformed
        String ambilvalue = (String) listSuplier.getSelectedItem();
        try {
            int value = Integer.parseInt(ambilvalue);
            String query = "SELECT nama FROM suplier WHERE idSuplier = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                nameSuplier.setText(resultSet.getString("nama"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("inisialisasi combobox suplier gagal");
        }
    }//GEN-LAST:event_listSuplierActionPerformed

    private void delOnlyAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delOnlyAdminActionPerformed
        if (workerNomor.getText().contains("ADMIN")) {
            System.out.println("berhasil");
            try {
                int idTr = Integer.parseInt(noTransaksiJual.getText());
                String deleteQuery = "DELETE FROM transaksipenjualan WHERE idTransaksiPenjualan = '" + idTr + "'";
                Statement statement = con.createStatement();
                int cekDelete = statement.executeUpdate(deleteQuery);
                if (cekDelete > 0) {
                    System.out.println("berhasil delete di tabel transaksi penjualan");
                } else {
                    System.out.println("gagal delete di tabel transaksi penjualan");
                }
            } catch (SQLException ex) {
                System.out.println(ex + " gagal delete tr penjualan");
            }
        } else {
            JOptionPane.showMessageDialog(null, "anda tidak memiliki wewenang untuk menghapus");
        }
    }//GEN-LAST:event_delOnlyAdminActionPerformed

    private void delAdminTrBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delAdminTrBeliActionPerformed
        if (workerNomor.getText().contains("ADMIN")) {
            try {
                int idTr = Integer.parseInt(nomorTransaksiBeli.getText());
                String deleteQuery = "DELETE FROM transaksipembelian WHERE idTransaksi = '" + idTr + "'";
                Statement statement = con.createStatement();
                int cekDelete = statement.executeUpdate(deleteQuery);
                if (cekDelete > 0) {
                    System.out.println("berhasil delete di tabel transaksi pembelian");
                } else {
                    System.out.println("gagal delete di tabel transaksi pembelian");
                }
            } catch (SQLException ex) {
                System.out.println(ex + " gagal delete tr beli");
            }
        } else {
            JOptionPane.showMessageDialog(null, "anda tidak memiliki wewenang untuk menghapus");
        }
    }//GEN-LAST:event_delAdminTrBeliActionPerformed

    private void aksiPencarianTRbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aksiPencarianTRbeliActionPerformed
        if (inputanIDP.getText().isEmpty()) {
            inisialisasiTabelTransaksiPembelian();
        } else {
            int idP = Integer.parseInt(inputanIDP.getText());
            try {
                DefaultTableModel tmodel = (DefaultTableModel) tabelTransaksiBeli.getModel();
                tmodel.setRowCount(0);
                tabelTransaksiBeli.setAutoCreateRowSorter(true);
                String sql = "SELECT idPesanan, tanggalpesan, status_pemebelian "
                        + "FROM pesananpembelian "
                        + "WHERE idPesanan = '" + idP + "'";
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int idPesanan = resultSet.getInt("idPesanan");
                    String tanggalPesan = resultSet.getString("tanggalpesan");
                    String statusPembelian = resultSet.getString("status_pemebelian");
                    ArrayList myPesananCari = new ArrayList();
                    myPesananCari.add(idPesanan);
                    myPesananCari.add(tanggalPesan);
                    myPesananCari.add(statusPembelian);
                    tmodel.addRow(myPesananCari.toArray());
                }

            } catch (SQLException ex) {
                System.out.println("Gagal mencari data dari pesananpembelian (cek date)");
            }
        }
    }//GEN-LAST:event_aksiPencarianTRbeliActionPerformed

    private void pelangganJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelangganJualActionPerformed
        String ambilvalue = (String) pelangganJual.getSelectedItem();
        try {
            int value = Integer.parseInt(ambilvalue);
            String query = "SELECT nama FROM pelanggan WHERE idPelanggan = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                namaBuyer.setText(resultSet.getString("nama"));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("inisialisasi combobox pelanggan ke label gagal");
        }
    }//GEN-LAST:event_pelangganJualActionPerformed

    private boolean cekKodePesananJual(int idPesananJual) {
        boolean cek = false;
        try {
            String query = "SELECT COUNT(*) AS count FROM pesananpenjualan WHERE idPesananPenjualan = '" + idPesananJual + "'";
            Statement statement = con.createStatement();
            ResultSet hasil = statement.executeQuery(query);
            if (hasil.next()) {
                int jumlah = hasil.getInt("count");
                if (jumlah > 0) {
                    cek = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Gagal cek id ke pesanan penjualan");
        }

        return cek;
    }

    private void butTambahPesananJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butTambahPesananJualActionPerformed
        // tambah di tabel pesanan jual
        if (noPesanJual.getText().isEmpty() || kodeItemJual.getText().isEmpty() || tglPesananJual.getDate() == null) {
            JOptionPane.showMessageDialog(null, "masukan komponen yang kosong");
        } else {
            int nomorPJual = Integer.parseInt(noPesanJual.getText());
            if (cekKodePesananJual(nomorPJual)) {
                JOptionPane.showMessageDialog(null, "nomor pesanan sudah ada, ganti yang lain");
            } else {
                int kodeItem = Integer.parseInt(kodeItemJual.getText());
                int jumlah = Integer.parseInt(jumPesanJual.getText());
                int pelangganJ = Integer.parseInt((String) pelangganJual.getSelectedItem());
                double harga = 0;
                if (cekKetersediaanBarang(jumlah, kodeItem)) {
                    try {
                        String selectSql = "SELECT hargajual FROM item WHERE kodeItem = '" + kodeItem + "'";
                        Statement s = con.createStatement();
                        ResultSet val = s.executeQuery(selectSql);
                        if (val.next()) {
                            harga = val.getDouble("hargajual") * (double) jumlah;
                        } else {
                            System.out.println("gagal ambil harga pesanan beli");
                        }
                        Date tanggalPesanJ = new Date(tglPesananJual.getDate().getTime());
                        String insertQuery = "INSERT INTO pesananpenjualan (idPesananPenjualan, idPelanggan, kodeItem, jumlah, harga, tanggalPesan, status_pesanan) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement insertStatement = con.prepareStatement(insertQuery);
                        insertStatement.setInt(1, nomorPJual);
                        insertStatement.setInt(2, pelangganJ);
                        insertStatement.setInt(3, kodeItem);
                        insertStatement.setInt(4, jumlah);
                        insertStatement.setDouble(5, harga);
                        insertStatement.setDate(6, tanggalPesanJ);
                        insertStatement.setString(7, "Belum");
                        int hasilInsert = insertStatement.executeUpdate();
                        if (hasilInsert > 0) {
                            System.out.println("Data pesananpenjualan berhasil diinsert.");
                        } else {
                            System.out.println("Gagal menginsert data pesananpenjualan.");
                        }
                        insertStatement.close();
                        inisialisasiTabelPesananJual();
                        kurangiStokBarang(jumlah, kodeItem);
                        s.close();
                        val.close();
                    } catch (SQLException e) {
                        System.out.println("Gagal insert untuk pesanan penjualan");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Jumlah barang tidak cukup untuk dijualkan");
                }
            }
        }
    }//GEN-LAST:event_butTambahPesananJualActionPerformed

    private void butHapusPesananJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butHapusPesananJualActionPerformed
        int row = tabelPesananPenjualan.getSelectedRow();
        int nomPesanan = Integer.parseInt(tabelPesananPenjualan.getModel().getValueAt(row, 0).toString());
        int kodeItm = Integer.parseInt(tabelPesananPenjualan.getModel().getValueAt(row, 1).toString());
        int jum = Integer.parseInt(tabelPesananPenjualan.getModel().getValueAt(row, 2).toString());
        try {
            String query = "DELETE FROM pesananpenjualan WHERE idPesananPenjualan = '" + nomPesanan + "'";
            Statement s = con.createStatement();
            int val = s.executeUpdate(query);
            if (val > 0) {
                System.out.println("delete berhasil");
            }
            tambahStokBarangPesananBatal(kodeItm, jum);
            inisialisasiTabelPesananJual();
            s.close();
        } catch (SQLException e) {
            System.out.println("Gagal delete untuk pesanan penjualan" + e);
        }

    }//GEN-LAST:event_butHapusPesananJualActionPerformed

    private void butConfirmTRJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butConfirmTRJualActionPerformed
        if (noTransaksiJual.getText().isEmpty() || noPesananJual.getSelectedIndex() == -1) {

        } else {
            int noTRJ = Integer.parseInt(noTransaksiJual.getText());
            int noPJ = Integer.parseInt((String) noPesananJual.getSelectedItem());
            double price = Double.parseDouble(totHargaJual.getText());
            try {
                boolean cek = false;
                String query = "INSERT INTO transaksipenjualan (idTransaksiPenjualan, idPesananPenjualan, tanggalTransaksi, totalBayar) VALUES (?, ?, CURRENT_DATE, ?)";
                PreparedStatement insertTransaksiStatement = con.prepareStatement(query);
                insertTransaksiStatement.setInt(1, noTRJ);
                insertTransaksiStatement.setInt(2, noPJ);
                insertTransaksiStatement.setDouble(3, price);
                int cekInsert = insertTransaksiStatement.executeUpdate();
                if (cekInsert > 0) {
                    System.out.println("insert transaksipenjualan berhasil");
                    cek = true;
                } else {
                    System.out.println("insert transaksipenjualan gagal");
                }
                if (cek) {
                    String sql = "UPDATE pesananpenjualan SET status_pesanan = 'Lunas' WHERE idPesananPenjualan = '" + noPJ + "'";
                    Statement s = con.createStatement();
                    int has = s.executeUpdate(sql);
                    if (has > 0) {
                        System.out.println("berhasil update lunas di transaksi jual");
                    } else {
                        System.out.println("gagal upate lunas di tr jual");
                    }
                    s.close();
                }
                insertTransaksiStatement.close();
            } catch (SQLException e) {
                System.out.println("Gagal insert untuk transaksi penjualan");
            }
        }
    }//GEN-LAST:event_butConfirmTRJualActionPerformed

    private void noPesananJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noPesananJualActionPerformed
        try {
            DefaultTableModel tmodel = (DefaultTableModel) tabelHistoriPesanan.getModel();
            tabelHistoriPesanan.setAutoCreateRowSorter(true);
            tmodel.setRowCount(0);
            int noP = Integer.parseInt((String) noPesananJual.getSelectedItem());
            String query = "SELECT  p.nama AS namaPelanggan, i.namaItem, pp.jumlah, pp.harga, pp.status_pesanan \n"
                    + "FROM pesananpenjualan AS pp JOIN pelanggan AS p ON pp.idPelanggan = p.idPelanggan \n"
                    + "JOIN item AS i ON pp.kodeItem = i.kodeItem\n"
                    + "WHERE idPesananPenjualan = '" + noP + "';";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String namaPelanggan = resultSet.getString("namaPelanggan");
                String namaItem = resultSet.getString("namaItem");
                int jumlah = resultSet.getInt("jumlah");
                double harga = resultSet.getDouble("harga");
                String statusPesanan = resultSet.getString("status_pesanan");
                ArrayList myPesananTabel = new ArrayList();
                myPesananTabel.add(namaPelanggan);
                myPesananTabel.add(namaItem);
                myPesananTabel.add(jumlah);
                myPesananTabel.add(harga);
                myPesananTabel.add(statusPesanan);
                totHargaJual.setText(Double.toString(harga));
                tmodel.addRow(myPesananTabel.toArray());
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Gagal inisialisasi Jtabel tPenjualan dari CB penjualan");
        }
    }//GEN-LAST:event_noPesananJualActionPerformed

    private void inputanIDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputanIDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputanIDPActionPerformed

    private void updateItemTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateItemTRActionPerformed
        if (noPesananJual.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "pilih nomor pesanan terlebih dulu");
        } else {
            int idPesananPJual = Integer.parseInt((String) noPesananJual.getSelectedItem());
            String jumlahBaru = JOptionPane.showInputDialog(null, "ubah jumlah item yang ingin dikonfirmasi: ");
            int codeItem = 0;
            int jumBaru = Integer.parseInt(jumlahBaru);
            if (jumBaru >= 0) {
                try {
                    String selectQuery = "SELECT jumlah, kodeItem FROM pesananpenjualan WHERE idPesananPenjualan = '" + idPesananPJual + "';";
                    Statement s = con.createStatement();
                    ResultSet resultSet = s.executeQuery(selectQuery);
                    int jumlahSebelum = 0;
                    if (resultSet.next()) {
                        jumlahSebelum = resultSet.getInt("jumlah");
                        codeItem = resultSet.getInt("kodeItem");
                    }
                    int totalITEM;
                    s.close();
                    resultSet.close();

                    if (jumBaru > jumlahSebelum) {
                        totalITEM = jumBaru - jumlahSebelum;
                        kurangiStokBarang(totalITEM, codeItem);
                        double harga = 0;
                        String sql = "SELECT hargajual FROM item WHERE kodeItem = '" + codeItem + "'";
                        Statement state = con.createStatement();
                        ResultSet result = state.executeQuery(sql);
                        if (result.next()) {
                            harga = result.getDouble("hargajual") * (double) jumBaru;
                        }

                        String updateQuery = "UPDATE pesananpenjualan SET jumlah = ?, harga = ? WHERE idPesananPenjualan = ?";
                        PreparedStatement preparedStatement = con.prepareStatement(updateQuery);
                        preparedStatement.setInt(1, jumBaru);
                        preparedStatement.setDouble(2, harga);
                        preparedStatement.setInt(3, idPesananPJual);

                        int rowupdated = preparedStatement.executeUpdate();

                        if (rowupdated > 0) {
                            System.out.println("Update berhasil");
                        } else {
                            System.out.println("Update gagal");
                        }
                        state.close();
                        result.close();
                        preparedStatement.close();
                    } else if (jumBaru == jumlahSebelum) {
                        JOptionPane.showMessageDialog(null, "jumlah item sama, tidak ada perubahan");
                    } else {
                        totalITEM = jumlahSebelum - jumBaru;
                        tambahStokBarangPesananBatal(codeItem, totalITEM);
                        double harga = 0;
                        String sql = "SELECT hargajual FROM item WHERE kodeItem = '" + codeItem + "'";
                        Statement state = con.createStatement();
                        ResultSet result = state.executeQuery(sql);
                        if (result.next()) {
                            harga = result.getDouble("hargajual") * (double) jumBaru;
                        }

                        String updateQuery = "UPDATE pesananpenjualan SET jumlah = ?, harga = ? WHERE idPesananPenjualan = ?";
                        PreparedStatement preparedStatement = con.prepareStatement(updateQuery);
                        preparedStatement.setInt(1, jumBaru);
                        preparedStatement.setDouble(2, harga);
                        preparedStatement.setInt(3, idPesananPJual);

                        int rowupdated = preparedStatement.executeUpdate();

                        if (rowupdated > 0) {
                            System.out.println("Update berhasil");
                        } else {
                            System.out.println("Update gagal");
                        }
                        state.close();
                        result.close();
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    System.out.println("Gagal update jumlah item");
                }
            } else {
                JOptionPane.showMessageDialog(null, "jumlah item tidak bisa kurang dari 0");
            }

        }
    }//GEN-LAST:event_updateItemTRActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_myButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.MyButton aksiPencarianTRbeli;
    private button.MyButton butBuyDeal;
    private button.MyButton butBuyPesan;
    private javax.swing.JButton butConfirmTRJual;
    private button.MyButton butDafItem;
    private button.MyButton butDash;
    private button.MyButton butHapusPesan;
    private button.MyButton butHapusPesananJual;
    private button.MyButton butKonfirmTransaksiBeli;
    private button.MyButton butLaporan;
    private button.MyButton butPelanggan;
    private button.MyButton butSales;
    private button.MyButton butSel;
    private button.MyButton butSellDeal;
    private button.MyButton butSupplier;
    private button.MyButton butTambahPesan;
    private button.MyButton butTambahPesananJual;
    private button.MyButton butUser;
    private keeptoo.KGradientPanel dashboard;
    private button.MyButton delAdminTrBeli;
    private button.MyButton delOnlyAdmin;
    private javax.swing.JTextField inputanIDP;
    private javax.swing.JPanel isiKeteranganUser;
    private javax.swing.JComboBox<String> itemPesan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jumPesanJual;
    private javax.swing.JTextField jumlahBar;
    private javax.swing.JTextField kodeItemJual;
    private javax.swing.JComboBox<String> listSuplier;
    private button.MyButton logOut;
    private button.MyButton myButton1;
    private javax.swing.JTextField namaBuyer;
    private javax.swing.JTextField nameSuplier;
    private javax.swing.JTextField noPesan;
    private javax.swing.JTextField noPesanJual;
    private javax.swing.JComboBox<String> noPesananJual;
    private javax.swing.JTextField noTransaksiJual;
    private javax.swing.JTextField nomorTransaksiBeli;
    private javax.swing.JPanel panelIsi;
    private keeptoo.KGradientPanel panelKeteranganUser;
    private javax.swing.JPanel panelMenuMenu;
    private javax.swing.JPanel panelMenuUtama;
    private javax.swing.JComboBox<String> pelangganJual;
    private keeptoo.KGradientPanel pembelian;
    private keeptoo.KGradientPanel penjualan;
    private javax.swing.JTable tabelHistoriPesanan;
    private javax.swing.JTable tabelPesananBeli;
    private javax.swing.JTable tabelPesananPenjualan;
    private javax.swing.JTable tabelTransaksiBeli;
    private com.toedter.calendar.JDateChooser tglPesan;
    private com.toedter.calendar.JDateChooser tglPesananJual;
    private javax.swing.JTextField totHargaJual;
    private keeptoo.KGradientPanel trBeli;
    private keeptoo.KGradientPanel trJual;
    private button.MyButton updateItemTR;
    private javax.swing.JLabel workerJabatan;
    private javax.swing.JLabel workerNama;
    private javax.swing.JLabel workerNomor;
    // End of variables declaration//GEN-END:variables
}
