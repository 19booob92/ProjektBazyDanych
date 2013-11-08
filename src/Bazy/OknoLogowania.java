package Bazy;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class OknoLogowania extends JFrame implements KeyListener{
	final JButton loguj;
	final JTextField login;
	final JPasswordField haslo;
	final Polaczenie nowePolaczenie = new Polaczenie(this);
	
	public OknoLogowania() {
		super("Logowanie");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 100);
		setLocationRelativeTo(null);
		
		setLayout(new FlowLayout());
		
		login = new JTextField("podaj login");
		haslo = new JPasswordField("podaj haslo");
		loguj = new JButton("Logouj"); 
		
		add(login);
		add(haslo);
		add(loguj);
		
		haslo.addKeyListener(this);
		
		loguj.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				nowePolaczenie.uzupelnij(login.getText(), haslo.getText());
			}
		});
	}
	@Override
	public void keyPressed(KeyEvent e) {	
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			nowePolaczenie.uzupelnij(login.getText(), haslo.getText());
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
}
