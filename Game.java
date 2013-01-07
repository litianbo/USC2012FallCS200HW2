import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class Game implements ActionListener {

	/**
	 * @param args
	 */

	ButtonDeck gamedeck = new ButtonDeck();

	int turncounter = 0;
	boolean cheat = false;
	ArrayList<Player> player = new ArrayList<Player>();
	// Layout Stuff
	JLabel decklabel = new JLabel("Deck: ");
	JPanel cardpanel = new JPanel();
	JPanel leftcardpanel = new JPanel();
	JPanel buttonpanel = new JPanel();
	JPanel deckpanel = new JPanel();
	JPanel enterp1namepanel = new JPanel();
	JPanel p1namepanel = new JPanel();
	JPanel p2namepanel = new JPanel();
	JPanel p3namepanel = new JPanel();
	JPanel enterp2namepanel = new JPanel();
	JPanel enterp3namepanel = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel wonpanel1 = new JPanel();
	JPanel wonpanel2 = new JPanel();
	JPanel wonpanel3 = new JPanel();
	boolean p1turn = true;
	boolean p2turn = false;
	boolean p3turn = false;
	boolean p4turn = false;
	boolean lockbool = false;
	JScrollPane scorllcardpane1 = new JScrollPane(cardpanel);
	JScrollPane scorllcardpane2 = new JScrollPane(leftcardpanel);
	JScrollPane scorllcardpane3 = new JScrollPane(panel3);
	JButton lock = new JButton("Lock");
	JButton turnover = new JButton("Turnover");
	JButton bullshit = new JButton("BullShit");
	GridBagConstraints c = new GridBagConstraints();
	JFrame app;
	String leftname, rightname;
	JMenuBar menubar;
	JMenu file, players;
	JMenuItem exit, start, addplayer, savedata, readdata, setp1name, setp2name,
			setp3name;
	JTextField enterp1name, enterp2name, enterp3name;
	JLabel p1name, p2name, p3name, wonlabel1, wonlabel2, wonlabel3;

	public Game(JFrame main) {
		// at least two people should play this game....
		player.add(new Player());
		player.add(new Player());
		app = main;
		// call game start to start a game.
		gameStart();

		turnover.addActionListener(this);
		lock.addActionListener(this);
		bullshit.addActionListener(this);
		start.addActionListener(this);
		exit.addActionListener(this);
		addplayer.addActionListener(this);
		savedata.addActionListener(this);
		setp1name.addActionListener(this);
		setp2name.addActionListener(this);
		setp3name.addActionListener(this);
		readdata.addActionListener(this);
		enterp1name.addActionListener(this);
		enterp2name.addActionListener(this);
		enterp3name.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// prompt user for names and game stats.
	public void gameStart() {
		// all of them are layout stuff....

		app.setLayout(new GridLayout(2, 3));
		menubar = new JMenuBar();
		file = new JMenu("File");
		players = new JMenu("Players");
		exit = new JMenuItem("Exit");
		start = new JMenuItem("Start");
		addplayer = new JMenuItem("Add 1 Player");
		readdata = new JMenuItem("Read data");
		savedata = new JMenuItem("Save data");
		setp1name = new JMenuItem("Set Player1's name");
		setp2name = new JMenuItem("Set Player2's name");
		setp3name = new JMenuItem("Set Player3's name");
		enterp1name = new JTextField(20);
		enterp2name = new JTextField(20);
		enterp3name = new JTextField(20);
		wonlabel1 = new JLabel("won! ");
		wonlabel2 = new JLabel("won ~~");
		wonlabel3 = new JLabel("won >_<");
		p1name = new JLabel(" ");
		p2name = new JLabel(" ");
		p3name = new JLabel(" ");
		menubar.setVisible(true);
		file.setVisible(true);
		players.setVisible(true);
		exit.setVisible(true);
		start.setVisible(true);
		addplayer.setVisible(true);
		decklabel.setVisible(true);
		wonlabel1.setVisible(true);
		decklabel.setBackground(Color.pink);
		menubar.add(file);
		menubar.add(players);
		file.add(exit);
		file.add(start);
		players.add(addplayer);
		players.add(savedata);
		players.add(readdata);
		players.add(setp1name);
		players.add(setp2name);
		players.add(setp3name);
		app.setJMenuBar(menubar);
		buttonpanel.setBackground(Color.CYAN);
		buttonpanel.setVisible(true);
		buttonpanel.setLayout(new FlowLayout());
		turnover.setVisible(true);
		lock.setVisible(true);
		bullshit.setVisible(true);

		buttonpanel.add(turnover);

		buttonpanel.add(lock);

		buttonpanel.add(bullshit);

		buttonpanel.add(decklabel);

		buttonpanel.add(gamedeck.getDeck());

		app.add(buttonpanel);
		// about the new panel(such as name TextField...) in layout
		gameStart2();

	}

	public void gameStart2() {
		// about buttonCards layout...
		cardpanel.setBackground(Color.yellow);
		leftcardpanel.setBackground(Color.GREEN);
		panel3.setBackground(Color.PINK);
		cardpanel.setLayout(new GridBagLayout());
		leftcardpanel.setLayout(new GridBagLayout());
		panel3.setLayout(new GridBagLayout());
		cardpanel.setVisible(true);
		leftcardpanel.setVisible(true);
		panel3.setVisible(true);
		gamedeck.shuffle();
		enterp1namepanel.setVisible(false);
		enterp2namepanel.setVisible(false);
		enterp3namepanel.setVisible(false);
		p1namepanel.setVisible(false);
		p2namepanel.setVisible(false);
		p3namepanel.setVisible(false);
		p1name.setVisible(true);
		p2name.setVisible(true);
		p3name.setVisible(true);
		enterp1namepanel.add(enterp1name);
		enterp2namepanel.add(enterp2name);
		enterp3namepanel.add(enterp3name);
		cardpanel.add(p1namepanel);
		cardpanel.add(enterp1namepanel);
		cardpanel.add(wonpanel1);
		leftcardpanel.add(p2namepanel);
		leftcardpanel.add(enterp2namepanel);
		leftcardpanel.add(wonpanel2);
		panel3.add(p3namepanel);
		panel3.add(enterp3namepanel);
		panel3.add(wonpanel3);
		p1namepanel.add(p1name);
		p2namepanel.add(p2name);
		p3namepanel.add(p3name);
		gamedeck.displayAllCards(cardpanel, leftcardpanel);
		scorllcardpane3.setVisible(true);
		app.add(scorllcardpane1);
		app.add(scorllcardpane2);
		app.add(scorllcardpane3);
		wonpanel2.add(wonlabel2);
		wonpanel3.add(wonlabel3);
		wonpanel1.add(wonlabel1);
		// wonpanel2.add(wonlabel);
		// wonpanel3.add(wonlabel);
		wonpanel1.setVisible(true);
		wonpanel2.setVisible(true);
		wonpanel3.setVisible(true);
		// Panel3 layout:

	}

	//
	public void gameOver() {
		// won display something....
		if (gamedeck.getCardsDeck().size() == 0) {
			wonlabel1.setVisible(false);
			wonpanel1.setVisible(false);
			player.get(0).addwontimes();
			if (player.get(0).getName() != null)
				wonlabel1 = new JLabel(player.get(0).getName()
						+ ", this is your " + player.get(0).getWonTimes()
						+ " wons. Congraluation! Click exit to quit");

			cardpanel.add(wonpanel1);
			wonpanel1.add(wonlabel1);
			wonlabel1.setVisible(true);
			wonpanel1.setVisible(true);

		}
		if (gamedeck.getLeftCardsDeck().size() == 0) {
			wonlabel2.setVisible(false);
			wonpanel2.setVisible(false);
			player.get(1).addwontimes();
			if (player.get(1).getName() != null)
				wonlabel2 = new JLabel(player.get(1).getName()
						+ ", this is your " + player.get(1).getWonTimes()
						+ " wons. Congraluation! Click exit to quit");

			leftcardpanel.add(wonpanel2);
			wonpanel2.add(wonlabel2);
			wonlabel2.setVisible(true);
			wonpanel2.setVisible(true);

		}
		if (gamedeck.getThirdCardsDeck().size() == 0 && player.size() == 3) {
			wonlabel3.setVisible(false);
			wonpanel3.setVisible(false);
			player.get(2).addwontimes();
			wonlabel3 = new JLabel(player.get(2).getName() + ", this is your "
					+ player.get(2).getWonTimes()
					+ " wons. Congraluation! Click exit to quit");

			panel3.add(wonpanel3);
			wonpanel3.add(wonlabel3);
			wonlabel3.setVisible(true);
			wonpanel3.setVisible(true);

		}
	}

	// to check the whether cheat or not...
	public boolean checkCheat() {

		cheat = false;
		for (int i = 0; i < gamedeck.getTempCards().size(); i++)
			if (turncounter % 13 != gamedeck.getTempCards().get(i).getValue())
				cheat = true;

		return cheat;
	}

	@Override
	// most complex methid in the game.,,
	// handle all of the input(mouse click, or keyboard input)
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// exit the application
		if (e.getSource() == exit) {
			System.exit(0);
		}
		// // player's name set
		if (e.getSource() == setp3name && player.size() > 2) {
			panel3.add(enterp3namepanel);

			enterp3namepanel.setVisible(true);
			enterp3name.setVisible(true);
			p3namepanel.setVisible(false);
		}

		if (e.getSource() == enterp3name) {
			player.get(2).setName(enterp3name.getText());
			p3name.setVisible(false);
			p3name = new JLabel(player.get(2).getName());
			enterp3namepanel.setVisible(false);
			p3namepanel.setVisible(true);
			panel3.add(p3namepanel);
			p3name.setVisible(true);
			p3namepanel.add(p3name);
		}

		if (e.getSource() == setp1name) {
			cardpanel.add(enterp1namepanel);

			enterp1namepanel.setVisible(true);
			enterp1name.setVisible(true);
			p1namepanel.setVisible(false);
		}
		if (e.getSource() == enterp1name) {
			player.get(0).setName(enterp1name.getText());
			p1name.setVisible(false);
			p1name = new JLabel(player.get(0).getName());
			enterp1namepanel.setVisible(false);
			p1namepanel.setVisible(true);
			cardpanel.add(p1namepanel);
			p1name.setVisible(true);
			p1namepanel.add(p1name);
		}
		if (e.getSource() == setp2name) {
			leftcardpanel.add(enterp2namepanel);
			enterp2namepanel.setVisible(true);
			enterp2name.setVisible(true);
			p2namepanel.setVisible(false);
		}
		if (e.getSource() == enterp2name) {
			player.get(1).setName(enterp2name.getText());
			p2name.setVisible(false);
			p2name = new JLabel(player.get(1).getName());
			enterp2namepanel.setVisible(false);
			p2namepanel.setVisible(true);
			leftcardpanel.add(p2namepanel);
			p2name.setVisible(true);
			p2namepanel.add(p2name);
		}
		
		//serilzable to store the players' data.
		if (e.getSource() == savedata) {
			try {

				FileOutputStream fos = new FileOutputStream("serial");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				player.get(0).setCards(gamedeck.getCardsDeck());
				player.get(1).setCards(gamedeck.getLeftCardsDeck());
				if (player.size() == 3) {
					player.get(2).setCards(gamedeck.getThirdCardsDeck());
				}
				oos.writeObject(player.get(0));
				oos.writeObject(player.get(1));
				if (player.size() == 3) {
					oos.writeObject(player.get(2));
				}
				oos.flush();
				oos.close();
			} catch (Exception ee) {
				System.out.println("Exception during serialization:" + e);

				System.exit(0);
			}
		}

		if (e.getSource() == readdata) {
			try {

				cardpanel.setVisible(false);
				leftcardpanel.setVisible(false);
				panel3.setVisible(false);

				FileInputStream fis = new FileInputStream("serial");
				ObjectInputStream ois = new ObjectInputStream(fis);

				Player newplayer1 = new Player();
				Player newplayer2 = new Player();
				Player newplayer3 = new Player();
				newplayer1 = (Player) ois.readObject();
				newplayer2 = (Player) ois.readObject();
				if (ois.available() > 0)
					newplayer3 = (Player) ois.readObject();
				gamedeck.setCard(newplayer1.getCards());
				gamedeck.setLeftCard(newplayer2.getCards());
				// gamedeck.setThirdCard(newplayer3.getCards());

				gamedeck.displayAllCards(cardpanel, leftcardpanel);

				cardpanel.setVisible(true);
				leftcardpanel.setVisible(true);
				panel3.setVisible(true);
				ois.close();

			} catch (Exception ee) {
				System.out.println("Exception during deserialization:" + e);
				System.exit(0);
			}

		}
		//add a new player
		if (e.getSource() == addplayer && player.size() < 3) {
			player.add(new Player());
			cardpanel.removeAll();
			leftcardpanel.removeAll();
			panel3.removeAll();
			gamedeck.shuffle3();
			cardpanel.setVisible(false);
			leftcardpanel.setVisible(false);
			panel3.setVisible(false);
			for (int i = 0; i < gamedeck.getCardsDeck().size(); i++)
				cardpanel.add(gamedeck.getCardsDeck().get(i));
			for (int i = 0; i < gamedeck.getLeftCardsDeck().size(); i++)
				leftcardpanel.add(gamedeck.getLeftCardsDeck().get(i));
			for (int i = 0; i < gamedeck.getThirdCardsDeck().size(); i++)
				panel3.add(gamedeck.getThirdCardsDeck().get(i));
			cardpanel.setVisible(true);
			leftcardpanel.setVisible(true);
			panel3.setVisible(true);
		}
		//start a game
		if (e.getSource() == start) {

			for (int i = 0; i < gamedeck.getLeftCardsDeck().size(); i++)
				gamedeck.getLeftCardsDeck().get(i).setVisible(false);
			for (int i = 0; i < gamedeck.getThirdCardsDeck().size(); i++)
				gamedeck.getThirdCardsDeck().get(i).setVisible(false);
			gamedeck.setDeck();
			gamedeck.setEmptyDeck();
		}
		//everything blow here is about the game rules, see DesignDocument for more info.
		if (p1turn && e.getSource() == lock && lockbool == false) {
			lockbool = true;
			p2turn = true;
			p1turn = false;
			p3turn = false;
			gamedeck.setPlayersTurn(p1turn, p2turn, p3turn, p4turn);
			for (int i = 0; i < gamedeck.getCardsDeck().size(); i++) {
				gamedeck.getCardsDeck().get(i).setVisible(false);
			}
			for (int i = 0; i < gamedeck.getLeftCardsDeck().size(); i++) {
				gamedeck.getLeftCardsDeck().get(i).setVisible(false);

			}
			for (int i = 0; i < gamedeck.getThirdCardsDeck().size(); i++)
				gamedeck.getThirdCardsDeck().get(i).setVisible(false);
			gamedeck.setDeck();

		}
		if (p2turn && e.getSource() == lock && lockbool == false
				&& player.size() == 2) {
			lockbool = true;
			p2turn = false;
			p1turn = true;
			p3turn = false;
			gamedeck.setPlayersTurn(p1turn, p2turn, p3turn, p4turn);
			for (int i = 0; i < gamedeck.getCardsDeck().size(); i++) {
				gamedeck.getCardsDeck().get(i).setVisible(false);

			}
			for (int i = 0; i < gamedeck.getLeftCardsDeck().size(); i++) {
				gamedeck.getLeftCardsDeck().get(i).setVisible(false);

			}
			for (int i = 0; i < gamedeck.getThirdCardsDeck().size(); i++)
				gamedeck.getThirdCardsDeck().get(i).setVisible(false);
			gamedeck.setDeck();
		}
		// set p3turn////
		if (p2turn && e.getSource() == lock && lockbool == false
				&& player.size() == 3) {
			lockbool = true;
			p2turn = false;
			p1turn = false;
			p3turn = true;
			gamedeck.setPlayersTurn(p1turn, p2turn, p3turn, p4turn);
			for (int i = 0; i < gamedeck.getCardsDeck().size(); i++) {
				gamedeck.getCardsDeck().get(i).setVisible(false);

			}
			for (int i = 0; i < gamedeck.getLeftCardsDeck().size(); i++) {
				gamedeck.getLeftCardsDeck().get(i).setVisible(false);

			}
			for (int i = 0; i < gamedeck.getThirdCardsDeck().size(); i++)
				gamedeck.getThirdCardsDeck().get(i).setVisible(false);
			gamedeck.setDeck();
		}
		if (p3turn && e.getSource() == lock && lockbool == false) {
			lockbool = true;
			p2turn = false;
			p1turn = true;
			p3turn = false;
			gamedeck.setPlayersTurn(p1turn, p2turn, p3turn, p4turn);
			for (int i = 0; i < gamedeck.getCardsDeck().size(); i++) {
				gamedeck.getCardsDeck().get(i).setVisible(false);

			}
			for (int i = 0; i < gamedeck.getLeftCardsDeck().size(); i++) {
				gamedeck.getLeftCardsDeck().get(i).setVisible(false);

			}
			for (int i = 0; i < gamedeck.getThirdCardsDeck().size(); i++)
				gamedeck.getThirdCardsDeck().get(i).setVisible(false);
		}
		// BULLSHITSHITHSIHISTHISTHISTHISTH
		if (lockbool && e.getSource() == bullshit) {

			gamedeck.setFakeDeckInv();
			// catch cheating or not?
			if (checkCheat()) {
				if (p1turn) {
					gamedeck.setP3Cards();
				} else if (p2turn) {
					gamedeck.setP1Cards();
				} else {
					gamedeck.setP2Cards();
				}
			} else {
				if (p2turn) {
					gamedeck.setP2Cards();
				} else if (p1turn) {
					gamedeck.setP1Cards();
				} else {
					gamedeck.setP3Cards();
				}
			}
		}
		if (lockbool && e.getSource() == turnover) {
			gameOver();
			lockbool = false;
			turncounter++;
			gamedeck.setEmptyDeck();
			if (p1turn) {
				for (int i = 0; i < gamedeck.getCardsDeck().size(); i++) {
					gamedeck.getCardsDeck().get(i).setVisible(true);

				}
				for (int i = 0; i < gamedeck.getLeftCardsDeck().size(); i++)
					gamedeck.getLeftCardsDeck().get(i).setVisible(false);
				for (int i = 0; i < gamedeck.getThirdCardsDeck().size(); i++)
					gamedeck.getThirdCardsDeck().get(i).setVisible(false);
				gamedeck.setFakeDeckInv();
			} else if (p2turn) {
				for (int i = 0; i < gamedeck.getCardsDeck().size(); i++) {
					gamedeck.getCardsDeck().get(i).setVisible(false);

				}
				for (int i = 0; i < gamedeck.getLeftCardsDeck().size(); i++)
					gamedeck.getLeftCardsDeck().get(i).setVisible(true);
				for (int i = 0; i < gamedeck.getThirdCardsDeck().size(); i++)
					gamedeck.getThirdCardsDeck().get(i).setVisible(false);
				gamedeck.setFakeDeckInv();
			} else {
				for (int i = 0; i < gamedeck.getCardsDeck().size(); i++) {
					gamedeck.getCardsDeck().get(i).setVisible(false);

				}
				for (int i = 0; i < gamedeck.getLeftCardsDeck().size(); i++)
					gamedeck.getLeftCardsDeck().get(i).setVisible(false);
				for (int i = 0; i < gamedeck.getThirdCardsDeck().size(); i++)
					gamedeck.getThirdCardsDeck().get(i).setVisible(true);
				gamedeck.setFakeDeckInv();

			}

		}
		//
	}

}
