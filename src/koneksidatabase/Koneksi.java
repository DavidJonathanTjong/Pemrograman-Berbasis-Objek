package koneksidatabase;

import java.sql.DriverManager;
import java.sql.Connection;

public class Koneksi {
    private static Connection mKoneksi;
    public static Connection createKoneksi() {
        String url = "jdbc:mysql://localhost:3306/manajemen_barangtoko",
                user = "root",
                pass = "";
        if (mKoneksi == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                mKoneksi = DriverManager.getConnection(url, user, pass);
                System.out.println("ok");
            } catch (Exception e) {
                System.out.println("fail");
            }

        }
        return mKoneksi;
    }
}