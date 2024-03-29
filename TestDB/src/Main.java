import java.sql.*;

public class Main {
    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Administrator\\Desktop\\Antonio\\Java\\TestDB\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
                    "(" + COLUMN_NAME + " TEXT," +
                    COLUMN_PHONE + " INTEGER," +
                    COLUMN_EMAIL + " TEXT)");

            insertContact(statement,"Joe",123465,"joe@mail.com");
            insertContact(statement,"Tim",789465,"tim@mail.com");
            insertContact(statement,"Jane",174258,"jane@mail.com");
            insertContact(statement,"Ann",195357,"ann@mail.com");

            statement.execute("SELECT * FROM " + TABLE_CONTACTS);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(COLUMN_NAME) + " " +
                        resultSet.getInt(COLUMN_PHONE) + " " +
                        resultSet.getString(COLUMN_EMAIL));
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void insertContact(Statement statement, String name, int phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + TABLE_CONTACTS +
                "(" + COLUMN_NAME + "," + COLUMN_PHONE + "," + COLUMN_EMAIL + ") " +
                "VALUES('"+ name + "'," + phone + ",'"  +email+"')");
    }
}
