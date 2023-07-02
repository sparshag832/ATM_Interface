import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.AlgorithmParametersSpi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	private JTextField textField;
	private JPasswordField textField_1;
public int flag=0;
public String card;
public float amountdep;
public float amountwid;
//Map<Float, String>minstmtMap=new HashMap<>(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		getContentPane().setBackground(new Color(240, 230, 140));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 450);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Card Number(16 Digit Code On Your Card)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(44, 116, 349, 38);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter PIN (4 Digit Code)");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 192, 244, 30);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(56, 160, 299, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(56, 233, 86, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEchoChar('*');
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		panel.setBounds(10, 36, 964, 51);
		getContentPane().add(panel);
		panel.setLayout(null);
		

		
		JLabel lblNewLabel_3 = new JLabel("WELCOME TO APNA ATM");
		lblNewLabel_3.setBounds(352, 11, 283, 29);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("SimSun-ExtB", Font.PLAIN, 25));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("*Incase you forget the login credentials , Please visit nearest branch.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 300, 430, 38);
		getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(524, 98, 416, 302);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Info");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Hii Guys , My Name Is Sparsh. I am a final year engineering student. Stay tuned for more exciting projects."
						+ "  LinkedIn Id:https://www.linkedin.com/in/sparsh-agarwal-5a0726212");
				
			}
		});
		btnNewButton_4.setBounds(245, 185, 143, 23);
		panel_1.add(btnNewButton_4);
		btnNewButton_4.setBackground(new Color(255, 20, 147));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		
		JButton btnNewButton_1 = new JButton("Widthraw ");
		btnNewButton_1.setBounds(24, 185, 143, 23);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setForeground(new Color(255, 255, 240));
		btnNewButton_1.setBackground(new Color(178, 34, 34));
		
		
		int amount;
		JButton btnNewButton_2 = new JButton("Deposit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(flag==1)
				{
					
try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/atm?user=root&password=root");
					String qString="select balance from account where cardno = ?";
					
					PreparedStatement statement=connection.prepareStatement(qString);
					statement.setString(1, card);
					ResultSet rs=statement.executeQuery();
					//System.out.println(card);
					while(rs.next()) 
					{
						 
					
						 String dep=JOptionPane.showInputDialog("Enter The Amount To Be Deposit");
							float total=rs.getFloat(1) + Float.parseFloat(dep);
						//	minstmtMap.put(Float.parseFloat(dep)," Amount Deposit ");
							JOptionPane.showMessageDialog(null, "Deposit Succesfull , New Balance Is "+ total);
							amountdep=total;
							
					
					}
					
					String qString2="update account set balance=? where cardno =?";
					PreparedStatement statement2=connection.prepareStatement(qString2);
					
					statement2.setFloat(1, amountdep);
					statement2.setString(2, card);
					int i=statement2.executeUpdate();
					connection.close();
					
					
					 
				} 
				
				
				
				catch (Exception e2) {
					System.out.println(e2);
				}
				}//if closed
				else {
					JOptionPane.showMessageDialog(null, "First Validate The Login Credentials ");
					
				}
	
				
			}
		});
		btnNewButton_2.setBounds(245, 103, 143, 23);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(178, 34, 34));
		
		JButton btnNewButton_5 = new JButton("Check Balance");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(flag==1)
				{
					
try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/atm?user=root&password=root");
					String qString="select balance from account where cardno = ?";
					
					PreparedStatement statement=connection.prepareStatement(qString);
					statement.setString(1, card);
					ResultSet rs=statement.executeQuery();
					//System.out.println(card);
					while(rs.next()) 
					{
					JOptionPane.showMessageDialog(null, "Your Current Balance Is "+rs.getFloat(1));
					//System.out.println( rs.getInt(1));
					
					
					}
				} 
				
				
				
				catch (Exception e2) {
					System.out.println(e2);
				}
				}//if closed
				else {
					JOptionPane.showMessageDialog(null, "First Validate The Login Credentials ");
					
				}
			}
		});
		btnNewButton_5.setBounds(24, 103, 143, 23);
		panel_1.add(btnNewButton_5);
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(178, 34, 34));
		
		JLabel lblNewLabel_4 = new JLabel("AVAILABLE SERVICES");
		lblNewLabel_4.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		lblNewLabel_4.setForeground(new Color(47, 79, 79));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(63, 11, 290, 58);
		panel_1.add(lblNewLabel_4);
		
		
		JButton btnNewButton = new JButton("ENTER");
		btnNewButton.setBounds(215, 277, 143, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
					 String userValue = textField.getText();        //get user entered username from the textField1  
				     String passValue =(String) textField_1.getText();        //get user entered pasword from the textField2  
				     
				     
						
				     try {
				     					
				     					Class.forName("com.mysql.cj.jdbc.Driver");
				     					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/atm?user=root&password=root");
				     					String qString="select cardno , pin from account";
				     					
				     					PreparedStatement statement=connection.prepareStatement(qString);
				     					ResultSet rs=statement.executeQuery();
				     					while(rs.next())
				     					{
				     					String localcard=rs.getString(1);
				     					String localpin=rs.getString(2);
				     					//System.out.println(card);
				     					
		 		        if (userValue.equals(localcard) && passValue.equals(localpin))
		 		        {  //if authentic, navigate user to a new page  
				              
				          flag=1;
				          card= textField.getText();
				          textField.setText(null);
				        textField_1.setText(null);
				        JOptionPane.showMessageDialog(null,"Succesfully Logged In");
				          
				        }
				        else {
				        	JOptionPane.showMessageDialog(null, "Enter Valid Credentials");
				        	textField.setText(null);
				        	textField_1.setText(null);	
						}
				     					}
				     }
			catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
				
				
				}
		});
		
		
		
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setForeground(new Color(255, 250, 250));
		
		btnNewButton.setForeground(new Color(255, 255, 240));
		btnNewButton.setBackground(new Color(165, 42, 42));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(flag==1)
				{
					
try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/atm?user=root&password=root");
					String qString="select balance from account where cardno = ?";
					
					PreparedStatement statement=connection.prepareStatement(qString);
					statement.setString(1, card);
					ResultSet rs=statement.executeQuery();
					//System.out.println(card);
					while(rs.next()) 
					{
						 
					
						 String wid=JOptionPane.showInputDialog("Enter The Amount To Be Widthrawn");
						 Float blnc=rs.getFloat(1);
						 if(blnc>=Float.parseFloat(wid))
						 {
							float deduc=rs.getFloat(1) - Float.parseFloat(wid);
							//minstmtMap.put(Float.parseFloat(wid)," Amount Widthrawn ");
							JOptionPane.showMessageDialog(null, "Widthrawl Succesfull , New Balance Is "+ deduc);
							amountwid=deduc;
						 }
						 else {
							JOptionPane.showMessageDialog(null, "No Enough Balance");
							break;
						}
					}
					
					String qString2="update account set balance=? where cardno =?";
					PreparedStatement statement2=connection.prepareStatement(qString2);
					
					statement2.setFloat(1, amountwid);
					statement2.setString(2, card);
					int i=statement2.executeUpdate();
					connection.close();
					
					
					 
				} 
				
				
				
				catch (Exception e2) {
					System.out.println(e2);
				}
				}//if closed
				else {
					JOptionPane.showMessageDialog(null, "First Validate The Login Credentials ");
					
				}
	
	
				
				
			}
		});
	}
}
