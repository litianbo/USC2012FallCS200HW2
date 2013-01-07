import javax.swing.ImageIcon;
import javax.swing.JButton;

//nothing fancy here...
public class ButtonCard extends JButton{
	int value;
	public ButtonCard(int v, String filename){
		super(new ImageIcon(filename));
		value = v;
	}
	public int getValue(){
		return value;
		
	}
	
	public String toString(){
		
		return ""+ value;
	}
}
