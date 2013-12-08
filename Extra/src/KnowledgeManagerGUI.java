import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Label;

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
import javax.swing.JScrollBar;

//changes
public class KnowledgeManagerGUI extends JFrame {

	private JPanel contentPane;
	private JTextField SelectRootDirtextField;
	private JTextField AddTagstextField_1;
	private JTextField textField_2;
	String root;
	JTree tree;
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
		
		final JPanel panel = new JPanel();
		
		
		tabbedPane.addTab("Tags", null, panel, null);
		panel.setLayout(null);
		
		SelectRootDirtextField = new JTextField();
		SelectRootDirtextField.setBounds(10, 43, 335, 20);
		panel.add(SelectRootDirtextField);
		SelectRootDirtextField.setColumns(10);
		
		JButton btnBrowse = new JButton("Ok");
		String root = "C:\\Users\\Shalan\\Desktop\\TESTDOCS";

		
		tree = new JTree(JTreeOne.bundleDirectory(root));

		tree.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tree.setBounds(10, 117, 216, 268);
		panel.add(tree);
		
		
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String roots;  
				roots = SelectRootDirtextField.getText();
				System.out.println(SelectRootDirtextField.getText());

				
				//File rootFolder = new File(root);
				try {
					ReadingFiles.readfiles(roots);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	//tree = new JTree(JTreeOne.bundleDirectory(root));

				//tree.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				//tree.setBounds(10, 117, 216, 268);
				//panel.add(tree);
				
				
			}
		});
		btnBrowse.setBounds(344, 42, 89, 23);
		panel.add(btnBrowse);
		
		JLabel lblNewLabel = new JLabel("Select root directory");
		lblNewLabel.setBounds(10, 27, 165, 14);
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
		
		JButton btnNewButton = new JButton("Add tag");
		btnNewButton.setBounds(370, 91, 89, 23);
		panel.add(btnNewButton);
		
		JList list = new JList();
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		list.setBounds(233, 117, 226, 268);
		panel.add(list);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.setBounds(233, 391, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("hello!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			
			
			}
		});
		btnDelete.setBounds(344, 391, 89, 23);
		panel.add(btnDelete);
		
		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.setBounds(10, 390, 89, 23);
		panel.add(btnSubmit_1);
		

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Search", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblSearchResult = new JLabel("Search Result");
		lblSearchResult.setBounds(10, 11, 101, 14);
		panel_1.add(lblSearchResult);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 36, 178, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		 final JTextArea textArea = new JTextArea();
		textArea.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textArea.setBounds(10, 67, 449, 335);
		panel_1.add(textArea);
		
	    
		
	    JScrollPane scroll = new JScrollPane();
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	          scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	         
	          
	         
	  	    textArea.setVisible(true);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String tagName;
				tagName = textField_2.getText();
				System.out.println(tagName);
				try {
					ArrayList a = new ArrayList();
					a = ReadingFiles.returnTagRearch(tagName);
					//textArea.append(ReadingFiles.returnTagRearch(tagName));
					for(int i = 0; i < a.size(); i++) {
						
						textArea.append((String) a.get(i));
						System.out.println();
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(192, 35, 89, 23);
		panel_1.add(btnSearch);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(291, 35, 89, 23);
		panel_1.add(btnRefresh);
		
		
		
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
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Recent", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton btnSubmit_3 = new JButton("Submit");
		btnSubmit_3.setBounds(10, 390, 89, 23);
		panel_3.add(btnSubmit_3);
		
		JList list_3 = new JList();
		list_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		list_3.setBounds(10, 30, 320, 328);
		panel_3.add(list_3);
		
		JLabel lblRecentSearch = new JLabel("Recent Search");
		lblRecentSearch.setBounds(10, 11, 119, 14);
		panel_3.add(lblRecentSearch);
		
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
		btnSubmit.setBounds(220, 39, 89, 23);
		panel_4.add(btnSubmit);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(220, 73, 89, 23);
		panel_4.add(btnAdd);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.setBounds(220, 107, 89, 23);
		panel_4.add(btnDelete_1);
	}
}