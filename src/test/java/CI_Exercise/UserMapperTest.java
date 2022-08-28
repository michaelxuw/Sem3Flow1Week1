package CI_Exercise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {
    ConnectionPool connectionPool;

    @BeforeEach
    void setUp() {
        System.out.println("TESTINNNNGGGG");
        connectionPool = new ConnectionPool();
        Connection con = null;
        try {
            con = connectionPool.getConnection();
            String dropTable = "DROP TABLE IF EXISTS `startcode_test`.`usertable`;";
            con.prepareStatement(dropTable).executeUpdate();
            String createTable = "CREATE TABLE IF NOT EXISTS `startcode_test`.`usertable` \n" +
                    "  (`id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `fname` VARCHAR(45) NULL,\n" +
                    "  `lname` VARCHAR(45) NULL,\n" +
                    "  `pw` VARCHAR(45) NULL,\n" +
                    "  `phone` VARCHAR(45) NULL,\n" +
                    "  `address` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            con.prepareStatement(createTable).executeUpdate();
            con.prepareStatement("DELETE FROM `startcode_test`.`usertable`").executeUpdate();

            String SQL = "INSERT INTO startcode_test.usertable (fname, lname, pw, phone, address) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Hans");
            ps.setString(2, "Hansen");
            ps.setString(3, "Hemmelig123");
            ps.setString(4, "40404040");
            ps.setString(5,"Rolighedsvej 3");
            ps.executeUpdate();
            SQL = "INSERT INTO startcode_test.usertable (fname, lname, pw, phone, address) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Jesper");
            ps.setString(2, "Jensen");
            ps.setString(3, "j123");
            ps.setString(4, "80808080");
            ps.setString(5,"Lysvej 3");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getNamesOfAllUsers() throws SQLException, ClassNotFoundException {
        UserMapper userMapper = new UserMapper(connectionPool);
        List<String> names = userMapper.getNamesOfAllUsers();

        List<String> expected = new ArrayList<>();
        expected.add("Hans Hansen");
        expected.add("Jesper Jensen");
        System.out.println("names is: "+names+"\nand expected is: "+expected);
        assertEquals(expected.get(0), names.get(0));
        assertEquals(expected.get(1), names.get(1));
        assertEquals(expected, names);
    }
    @Test
    void getAllUsers() throws SQLException, ClassNotFoundException {
        UserMapper userMapper = new UserMapper(connectionPool);
        List<User> users = userMapper.getAllUsers();

        assertEquals(users.size(),2);
        System.out.println("users.size() is: "+users.size());
    }


}