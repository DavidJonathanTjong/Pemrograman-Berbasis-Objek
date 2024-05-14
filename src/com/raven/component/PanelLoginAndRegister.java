package com.raven.component;

import com.raven.model.ModelLogin;
import com.raven.model.ModelUser;
import com.raven.swing.Button;
import com.raven.swing.MyPasswordField;
import com.raven.swing.MyTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    public ModelLogin getDataLogin() {
        return dataLogin;
    }

    public ModelUser getUser() {
        return user;
    }

    private ModelUser user;
    private ModelLogin dataLogin;

    public PanelLoginAndRegister(ActionListener eventRegister, ActionListener eventLogin) {
        initComponents();
        initRegister(eventRegister);
        initLogin(eventLogin);
        login.setVisible(false);
        register.setVisible(true);
    }

    private JCheckBox akses1 = new JCheckBox();
    private JCheckBox akses2 = new JCheckBox();
    private JCheckBox akses3 = new JCheckBox();
    private JCheckBox akses4 = new JCheckBox();
    private JCheckBox akses5 = new JCheckBox();
    private JCheckBox akses6 = new JCheckBox();
    private JCheckBox akses7 = new JCheckBox();
    private JCheckBox akses8 = new JCheckBox();
    private JCheckBox akses9 = new JCheckBox();
    private JCheckBox akses10 = new JCheckBox();
    
    private MyTextField txtUser = new MyTextField();
    private MyPasswordField txtPass = new MyPasswordField();
    private MyTextField txtNoPegawai = new MyTextField();
    private MyTextField txtNama = new MyTextField();
    private MyTextField txtNoTelpon = new MyTextField();
    private MyTextField txtAlamat = new MyTextField();
    private MyTextField txtJabatan = new MyTextField();
    
    private void initRegister(ActionListener eventRegister) {
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        register.add(label);

        
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/user.png")));
        txtUser.setHint("Username");
        register.add(txtUser, "w 60%");
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/pass.png")));
        txtPass.setHint("Password");
        register.add(txtPass, "w 60%");
        
        JPanel panelRegistrasi = new JPanel();
        panelRegistrasi.setLayout(new GridLayout(3, 2, 5, 5));
        panelRegistrasi.setSize(300, 300);
        panelRegistrasi.setBackground(new Color(255, 255, 255));
        panelRegistrasi.setVisible(true);
        register.add(panelRegistrasi, "w 80%, h 100");
        
        
        txtNoPegawai.setHint("Nomor Pegawai");
        txtNama.setHint("Nama");
        txtNoTelpon.setHint("Nomor Telepon");
        txtAlamat.setHint("Alamat");
        txtJabatan.setHint("Bekerja sebagai");
        
        panelRegistrasi.add(txtNoPegawai);
        panelRegistrasi.add(txtNama);
        panelRegistrasi.add(txtNoTelpon);
        panelRegistrasi.add(txtAlamat);
        panelRegistrasi.add(txtJabatan);

        JPanel panelCB = new JPanel();
        panelCB.setLayout(new GridLayout(4, 4, 5, 5));
        panelCB.setSize(300, 300);
        panelCB.setBackground(new Color(255, 255, 255));
        panelCB.setVisible(true);
        register.add(panelCB, "w 30%, h 100");

        akses1.setText("akses_user");
        akses1.setVisible(true);

        akses2.setText("akses_daftaritem");
        akses2.setVisible(true);

        akses3.setText("akses_suplier");
        akses3.setVisible(true);

        akses4.setText("akses_pelanggan");
        akses4.setVisible(true);

        akses5.setText("akses_sales");
        akses5.setVisible(true);

        akses6.setText("akses_settingkas");
        akses6.setVisible(true);

        akses7.setText("akses_pembelian");
        akses7.setVisible(true);

        akses8.setText("akses_penjualan");
        akses8.setVisible(true);

        akses9.setText("akses_laporan");
        akses9.setVisible(true);

        akses10.setText("akses_pemeliharaandata");
        akses10.setVisible(true);
        panelCB.add(akses1);
        panelCB.add(akses2);
        panelCB.add(akses3);
        panelCB.add(akses4);
        panelCB.add(akses5);
        panelCB.add(akses6);
        panelCB.add(akses7);
        panelCB.add(akses8);
        panelCB.add(akses9);
        panelCB.add(akses10);

        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventRegister);
        cmd.setText("SIGN UP");
        register.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String userName = txtUser.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                String nomorPegawai = txtNoPegawai.getText().trim();
                String namaPegawai = txtNama.getText().trim();
                String nomorTelp = txtNoTelpon.getText().trim();
                String alamat = txtAlamat.getText().trim();
                String jabatan = txtJabatan.getText().trim();
                boolean aks1 = akses1.isSelected();
                boolean aks2 = akses2.isSelected();
                boolean aks3 = akses3.isSelected();
                boolean aks4 = akses4.isSelected();
                boolean aks5 = akses5.isSelected();
                boolean aks6 = akses6.isSelected();
                boolean aks7 = akses7.isSelected();
                boolean aks8 = akses8.isSelected();
                boolean aks9 = akses9.isSelected();
                boolean aks10 = akses10.isSelected();
                System.out.println(userName);
                System.out.println(password);
                user = new ModelUser(userName, password,aks1,aks2,aks3,aks4,aks5,aks6,aks7,aks8,aks9,aks10,
                nomorPegawai, namaPegawai, nomorTelp, alamat, jabatan);
            }
        });

    }

    private void initLogin(ActionListener eventLogin) {
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/user.png")));
        txtUser.setHint("Username");
        login.add(txtUser, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/raven/icon/pass.png")));
        txtPass.setHint("Password");
        login.add(txtPass, "w 60%");
        JButton cmdForget = new JButton("Forgot your password ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        Button cmd = new Button();
        cmd.setBackground(new Color(7, 164, 121));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.addActionListener(eventLogin);
        cmd.setText("SIGN IN");
        login.add(cmd, "w 40%, h 40");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String username = txtUser.getText().trim();
                String password = String.valueOf(txtPass.getPassword());
                dataLogin = new ModelLogin(username, password);
            }
        });
    }

    public void showRegister(boolean show) {
        if (show) {
            register.setVisible(true);
            login.setVisible(false);
        } else {
            txtUser.setText("");
            txtPass.setText("");
            txtNoPegawai.setText("");
            txtNama.setText("");
            txtNoTelpon.setText("");
            txtAlamat.setText("");
            txtJabatan.setText("");
            akses1.setSelected(false);
            akses2.setSelected(false);
            akses3.setSelected(false);
            akses4.setSelected(false);
            akses5.setSelected(false);
            akses6.setSelected(false);
            akses7.setSelected(false);
            akses8.setSelected(false);
            akses9.setSelected(false);
            akses10.setSelected(false);
            register.setVisible(false);
            login.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
