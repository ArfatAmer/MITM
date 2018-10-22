package com.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.DBConnection.DBConnection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServerLogin extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerLogin frame = new ServerLogin();
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
	public ServerLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,800,800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-12, 0, 794, 92);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblServerAuthentication = new JLabel("Server Authentication");
		lblServerAuthentication.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblServerAuthentication.setForeground(new Color(138, 43, 226));
		lblServerAuthentication.setBounds(308, 26, 208, 34);
		panel.add(lblServerAuthentication);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(255, 0, 255));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(358, 64, 75, 25);
		panel.add(lblLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 661, 782, 92);
		contentPane.add(panel_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setBounds(246, 175, 66, 36);
		contentPane.add(lblName);
		
		Name = new JTextField();
		Name.setBounds(313, 175, 203, 30);
		contentPane.add(Name);
		Name.setColumns(10);
		
		Password = new JPasswordField();
		Password.setColumns(10);
		Password.setBounds(313, 256, 203, 30);
		contentPane.add(Password);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(214, 250, 87, 36);
		contentPane.add(lblPassword);
		
		JButton btnAuthenticate = new JButton("Authenticate");
		btnAuthenticate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name=Name.getText();
				String pass=Password.getText();
				
				
				try{
				DBConnection db=new DBConnection();
				
				Connection con=(Connection)db.con();
				
				
				PreparedStatement ps=(PreparedStatement)con.prepareStatement("SELECT * FROM serverregister s where Name='"+name+"'  && ServerPassword='"+pass+"'  ;");
				
				
				ResultSet rs=(ResultSet)ps.executeQuery();
				
				
				boolean ss=rs.next();
				
				if(ss==true)
				{
					JOptionPane.showMessageDialog(null, "You are  Valid Server");
					ServerAuthentication sa=new ServerAuthentication();
					sa.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You are Not Valid Server");
				}
				
				
				}
				catch(Exception re)
				{
					re.printStackTrace();
				}
			}
		});
		btnAuthenticate.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		btnAuthenticate.setForeground(new Color(0, 206, 209));
		btnAuthenticate.setBounds(322, 362, 155, 25);
		contentPane.add(btnAuthenticate);
		
		
		
	}
}
