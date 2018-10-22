package com.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.PreparedStatement;

import com.mysql.jdbc.Statement;
//import java.sql.PreparedStatement;
//import java.sql.Statement;


public class Hacking extends JFrame {

	private JPanel contentPane;
	private JTextField PNumber;
	String FileContent;
	private JTextField hack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hacking frame = new Hacking();
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
	public Hacking() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,800,800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		//contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHackingNetwork = new JLabel("Un Authorized Access");
		lblHackingNetwork.setForeground(new Color(138, 43, 226));
		lblHackingNetwork.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		lblHackingNetwork.setBounds(300, 31, 215, 34);
		contentPane.add(lblHackingNetwork);
		
		JLabel lblPortNumber = new JLabel("Your Port Number");
		lblPortNumber.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
		lblPortNumber.setForeground(new Color(153, 50, 204));
		lblPortNumber.setBounds(117, 337, 181, 27);
		contentPane.add(lblPortNumber);
		
		PNumber = new JTextField();
		PNumber.setBounds(315, 342, 200, 22);
		contentPane.add(PNumber);
		PNumber.setColumns(10);
		
		
		
		ImageIcon icon=new ImageIcon("resource/images/C2.jpg");
		
		JLabel thumb=new JLabel();
		
		thumb.setIcon(icon);
		thumb.setBounds(310,120,200,200);
		contentPane.add(thumb);
		
		hack = new JTextField();
		hack.setColumns(10);
		hack.setBounds(315, 432, 200, 22);
		contentPane.add(hack);
		
		JLabel lblHackingPortNumber = new JLabel("Hacking Port Number");
		lblHackingPortNumber.setForeground(new Color(153, 50, 204));
		lblHackingPortNumber.setFont(new Font("Baskerville Old Face", Font.BOLD, 15));
		lblHackingPortNumber.setBounds(117, 435, 181, 27);
		contentPane.add(lblHackingPortNumber);
		
		
		
		JButton btnHackIt = new JButton("Hack IT!!");
		btnHackIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String PortNumber=PNumber.getText();
				String HPortNumber=hack.getText();
				
				
				
				
				
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjnw08@2016","root","admin");
					
					PreparedStatement ps=(PreparedStatement)con.prepareStatement("SELECT * FROM register where IPAddress='"+PortNumber+"'");
					
				    ResultSet rs=(ResultSet)ps.executeQuery();
				    
				    boolean i=rs.next();
				    
				    if(i==true)
				    {
				    	FileContent fc=new FileContent(PortNumber,HPortNumber);
						fc.setVisible(true);
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(null, "Your Port Number is Incorrect");
				    }
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				
			}
		});
		btnHackIt.setBounds(315, 497, 117, 34);
		contentPane.add(btnHackIt);
		
		
		
	}
}
