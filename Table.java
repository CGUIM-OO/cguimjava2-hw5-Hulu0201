import java.util.ArrayList;


public class Table {
	final int MAXPLAYER = 4;  //一張牌桌最多能坐4個人
	private Deck deck;   //存放所有的牌
	private Player[]  player;	//存放所有的玩家
	private Dealer dealer;	//存放一個莊家
	int[] pos_betArray = new int[MAXPLAYER];//存放每個玩家在一局下的注
	ArrayList<Card> player1Card=new ArrayList<Card>();
	ArrayList<Card> player2Card=new ArrayList<Card>();
	ArrayList<Card> player3Card=new ArrayList<Card>();
	ArrayList<Card> player4Card=new ArrayList<Card>();
	ArrayList<Card> dealerCard=new ArrayList<Card>();
	public Table(int nDeck){
		deck = new Deck(nDeck);	
		player =  new Player[MAXPLAYER];
	}
	public void set_player(int pos, Player p){
		 player[pos] = p;
	}
	public Player[] get_player(){
		return player;  
	}
	public void set_dealer(Dealer d){     
		dealer = d ;
		
	}
	public Card get_face_up_card_of_dealer(){
		return dealer.getOneRoundCard().get(1);//回傳dealer打開的那張牌
	}
	private void ask_each_player_about_bets(){
		for(int i=0;i<MAXPLAYER;i++){
		player[i].sayHello();
		pos_betArray[i] = player[i].makeBet();
		}
	}
	private void distribute_cards_to_dealer_and_players(){
		player1Card.add(deck.getOneCard(true));
		player1Card.add(deck.getOneCard(true));
		player[0].setOneRoundCard(player1Card);
		
		player2Card.add(deck.getOneCard(true));
		player2Card.add(deck.getOneCard(true));
		player[1].setOneRoundCard(player2Card);
		
		player3Card.add(deck.getOneCard(true));
		player3Card.add(deck.getOneCard(true));
		player[2].setOneRoundCard(player3Card);
	
		player4Card.add(deck.getOneCard(true));
		player4Card.add(deck.getOneCard(true));
		player[3].setOneRoundCard(player4Card);
		
		dealerCard.add(deck.getOneCard(false));//蓋著的牌
		dealerCard.add(deck.getOneCard(true));//打開的牌
		dealer.setOneRoundCard(dealerCard);
		System.out.println("Dealer's face up card is "); 
		dealerCard.get(1).printCard();//在畫面上印出莊家打開的牌
	}
	private void ask_each_player_about_hits(){
		
		boolean hit=false;
		do{
			if(player[0].getTotalValue() > 21){
					hit = false;
				}
			hit=player[0].hit_me(this); 
			if(hit){
				player1Card.add(deck.getOneCard(true));
				player[0].setOneRoundCard(player1Card);
				System.out.print("Hit! ");
				System.out.println(player[0].getName()+"'s Cards now:");
				for(Card c : player1Card){
					c.printCard();
				}
			}
			else{
				System.out.println(player[0].getName()+", Pass hit!");
				System.out.println(player[0].getName()+", Final Card:");
				for(Card c : player1Card){
					c.printCard();
				}
			}
		}while(hit);
		
		
		hit=false;
		do{
			if(player[1].getTotalValue() > 21){
					hit = false;
				}
			hit=player[1].hit_me(this);
			if(hit){
				player2Card.add(deck.getOneCard(true));
				player[1].setOneRoundCard(player2Card);
				System.out.print("Hit! ");
				System.out.println(player[1].getName()+"'s Cards now:");
				for(Card c : player2Card){
					c.printCard();
				}
			}
			else{
				System.out.println(player[1].getName()+", Pass hit!");
				System.out.println(player[1].getName()+", Final Card:");
				for(Card c : player2Card){
					c.printCard();
				}
			}
		}while(hit);
		
		hit=false;
		do{
			if(player[2].getTotalValue() > 21){
					hit = false;
				}
			hit=player[2].hit_me(this); 
			if(hit){
				player3Card.add(deck.getOneCard(true));
				player[2].setOneRoundCard(player3Card);
				System.out.print("Hit! ");
				System.out.println(player[2].getName()+"'s Cards now:");
				for(Card c : player3Card){
					c.printCard();
				}
			}
			else{
				System.out.println(player[2].getName()+", Pass hit!");
				System.out.println(player[2].getName()+", Final Card:");
				for(Card c : player3Card){
					c.printCard();
				}
			}
		}while(hit);
		
		
		hit=false;
		do{
			if(player[3].getTotalValue() > 21){
					hit = false;
				}
			hit=player[3].hit_me(this); 
			if(hit){
				player4Card.add(deck.getOneCard(true));
				player[3].setOneRoundCard(player4Card);
				System.out.print("Hit! ");
				System.out.println(player[3].getName()+"'s Cards now:");
				for(Card c : player4Card){
					c.printCard();
				}
			}
			else{
				System.out.println(player[3].getName()+", Pass hit!");
				System.out.println(player[3].getName()+", Final Card:");
				for(Card c : player4Card){
					c.printCard();
				}
			}
		}while(hit);
	//***如果爆了，請不要再問玩家是否要牌
	}
	
