package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

class Spanish extends Deck {
    @JsonCreator
    public Spanish(){
        cards = new ArrayList<>();

        //add cards 2-12
        for(int i = 2; i < 13; i++){
            this.cards.add(new Card(i,Suit.Clubs));
            this.cards.add(new Card(i,Suit.Coins));
            this.cards.add(new Card(i,Suit.Cups));
            this.cards.add(new Card(i,Suit.Swords));
        }

        this.cards.add(new Card(14,Suit.Clubs));
        this.cards.add(new Card(14,Suit.Coins));
        this.cards.add(new Card(14,Suit.Cups));
        this.cards.add(new Card(14,Suit.Swords));

        //add two jokers
        this.cards.add(new Card(15, Suit.Joker));
        this.cards.add(new Card(15, Suit.Joker));

        shuffle();
    }
}
