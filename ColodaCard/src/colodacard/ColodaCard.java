/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colodacard;

/**
 *
 * @author Yulay
 */
public class ColodaCard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Card a = new Card("hearts","8");
        Card b = new Card("hearts","ace");
        Card c = new Card("clubs","2");
        Card y = new Card("clubs","10");
        ArrayHand ar = new ArrayHand(4);      
        ar.insertCard(a);
        ar.insertCard(c);
        ar.insertCard(b);
        System.out.println(ar.getFirst() +"..."+ar.getLast());        //-
        System.out.println("size = "+ar.getSize());
        System.out.println("get card ( index = 0 ) ::: "+ar.getNth(0));
        ar.printList();
        System.out.println("=========================================");
        LinkedHand lh = new LinkedHand();
        lh.insertCard(c);
        lh.insertCard(b);
        lh.insertCard(a);
        lh.insertCard(y);
        System.out.println(lh.getFirst() +"..."+lh.getLast());        //-
        System.out.println("size = "+lh.getSize());
        System.out.println("get card ( index = 2 ) ::: "+lh.getNth(2));
        lh.printList();
    }
    
}
