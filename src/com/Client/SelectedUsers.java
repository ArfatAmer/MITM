package com.Client;

import java.awt.EventQueue;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;

import com.DBConnection.DBConnection;

public class SelectedUsers extends JFrame {
	
	ArrayList Contentline0=new ArrayList();
	ArrayList Contentline1=new ArrayList();
	ArrayList Contentline2=new ArrayList();
	ArrayList Contentline3=new ArrayList();
	ArrayList Contentline4=new ArrayList();
	ArrayList Contentline5=new ArrayList();
	ArrayList Contentline6=new ArrayList();
	ArrayList Contentline7=new ArrayList();
	ArrayList Contentline8=new ArrayList();
	

	String FileName0,FileName1,FileName2,FileName3,FileName4,FileName5,FileName6,FileName7,FileName8;
	
	String line0,line1,line2,line3,line4,line5,line6,line7,line8;
	String Key;
	
	String IPAddress0,IPAddress1,IPAddress2,IPAddress3,IPAddress4,IPAddress5,IPAddress6,IPAddress7,IPAddress8;
	String Conn0,Conn1,Conn2,Conn3,Conn4,Conn5,Conn6,Conn7,Conn8;
	String FFilePath0,FFilePath1,FFilePath2,FFilePath3,FFilePath4,FFilePath5,FFilePath6,FFilePath7,FFilePath8;
	String FilePath0,FilePath1,FilePath2,FilePath3,FilePath4,FilePath5,FilePath6,FilePath7,FilePath8;
	
	private JPanel contentPane;
	static String UName1,UName2,UName3,UName4,UName5,UName6,UName7,UName8,UName9;
	static boolean UStatus1,UStatus2,UStatus3,UStatus4,UStatus5,UStatus6,UStatus7,UStatus8,UStatus9;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<String> list = null;
					ArrayList<String> NName = null;
					ArrayList<String> NEmail = null;
					SelectedUsers frame = new SelectedUsers(list,NName,NEmail);
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
	public SelectedUsers(final ArrayList<String> list,final ArrayList<String> NName,final ArrayList<String> NEmail) {
		
	
	    
		
		
		
		int in[]={1,2,3,4,5,6,7,8,9,0};
		String str[]={"a","b","c","d","e","f","g"
				
				,"h","i","j","k","l","m","n","o","p"
				,"q","r","s","t","u","v","w","x","y","z"
                  ,"A","B","C","D","E","F","G"
				
				,"H","I","J","K","L","M","N","O","P"
				,"Q","R","S","T","U","V","W","X","Y","Z"}; 
		
		
		
		int NumRandom1=(in[new Random().nextInt(in.length)]);

		String NumRandom2=(str[new Random().nextInt(str.length)]);
		int NumRandom3=(in[new Random().nextInt(in.length)]);
		String NumRandom4=(str[new Random().nextInt(str.length)]);
		int NumRandom5=(in[new Random().nextInt(in.length)]);
		String NumRandom6=(str[new Random().nextInt(str.length)]);
		
		System.out.println("NumRandom"+NumRandom1+NumRandom2+NumRandom3+NumRandom4+NumRandom5+NumRandom6);
		
		Key=NumRandom1+NumRandom2+NumRandom3+NumRandom4+NumRandom5+NumRandom6;
		
		System.out.println("key-->"+Key);
		System.out.println("Array Lsit"+list);
		
		
		UName1=list.get(0).toString();
		UName2=list.get(1).toString();
		UName3=list.get(2).toString();
		UName4=list.get(3).toString();
		UName5=list.get(4).toString();
		UName6=list.get(5).toString();
		UName7=list.get(6).toString();
		UName8=list.get(7).toString();
		UName9=list.get(8).toString();
		
		
		
		
		System.out.println("UName Selected 1-->"+UName1+UStatus1);
		System.out.println("UName Selected 2-->"+UName2+UStatus2);
		System.out.println("UName Selected 3-->"+UName3+UStatus3);
		System.out.println("UName Selected 4-->"+UName4+UStatus4);
		System.out.println("UName Selected 5-->"+UName5+UStatus5);
		System.out.println("UName Selected 6-->"+UName6+UStatus6);
		System.out.println("UName Selected 7-->"+UName7+UStatus7);
		System.out.println("UName Selected 8-->"+UName8+UStatus8);
		System.out.println("UName Selected 9-->"+UName9+UStatus9);
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1000,880);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.repaint();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(0, 0, 982, 125);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblSelectedUsers = new JLabel("Selected Users");
		lblSelectedUsers.setBounds(380, 13, 161, 66);
		lblSelectedUsers.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		lblSelectedUsers.setForeground(new Color(255, 105, 180));
		panel.add(lblSelectedUsers);
		
