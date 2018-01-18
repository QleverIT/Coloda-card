package colodacard;
import java.util.*;

public class CardNode {

    private Card data;
    private CardNode nextNode;

    public CardNode(Card data) {
        this.data = data;        
    }

    public Card getData() {        
        return data;
    }

    public CardNode getNext() {
        return nextNode;
    }

    public void setNext(CardNode node) {
        this.nextNode = node;
    }
    
    public boolean isEmpty(){
        if(data.getSuit()=="")return true;
        else return false;
    }    

}