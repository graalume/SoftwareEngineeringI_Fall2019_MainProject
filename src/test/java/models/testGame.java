package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testGame {
    @Test
    public void testMoveCard() {
        //  java.util.List<Card> custom = deck.getCards();

        Game g = new Game();
        g.customDeal(14, 3, 6, 9);
        g.remove(2);
        assertEquals(0, g.cols.getColSize(2));
        g.move(0, 2);
        assertEquals(1, g.cols.getColSize(2));
        assertEquals(0, g.cols.getColSize(0));
    }
}