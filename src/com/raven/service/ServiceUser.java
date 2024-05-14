package com.raven.service;

import com.raven.component.Message;
import com.raven.connection.DatabaseConnection;
import com.raven.model.ModelLogin;
import com.raven.model.ModelMessage;
import com.raven.model.ModelUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JOptionPane;

public class ServiceUser {

    private static Connection con;

    public ServiceUser() {
        con = DatabaseConnection.getInstance().getConnection();
    }

    public ModelUser login(ModelLogin login) throws SQLException {
        ModelUser data = null;
        PreparedStatement p = con.prepareStatement("SELECT * FROM pengguna WHERE username = ? AND pass = ?");
        p.setString(1, login.getUsername());
        p.setString(2, login.getPassword());
        ResultSet r = p.executeQuery();
        if (r.first()) {
            String userName = r.getString(1);
            String password = r.getString(2);
            data = new ModelUser(userName, password);
        }
        r.close();
        p.close();
        return data;
    }

    public void insertUser(ModelUser user) throws SQLException {
        String idNomorPegawai = user.getNoPegawai();
        if (!cekKetersediaanNomorPegawai(idNomorPegawai)) {
            try {
                Statement statement = con.createStatement();
                String sqlCek = "SELECT username FROM pengguna";
                ResultSet hasilcek = statement.executeQuery(sqlCek);
                boolean isAda = false;
                while (hasilcek.next()) {
                    if (hasilcek.getString("username").equals(user.getUserName())) {
                        isAda = true;
                    }
                }
                hasilcek.close();
                if (isAda) {
                    JOptionPane.showMessageDialog(null, "username sudah ada");
                } else {
                    //insert detailuser
                    String sql_detailUser = "INSERT INTO detailuser (nomor_pegawai, nama, nomor_telpon, alamat, posisibekerja) VALUES (?, ?, ?, ?, ?)";
                    try {
                        PreparedStatement preparedStatement = con.prepareStatement(sql_detailUser);
                        preparedStatement.setString(1, user.getNoPegawai());
                        preparedStatement.setString(2, user.getNamaPegawai());
                        preparedStatement.setString(3, user.getNoTelp());
                        preparedStatement.setString(4, user.getAlamatPegawai());
                        preparedStatement.setString(5, user.getPosisiPegawai());

                        int cekperubahan = preparedStatement.executeUpdate();

                        if (cekperubahan > 0) {
                            System.out.println("tambah detailUser sukses!");
                        } else {
                            System.out.println("tambah detailUser Failed.");
                        }
                    } catch (SQLException e) {
                        System.out.println("gagal menambah ke tabel detailuser");
                    }
                    //insert akses
                    String sql_akses = "INSERT INTO akses (panelpengguna, daftaritem, suplier, pelanggan, "
                            + "sales, settingkas, panelpembelian, panelpenjualan, panellaporan, panelpemeliharaandata) "
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try {
                        PreparedStatement preparedStatement = con.prepareStatement(sql_akses);
                        preparedStatement.setBoolean(1, user.isCek1());
                        preparedStatement.setBoolean(2, user.isCek2());
                        preparedStatement.setBoolean(3, user.isCek3());
                        preparedStatement.setBoolean(4, user.isCek4());
                        preparedStatement.setBoolean(5, user.isCek5());
                        preparedStatement.setBoolean(6, user.isCek6());
                        preparedStatement.setBoolean(7, user.isCek7());
                        preparedStatement.setBoolean(8, user.isCek8());
                        preparedStatement.setBoolean(9, user.isCek9());
                        preparedStatement.setBoolean(10, user.isCek10());

                        int cekperubahan = preparedStatement.executeUpdate();

                        if (cekperubahan > 0) {
                            System.out.println("tambah Akses sukses!");
                        } else {
                            System.out.println("tambah Akses Failed.");
                        }
                    } catch (SQLException e) {
                        System.out.println("gagal menambah ke tabel akses");
                    }
                    //insert pengguna
                    String query = "INSERT INTO pengguna (username, pass, nomor_pegawai, detail_akses) VALUES (?, ?, ?, ?)";

                    try {
                        PreparedStatement preparedStatement = con.prepareStatement(query);
                        preparedStatement.setString(1, user.getUserName());
                        preparedStatement.setString(2, user.getPassword());
                        preparedStatement.setString(3, idNomorPegawai);

                        String queryAmbil = "SELECT MAX(id_akses) FROM akses";
                        ResultSet hasilambil = statement.executeQuery(queryAmbil);
                        int id_akses;
                        if (hasilambil.next()) {
                            id_akses = hasilambil.getInt(1);
                            preparedStatement.setInt(4, id_akses);
                        }
                        int cekperubahan = preparedStatement.executeUpdate();

                        if (cekperubahan > 0) {
                            System.out.println("tambah ke tabel pengguna berhasil");
                        } else {
                            System.out.println("gagal menambahkan ke tabel pengguna.");
                        }
                    } catch (SQLException e) {
                        System.out.println("gagal menambahkan user baru");
                    }

                    statement.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex + "ini eror");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nomor pegawai telah ada");
        }

    }

    public boolean cekKetersediaanNomorPegawai(String value) {
        boolean cek = false;
        try {
            Statement statement = con.createStatement();
            String sqlCek = "SELECT nomor_pegawai FROM `detailuser`";
            ResultSet hasilcek = statement.executeQuery(sqlCek);
            while (hasilcek.next()) {
                if (hasilcek.getString("nomor_pegawai").equals(value)) {
                    cek = true;
                }
            }
            hasilcek.close();
        } catch (SQLException e) {
            System.out.println("gagal cek nomor pegawai");
        }
        return cek;
    }

    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));  //  Random from 0 to 999999
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }

    private boolean checkDuplicateCode(String code) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = con.prepareStatement("select UserID from `user` where VerifyCode=? limit 1");
        p.setString(1, code);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public boolean checkDuplicateUser(String value) throws SQLException {
        boolean cek = false;
        try {
            Statement statement = con.createStatement();
            String sqlCek = "SELECT nomor_pegawai FROM `detailuser`";
            ResultSet hasilcek = statement.executeQuery(sqlCek);
            while (hasilcek.next()) {
                if (hasilcek.getString("nomor_pegawai").equals(value)) {
                    cek = true;
                }
            }
            hasilcek.close();
        } catch (SQLException e) {
            System.out.println("gagal cek nomor pegawai");
        }
        return cek;
    }

    public boolean checkDuplicateUsername(String user) throws SQLException {
        Statement statement = con.createStatement();
        String sqlCek = "SELECT username FROM pengguna";
        ResultSet hasilcek = statement.executeQuery(sqlCek);
        boolean isAda = false;
        while (hasilcek.next()) {
            if (hasilcek.getString("username").equals(user)) {
                isAda = true;
            }
        }
        hasilcek.close();
        return isAda;
    }

    public void doneVerify(int userID) throws SQLException {
        PreparedStatement p = con.prepareStatement("update `user` set VerifyCode='', `Status`='Verified' where UserID=? limit 1");
        p.setInt(1, userID);
        p.execute();
        p.close();
    }

    public boolean verifyCodeWithUser(int userID, String code) throws SQLException {
        boolean verify = false;
        PreparedStatement p = con.prepareStatement("select UserID from `user` where UserID=? and VerifyCode=? limit 1");
        p.setInt(1, userID);
        p.setString(2, code);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            verify = true;
        }
        r.close();
        p.close();
        return verify;
    }
}