		JLabel lblYourSecretKey = new JLabel("Your Secret Key is ");
		lblYourSecretKey.setForeground(new Color(0, 100, 0));
		lblYourSecretKey.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYourSecretKey.setBounds(289, 76, 181, 32);
		panel.add(lblYourSecretKey);
		
		JLabel lblNewLabel = new JLabel(Key);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(469, 76, 97, 32);
		panel.add(lblNewLabel);
		
		
		JButton btnSendMessage = new JButton("Send File");
		btnSendMessage.setBounds(548, 81, 118, 25);
		panel.add(btnSendMessage);
		btnSendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try{
				//Adding to Database
				IPAddress0=NEmail.get(0).toString();
				Conn0=list.get(0).toString();
				FFilePath0=FilePath0;
				
				
				
				System.out.println("Hello "+IPAddress0+Conn0+FFilePath0+FileName0);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				try{
				IPAddress1=NEmail.get(1).toString();
				Conn1=list.get(1).toString();
				FFilePath1=FilePath1;
				
				
				System.out.println("Hello "+IPAddress1+Conn1+FFilePath1+FileName1);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				try{
				IPAddress2=NEmail.get(2).toString();
				Conn2=list.get(2).toString();
				FFilePath2=FilePath2;
				
				
				System.out.println("Hello "+IPAddress2+Conn2+FFilePath2+FileName2);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				
				
				try{
				IPAddress3=NEmail.get(3).toString();
				Conn3=list.get(3).toString();
				FFilePath3=FilePath3;
				
				
				System.out.println("Hello "+IPAddress3+Conn3+FFilePath3+FileName3);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				
				try{
				IPAddress4=NEmail.get(4).toString();
				Conn4=list.get(4).toString();
				FFilePath4=FilePath4;
				
				
				System.out.println("Hello "+IPAddress4+Conn4+FFilePath4+FileName4);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				try{
				IPAddress5=NEmail.get(5).toString();
				Conn5=list.get(5).toString();
				FFilePath5=FilePath5;
				
				
				System.out.println("Hello "+IPAddress5+Conn5+FFilePath5+FileName5);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				try{
				IPAddress6=NEmail.get(6).toString();
				Conn6=list.get(6).toString();
				FFilePath6=FilePath6;
				
				
				System.out.println("Hello "+IPAddress6+Conn6+FFilePath6+FileName6);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				try{
				IPAddress7=NEmail.get(7).toString();
				Conn7=list.get(7).toString();
				FFilePath7=FilePath7;
				
				
				System.out.println("Hello "+IPAddress7+Conn7+FFilePath7+FileName7);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				
				
				try{
				IPAddress8=NEmail.get(8).toString();
				Conn8=list.get(8).toString();
				FFilePath8=FilePath8;
				
				
				System.out.println("Hello "+IPAddress8+Conn8+FFilePath8+FileName8);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				System.out.println("Finish");
				//User0 Adding Files TO DB IF The Network is Connected
				
				if(IPAddress0!=null&&Conn0!="Not Connected"&&FFilePath0!=null){
				
				try
				{
				DBConnection co=new DBConnection();
				
				Connection c=(Connection)co.con();
				
				
				BufferedReader br=new BufferedReader(new FileReader(FFilePath0));
				
				
				
				while((line0=br.readLine())!=null){
					
					System.out.println("File Content-->"+line0);
					Contentline0.add(line0);
				}
				
				System.out.println("Contentline0-->"+Contentline0.toString());
				
				String Value=Contentline0.toString();
				
				byte[] text=Value.getBytes();
				
				
				KeyGenerator key=KeyGenerator.getInstance("DES");
				
				SecretKey sk=key.generateKey();
				
				Cipher cip=Cipher.getInstance("DES");
				
				
				cip.init(Cipher.ENCRYPT_MODE,sk);
				
				byte[] EText=cip.doFinal(text);
				
				String EncryptedText=new String(EText);
				
				
				cip.init(Cipher.DECRYPT_MODE,sk);
				
				byte[] DText=cip.doFinal(EText);
				
				String DecryptText=new String(DText);
				
				
				
				PreparedStatement ps=(PreparedStatement)c.prepareStatement("INSERT INTO shareddata VALUES(?,?,?,?,?,?)");
					
				
				ps.setString(1,IPAddress0);
				ps.setString(2,FFilePath0);
				ps.setString(3,EncryptedText);
				ps.setString(4,Key);
				ps.setString(5,FileName0);
				ps.setString(6,DecryptText);
				
				int i=ps.executeUpdate();
				
				if(i==1){
					
					JOptionPane.showMessageDialog(null,"Successfully Data Send");
				}
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				}
				
				
				
				
                //User1 Adding Files TO DB IF The Network is Connected
				
				if(IPAddress1!=null&&Conn1!="Not Connected"&&FFilePath1!=null){
				
				try
				{
				DBConnection co=new DBConnection();
				
				Connection c=(Connection)co.con();
				
				
				BufferedReader br=new BufferedReader(new FileReader(FFilePath1));
				
				
				
				while((line1=br.readLine())!=null){
					
					System.out.println("File Content-->"+line1);
					Contentline1.add(line1);
				}
				
				System.out.println("Contentline1-->"+Contentline1.toString());
				
				String Value=Contentline1.toString();
				
				byte[] text=Value.getBytes();
				
				
				KeyGenerator key=KeyGenerator.getInstance("DES");
				
				SecretKey sk=key.generateKey();
				
				Cipher cip=Cipher.getInstance("DES");
				
				
				cip.init(Cipher.ENCRYPT_MODE,sk);
				
				byte[] EText=cip.doFinal(text);
				
				String EncryptedText=new String(EText);
				
				
				
                cip.init(Cipher.DECRYPT_MODE,sk);
				
				byte[] DText=cip.doFinal(EText);
				
				String DecryptText=new String(DText);
				
				PreparedStatement ps=(PreparedStatement)c.prepareStatement("INSERT INTO shareddata VALUES(?,?,?,?,?,?)");
					
				
				ps.setString(1,IPAddress1);
				ps.setString(2,FFilePath1);
				ps.setString(3,EncryptedText);
				ps.setString(4,Key);
				ps.setString(5,FileName1);
				ps.setString(6,DecryptText);
				int i=ps.executeUpdate();
				
				if(i==1){
					
					JOptionPane.showMessageDialog(null,"Successfully Data Send");
				}
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				}
				
				
				
				
				
//User2 Adding Files TO DB IF The Network is Connected
				
				if(IPAddress2!=null&&Conn2!="Not Connected"&&FFilePath2!=null){
				
				try
				{
				DBConnection co=new DBConnection();
				
				Connection c=(Connection)co.con();
				
				
				BufferedReader br=new BufferedReader(new FileReader(FFilePath2));
				
				
				
				while((line2=br.readLine())!=null){
					
					System.out.println("File Content-->"+line2);
					Contentline2.add(line2);
				}
				
				System.out.println("Contentline2-->"+Contentline2.toString());
				
				String Value=Contentline2.toString();
				
				byte[] text=Value.getBytes();
				
				
				KeyGenerator key=KeyGenerator.getInstance("DES");
				
				SecretKey sk=key.generateKey();
				
				Cipher cip=Cipher.getInstance("DES");
				
				
				cip.init(Cipher.ENCRYPT_MODE,sk);
				
				byte[] EText=cip.doFinal(text);
				
				String EncryptedText=new String(EText);
				
				
				
                cip.init(Cipher.DECRYPT_MODE,sk);
				
				byte[] DText=cip.doFinal(EText);
				
				String DecryptText=new String(DText);
				
				PreparedStatement ps=(PreparedStatement)c.prepareStatement("INSERT INTO shareddata VALUES(?,?,?,?,?,?)");
					
				
				ps.setString(1,IPAddress2);
				ps.setString(2,FFilePath2);
				ps.setString(3,EncryptedText);
				ps.setString(4,Key);
				ps.setString(5,FileName2);
				ps.setString(6,DecryptText);
				int i=ps.executeUpdate();
				
				if(i==1){
					
					JOptionPane.showMessageDialog(null,"Successfully Data Send");
				}
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				}
				
				
				
				
				
				
				
				
                //User3 Adding Files TO DB IF The Network is Connected
				
				if(IPAddress3!=null&&Conn3!="Not Connected"&&FFilePath3!=null){
				
				try
				{
				DBConnection co=new DBConnection();
				
				Connection c=(Connection)co.con();
				
				
				BufferedReader br=new BufferedReader(new FileReader(FFilePath3));
				
				
				
				while((line3=br.readLine())!=null){
					
					System.out.println("File Content-->"+line3);
					Contentline3.add(line3);
				}
				
				System.out.println("Contentline3-->"+Contentline3.toString());
				
				String Value=Contentline3.toString();
				
				byte[] text=Value.getBytes();
				
				
				KeyGenerator key=KeyGenerator.getInstance("DES");
				
				SecretKey sk=key.generateKey();
				
				Cipher cip=Cipher.getInstance("DES");
				
				
				cip.init(Cipher.ENCRYPT_MODE,sk);
				
				byte[] EText=cip.doFinal(text);
				
				String EncryptedText=new String(EText);
				
				
				
cip.init(Cipher.DECRYPT_MODE,sk);
				
				byte[] DText=cip.doFinal(EText);
				
				String DecryptText=new String(DText);
				
				PreparedStatement ps=(PreparedStatement)c.prepareStatement("INSERT INTO shareddata VALUES(?,?,?,?,?,?)");
					
				
				ps.setString(1,IPAddress3);
				ps.setString(2,FFilePath3);
				ps.setString(3,EncryptedText);
				ps.setString(4,Key);
				ps.setString(5,FileName3);
				ps.setString(6,DecryptText);
				int i=ps.executeUpdate();
				
				if(i==1){
					
					JOptionPane.showMessageDialog(null,"Successfully Data Send");
				}
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				}
				
				
				
				
                //User4 Adding Files TO DB IF The Network is Connected
				
				if(IPAddress4!=null&&Conn4!="Not Connected"&&FFilePath4!=null){
				
				try
				{
				DBConnection co=new DBConnection();
				
				Connection c=(Connection)co.con();
				
				
				BufferedReader br=new BufferedReader(new FileReader(FFilePath4));
				
				
				
				while((line4=br.readLine())!=null){
					
					System.out.println("File Content-->"+line4);
					Contentline4.add(line4);
				}
				
				System.out.println("Contentline4-->"+Contentline4.toString());
				
				String Value=Contentline4.toString();
				
				byte[] text=Value.getBytes();
				
				
				KeyGenerator key=KeyGenerator.getInstance("DES");
				
				SecretKey sk=key.generateKey();
				
				Cipher cip=Cipher.getInstance("DES");
				
				
				cip.init(Cipher.ENCRYPT_MODE,sk);
				
				byte[] EText=cip.doFinal(text);
				
				String EncryptedText=new String(EText);
				
				
cip.init(Cipher.DECRYPT_MODE,sk);
				
				byte[] DText=cip.doFinal(EText);
				
				String DecryptText=new String(DText);
				
				PreparedStatement ps=(PreparedStatement)c.prepareStatement("INSERT INTO shareddata VALUES(?,?,?,?,?,?)");
					
				
				ps.setString(1,IPAddress4);
				ps.setString(2,FFilePath4);
				ps.setString(3,EncryptedText);
				ps.setString(4,Key);
				ps.setString(5,FileName4);
				ps.setString(6,DecryptText);
				int i=ps.executeUpdate();
				
				if(i==1){
					
					JOptionPane.showMessageDialog(null,"Successfully Data Send");
				}
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				}
				
				
				
				
				
				
				
//User5 Adding Files TO DB IF The Network is Connected
				
				if(IPAddress5!=null&&Conn5!="Not Connected"&&FFilePath5!=null){
				
				try
				{
				DBConnection co=new DBConnection();
				
				Connection c=(Connection)co.con();
				
				
				BufferedReader br=new BufferedReader(new FileReader(FFilePath5));
				
				
				
				while((line5=br.readLine())!=null){
					
					System.out.println("File Content-->"+line5);
					Contentline5.add(line5);
				}
				
				System.out.println("Contentline5-->"+Contentline5.toString());
				
				String Value=Contentline5.toString();
				
				byte[] text=Value.getBytes();
				
				
				KeyGenerator key=KeyGenerator.getInstance("DES");
				
				SecretKey sk=key.generateKey();
				
				Cipher cip=Cipher.getInstance("DES");
				
				
				cip.init(Cipher.ENCRYPT_MODE,sk);
				
				byte[] EText=cip.doFinal(text);
				
				String EncryptedText=new String(EText);
				
				
				
                cip.init(Cipher.DECRYPT_MODE,sk);
				
				byte[] DText=cip.doFinal(EText);
				
				String DecryptText=new String(DText);
				
				PreparedStatement ps=(PreparedStatement)c.prepareStatement("INSERT INTO shareddata VALUES(?,?,?,?,?,?)");
					
				
				ps.setString(1,IPAddress5);
				ps.setString(2,FFilePath5);
				ps.setString(3,EncryptedText);
				ps.setString(4,Key);
				ps.setString(5,FileName5);
				ps.setString(6,DecryptText);
				int i=ps.executeUpdate();
				
				if(i==1){
					
					JOptionPane.showMessageDialog(null,"Successfully Data Send");
				}
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				}
				
				
				
				
				
                //User6 Adding Files TO DB IF The Network is Connected
				
				if(IPAddress6!=null&&Conn6!="Not Connected"&&FFilePath6!=null){
				
				try
				{
				DBConnection co=new DBConnection();
				
				Connection c=(Connection)co.con();
				
				
				BufferedReader br=new BufferedReader(new FileReader(FFilePath6));
				
				
				
				while((line6=br.readLine())!=null){
					
					System.out.println("File Content-->"+line6);
					Contentline6.add(line6);
				}
				
				System.out.println("Contentline6-->"+Contentline6.toString());
				
				String Value=Contentline6.toString();
				
				byte[] text=Value.getBytes();
				
				
				KeyGenerator key=KeyGenerator.getInstance("DES");
				
				SecretKey sk=key.generateKey();
				
				Cipher cip=Cipher.getInstance("DES");
				
				
				cip.init(Cipher.ENCRYPT_MODE,sk);
				
				byte[] EText=cip.doFinal(text);
				
				String EncryptedText=new String(EText);
				
				
cip.init(Cipher.DECRYPT_MODE,sk);
				
				byte[] DText=cip.doFinal(EText);
				
				String DecryptText=new String(DText);
				
				PreparedStatement ps=(PreparedStatement)c.prepareStatement("INSERT INTO shareddata VALUES(?,?,?,?,?,?)");
					
				
				ps.setString(1,IPAddress6);
				ps.setString(2,FFilePath6);
				ps.setString(3,EncryptedText);
				ps.setString(4,Key);
				ps.setString(5,FileName6);
				ps.setString(6,DecryptText);
				int i=ps.executeUpdate();
				
				if(i==1){
					
					JOptionPane.showMessageDialog(null,"Successfully Data Send");
				}
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				}
				
				
				
				
				
				
				
//User7 Adding Files TO DB IF The Network is Connected
				
				if(IPAddress7!=null&&Conn7!="Not Connected"&&FFilePath7!=null){
				
				try
				{
				DBConnection co=new DBConnection();
				
				Connection c=(Connection)co.con();
				
				
				BufferedReader br=new BufferedReader(new FileReader(FFilePath7));
				
				
				
				while((line7=br.readLine())!=null){
					
					System.out.println("File Content-->"+line7);
					Contentline7.add(line7);
				}
				
				System.out.println("Contentline7-->"+Contentline7.toString());
				
				String Value=Contentline7.toString();
				
				byte[] text=Value.getBytes();
				
				
				KeyGenerator key=KeyGenerator.getInstance("DES");
				
				SecretKey sk=key.generateKey();
				
				Cipher cip=Cipher.getInstance("DES");
				
				
				cip.init(Cipher.ENCRYPT_MODE,sk);
				
				byte[] EText=cip.doFinal(text);
				
				String EncryptedText=new String(EText);
				
				
				
                cip.init(Cipher.DECRYPT_MODE,sk);
				
				byte[] DText=cip.doFinal(EText);
				
				String DecryptText=new String(DText);
				
				PreparedStatement ps=(PreparedStatement)c.prepareStatement("INSERT INTO shareddata VALUES(?,?,?,?,?,?)");
					
				
				ps.setString(1,IPAddress7);
				ps.setString(2,FFilePath7);
				ps.setString(3,EncryptedText);
				ps.setString(4,Key);
				ps.setString(5,FileName7);
				ps.setString(6,DecryptText);
				int i=ps.executeUpdate();
				
				if(i==1){
					
					JOptionPane.showMessageDialog(null,"Successfully Data Send");
				}
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				}
				
				
				
				
				
//User8 Adding Files TO DB IF The Network is Connected
				
				if(IPAddress8!=null&&Conn8!="Not Connected"&&FFilePath8!=null){
				
				try
				{
				DBConnection co=new DBConnection();
				
				Connection c=(Connection)co.con();
				
				
				BufferedReader br=new BufferedReader(new FileReader(FFilePath8));
				
				
				
				while((line8=br.readLine())!=null){
					
					System.out.println("File Content-->"+line8);
					Contentline8.add(line8);
				}
				
				System.out.println("Contentline8-->"+Contentline8.toString());
				
				String Value=Contentline8.toString();
				
				byte[] text=Value.getBytes();
				
				
				KeyGenerator key=KeyGenerator.getInstance("DES");
				
				SecretKey sk=key.generateKey();
				
				Cipher cip=Cipher.getInstance("DES");
				
				
				cip.init(Cipher.ENCRYPT_MODE,sk);
				
				byte[] EText=cip.doFinal(text);
				
				String EncryptedText=new String(EText);
				
				
				
                cip.init(Cipher.DECRYPT_MODE,sk);
				
				byte[] DText=cip.doFinal(EText);
				
				String DecryptText=new String(DText);
				
				PreparedStatement ps=(PreparedStatement)c.prepareStatement("INSERT INTO shareddata VALUES(?,?,?,?,?,?)");
					
				
				ps.setString(1,IPAddress8);
				ps.setString(2,FFilePath8);
				ps.setString(3,EncryptedText);
				ps.setString(4,Key);
				ps.setString(5,FileName8);
				ps.setString(6,DecryptText);
				int i=ps.executeUpdate();
				
				if(i==1){
					
					JOptionPane.showMessageDialog(null,"Successfully Data Send");
				}
				
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				}
				
				
				
				
				
			}
		});
		btnSendMessage.setForeground(new Color(0, 100, 0));
		btnSendMessage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		try{
		JLabel lblName = new JLabel(NEmail.get(0).toString());
		lblName.setForeground(new Color(255, 235, 205));
		lblName.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		lblName.setBounds(215, 138, 191, 39);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel(list.get(0).toString());
		lblPassword.setForeground(new Color(255, 235, 205));
		lblPassword.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		lblPassword.setBounds(454, 138, 218, 39);
		contentPane.add(lblPassword);
		
		JLabel lblPicture = new JLabel(NName.get(0).toString());
		lblPicture.setForeground(new Color(255, 235, 205));
		lblPicture.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		lblPicture.setBounds(29, 138, 159, 39);
		contentPane.add(lblPicture);
		
		final Button button = new Button("Select File");
		button.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		button.setForeground(new Color(240, 255, 255));
		button.setBackground(new Color(0, 206, 209));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    FilePath0=selectedFile.getAbsolutePath();
				    FileName0=selectedFile.getName();
				    
				    
				    System.out.println("File Path1_-->"+FilePath0);
				    
				   // System.out.println("Selected file1: " + selectedFile.getAbsolutePath());
				}
				
			
				
				
			}
		});
		button.setBounds(733, 138, 133, 39);
		contentPane.add(button);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		try{
		if(NEmail.get(1).toString()!=null){
		Button button_1 = new Button("Select File");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    FileName1=selectedFile.getName();
				    FilePath1=selectedFile.getAbsolutePath();	
				    System.out.println("File Path2_-->"+FilePath1);
				    //System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
				
			}
		});
		button_1.setForeground(new Color(240, 255, 255));
		button_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		button_1.setBackground(new Color(0, 206, 209));
		button_1.setBounds(733, 210, 133, 39);
		contentPane.add(button_1);
		
		JLabel label = new JLabel(list.get(1).toString());
		label.setForeground(new Color(255, 235, 205));
		label.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label.setBounds(454, 210, 218, 39);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel(NEmail.get(1).toString());
		label_1.setForeground(new Color(255, 235, 205));
		label_1.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_1.setBounds(215, 210, 191, 39);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel(NName.get(1).toString());
		label_2.setForeground(new Color(255, 235, 205));
		label_2.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_2.setBounds(29, 210, 159, 39);
		contentPane.add(label_2);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		try{
		if(NEmail.get(2).toString()!=null){
		Button button_2 = new Button("Select File");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    FilePath2=selectedFile.getAbsolutePath();	
				    FileName2=selectedFile.getName();
				    System.out.println("File Path3_-->"+FilePath2);
				    //System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
			}
		});
		button_2.setForeground(new Color(240, 255, 255));
		button_2.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		button_2.setBackground(new Color(0, 206, 209));
		button_2.setBounds(733, 291, 133, 39);
		contentPane.add(button_2);
		
		JLabel label_3 = new JLabel(list.get(2).toString());
		label_3.setForeground(new Color(255, 235, 205));
		label_3.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_3.setBounds(454, 291, 218, 39);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel(NEmail.get(2).toString());
		label_4.setForeground(new Color(255, 235, 205));
		label_4.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_4.setBounds(215, 291, 191, 39);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel(NName.get(2).toString());
		label_5.setForeground(new Color(255, 235, 205));
		label_5.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_5.setBounds(29, 291, 159, 39);
		contentPane.add(label_5);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		try{
		if(NEmail.get(3).toString()!=null){
		Button button_3 = new Button("Select File");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    FilePath3=selectedFile.getAbsolutePath();
				    FileName3=selectedFile.getName();
				    System.out.println("File Path4_-->"+FilePath3);
				   // System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
			}
		});
		button_3.setForeground(new Color(240, 255, 255));
		button_3.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		button_3.setBackground(new Color(0, 206, 209));
		button_3.setBounds(733, 370, 133, 39);
		contentPane.add(button_3);
		
		JLabel label_6 = new JLabel(list.get(3).toString());
		label_6.setForeground(new Color(255, 235, 205));
		label_6.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_6.setBounds(454, 370, 218, 39);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel(NEmail.get(3).toString());
		label_7.setForeground(new Color(255, 235, 205));
		label_7.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_7.setBounds(215, 370, 191, 39);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel(NName.get(3).toString());
		label_8.setForeground(new Color(255, 235, 205));
		label_8.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_8.setBounds(29, 370, 159, 39);
		contentPane.add(label_8);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		try{
        if(NEmail.get(4).toString()!=null){
		Button button_4 = new Button("Select File");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    FilePath4=selectedFile.getAbsolutePath();
				    FileName4=selectedFile.getName();
				    System.out.println("File Path5_-->"+FilePath4);
				   // System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
			}
		});
		button_4.setForeground(new Color(240, 255, 255));
		button_4.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		button_4.setBackground(new Color(0, 206, 209));
		button_4.setBounds(733, 449, 133, 39);
		contentPane.add(button_4);
		
		JLabel label_9 = new JLabel(list.get(4).toString());
		label_9.setForeground(new Color(255, 235, 205));
		label_9.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_9.setBounds(454, 449, 218, 39);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel(NEmail.get(4).toString());
		label_10.setForeground(new Color(255, 235, 205));
		label_10.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_10.setBounds(215, 449, 191, 39);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel(NName.get(4).toString());
		label_11.setForeground(new Color(255, 235, 205));
		label_11.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_11.setBounds(29, 449, 159, 39);
		contentPane.add(label_11);
        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		try{
		if(NEmail.get(5).toString()!=null){
		Button button_5 = new Button("Select File");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    FilePath5=selectedFile.getAbsolutePath();
				    FileName5=selectedFile.getName();
				    System.out.println("File Path6_-->"+FilePath5);
				  //  System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
			}
		});
		button_5.setForeground(new Color(240, 255, 255));
		button_5.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		button_5.setBackground(new Color(0, 206, 209));
		button_5.setBounds(733, 538, 133, 39);
		contentPane.add(button_5);
		
		JLabel label_12 = new JLabel(list.get(5).toString());
		label_12.setForeground(new Color(255, 235, 205));
		label_12.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_12.setBounds(454, 538, 218, 39);
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel(NEmail.get(5).toString());
		label_13.setForeground(new Color(255, 235, 205));
		label_13.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_13.setBounds(215, 538, 191, 39);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel(NName.get(5).toString());
		label_14.setForeground(new Color(255, 235, 205));
		label_14.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_14.setBounds(29, 538, 159, 39);
		contentPane.add(label_14);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		try{
		if(NEmail.get(6).toString()!=null){
		Button button_6 = new Button("Select File");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    FilePath6=selectedFile.getAbsolutePath();	
				    FileName6=selectedFile.getName();
				    System.out.println("File Path7_-->"+FilePath6);
				   // System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
			}
		});
		button_6.setForeground(new Color(240, 255, 255));
		button_6.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		button_6.setBackground(new Color(0, 206, 209));
		button_6.setBounds(733, 617, 133, 39);
		contentPane.add(button_6);
		
		JLabel label_15 = new JLabel(list.get(6).toString());
		label_15.setForeground(new Color(255, 235, 205));
		label_15.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_15.setBounds(454, 617, 218, 39);
		contentPane.add(label_15);
		
		JLabel label_16 = new JLabel(NEmail.get(6).toString());
		label_16.setForeground(new Color(255, 235, 205));
		label_16.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_16.setBounds(215, 617, 191, 39);
		contentPane.add(label_16);
		
		JLabel label_17 = new JLabel(NName.get(6).toString());
		label_17.setForeground(new Color(255, 235, 205));
		label_17.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_17.setBounds(29, 617, 159, 39);
		contentPane.add(label_17);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		try{
		if(NEmail.get(7).toString()!=null){
		Button button_7 = new Button("Select File");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				     FilePath7=selectedFile.getAbsolutePath();
				     FileName7=selectedFile.getName();
				    System.out.println("File Path8_-->"+FilePath7);
				    
				   // System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
			}
		});
		button_7.setForeground(new Color(240, 255, 255));
		button_7.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		button_7.setBackground(new Color(0, 206, 209));
		button_7.setBounds(733, 686, 133, 39);
		contentPane.add(button_7);
		
		JLabel label_18 = new JLabel(list.get(7).toString());
		label_18.setForeground(new Color(255, 235, 205));
		label_18.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_18.setBounds(454, 686, 218, 39);
		contentPane.add(label_18);
		
		JLabel label_19 = new JLabel(NEmail.get(7).toString());
		label_19.setForeground(new Color(255, 235, 205));
		label_19.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_19.setBounds(215, 686, 191, 39);
		contentPane.add(label_19);
		
		JLabel label_20 = new JLabel(NName.get(7).toString());
		label_20.setForeground(new Color(255, 235, 205));
		label_20.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_20.setBounds(29, 686, 159, 39);
		contentPane.add(label_20);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		try{
		if(NEmail.get(8).toString()!=null){
		JLabel label_21 = new JLabel(NName.get(8).toString());
		label_21.setForeground(new Color(255, 235, 205));
		label_21.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_21.setBounds(29, 740, 159, 39);
		contentPane.add(label_21);
		
		JLabel label_22 = new JLabel(NEmail.get(8).toString());
		label_22.setForeground(new Color(255, 235, 205));
		label_22.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_22.setBounds(215, 740, 191, 39);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel(list.get(8).toString());
		label_23.setForeground(new Color(255, 235, 205));
		label_23.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		label_23.setBounds(454, 740, 218, 39);
		contentPane.add(label_23);
		
		Button button_8 = new Button("Select File");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				     FilePath8=selectedFile.getAbsolutePath();
				     FileName8=selectedFile.getName();
				    System.out.println("File Path9_-->"+FilePath8);
				    
				   // System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
				
			}
		});
		button_8.setForeground(new Color(240, 255, 255));
		button_8.setFont(new Font("Baskerville Old Face", Font.BOLD, 20));
		button_8.setBackground(new Color(0, 206, 209));
		button_8.setBounds(733, 740, 133, 39);
		contentPane.add(button_8);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
