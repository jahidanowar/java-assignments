package Auth;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField nameField;
	
	/*
	 * Database Credentials
	 */
	private String DB_URI = "jdbc:mysql://localhost/";
	private String DB_NAME = "sellify";
	private String DB_USER = "root";
	private String DB_PASS = "";
	Connection db;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		
		// DB Connection
		try {
			db = DriverManager.getConnection(DB_URI+DB_NAME,DB_USER,DB_PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.WHITE);
		contentPane.add(panelCenter, BorderLayout.CENTER);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{0, 0, 0, 0, 146, 0, 0, 0, 0, 0};
		gbl_panelCenter.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCenter.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		JLabel nameLabel = new JLabel("Full Name");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameLabel.anchor = GridBagConstraints.SOUTH;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 4;
		gbc_nameLabel.gridy = 2;
		panelCenter.add(nameLabel, gbc_nameLabel);
		
		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.ipady = 10;
		gbc_nameField.anchor = GridBagConstraints.NORTH;
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 4;
		gbc_nameField.gridy = 3;
		panelCenter.add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Username*");
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.anchor = GridBagConstraints.SOUTH;
		gbc_usernameLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usernameLabel.gridx = 4;
		gbc_usernameLabel.gridy = 4;
		panelCenter.add(usernameLabel, gbc_usernameLabel);
		
		usernameField = new JTextField();
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.ipady = 10;
		gbc_usernameField.anchor = GridBagConstraints.NORTH;
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.insets = new Insets(0, 0, 5, 5);
		gbc_usernameField.gridx = 4;
		gbc_usernameField.gridy = 5;
		panelCenter.add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password*");
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.anchor = GridBagConstraints.SOUTH;
		gbc_passwordLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 4;
		gbc_passwordLabel.gridy = 6;
		panelCenter.add(passwordLabel, gbc_passwordLabel);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.ipady = 10;
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 7;
		panelCenter.add(passwordField, gbc_passwordField);
		
		JButton registerBtn = new JButton("Register");
		
		registerBtn.setForeground(Color.WHITE);
		registerBtn.setBackground(Color.BLACK);
		registerBtn.setFocusPainted(false);
		GridBagConstraints gbc_registerBtn = new GridBagConstraints();
		gbc_registerBtn.ipady = 10;
		gbc_registerBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_registerBtn.insets = new Insets(0, 0, 5, 5);
		gbc_registerBtn.gridx = 4;
		gbc_registerBtn.gridy = 8;
		panelCenter.add(registerBtn, gbc_registerBtn);
		
		
		JLabel result = new JLabel("");
		GridBagConstraints gbc_result = new GridBagConstraints();
		gbc_result.insets = new Insets(0, 0, 5, 5);
		gbc_result.gridx = 4;
		gbc_result.gridy = 9;
		panelCenter.add(result, gbc_result);
		
		JPanel panelNorth = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelNorth.getLayout();
		flowLayout.setVgap(20);
		panelNorth.setBackground(Color.BLACK);
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel title = new JLabel("Create an account");
		title.setFont(new Font("Tahoma", Font.BOLD, 18));
		title.setForeground(Color.WHITE);
		panelNorth.add(title);
		
		
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = nameField.getText();
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				
				if(checkUserName(username) != null) {
					
					result.setText("Username is already taken by "+checkUserName(username)+". Choose an unique username");
					result.setForeground(Color.RED);
					
					return;
				}
				
				try {
					
					registerBtn.setText("Registering....");
					
					PreparedStatement stmt = db.prepareStatement("INSERT INTO users (username, password, name) VALUES(?,?,?)");
					stmt.setString(1, username.trim().toLowerCase());
					stmt.setString(2, password);
					stmt.setString(3, name);
					stmt.executeUpdate();
					
					result.setText("🙌 User has been successfully registered!");
					result.setForeground(Color.BLUE);
					
					// Reset the Input Field
					nameField.setText("");
					usernameField.setText("");
					passwordField.setText("");
					
					
				} catch(SQLException e1) {
					e1.printStackTrace();
					result.setText("🤔 Something went wrong, Try again later.");
					result.setForeground(Color.RED);
				} finally {
					registerBtn.setText("Register");
				}
				
				
				System.out.println("Register button clicked");
			}
			
		});
	}

	private String checkUserName(String uname) {
		
		try {
			
			PreparedStatement stmt = db.prepareStatement("SELECT name FROM users WHERE username=?");
			stmt.setString(1, uname);
			
			ResultSet results = stmt.executeQuery();
			
			while(results.next()) {
				return results.getString("name") != null ? results.getString("name") : null;
			}
			
			return null;
			
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
		
	}
}
