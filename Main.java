import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 
	 Game game;
	 
	 
			/**
	 * @param args
	 */
	public Main() {
		game = new Game(this);
		
		
		
		
		
		
	}


public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Main m = new Main();
		m.setSize(1500,800);
		m.setVisible(true);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setTitle("BullShit for 2");
		
	}
//paint stuffs....
	public void actionPerformed(ActionEvent ae) {
		//repaint();
		
		
		
		
	}
	

}
