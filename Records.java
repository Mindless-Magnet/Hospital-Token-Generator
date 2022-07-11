import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Records extends JFrame {

	private JPanel contentPane;

	
	

	/**
	 * Create the frame.
	 */
	public Records() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox doctorField = new JComboBox();
		doctorField.setModel(new DefaultComboBoxModel(new String[] {"Dr. Muhammad Haseeb", "Dr. Avinash Kumar", "Dr. Abdul Hafeez Jagirani",}));
		doctorField.setBackground(SystemColor.inactiveCaption);
		doctorField.setBounds(212, 11, 172, 22);
		contentPane.setBorder(new LineBorder(new Color(255, 0, 0), 3));
		contentPane.add(doctorField);
		
		JButton Update = new JButton("Update");
		
		
		
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Vector<Object> name = new Vector<Object>();
				Vector<Object> age = new Vector<Object>();
				Vector<Object> weight = new Vector<Object>();
				Vector<Object> status = new Vector<Object>();
				Vector<Object> time = new Vector<Object>();
				String columns[]= {"Sr.No","Name","Age","Weight(Kgs)","Condition","Time"};
				Scanner scan;
				try {
					
				
					if(doctorField.getSelectedItem().equals("Dr. Avinash Kumar"))
					{
						if(new File("dr2.txt").length()<1)
							throw new RuntimeException("Empty Records!! for "+doctorField.getSelectedItem());
						
						scan = new Scanner(new File("dr2.txt"));
					

						
						while(scan.hasNext())
						{
							Object[] data = scan.nextLine().split(" ");
							
							if(((String) data[0]).split(".").length!=1)
							{
								data[0] =((String) data[0]).replace('.', ' ');
							}
							name.add(data[0]);
							
							age.add(data[1]);
							
							weight.add(data[2]);
							
							status.add(data[3]);
							
							time.add(data[4]);
							
							
							
						}
						
					scan.close();
					
					
						
						
					}
					else if(doctorField.getSelectedItem().equals("Dr. Abdul Hafeez Jagirani"))
					{
						if(new File("dr3.txt").length()<1)
							throw new RuntimeException("Empty Records!! for "+doctorField.getSelectedItem());
						scan = new Scanner(new File("dr3.txt"));
					
						
						
						
						
						while(scan.hasNext())
						{
							Object[] data = scan.nextLine().split(" ");
							
							if(((String) data[0]).split(".").length!=1)
							{
								data[0] =((String) data[0]).replace('.', ' ');
							}
							name.add(data[0]);
							
							age.add(data[1]);
							
							weight.add(data[2]);
							
							status.add(data[3]);
							
							time.add(data[4]);
							
							
							
						}
						
					scan.close();
						
						
						
				
				}
					else
					{
						if(new File("dr1.txt").length()<1)
							throw new RuntimeException("Empty Records!! for "+doctorField.getSelectedItem());
						scan = new Scanner(new File("dr1.txt"));
					
						
						
						
						
						while(scan.hasNext())
						{
							Object[] data = scan.nextLine().split(" ");
							
							if(((String) data[0]).split(".").length!=1)
							{
								data[0] =((String) data[0]).replace('.', ' ');
							}
							name.add(data[0]);
							
							age.add(data[1]);
							
							weight.add(data[2]);
							
							status.add(data[3]);
							
							time.add(data[4]);
						}
						
					scan.close();
					
						}
					
				
					
			
				Object data[][] = new Object[name.size()][6];
				
				for(int i = 0 ; i<name.size();i++)
				{
					data[i][0] = i+1;
					data[i][1] = name.get(i);
					
					data[i][2] = age.get(i);
					
					data[i][3] = weight.get(i);
					
					data[i][4] = status.get(i);
					
					
					data[i][5] = time.get(i);
					
				}
				JTable table = new JTable(data,columns);
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10, 37, 774, 450);
				contentPane.add(scrollPane);
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(contentPane,e1.getMessage());
				}
				
				
			
			}
		});
		Update.setBounds(394, 11, 110, 23);
		contentPane.add(Update);
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				new patientStatus();
			}
			
			
		});
		Back.setFont(new Font("Segoe UI Black", Font.BOLD, 11));
		Back.setBackground(SystemColor.inactiveCaption);
		Back.setBounds(10, 11, 101, 23);
		contentPane.add(Back);
		
		JLabel pic = new JLabel("");
		pic.setIcon(new ImageIcon("hospital.png"));
		pic.setBounds(0, 0, 784, 487);
		contentPane.add(pic);
		
		
		this.setVisible(true);
	}
}
