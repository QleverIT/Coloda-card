package colodacard;
import java.util.*;

/**
 * 
 */
public class Card implements Comparable<Card> {

    private String suit; //масть карты: "spades", "clubs", "dimonds", "hearts"
    private String faceValue; // значение карты: от "2" до "ace"
    private int cardValue; //для сортировки, вес карты в рамках 1-ой масти (от 2 до 14)
    private int cardSuit; //для сортировки, вес масти карты (от 1 до 4) 
    
        public Card(String suit, String faceValue) {
            this.suit = suit;
            this.faceValue = faceValue;
            switch(faceValue){
                    case "2": cardValue = 2; break;
                    case "3": cardValue = 3; break;
                    case "4": cardValue = 4; break;
                    case "5": cardValue = 5; break;
                    case "6": cardValue = 6; break;
                    case "7": cardValue = 7; break;
                    case "8": cardValue = 8; break;
                    case "9": cardValue = 9; break;
                    case "10": cardValue = 10; break;
                    case "jack": cardValue = 11; break;
                    case "queen": cardValue = 12; break;
                    case "king": cardValue = 13; break;
                    case "ace": cardValue = 14; break;
            }
            switch (suit) {
                case "spades": cardSuit = 1; break;
                case "clubs": cardSuit = 2; break;
                case "dimonds": cardSuit = 3; break;
                case "hearts": cardSuit = 4; break;
            }
        }

    public String getSuit() {        
        return suit;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public int getCardValue() {        
        return cardValue;
    }
    
    @Override
    public String toString(){
        return faceValue+" of "+suit;
    }

    @Override
    public int compareTo(Card o) {
        if(o.cardSuit == cardSuit)return o.cardValue-cardValue; // cardValue-o.cardValue ;
        return o.cardSuit-cardSuit;//cardSuit-o.cardSuit;
    }
}