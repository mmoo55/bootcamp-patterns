package mysqlsingleton;

public class MySQLSingletonMain {

    public static void main(String[]arg) {
        MySQLConnect connect = MySQLConnect.getClient();

        MySQLConnect connect1 = MySQLConnect.getClient();

        MySQLConnect connect2 = MySQLConnect.getClient();

    }
}
