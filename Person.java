import java.util.ArrayList;
		
public abstract class Person {
	public ArrayList<Card> oneRoundCard; //此牌局的卡
	public String name; //玩(莊)家姓名 
	public int chips;  //玩(莊)家有的籌碼
	public int bet;  //玩(莊)家此局下注的籌碼
	public void setOneRoundCard(ArrayList<Card> cards){
		oneRoundCard=cards;
	}
	public ArrayList<Card> getOneRoundCard(){
		return oneRoundCard;
	}
	public abstract boolean hit_me(Table table);
	public  String getName(){
		return name;
	}
	public void increaseChips (int diff){
		bet = chips + diff;//*玩家籌碼變動，setter
	}
	public int makeBet(){
		if(chips<0){//注意：要檢查是否還有錢，沒錢了就不能再繼續下注
			return bet =0;
		}
		return bet = chips/2 ;//下注，回傳預計下注的籌碼
	}
	public int getCurrentChips(){
		return bet;
	}
	public int getTotalValue() {
		int Ace_count = 0;
		int total_value = 0;
		for (Card c : oneRoundCard) {
			if (Ace_count == 0 && c.getRank() == 1) {
				Ace_count = 1;
				continue;
			} else {
				if (c.getRank() == 11 || c.getRank() == 12 || c.getRank() == 13)
					total_value += 10;
				else
					total_value += c.getRank();
			}
		}
		if (Ace_count != 0) {
			if (total_value < 11) {
				total_value += 11;
			} else {
				total_value += 1;
			}

		}
		return total_value;
	}
	public boolean hasAce() {
		boolean hasAce= false;
		for (Card c : oneRoundCard) {
			if (c.getRank() == 1) {
				hasAce = true;
			} 
		}
		return hasAce;
	}
	public void sayHello(){
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
		}
	public void printAllCard(){
		for(Card c : oneRoundCard){
			c.printCard();
		}
	}
}
