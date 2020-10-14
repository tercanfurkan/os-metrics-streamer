package fi.tercanfurkan.os.metrics.consumer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static fi.tercanfurkan.os.metrics.consumer.ConsumerApp.CERTS_PATH;

public class DbConnect {

    private static String JDBC_URL = System.getProperty("postgres.jdbc.url");
    private static String DB_USER = System.getProperty("postgres.db.user");
    private static String DB_PASSWORD = System.getProperty("postgres.db.password");

    private final Connection connection;

    public DbConnect() {
        connection = createConnection();
    }

    public static Connection createConnection() {
        Properties props = new Properties();

        props.put("jdbc.url", JDBC_URL);
        props.put("user", DB_USER);
        props.put("password", DB_PASSWORD);
        props.put("ssl", "true");
        props.put("sslmode", "verify-ca");
        props.put("sslrootcert", CERTS_PATH + "/jdbc_ca.pem");

        final Connection connection;
        try {
            connection = DriverManager.getConnection(props.getProperty("jdbc.url"), props);
            System.out.println("Success");
            return connection;
        } catch (Exception e) {
            System.out.println("getConnection failed");
            e.printStackTrace();
        }
        return null;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
