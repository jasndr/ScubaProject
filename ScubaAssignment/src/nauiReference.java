import java.awt.Container;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;


public class nauiReference extends JFrame implements ActionListener{
	
	private ImageIcon image;
	private JLabel imageHolder;
	private Container container;
	
	public nauiReference(final JButton button){		
		
		setTitle("This program is a prototype and CANNOT be used for ACTUAL DIVES.");
		
		image = new ImageIcon(getClass().getResource("Dive_tables_NAUI.jpg"));
		imageHolder = new JLabel(image);
		container = getContentPane();
		container.add(imageHolder);	
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				button.setEnabled(true);
			}
		});
		
	}

	
	//if you would just like to test the diveTable
	//comment out other main methods in other class
/*	public static void main(String[] args){
		nauiReference naui = new nauiReference();
		naui.setVisible(true);
		naui.setTitle("PROTOTYPE");
		naui.setLocation(700,100);
		naui.pack();
		naui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
