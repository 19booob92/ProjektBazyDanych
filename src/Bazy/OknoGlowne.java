package Bazy;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

public class OknoGlowne extends JFrame{
	static String tablica = "";
	static Choice listaTablice = null;
	
	public OknoGlowne() {
		super("Biblioteka");
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,400);
		setLocationRelativeTo(null);
		
		setLayout(new FlowLayout());
		
		JTable tabela = new JTable(5, 5);
		JButton przycisk = new JButton("Wykonaj");
		JTextField poleTekstowe = new JTextField("wpisz swoje zapytanie");
		listaTablice = new Choice();
		
		listaTablice.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				tablica = listaTablice.getSelectedItem();
			}
		});
		
		add(poleTekstowe);
		add(listaTablice);
		add(przycisk);
		add(tabela);
	}
}
