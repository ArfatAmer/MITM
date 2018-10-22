package com.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JPasswordField password;
	private JTextField uname;
	 Socket socket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,800,800);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(138, 43, 226));
		contentPane.setBackground(new Color(138, 43, 226));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(188, 143, 143));
		panel.setBounds(0, 0, 782, 23);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 255));
		panel_1.setBounds(0, 23, 782, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLoginForm = new JLabel("Registration Form");
		lblLoginForm.setForeground(new Color(138, 43, 226));
		lblLoginForm.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 20));
		lblLoginForm.setBounds(352, 13, 174, 35);
		panel_1.add(lblLoginForm);
		
		JLabel lblName = new JLabel("IP Address :");
		lblName.setForeground(new Color(240, 255, 255));
		lblName.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 20));
		lblName.setBounds(186, 200, 118, 43);
		contentPane.add(lblName);
		
		email = new JTextField();
		email.setBounds(335, 210, 222, 22);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblPassword = new JLabel("Local Port Number :");
		lblPassword.setForeground(new Color(240, 255, 255));
		lblPassword.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 20));
		lblPassword.setBounds(130, 280, 222, 43);
		contentPane.add(lblPassword);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(335, 290, 222, 22);
		contentPane.add(password);
		
		JButton btnLogin = new JButton("Register");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try{
				
			
		    socket=new Socket("localhost",120);
		   
		   
		    String Uname=uname.getText();
			String Email=email.getText();
			String Password=password.getText();
			
			
			ArrayList<String> list=new ArrayList<String>();
			
			list.add("Register");
			list.add(Uname);
			list.add(Email);
			list.add(Password);
			
			
			ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
			
			oos.writeObject(list);
			
			
			
			}
			catch(Exception ek)
			{
				ek.printStackTrace();
			}
			
			
				
				
			}
		});
		btnLogin.setForeground(new Color(138, 43, 226));
		btnLogin.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		btnLogin.setBounds(347, 361, 175, 25);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Already a User");
		btnRegister.setForeground(new Color(138, 43, 226));
		btnRegister.setFont(new Font("Baskerville Old Face", Font.BOLD, 14));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnRegister.setBounds(347, 435, 175, 25);
		contentPane.add(btnRegister);
		
		JLabel lblUserName = new JLabel("PC Name");
		lblUserName.setForeground(new Color(240, 255, 255));
		lblUserName.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		lblUserName.setBounds(194, 117, 126, 43);
		contentPane.add(lblUserName);
		
		uname = new JTextField();
		uname.setColumns(10);
		uname.setBounds(335, 127, 222, 22);
		contentPane.add(uname);
		
		
		
		ImageIcon icon = new ImageIcon("resource/images/VV3.jpg"); 
		JLabel thumb = new JLabel();
		thumb.setIcon(icon);
		thumb.setBounds(0,0,1280,1024);
		contentPane.add(thumb);
		
		
		
		
	}
}
