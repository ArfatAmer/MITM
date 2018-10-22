package com.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

public class WelcomePage extends JFrame {

	
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
					WelcomePage frame = new WelcomePage(User,IPAddress);
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
	public WelcomePage(String User,final String IPAddress) {
		
		
		
		System.out.println("User in Welcome Page::"+User);
		System.out.println("User in Welcome Page::"+IPAddress);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1000,880);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setForeground(new Color(186, 85, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 982, 61);
		panel.setBackground(new Color(245, 245, 220));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNetworkUsers = new JButton("Network Users");
		btnNetworkUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			NetworkUsers net=new NetworkUsers();
			net.setVisible(true);
				
			}
		});
		btnNetworkUsers.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 13));
		btnNetworkUsers.setForeground(new Color(188, 143, 143));
		btnNetworkUsers.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 165, 0), new Color(255, 20, 147), new Color(255, 140, 0), new Color(184, 134, 11)));
		btnNetworkUsers.setBounds(429, 23, 127, 25);
		panel.add(btnNetworkUsers);
		
		JLabel lblWelcome = new JLabel("Welcome ");
		lblWelcome.setForeground(new Color(0, 100, 0));
		lblWelcome.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 20));
		lblWelcome.setBounds(12, 13, 97, 35);
		panel.add(lblWelcome);
		

		
		JLabel lblArunKumar = new JLabel(User);
		lblArunKumar.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 20));
		lblArunKumar.setForeground(new Color(138, 43, 226));
		lblArunKumar.setBounds(129, 13, 136, 35);
		panel.add(lblArunKumar);
		
		JButton btnGetReceivedPackets = new JButton("Get Received Packets");
		btnGetReceivedPackets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contentPane.repaint();
				try
				{
					DBConnection cc=new DBConnection();
					
					Connection con=cc.con();
					
					PreparedStatement ps=(PreparedStatement)con.prepareStatement("SELECT * FROM shareddata where IPAddress='"+IPAddress+"';");
					
					ResultSet rs=(ResultSet)ps.executeQuery();
					
					int l=1;
					
					while(rs.next()){
						
						System.out.println("File Content"+rs.getString(3));
						System.out.println("Secret Key"+rs.getString(4));
						System.out.println("FileName"+rs.getString(5));
						
						FileName=rs.getString(5);
						SecretKey=rs.getString(4);
						FileContent=rs.getString(3);
						
						AFileName.add(rs.getString(5));
						ASecretKey.add(rs.getString(4));
						AFileContent.add(rs.getString(3));
						
						
						
						
						
						if(l==1){
						JLabel label = new JLabel(FileName);
						label.setForeground(Color.WHITE);
						label.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
						label.setBounds(38, 182, 220, 37);
						contentPane.add(label);
						
						JLabel label_1 = new JLabel(SecretKey);
						label_1.setForeground(Color.WHITE);
						label_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
						label_1.setBounds(232, 182, 102, 37);
						contentPane.add(label_1);
						
						TextArea textArea = new TextArea(AFileContent.toString());
						textArea.setBounds(442, 172, 387, 80);
						contentPane.add(textArea);
						}
						
						
						
						if(l==2){
						JLabel label_2 = new JLabel(FileName);
						label_2.setForeground(Color.WHITE);
						label_2.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
						label_2.setBounds(38, 288, 220, 37);
						contentPane.add(label_2);
						
						JLabel label_3 = new JLabel(SecretKey);
						label_3.setForeground(Color.WHITE);
						label_3.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
						label_3.setBounds(232, 288, 102, 37);
						contentPane.add(label_3);
						
						TextArea textArea_1 = new TextArea(AFileContent.toString());
						textArea_1.setBounds(442, 278, 387, 80);
						contentPane.add(textArea_1);
						}
						
						
						if(l==3){
						JLabel label_4 = new JLabel(FileName);
						label_4.setForeground(Color.WHITE);
						label_4.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
						label_4.setBounds(38, 392, 220, 37);
						contentPane.add(label_4);
						
						JLabel label_5 = new JLabel(SecretKey);
						label_5.setForeground(Color.WHITE);
						label_5.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
						label_5.setBounds(232, 392, 102, 37);
						contentPane.add(label_5);
						
						TextArea textArea_2 = new TextArea(AFileContent.toString());
						textArea_2.setBounds(442, 382, 387, 80);
						contentPane.add(textArea_2);
						}
						
						
						if(l==4){
						JLabel label_6 = new JLabel(FileName);
						label_6.setForeground(Color.WHITE);
						label_6.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
						label_6.setBounds(38, 508, 220, 37);
						contentPane.add(label_6);
						
						JLabel label_7 = new JLabel(SecretKey);
						label_7.setForeground(Color.WHITE);
						label_7.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
						label_7.setBounds(232, 508, 102, 37);
						contentPane.add(label_7);
						
						TextArea textArea_3 = new TextArea(AFileContent.toString());
						textArea_3.setBounds(442, 498, 387, 80);
						contentPane.add(textArea_3);
						}
						
						
						
						if(l==5){
						JLabel label_8 = new JLabel(FileName);
						label_8.setForeground(Color.WHITE);
						label_8.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
						label_8.setBounds(38, 629, 220, 37);
						contentPane.add(label_8);
						
						JLabel label_9 = new JLabel(SecretKey);
						label_9.setForeground(Color.WHITE);
						label_9.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
						label_9.setBounds(232, 629, 102, 37);
						contentPane.add(label_9);
						
						TextArea textArea_4 = new TextArea(AFileContent.toString());
						textArea_4.setBounds(442, 619, 387, 80);
						contentPane.add(textArea_4);
						}
						
						
						if(l==6){
						JLabel label_10 = new JLabel(FileName);
						label_10.setForeground(Color.WHITE);
						label_10.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
						label_10.setBounds(38, 740, 220, 37);
						contentPane.add(label_10);
						
						JLabel label_11 = new JLabel(SecretKey);
						label_11.setForeground(Color.WHITE);
						label_11.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
						label_11.setBounds(232, 740, 102, 37);
						contentPane.add(label_11);
						
						
						TextArea textArea_5 = new TextArea(AFileContent.toString());
						textArea_5.setBounds(442, 730, 387, 80);
						contentPane.add(textArea_5);
						}
						
						
						
						
						
						l++;
						
					}
					
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				
				
			}
		});
		btnGetReceivedPackets.setForeground(new Color(188, 143, 143));
		btnGetReceivedPackets.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 13));
		btnGetReceivedPackets.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 165, 0), new Color(255, 20, 147), new Color(255, 140, 0), new Color(184, 134, 11)));
		btnGetReceivedPackets.setBounds(589, 23, 150, 25);
		panel.add(btnGetReceivedPackets);
		
		JButton btnSecretKey = new JButton("Secret Key");
		btnSecretKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//JOptionPane.showMessageDialog(null,"You Cannot Use Your Secret Key Now");
				String User=JOptionPane.showInputDialog("Enter Secret Key");
				
				System.out.println("Secret Key-->"+User);
				System.out.println("IPAddress-->"+IPAddress);
				
				
				DecryptPage dp=new DecryptPage(User,IPAddress);
				
				dp.setVisible(true);
				
				
				
			}
		});
		btnSecretKey.setForeground(new Color(188, 143, 143));
		btnSecretKey.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 13));
		btnSecretKey.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(255, 165, 0), new Color(255, 20, 147), new Color(255, 140, 0), new Color(184, 134, 11)));
		btnSecretKey.setBounds(788, 21, 150, 25);
		panel.add(btnSecretKey);
		
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
		
		
		
		
	}
}
