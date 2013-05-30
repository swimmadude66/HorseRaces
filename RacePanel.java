import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Canvas;
import java.awt.TextArea;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.BoxLayout;


public class RacePanel extends JPanel {

	public static HorseRaces hr;
	JLabel out;
	JLabel cbet;
	JLabel sbet;
	JLabel hbet;
	JLabel dbet;
	int ctot;
	int stot;
	int htot;
	int dtot;
	/**
	 * Create the panel.
	 */
	public RacePanel() {
		super();
		ctot =0;
		stot = 0;
		htot=0;
		dtot = 0;
		setLayout(null);
		
		hr = new HorseRaces();		

		JButton raceButton = new JButton("Race!");
		raceButton.addActionListener(
				new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					start();
					}
				}
		);
		raceButton.setBounds(212, 370, 196, 23);
		add(raceButton);
		
			
			out = new JLabel("Place your bets!");
			out.setHorizontalAlignment(SwingConstants.CENTER);
			out.setBounds(101, 345, 416, 14);
			add(out);
			
			JButton cp1 = new JButton("+1");
			cp1.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						betClubs(1);
						}
					}
			);
			cp1.setBounds(163, 418, 89, 23);
			add(cp1);
			
			JButton sp1 = new JButton("+1");
			sp1.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						betSpades(1);
						}
					}
			);
			sp1.setBounds(163, 452, 89, 23);
			add(sp1);
			
			JButton hp1 = new JButton("+1");
			hp1.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						betHearts(1);
						}
					}
			);
			hp1.setBounds(163, 490, 89, 23);
			add(hp1);
			
			JButton dp1 = new JButton("+1");
			dp1.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						betDiamonds(1);
						}
					}
			);
			dp1.setBounds(163, 524, 89, 23);
			add(dp1);
			
			JButton cp5 = new JButton("+5");
			cp5.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						betClubs(5);
						}
					}
			);
			cp5.setBounds(262, 418, 89, 23);
			add(cp5);
			
			JButton sp5 = new JButton("+5");
			sp5.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						betSpades(5);
						}
					}
			);
			sp5.setBounds(262, 452, 89, 23);
			add(sp5);
			
			JButton hp5 = new JButton("+5");
			hp5.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						betHearts(5);
						}
					}
			);
			hp5.setBounds(262, 490, 89, 23);
			add(hp5);
			
			JButton dp5 = new JButton("+5");
			dp5.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						betDiamonds(5);
						}
					}
			);
			dp5.setBounds(262, 524, 89, 23);
			add(dp5);
			
			JButton cp10 = new JButton("+10");
			cp10.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						betClubs(10);
						}
					}
			);
			cp10.setBounds(361, 418, 89, 23);
			add(cp10);
			
			JButton sp10 = new JButton("+10");
			sp10.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						betSpades(10);
						}
					}
			);
			sp10.setBounds(361, 452, 89, 23);
			add(sp10);
			
			JButton hp10 = new JButton("+10");
			hp10.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						betHearts(10);
						}
					}
			);
			hp10.setBounds(361, 490, 89, 23);
			add(hp10);
			
			JButton dp10 = new JButton("+10");
			dp10.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						betDiamonds(10);
						}
					}
			);
			dp10.setBounds(361, 524, 89, 23);
			add(dp10);
			
			cbet = new JLabel("0");
			cbet.setBounds(80, 418, 73, 23);
			add(cbet);
			
			sbet = new JLabel("0");
			sbet.setBounds(80, 452, 73, 23);
			add(sbet);
			
			hbet = new JLabel("0");
			hbet.setBounds(80, 490, 73, 23);
			add(hbet);
			
			dbet = new JLabel("0");
			dbet.setBounds(80, 524, 73, 23);
			add(dbet);
			
			JLabel clubs = new JLabel("Clubs:");
			clubs.setBounds(10, 418, 60, 23);
			add(clubs);
			
			JLabel spades = new JLabel("Spades:");
			spades.setBounds(10, 452, 60, 23);
			add(spades);
			
			JLabel hearts = new JLabel("Hearts:");
			hearts.setBounds(10, 490, 60, 23);
			add(hearts);
			
			JLabel diamonds = new JLabel("Diamonds:");
			diamonds.setBounds(10, 524, 60, 23);
			add(diamonds);
			
			JButton reset = new JButton("RESET");
			reset.addActionListener(
					new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						reset();
						}
					}
			);
			reset.setBounds(95, 587, 431, 23);
			add(reset);

	}
	
	public void paint(Graphics g){
		super.paint(g);
		for(int i=0; i<hr.side.length; i++){
			if(i<4){
				hr.horses[i].draw(g);
			}
			hr.side[i].draw(g,(i*50)+50,268);
		}
		if(hr.drawn!=null){
			hr.drawn.draw(g,0,268);
		}
		else{
			g.drawImage(new ImageIcon(getClass().getResource("/Images/b1fv.png")).getImage(), 0, 268, 50, 67, null);
		}
	}
	
	public void start(){
		while(!hr.over){
			out.setText(hr.race());
			this.repaint();
			wait(250);
		}
	}
	
	public void wait(int x){
		try {
		    Thread.currentThread();
			Thread.sleep(x);
		    this.repaint();
		} 
		catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	public void betClubs(int amount){
		ctot += amount;
		String bet = ""+ctot;
		cbet.setText(bet);
	}
	public void betSpades(int amount){
		stot += amount;
		String bet = ""+stot;
		sbet.setText(bet);
	}
	public void betHearts(int amount){
		htot += amount;
		String bet = ""+htot;
		hbet.setText(bet);
	}
	public void betDiamonds(int amount){
		dtot += amount;
		String bet = ""+dtot;
		dbet.setText(bet);
	}
	
	public void reset(){
		ctot =0;
		stot = 0;
		htot=0;
		dtot = 0;
		hr = new HorseRaces();
		cbet.setText("0");
		sbet.setText("0");
		hbet.setText("0");
		dbet.setText("0");
		this.repaint();
	}
	
}
