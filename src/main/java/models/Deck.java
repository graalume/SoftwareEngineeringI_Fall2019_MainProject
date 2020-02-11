package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Deck {
    public java.util.List<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
    }

    public java.util.List<Card> getCards() {
        return this.cards;
    }

    public void setCards(java.util.List<Card> newCards){
        this.cards = newCards;
    }

    @JsonIgnore
    public void add(Card newCard){
        this.cards.add(newCard);
    }

    @JsonIgnore
    public void remove(){
        this.cards.remove(cards.size() - 1);
    }

    @JsonIgnore
    public Card get_top_card(){
        return this.cards.get(this.cards.size() - 1);
    }

    @JsonIgnore
    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    @JsonIgnore
    public boolean isEmpty(){
        return this.cards.isEmpty();
    }
}

