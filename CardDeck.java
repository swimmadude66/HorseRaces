import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
public class CardDeck {
	
	Image[] images =
		{
		new ImageIcon(getClass().getResource("Images/1.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/2.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/3.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/4.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/5.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/6.png")).getImage(),
		new ImageIcon(getClass().getResource("Images/7.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/8.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/9.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/10.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/11.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/12.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/13.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/14.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/15.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/16.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/17.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/18.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/19.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/20.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/21.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/22.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/23.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/24.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/25.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/26.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/27.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/28.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/29.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/30.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/31.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/32.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/33.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/34.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/35.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/36.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/37.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/38.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/39.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/40.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/41.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/42.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/43.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/44.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/45.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/46.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/47.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/48.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/49.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/50.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/51.png")).getImage(), 
		new ImageIcon(getClass().getResource("Images/52.png")).getImage(), 
		};
	
	String[] suits ={"club", "spade", "heart", "diamond"};
	String[] values={"ace", "king", "queen", "jack", "ten", "nine", "eight", "seven", "six", "five", "four", "three", "two"};
	Random rnd;
	
	public Card[] deck;
	public Card[] discard;
	
	public CardDeck(){
		rnd = new Random();
		deck = new Card[52];
		discard = new Card[0];
		for(int i=0; i<suits.length;i++){
			for(int j=0; j<values.length; j++){
				deck[(values.length*i)+j] = new Card(suits[i],values[j]);
			}
		}
	}
	
	public Card draw(){
		if(!isEmpty()){
		int d = Math.abs(rnd.nextInt())%deck.length;
		Card[] newdeck = new Card[deck.length -1];
		Card drawn = deck[d];
		int j = 0;
		for(int i=0; i<deck.length;i++){
			if(i!=d){
				newdeck[j]=deck[i];
				j++;
			}
		}
		deck = newdeck;
		return drawn;
		}
		else{
			return null;
		}
	}
	
	public void discard(Card c){
		Card[] newdiscard = new Card[discard.length +1];
		for(int i = 0; i<discard.length; i++){
			newdiscard[i] = discard[i];
		}
		newdiscard[newdiscard.length -1] = c;
		discard = newdiscard;
	}
	
	
	
	public boolean isEmpty(){
		if(deck.length>0){
			return false;
		}
		else{
			return true;
		}
	}
	
	public void removeValue(int val){
		Card[] newdeck = new Card[deck.length-4];
		int j =0;
		for(int i=0; i<deck.length; i++){
			if(deck[i].getValue()!=(val)){
				newdeck[j] = deck[i];
				j++;
			}
		}
		deck = newdeck;
	}
	
	
	public void reshuffle(){
		deck = discard;
	}
	
	public class Card{
			public Image img;
			private ImageIcon back = new ImageIcon(getClass().getResource("/Images/b1fv.png"));
			
			String[] suits ={"club", "spade", "heart", "diamond"};
			String[] values={"ace", "king", "queen", "jack", "ten", "nine", "eight", "seven", "six", "five", "four", "three", "two"};
			
			private int si;
			private int vi;
			int id;
			
			private boolean flipped;
					
			public Card(String su, String va){
				si = find(suits,su);
				vi = find(values,va);
				id =(vi*4)+si;
				flipped = false;
				img = back.getImage();
			}
			
			public int find (String[] arr, String target){
				int ind = -1;
				for(int i=0; i<arr.length; i++){
					if(arr[i].equals(target)){
						ind = i;
						return ind;
					}
				}
				return ind;
			}
						
			public void flip(){
				flipped = true;
				img = images[id];
			}
			
			public boolean isFlipped(){
				return flipped;
			}
			
			public int getSuit(){
				return si;
			}
			public int getValue(){
				return vi;
			}
			
			public void draw(Graphics g, int locx, int locy){
				g.drawImage(this.img, locx, locy, 50, 67, null);
			}
	}
	
}


