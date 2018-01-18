package colodacard;
import java.util.*;

/**
 * 
 */
public class LinkedHand extends InsertTemplate implements CardList {
    
    private CardNode list;//карта(1-ая) + ссылка на следующую
    private int length;
    
    public LinkedHand() { 
        list = new CardNode(new Card("",""));
        list.setNext(list);
    }

    
    @Override
    public Card getFirst() {
        return list.getData();
    }

    @Override
    public Card getLast() {
        CardNode card = list;
        while(!card.getNext().isEmpty())
            card = card.getNext();
        return card.getData();
    }

    @Override
    public Card getNth(int index) {
       if(list.isEmpty()||this.getSize()<=index) return null;
       
       CardNode card = list;
        int count = 0;
        while (!card.getNext().isEmpty() && count != index) {
            card = card.getNext();
            count++;
        }
        return card.getData();
    }

    @Override
    public int getSize() {
        int count = 0;
        if (!list.isEmpty()) {
            count++;
            CardNode card = list;
            while (!card.getNext().isEmpty()) {
                card = card.getNext();
                count++;
            }
        }
        return count;
    }

    @Override
    public void printList() {
        CardNode card = list;
            while (!card.isEmpty()) {                
                System.out.print(" | "+card.getData()+" | ");
                card = card.getNext();                
            }
    }


    @Override
    protected int findIndex(Card newCard) {
        int count = 0;
        if(!list.isEmpty()){            
            CardNode card = list;
            if(card.getData().compareTo(newCard)<0) return 0;
            count++;
            while (!card.getNext().isEmpty() &&(card.getData().compareTo(newCard)<0)) {                
                card = card.getNext();
                count++;
            }
        }
        return count;
    }

    @Override
    protected void makeRoom(int index) {
        
        if(!list.isEmpty() && 0<index){             
            CardNode card = list;
            int count = 0;
            while (card.getNext().isEmpty() && count != index-1) {                
                card = card.getNext();
                count++;
            }
            CardNode temp = new CardNode(new Card("",""));
            temp.setNext(card.getNext());
            card.setNext(temp);
        } else if (index == 0) {
            CardNode newCard = list;
            newCard.setNext(list);
            list = newCard;
        } else {
            list = new CardNode(new Card("",""));
        }            
    }

    @Override
    protected void addCard(Card newCard, int index) {
        CardNode card = list;
        CardNode temp = new CardNode(newCard);//*
        int count = 0;
        if (!card.isEmpty()) {
            while (!card.getNext().isEmpty() && count != index - 1) {
                card = card.getNext();
                count++;
            }                
        temp.setNext(card.getNext().getNext());
        card.setNext(temp);
        }else{ 
            list = temp;
            list.setNext(new CardNode(new Card("","")));
        }
    }
    


}