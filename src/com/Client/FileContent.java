package com.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FileContent extends JFrame {

	private JPanel contentPane;
	private JTextField SKey;;
	static String FContent;
	static String HHContent;
	static String HContent;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileContent frame = new FileContent(FContent,HContent);
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
	public FileContent(final String FContent,final String HContent) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,600,600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JButton btnEnterSecretKey = new JButton("Enter Secret Key");
		btnEnterSecretKey.setBackground(new Color(240, 248, 255));
		btnEnterSecretKey.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
		btnEnterSecretKey.setBounds(88, 404, 187, 25);
		contentPane.add(btnEnterSecretKey);
		
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjnw08@2016","root","admin");
			
			PreparedStatement ps=(PreparedStatement)con.prepareStatement("SELECT * FROM shareddata where IPAddress='"+HContent+"'");
		
			ResultSet rs=(ResultSet)ps.executeQuery();
			
			while(rs.next())
			{
				HHContent=rs.getString(3);
				System.out.println(HContent);
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		TextField textField = new TextField(HHContent);
		textField.setBounds(58, 116, 472, 244);
		contentPane.add(textField);
		
		
		
		SKey = new JTextField();
		
		SKey.setBounds(294, 404, 224, 22);
		contentPane.add(SKey);
		SKey.setColumns(10);
		
		JButton btnNewButton = new JButton("Get Original Content");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Wrong Secret Key");
				JOptionPane.showMessageDialog(null,"Un AuthoriazedAccess");
				
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjnw08@2016","root","admin");
					
					PreparedStatement ps=(PreparedStatement)con.prepareStatement("INSERT INTO hacking VALUES('"+FContent+"','"+HContent+"')");
					
					int i=ps.executeUpdate();
					
					if(i==1)
					{
						JOptionPane.showMessageDialog(null, "Account Tracked");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Account  Tracking Failed");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				
			
			
			}
		});
		btnNewButton.setBounds(193, 465, 153, 25);
		contentPane.add(btnNewButton);
	}
}
