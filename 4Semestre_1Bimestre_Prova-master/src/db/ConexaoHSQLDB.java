package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoHSQLDB {

	private String usuario = "SA";
	private String senha = "";
	private String PathBase = "C:\\Users\\wcwil\\Desktop\\4Semestre_1Bimestre_Prova-master\\Dados\\dados";
	private String URL = "jdbc:hsqldb:file:" + PathBase + ";";
	
	public Connection conectar() {
		try {
			return DriverManager.getConnection(URL, usuario, senha);
		} catch (SQLException e) {
			throw new Error("SQLException");
		}
	}
}
