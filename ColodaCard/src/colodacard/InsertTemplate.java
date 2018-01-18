package colodacard;
import java.util.*;

public  abstract class InsertTemplate {
    protected int length;
    protected Object list; //колода карт (массив/лист ) Object - ?
    protected int index;
    
    //вставить карту: инструкция
    public int insertCard(Card newCard) {    
        doubleList();// Если список полон, увеличить его размер
        index = findIndex(newCard); //Найти позицию для вставки карты
        makeRoom(index); //Создать ячейку для новой карты
        addCard(newCard,index); //Добавить новую карту в список
        return returnIndex(); // Вернуть номер карты в списке        
    }
    
    protected void doubleList(){};
    
    protected abstract int findIndex(Card newCard);
    protected abstract void makeRoom(int index);
    protected abstract void addCard(Card newCard, int index);
    final protected int returnIndex(){
        return index;
    }; 

}