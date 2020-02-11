package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
    //make a global variable that counts everytime remove has been called
public class Game{

    public Deck deck;

    public Column cols;

    public Stat stats = new Stat();

    public Game(){
        cols = new Column();
    }

    public void dealFour() {
        // check if deck is empty
        for (int i = 0; i < 4; i++) {
            // remove the top card from the deck and add it to a column; repeat for each of the four columns
            if(!deck.isEmpty()) {
                cols.addToCol(i, deck.get_top_card());
                deck.remove();
            }
        }
        //check for game over
        isWin();
        isLose();
    }

    public void customDeal(int c1, int c2, int c3, int c4){
      //  java.util.List<Card> custom = deck.getCards();
        Card card1 = new Card(c1,Suit.Clubs);
        Card card2 = new Card(c2,Suit.Clubs);
        Card card3 = new Card(c3,Suit.Clubs);
        Card card4 = new Card(c4,Suit.Clubs);

        cols.addToCol(0,card1);

        cols.addToCol(1,card2);

        cols.addToCol(2,card3);

        cols.addToCol(3,card4);
    }

    public void remove(int columnNumber){
        if(cols.remove(columnNumber) == true)
            stats.setScore(stats.score + 1);
    }

    public void move(int columnFrom, int columnTo) {

        // remove the top card from the columnFrom column, add it to the columnTo column
        if(!cols.columnHasCards(columnTo)) {

            if (cols.getTopCard(columnFrom).value == 14){
                stats.setnoMove(false);
                cols.addToCol(columnTo, cols.getTopCard(columnFrom));
                cols.removeCardFromCol(columnFrom);
            }
            else{
                stats.setnoMove(true);
            }
        }else{
			    stats.setnoMove(true);
          
        }
    }

  /*  private boolean move_remove(int i){
        for(int j=0; j<4; j++){
            if(i != j){
                if (cols.getTopCard(j).getValue() > cols.getTopCard(i).getValue()){
                    if (cols.getTopCard(j).getSuit() == cols.getTopCard(i).getSuit()){
                        return true;
                    }
                    else if (cols.getTopCard(j).getValue() == 14){
                        if (cols.getTopCard(j).getSuit() == Suit.Joker) {
                            remove(j);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }*/

    //check if a move exists
    private boolean move_exists(){
        //check if deck empty
        if(deck.isEmpty()){
            //loop over all columns
            for(int i=0; i<4; i++){
                //check if a card can be moved
                if(cols.getColSize(i) == 0 && cols.topAce() == true ){
                    return true;
                }
                //check if a card can be removed
                if(cols.can_remove(i) == true){
                    return true;
                }
            }
            return false;
        }
        else{
            return true;
        }
    }

    private void deckWinLoop() {
        stats.setWin(true);
        for(int i=0; i<4; i++) {
            //check if only one card in column
            if (cols.getColSize(i) != 1) {
                stats.setWin(false);
                return;
            }
            //check that card is Ace
            else if (cols.getTopCard(i).getValue() != 14) {
                stats.setWin(false);
                return;
            }
        }
    }

    //check for a win
private void isWin(){
	//check if deck is empty
	if(deck.isEmpty()){
		//loop over columns
		deckWinLoop();
	}else{
		stats.setWin(false);
	}
}

    //check for a lose
    private void isLose() {
        //if move exists, no lose
        if(move_exists() || stats.getWin() == true ){
            stats.setLose(false);
            return;
        }
        else{
            stats.setLose(true);
            return;
        }
    }

}

