package Helpers;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private Connection connection = null;
    public Connection ConnectToDb()
    {
        try  {
            Class.forName("org.postgresql.Driver");
            if(this.connection == null)
            {
                 this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"postgres","postgres","1832003");
                 return this.connection;
            }
            return this.connection;
        }catch (Exception e){
                throw new RuntimeException(e);
        }
    }
}
