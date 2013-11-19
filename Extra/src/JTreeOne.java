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
	static DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");
	static DefaultMutableTreeNode tempNode = rootNode;

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


    	searchFile (root);
    	tree = new JTree(rootNode);
    	JFrame frame = new JFrame ("TreeTest");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	JScrollPane treeView = new JScrollPane(tree);
    	treeView.setOpaque(true);
    	frame.setContentPane(treeView);
    	frame.pack();
    	frame.setVisible(true);

	}

	public static void searchFile (String root) // input path and displays file names
    {
	  File folder = new File(root); //creates new root file
      File[] listOfFiles = folder.listFiles();
      String subRoot = "";


      for (int i = 0; i < listOfFiles.length; i++)
      {
    	  DefaultMutableTreeNode directoryNode = null;
          DefaultMutableTreeNode fileNode = null;
          /*if (listOfFiles[i].isFile())
          {
              System.out.println("File:\t" + listOfFiles[i].getName()); 						//displays name of file
              //System.out.println("Path:\t" + listOfFiles[i].getPath());						//displays file path
              //System.out.println("Parent:\t" + listOfFiles[i].getParentFile());				//displays directory path
              System.out.println("Parent:\t" + listOfFiles[i].getParentFile().getName());		// display parent file name
              System.out.println("Size:\t"+listOfFiles[i].length()+"kb");						//display file size
              System.out.println("Date Modified:\t"+ dateFormat.format(listOfFiles[i].lastModified())); //display date modified
              System.out.println(" ");

          }
          else if (listOfFiles[i].isDirectory())
          {
              subRoot = listOfFiles[i].getName();
        	  System.out.println("Subdirectory:\t" + subRoot);
              searchFile (root + "\\"+subRoot); //if it is a directory, recursively search sub directory

          }*/
    	  if (listOfFiles[i].isDirectory())
          {
    		  directoryNode = new DefaultMutableTreeNode(listOfFiles[i].getName());
    		  rootNode.add(directoryNode);;
    		  tempNode = directoryNode;

              subRoot = listOfFiles[i].getName();
        	  System.out.println("Subdirectory:\t" + subRoot);
              searchFile (root + "\\"+subRoot); //if it is a directory, recursively search sub directory

          }
          else if (listOfFiles[i].isFile())
          {
        	  fileNode = new DefaultMutableTreeNode(listOfFiles[i].getName());
        	  tempNode.add(fileNode);						// @@@PLACEHOLDER@@@
        	  //directoryNode.add(fileNode);				// doesn't work because directoryNode is null

        	  System.out.println("File:\t" + listOfFiles[i].getName()); 						//displays name of file
              //System.out.println("Path:\t" + listOfFiles[i].getPath());						//displays file path
              //System.out.println("Parent:\t" + listOfFiles[i].getParentFile());				//displays directory path
              System.out.println("Parent:\t" + listOfFiles[i].getParentFile().getName());		// display parent file name
              System.out.println("Size:\t"+listOfFiles[i].length()+"kb");						//display file size
              System.out.println("Date Modified:\t"+ dateFormat.format(listOfFiles[i].lastModified())); //display date modified
              System.out.println(" ");

          }
      }
      rootNode.add(tempNode);;

    }

}
