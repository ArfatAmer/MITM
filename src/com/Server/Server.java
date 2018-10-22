package com.Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.Client.Register;
import com.Client.WelcomePage;
import com.DBConnection.DBConnection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import com.Client.*;


public class Server implements Runnable{
	
	Connection cc;
	ServerSocket serversocket;
	Socket socket;
	String User;
	
	
	
	
	public void run()
	{
		
		
		try
		{
			
			serversocket=new ServerSocket(120);
			
			System.out.println("Server Waiting for Client Port"+serversocket.getLocalPort());
			
			while(true)
			{
				socket=serversocket.accept();
				
				System.out.println(socket+"Connected");
				
				ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
				
				
				
				ArrayList<String> list=(ArrayList<String>) ois.readObject();
				
				String value=list.get(0).toString();
				
				System.out.println("Value::"+value);
				System.out.println("List::"+list);
			
				if(value.equals("Register"))
					
				{
					
					DBConnection con=new DBConnection();
					
					 cc=(Connection)con.con();
					 
					 System.out.println(cc);

					 PreparedStatement ps=(PreparedStatement)cc.prepareStatement("INSERT INTO register VALUES(?,?,?);");
					 
					 ps.setString(1,list.get(1).toString());
					 ps.setString(2,list.get(2).toString());
					 ps.setString(3,list.get(3).toString());
					 
					int i= ps.executeUpdate();
					
					System.out.println("i"+i);
					 
					 if(i==1)
					 {
						 JOptionPane.showMessageDialog(null,"Registered Successfully");
						 
						 Login l=new Login();
						 l.setVisible(true);
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null,"Registration Failed");
					 }
					
				}
				
				else if(value.equals("Login"))
				{
					
					DBConnection con=new DBConnection();
					
					 cc=(Connection)con.con();
					 
					 System.out.println(cc);
				
					 PreparedStatement ps=(PreparedStatement)cc.prepareStatement("SELECT * FROM register where IPAddress='"+list.get(1).toString()+"'  &&  LocalPortNumber='"+list.get(2).toString()+"'   ");
					
					 ResultSet rs=(ResultSet)ps.executeQuery();
					 
					 boolean status=rs.next();
					
					String User=rs.getString(1).toString();
					String Password=rs.getString(2).toString();
					 
					 System.out.println("status:::"+status);
					 System.out.println("User"+User);
					 if(status==true)
					 {
						
						 WelcomePage page=new WelcomePage(User,Password);
						 page.setVisible(true);
						 
						 
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null, "User Name or Password is Error");
						 
						 Register r=new Register();
						 r.setVisible(true);
					 }
					
				}
				
				
				
				
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String args[])
	{
		Server s=new Server();
		
		Thread t=new Thread(s);
		
		t.start();
	}

}
