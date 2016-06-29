package SlideViewer;

import javax.swing.JOptionPane;

public class PresentationEditor {

    public void addSlide(Slide slide, int order, Presentation pres) {
        pres.getSlides().insert(slide, order);
    }

    public void duplica(int page, Presentation pres) {
        pres.getSlides().insert(pres.getSlide(page), page);
    }

    public void remove(int page, Presentation pres) {
        pres.getSlides().remove(page);
    }

    public void move(int from, int to, Presentation pres) {
        pres.getSlides().insert(pres, to);
        pres.getSlides().remove(from);

    }

    public void changeTitle(Title title, int page, Presentation pres) {
        try {
            if (title.getText().length() > 57) {
                JOptionPane.showMessageDialog(null, "Digite um número de caracteres válido", "Erro de escrita", JOptionPane.ERROR_MESSAGE);
            } else {
                pres.getSlide(page).setTitle(title);
            }

        } catch (Exception e) {
            System.out.println("Erro ao mudar o titulo");
        }
    }

    public void addElement(String item, int page, Presentation pres, int level, int pagination) {
        int letras = 97, contSub = 1, cont = 1;
        ListItem newItem = new ListItem("", 0);

        //SE FOR ITEM
        if (level == 1) {
            //SE FOR NUMEROS
            if (pagination == 1) {
                item = "# " + item;
                Node<ListItem> temp = pres.getSlide(page).getElem().head;
                for(int i = 0;i < pres.getSlide(page).getElem().numElements;i++){
                    if(temp.element.getText().startsWith(".", 1)){
                        cont++;
                    }
                    temp = temp.getNext();
                }
                newItem = new ListItem(item, cont);
                newItem.adicionarTopico(newItem, cont, item);
                pres.getSlide(page).addElement(newItem);
            } 
            //SE FOR SIMBOLOS
            else if (pagination == 2) {
                item = "* " + item;
                newItem = new ListItem(item, cont);
                newItem.adicionarTopico(newItem, cont, item);
                pres.getSlide(page).addElement(newItem);
                cont++;
            }
        }
        //SE FOR SUB-ITEM
        else if (level == 2) {
            //SE FOR NUMEROS
            if (pagination == 1) {
                item = "## " + item;
                Node<ListItem> temp = pres.getSlide(page).getElem().tail;
                for(int i = 0;i < temp.getElement().getSubTopicos().numElements;i++){
                        if(temp.element.getText().startsWith(")", 9)){
                            letras++;
                        }      
                }
                newItem.adicionarTopico(newItem, letras, item);
                letras++;
                pres.getSlide(page).addElement(newItem.getLastSupTopico());
            } 
            //SE FOR SIMBOLOS
            else if (pagination == 2) {
                item = "** " + item;
                newItem.adicionarTopico(newItem, contSub, item);
                contSub++;
                pres.getSlide(page).addElement(newItem.getLastSupTopico());
            }
        }
    }
}
