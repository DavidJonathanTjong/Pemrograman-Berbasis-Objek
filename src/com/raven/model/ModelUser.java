package com.raven.model;

public class ModelUser {

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public ModelUser(int userID, String userName, String email, String password, String verifyCode) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.verifyCode = verifyCode;
    }

    public ModelUser(int userID, String userName, String email, String password) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public ModelUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public ModelUser(String userName, String password, boolean acces1, boolean acces2,
            boolean acces3, boolean acces4, boolean acces5, boolean acces6, boolean acces7, boolean acces8, boolean acces9,
            boolean acces10, String noP, String namP, String noTelp, String alm, String posb) {
        this.userName = userName;
        this.password = password;
        cek1 = acces1;
        cek2 = acces2;
        cek3 = acces3;
        cek4 = acces4;
        cek5 = acces5;
        cek6 = acces6;
        cek7 = acces7;
        cek8 = acces8;
        cek9 = acces9;
        cek10 = acces10;
        noPegawai = noP;
        namaPegawai = namP;
        this.noTelp = noTelp;
        alamatPegawai = alm;
        posisiPegawai = posb;
    }

    public boolean isCek1() {
        return cek1;
    }

    public boolean isCek2() {
        return cek2;
    }

    public boolean isCek3() {
        return cek3;
    }

    public boolean isCek4() {
        return cek4;
    }

    public boolean isCek5() {
        return cek5;
    }

    public boolean isCek6() {
        return cek6;
    }

    public boolean isCek7() {
        return cek7;
    }

    public boolean isCek8() {
        return cek8;
    }

    public boolean isCek9() {
        return cek9;
    }

    public boolean isCek10() {
        return cek10;
    }
    
    public String getNamaPegawai() {
        return namaPegawai;
    }

    public String getNoPegawai() {
        return noPegawai;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getAlamatPegawai() {
        return alamatPegawai;
    }

    public String getPosisiPegawai() {
        return posisiPegawai;
    }

    public ModelUser() {
    }

    private int userID;
    private String userName;
    private String email;
    private String password;
    private String verifyCode;
    
    private String namaPegawai;
    private String noPegawai;
    private String noTelp;
    private String alamatPegawai;
    private String posisiPegawai;
    private boolean cek1;
    private boolean cek2;
    private boolean cek3;
    private boolean cek4;
    private boolean cek5;
    private boolean cek6;
    private boolean cek7;
    private boolean cek8;
    private boolean cek9;
    private boolean cek10;

}
