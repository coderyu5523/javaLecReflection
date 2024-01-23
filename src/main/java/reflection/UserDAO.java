package reflection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public int insert(String username, String password, String phone) {
        Connection conn = DBConnection.getInstance();

        try {
            String sql = "insert into user_tb(username,password,phone) values(?,?,?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, phone);

            int num = pstmt.executeUpdate();
            return num;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int delete(int number) {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "delete from user_tb where number = ? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);
            int num = pstmt.executeUpdate();  // flush 코드
            return num;
        } catch (Exception e) {
            e.printStackTrace();  //throw new RuntimeException(e); 이거는 오류를 메인에 던짐

        }
        return -1;  // 오류값을
    }


    public int update(String password,String phone, int number) {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "UPDATE user_tb set password = ? ,phone = ? WHERE number =?  ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setString(2,phone);
            pstmt.setInt(3, number);
            int num = pstmt.executeUpdate();  // flush 코드
            return num;
        } catch (Exception e) {
            e.printStackTrace();  //throw new RuntimeException(e); 이거는 오류를 메인에 던짐

        }
        return -1;  // 오류값을

    }

    public User selectByNumber(int number){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from user_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);

            ResultSet rs = pstmt.executeQuery();

            boolean isRow = rs.next(); // 커서 한칸 내리기

            if(isRow){
                User user = new User(

                        rs.getInt("number"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("phone")
                );
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<User> selectAll(){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from user_tb order by number desc";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            List<User> userList = new ArrayList<>();
            while(rs.next()){
                User user = new User(
                        rs.getInt("number"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("phone")
                );
                userList.add(user);
            }
            return userList;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



}