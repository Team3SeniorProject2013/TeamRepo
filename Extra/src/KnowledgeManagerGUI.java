import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Label;

import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.RootPaneContainer;

import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.AbstractListModel;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.JScrollBar;
import java.awt.Panel;
import java.awt.Checkbox;
import java.awt.Component;

//changes
public class KnowledgeManagerGUI extends JFrame {

        private JPanel contentPane;
        private JTextField SelectRootDirtextField;
        private JTextField AddTagstextField_1;
        private JTextField textField_2;
        private  Checkbox update_checkbox;
        String root;
        static JTree tree;
        private static String roots;
        JList taglist;
        DefaultListModel listModel;
        /**
         * Launch the application.
         */
        public static void main(String[] args) {
        	
	        KnowledgeManagerGUI frame = new KnowledgeManagerGUI();
	        frame.setVisible(true);                       
        }

        /**
         * Create the frame.
         */
        @SuppressWarnings("serial")
        
        

        
        public KnowledgeManagerGUI() {
        	
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setBounds(100, 100, 500, 500);
                contentPane = new JPanel();
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                contentPane.setLayout(new BorderLayout(0, 0));
                setContentPane(contentPane);
                
                JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
                contentPane.add(tabbedPane, BorderLayout.CENTER);
                
                /********************************************************************************
                 * TAGS TAB
                 ********************************************************************************/
                
                final JPanel panel = new JPanel();
                
                
                tabbedPane.addTab("Tags", null, panel, null);
                panel.setLayout(null);
                
                SelectRootDirtextField = new JTextField();
                SelectRootDirtextField.setBounds(10, 35, 335, 20);
                panel.add(SelectRootDirtextField);
                SelectRootDirtextField.setColumns(10);
                
                JButton btnBrowse = new JButton("Ok");
                
                root = "";
                
                btnBrowse.addActionListener(new ActionListener() 
                {
                        public void actionPerformed(ActionEvent e) {
                                  
                                roots = SelectRootDirtextField.getText();
                                System.out.println(SelectRootDirtextField.getText());
                      
                                try {
                                        if (update_checkbox.getState() == true) {
											ReadingFiles.readfiles(roots);
										}
										root = SelectRootDirtextField.getText();
                                        
                                        if(!root.equals(""))
                                        {
                                        	JScrollPane scrollPane = new JScrollPane();
                                            scrollPane.setBounds(10, 117, 216, 268);
                                            panel.add(scrollPane);
                                            
                                        	tree = new JTree(JTreeOne.bundleDirectory(root));
                                        	scrollPane.setViewportView(tree);
                                        	tree.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                                        }
 
                                } catch (Exception ex) {
                                        // TODO Auto-generated catch block
                                        ex.printStackTrace();
                                }
                        }
                        
                        
                });
                
                
                
                btnBrowse.setBounds(344, 34, 89, 23);
                panel.add(btnBrowse);
                
                JLabel lblNewLabel = new JLabel("Select root directory");
                lblNewLabel.setBounds(10, 10, 165, 14);
                panel.add(lblNewLabel);
                
                JLabel lblAssociatedTags = new JLabel("Associated Tags");
                lblAssociatedTags.setBounds(233, 76, 150, 14);
                panel.add(lblAssociatedTags);
                
                JLabel lblNewLabel_1 = new JLabel("Select a file");
                lblNewLabel_1.setBounds(20, 76, 143, 14);
                panel.add(lblNewLabel_1);
                
                AddTagstextField_1 = new JTextField();
                AddTagstextField_1.setBounds(236, 92, 134, 20);
                panel.add(AddTagstextField_1);
                AddTagstextField_1.setColumns(10);
        		listModel = new DefaultListModel();
        		
        		final JScrollPane tagScrollPane = new JScrollPane();
        		tagScrollPane.setBounds(233, 117, 226, 268);
        		panel.add(tagScrollPane);
        		
        		taglist = new JList();
        		tagScrollPane.setViewportView(taglist);
        		taglist.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        		 listModel.addElement("item 1");

        		 
                JButton btnNewButton = new JButton("Add tag");
                btnNewButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
                		
                		String fileName = null;
                		String parentName = null;
                		String tagName = null;
                		TreePath treepath = tree.getSelectionPath();
                		
                		Object[] c = treepath.getPath();
                		
                		fileName = c[c.length-1].toString();
                		parentName = c[c.length-2].toString();
                		tagName = AddTagstextField_1.getText();
                		
                		try{
                			ReadingFiles.addTagstoDB(tagName, parentName, fileName);
                		}
                		catch(Exception e)
                		{
                			System.out.println(e);
                		}
                			
                	}
                });
                btnNewButton.setBounds(370, 91, 89, 23);
                panel.add(btnNewButton);    
                
                JButton btnNewButton_1 = new JButton("Edit");
                btnNewButton_1.setBounds(233, 391, 89, 23);
                panel.add(btnNewButton_1);
                
                JButton btnDelete = new JButton("Delete");
                btnDelete.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                         
                        
                        
                        }
                });
                btnDelete.setBounds(344, 391, 89, 23);
                panel.add(btnDelete);
                
                JButton btnSubmit_1 = new JButton("Submit");
                btnSubmit_1.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
                        
                		taglist = new JList(returnTags().toArray());
                		tagScrollPane.setViewportView(taglist);
                			
                	}
                });
                btnSubmit_1.setBounds(10, 390, 89, 23);
                panel.add(btnSubmit_1);                
                
                update_checkbox = new Checkbox("Update Database");
                update_checkbox.setBounds(344, 10, 115, 22);
                panel.add(update_checkbox);
                
                
                /********************************************************************************
                 * SEARCH TAB
                 ********************************************************************************/
                
                JPanel panel_1 = new JPanel();
                tabbedPane.addTab("Search", null, panel_1, null);
                panel_1.setLayout(null);
                
                JLabel lblSearchResult = new JLabel("Search using Tag");
                lblSearchResult.setBounds(10, 11, 101, 14);
                panel_1.add(lblSearchResult);
                
                textField_2 = new JTextField();
                textField_2.setBounds(10, 24, 178, 20);
                panel_1.add(textField_2);
                textField_2.setColumns(10);
                 
                 JScrollPane scrollPane = new JScrollPane();
                 scrollPane.setBounds(10, 67, 449, 335);
                 panel_1.add(scrollPane);
                
                 final JTextArea textArea = new JTextArea();
                 scrollPane.setViewportView(textArea);
                
                 
                
                     textArea.setVisible(true);
                
            
                
            JScrollPane scroll = new JScrollPane();
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                  scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                
                JButton btnSearch = new JButton("Search");
                btnSearch.setBounds(188, 23, 89, 23);
                btnSearch.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                                textArea.setText("");
                                String tagName;
                                tagName = textField_2.getText();
                                System.out.println(tagName);
                                try {
                                        ArrayList a = new ArrayList();
                                        a = ReadingFiles.returnTagRearch(tagName);
                                       // System.out.println(a.size());
                                        //textArea.append(ReadingFiles.returnTagRearch(tagName));

                                        for(int i = 0; i < a.size(); i++) {
                                                textArea.append((String) a.get(i));
                                                textArea.append("    ");
                                                
                                                if ((i+1) % 4 == 0) {
                                                	textArea.append("\n");
                                                System.out.println((i+1) % 4);}
                                                
                                                
                                        }
                                        
                                } catch (Exception e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                }
                        }
                });
                panel_1.add(btnSearch);
                
                JLabel lblFileNameDirectory = new JLabel("File Name, Directory, File Size(Kb), Last Date Modifited");
                lblFileNameDirectory.setBounds(10, 53, 381, 14);
                panel_1.add(lblFileNameDirectory);
                
                
                /********************************************************************************
                 * LIST TAB
                 ********************************************************************************/
                
                JPanel panel_2 = new JPanel();
                tabbedPane.addTab("List", null, panel_2, null);
                panel_2.setLayout(null);
                
                JLabel lblShotcut = new JLabel("Shortcut");
                lblShotcut.setBounds(386, 11, 73, 14);
                panel_2.add(lblShotcut);
                
                JList list_2 = new JList();
                list_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
                list_2.setModel(new AbstractListModel() {
                        String[] values = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
                        public int getSize() {
                                return values.length;
                        }
                        public Object getElementAt(int index) {
                                return values[index];
                        }
                });
                
                list_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                list_2.setBounds(386, 25, 73, 350);
                panel_2.add(list_2);
                
                JButton btnSubmit_2 = new JButton("Submit");
                btnSubmit_2.setBounds(0, 390, 89, 23);
                panel_2.add(btnSubmit_2);
                
                JTextArea textArea_1 = new JTextArea();
                textArea_1.setBounds(10, 25, 366, 350);
                panel_2.add(textArea_1);
                
                JLabel lblList = new JLabel("List");
                lblList.setBounds(10, 11, 46, 14);
                panel_2.add(lblList);
                
                
                /********************************************************************************
                 * RECENT TAB
                 ********************************************************************************/
                
                JPanel panel_3 = new JPanel();
                tabbedPane.addTab("Recent", null, panel_3, null);
                panel_3.setLayout(null);
                
                JButton btnSubmit_3 = new JButton("Submit");
                
                btnSubmit_3.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                
                btnSubmit_3.setBounds(10, 390, 89, 23);
                panel_3.add(btnSubmit_3);
                
                JList list_3 = new JList();
                list_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                list_3.setBounds(10, 30, 320, 328);
                panel_3.add(list_3);
                
                JLabel lblRecentSearch = new JLabel("Recent Search");
                lblRecentSearch.setBounds(10, 11, 119, 14);
                panel_3.add(lblRecentSearch);
                
                /********************************************************************************
                 * BOOKMARK TAB
                 ********************************************************************************/
                JPanel panel_4 = new JPanel();
                tabbedPane.addTab("Bookmark", null, panel_4, null);
                panel_4.setLayout(null);
                
                JLabel lblBookmarkedTags = new JLabel("Bookmarked Tags");
                lblBookmarkedTags.setBounds(10, 28, 288, 14);
                panel_4.add(lblBookmarkedTags);
                
                JList list_1 = new JList();
                list_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                list_1.setBounds(10, 42, 200, 349);
                panel_4.add(list_1);
                
                JButton btnSubmit = new JButton("Submit");
                
                /*
                 * btnBrowse.addActionListener(new ActionListener() 
                {
                        public void actionPerformed(ActionEvent e) {
                                String roots;  
                                roots = SelectRootDirtextField.getText();
                                System.out.println(SelectRootDirtextField.getText());                   
                                try {
                                        ReadingFiles.readfiles(roots);                                    
                                        root = SelectRootDirtextField.getText();
                                } catch (Exception ex) {
                                        // TODO Auto-generated catch block
                                        ex.printStackTrace();
                                }
                        }       
                });
                 */
                btnSubmit.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		
                	}
                });
                
                btnSubmit.setBounds(220, 39, 89, 23);
                panel_4.add(btnSubmit);
                
                JButton btnAdd = new JButton("Add");
                
                btnAdd.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                
                btnAdd.setBounds(220, 73, 89, 23);
                panel_4.add(btnAdd);
                
                JButton btnDelete_1 = new JButton("Delete");
                
                btnDelete_1.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                btnDelete_1.setBounds(220, 107, 89, 23);
                panel_4.add(btnDelete_1);
        }

        public static String getRoots() {
        	return roots;
        }
        
        public static ArrayList returnTags() {
        	
        	String filename = null;
    		String parentName = null;
    		TreePath treepath = tree.getSelectionPath();
    		
    		Object[] c = treepath.getPath();
    		
    		filename = c[c.length-1].toString();
    		parentName = c[c.length-2].toString();
    		
    		ArrayList tagNames = new ArrayList();
    		try {
				tagNames = ReadingFiles.getTagsfromDB(filename,parentName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		return tagNames;
        }
}
