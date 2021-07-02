import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.TextArea;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class UIFinalMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField_s1_lower;
	private JTextField textField_s0_lower;
	private JTextField textField_s0_upper;
	private JTextField textField_s1_upper;
	private JTextField textField_1_lower;
	private JTextField textField_0_lower;
	private JTextField textField_0_upper;
	private JTextField textField_1_upper;
	private JTextField textField_sizepoints;
	private JTextField textField_image;
	
	DataPreparing preData = new DataPreparing ();
	BinaryNumberToString toString = new BinaryNumberToString();
	CodeToImage toImage = new CodeToImage();
    String saveto = "D://test.jpg";

    String strRet="";
    int divisionposition = 0;
    double stZeroLower = 0;
    double stZeroUpper = 0;
    double stOneLower = 0;
    double stOneUpper = 0;
    double ZeroLower = 0;
    double ZeroUpper = 0;
    double OneLower = 0;
    double OneUpper = 0;
 
    int dedivisionposition = 1790;
    double destZeroLower = 412;
    double destZeroUpper = 417;
    double destOneLower = 406;
    double destOneUpper = 410;
    double deZeroLower = 334;
    double deZeroUpper = 337;
    double deOneLower = 328;
    double deOneUpper = 333;
  
    int sizeOfpoints = 290;
    int desizeOfpoints = 290;

    
    int divisionpositionsubmit = 0;
    int startzeroonesubmit = 0;
    int zeroonesubmit = 0;
    int numofpointsubmit = 0;
    private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIFinalMain frame = new UIFinalMain();
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
	public UIFinalMain() {
		setTitle("UNIVERSAL TANDEM MASS DECODER ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel_TitledBorder = new JPanel();
		panel_TitledBorder.setBounds(10, 10, 543, 362);
        panel_TitledBorder.setBorder(BorderFactory.createTitledBorder("Parameter Setting"));
        contentPane.add(panel_TitledBorder);
        panel_TitledBorder.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Division position:");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setBounds(37, 26, 133, 18);
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
        panel_TitledBorder.add(lblNewLabel_1);
        
        textField_sizepoints = new JTextField();
        textField_sizepoints.setColumns(10);
        textField_sizepoints.setBounds(185, 63, 86, 30);
        
        TextArea textArea_incorrect = new TextArea();
        textArea_incorrect.setBounds(22, 18, 499, 89);
        
        TextArea textArea_2 = new TextArea();
        textArea_2.setBounds(121, 277, 399, 63);
        
        TextArea textArea_1 = new TextArea();
        textArea_1.setBounds(121, 134, 399, 63);
        
        TextArea textArea = new TextArea();
        textArea.setBounds(121, 55, 399, 63);
        
        JButton btnNewButton_4 = new JButton("Submit");
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				String s = textField.getText();
				if (s.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "No Input");
				}
				else
				{
					divisionposition = Integer.parseInt(s);
				}
			    divisionpositionsubmit = 1;

			}
        });
        btnNewButton_4.setBounds(304, 20, 85, 30);
        btnNewButton_4.setFont(new Font("Arial", Font.PLAIN, 14));
        panel_TitledBorder.add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("Default");
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				divisionposition = 0;
				textField.setText(String.valueOf(dedivisionposition));
				
				toString.CodeTextInitialize();
		        preData.ListInitialize();
		        
		        divisionpositionsubmit = 0;

			}
        });
        btnNewButton_5.setBounds(419, 20, 103, 30);
        btnNewButton_5.setFont(new Font("Arial", Font.PLAIN, 14));
        panel_TitledBorder.add(btnNewButton_5);
        
        JLabel lblNewLabel_2 = new JLabel("Range of code 0-T:");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(37, 168, 139, 15);
        panel_TitledBorder.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Range of code 1-T:");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(37, 208, 139, 15);
        panel_TitledBorder.add(lblNewLabel_3);
        
        textField_s1_lower = new JTextField();
        textField_s1_lower.setColumns(10);
        textField_s1_lower.setBounds(185, 200, 66, 30);
        panel_TitledBorder.add(textField_s1_lower);
        
        textField_s0_lower = new JTextField();
        textField_s0_lower.setColumns(10);
        textField_s0_lower.setBounds(185, 160, 66, 30);
        panel_TitledBorder.add(textField_s0_lower);
        
        JLabel lblNewLabel_4 = new JLabel("Lower");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(185, 140, 66, 15);
        panel_TitledBorder.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Upper");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(310, 140, 54, 15);
        panel_TitledBorder.add(lblNewLabel_5);
        
        textField_s0_upper = new JTextField();
        textField_s0_upper.setColumns(10);
        textField_s0_upper.setBounds(304, 160, 66, 30);
        panel_TitledBorder.add(textField_s0_upper);
        
        textField_s1_upper = new JTextField();
        textField_s1_upper.setColumns(10);
        textField_s1_upper.setBounds(304, 200, 66, 30);
        panel_TitledBorder.add(textField_s1_upper);
        
        JButton btnNewButton_7 = new JButton("Default");
        btnNewButton_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				stZeroLower = 0;
				stZeroUpper = 0;
				stOneLower = 0;
				stOneUpper = 0;

				textField_s0_lower.setText(String.valueOf(destZeroLower));
				textField_s0_upper.setText(String.valueOf(destZeroUpper));
				textField_s1_lower.setText(String.valueOf(destOneLower));
				textField_s1_upper.setText(String.valueOf(destOneUpper));
				
				toString.CodeTextInitialize();
		        preData.ListInitialize();
		        

		        startzeroonesubmit = 0;

			}
        });
        btnNewButton_7.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNewButton_7.setBounds(419, 200, 103, 30);
        panel_TitledBorder.add(btnNewButton_7);
        
        JButton btnNewButton_6 = new JButton("Submit");
        btnNewButton_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				String zerolower = textField_s0_lower.getText();
				String zeroupper = textField_s0_upper.getText();
				String onelower = textField_s1_lower.getText();
				String oneupper = textField_s1_upper.getText();

				
				
				if (zerolower.isEmpty() || zeroupper.isEmpty() || onelower.isEmpty() || oneupper.isEmpty())
				{
					JOptionPane.showMessageDialog(contentPane, "No input!!");
				}
				else if ((Double.parseDouble(zerolower) > Double.parseDouble(zeroupper)) || (Double.parseDouble(onelower) > Double.parseDouble(oneupper)))
				{
					JOptionPane.showMessageDialog(contentPane, "Check the input, LOWER has to be smaller than UPPER!!");
				}
				else
				{
					stZeroLower = Double.parseDouble(zerolower);
					stZeroUpper = Double.parseDouble(zeroupper);
					stOneLower = Double.parseDouble(onelower);
					stOneUpper = Double.parseDouble(oneupper);
				}
			    startzeroonesubmit = 1;

			}
        });
        btnNewButton_6.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNewButton_6.setBounds(419, 160, 103, 30);
        panel_TitledBorder.add(btnNewButton_6);
        
        JLabel lblNewLabel_2_1 = new JLabel("Range of code 0-T:");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_2_1.setBounds(37, 290, 139, 15);
        panel_TitledBorder.add(lblNewLabel_2_1);
        
        JLabel lblNewLabel_3_1 = new JLabel("Range of code 1-T:");
        lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_3_1.setBounds(37, 330, 139, 15);
        panel_TitledBorder.add(lblNewLabel_3_1);
        
        textField_1_lower = new JTextField();
        textField_1_lower.setColumns(10);
        textField_1_lower.setBounds(185, 322, 66, 30);
        panel_TitledBorder.add(textField_1_lower);
        
        textField_0_lower = new JTextField();
        textField_0_lower.setColumns(10);
        textField_0_lower.setBounds(185, 282, 66, 30);
        panel_TitledBorder.add(textField_0_lower);
        
        JLabel lblNewLabel_4_1 = new JLabel("Lower");
        lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_4_1.setBounds(185, 260, 66, 15);
        panel_TitledBorder.add(lblNewLabel_4_1);
        
        JLabel lblNewLabel_5_1 = new JLabel("Upper");
        lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5_1.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_5_1.setBounds(310, 260, 54, 15);
        panel_TitledBorder.add(lblNewLabel_5_1);
        
        textField_0_upper = new JTextField();
        textField_0_upper.setColumns(10);
        textField_0_upper.setBounds(304, 282, 66, 30);
        panel_TitledBorder.add(textField_0_upper);
        
        textField_1_upper = new JTextField();
        textField_1_upper.setColumns(10);
        textField_1_upper.setBounds(304, 322, 66, 30);
        panel_TitledBorder.add(textField_1_upper);
        
        JButton btnNewButton_7_1 = new JButton("Default");
        btnNewButton_7_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				ZeroLower = 0;
				ZeroUpper = 0;
				OneLower = 0;
				OneUpper = 0;

				textField_0_lower.setText(String.valueOf(deZeroLower));
				textField_0_upper.setText(String.valueOf(deZeroUpper));
				textField_1_lower.setText(String.valueOf(deOneLower));
				textField_1_upper.setText(String.valueOf(deOneUpper));
				
				toString.CodeTextInitialize();
		        preData.ListInitialize();

		        zeroonesubmit = 0;

			}
        });
        btnNewButton_7_1.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNewButton_7_1.setBounds(419, 322, 103, 30);
        panel_TitledBorder.add(btnNewButton_7_1);
        
        JButton btnNewButton_6_1 = new JButton("Submit");
        btnNewButton_6_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				String zerolower = textField_0_lower.getText();
				String zeroupper = textField_0_upper.getText();
				String onelower = textField_1_lower.getText();
				String oneupper = textField_1_upper.getText();

				
				
				if (zerolower.isEmpty() || zeroupper.isEmpty() || onelower.isEmpty() || oneupper.isEmpty())
				{
					JOptionPane.showMessageDialog(contentPane, "No input!!");
				}
				else if ((Double.parseDouble(zerolower) > Double.parseDouble(zeroupper)) || (Double.parseDouble(onelower) > Double.parseDouble(oneupper)))
				{
					JOptionPane.showMessageDialog(contentPane, "Check the input, LOWER has to be smaller than UPPER!!");
				}
				else
				{
					ZeroLower = Double.parseDouble(zerolower);
					ZeroUpper = Double.parseDouble(zeroupper);
					OneLower = Double.parseDouble(onelower);
					OneUpper = Double.parseDouble(oneupper);
				}

			    zeroonesubmit = 1;
			}
        });
        btnNewButton_6_1.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNewButton_6_1.setBounds(419, 282, 103, 30);
        panel_TitledBorder.add(btnNewButton_6_1);
        
        JLabel lblSizeOfPeak = new JLabel("Size of Peak Points:");
        lblSizeOfPeak.setHorizontalAlignment(SwingConstants.LEFT);
        lblSizeOfPeak.setForeground(Color.BLACK);
        lblSizeOfPeak.setFont(new Font("Arial", Font.PLAIN, 14));
        lblSizeOfPeak.setBackground(Color.YELLOW);
        lblSizeOfPeak.setBounds(37, 62, 139, 33);
        panel_TitledBorder.add(lblSizeOfPeak);
        

        panel_TitledBorder.add(textField_sizepoints);
        
        JButton btnNewButton_6_1_1 = new JButton("Submit");
        btnNewButton_6_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				String s = textField_sizepoints.getText();
				if (s.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "No input, Set the value to default of " + sizeOfpoints);
				}
				else if (Integer.parseInt(s) == 0)
				{
					JOptionPane.showMessageDialog(null, "Wrong Input!! Can not be 0!!");
				}
				else
				{
					sizeOfpoints = Integer.parseInt(s);
				}
				

			    numofpointsubmit = 1;
			}
        });
        btnNewButton_6_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNewButton_6_1_1.setBounds(304, 63, 85, 30);
        panel_TitledBorder.add(btnNewButton_6_1_1);
        
        JButton btnNewButton_7_1_1 = new JButton("Default");
        btnNewButton_7_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				sizeOfpoints = desizeOfpoints;
				String strRet = Integer.toString(sizeOfpoints);
				textField_sizepoints.setText(strRet);
				
			    numofpointsubmit = 0;

			}
        });
        btnNewButton_7_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNewButton_7_1_1.setBounds(419, 63, 103, 30);
        panel_TitledBorder.add(btnNewButton_7_1_1);
        
        JPanel panel_TitledBorder_1 = new JPanel();
        panel_TitledBorder_1.setBounds(0, 120, 543, 119);
        panel_TitledBorder.add(panel_TitledBorder_1);
        panel_TitledBorder_1.setLayout(null);
        panel_TitledBorder_1.setBorder(BorderFactory.createTitledBorder("m/z range WITH α-terminal"));
        
        JPanel panel_TitledBorder_1_1 = new JPanel();
        panel_TitledBorder_1_1.setLayout(null);
        panel_TitledBorder_1_1.setBorder(BorderFactory.createTitledBorder("m/z range WITHOUT α-terminal"));
        panel_TitledBorder_1_1.setBounds(0, 243, 543, 119);
        panel_TitledBorder.add(panel_TitledBorder_1_1);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(185, 20, 86, 30);
        panel_TitledBorder.add(textField);
        
        JPanel panel_TitledBorder_2 = new JPanel();
        panel_TitledBorder_2.setBounds(563, 10, 543, 362);
        panel_TitledBorder_2.setLayout(null);
        panel_TitledBorder_2.setBorder(BorderFactory.createTitledBorder("Code to Text"));
        contentPane.add(panel_TitledBorder_2);
        
        JButton btnNewButton_2 = new JButton("Load single file and run");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    			
				if (textField.getText().isEmpty() || divisionpositionsubmit == 0)
					textField.setText(String.valueOf(dedivisionposition));
				else if (divisionpositionsubmit == 1)
					textField.setText(String.valueOf(divisionposition));
				
				if (textField_s0_lower.getText().isEmpty() || startzeroonesubmit == 0)
					textField_s0_lower.setText(String.valueOf(destZeroLower));
				else if (startzeroonesubmit == 1)
					textField_s0_lower.setText(String.valueOf(stZeroLower));

				
				if (textField_s0_upper.getText().isEmpty() || startzeroonesubmit == 0)
					textField_s0_upper.setText(String.valueOf(destZeroUpper));
				else if (startzeroonesubmit == 1)
					textField_s0_upper.setText(String.valueOf(stZeroUpper));

				if (textField_s1_lower.getText().isEmpty() || startzeroonesubmit == 0)
					textField_s1_lower.setText(String.valueOf(destOneLower));
				else if (startzeroonesubmit == 1)
					textField_s1_lower.setText(String.valueOf(stOneLower));

				if (textField_s1_upper.getText().isEmpty() || startzeroonesubmit == 0)
					textField_s1_upper.setText(String.valueOf(destOneUpper));
				else if (startzeroonesubmit == 1)
					textField_s1_upper.setText(String.valueOf(stOneUpper));

				if (textField_1_lower.getText().isEmpty() || zeroonesubmit == 0)
					textField_1_lower.setText(String.valueOf(deOneLower));
				else if (zeroonesubmit == 1)
					textField_1_lower.setText(String.valueOf(OneLower));

				if (textField_1_upper.getText().isEmpty() || zeroonesubmit == 0)
					textField_1_upper.setText(String.valueOf(deOneUpper));
				else if (zeroonesubmit == 1)
					textField_1_upper.setText(String.valueOf(OneUpper));

				if (textField_0_lower.getText().isEmpty() || zeroonesubmit == 0)
					textField_0_lower.setText(String.valueOf(deZeroLower));
				else if (zeroonesubmit == 1)
					textField_0_lower.setText(String.valueOf(ZeroLower));

				if (textField_0_upper.getText().isEmpty() || zeroonesubmit == 0)
					textField_0_upper.setText(String.valueOf(deZeroUpper));
				else if (zeroonesubmit == 1)
					textField_0_upper.setText(String.valueOf(ZeroUpper));

				if (textField_sizepoints.getText().isEmpty() || numofpointsubmit == 0)
					textField_sizepoints.setText(String.valueOf(desizeOfpoints));
				else if (numofpointsubmit == 1)
					textField_sizepoints.setText(String.valueOf(sizeOfpoints));

				
				JFileChooser fs = new JFileChooser(new File("D:\\"));
				fs.setDialogTitle("Open a File");
				fs.setFileFilter(new FileSave(".txt","Text File"));
				int result = fs.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION)
				{
					File file = fs.getSelectedFile();
					try
					{

						
						//BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
						Path inputpath = Paths.get(file.getPath());
				        List<String> inputlines = Files.readAllLines(inputpath, StandardCharsets.UTF_8);

				      //----------------------Data Parser---------------------------------
				        DataParserAndToArray parser = new DataParserAndToArray();
				        // set up a loop over the input data
				        for (String line : inputlines) {
				            parser.parseLine(line);
				        }
				        //char[][] chars = parser.getChars();
				        double[] Xaxis= parser.getChars();
				        int[] ints = parser.getInts();
				        
				        //textArea.setText(Arrays.toString(ints));
				        
				        preData.DataLoad(ints, Xaxis);
				        preData.DataDivision(divisionposition);
			        	//textArea.setText("Data Loaded!!");
			            //textArea_1.setText(null);
			            
			            
			            int[] priInts = preData.returnPriInts(); 
				        int[] posInts = preData.returnPosInts();
				        double[] priXaxis = preData.returnPriaxis(); 
				        double[] posXaxis = preData.returnPosaxis();
				        
				        if (priInts.length ==0)
				        {
				        	textArea.setText("No Input!!");
				        }
				        else
				        {
		        	
				        	CheckZeroOne finalCode = new CheckZeroOne();
				        	finalCode.GetZeroOne(priInts, priXaxis, posInts, posXaxis, sizeOfpoints, stZeroLower, stZeroUpper, stOneLower, stOneUpper, ZeroLower, ZeroUpper, OneLower, OneUpper);
				        	finalCode.checkFinalPeak();
				        	finalCode.FinalCodeList();
				        	ArrayList<Integer> code = finalCode.returnCodeList();
				        	textArea.setText(inputpath + " >> " + code.toString());
				        	
				        	
				    		ArrayListToIntArray toArray = new ArrayListToIntArray();
				    		int[] codevalue = toArray.ListToIntArray(code);
		        	
				        	//Integer Array to String
				        	String strRet="";
				            for(int i : codevalue) {
				                strRet+=Integer.toString(i);
				            }
				            textArea_1.setText(strRet);
				        	textArea_2.setText("PeakAxis>> " + finalCode.returnPeakAxis() + "\n" + "tempPeakAxis>> " + finalCode.returntempPeakAxis() + "\n" + "PeakValue>> " + finalCode.returnpeakValue());

				            
				        }
				        preData.ListInitialize();
				        
					}
					catch (Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
			}
        });
        btnNewButton_2.setForeground(Color.BLUE);
        btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNewButton_2.setBounds(175, 23, 232, 27);
        panel_TitledBorder_2.add(btnNewButton_2);
        
        JButton btnNewButton_1 = new JButton("Save");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser(new File("D:\\"));
				fs.setDialogTitle("Save a File");
				fs.setFileFilter(new FileSave(".txt","Text File"));
				int result = fs.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION)
				{
					String content = textArea.getText();
					File file = fs.getSelectedFile();
					try
					{
						FileWriter fw = new FileWriter(file.getPath() + ".txt");
						fw.write(content);
						fw.flush();
						fw.close();
					}
					catch (Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
			}
        });
        btnNewButton_1.setForeground(Color.BLUE);
        btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNewButton_1.setBounds(417, 23, 103, 27);
        panel_TitledBorder_2.add(btnNewButton_1);
        
        JLabel lblSignleCode = new JLabel("Signle code:");
        lblSignleCode.setForeground(Color.BLUE);
        lblSignleCode.setFont(new Font("Arial", Font.PLAIN, 14));
        lblSignleCode.setBackground(Color.YELLOW);
        lblSignleCode.setBounds(22, 79, 93, 15);
        panel_TitledBorder_2.add(lblSignleCode);
        

        panel_TitledBorder_2.add(textArea);
        
        JLabel lblCodeString_1 = new JLabel("Code string:");
        lblCodeString_1.setForeground(Color.BLUE);
        lblCodeString_1.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCodeString_1.setBackground(Color.YELLOW);
        lblCodeString_1.setBounds(22, 158, 86, 15);
        panel_TitledBorder_2.add(lblCodeString_1);
        

        panel_TitledBorder_2.add(textArea_1);
        
        JButton btnNewButton_3 = new JButton("Load files and run");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

				long startTime = System.currentTimeMillis();    //获取开始时间
				
				textArea.setText(null);
				textArea_1.setText(null);
	            textArea_2.setText(null);
	            textArea_incorrect.setText(null);

	            if (textField.getText().isEmpty() || divisionpositionsubmit == 0)
					textField.setText(String.valueOf(dedivisionposition));
				else if (divisionpositionsubmit == 1)
					textField.setText(String.valueOf(divisionposition));
				
				if (textField_s0_lower.getText().isEmpty() || startzeroonesubmit == 0)
					textField_s0_lower.setText(String.valueOf(destZeroLower));
				else if (startzeroonesubmit == 1)
					textField_s0_lower.setText(String.valueOf(stZeroLower));

				
				if (textField_s0_upper.getText().isEmpty() || startzeroonesubmit == 0)
					textField_s0_upper.setText(String.valueOf(destZeroUpper));
				else if (startzeroonesubmit == 1)
					textField_s0_upper.setText(String.valueOf(stZeroUpper));

				if (textField_s1_lower.getText().isEmpty() || startzeroonesubmit == 0)
					textField_s1_lower.setText(String.valueOf(destOneLower));
				else if (startzeroonesubmit == 1)
					textField_s1_lower.setText(String.valueOf(stOneLower));

				if (textField_s1_upper.getText().isEmpty() || startzeroonesubmit == 0)
					textField_s1_upper.setText(String.valueOf(destOneUpper));
				else if (startzeroonesubmit == 1)
					textField_s1_upper.setText(String.valueOf(stOneUpper));

				if (textField_1_lower.getText().isEmpty() || zeroonesubmit == 0)
					textField_1_lower.setText(String.valueOf(deOneLower));
				else if (zeroonesubmit == 1)
					textField_1_lower.setText(String.valueOf(OneLower));

				if (textField_1_upper.getText().isEmpty() || zeroonesubmit == 0)
					textField_1_upper.setText(String.valueOf(deOneUpper));
				else if (zeroonesubmit == 1)
					textField_1_upper.setText(String.valueOf(OneUpper));

				if (textField_0_lower.getText().isEmpty() || zeroonesubmit == 0)
					textField_0_lower.setText(String.valueOf(deZeroLower));
				else if (zeroonesubmit == 1)
					textField_0_lower.setText(String.valueOf(ZeroLower));

				if (textField_0_upper.getText().isEmpty() || zeroonesubmit == 0)
					textField_0_upper.setText(String.valueOf(deZeroUpper));
				else if (zeroonesubmit == 1)
					textField_0_upper.setText(String.valueOf(ZeroUpper));

				if (textField_sizepoints.getText().isEmpty() || numofpointsubmit == 0)
					textField_sizepoints.setText(String.valueOf(desizeOfpoints));
				else if (numofpointsubmit == 1)
					textField_sizepoints.setText(String.valueOf(sizeOfpoints));
				
	            
		        preData.ListInitialize();
				toString.CodeTextInitialize();

	            JFileChooser jfc = new JFileChooser(new File("D:\\"));
	            jfc.setDialogTitle("Open a File");
	            jfc.setFileFilter(new FileSave(".txt","Text File"));

				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfc.showOpenDialog(null);
				File dir = jfc.getSelectedFile();
				File files[] = dir.listFiles();

