package SlideViewer;

public class Presentation<E> {

    private SinglyLinkedList<Style> style;
    private Footer foo;
    private SinglyLinkedList<Slide> slide;

    //Quantidades de Styles que o presentation pode ter.
    public Presentation() {
        style = new SinglyLinkedList();
        slide = new SinglyLinkedList();
    }

    public void addStyle(Style st) {
        if (st != null) {
            style.insertLast(st);
        }
    }

    public SinglyLinkedList getSlides() {
        return slide;
    }

    public void setSlides(Slide slide) {
        this.slide.insertLast(slide);
    }

    public Slide getSlide(int idx) {
        return slide.get(idx);
    }

    public void setSlide(Slide s, int idx) {
        this.slide.insert(s, idx);
    }

    public Style getStyle(int index) {      
        return style.get(index);
    }

    public Footer getFoo() {
        return foo;
    }

    public void setFoo(Footer foo) {
        this.foo = foo;
    }
}
