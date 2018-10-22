package com.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Client.*;
import com.DBConnection.DBConnection;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.TextField;
import java.awt.List;
import java.awt.Label;
import java.awt.TextArea;

public class DecryptPage extends JFrame {

	
	private JPanel contentPane;
	
	public static String User,IPAddress;
	
	String FileName,SecretKey,FileContent;
	
	ArrayList<String> AFileName=new ArrayList<String>();
	ArrayList<String> ASecretKey=new ArrayList<String>();
	ArrayList<String> AFileContent=new ArrayList<String>();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DecryptPage frame = new DecryptPage(User,IPAddress);
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	     public DecryptPage(String User,final String IPAddress) {
		
		
		
		System.out.println("User in Welcome Page::"+User);
		System.out.println("User in Welcome Page::"+IPAddress);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1000,880);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setForeground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 982, 61);
		panel.setBackground(new Color(245, 245, 220));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEncryptedContent = new JLabel("Encrypted Content");
		lblEncryptedContent.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		lblEncryptedContent.setForeground(new Color(0, 204, 255));
		lblEncryptedContent.setBounds(419, 13, 170, 35);
		panel.add(lblEncryptedContent);
		
		System.out.println("FileName=="+AFileName);
		System.out.println("SecretKey=="+ASecretKey);
		System.out.println("FileContent=="+AFileContent);
		
		
		
		JLabel lblFilename = new JLabel("FileName");
		lblFilename.setForeground(Color.WHITE);
		lblFilename.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		lblFilename.setBounds(38, 109, 102, 37);
		contentPane.add(lblFilename);
		
		JLabel lblSecretKey = new JLabel("SecretKey");
		lblSecretKey.setForeground(Color.WHITE);
		lblSecretKey.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		lblSecretKey.setBounds(232, 109, 102, 37);
		contentPane.add(lblSecretKey);
		
		JLabel lblFileContent = new JLabel("File Content");
		lblFileContent.setForeground(Color.WHITE);
		lblFileContent.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		lblFileContent.setBounds(493, 109, 129, 37);
		contentPane.add(lblFileContent);
		
		JLabel lblRfilename = new JLabel(IPAddress);
		lblRfilename.setForeground(Color.WHITE);
		lblRfilename.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		lblRfilename.setBounds(12, 201, 208, 37);
		contentPane.add(lblRfilename);
		
		JLabel lblRsecretkey = new JLabel(User);
		lblRsecretkey.setForeground(Color.WHITE);
		lblRsecretkey.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		lblRsecretkey.setBounds(232, 201, 140, 37);
		contentPane.add(lblRsecretkey);
		
		
		
		try
		{
			
			DBConnection db=new DBConnection();
			
			Connection con=db.con();
			
			PreparedStatement ps=(PreparedStatement)con.prepareStatement("SELECT * FROM `shareddata` where IPAddress='"+IPAddress+"'  && SecretKey='"+User+"'   "); 
			
			ResultSet rs=(ResultSet)ps.executeQuery();
			
			while(rs.next()){
				
				String FileContent=rs.getString(6);
				
				System.out.println("FileContent-->"+FileContent);
				
				
				TextArea textArea = new TextArea(FileContent);
				textArea.setBounds(428, 208, 440, 481);
				contentPane.add(textArea);
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}
}
