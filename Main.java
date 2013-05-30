import java.awt.*;
import javax.swing.*;



public class Main {
	public static RacePanel primary;
	
	static String[] suits ={"club", "spade", "heart", "diamond"};
	static String[] values={"ace", "king", "queen", "jack", "ten", "nine", "eight", "seven", "six", "five", "four", "three", "two"};
	
	
	
	public static void main(String[] args){
		JFrame frame = new JFrame("A Day at the Races");
			frame.setPreferredSize(new Dimension(600,800));
		primary = new RacePanel();
			primary.setPreferredSize(new Dimension(500,300));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(primary);
	frame.pack();
	frame.setVisible(true);
	}
}
