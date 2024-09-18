package vn.iotstar.configs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectSQL {
	private final String serverName = "ADMIN-PC\\SQLEXPRESS";


	 private final String dbName = "ltwebst5";

	 private final String portNumber = "1433";

	 private final String userID = "sa";

	 private final String password = "Quyen_1501";

	 public Connection getConnection() throws Exception {

	 String url = "jdbc:sqlserver://" + serverName + ";databaseName=" + dbName;

	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

	 return DriverManager.getConnection(url,userID, password);
	 }

	 public static void main(String[] args) {

		 try {


		 System.out.println(new DBConnectSQL().getConnection());

		 } catch (Exception e) {

		 e.printStackTrace();


		 }

		 }

	 }


