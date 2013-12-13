import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;



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
         static SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd"); 
         
         
         
         private static Connection connect = null;
         private static Statement statement = null;
         private static PreparedStatement preparedStatement = null;
         private static ResultSet resultSet = null;  
         
   	public static void main(String[] args) throws Exception {
		  
	  }
    public static void dbConnection() throws Exception{
            Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager
            .getConnection("jdbc:mysql://localhost/research knowledge manager?"
                + "user=root&password=");
        
            
    }
    
    public static void dbClose() throws Exception{
    	connect.close();
    }
    
    
    
    public static void readfiles(String root) throws Exception{
            dbConnection();
           
        Scanner input = new Scanner(System.in);
     
   
        //asdfasdfasdf test push
        
            //System.out.println("Please enter root path:");
            //String root = input.nextLine();
       /**
            *        Example valid root path inputs: 
            *        1. C:\Users\Quang\Documents\Dropbox\9) Fall 2013\Software Engineering Project\testFiles
            *   2. C:\Users\Quang\Google Drive\Data Alliance Test Files\TESTDOCS\-- Bri Library --
       **/
            
            //String root = "a";
            //String root = "C:\\Users\\Shalan\\Desktop\\TESTDOCS";
            
            searchFile(root);
            //searchFile2 (root);
            //searchFile3(root);
    
    }
    
    public static void searchFile (String root) throws Exception // input path and displays file names
    {
          File folder = new File(root); //creates new root file
      File[] listOfFiles = folder.listFiles();
      String subRoot = "";
  
      
      statement = connect.createStatement();
      
       
      
      String names,path,extension, DateModified;
      long fileSize;
      int extensionIndex;
      
      for (int i = 0; i < listOfFiles.length; i++) 
      {
          if (listOfFiles[i].isFile()) 
          {
        	  System.out.println("Uploading to database: "+listOfFiles[i].getName());
        	  //System.out.println("File:\t" + listOfFiles[i].getName());                                                 //displays name of file
             // System.out.println("Path:\t" + listOfFiles[i].getPath());                                                //displays file path
              //System.out.println("Parent:\t" + listOfFiles[i].getParentFile());                                //displays directory path
              //System.out.println("Parent:\t" + listOfFiles[i].getParentFile().getName());                // display parent file name
             // System.out.println("Size:\t"+listOfFiles[i].length());                                                //display file size
             // System.out.println("Date Modified:\t"+ dateFormat.format(listOfFiles[i].lastModified())); //display date modified
             // System.out.println(" ");
              
              extension = "";

              extensionIndex = listOfFiles[i].getName().lastIndexOf('.');
              if (extensionIndex >= 0) {
                  extension = listOfFiles[i].getName().substring(extensionIndex+1);
              }
              
              System.out.println(extension);
              names = listOfFiles[i].getName();
              path = listOfFiles[i].getPath();
              fileSize = listOfFiles[i].length();
              DateModified = dateFormat.format(listOfFiles[i].lastModified());
              //
              //preparedStatement = connect
               //       .prepareStatement("insert into file (filename,directory,filesize,filetype,DateModified) values (?,?,?,?,?)"); 

              
              
              preparedStatement = 
            		  connect.prepareStatement("insert into file (filename,directory,filesize,filetype,DateModified) SELECT ?,?,?,?,? FROM dual WHERE not exists (select * from file where directory = ?)"); 
              
              
              preparedStatement.setString(1, names);
              preparedStatement.setString(2, path);
              preparedStatement.setLong(3,fileSize);
              preparedStatement.setString(4,extension);
              preparedStatement.setString(5,DateModified);
              preparedStatement.setString(6, path);
              preparedStatement.executeUpdate();
              
             
              
          } 
          else if (listOfFiles[i].isDirectory()) 
          {
              subRoot = listOfFiles[i].getName();
                  System.out.println("Subdirectory:\t" + subRoot);
              searchFile (root + "\\"+subRoot); //if it is a directory, recursively search sub directory
              
          }
		    

      }
      //dbClose();
    }        

    
    public static ArrayList returnTagSearch(String TagName) throws Exception {
            
        dbConnection();
        
        String selectSQL = "select FileName, Directory, FileSize, DateModified from file, tag where tag.FileID = file.FileIndex and tag = ?";
        preparedStatement = connect.prepareStatement(selectSQL);
        preparedStatement.setString(1, TagName);
        
        resultSet = preparedStatement.executeQuery();
        ArrayList arrayList = new ArrayList();
        
        while(resultSet.next()) {
                arrayList.add(resultSet.getString("filename"));
                arrayList.add(resultSet.getString("Directory"));
                arrayList.add(resultSet.getString("FileSize"));
                arrayList.add(resultSet.getString("DateModified"));

            
        }
	    dbClose();
            return arrayList;
            
    }    

    
    public static ArrayList getTagsfromDB(String fileName, String parentName) throws Exception {
        
        dbConnection();
    
		    String selectSQL = "select tag from file, tag where directory like '%" + fileName + "%'  and directory like '%" + parentName + "%' and file.FileIndex = tag.FileId;";

		    preparedStatement = connect.prepareStatement(selectSQL);
		   
		    
		    resultSet = preparedStatement.executeQuery();
		    ArrayList arrayList = new ArrayList();
		    
		    while(resultSet.next()) {
		            arrayList.add(resultSet.getString("tag"));
		
		    }
		    dbClose(); 
		        return arrayList;
		        
		}    

    	public static ArrayList getAllTag() throws Exception {
    		
    		dbConnection();
		    String selectSQL = "select tag from tag;";
		    preparedStatement = connect.prepareStatement(selectSQL);

		    resultSet = preparedStatement.executeQuery();
		    ArrayList arrayList = new ArrayList();
		    
		    while(resultSet.next()) {
		            arrayList.add(resultSet.getString("tag"));
		
		    }
		    dbClose();
		    return arrayList;
		        
		}    
    	
    	public static ArrayList getEntireTagList() throws Exception {
    		
    		dbConnection();
		    String selectSQL = "select tag from tag;";
		    
		    resultSet = preparedStatement.executeQuery();
		    ArrayList arrayList = new ArrayList();
		    
		    while(resultSet.next()) {
		            arrayList.add(resultSet.getString("tag"));
		
		    }
		    dbClose();
		    return arrayList;
		        
		}  
    	
    	public static void addTagstoDB(String tagName, String parentName, String fileName) throws Exception {
    		
    		dbConnection();
    		String index = "-1";
            String selectSQL = "select FileIndex from file where file.directory like '%" + parentName +"%' and file.directory like '%" + fileName+"%'";
    		preparedStatement = connect.prepareStatement(selectSQL);
    		resultSet = preparedStatement.executeQuery();
		    
		    while(resultSet.next()) {
		            index = resultSet.getString("FileIndex");
		    }
		    
		    //System.out.println(index);
    		String insertSQL = "insert into tag (FileID, Tag) values (?,?)";
    		preparedStatement = connect.prepareStatement(insertSQL);
    		preparedStatement.setString(1,index);
    		preparedStatement.setString(2, tagName);
    		preparedStatement.executeUpdate();
		    
    		dbClose();	    	            
    	}
    	
    	public static void editTag(ArrayList a) throws Exception{
    		dbConnection();
    		
    		
    		String dir1, dir2, tagnow, changeto;
    		dir1 = a.get(0).toString();
    		dir2 = a.get(1).toString();
    		tagnow = a.get(2).toString();
    		changeto = a.get(3).toString();
    		
    		String selectSQL = "select tagid from tag, file where tag = '"+ tagnow + "' and file.directory like '%" + dir2 + "%' and file.directory like '%" + dir2 + "%' and file.fileIndex = tag.fileid";
            preparedStatement = connect.prepareStatement(selectSQL);
            //preparedStatement.setString(1, TagName);
            
            resultSet = preparedStatement.executeQuery();
            ArrayList arrayList = new ArrayList();
            
            while(resultSet.next()) {
                    arrayList.add(resultSet.getString("tagid"));
                   // System.out.println(arrayList);

                
            }
            String arrayListString = arrayList.get(0).toString();
            String updateSQL = "UPDATE tag SET tag='"+ changeto +"' WHERE tagid =  " + arrayListString;
            
            preparedStatement = connect.prepareStatement(updateSQL);
    		preparedStatement.executeUpdate();
    	}	
    	
    	
    	
    	public static void deleteTag(ArrayList a) throws Exception{
    		dbConnection();
    		
    		
    		String dir1, dir2, tagnow, changeto;
    		dir1 = a.get(0).toString();
    		dir2 = a.get(1).toString();
    		tagnow = a.get(2).toString();
    		
    		
    		String selectSQL = "select tagid from tag, file where tag = '"+ tagnow + "' and file.directory like '%" + dir2 + "%' and file.directory like '%" + dir2 + "%' and file.fileIndex = tag.fileid";
            preparedStatement = connect.prepareStatement(selectSQL);
            
            
            resultSet = preparedStatement.executeQuery();
            ArrayList arrayList = new ArrayList();
            
            while(resultSet.next()) {
                    arrayList.add(resultSet.getString("tagid"));
                   

                
            }
            String arrayListString = arrayList.get(0).toString();
            //delete from orders 
            //where id_users = 1
            String deleteSQL = "delete from tag where tagid = '"+ arrayListString +"'";
            
            preparedStatement = connect.prepareStatement(deleteSQL);
    		preparedStatement.executeUpdate();
    	}	
    	
    	

}
