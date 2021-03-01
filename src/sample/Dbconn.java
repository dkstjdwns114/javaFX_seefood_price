package sample;

import java.sql.*;

public class Dbconn {
    private static Connection dbConn;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mariadb://127.0.0.1:3306/seafood";
        String user = "root";
        String pw = "1234";
        Class.forName("org.mariadb.jdbc.Driver");
        dbConn = DriverManager.getConnection(url, user, pw);

        return dbConn;
    }

    public static void close(Connection dbConn, PreparedStatement pstmt) throws SQLException {
        if(pstmt != null) pstmt.close();
        if(dbConn != null) dbConn.close();
    }

    public static void close(Connection dbConn, PreparedStatement pstmt, ResultSet rs) throws SQLException {
        if(pstmt != null) pstmt.close();
        if(dbConn != null) dbConn.close();
        if(rs != null) rs.close();
    }
}
