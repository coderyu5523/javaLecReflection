package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getInstance(){
        String username = "root";
        String password = "1234";
        String url = "jdbc:mariadb://localhost:3306/usertest1";

        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("DB 연결 완료");
            return conn ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
