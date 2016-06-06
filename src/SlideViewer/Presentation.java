package SlideViewer;

public class Presentation {

    private Style style[];
    private int cont;
    private Footer foo;
    private Slide[] slide;

    //Quantidades de Styles que o presentation pode ter.
    public Presentation(int cont, Slide[] s) {
        style = new Style[cont];
        this.slide = s;
    }

    public void addStyle(Style st) {
        if (st != null) {
            if (cont < style.length) {
                style[cont] = st;
                cont++;
            }
        }
    }

    public Slide[] getSlides() {
        return slide;
    }

    public void setSlides(Slide[] slide) {
        this.slide = slide;
    }

    public Slide getSlide(int idx) {
        return this.slide[idx];
    }

    public void setSlide(Slide s, int idx) {
        this.slide[idx] = s;
    }

    public Style getStyle(int index) {
        return style[index];
    }

    public Footer getFoo() {
        return foo;
    }

    public void setFoo(Footer foo) {
        this.foo = foo;
    }
}