	private void ask_dealer_about_hits(){
		boolean hits =dealer.hit_me(this);
		if(hits == false){
			System.out.println("Dealer's hit is over!");
		}//詢問莊家是否要牌，完成後，印出"Dealer's hit is over!"
	}
	private void calculate_chips(){
		System.out.println("Dealer's card value is "
				+dealer.getTotalValue()+" , Cards:"); 
			for(Card c : dealerCard){
				c.printCard();
			}//印出莊家的點數和牌
		for(int i=0;i<MAXPLAYER;i++){
			System.out.println(player[i].getName()+
			" card value is "+player[i].getTotalValue()); 
			//針對每個玩家，先印出 玩家姓名+" card value is "+玩家總點數
		if(dealer.getTotalValue()>21 && player[i].getTotalValue()>21){
			System.out.println("chips have no change! "+
			"The Chips now is: "+player[i].getCurrentChips());//平手
		}else if(dealer.getTotalValue()<=21 && player[i].getTotalValue()>21){
			dealer.increaseChips(pos_betArray[i]);
			player[i].increaseChips(-pos_betArray[i]);	
			System.out.println("Loss "+pos_betArray[i]+" Chips,"+
			"the Chips now is:" +player[i].getCurrentChips());
		}else if(dealer.getTotalValue()>21 && player[i].getTotalValue()<=21){
			dealer.increaseChips(-pos_betArray[i]);
			player[i].increaseChips(pos_betArray[i]);
			System.out.println(player[i].getName()+"Get "+pos_betArray[i]+"Chips, "+
			"the Chips now is: "+player[i].getCurrentChips());
		}else if(dealer.getTotalValue()>player[i].getTotalValue() && dealer.getTotalValue()<=21){
			dealer.increaseChips(pos_betArray[i]);
			player[i].increaseChips(-pos_betArray[i]);	
			System.out.println("Loss "+pos_betArray[i]+" Chips, "+
			"the Chips now is : "+player[i].getCurrentChips());
		}else if(dealer.getTotalValue()<player[i].getTotalValue() && player[i].getTotalValue()<=21){
			dealer.increaseChips(-pos_betArray[i]);
			player[i].increaseChips(pos_betArray[i]);
			System.out.println(player[i].getName()+" Get "+pos_betArray[i]+"Chips,"+
			"the Chips now is: "+player[i].getCurrentChips());
		}else{
			System.out.println("chips have no change! "+
			"The Chips now is: "+player[i].getCurrentChips());
		}
		System.out.println(player[i].getName()+" has "+player[i].getCurrentChips()+" chips");
		}
	}
	public int[] get_players_bet(){
		return pos_betArray;//**
	}
	public void play(){ 
		ask_each_player_about_bets();
		distribute_cards_to_dealer_and_players();
		ask_each_player_about_hits();
		ask_dealer_about_hits();
		calculate_chips();
	}
}