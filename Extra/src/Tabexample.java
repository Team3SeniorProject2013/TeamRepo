import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.AbstractListModel;
import java.awt.Font;


public class Tabexample extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabexample frame = new Tabexample();
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
	public Tabexample() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		
		
		tabbedPane.addTab("Tags", null, panel, null);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 43, 335, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse");
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(236, 92, 134, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Add tag");
		btnNewButton.setBounds(370, 91, 89, 23);
		panel.add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(233, 117, 226, 274);
		panel.add(list);
		
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
		btnSubmit_1.setBounds(10, 390, 89, 23);
		panel.add(btnSubmit_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Search", null, panel_1, null);
		
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
		list_2.setBounds(386, 25, 73, 388);
		panel_2.add(list_2);
		
		JButton btnSubmit_2 = new JButton("Submit");
		btnSubmit_2.setBounds(0, 390, 89, 23);
		panel_2.add(btnSubmit_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Recent", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Bookmark", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblBookmarkedTags = new JLabel("Bookmarked Tags");
		lblBookmarkedTags.setBounds(10, 28, 288, 14);
		panel_4.add(lblBookmarkedTags);
		
		JList list_1 = new JList();
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
