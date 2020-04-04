package project.database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author chenhuiz
 */
public interface Database {
    void init() throws SQLException;
    Connection getConnection() throws SQLException;
}
