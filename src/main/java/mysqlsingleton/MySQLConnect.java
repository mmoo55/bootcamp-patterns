package mysqlsingleton;

import java.sql.*;

public class MySQLConnect {
    public static Connection connect;
    public static MySQLConnect instance = null;

    private static final String URL = "jdbc:mysql://localhost/prueba";
    private static final String USERNAME = "prueba";
    private static final String PASSWORD = "123";


    private void OpenMySQLCLient()
    {
        try
        {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexión Exitosa");

        }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println("Error al abrir Conexión: " + ex.getMessage());
        }

    }

    public static MySQLConnect getClient()
    {
        if (instance == null){
            System.out.println("Primera vez");
            instance = new MySQLConnect();
            instance.OpenMySQLCLient();
        }
        else {
            System.out.println("FALLO DE CONEXIÓN");
        }

        return instance;
    }

    public void getData(){
        PreparedStatement statement;
        ResultSet result;

        String query = "SELECT count(id_persona) FROM persona";

        try {
            statement = connect.prepareStatement(query);
            result = statement.executeQuery();

            if (result.next())
            {
                String count = result.getString("count(id_persona)");

                System.out.println("El conteo es: " + count);
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Error al abrir Conexión: " + ex.getMessage());
        }

    }

}
