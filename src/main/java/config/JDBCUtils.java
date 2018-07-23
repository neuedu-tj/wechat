package config;

import java.sql.Connection;
import java.sql.DriverManager;


public class JDBCUtils {

	private Connection conn;

	public Connection openConnection() {
		try {
			Class.forName(AppConfig.DRIVER);
			conn = DriverManager.getConnection(AppConfig.URL, AppConfig.NAME, AppConfig.PWD);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}


}
