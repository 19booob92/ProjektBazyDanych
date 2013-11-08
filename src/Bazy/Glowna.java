package Bazy;

import java.awt.EventQueue;
import java.sql.SQLException;

public class Glowna {

	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new OknoLogowania();
			}
		});
	}
	
}
