package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Column {
    //public final int place;
    public java.util.List<java.util.List<Card>> cols;

    public java.util.List<java.util.List<Card>> getCol(){
        return this.cols;
    }

    public boolean jokerFound = false;
    public int jokerPlace;

    public void setCols(java.util.List<java.util.List<Card>> cols){
        this.cols = cols;
    }

    @JsonCreator
    public Column(){
        cols = new ArrayList<>(4);
        for(int i = 0; i < 4; i++)
            cols.add(new ArrayList<Card>());

    }

    @JsonIgnore
    public Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size() - 1);
    }

    @JsonIgnore
    public int getColSize(int columnNumber) {
        return this.cols.get(columnNumber).size();
    }

    @JsonIgnore
    public boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
        if (this.cols.get(columnNumber).isEmpty()){
            return false;
        }
        return true;
    }

    @JsonIgnore
    public void addToCol(int columnNumber, Card card){
        cols.get(columnNumber).add(card);
    }

    @JsonIgnore
    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        if(!this.columnHasCards(columnTo)) {
            //noMove=false;
            this.addToCol(columnTo, this.getTopCard(columnFrom));
            removeCardFromCol(columnFrom);
        }else{
            //noMove=true;
        }
    }

   @JsonIgnore
    public void removeCardFromCol(int colFrom) {
        cols.get(colFrom).remove(cols.get(colFrom).size()-1);
       // this.getCol(colFrom).remove(this.getCol(colFrom).size()-1);
    }

    @JsonIgnore
    public boolean can_remove(int i) {
        if (this.columnHasCards(i)) {
            for (int j = 0; j < 4; j++) {
                if (i != j && this.columnHasCards(j)) {
                    if (this.getTopCard(j).getValue() > this.getTopCard(i).getValue()) {
                        if (this.getTopCard(j).getSuit() == this.getTopCard(i).getSuit()) {
                            return true;
                        } else if (this.getTopCard(j).getValue() == 15) {
                            if (this.getTopCard(j).getSuit() == Suit.Joker) {
                                jokerFound = true;
                                jokerPlace = j;
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    @JsonIgnore
    public boolean topAce() {
        int i = 0;
            for (i = 0; i < 4; i++) {
                if (this.columnHasCards(i)) {
                  if (this.getTopCard(i).getValue() == 14) {
                    return true;
                  }
                }
            return false;
          }
        return false;
     }

    @JsonIgnore
    public boolean remove(int columnNumber) {
        if(can_remove(columnNumber) == true){
        //    Card c = this.getTopCard(columnNumber);
         //   remove(columnNumber);

            this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);

            if(jokerFound == true){
                //   remove(jokerPlace);
                this.cols.get(jokerPlace).remove(this.cols.get(jokerPlace).size() - 1);
                return true;
            }
            return true;
        }

      /*  if(this.columnHasCards(columnNumber)) {
            Card c = this.getTopCard(columnNumber);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (this.columnHasCards(i)) {
                        Card compare = this.getTopCard(i);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                        else if (compare.getSuit(i) == Suit.Joker){
                            if (compare.getValue(i) == 14) {
                                remove(i);
                                return true;
                            }
                        }
                    }
                }
            }
            if (removeCard) {
                this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);
                return true;
            }
        }*/
        return false;
    }
}
