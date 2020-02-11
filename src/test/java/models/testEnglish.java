package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testEnglish {
    @Test
    public void testadd(){
        English deck = new English(); //new deck
        deck.add(new Card(2,Suit.Clubs));
        java.util.List<Card> cards = deck.getCards();    //get cards

        Card c = cards.get(cards.size() - 1);

        //check the right card was added
        assertEquals(Suit.Clubs,c.getSuit());
        assertEquals(2, c.getValue());
    }

    @Test
    public void testEnglish(){
        English deck = new English(); //new deck
        java.util.List<Card> cards = deck.getCards();    //get cards

        //check number of cards
        assertEquals(52, cards.size());
    }
}