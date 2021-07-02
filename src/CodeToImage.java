import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;


public class CodeToImage extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BinaryNumberToString toString = new BinaryNumberToString();
	String totalstring = "";
	String codestring = "";
    ArrayList<Integer> entirecode = new ArrayList<Integer>();

	String codeToText = "";
	int count = 0;
	
	int row = 0;
	int col = 0;
    int[][] arrMatrix = new int[row][col];

	
	public void CodesForImage(int[] code, int len)
	{
		for(int ii : code) //the length of one code is 4
		{
			codestring+=Integer.toString(ii);
			entirecode.add(ii);
			count++;
			if ((count % len) == 0) //combine two codes into one, length is 8
			{
				codestring = codestring + " ";
			}
        }
        System.out.println("codestring>> " + codestring);
        System.out.println("code list >> " + entirecode);
	}
	
	public void codeToTwoDArray(int len)
	{
	    ArrayList<Integer> code = new ArrayList<Integer>();

		int listlen = entirecode.size();
		col = len; // column size
		if ((listlen%len) == 0) // row size
		{
			row = listlen/len;
		}
		else
		{
			row = listlen/len + 1;
		}
        System.out.println("nocol >> " + len + "norwo >> " + row);
        
 // according to row,col, generate a matrix
        for (int i=0; i< row*col; i++)
        {
        	if (i<listlen)
        	{
        		code.add(entirecode.get(i));
        	}
        	else
        	{
        		code.add(0);
        	}
        }
        System.out.println("code list >> " + code);

        arrMatrix = new int[row][col];
        int k=0;
        for (int i=0; i<row; i++)
        {
        	for (int j=0; j<col; j++)
        	{
        		arrMatrix[i][j] = code.get(k++);
        	}
        }
        System.out.println(Arrays.deepToString(arrMatrix));

	}
	
    public String returnCodeString()
    {
    	return codestring;
    }
    
	public void CodeStringInitialize()
	{
		entirecode.clear();
		codestring = ""; 
		count = 0;
	}
	
	public ArrayList<Integer> getentirecode() 
	{
		return entirecode;
	}

	public void codeToImage(String dir) throws IOException 
	{
		int width = col*40+4; // size of image, 
		int height = row*40+4;
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphic = bi.createGraphics();
        graphic.setColor(Color.red);
        graphic.fillRect(0, 0, width, height);
        for (int i=0; i<row;i++)
		{
			for (int j=0;j<col;j++)
			{
				if (arrMatrix[i][j]==0) 
					graphic.setColor(Color.white);
				else 
					graphic.setColor(Color.black);
					graphic.fillRect(2+j*40, 2+i*40,40,40);

			}
		} 
		
		ImageIO.write(bi, "jpg", new File(dir));	
		/*
		ImageIcon icon=new ImageIcon(bi);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        //frame.setSize(width,height);
        frame.setSize(500,500);

        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */
		
		Image tmp = bi.getScaledInstance(col*10, row*10, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(col*10, row*10, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);

        g2d.dispose();
        
		ImageIcon icon=new ImageIcon(resized);
        JFrame tempframe=new JFrame();
        tempframe.setLayout(new FlowLayout());
        //frame.setSize(width,height);
        tempframe.setSize(col*10+100, row*10+100);
        tempframe.setLocationRelativeTo(null);

        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        tempframe.add(lbl);
        tempframe.setVisible(true);
        tempframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
	

	}

}



