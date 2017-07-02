//Design data structures for a generic deck of cards
public class Card{
	public enum Suit {
		CLUBS (1), SPADES (2), HEARTS (3), DIAMONDS(4);
		int value;
		private Suit(int v){
			value = v;
		}
	}
	private int value;
	private Suit suit;
	
	public Card(int value, Suit suit){
		this.value = value;
		this.suit = suit;
	}
	
	public int value(){
		return value;
	}
	public Suit suit(){
		return suit;
	}
	
}

public class BlackJackCard extends Card{
	public BlackJackCard(int value, Suit suit){
		super(value, suit);
	}
	
	//aces are 11, less than 10 is the same
	public int value(){
		int value = super.value();
		if (value == 1)
			return 11; //ace is 11 in blackjack
		if (value < 10)
			return value;
		return 10;
	}
	
	boolean isAce(){
		return super.value() == 1;
	}
}