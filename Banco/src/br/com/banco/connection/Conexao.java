package br.com.banco.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
	private static Connection con = null;

	private static void conectar() {
		System.out.println("Conectando ao banco...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/banco", "root", "frsd1075");
			System.out.println("Conectado.");
		} catch (ClassNotFoundException ex) {
			System.out.println("Classe nao encontrada, adicione o driver nas bibliotecas.");
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}

	}
	
	
	public static Connection getConnection() {
		if(con == null) {
			conectar();
		}
		return con;
	}
	
	public static void main(String[] args) {
		Conexao.conectar();
	}
}