//==============according modified time to load files===================
//				if (!TextCheckBox_filename.isSelected())
//				{
					Arrays.sort(files, new Comparator<File>() {
						public int compare(File f1, File f2) {
							long diff = f1.lastModified() - f2.lastModified();
							if (diff > 0)
								return 1;
							else if (diff == 0)
								return 0;
							else
								return -1;//若是 if 中修改成 返回-1 同时此处修改成返回 1 排序就会是递减
						}

						public boolean equals(Object obj) {
							return true;
						}

					});
//				}
							
//====================================================================================	
					
/*				
				else
				{
//==============according filename to load files===================
					Arrays.sort(files, new Comparator<File>() 
					{
						@Override
						public int compare(File o1, File o2) 
						{
							String s1 = extractNumber(o1.getName());
							String s2 = extractNumber(o2.getName());
							
							String[] s1Parts = s1.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
				            String[] s2Parts = s2.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

				            int i = 0;
				            while(i < s1Parts.length && i < s2Parts.length){

				                //if parts are the same
				                if(s1Parts[i].compareTo(s2Parts[i]) == 0){
				                    ++i;
				                }else{
				                    try{

				                        int intS1 = Integer.parseInt(s1Parts[i]);
				                        int intS2 = Integer.parseInt(s2Parts[i]);

				                        //if the parse works

				                        int diff = intS1 - intS2; 
				                        if(diff == 0){
				                            ++i;
				                        }else{
				                            return diff;
				                        }
				                    }catch(Exception ex){
				                        return s1.compareTo(s2);
				                    }
				                }//end else
				            }//end while

				            //Handle if one string is a prefix of the other.
				            // nothing comes before something.
				            if(s1.length() < s2.length()){
				                return -1;
				            }else if(s1.length() > s2.length()){
				                return 1;
				            }else{
				                return 0;
				            }
						}

						private String extractNumber(String name) 
						{
							String number="";
							try {
								//int s = name.indexOf('_')+1;
								int e = name.lastIndexOf('-');
								number = name.substring(0, e);
							} catch(Exception e) {
								number = ""; // if filename does not match the format
								// then default to 0
							}
							return number;
						}
					});	
				}
//====================================================================================			

*/				
				
				
	    	    ArrayList<String> comparison = new ArrayList<String>();

				
				for (int i = 0; i < files.length; i++) 
				{
					System.out.println("file: " + files[i]);
					try
					{

						//BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
						Path inputpath = Paths.get(files[i].getPath());
				        List<String> inputlines = Files.readAllLines(inputpath, StandardCharsets.UTF_8);

				      //----------------------Data Parser---------------------------------
				        DataParserAndToArray parser = new DataParserAndToArray();
				        // set up a loop over the input data
				        for (String line : inputlines) {
				            parser.parseLine(line);
				        }
				        //char[][] chars = parser.getChars();
				        double[] Xaxis= parser.getChars();
				        int[] ints = parser.getInts();
				        
				        //textArea.setText(Arrays.toString(ints));
				        
				        preData.DataLoad(ints, Xaxis);
				        preData.DataDivision(divisionposition);
				        int[] priInts = preData.returnPriInts(); 
				        int[] posInts = preData.returnPosInts();
				        double[] priXaxis = preData.returnPriaxis(); 
				        double[] posXaxis = preData.returnPosaxis();
				        
				        if (priInts.length ==0)
				        {
				        	textArea.setText("No Input!!");
				        }
				        else
				        {
				        	CheckZeroOne finalCode = new CheckZeroOne();
				        	finalCode.GetZeroOne(priInts, priXaxis, posInts, posXaxis, sizeOfpoints, stZeroLower, stZeroUpper, stOneLower, stOneUpper, ZeroLower, ZeroUpper, OneLower, OneUpper);
				        	finalCode.checkFinalPeak();
				        	finalCode.FinalCodeList();
				        	ArrayList<Integer> code = finalCode.returnCodeList();
				        	textArea.setText(inputpath + " >> " + code.toString());

				    		ArrayListToIntArray toArray = new ArrayListToIntArray();
				    		int[] codevalue = toArray.ListToIntArray(code);
				    		

				    		String tempstr = "";
				    		toString.CombineCodes(codevalue);
				    		tempstr = toString.returnCodeString();
				            textArea_1.setText(tempstr);
				           
				    		//check incorrectly recognized codes
				        	if (!inputpath.toString().contains(toString.CheckCodes(codevalue)) || toString.CheckCodes(codevalue).length() < 4)
				        	{
				        		comparison.add(inputpath.toString() + ">> " + toString.CheckCodes(codevalue) + "\n");
				        	}

				        }
				        preData.ListInitialize();


					}
					catch (Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
	    		toString.CodeToText();
	            strRet = toString.returnText();
	            textArea_2.setText(strRet);
				toString.CodeTextInitialize();
				
				long endTime = System.currentTimeMillis();    //获取结束时间
				
				if (comparison.isEmpty())
				{
					System.out.println("All Correct!!"); //check the code
					textArea_incorrect.setText("All Correct!!" + "\n" + "Run Time: " + (endTime-startTime)/1000 + "second");
				}
				else
				{
					System.out.println(comparison); //check the code
					textArea_incorrect.setText(String.valueOf(comparison) + "\n" + "Run Time: " + (endTime-startTime)/1000 + "second");

				}
			}
        });
        btnNewButton_3.setForeground(Color.RED);
        btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNewButton_3.setBounds(245, 243, 185, 27);
        panel_TitledBorder_2.add(btnNewButton_3);
        
        JButton btnNewButton_1_1 = new JButton("Save");
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				//JFileChooser fs = new JFileChooser(new File("D:\\"));
				JFileChooser fs = new JFileChooser();

				fs.setDialogTitle("Save a File");
				fs.setFileFilter(new FileSave(".txt","Text File"));
				int result = fs.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION)
				{
					String content = textArea_2.getText();
					File file = fs.getSelectedFile();
					try
					{
						FileWriter fw = new FileWriter(file.getPath() + ".txt");
						fw.write(content);
						fw.flush();
						fw.close();
					}
					catch (Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
			}
        });
        btnNewButton_1_1.setForeground(Color.RED);
        btnNewButton_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNewButton_1_1.setBounds(440, 243, 80, 27);
        panel_TitledBorder_2.add(btnNewButton_1_1);
        
        JLabel lblCodeToText = new JLabel("Code to Text:");
        lblCodeToText.setHorizontalAlignment(SwingConstants.LEFT);
        lblCodeToText.setForeground(Color.RED);
        lblCodeToText.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCodeToText.setBackground(Color.YELLOW);
        lblCodeToText.setBounds(22, 301, 93, 15);
        panel_TitledBorder_2.add(lblCodeToText);
        

        panel_TitledBorder_2.add(textArea_2);
        
        JPanel panel_TitledBorder_2_1 = new JPanel();
        panel_TitledBorder_2_1.setBounds(10, 382, 543, 117);
        panel_TitledBorder_2_1.setLayout(null);
        panel_TitledBorder_2_1.setBorder(BorderFactory.createTitledBorder("Code to Image"));
        contentPane.add(panel_TitledBorder_2_1);
        
        JLabel lblCodeToText_1 = new JLabel("Code to Text:");
        lblCodeToText_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblCodeToText_1.setForeground(Color.RED);
        lblCodeToText_1.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCodeToText_1.setBackground(Color.YELLOW);
        lblCodeToText_1.setBounds(22, 301, 93, 15);
        panel_TitledBorder_2_1.add(lblCodeToText_1);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("No. of Codes Per Line:");
        lblNewLabel_3_1_1.setForeground(Color.BLACK);
        lblNewLabel_3_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_3_1_1.setBounds(22, 52, 173, 15);
        panel_TitledBorder_2_1.add(lblNewLabel_3_1_1);
        
        textField_image = new JTextField();
        textField_image.setColumns(10);
        textField_image.setBounds(186, 46, 66, 27);
        panel_TitledBorder_2_1.add(textField_image);
        
        JButton btnNewButton_saveimage = new JButton("Save to");
        btnNewButton_saveimage.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				JFileChooser fs = new JFileChooser();

				fs.setDialogTitle("Save a File");
				int result = fs.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION)
				{
					File file = fs.getSelectedFile();
					try
					{
						saveto = file.getPath().toString();
						
					}
					catch (Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
			}
        });
        btnNewButton_saveimage.setForeground(Color.BLACK);
        btnNewButton_saveimage.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNewButton_saveimage.setBounds(262, 46, 91, 27);
        panel_TitledBorder_2_1.add(btnNewButton_saveimage);
        
        JButton btnNewButton_3_ToImage = new JButton("Choose and run");
        btnNewButton_3_ToImage.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
				
				long startTime = System.currentTimeMillis();    //获取开始时间
				
				textArea.setText(null);
				textArea_1.setText(null);
	            textArea_2.setText(null);
	            textArea_incorrect.setText(null);

	            if (textField.getText().isEmpty() || divisionpositionsubmit == 0)
					textField.setText(String.valueOf(dedivisionposition));
				else if (divisionpositionsubmit == 1)
					textField.setText(String.valueOf(divisionposition));
				
				if (textField_s0_lower.getText().isEmpty() || startzeroonesubmit == 0)
					textField_s0_lower.setText(String.valueOf(destZeroLower));
				else if (startzeroonesubmit == 1)
					textField_s0_lower.setText(String.valueOf(stZeroLower));

				
				if (textField_s0_upper.getText().isEmpty() || startzeroonesubmit == 0)
					textField_s0_upper.setText(String.valueOf(destZeroUpper));
				else if (startzeroonesubmit == 1)
					textField_s0_upper.setText(String.valueOf(stZeroUpper));

				if (textField_s1_lower.getText().isEmpty() || startzeroonesubmit == 0)
					textField_s1_lower.setText(String.valueOf(destOneLower));
				else if (startzeroonesubmit == 1)
					textField_s1_lower.setText(String.valueOf(stOneLower));

				if (textField_s1_upper.getText().isEmpty() || startzeroonesubmit == 0)
					textField_s1_upper.setText(String.valueOf(destOneUpper));
				else if (startzeroonesubmit == 1)
					textField_s1_upper.setText(String.valueOf(stOneUpper));

				if (textField_1_lower.getText().isEmpty() || zeroonesubmit == 0)
					textField_1_lower.setText(String.valueOf(deOneLower));
				else if (zeroonesubmit == 1)
					textField_1_lower.setText(String.valueOf(OneLower));

				if (textField_1_upper.getText().isEmpty() || zeroonesubmit == 0)
					textField_1_upper.setText(String.valueOf(deOneUpper));
				else if (zeroonesubmit == 1)
					textField_1_upper.setText(String.valueOf(OneUpper));

				if (textField_0_lower.getText().isEmpty() || zeroonesubmit == 0)
					textField_0_lower.setText(String.valueOf(deZeroLower));
				else if (zeroonesubmit == 1)
					textField_0_lower.setText(String.valueOf(ZeroLower));

				if (textField_0_upper.getText().isEmpty() || zeroonesubmit == 0)
					textField_0_upper.setText(String.valueOf(deZeroUpper));
				else if (zeroonesubmit == 1)
					textField_0_upper.setText(String.valueOf(ZeroUpper));

				if (textField_sizepoints.getText().isEmpty() || numofpointsubmit == 0)
					textField_sizepoints.setText(String.valueOf(desizeOfpoints));
				else if (numofpointsubmit == 1)
					textField_sizepoints.setText(String.valueOf(sizeOfpoints));
	            
	            int widthOfImage = 0;
	            
	            String s = textField_image.getText();
				if (s.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "No input, Set the value to default of 52");
					widthOfImage = 52;
					textField_image.setText("52");
				}
				else if (Integer.parseInt(s) == 0)
				{
					JOptionPane.showMessageDialog(null, "Wrong Input!! Can not be 0!!");
				}
				else
				{
					widthOfImage = Integer.parseInt(s);
				}

	            JFileChooser jfc = new JFileChooser(new File("D:\\"));
	            jfc.setDialogTitle("Open a File");
	            jfc.setFileFilter(new FileSave(".txt","Text File"));

				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfc.showOpenDialog(null);
				File dir = jfc.getSelectedFile();
				File files[] = dir.listFiles();

				//==============according modified time to load files===================
				//if (!ImageCheckBox_filename.isSelected())
				//{
					Arrays.sort(files, new Comparator<File>() {
						public int compare(File f1, File f2) {
							long diff = f1.lastModified() - f2.lastModified();
							if (diff > 0)
								return 1;
							else if (diff == 0)
								return 0;
							else
								return -1;//若是 if 中修改成 返回-1 同时此处修改成返回 1 排序就会是递减
						}

						public boolean equals(Object obj) {
							return true;
						}

					});
				//}
							
