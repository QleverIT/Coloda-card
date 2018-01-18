package colodacard;
import java.util.*;

public interface CardList {

    public Card getFirst();
    public Card getLast();
    public Card getNth(int index);
    public int getSize();
    public void printList();

}