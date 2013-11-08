package Bazy;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JOptionPane;

public class Polaczenie {
	OknoLogowania oknoLogowania = null;
	private Statement statement = null;
	
	Polaczenie(OknoLogowania a) {
		oknoLogowania = a;
	}
	
	public void uzupelnij(String login, String haslo) {
		System.out.print("");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection polacz = 
				DriverManager.getConnection("jdbc:oracle:thin:@156.17.43.17:1521:orcl",login , haslo);
			
			statement = polacz.createStatement();
			
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					 oknoLogowania.dispose();
					 new OknoGlowne();
					 try {
						 ResultSet doListy = statement.executeQuery("SELECT table_name FROM user_tables");
						 while(doListy.next()) {
							 OknoGlowne.listaTablice.add(doListy.getString(1));
						 }
					 } 
					 catch (Exception e) {
					 }
				}
			});
		} 
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Przykro mi złe hasło :(:/:|");
		}
	}
}
