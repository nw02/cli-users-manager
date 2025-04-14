import java.sql.*;
import java.util.Scanner;

public class UserService {
    public static void addUser(Connection c, Scanner scanner) throws SQLException {
        System.out.println("Type name and age:");
        String sql = "INSERT INTO users (name, age) VALUES (?,?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, scanner.nextLine());
        ps.setInt(2, scanner.nextInt());
        int rows = ps.executeUpdate();
        if(rows >0){
            System.out.println("User added");
        }
    }

    public static void updateUser(Connection c, Scanner scanner) throws SQLException {
        System.out.println("Type the id:");
        int id = scanner.nextInt();
        String sql = "SELECT * FROM users WHERE id = "+ id;
        Statement statement = c.createStatement();
        ResultSet result = statement.executeQuery(sql);
        if(result.next()) {
            System.out.println(result.getString("name") + ", " + result.getString("age") + "years");
        }else{
            System.out.println("This Id doesnt exist");
            return;
        }
        scanner.nextLine();

        System.out.println("Type name, age:");
        sql = "UPDATE users SET name = ?, age = ? WHERE id = "+id;
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, scanner.nextLine());
        ps.setInt(2, scanner.nextInt());
        ps.executeUpdate();
    }

    public static void deleteUser(Connection c, Scanner scanner) throws SQLException {
        System.out.println("Type the id:");
        int id = scanner.nextInt();
        String sql = "DELETE FROM users WHERE id = "+ id;
        PreparedStatement ps = c.prepareStatement(sql);
        int rows = ps.executeUpdate();
        if(rows > 0){
            System.out.println("User deleted");
        }else{
            System.out.println("This Id doesnt exist");
        }
    }

    public static void showusers(Connection c) throws SQLException {
        String sql = "SELECT * FROM users";
        Statement statement = c.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while(result.next()){
            System.out.println(result.getString("name")+",\n"+result.getString("age"));
        }
    }
}