//====================================================================================		

/*				
				else
				{
//==============according filename to load files===================
					Arrays.sort(files, new Comparator<File>() 
					{
						@Override
						public int compare(File o1, File o2) 
						{
							String s1 = extractNumber(o1.getName());
							String s2 = extractNumber(o2.getName());
							
							String[] s1Parts = s1.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
				            String[] s2Parts = s2.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

				            int i = 0;
				            while(i < s1Parts.length && i < s2Parts.length){

				                //if parts are the same
				                if(s1Parts[i].compareTo(s2Parts[i]) == 0){
				                    ++i;
				                }else{
				                    try{

				                        int intS1 = Integer.parseInt(s1Parts[i]);
				                        int intS2 = Integer.parseInt(s2Parts[i]);

				                        //if the parse works

				                        int diff = intS1 - intS2; 
				                        if(diff == 0){
				                            ++i;
				                        }else{
				                            return diff;
				                        }
				                    }catch(Exception ex){
				                        return s1.compareTo(s2);
				                    }
				                }//end else
				            }//end while

				            //Handle if one string is a prefix of the other.
				            // nothing comes before something.
				            if(s1.length() < s2.length()){
				                return -1;
				            }else if(s1.length() > s2.length()){
				                return 1;
				            }else{
				                return 0;
				            }
						}

						private String extractNumber(String name) 
						{
							String number="";
							try {
								//int s = name.indexOf('_')+1;
								int e = name.lastIndexOf('-');
								number = name.substring(0, e);
							} catch(Exception e) {
								number = ""; // if filename does not match the format
								// then default to 0
							}
							return number;
						}
					});	
				}
//====================================================================================			

*/
				
	    		String tempstr = ""; //for print in Text area
	    	    ArrayList<String> comparison = new ArrayList<String>();

	    	    for (int i = 0; i < files.length; i++) 
				{
					System.out.println("file: " + files[i]);
					try
					{

						
						//BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
						Path inputpath = Paths.get(files[i].getPath());
				        List<String> inputlines = Files.readAllLines(inputpath, StandardCharsets.UTF_8);

				      //----------------------Data Parser---------------------------------
				        DataParserAndToArray parser = new DataParserAndToArray();
				        // set up a loop over the input data
				        for (String line : inputlines) {
				            parser.parseLine(line);
				        }
				        //char[][] chars = parser.getChars();
				        double[] Xaxis= parser.getChars();
				        int[] ints = parser.getInts();
				        
				        //textArea.setText(Arrays.toString(ints));
				        
				        preData.DataLoad(ints, Xaxis);
				        preData.DataDivision(divisionposition);
				        int[] priInts = preData.returnPriInts(); 
				        int[] posInts = preData.returnPosInts();
				        double[] priXaxis = preData.returnPriaxis(); 
				        double[] posXaxis = preData.returnPosaxis();
				        
				        if (priInts.length ==0)
				        {
				        	textArea.setText("No Input!!");
				        }
				        else
				        {
				        	CheckZeroOne finalCode = new CheckZeroOne();
				        	finalCode.GetZeroOne(priInts, priXaxis, posInts, posXaxis, sizeOfpoints, stZeroLower, stZeroUpper, stOneLower, stOneUpper, ZeroLower, ZeroUpper, OneLower, OneUpper);
				        	finalCode.checkFinalPeak();
				        	finalCode.FinalCodeList();
				        	ArrayList<Integer> code = finalCode.returnCodeList();
				        	textArea.setText(inputpath + " >> " + code.toString());
				        	
		        	
				        	
				    		ArrayListToIntArray toArray = new ArrayListToIntArray();
				    		int[] codevalue = toArray.ListToIntArray(code);
				    		
				    		
				    		//CodeToImage toImage = new CodeToImage();
				    		toImage.CodesForImage(codevalue, widthOfImage);
				    		tempstr = toImage.returnCodeString();
				            textArea_1.setText(tempstr);
				            
				    		//check incorrectly recognized codes
				        	if (!inputpath.toString().contains(toString.CheckCodes(codevalue)) || toString.CheckCodes(codevalue).length() < 4)
				        	{
				        		comparison.add(inputpath.toString() + ">> " + toString.CheckCodes(codevalue) + "\n");
				        	}


				        }
				        preData.ListInitialize();


					}
					catch (Exception ex)
					{
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
	    	    toImage.codeToTwoDArray(widthOfImage);
				//entirecode = toImage.getentirecode();
		        //System.out.println("code list >> " + entirecode);
				try 
				{
					toImage.codeToImage(saveto);

				} catch (IOException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            textArea_2.setText("Image generated, please check the directory: " + saveto);
				toImage.CodeStringInitialize();
				
				long endTime = System.currentTimeMillis();    //获取结束时间
				
				if (comparison.isEmpty())
				{
					System.out.println("All Correct!!"); //check the code
					textArea_incorrect.setText("All Correct!!" + "\n" + "Run Time: " + (endTime-startTime)/1000 + "second");
				}
				else
				{
					System.out.println(comparison); //check the code
					textArea_incorrect.setText(String.valueOf(comparison) + "\n" + "Run Time: " + (endTime-startTime)/1000 + "second");
				}
			}
        });
        btnNewButton_3_ToImage.setForeground(Color.BLACK);
        btnNewButton_3_ToImage.setFont(new Font("Arial", Font.PLAIN, 14));
        btnNewButton_3_ToImage.setBounds(363, 46, 162, 27);
        panel_TitledBorder_2_1.add(btnNewButton_3_ToImage);
        
        JPanel panel_TitledBorder_2_1_1 = new JPanel();
        panel_TitledBorder_2_1_1.setBounds(563, 382, 543, 117);
        panel_TitledBorder_2_1_1.setLayout(null);
        panel_TitledBorder_2_1_1.setBorder(BorderFactory.createTitledBorder("Incorrectly recognized"));
        contentPane.add(panel_TitledBorder_2_1_1);
        
        JLabel lblCodeToText_1_1 = new JLabel("Code to Text:");
        lblCodeToText_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblCodeToText_1_1.setForeground(Color.RED);
        lblCodeToText_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCodeToText_1_1.setBackground(Color.YELLOW);
        lblCodeToText_1_1.setBounds(22, 301, 93, 15);
        panel_TitledBorder_2_1_1.add(lblCodeToText_1_1);
        

        panel_TitledBorder_2_1_1.add(textArea_incorrect);
        
        
		
	}
}
