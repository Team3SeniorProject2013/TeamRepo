import java.io.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;

/**
 *
 * @author Quang Mai 
 * 10/31/2013
 * Enter root path. Retreives file name, path, parent path, or parent file name. 
 * Recursively looks through subdirectory
 * 
 */
public class ReadingFiles 
{
	 static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY"); 
	   
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
     
   
    	System.out.println("Please enter root path:");
    	String root = input.nextLine();
       /**
	    *	Example valid root path inputs: 
	    *	1. C:\Users\Quang\Documents\Dropbox\9) Fall 2013\Software Engineering Project\testFiles
	    *   2. C:\Users\Quang\Google Drive\Data Alliance Test Files\TESTDOCS\-- Bri Library --
       **/
    	
    	
    	//String root = "C:\\Users\\Quang\\Documents\\Dropbox\\9) Fall 2013\\Software Engineering Project\\testFiles";
    	searchFile (root);
      
      
        
    }
    
    public static void searchFile (String root) // input path and displays file names
    {
	  File folder = new File(root); //creates new root file
      File[] listOfFiles = folder.listFiles();
      String subRoot = "";
  
      
      for (int i = 0; i < listOfFiles.length; i++) 
      {
          if (listOfFiles[i].isFile()) 
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
              
          }
      }
          
    }	
    
}
