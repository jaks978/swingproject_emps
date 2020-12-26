package com.demo.sampleproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class AdminConsoleWindow extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmpId;
	private JTextField tf_empname;
	private JLabel lblupdates;
	static DataCommunicator communicator;
	String empid,empname,empaddress;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminConsoleWindow frame = new AdminConsoleWindow();
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
	public AdminConsoleWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 458, 623);
		setTitle("Admin Console");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 32, 150, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeName.setBounds(23, 113, 150, 50);
		contentPane.add(lblEmployeeName);
		
		JLabel lblEmployeeAddress = new JLabel("Employee Address");
		lblEmployeeAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmployeeAddress.setBounds(23, 201, 150, 50);
		contentPane.add(lblEmployeeAddress);
		
		tfEmpId = new JTextField();
		tfEmpId.setBounds(183, 35, 200, 50);
		contentPane.add(tfEmpId);
		tfEmpId.setColumns(10);
		
		tf_empname = new JTextField();
		tf_empname.setColumns(10);
		tf_empname.setBounds(183, 113, 200, 50);
		contentPane.add(tf_empname);
		
		JTextArea taAddress = new JTextArea();
		taAddress.setBounds(183, 216, 200, 146);
		contentPane.add(taAddress);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empid = tfEmpId.getText();
				empname = tf_empname.getText();
				empaddress = taAddress.getText();
				if(!empid.isEmpty())
				{
					if(!empname.isEmpty()||!empaddress.isEmpty())
					{
						EmployeeClass.addEmpDetails(empid, empname, empaddress);
						printUpdates("Details Added");
						publishUpdates("New Employee Added");
						publishUpdates("Details\n/**************************/\n");
						publishUpdates("Employee ID :"+empid);
						publishUpdates("Employee Name :"+empname);
						publishUpdates("Employee Address :"+empaddress);
					}
					else
					{
						printUpdates("Empty Fields Found ");
					}
					
				}
				else
				{
					printUpdates("Please Enter Employee ID ");
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(23, 425, 150, 50);
		contentPane.add(btnAdd);
		
		JButton btnUpd = new JButton("Update");
		btnUpd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empid = tfEmpId.getText();
				empname = tf_empname.getText();
				empaddress = taAddress.getText();
				if(!empid.isEmpty())
				{
					if(EmployeeClass.checkEmpDetails(empid))
					{
						if(!empname.isEmpty()||!empaddress.isEmpty())
						{
							EmployeeClass.addEmpDetails(empid, empname, empaddress);
							printUpdates("Details Updated");
							publishUpdates("Employee Details updated");
							publishUpdates("Details\n/**************************/\n");
							publishUpdates("Employee ID :"+empid);
							publishUpdates("Employee Name :"+empname);
							publishUpdates("Employee Address :"+empaddress);
						}
						else
						{
							printUpdates("Empty Fields Found ");
						}
					}
					else
					{
						printUpdates("Employee ID :"+empid+" Not exist to update ");
					}
					
					
				}
				else
				{
					printUpdates("Please Enter Employee ID ");
				}
			}
		});
		btnUpd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpd.setBounds(216, 425, 156, 50);
		contentPane.add(btnUpd);
		
		JButton btnDel = new JButton("Delete");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empid = tfEmpId.getText();
				
				if(!empid.isEmpty())
				{
					if(EmployeeClass.checkEmpDetails(empid))
					{
							EmployeeClass.deleteEmpDetails(empid);
							printUpdates("Employee ID:"+empid+" Deleted");
							publishUpdates("Employee ID:"+empid+" Deleted");
					
					}
					else
					{
						printUpdates("Employee ID :"+empid+" Not exist to Delete ");
						publishUpdates("Employee ID :"+empid+" Not exist to Delete ");
					}
					
					
				}
				else
				{
					printUpdates("Please Enter Employee ID ");
					publishUpdates("Please Enter Employee ID ");
				}
			}
		});
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDel.setBounds(23, 485, 150, 50);
		contentPane.add(btnDel);
		
		lblupdates = new JLabel("");
		lblupdates.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblupdates.setBounds(22, 526, 400, 50);
		contentPane.add(lblupdates);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				empid = tfEmpId.getText();
				empname = tf_empname.getText();
				empaddress = taAddress.getText();
				if(!empid.isEmpty())
				{
					if(EmployeeClass.checkEmpDetails(empid))
					{
						
							Employee employee= EmployeeClass.getEmpDetails(empid);
							tf_empname.setText(employee.getName());
							taAddress.setText(employee.getAdress());
							
						
					}
					else
					{
						printUpdates("Employee ID :"+empid+" Not exist to Display ");
					}
					
					
				}
				else
				{
					printUpdates("Please Enter Employee ID ");
				}
			}
		});
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnView.setBounds(216, 485, 156, 50);
		contentPane.add(btnView);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				communicator = null;
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	public void printUpdates(String update)
	{
		lblupdates.setText(update);
	}
	
	public void publishUpdates(String update)
	{	
		if(communicator!=null)
		{
			communicator.publishData("\n");
			communicator.publishData(update);
		}
		
	}
	
	public static void startComm(DataCommunicator _communicator)
	{
		if(communicator==null)
		{
			communicator = _communicator;
		}
		
	}
}
