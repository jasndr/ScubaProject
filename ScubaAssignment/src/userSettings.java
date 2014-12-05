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


public class userSettings extends JFrame implements ActionListener{

	private ImageIcon image;
	private JLabel imageHolder;
	private Container container;
	
	public userSettings(final JButton button, final JButton button2, final JButton button3){
		setTitle("This program is a prototype and CANNOT be used for ACTUAL DIVES.");
		
		//get the image from the default package
		image = new ImageIcon(getClass().getResource("settings_img.jpg"));
		imageHolder = new JLabel(image); //set the image to a label
		container = getContentPane(); 
		container.add(imageHolder);	 //add the image to the container
		
		
		//add event listener
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				button.setEnabled(true);
				button2.setEnabled(true);
				button3.setEnabled(true);
			}
		});
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
