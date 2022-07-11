import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class patientStatus extends JFrame {

	
	public String doctorsTimeForNormalPateints;
	/*
	 * Here 3 timings wouuld  be there separted by space
	 * like 9:00 9:00 9:00
	 * this is default timing
	 * 1st Indicating Dr Muhammad Haseeb
	 * 2nd Indicating Dr Avinash Kumar
	 * 3rd Indicating Dr Abdul Hafeez
	 */
	LocalDate today = LocalDate.now();
	
	
    String formattedDate = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));

    /*
     * Current Date of the system
     */

    /*
     * Machine time by default in 24 hours so we need to make them into 12 hours
     */
    public static String ConvertInto12Hours(String current)
    {
        if(Integer.parseInt(current)>=0 && Integer.parseInt(current)<=12)
            return current;

        return(Integer.toString(Integer.parseInt(current)-12));


    }

    /*
     * Get the Minutes difference
     * curTime refers to current machine time and previous time refers to the last time in the file
     *
     */
    /*
     * Time format would be AB:CD
     */
    public static int getMinutesDifference(String curTime,String previousTime)
    {
    	
        int curTimeHours;

        int curTimeMinutes;


        int previousTimeHours;

        int previousTimeMinutes;

        String tempString="";

        for(int i = 0 ; i<curTime.indexOf(':');i++)
        {
            tempString+=curTime.charAt(i);
        }

        curTimeHours = Integer.parseInt(tempString);

        tempString="";

        for(int i = curTime.indexOf(':')+1; i<curTime.length();i++)
        {
            tempString+=curTime.charAt(i);
        }

        curTimeMinutes = Integer.parseInt(tempString);


        tempString="";

        for(int i = 0 ; i<previousTime.indexOf(':');i++)
        {
            tempString+=previousTime.charAt(i);
        }

        previousTimeHours = Integer.parseInt(tempString);

        tempString="";

        for(int i = previousTime.indexOf(':')+1; i<previousTime.length();i++)
        {
            tempString+=previousTime.charAt(i);
        }

        previousTimeMinutes = Integer.parseInt(tempString);

        curTimeMinutes = (curTimeHours*60)+curTimeMinutes;


        previousTimeMinutes = (previousTimeHours*60)+previousTimeMinutes;
/*
 * Absolute method is being used to neglect the negative sign
 */
        return(Math.abs(curTimeMinutes-previousTimeMinutes));

    }

    public static String increaseTenMinutes(String time)
    {

        if(Integer.parseInt(time.substring(time.indexOf(':')+1,time.length()))<=50)
        {
            return time.substring(0, time.indexOf(':')+1)+Integer.toString(Integer.parseInt(time.substring(time.indexOf(':')+1))+10);
        }
        String formattedTime = Integer.toString(Integer.parseInt(time.substring(0, time.indexOf(':')))+1)+":0"+Integer.toString(60-Integer.parseInt(time.substring(time.indexOf(':')+1)));


        return(ConvertInto12Hours(formattedTime.substring(0, 2).charAt(1) == ':'?formattedTime.substring(0, 1):formattedTime.substring(0, 2))+(formattedTime.substring(0, 2).charAt(1) == ':'?formattedTime.substring(1, 4):formattedTime.substring(2, 5)));

    }
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField ageField;
	private JTextField weightField;

	
	

	/**
	 * Create the frame.
	 */
	public patientStatus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Name");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setForeground(SystemColor.menu);
		lblNewLabel_1_1_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1.setBounds(50, 127, 57, 20);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		JLabel lblNewLabel_1_1_1_1 = new JLabel("PATIENT INFO");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(SystemColor.menu);
		lblNewLabel_1_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 26));
		lblNewLabel_1_1_1_1.setBounds(24, 65, 320, 59);
		contentPane.add(lblNewLabel_1_1_1_1);
		nameField = new JTextField();
		nameField.setBounds(153, 129, 168, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		 
		ageField = new JTextField();
		ageField.setColumns(10);
		ageField.setBounds(153, 160, 168, 20);
		contentPane.add(ageField);
		
		weightField = new JTextField();
		weightField.setColumns(10);
		weightField.setBounds(153, 195, 168, 20);
		contentPane.add(weightField);
		 
		JComboBox statusField = new JComboBox();
		statusField.setBackground(SystemColor.inactiveCaption);
		statusField.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Serious"}));
		statusField.setBounds(151, 242, 170, 22);
		contentPane.add(statusField);
		
		JComboBox doctorField = new JComboBox();
		doctorField.setModel(new DefaultComboBoxModel(new String[] {"Dr. Muhammad Haseeb", "Dr. Avinash Kumar", "Dr. Abdul Hafeez Jagirani", "", ""}));
		doctorField.setBackground(SystemColor.inactiveCaption);
		doctorField.setBounds(151, 281, 170, 22);
		contentPane.setBorder(new LineBorder(new Color(255, 0, 0), 3));
		contentPane.add(doctorField);
		 
		JButton Assign = new JButton("Assign");
		Assign.setForeground(SystemColor.desktop);
		Assign.setBackground(SystemColor.activeCaption);
		
		 
		Assign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
			try {
				
				if(nameField.getText().isEmpty())
				{
					
					throw new RuntimeException("Kindly enter the name i.e.  Muhammad Haseeb / Avinash Kumar / Hafeez ");
					
				}
				
				if(Integer.parseInt(ageField.getText())<=0 | Integer.parseInt(ageField.getText())>200)
				{
					ageField.setText("");
					throw new RuntimeException("Kindly enter the correct age i.e. age must lie between 1 to 200");
				
				}
				
				if(Float.parseFloat(weightField.getText())<=0 | Float.parseFloat(weightField.getText())>400)
				{
					weightField.setText("");
					throw new RuntimeException("Kindly enter the correct weight i.e. weight must lie between 1 to 400!");
					
				}
				
				/*
				 * This records file store the patients info for long term
				 */
				FileWriter write = new FileWriter(new File("records.txt"),true);
				

			
				
			
				
				
			
                LocalTime todayTime = LocalTime.now();
                String formattedTime = todayTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
                
                formattedTime = ConvertInto12Hours(formattedTime.substring(0, 2))+formattedTime.substring(2,5);
				
                /*
                 * If file is flushed then set the  default time to 9:00
                 */
                
                if(new File("drsTimingForNormal.txt").length() == 0)
                {
                	FileWriter file = new FileWriter(new File("drsTimingForNormal.txt"));
                	
                	file.write("9:00 9:00 9:00");
                	
                	file.close();
                	doctorsTimeForNormalPateints = "9:00 9:00 9:00";
                }
                else
                {
                	Scanner scan = new Scanner(new File("drsTimingForNormal.txt"));
                	
                	doctorsTimeForNormalPateints = scan.nextLine();
                	
                	scan.close();
                	
                }
                
               /*
                * Now the operations would be same in all bodies but text files data 
                * would assessed separately according with the selected doctor
                */
				
				if(doctorField.getSelectedItem().equals("Dr. Avinash Kumar"))
				{
					if(statusField.getSelectedItem().equals("Normal"))
					{
						if(getMinutesDifference(formattedTime,doctorsTimeForNormalPateints.split(" ")[1])<=10)
						{
							formattedTime=increaseTenMinutes(doctorsTimeForNormalPateints.split(" ")[1]);
							System.out.println("Formatted New Time:"+formattedTime);
							
						}
						
						Scanner scan = new Scanner(new File("drsTimingForNormal.txt"));
	                	
	                	String UpdatedTime[] = scan.nextLine().split(" ");
	                	
	                	scan.close();
	                	
						FileWriter file = new FileWriter(new File("drsTimingForNormal.txt"));
	                	
	                	file.write(UpdatedTime[0]+" "+formattedTime+" "+UpdatedTime[2]);
	                	
	                	file.close();
						
					}
					
					new PriorityQueue().insert(new Node(nameField.getText(),statusField.getSelectedItem().equals("Serious")?'S':'N',Integer.parseInt(ageField.getText()),Float.parseFloat(weightField.getText()),formattedTime),2);
					
					
				}
				else if(doctorField.getSelectedItem().equals("Dr. Abdul Hafeez Jagirani"))
				{
					if(statusField.getSelectedItem().equals("Normal"))
					{
						if(getMinutesDifference(formattedTime,doctorsTimeForNormalPateints.split(" ")[2])<=10)
						{
							formattedTime=increaseTenMinutes(doctorsTimeForNormalPateints.split(" ")[2]);
							
							
						}
						
						Scanner scan = new Scanner(new File("drsTimingForNormal.txt"));
	                	
	                	String UpdatedTime[] = scan.nextLine().split(" ");
	                	
	                	scan.close();
	                	
						FileWriter file = new FileWriter(new File("drsTimingForNormal.txt"));
	                	
	                	file.write(UpdatedTime[0]+" "+UpdatedTime[2]+" "+formattedTime);
	                	
	                	file.close();
						
					}
					new PriorityQueue().insert(new Node(nameField.getText(),statusField.getSelectedItem().equals("Serious")?'S':'N',Integer.parseInt(ageField.getText()),Float.parseFloat(weightField.getText()),formattedTime),3);
				}
				else
				{

					if(statusField.getSelectedItem().equals("Normal"))
					{
						if(getMinutesDifference(formattedTime,doctorsTimeForNormalPateints.split(" ")[0])<=10)
						{
							formattedTime=increaseTenMinutes(doctorsTimeForNormalPateints.split(" ")[0]);
							
							
						}
						
						Scanner scan = new Scanner(new File("drsTimingForNormal.txt"));
	                	
	                	String UpdatedTime[] = scan.nextLine().split(" ");
	                	
	                	scan.close();
	                	
						FileWriter file = new FileWriter(new File("drsTimingForNormal.txt"));
	                	
	                	file.write(formattedTime+" "+UpdatedTime[1]+" "+UpdatedTime[1]);
	                	
	                	file.close();
						
					}
					new PriorityQueue().insert(new Node(nameField.getText(),statusField.getSelectedItem().equals("Serious")?'S':'N',Integer.parseInt(ageField.getText()),Float.parseFloat(weightField.getText()),formattedTime),1);
				}
				
			
				
				
				
				String tempName = nameField.getText().split(" ").length!=1?nameField.getText().replace(' ', '.'):nameField.getText();
                
                write.write(tempName+" "+ageField.getText()+" "+weightField.getText()+" "+statusField.getSelectedItem()+" "+doctorField.getSelectedItem()+" "+formattedDate+" "+formattedTime+"\n");
                
             
                
				JOptionPane.showMessageDialog(contentPane, "Name: "+nameField.getText()+"\n"+"-------------------"+"\n"+"Age: "+ageField.getText()+"\n"+"-------------------"+"\n"+"Weight: "+weightField.getText()+"kgs"+"\n"+"-------------------"+"\n"+"Condition: "+statusField.getSelectedItem()+"\n"+"-------------------"+"\n"+"Date:"+formattedDate+"\n"+"-------------------"+"\nTime:"+formattedTime+"\n"+"-------------------"+"\n"+"Consultant Doctor: "+doctorField.getSelectedItem());
			
				JTextField printField = new JTextField( "Name: "+nameField.getText()+"\n"+"-------------------"+"\n"+"Age: "+ageField.getText()+"\n"+"-------------------"+"\n"+"Weight: "+weightField.getText()+"kgs"+"\n"+"-------------------"+"\n"+"Condition: "+statusField.getSelectedItem()+"\n"+"-------------------"+"\n"+"Date:"+formattedDate+"\n"+"-------------------"+"\nTime:"+formattedTime+"\n"+"-------------------"+"\n"+"Consultant Doctor: "+doctorField.getSelectedItem());
				write.close();
				
				try {
					
					if(printField.print())
					{
						JOptionPane.showMessageDialog(contentPane,"Printed Successfully...");
					}
					else
					{
						JOptionPane.showMessageDialog(contentPane,"Printed Unsuccessfully...");
					}
				} catch (Exception e1) {
					
					JOptionPane.showMessageDialog(contentPane, e1.getMessage());
				}
				
				nameField.setText(null);
				ageField.setText(null);
				weightField.setText(null);
				
				
				
				
				
			} catch (Exception e1) {
				
				JOptionPane.showMessageDialog(contentPane, e1.getMessage());
			}
			
			
				
				
			}
				
			
			
		});
		Assign.setBounds(153, 327, 168, 23);
		contentPane.add(Assign);
		
		JButton Records = new JButton("Display The Current Records");
		Records.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Records();
			}
		});
		Records.setFont(new Font("Segoe UI", Font.BOLD, 13));
		Records.setBackground(SystemColor.activeCaptionBorder);
		Records.setBounds(450, 8, 232, 23);
		contentPane.add(Records);
		
		JButton btnFlushThePrevious = new JButton("Flush The Previous Records");
		btnFlushThePrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					FileWriter file1 = new FileWriter(new File("dr1.txt"));
					FileWriter file2 = new FileWriter(new File("dr2.txt"));
					FileWriter file3 = new FileWriter(new File("dr3.txt"));
					FileWriter file = new FileWriter(new File("drsTimingForNormal.txt"));
                	
                	file.write("9:00 9:00 9:00");
                	
                	file.close();
                	doctorsTimeForNormalPateints = "9:00 9:00 9:00";
					file1.close();
					file2.close();
					file3.close();
					
					
					JOptionPane.showMessageDialog(contentPane,"The Hospital's previous data has been flushed.\n						Now You can put new records for today Dated "+formattedDate+"\n"+"					Have a Nice Day :)");
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnFlushThePrevious.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnFlushThePrevious.setBackground(SystemColor.activeCaptionBorder);
		btnFlushThePrevious.setBounds(43, 11, 256, 23);
		contentPane.add(btnFlushThePrevious);

		JLabel lblNewLabel_1_1_1_1_1_4 = new JLabel("Name");
		lblNewLabel_1_1_1_1_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_4.setForeground(SystemColor.BLACK);
		lblNewLabel_1_1_1_1_1_4.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1_4.setBounds(78, 130, 71, 20);
		contentPane.add(lblNewLabel_1_1_1_1_1_4);
		this.setVisible(true);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Age");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_1.setForeground(SystemColor.BLACK);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1_1.setBounds(60, 158, 27, 20);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Weight(Kgs)");
		lblNewLabel_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_2.setForeground(SystemColor.BLACK);
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1_2.setBounds(56, 193, 87, 20);
		contentPane.add(lblNewLabel_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1_3 = new JLabel("Condition");
		lblNewLabel_1_1_1_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_3.setForeground(SystemColor.BLACK);
		lblNewLabel_1_1_1_1_1_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1_3.setBounds(50, 241, 71, 20);
		contentPane.add(lblNewLabel_1_1_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_1_1_3_1 = new JLabel("Consultant Dr:");
		lblNewLabel_1_1_1_1_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_3_1.setForeground(SystemColor.BLACK);
		lblNewLabel_1_1_1_1_1_3_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_1_1_1_1_1_3_1.setBounds(35, 280, 125, 20);
		contentPane.add(lblNewLabel_1_1_1_1_1_3_1);

	}
}
