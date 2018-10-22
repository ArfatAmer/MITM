package com.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextField;

public class HackedDB extends JFrame {

	private JPanel contentPane;
	
	static String Hacker;

	static String Hacked;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HackedDB frame = new HackedDB(Hacker,Hacked);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HackedDB(String Hacker,String Hacked) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,800,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TextField textField = new TextField("Hacker Port Number:"+Hacker+"\t\t\t\t"+"Hacked Port Number:"+Hacked);
		textField.setBounds(38, 40, 717, 677);
		contentPane.add(textField);
	}

}
