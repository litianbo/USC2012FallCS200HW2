import java.io.Serializable;
import java.util.ArrayList;

//implements serializable here.....
public class Player implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	//get the names from game class...
	String name;
	ArrayList<ButtonCard> cards = new ArrayList<ButtonCard>();
	int wontimes;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//serialization
		
		
	}
	public void addwontimes(){
		wontimes++;
	}
	public int getWonTimes(){
		return wontimes;
	}
	public void setCards(ArrayList<ButtonCard> bc){
		cards = bc;
	}
	public ArrayList<ButtonCard> getCards(){
		return cards;
	}
	public void printCards(){
		
	System.out.println(cards.get(0).getValue());
	}
	public String toString(){
		return name;
	}
	public String getName(){
		return name;
	}
	public void setName(String s1){
		
		name = s1;
	}
}
