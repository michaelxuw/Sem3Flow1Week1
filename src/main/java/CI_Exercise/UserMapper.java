package CI_Exercise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    static ConnectionPool connectionPool;

    public UserMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public List<String> getNamesOfAllUsers() throws SQLException, ClassNotFoundException {
        List<User> users = getAllUsers();
        List<String> names = new ArrayList<>();

        for (User user : users) {
            names.add(user.fname+" "+user.lname);
        }
        return names;
    }
    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM `startcode_test`.`usertable` order by `fname`;";
        Connection connection = connectionPool.getConnection();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String pw = rs.getString("pw");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                int id = rs.getInt("id");

                User user = new User(fname,lname,pw,phone,address,id);
                users.add(user);
            }
        }
        return users;
    }

}
