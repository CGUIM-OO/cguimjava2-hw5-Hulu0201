import java.util.ArrayList;
import java.util.Random;

public class Deck{
	private ArrayList<Card> cards; 
	public  ArrayList<Card> usedCard;
	private ArrayList<Card> openCard; //存放此副牌中所有打開的牌，洗牌時要重置 
	public  int nUsed; 
	public Deck(int nDeck){   
		cards = new ArrayList<Card>();
		for(int i=0;i<nDeck ;i++){			
			for (Card.Suit s : Card.Suit.values()){		
				for(int k=1;k<=13;k++){		
					Card card = new Card(s,k); 
					cards.add(card);		
				}
			}
		}
		shuffle();
	}	
	
	public void printDeck(){
		for(int i=0;i < cards.size();i++){
			Card printdeck = cards.get(i);
			printdeck.printCard();
			System.out.println(cards.size()); 
		}
	}
	public Card getOneCard(boolean isOpened){ 
		//拿到一張牌，修改原有method，加入isOpened參數，決定發出去的牌是開著還是蓋起來的。
		if(nUsed == 52){ 
			shuffle();
		} 
		Card newcard = cards.get(0);
		usedCard.add(newcard); //發出去的牌紀錄在ArrayList usedCard
		nUsed +=1; //發了幾張牌？紀錄在private int nUsed;
		cards.remove(newcard);
		if(isOpened == true){  //若是開著的牌，加入openCard。
			openCard.add(newcard);
		}
		return newcard;
	}
	public void shuffle(){
		//把牌收回來
		 for(int j=0;j<nUsed;j++){
			cards.add(j,usedCard.get(j));
		}
		Random random = new Random();
		for(int i=0;i<cards.size();i++){
			int k = random.nextInt(cards.size());
			Card temp = cards.get(k);
			cards.set(k,cards.get(i));
			cards.set(i, temp);
		}
		nUsed = 0;		 
		usedCard = new ArrayList<Card>();
		openCard = new ArrayList<Card>();//所有打開的牌，洗牌時要重置 
	}

	public ArrayList<Card>  getOpenedCard(){
		return openCard;
		//回傳此副牌中所有打開過的牌，意即openCard
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
