import java.awt.Graphics;
import java.awt.Image;



public class HorseRaces {
	String[] suits ={"club", "spade", "heart", "diamond"};
	String[] values={"ace", "king", "queen", "jack", "ten", "nine", "eight", "seven", "six", "five", "four", "three", "two"};
	public static CardDeck deck;
	
	public CardDeck.Card[] side;
	public Horse[] horses;
	
	public CardDeck.Card drawn;
	private int lastplace;
	public boolean over;
	public int winner;
	
	public HorseRaces(){
		deck = new CardDeck();
		deck.removeValue(0);
		over = false;
		side = new CardDeck.Card[8];
		horses = new Horse[4];
		winner = -1;
		over = false;
		for(int i=0;i<8;i++){
			if(i<4){
				horses[i] = new Horse(i);
			}
			side[i] = deck.draw();
		}
	}
	
	public String race(){
		lastplace = 100;
		String outp= "";
		if(deck.isEmpty()){
			deck.reshuffle();
		}
		drawn = deck.draw();
		deck.discard(drawn);
		drawn.flip();
		horses[drawn.getSuit()].moveup();
		outp = (suits[drawn.getSuit()] + " rushes forward");
		for(int i=0; i<4; i++){
			if(horses[i].locx >=9){
				over = true;
				outp += (" and wins!");
				winner = horses[i].suitindex;
				return outp;
			}
			lastplace = (int)Math.min(lastplace, horses[i].locx);
		}
		if(lastplace >0){
			if(!side[lastplace-1].isFlipped()){
				side[lastplace-1].flip();
				horses[side[lastplace-1].getSuit()].moveback();
				outp += (" and " + suits[side[lastplace-1].getSuit()] +" falls back!");
				return outp;
			}
			else{
				outp +=("!");
				return outp;
			}
		}
		else{
			outp +=("!");
			return outp;
		}
		
	}
	
	
	
	//@SuppressWarnings("unused")
	public class Horse{
		private Image img;
		private int suitindex;
		private int locx;
		private int locy;
		final int SIZEx = 50;
		final int SIZEy = 67;
		
		public Horse(int suit){
			suitindex = suit;
			locy = suitindex*SIZEy;
			locx=0;
			switch(suitindex){
			case 0:
				img = new javax.swing.ImageIcon(getClass().getResource("Images/c.png")).getImage();
				break;
			case 1:
				img = new javax.swing.ImageIcon(getClass().getResource("Images/s.png")).getImage();
				break;
			case 2:
				img = new javax.swing.ImageIcon(getClass().getResource("Images/h.png")).getImage();
				break;
			case 3:
				img = new javax.swing.ImageIcon(getClass().getResource("Images/d.png")).getImage();
				break;
			default:
				img = new javax.swing.ImageIcon(getClass().getResource("Images/c.png")).getImage();
				break;
			}
			
		}
		
		public void moveup(){
			locx += 1;
		}
		public void moveback(){
			locx -= 1;
		}
		
		
		public int getPos(){
			return locx;
		}
		
		public void draw(Graphics g){
			g.drawImage(this.img, locx*50, locy,SIZEx, SIZEy, null);
		}
		
		public Image getImage(){
			return img;
		}
		
	}
}
