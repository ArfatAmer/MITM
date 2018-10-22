package com.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1000,880);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 982, 19);
		panel.setBackground(new Color(188, 143, 143));
		contentPane.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 13, 982, 68);
		panel_2.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				Login login =new Login();
				login.setVisible(true);
			}
		});
		btnLogin.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 20));
		btnLogin.setBounds(559, 20, 122, 35);
		panel_2.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Register r=new Register();
				r.setVisible(true);
				
			}
		});
		btnRegister.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 20));
		btnRegister.setBounds(742, 20, 122, 35);
		panel_2.add(btnRegister);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 80, 982, 228);
		panel_1.setBackground(new Color(188, 143, 143));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAuthenticatedKeyExchange = new JLabel("Man In The Middle Attack");
		lblAuthenticatedKeyExchange.setForeground(new Color(240, 255, 255));
		lblAuthenticatedKeyExchange.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 25));
		lblAuthenticatedKeyExchange.setBounds(310, 70, 319, 79);
		panel_1.add(lblAuthenticatedKeyExchange);
		
		ImageIcon icon = new ImageIcon("resource/images/VV3.jpg"); 
		JLabel thumb = new JLabel();
		thumb.setIcon(icon);
		thumb.setBounds(0,0,1280,1024);
		contentPane.add(thumb);
		
		
		
	}

}
