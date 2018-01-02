	
public class Card {
		public Suit suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
		public int rank; //1~13
		String rank_s ="";
		String suit_s ="";
			Suit s1 = Suit.Club;
			/**
		 * @param s suit
		 * @param r rank
		 */
		enum  Suit {Club,Diamond,Heart,Spade};
		public Card(Suit s,int value){  //Constructor
			suit=s;
			rank=value;
		}	
		//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
		public void printCard(){
			//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
			
			switch (suit){
			case Club: 
				suit_s = "Club";
				break;
			case Diamond: 
				suit_s = "Diamond"; 
				break;
			case Heart: 
				suit_s = "Heart";
				break;
			case Spade:	
				suit_s = "Spade";
				break;
			}
			switch (rank){
			case 1: rank_s = "Ace"; break;
			case 2: rank_s = "2"; break;
			case 3: rank_s = "3"; break;
			case 4: rank_s = "4"; break;
			case 5: rank_s = "5"; break;
			case 6: rank_s = "6"; break;
			case 7: rank_s = "7"; break;
			case 8: rank_s = "8"; break;
			case 9:	rank_s = "9"; break;
			case 10: rank_s = "10"; break;
			case 11: rank_s = "11"; break;
			case 12: rank_s = "12"; break;
			case 13: rank_s	= "13"; break;
			}	
			System.out.println(this.suit+","+rank_s);
			
		}
		public Suit getSuit(){
			return suit;
		}
		public int getRank(){
			return rank;
		}
}
