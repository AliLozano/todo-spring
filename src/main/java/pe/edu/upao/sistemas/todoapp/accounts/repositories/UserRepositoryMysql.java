package pe.edu.upao.sistemas.todoapp.accounts.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pe.edu.upao.sistemas.todoapp.accounts.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Service
@Profile("mysql")
public class UserRepositoryMysql implements IUserRepository {
    class UserTable {
        static int COLUMN_ID=1;
        static int COLUMN_USERNAME=2;
        static int COLUMN_PASSWORD=3;
    }
    @Override
    public List<User> list()  {
        try {
            List<User> users = new ArrayList<>();

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoapp", "root", "");
            try(conn) {
                Statement stmt = conn.createStatement();
                try(stmt) {
                    try (ResultSet r = stmt.executeQuery("SELECT id, username, password FROM USER"); r) {
                        while (r.next()) {
                            User user = new User();
                            user.id = r.getInt(UserTable.COLUMN_ID);
                            user.username = r.getString(UserTable.COLUMN_USERNAME);
                            user.password = r.getString(UserTable.COLUMN_PASSWORD);
                            users.add(user);
                        }
                    }
                }
            }

            return users;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public User create(User user) {
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todoapp", "root", "");

        Statement stmt = conn.createStatement();
        ResultSet r = stmt.executeQuery("SELECT id, username, password FROM USER");
        while(r.next()) {
            System.out.println("ID: " + r.getInt(1));
            System.out.println("Username: " + r.getString(2));
            System.out.println("Password: " + r.getString(3));
        }
        r.close();

        stmt.close();
        conn.close();
    }
}
