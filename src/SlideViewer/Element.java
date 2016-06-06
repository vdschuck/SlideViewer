package SlideViewer;

public class Element implements Printable {

    private String text;

    public Element(String e) {
        this.text = e;
    }

    public void setText(String n) {
        this.text = n;
    }

    public String getText() {
        return text;
    }

    public String print() {
        return text;
    }
}
