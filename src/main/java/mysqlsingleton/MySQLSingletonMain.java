package mysqlsingleton;

public class MySQLSingletonMain {

    public static void main(String[]arg) {
        MySQLConnect connect = MySQLConnect.getClient();
        connect.getData();

        MySQLConnect connect1 = MySQLConnect.getClient();
        connect1.getData();

        MySQLConnect connect2 = MySQLConnect.getClient();
        connect2.getData();

    }
}
