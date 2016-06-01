package SlideViewer;

public class Slide implements Printable {

    private int contEle = 0;
    private Title title;
    private Style style;
    //Começa com apenas 1 elememento/tópico
    private Element[] elem = new Element[1];

    public Element[] getElem() {
        return elem;
    }

    public Element getElem(int idx) {
        return elem[idx];
    }

    public void addElement(String texto) {
        try {
            //Add um elemento no espaço
            elem[contEle] = new Element(texto);
            contEle++;
        } //Caso seja necessário adicionar mais um elemento
        catch (ArrayIndexOutOfBoundsException e) {
            Element[] swap;
            //Copia os elementos atuais para swap. 
            swap = elem;
            //Criar um array com mais 1 espaço vazio;
            elem = new Element[++contEle];
            //Copia os elementos de swap para o novo array
            System.arraycopy(swap, 0, elem, 0, swap.length);
            //Adiciona o elemento desejado no novo espaço.
            elem[contEle - 1] = new Element(texto);
        }
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

    public String print() {
        return "";
    }

}
