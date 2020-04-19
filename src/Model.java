import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class Model {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/kontak";
    static final String USER = "root";
    static final String PASS = "";
    Connection connection;
    Statement statement;

    public Model() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void insert(String no_hp, String nama, String umur, String email){
        try {
            String query = "INSERT INTO `user`(`no_hp`, `nama`, `umur`, `email`) " +
                    "VALUES ('"+no_hp+"','"+nama+"','"+umur+"','"+email+"')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String[][] read(){
        try {
            int jmlData = 0;
            String data[][] = new String[getBanyakData()][4];
            String query = "SELECT * FROM `user`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("no_hp");
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("umur");
                data[jmlData][3] = resultSet.getString("email");
                jmlData++;
            }
            return data;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<String> readNo_hp(){
        try {
            ArrayList<String> data = new ArrayList<>();
            String query = "Select * from`user`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data.add(resultSet.getString("no_hp"));
            }
            return data;
        } catch (SQLException e) {
            return null;
        }
    }

    public int getBanyakData(){
        try {
            int jmlData = 0;
            String query = "SELECT * FROM `user`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e) {
            return 0;
        }
    }

    public void delete(String no_hp){
        try {
            String query = "DELETE FROM `user` WHERE `no_hp` = '"+no_hp+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void update(String no_hp, String nama, String umur, String email){
        try {
            String query = "UPDATE `user` SET `email`='" + email + "',`umur`='" + umur + "',`nama`='" + nama + "' WHERE `no_hp` = '" + no_hp + "'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}