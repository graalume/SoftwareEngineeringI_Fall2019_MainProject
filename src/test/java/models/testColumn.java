package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testColumn {
    @Test
    public void testMoveCard() {
        Column c = new Column();
       // c.customDeal(14, 3, 6, 9);

        Card card1 = new Card(14,Suit.Clubs);
        Card card2 = new Card(3,Suit.Clubs);
        Card card3 = new Card(6,Suit.Clubs);
        Card card4 = new Card(9,Suit.Clubs);

        c.addToCol(0,card1);
        c.addToCol(1,card2);
        c.addToCol(2,card3);
        c.addToCol(3,card4);

        c.remove(2);
        assertEquals(0, c.getColSize(2));
        c.move(0, 2);
        assertEquals(1, c.getColSize(2));
        assertEquals(0, c.getColSize(0));
    }
}