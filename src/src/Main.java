import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try(Connection conn = ConnectionFactory.getConnection()){
            System.out.println("Connected");
            while(true){
                System.out.println("------Users Manager------");
                System.out.println("1- Add user");
                System.out.println("2- Update user by id");
                System.out.println("3- Delete user by id");
                System.out.println("4- Show all users");
                System.out.println("5- Close program");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch(choice){
                    case 1:
                        UserService.addUser(conn, scanner);
                        break;
                    case 2:
                        UserService.updateUser(conn, scanner);
                        break;
                    case 3:
                        UserService.deleteUser(conn, scanner);
                        break;
                    case 4:
                        UserService.showusers(conn);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("This option doesnt exist");
                }
            }
        }   catch (SQLException e){
            e.printStackTrace();
        }
    }
}
