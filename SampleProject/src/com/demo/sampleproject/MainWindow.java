package com.demo.sampleproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Sample Project");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sample Project");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(118, 10, 200, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAdminConsole = new JButton("Admin Console");
		btnAdminConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminConsoleWindow frame = new AdminConsoleWindow();
				frame.setVisible(true);
			}
		});
		btnAdminConsole.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdminConsole.setBounds(118, 70, 200, 50);
		frame.getContentPane().add(btnAdminConsole);
		
		JButton btnDashboardConsole = new JButton("Dashboard console");
		btnDashboardConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DashboardConsoleWindow frame = new DashboardConsoleWindow();
				frame.setVisible(true);
			}
		});
		btnDashboardConsole.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDashboardConsole.setBounds(118, 157, 200, 50);
		frame.getContentPane().add(btnDashboardConsole);
	}
}
