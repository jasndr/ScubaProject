import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.ArrayList;


public class mainDisplay extends JFrame implements ActionListener{

	private ImageIcon image;
	private JLabel imageHolder;
	private Container container;

	public mainDisplay(final JButton button, final JButton button2, final JButton button3, final ArrayList<DiveStruct> userTable){
		setTitle("This program is a prototype and CANNOT be used for ACTUAL DIVES.");

		//get the image from the default package
		image = new ImageIcon(getClass().getResource("mainDis_img.jpg"));
		imageHolder = new JLabel(image); //set the image to a label
		container = getContentPane();
		container.add(imageHolder);	 //add the image to a container


		//add event listener
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				button.setEnabled(true);
				button2.setEnabled(true);
				button3.setEnabled(true);
				if(userTable.size() > 0){
					userTable.remove(0);
				}
			}
		});

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
