package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testDeck {
    @Test
    public void testadd(){
        Deck deck = new Deck(); //new deck
        deck.add(new Card(2,Suit.Clubs));
        java.util.List<Card> cards = deck.getCards();    //get cards

        Card c = cards.get(cards.size() - 1);

        //check the right card was added
        assertEquals(Suit.Clubs,c.getSuit());
        assertEquals(2, c.getValue());
    }
}