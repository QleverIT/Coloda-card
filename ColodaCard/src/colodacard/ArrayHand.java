package colodacard;


import java.util.*;

/**
 * 
 */
public class ArrayHand extends InsertTemplate implements CardList {

    private Card[] list;
    private int length;

    public ArrayHand(int length) {
        this.length = length;       
        list = new Card[length];//? 0       
        for(int i = 0; i<length;i++){
            list[i]=new Card("","");
        }
        
    }

    @Override
    public Card getFirst() {
        if(length>0) return list[0];
        return null;
    }

    @Override
    public Card getLast() {
         if(length>0) 
             for(int i = length-1; i>=0;i--){
                 if(list[i].getSuit()!="") return list[i];
             }
         return null;
    }

    @Override
    public Card getNth(int index) {
        if( 0 <= index && index < length) return list[index];
        return null;
    }

    @Override
    public int getSize() {
        return findIndex(getLast());//return index get last
    }

    @Override
    public void printList() {
        for(Card c:list)
           if(c.getFaceValue()!=""&&c.getSuit()!="") System.out.print(" | "+c+" | ");
        System.out.println("");
    }

    @Override
    protected void doubleList(){        
        boolean t = false;   
        for(int i = 0; i < length;i++)
           if(list[i].getSuit()=="") t = true;
        if (!t) {
            length++;
            Card temp[] = new Card[length];            
            for (int i = 0; i < length - 1; i++) {
                if(list[i]!=null)temp[i] = list[i];
            }
            list = temp.clone();//*
            list[length-1]=new Card("","");
        }
    };
    
    @Override
    protected int findIndex(Card newCard) {
       int index = -1; //индес карты(самый большой), которой => newCard      
       
       for(int i = 0; i< length; i++){     
           if(list[i].getSuit()!=""&&newCard.compareTo(list[i])<=0) index++;
       }
       if(index == -1) return 0;
       return index+1;
    }

    @Override
    protected void makeRoom(int index) {
        for(int i = length-1; i!=index; i--)
            list[i]=list[i-1];        
    }

    @Override
    protected void addCard(Card newCard, int index) {
        list[index]=newCard;
    }

}