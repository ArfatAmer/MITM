package com.Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

import com.DBConnection.DBConnection;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.swing.JCheckBox;

public class ServerAuthentication extends JFrame {
	
	protected   String SelEmail1;
	protected   String SelEmail2;
	protected   String SelEmail3;
	protected   String SelEmail4 ;
	protected   String SelEmail5 ;
	protected   String SelEmail6 ;
	protected   String SelEmail7 ;
	protected   String SelEmail9 ;
	protected   String SelEmail8 ;
	protected   boolean status1 ;
	protected   boolean status2 ;
	protected   boolean status3 ;
	protected   boolean status4  ;
	protected   boolean status5  ;
	protected   boolean status6 ;
	protected   boolean status7  ;
	protected   boolean status9  ;
	protected   boolean status8  ;
	
	
	String Hacker,Hacked;
	
	
	static ServerAuthentication frame;
	
	ArrayList NName=new ArrayList();
	ArrayList NEmail=new ArrayList();
   ArrayList<String> list=new ArrayList<String>();
	private JPanel contentPane;
	String Email,Name,Password;
	private JTextField textField;
	private JLabel lblWait;
	JCheckBox chckbxSelect1,chckbxSelect2,chckbxSelect3,chckbxSelect4,chckbxSelect5,chckbxSelect6,chckbxSelect7,chckbxSelect8,chckbxSelect9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				 frame = new ServerAuthentication();
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
	public ServerAuthentication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1000,600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(0, 0, 982, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNetworkUsersparallelSession = new JLabel("Man In the Middle Identifier");
		lblNetworkUsersparallelSession.setForeground(new Color(0, 100, 0));
		lblNetworkUsersparallelSession.setFont(new Font("Baskerville Old Face", Font.BOLD, 25));
		lblNetworkUsersparallelSession.setBounds(317, 11, 350, 44);
		panel.add(lblNetworkUsersparallelSession);
		
		JButton btnGetAllUsers = new JButton("Detect All Users");
		btnGetAllUsers.setBackground(new Color(192, 192, 192));
		btnGetAllUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try
				{
				DBConnection c=new DBConnection();
				
				Connection cd=(Connection)c.con();
					
				PreparedStatement ps=(PreparedStatement)cd.prepareStatement("SELECT * FROM register r;");
				
				ResultSet rs=(ResultSet)ps.executeQuery();
				
				
				int k=1;
				while(rs.next())
				{
					Name=rs.getString(1).toString();
					Email=rs.getString(2).toString();
					Password=rs.getString(3).toString();
					
					NName.add(Name);
					NEmail.add(Email);
					
					System.out.println("K is "+k);
					
					System.out.println("NName:::"+Name);
					
					contentPane.repaint();
					
					if(k==1){
						System.out.println("Inside 1 loop");
						
					JLabel lblName = new JLabel(Name);
					lblName.setForeground(new Color(224, 255, 255));
					lblName.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					lblName.setBounds(50, 133, 196, 31);
					contentPane.add(lblName);
					
					JLabel lblEmail = new JLabel(Email);
					lblEmail.setForeground(new Color(224, 255, 255));
					lblEmail.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					lblEmail.setBounds(374, 133, 267, 31);
					contentPane.add(lblEmail);
					
//					JLabel lblPassword = new JLabel(Password);
//					lblPassword.setForeground(new Color(224, 255, 255));
//					lblPassword.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
//					lblPassword.setBounds(712, 133, 210, 31);
//					contentPane.add(lblPassword);
					
					
					chckbxSelect1 = new JCheckBox("Block");
					chckbxSelect1.setName(Email);
					
					chckbxSelect1.setBounds(712, 133, 210, 31);
					contentPane.add(chckbxSelect1);
					chckbxSelect1.setBackground(new Color(138, 43, 226));
					chckbxSelect1.setForeground(Color.white);
					chckbxSelect1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					
					
					}
					
					if(k==2){
						System.out.println("Inside 2 loop");
					JPanel panel_2 = new JPanel();
					panel_2.setBounds(0, 194, 982, 42);
					contentPane.add(panel_2);
					panel_2.setLayout(null);
					
					JLabel label_12 = new JLabel(Name);
					label_12.setForeground(new Color(0, 0, 255));
					label_12.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_12.setBounds(48, 0, 196, 31);
					panel_2.add(label_12);
					
					JLabel label_13 = new JLabel(Email);
					label_13.setForeground(new Color(0, 0, 255));
					label_13.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_13.setBounds(372, 0, 267, 31);
					panel_2.add(label_13);
					
//					JLabel label_14 = new JLabel(Password);
//					label_14.setForeground(new Color(0, 0, 255));
//					label_14.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
//					label_14.setBounds(710, 0, 210, 31);
//					panel_2.add(label_14);
					
					
					chckbxSelect2 = new JCheckBox("Block");
					chckbxSelect2.setName(Email);
					chckbxSelect2.setBounds(710, 0, 210, 31);
					panel_2.add(chckbxSelect2);
//					chckbxSelect.setBackground(new Color(138, 43, 226));
					chckbxSelect2.setForeground(new Color(138, 43, 226));
					chckbxSelect2.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					
					
					}
					
					
					if(k==3){
						System.out.println("Inside 3 loop");
					JLabel label = new JLabel(Name);
					label.setForeground(new Color(224, 255, 255));
					label.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label.setBounds(50, 271, 196, 31);
					contentPane.add(label);
					
					JLabel label_1 = new JLabel(Email);
					label_1.setForeground(new Color(224, 255, 255));
					label_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_1.setBounds(374, 271, 267, 31);
					contentPane.add(label_1);
					
//					JLabel label_2 = new JLabel(Password);
//					label_2.setForeground(new Color(224, 255, 255));
//					label_2.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
//					label_2.setBounds(712, 271, 210, 31);
//					contentPane.add(label_2);
					
					chckbxSelect3 = new JCheckBox("Block");
					chckbxSelect3.setName(Email);
					chckbxSelect3.setBounds(712, 271, 210, 31);
					contentPane.add(chckbxSelect3);
					chckbxSelect3.setBackground(new Color(138, 43, 226));
					chckbxSelect3.setForeground(Color.white);
					chckbxSelect3.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					
					
					}
					
					if(k==4){
						System.out.println("Inside 4 loop");
					JPanel panel_3 = new JPanel();
					panel_3.setBounds(0, 332, 982, 42);
					contentPane.add(panel_3);
					panel_3.setLayout(null);
					
					JLabel label_15 = new JLabel(Name);
					label_15.setForeground(Color.BLUE);
					label_15.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_15.setBounds(51, 0, 196, 31);
					panel_3.add(label_15);
					
					JLabel label_16 = new JLabel(Email);
					label_16.setForeground(Color.BLUE);
					label_16.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_16.setBounds(375, 0, 267, 31);
					panel_3.add(label_16);
					
//					JLabel label_17 = new JLabel(Password);
//					label_17.setForeground(Color.BLUE);
//					label_17.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
//					label_17.setBounds(713, 0, 210, 31);
//					panel_3.add(label_17);
					
					chckbxSelect4 = new JCheckBox("Block");
					chckbxSelect4.setName(Email);
					chckbxSelect4.setBounds(713, 0, 210, 31);
					panel_3.add(chckbxSelect4);
//					chckbxSelect.setBackground(new Color(138, 43, 226));
					chckbxSelect4.setForeground(new Color(138, 43, 226));
					chckbxSelect4.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					
					
					}
					
					
					if(k==5){
						System.out.println("Inside 5 loop");
					JLabel label_3 = new JLabel(Name);
					label_3.setForeground(new Color(224, 255, 255));
					label_3.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_3.setBounds(50, 414, 196, 31);
					contentPane.add(label_3);
					
					JLabel label_4 = new JLabel(Email);
					label_4.setForeground(new Color(224, 255, 255));
					label_4.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_4.setBounds(374, 414, 267, 31);
					contentPane.add(label_4);
					
//					JLabel label_5 = new JLabel(Password);
//					label_5.setForeground(new Color(224, 255, 255));
//					label_5.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
//					label_5.setBounds(712, 414, 210, 31);
//					contentPane.add(label_5);
					
					
					chckbxSelect5 = new JCheckBox("Block");
					chckbxSelect5.setName(Email);
					chckbxSelect5.setBounds(712, 414, 210, 31);
					contentPane.add(chckbxSelect5);
					chckbxSelect5.setBackground(new Color(138, 43, 226));
					chckbxSelect5.setForeground(Color.white);
					chckbxSelect5.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					
					
					}
					
					if(k==6){
						System.out.println("Inside 6 loop");
					JPanel panel_4 = new JPanel();
					panel_4.setBounds(0, 475, 982, 42);
					contentPane.add(panel_4);
					panel_4.setLayout(null);
					
					JLabel label_18 = new JLabel(Name);
					label_18.setForeground(Color.BLUE);
					label_18.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_18.setBounds(53, 0, 196, 31);
					panel_4.add(label_18);
					
					JLabel label_19 = new JLabel(Email);
					label_19.setForeground(Color.BLUE);
					label_19.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_19.setBounds(377, 0, 267, 31);
					panel_4.add(label_19);
					
//					JLabel label_20 = new JLabel(Password);
//					label_20.setForeground(Color.BLUE);
//					label_20.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
//					label_20.setBounds(715, 0, 210, 31);
//					panel_4.add(label_20);
					
					chckbxSelect6 = new JCheckBox("Block");
					chckbxSelect6.setName(Email);
					chckbxSelect6.setBounds(715, 0, 210, 31);
					panel_4.add(chckbxSelect6);
//					chckbxSelect.setBackground(new Color(138, 43, 226));
					chckbxSelect6.setForeground(new Color(138, 43, 226));
					chckbxSelect6.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					
					
					}
					
					if(k==7){
						System.out.println("Inside 7 loop");
					JLabel label_6 = new JLabel(Name);
					label_6.setForeground(new Color(224, 255, 255));
					label_6.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_6.setBounds(50, 551, 196, 31);
					contentPane.add(label_6);
					
					JLabel label_7 = new JLabel(Email);
					label_7.setForeground(new Color(224, 255, 255));
					label_7.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_7.setBounds(374, 551, 267, 31);
					contentPane.add(label_7);
					
//					JLabel label_8 = new JLabel(Password);
//					label_8.setForeground(new Color(224, 255, 255));
//					label_8.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
//					label_8.setBounds(712, 551, 210, 31);
//					contentPane.add(label_8);
					
					chckbxSelect7 = new JCheckBox("Block");
					chckbxSelect7.setName(Email);
					chckbxSelect7.setBounds(712, 551, 210, 31);
					contentPane.add(chckbxSelect7);
					chckbxSelect7.setBackground(new Color(138, 43, 226));
					chckbxSelect7.setForeground(Color.white);
					chckbxSelect7.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					
					
					}
					
					 if(k==8){
						System.out.println("Inside 8 loop");
					JPanel panel_5 = new JPanel();
					panel_5.setBounds(0, 612, 982, 42);
					contentPane.add(panel_5);
					panel_5.setLayout(null);
					
					JLabel label_21 = new JLabel(Name);
					label_21.setForeground(Color.BLUE);
					label_21.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_21.setBounds(51, 0, 196, 31);
					panel_5.add(label_21);
					
					JLabel label_22 = new JLabel(Email);
					label_22.setForeground(Color.BLUE);
					label_22.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_22.setBounds(375, 0, 267, 31);
					panel_5.add(label_22);
					
//					JLabel label_23 = new JLabel(Password);
//					label_23.setForeground(Color.BLUE);
//					label_23.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
//					label_23.setBounds(713, 0, 210, 31);
//					panel_5.add(label_23);
					
					chckbxSelect8 = new JCheckBox("Block");
					chckbxSelect8.setName(Email);
					chckbxSelect8.setBounds(713, 0, 210, 31);
					panel_5.add(chckbxSelect8);
//					chckbxSelect.setBackground(new Color(138, 43, 226));
					chckbxSelect8.setForeground(new Color(138, 43, 226));
					chckbxSelect8.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					
					
					}
					
					if(k==9){
						System.out.println("Inside 9 loop");
					JLabel label_9 = new JLabel(Name);
					label_9.setForeground(new Color(224, 255, 255));
					label_9.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_9.setBounds(50, 679, 196, 31);
					contentPane.add(label_9);
					
					JLabel label_10 = new JLabel(Email);
					label_10.setForeground(new Color(224, 255, 255));
					label_10.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					label_10.setBounds(374, 679, 267, 31);
					contentPane.add(label_10);
					
//					JLabel label_11 = new JLabel(Password);
//					label_11.setForeground(new Color(224, 255, 255));
//					label_11.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
//					label_11.setBounds(712, 679, 210, 31);
//					contentPane.add(label_11);
					
					
					chckbxSelect9 = new JCheckBox("Block");
					chckbxSelect9.setName(Email);
					chckbxSelect9.setBounds(712, 679, 210, 31);
					contentPane.add(chckbxSelect9);
					chckbxSelect9.setBackground(new Color(138, 43, 226));
					chckbxSelect9.setForeground(Color.white);
					chckbxSelect9.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
					
					
					}
					k++;
					
					
				}
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				System.out.println("Name::::"+Name);
				System.out.println("Email::::"+Email);
				System.out.println("Password::::"+Password);
				
				
				
				
				
				
			}
		});
		btnGetAllUsers.setForeground(new Color(0, 100, 0));
		btnGetAllUsers.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		btnGetAllUsers.setBounds(88, 70, 174, 30);
		panel.add(btnGetAllUsers);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBackground(new Color(192, 192, 192));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ServerAuthentication sss=new ServerAuthentication();
				sss.setVisible(true);
				dispose();
			}
		});
		btnRefresh.setForeground(new Color(0, 100, 0));
		btnRefresh.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		btnRefresh.setBounds(274, 70, 146, 30);
		panel.add(btnRefresh);
		
		JButton btnNotification = new JButton("Notification");
		btnNotification.setBackground(new Color(192, 192, 192));
		btnNotification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/vtjnw08@2016","root","admin");
					
					PreparedStatement ps=(PreparedStatement)con.prepareStatement("SELECT * FROM `hacking`;");
					
					ResultSet rs=(ResultSet) ps.executeQuery();
					
					while(rs.next())
					{
						
						Hacker=rs.getString(1);
						Hacked=rs.getString(2);
						
						System.out.print(Hacker+Hacked);
						
					}
					
					
					HackedDB bb=new HackedDB(Hacker,Hacked);
					
					bb.setVisible(true);
					
					
					
					
					
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNotification.setForeground(new Color(0, 100, 0));
		btnNotification.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
		btnNotification.setBounds(430, 70, 146, 30);
		panel.add(btnNotification);
		
		
		
		
		JButton btnStartParallelSession = new JButton("Server Authentication");
		btnStartParallelSession.setBounds(586, 73, 251, 25);
		panel.add(btnStartParallelSession);
		btnStartParallelSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent g) {
				
			
				
			   if(chckbxSelect1.isSelected()==true){
				//ckbox1
				 SelEmail1=chckbxSelect1.getName();
				  status1=chckbxSelect1.isSelected();
				 System.out.println(SelEmail1+status1);
				 
				 
				try
				{
					
					DBConnection db=new DBConnection();
					
					Connection con=(Connection)db.con();
					
					PreparedStatement ps=(PreparedStatement)con.prepareStatement("DELETE FROM register WHERE IPAddress='"+SelEmail1+"';");
					
					PreparedStatement pss=(PreparedStatement)con.prepareStatement("DELETE FROM hacking WHERE IPAddress='"+SelEmail1+"'");
					
					int status=ps.executeUpdate();
					
					int statuss=pss.executeUpdate();
				
					
					
					if(status==1){
						
						JOptionPane.showMessageDialog(null,"Account Deactivated");
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Account Not Deactivated");
					}
					
					
					
                      if(statuss==1){
						
						JOptionPane.showMessageDialog(null,SelEmail1+"\t"+"Deactivation Successfully Completed");
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,SelEmail1+"\t"+"Deactivation Successfully Completed");
					}
					
					
					
					
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				 
				 
				 
				 
				 
				 
				 
				 
				}
				
				
				if(chckbxSelect2.isSelected()==true){ 
				//ckbox2
				SelEmail2=chckbxSelect2.getName();
				 status2=chckbxSelect2.isSelected();
				 System.out.println(SelEmail2+status2);
				 
				 
				 try
					{
						
						DBConnection db=new DBConnection();
						
						Connection con=(Connection)db.con();
						
						PreparedStatement ps=(PreparedStatement)con.prepareStatement("DELETE FROM register WHERE IPAddress='"+SelEmail2+"';");
						
						PreparedStatement pss=(PreparedStatement)con.prepareStatement("DELETE FROM hacking WHERE IPAddress='"+SelEmail2+"'");
						
						int status=ps.executeUpdate();
						
						int statuss=pss.executeUpdate();
					
						
						
						if(status==1){
							
							JOptionPane.showMessageDialog(null,"Account Deactivated");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Account Not Deactivated");
						}
						
						
						
	                      if(statuss==1){
							
							JOptionPane.showMessageDialog(null,SelEmail2+"\t"+"Deactivation Successfully Completed");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,SelEmail2+"\t"+"Deactivation Successfully Completed");
						}
						
						
						
						
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				 
				 
				 
				 
				 
				 
				}
				 
				if(chckbxSelect3.isSelected()==true){
				//ckbox3
				SelEmail3=chckbxSelect3.getName();
				status3=chckbxSelect3.isSelected();
				 System.out.println(SelEmail3+status3);
				 
				 
				 try
					{
						
						DBConnection db=new DBConnection();
						
						Connection con=(Connection)db.con();
						
						PreparedStatement ps=(PreparedStatement)con.prepareStatement("DELETE FROM register WHERE IPAddress='"+SelEmail3+"';");
						
						PreparedStatement pss=(PreparedStatement)con.prepareStatement("DELETE FROM hacking WHERE IPAddress='"+SelEmail3+"'");
						
						int status=ps.executeUpdate();
						
						int statuss=pss.executeUpdate();
					
						
						
						if(status==1){
							
							JOptionPane.showMessageDialog(null,"Account Deactivated");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Account Not Deactivated");
						}
						
						
						
	                      if(statuss==1){
							
							JOptionPane.showMessageDialog(null,SelEmail3+"\t"+"Deactivation Successfully Completed");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,SelEmail3+"\t"+"Deactivation Successfully Completed");
						}
						
						
						
						
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				 
				 
				 
				 
				 
				 
				}
				 
				if(chckbxSelect4.isSelected()==true){
				//ckbox4
				SelEmail4=chckbxSelect4.getName();
				 status4=chckbxSelect4.isSelected();
				 System.out.println(SelEmail4+status4);
				 
				 
				 try
					{
						
						DBConnection db=new DBConnection();
						
						Connection con=(Connection)db.con();
						
						PreparedStatement ps=(PreparedStatement)con.prepareStatement("DELETE FROM register WHERE IPAddress='"+SelEmail4+"';");
						
						PreparedStatement pss=(PreparedStatement)con.prepareStatement("DELETE FROM hacking WHERE IPAddress='"+SelEmail4+"'");
						
						int status=ps.executeUpdate();
						
						int statuss=pss.executeUpdate();
					
						
						
						if(status==1){
							
							JOptionPane.showMessageDialog(null,"Account Deactivated");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Account Not Deactivated");
						}
						
						
						
	                      if(statuss==1){
							
							JOptionPane.showMessageDialog(null,SelEmail4+"\t"+"Deactivation Successfully Completed");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,SelEmail4+"\t"+"Deactivation Successfully Completed");
						}
						
						
						
						
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				 
				 
				 
				 
				 
				 
				 
				 
				}
				 
				if(chckbxSelect5.isSelected()==true){
				//ckbox5
				SelEmail5=chckbxSelect5.getName();
				 status5=chckbxSelect5.isSelected();
				 System.out.println(SelEmail5+status5);
				 
				 
				 try
					{
						
						DBConnection db=new DBConnection();
						
						Connection con=(Connection)db.con();
						
						PreparedStatement ps=(PreparedStatement)con.prepareStatement("DELETE FROM register WHERE IPAddress='"+SelEmail5+"';");
						
						PreparedStatement pss=(PreparedStatement)con.prepareStatement("DELETE FROM hacking WHERE IPAddress='"+SelEmail5+"'");
						
						int status=ps.executeUpdate();
						
						int statuss=pss.executeUpdate();
					
						
						
						if(status==1){
							
							JOptionPane.showMessageDialog(null,"Account Deactivated");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Account Not Deactivated");
						}
						
						
						
	                      if(statuss==1){
							
							JOptionPane.showMessageDialog(null,SelEmail5+"\t"+"Deactivation Successfully Completed");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,SelEmail5+"\t"+"Deactivation Successfully Completed");
						}
						
						
						
						
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				 
				 
				 
				 
				 
				}
				 
			     if(chckbxSelect6.isSelected()==true){
				//ckbox6
				SelEmail6=chckbxSelect6.getName();
				 status6=chckbxSelect6.isSelected();
				 System.out.println(SelEmail6+status6);
				 
				 try
					{
						
						DBConnection db=new DBConnection();
						
						Connection con=(Connection)db.con();
						
						PreparedStatement ps=(PreparedStatement)con.prepareStatement("DELETE FROM register WHERE IPAddress='"+SelEmail6+"';");
						
						PreparedStatement pss=(PreparedStatement)con.prepareStatement("DELETE FROM hacking WHERE IPAddress='"+SelEmail6+"'");
						
						int status=ps.executeUpdate();
						
						int statuss=pss.executeUpdate();
					
						
						
						if(status==1){
							
							JOptionPane.showMessageDialog(null,"Account Deactivated");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Account Not Deactivated");
						}
						
						
						
	                      if(statuss==1){
							
							JOptionPane.showMessageDialog(null,SelEmail6+"\t"+"Deactivation Successfully Completed");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,SelEmail6+"\t"+"Deactivation Successfully Completed");
						}
						
						
						
						
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				 
				 
				 
				 
				 
				 
				}
				 
//			    if(chckbxSelect7.isSelected()==true){
//				//ckbox7
//				SelEmail7=chckbxSelect7.getName();
//				 status7=chckbxSelect7.isSelected();
//				 System.out.println(SelEmail7+status7);
//				 
//				 
//				 try
//					{
//						
//						DBConnection db=new DBConnection();
//						
//						Connection con=(Connection)db.con();
//						
//						PreparedStatement ps=(PreparedStatement)con.prepareStatement("DELETE FROM register WHERE IPAddress='"+SelEmail7+"';");
//						
//						PreparedStatement pss=(PreparedStatement)con.prepareStatement("DELETE FROM hacking WHERE IPAddress='"+SelEmail7+"'");
//						
//						int status=ps.executeUpdate();
//						
//						int statuss=pss.executeUpdate();
//					
//						
//						
//						if(status==1){
//							
//							JOptionPane.showMessageDialog(null,"Account Deactivated");
//							
//						}
//						else
//						{
//							JOptionPane.showMessageDialog(null,"Account Not Deactivated");
//						}
//						
//						
//						
//	                      if(statuss==1){
//							
//							JOptionPane.showMessageDialog(null,SelEmail7+"\t"+"Deactivation Successfully Completed");
//							
//						}
//						else
//						{
//							JOptionPane.showMessageDialog(null,SelEmail7+"\t"+"Deactivation Successfully Completed");
//						}
//						
//						
//						
//						
//						
//					}
//					catch(Exception e)
//					{
//						e.printStackTrace();
//					}
//				 
//				 
//				 
//				 
//				 
//				 
//				 
//				}
//				 
//				
//				 if(chckbxSelect8.isSelected()==true){
//				//ckbox8
//				SelEmail8=chckbxSelect8.getName();
//				 status8=chckbxSelect8.isSelected();
//				 System.out.println(SelEmail8+status8);
//				 
//				 
//				 
//				 try
//					{
//						
//						DBConnection db=new DBConnection();
//						
//						Connection con=(Connection)db.con();
//						
//						PreparedStatement ps=(PreparedStatement)con.prepareStatement("DELETE FROM register WHERE IPAddress='"+SelEmail8+"';");
//						
//						PreparedStatement pss=(PreparedStatement)con.prepareStatement("DELETE FROM hacking WHERE IPAddress='"+SelEmail8+"'");
//						
//						int status=ps.executeUpdate();
//						
//						int statuss=pss.executeUpdate();
//					
//						
//						
//						if(status==1){
//							
//							JOptionPane.showMessageDialog(null,"Account Deactivated");
//							
//						}
//						else
//						{
//							JOptionPane.showMessageDialog(null,"Account Not Deactivated");
//						}
//						
//						
//						
//	                      if(statuss==1){
//							
//							JOptionPane.showMessageDialog(null,SelEmail8+"\t"+"Deactivation Successfully Completed");
//							
//						}
//						else
//						{
//							JOptionPane.showMessageDialog(null,SelEmail8+"\t"+"Deactivation Successfully Completed");
//						}
//						
//						
//						
//						
//						
//					}
//					catch(Exception e)
//					{
//						e.printStackTrace();
//					}
//				 
//				 
//				 
//				 
//				 
//				 
//				}
//				
//				if(chckbxSelect9.isSelected()==true){ 
//				//ckbox9
//				 SelEmail9=chckbxSelect9.getName();
//				 status9=chckbxSelect9.isSelected();
//				 System.out.println(SelEmail9+status9);
//				 
//				 
//				 
//				 
//				 try
//					{
//						
//						DBConnection db=new DBConnection();
//						
//						Connection con=(Connection)db.con();
//						
//						PreparedStatement ps=(PreparedStatement)con.prepareStatement("DELETE FROM register WHERE IPAddress='"+SelEmail9+"';");
//						
//						PreparedStatement pss=(PreparedStatement)con.prepareStatement("DELETE FROM hacking WHERE IPAddress='"+SelEmail9+"'");
//						
//						int status=ps.executeUpdate();
//						
//						int statuss=pss.executeUpdate();
//					
//						
//						
//						if(status==1){
//							
//							JOptionPane.showMessageDialog(null,"Account Deactivated");
//							
//						}
//						else
//						{
//							JOptionPane.showMessageDialog(null,"Account Not Deactivated");
//						}
//						
//						
//						
//	                      if(statuss==1){
//							
//							JOptionPane.showMessageDialog(null,SelEmail9+"\t"+"Deactivation Successfully Completed");
//							
//						}
//						else
//						{
//							JOptionPane.showMessageDialog(null,SelEmail9+"\t"+"Deactivation Successfully Completed");
//						}
//						
//						
//						
//						
//						
//					}
//					catch(Exception e)
//					{
//						e.printStackTrace();
//					}
				 
//			}
				 
				 
				 
				 
				 
				 
				 
				 
				 
				
			 
			
			 
//			 System.out.println("SelEmail1");
//			 
//			 if(SelEmail1==null)
//			 {
//				 SelEmail1="Not Connected";
//			 }
//			 else
//			 {
//				 SelEmail1="Connected"; 
//			 }
//			 
//			 if(SelEmail2==null)
//			 {
//				 SelEmail2="Not Connected";
//			 }
//			 else
//			 {
//				 SelEmail2="Connected";
//			 }
//			 
//			 if(SelEmail3==null)
//			 {
//				 SelEmail3="Not Connected";
//			 }
//			 else
//			 {
//				 SelEmail3="Connected"; 
//			 }
//			 
//			 if(SelEmail4==null)
//			 {
//				 SelEmail4="Not Connected";
//			 }
//			 else
//			 {
//				 SelEmail4="Connected"; 
//			 }
//			 
//			 if(SelEmail5==null)
//			 {
//				 SelEmail5="Not Connected";
//			 }
//			 else
//			 {
//				 SelEmail5="Connected";
//			 }
//			 
//			 if(SelEmail6==null)
//			 {
//				 SelEmail6="Not Connected";
//			 }
//			 else
//			 {
//				 SelEmail6="Connected"; 
//			 }
//			 
//			 if(SelEmail7==null)
//			 {
//				 SelEmail7="Not Connected";
//			 }
//			 else
//			 {
//				 SelEmail7="Connected"; 
//			 }
//			 
//			 if(SelEmail8==null)
//			 {
//				 SelEmail8="Not Connected";
//			 }
//			 else
//			 {
//				 SelEmail8="Connected"; 
//			 }
//			 
//			 if(SelEmail9==null)
//			 {
//				 SelEmail9="Not Connected";
//			 }
//			 else
//			 {
//				 SelEmail9="Connected"; 
//			 }
//			 
//			System.out.println("adding List"+list); 
//			 
//			 list.add(SelEmail1);
//			 list.add(SelEmail2);
//			 list.add(SelEmail3);
//			 list.add(SelEmail4);
//			 list.add(SelEmail5);
//			 list.add(SelEmail6);
//			 list.add(SelEmail7);
//			 list.add(SelEmail8);
//			 list.add(SelEmail9);
//			 
//			 
//			 
//			 
//				 
//			      System.out.println("List-->"+list);
//			      System.out.println("NName:"+NName);
//			      System.out.println("NEmail"+NEmail);
//			 
//				 SelectedUsers sel=new SelectedUsers(list,NName,NEmail);
//				 sel.setVisible(true);
				
				
			}
		});
		btnStartParallelSession.setBackground(Color.LIGHT_GRAY);
		btnStartParallelSession.setForeground(new Color(0, 100, 0));
		btnStartParallelSession.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		
		
	
		
	}
}
