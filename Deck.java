import java.util.ArrayList;
import java.util.Random;

public class Deck{
	private ArrayList<Card> cards; 
	public  ArrayList<Card> usedCard;
	private ArrayList<Card> openCard; //�s�񦹰ƵP���Ҧ����}���P�A�~�P�ɭn���m 
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
		//����@�i�P�A�ק�즳method�A�[�JisOpened�ѼơA�M�w�o�X�h���P�O�}���٬O�\�_�Ӫ��C
		if(nUsed == 52){ 
			shuffle();
		} 
		Card newcard = cards.get(0);
		usedCard.add(newcard); //�o�X�h���P�����bArrayList usedCard
		nUsed +=1; //�o�F�X�i�P�H�����bprivate int nUsed;
		cards.remove(newcard);
		if(isOpened == true){  //�Y�O�}�۪��P�A�[�JopenCard�C
			openCard.add(newcard);
		}
		return newcard;
	}
	public void shuffle(){
		//��P���^��
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
		openCard = new ArrayList<Card>();//�Ҧ����}���P�A�~�P�ɭn���m 
	}

	public ArrayList<Card>  getOpenedCard(){
		return openCard;
		//�^�Ǧ��ƵP���Ҧ����}�L���P�A�N�YopenCard
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
