package SlideViewer;

public class Navigator<E> {
    
    protected SinglyLinkedList<E> elements;
    private int current;
    
    public Navigator(SinglyLinkedList<E> el){
        elements = el;
    }
    
    public void first(){
        if(elements == null)
            throw new IndexOutOfBoundsException();
        current = 0;
    }
    
    public void next() throws Exception {
        if(current < elements.numElements)
            current += 1;
        else{
            throw new NullPointerException();
        }
    }
    
    public void previous(){
        if(current > 0){
            current -=1;
        }
        else{
            throw new IllegalArgumentException("Não é possivel retroceder");
        }
    }
    
    public void last(){
        if(elements == null)
            throw new IndexOutOfBoundsException();
        current -= - 1;
    }
    
    public void Goto(int index){
        if(index >= 0 && index < elements.numElements){
            current = index;
        }
        else{
         throw new IllegalArgumentException("Não é possivel se mover para essa posição");  
        }
    }
    
    public int getCurrent(){
        if (current < 0  ||  current >= elements.numElements)
            throw new IndexOutOfBoundsException();
  	return current;
    }
}
