package net.ausiasmarch.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class HikariConfiguration {

    private static HikariDataSource webappPool;
    static {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(DatabaseParameters.getDbUrl());
        config.setUsername(DatabaseParameters.getDbUser());
        config.setPassword(DatabaseParameters.getDbPassword());
        config.setMaximumPoolSize(10); // Máximo de conexiones
        config.setMinimumIdle(2); // Conexiones mínimas inactivas
        config.setIdleTimeout(30000); // Tiempo de espera antes de liberar conexiones inactivas (30s)
        config.setConnectionTimeout(30000); // Tiempo máximo de espera para obtener una conexión (30s)
        config.setPoolName("MiHikariPool"); // Nombre de la pool (opcional, útil para debug)

        webappPool = new HikariDataSource(config);
    }

    public static DataSource getPool() {
        return webappPool;
    }

    public static void closePool() {
        if (webappPool != null && !webappPool.isClosed()) {
            webappPool.close();
        }
    }

    public static Connection getConnection() throws SQLException {
        return webappPool.getConnection();
    }

}
