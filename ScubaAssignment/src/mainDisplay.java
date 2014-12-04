import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class mainDisplay extends JFrame implements ActionListener{

	private JLabel lbl;
	
	public mainDisplay(final JButton button){
		setTitle("This program is a prototype and CANNOT be used for ACTUAL DIVES.");
	
		lbl = new JLabel("Placeholder: The MAIN DISPLAY GUI isn't implemented yet", SwingConstants.CENTER);
		lbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(lbl);
		
		
		//add event listener
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				button.setEnabled(true);
			}
		});
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
