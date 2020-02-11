package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testSpanish {
    @Test
    public void testadd(){
        Spanish deck = new Spanish(); //new deck
        deck.add(new Card(2,Suit.Coins));
        java.util.List<Card> cards = deck.getCards();    //get cards

        Card c = cards.get(cards.size() - 1);

        //check the right card was added
        assertEquals(Suit.Coins,c.getSuit());
        assertEquals(2, c.getValue());
    }

    @Test
    public void testSpanish(){
        Spanish deck = new Spanish(); //new deck
        java.util.List<Card> cards = deck.getCards();    //get cards

        //check number of cards
        assertEquals(50, cards.size());
    }
}
