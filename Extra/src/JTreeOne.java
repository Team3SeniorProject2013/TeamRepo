import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;


public class JTreeOne {

	static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
	static int rootcounter=0;
	static JTree tree;
	static DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("RootNode");
	static DefaultMutableTreeNode tempNode = rootNode;
	static DefaultMutableTreeNode tempNode2 = tempNode;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);


    	System.out.println("Please enter root path:");
    	String root = input.nextLine();
       /**
	    *	Example valid root path inputs:
	    *	1. C:\Users\Quang\Documents\Dropbox\9) Fall 2013\Software Engineering Project\testFiles
	    *   2. C:\Users\Quang\Google Drive\Data Alliance Test Files\TESTDOCS\-- Bri Library --
       **/

    	//String root = "C:\\Users\\Quang\\Documents\\Dropbox\\9) Fall 2013\\Software Engineering Project\\testFiles";
    	File rootFolder = new File(root);

    	tree = new JTree(bundleDirectory(root));
    	JFrame frame = new JFrame ("TreeTest");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	JScrollPane treeView = new JScrollPane(tree);
    	treeView.setOpaque(true);
    	frame.setContentPane(treeView);
    	frame.pack();
    	frame.setVisible(true);

	}
	
	private static DefaultMutableTreeNode bundleDirectory(String sbr)
	{
		File folder = new File(sbr); 
	    File[] listOfFiles = folder.listFiles();

	    DefaultMutableTreeNode subNode = new DefaultMutableTreeNode(getFolderName(sbr));
	    
	    for (int i = 0; i < listOfFiles.length; i++)
	    {
	    	DefaultMutableTreeNode fileNode = null;
	    	
	    	System.out.println(listOfFiles[i].getPath());
	    	
	    	if (listOfFiles[i].isDirectory())
	        {
	        	subNode.add(bundleDirectory(listOfFiles[i].getPath()));
	        }
	    	else
	    	{
	    		fileNode = new DefaultMutableTreeNode(listOfFiles[i].getName());
	    		subNode.add(fileNode);
	    	}   
	        
	    }
	    
		return subNode;
	}
	
	private static String getFolderName(String directory)
	{
		Scanner delim = new Scanner(directory).useDelimiter("\\\\");
		
		String foldername = ""; 
		while(delim.hasNext())
		{
			foldername = delim.next();
		}
		
		delim.close();	
		
		return foldername;
	}
	
}
