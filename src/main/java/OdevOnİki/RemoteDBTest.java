package OdevOnİki;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RemoteDBTest {

    public static void main(String[] args) {
        String url = "jdbc:mysql://mysql-daglaroglue-elifdaglaroglu-fcf7.k.aivencloud.com:17913/defaultdb?sslMode=REQUIRED";
        String user = "avnadmin";
        String pass = "AVNS_n0srgKQRA0dJ9EQPvxk";

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Aiven MySQL bağlantısı başarılı!");

            // create table
            String createTable = "CREATE TABLE IF NOT EXISTS elif_daglaroglu_remote ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "ad VARCHAR(50),"
                    + "soyad VARCHAR(50),"
                    + "departman VARCHAR(50))";

            conn.prepareStatement(createTable).execute();
            System.out.println("Remote tablo oluşturuldu.");

            // CREATE
            String insert = "INSERT INTO elif_daglaroglu_remote (ad, soyad, departman) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(insert);

            ps.setString(1, "Elif");
            ps.setString(2, "Dağlaroğlu");
            ps.setString(3, "QA");
            ps.executeUpdate();


            ps.setString(1, "Ayşe");
            ps.setString(2, "Demir");
            ps.setString(3, "Developer");
            ps.executeUpdate();


            ps.setString(1, "Mehmet");
            ps.setString(2, "Kara");
            ps.setString(3, "DevOps");
            ps.executeUpdate();

            System.out.println("Remote tabloya 3 kayıt eklendi.");

            // READ
            String select = "SELECT * FROM elif_daglaroglu_remote";
            ResultSet rs = conn.prepareStatement(select).executeQuery();

            System.out.println("--- Remote Kayıtlar ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                                rs.getString("ad") + " " +
                                rs.getString("soyad") + " / " +
                                rs.getString("departman")
                );
            }

            // UPDATE
            String update = "UPDATE elif_daglaroglu_remote SET departman = ? WHERE ad = ?";
            ps = conn.prepareStatement(update);
            ps.setString(1, "Senior QA");
            ps.setString(2, "Elif");
            ps.executeUpdate();
            System.out.println("Kayıt güncellendi.");

            // DELETE
            String delete = "DELETE FROM elif_daglaroglu_remote WHERE ad = ?";
            ps = conn.prepareStatement(delete);
            ps.setString(1, "Elif");
            ps.executeUpdate();
            System.out.println("Kayıt silindi.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
