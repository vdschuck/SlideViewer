package SlideViewer;

public class Navigator<E> {
    
    protected SinglyLinkedList<E> elements;
    int numElements;
    private int current;
    
    public Navigator(SinglyLinkedList<E> el){
        elements = el;
        numElements = el.numElements;
    }
    
    public void first(){
        if(elements == null)
            throw new IndexOutOfBoundsException();              
    }
    
    public void next() throws Exception {
        if(current < numElements){
            current += 1;
        }
        else{
            throw new IllegalArgumentException("Não tem mais slides! "); 
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
        current = numElements;
    }
    
    public void Goto(int index){
        if(index >= 0 && index < numElements){
            current = index;
        }
        else{
         throw new IllegalArgumentException("Não é possivel se mover para essa posição");  
        }
    }
    
    public int getCurrent(){
        if (current < 0  ||  current >= numElements)
            throw new IndexOutOfBoundsException();
  	return current;
    }
}
