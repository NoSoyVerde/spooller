package net.ausiasmarch.connection;

public class DatabaseParameters {
    private static final String dbUrl="jdbc:mysql://localhost:3306/spooller?serverTimezone=UTC";
    private static final String dbUser="root";
    private static final String dbPassword="tiger";

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

}