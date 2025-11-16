package OdevOnİki;

import java.sql.*;

public class LocalDbExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/elif_db";
        String user = "root";
        String password = "12345";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Bağlantı başarılı!");

            // INSERT
            String insertSql = "INSERT INTO elif_daglaroglu (ad, soyad, departman) VALUES (?, ?, ?)";
            PreparedStatement insertPS = conn.prepareStatement(insertSql);
            insertPS.setString(1, "Ahmet");
            insertPS.setString(2, "Yılmaz");
            insertPS.setString(3, "QA");
            insertPS.executeUpdate();
            System.out.println("Insert");


            insertPS.setString(1, "Ayşe");
            insertPS.setString(2, "Demir");
            insertPS.setString(3, "Developer");
            insertPS.executeUpdate();


            insertPS.setString(1, "Mehmet");
            insertPS.setString(2, "Kara");
            insertPS.setString(3, "DevOps");
            insertPS.executeUpdate();

            // SELECT
            String selectSql = "SELECT * FROM elif_daglaroglu";
            PreparedStatement selectPS = conn.prepareStatement(selectSql);
            ResultSet rs = selectPS.executeQuery();
            System.out.println("Kayıtlar:");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " +
                        rs.getString("ad") + " " + rs.getString("soyad") +
                        " (" + rs.getString("departman") + ")");
            }

            // DELETE
            String deleteSql = "DELETE FROM elif_daglaroglu WHERE id = ?";
            PreparedStatement deletePS = conn.prepareStatement(deleteSql);
            deletePS.setInt(1, 1);
            deletePS.executeUpdate();
            System.out.println("Delete tamam!");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
