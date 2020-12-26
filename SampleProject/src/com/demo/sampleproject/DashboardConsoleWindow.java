package com.demo.sampleproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

public class DashboardConsoleWindow extends JFrame {

	private JPanel contentPane;
	JTextArea textArea;
	JScrollPane jScrollPane;
	DataCommunicator communicator;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardConsoleWindow frame = new DashboardConsoleWindow();
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
	public DashboardConsoleWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Dashboard Console");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textArea = new JTextArea();
		textArea.setRows(10);
		textArea.setColumns(50);
		jScrollPane = new JScrollPane(textArea);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setCaretPosition(textArea.getDocument().getLength());	
		
		contentPane.add(jScrollPane);
		pack();
		
		communicator = new DataCommunicator() {
			
			@Override
			public void publishData(String data) {
				// TODO Auto-generated method stub
				textArea.append(data);
			}
		};
		AdminConsoleWindow.startComm(communicator);
		
	}

}
