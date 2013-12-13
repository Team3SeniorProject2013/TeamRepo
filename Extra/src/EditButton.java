import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class EditButton {

    public static void main(String [] args) {

        String test1= JOptionPane.showInputDialog("Please input mark for test 1: ");

        

        

        int int1 = Integer.parseInt(test1);
        
        

        SortedSet<Integer> set = new TreeSet<>();
        set.add(int1);
        
       

        Integer [] intArray = set.toArray(new Integer[3]);
        JFrame frame = new JFrame();
        JOptionPane.showInternalMessageDialog(frame.getContentPane(), String.format("Result %f", (intArray[1] + intArray[2]) / 2.0));

    }

}

