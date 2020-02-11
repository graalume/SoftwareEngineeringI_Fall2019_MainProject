package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class English extends Deck {
    @JsonCreator
    public English(){
        cards = new ArrayList<>();

        //add cards 2-15, where value 14 is an Ace (one of each suit)
        for(int i = 2; i < 15; i++){
            this.cards.add(new Card(i,Suit.Clubs));
            this.cards.add(new Card(i,Suit.Hearts));
            this.cards.add(new Card(i,Suit.Diamonds));
            this.cards.add(new Card(i,Suit.Spades));
        }
        shuffle();
    }
}