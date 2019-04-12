package topica.edu.BTVN.BTVN_Bai14_Hoangnv2;
import java.sql.*;

public class TestConnectDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/user";// your db name
            String user="root"; // your db username
            String password=""; // your db password
            Connection conn = DriverManager.getConnection(url, user, password);
            if(conn != null){
                System.out.println("Connect success!");
            }

            String sql = "CALL GetName()";
            CallableStatement statement = conn.prepareCall(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)
                        +"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showResutl(ResultSet resultSet) throws SQLException {
        System.out.printf("ID", "TEN", "KHOAHOC");
        while (resultSet.next()){
            int id = resultSet.getInt("ID");
            String name = resultSet.getString("Ten");
            String course = resultSet.getString("Khoahoc");

            System.out.printf("%-10d%-20s%-20s%-30s\n", id, name, course);
        }
    }
}

