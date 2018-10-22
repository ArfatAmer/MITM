package com.Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectionPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectionPage frame = new SelectionPage();
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
	public SelectionPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(0,2,120,120));
		setContentPane(contentPane);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 832, 277);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setBounds(0, 220, 832, 57);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnGoToClient = new JButton("Go To Server Page");
		btnGoToClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				ServerLogin sl=new ServerLogin();
				sl.setVisible(true);
				dispose();
			}
		});
		btnGoToClient.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
		btnGoToClient.setForeground(new Color(138, 43, 226));
		btnGoToClient.setBounds(80, 13, 195, 25);
		panel_1.add(btnGoToClient);
		
		JButton button = new JButton("Go To Client Page");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HomePage hp=new HomePage();
				hp.setVisible(true);
				dispose();
				
			}
		});
		button.setForeground(new Color(138, 43, 226));
		button.setFont(new Font("Baskerville Old Face", Font.BOLD, 16));
		button.setBounds(530, 12, 195, 25);
		panel_1.add(button);
		
		JLabel lblAuthenticatedKeyExchange = new JLabel("Man In The Middle Attack");
		lblAuthenticatedKeyExchange.setBackground(new Color(240, 248, 255));
		lblAuthenticatedKeyExchange.setForeground(new Color(240, 255, 255));
		lblAuthenticatedKeyExchange.setFont(new Font("Baskerville Old Face", Font.BOLD | Font.ITALIC, 25));
		lblAuthenticatedKeyExchange.setBounds(257, 82, 434, 41);
		panel.add(lblAuthenticatedKeyExchange);
		
		
		ImageIcon icon=new ImageIcon("resource/images/V6.jpg");
		contentPane.setLayout(null);
		
		JLabel thumb=new JLabel();
		thumb.setBackground(new Color(218, 165, 32));
		thumb.setBounds(0, 10, 835, 743);
		
		thumb.setIcon(icon);
		contentPane.add(thumb);
	}
}
