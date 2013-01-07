import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class ButtonDeck implements ActionListener {
	final int DECKSIZE = 52;
	final char[] cardNames = { 'a', '2', '3', '4', '5', '6', '7', '8', '9',
			't', 'j', 'q', 'k' };
	final char[] suitNames = { 'h', 'c', 'd', 's' };
	ArrayList<ButtonCard> allcards,cards, leftcards, thirdcards;

	JPanel cardpanel = new JPanel(new GridLayout());
	JPanel deckpanel = new JPanel(new FlowLayout());
	boolean p1turn = true;
	boolean p2turn = false;
	boolean p3turn = false;
	boolean p4turn = false;

	GridBagConstraints c = new GridBagConstraints();
	ArrayList<ButtonCard> tempdeck = new ArrayList<ButtonCard>();
	ArrayList<ButtonCard> fakedeck = new ArrayList<ButtonCard>();
	ArrayList<ButtonCard> deckcards = new ArrayList<ButtonCard>();
//to generate new cards....
	public ButtonDeck() {
		allcards = new ArrayList<ButtonCard>();
		cards = new ArrayList<ButtonCard>();
		leftcards = new ArrayList<ButtonCard>();
		thirdcards = new ArrayList<ButtonCard>();
		for (int i = 0; i < suitNames.length; i++) {
			for (int j = 0; j < cardNames.length; j++) {
				ButtonCard card = new ButtonCard(j, "cards/" + cardNames[j]
						+ suitNames[i] + ".gif");
				card.addActionListener(this);
				cards.add(card);
				ButtonCard tempcard = new ButtonCard(0, "cards/b.gif");
				tempcard.setVisible(false);

				fakedeck.add(tempcard);

			}

		}

		deckpanel.setBackground(Color.PINK);
	}
//set player's turn...
	public void setPlayersTurn(boolean p1, boolean p2, boolean p3, boolean p4) {
		p1turn = p1;
		p2turn = p2;
		p3turn = p3;
		p4turn = p4;

	}

	public ArrayList<ButtonCard> getDeckCards() {

		return deckcards;
	}

	public void setFakeDeckInv() {
		for (int i = 0; i < fakedeck.size(); i++)
			fakedeck.get(i).setVisible(false);

	}

	public JPanel getDeck() {
		for (int i = 0; i < fakedeck.size(); i++)
			deckpanel.add(fakedeck.get(i));
		return deckpanel;

	}

	public void setP1Cards() {
		for (int i = 0; i < deckcards.size(); i++)
			cards.add(deckcards.get(i));
	}

	public void setP2Cards() {
		for (int i = 0; i < deckcards.size(); i++)
			leftcards.add(deckcards.get(i));
	}

	public void setP3Cards() {
		for (int i = 0; i < deckcards.size(); i++)
			thirdcards.add(deckcards.get(i));
	}

	public void setDeck() {
		for (int i = 0; i < tempdeck.size(); i++) {

			deckcards.add(tempdeck.get(i));
		}
	}

	public ArrayList<ButtonCard> getTempCards() {

		return tempdeck;
	}

	public void setEmptyDeck() {
		tempdeck.clear();

	}

	public void setCard(ArrayList<ButtonCard> bc) {

		cards = bc;
		for (int i = 0; i < cards.size(); i++)
			cards.get(i).addActionListener(this);

	}

	public void setLeftCard(ArrayList<ButtonCard> bc) {

		leftcards = bc;
		for (int i = 0; i < leftcards.size(); i++)
			leftcards.get(i).addActionListener(this);
	}

	public void setThirdCard(ArrayList<ButtonCard> bc) {

		thirdcards = bc;
		for (int i = 0; i < thirdcards.size(); i++)
			thirdcards.get(i).addActionListener(this);
	}

	public ArrayList<ButtonCard> getCardsDeck() {

		return cards;
	}

	public ArrayList<ButtonCard> getLeftCardsDeck() {

		return leftcards;
	}

	public ArrayList<ButtonCard> getThirdCardsDeck() {

		return thirdcards;
	}

	@Override
	//make their cards clickable,,,,,
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (p1turn) {

			for (int i = 0; i < cards.size(); i++) {
				if (e.getSource() == cards.get(i)) {
					cards.get(i).setVisible(false);
					tempdeck.add(cards.remove(i));

					fakedeck.get(tempdeck.size() - 1).setVisible(true);

				}
			}

		} else if (p2turn) {

			for (int i = 0; i < leftcards.size(); i++) {
				if (e.getSource() == leftcards.get(i)) {
					leftcards.get(i).setVisible(false);
					tempdeck.add(leftcards.remove(i));
					fakedeck.get(tempdeck.size() - 1).setVisible(true);

				}
			}
		} else if (p3turn) {

			for (int i = 0; i < thirdcards.size(); i++) {
				if (e.getSource() == thirdcards.get(i)) {
					thirdcards.get(i).setVisible(false);
					tempdeck.add(thirdcards.remove(i));
					fakedeck.get(tempdeck.size() - 1).setVisible(true);

				}
			}
		}

	}
	//shufle cards for 3 players////
	public void shuffle3(){
		ArrayList<ButtonCard> shuffledCards = new ArrayList<ButtonCard>();
		Random r = new Random();
		cards.clear();
		leftcards.clear();
		thirdcards.clear();
		for (int i = 0; i < suitNames.length; i++) {
			for (int j = 0; j < cardNames.length; j++) {
				ButtonCard card = new ButtonCard(j, "cards/" + cardNames[j]
						+ suitNames[i] + ".gif");
				card.addActionListener(this);
				cards.add(card);
			}
		}
		for (int i = 0; i < DECKSIZE; i++) {
			int index = r.nextInt(DECKSIZE - i);
			shuffledCards.add(cards.remove(index));

		}
		cards = shuffledCards;
		for (int i = 0; i < DECKSIZE / 3; i++) {
			leftcards.add(cards.remove(i));

		}
		for (int i = 0; i < DECKSIZE / 3; i++) {
			thirdcards.add(cards.remove(i));

		}
	}
	public void shuffle() {
		ArrayList<ButtonCard> shuffledCards = new ArrayList<ButtonCard>();
		Random r = new Random();
		leftcards.clear();
		thirdcards.clear();
		for (int i = 0; i < DECKSIZE; i++) {
			int index = r.nextInt(DECKSIZE - i);
			shuffledCards.add(cards.remove(index));

		}
		cards = shuffledCards;
		for (int i = 0; i < DECKSIZE / 2; i++) {
			leftcards.add(cards.remove(i));

		}

	}
//display first player and second player's card...
	public void displayAllCards(JPanel p1, JPanel p2) {

		c.gridy = 4;

		p1.removeAll();
		p2.removeAll();
		for (ButtonCard card : cards) {
			// card.setPreferredSize(new Dimension(80,110));
			p1.add(card, c);

		}
		for (ButtonCard card : leftcards) {

			p2.add(card, c);

		}
	}

}
