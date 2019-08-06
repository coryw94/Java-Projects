import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class SortArray extends JApplet implements ActionListener {

	JTextField txtIn = new JTextField(10);
	JTextArea txtOut = new JTextArea(10,10);
	JButton btnStart = new JButton("Start");
	int counter = 0;
	int []temp = new int[5];

	public SortArray(){
		setLayout(new BorderLayout());
		add(txtIn,BorderLayout.NORTH);
		add(txtOut,BorderLayout.CENTER);
		add(btnStart,BorderLayout.SOUTH);
		btnStart.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e){
		Array test = new Array(temp);
		if (counter<5) {
			temp[counter] = Integer.parseInt(txtIn.getText());
			counter++;
		} else {
			temp = test.sortArray(temp);
			System.out.println(temp[0]+" "+temp[1]+" "+temp[2]+" "+temp[3]+" "+temp[4]+" ");
		}

	}

}