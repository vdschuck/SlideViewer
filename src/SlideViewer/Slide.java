package SlideViewer;

public class Slide<E> implements Printable{

    private Title title;
    private Style style;
    private SinglyLinkedList<ListItem> elem = new SinglyLinkedList();

    public  ListItem getElem(ListItem<E> element) {
        int i = elem.search(element);
        if(i > 0){
            return elem.get(i);
        }
        else{
            throw new NullPointerException();
        }
    }
    
    public SinglyLinkedList<ListItem> getElem(){
        return elem;
    }

    public void addElement(ListItem texto) {
        elem.insertLast(texto);
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public String print() {
        return "";
    }

}
