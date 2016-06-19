package SlideViewer;


public class PresentationEditor {
    
    public void addSlide(Slide slide, int order, Presentation pres){
       pres.getSlides().insert(slide, order);       
    }
    
    public void duplica(int page, Presentation pres){
        pres.getSlides().insert(pres.getSlide(page), page);    
    }
    
    public void remove(int page, Presentation pres){
        pres.getSlides().remove(page);
    }
    
    public void move(int from, int to, Presentation pres){
      pres.getSlides().insert(pres, to);
      pres.getSlides().remove(from);
       
    }
    
    public void changeTitle(Title title, int page, Presentation pres){
        try{
            pres.getSlide(page).setTitle(title);
        }
        catch(Exception e){
            System.out.println("Erro ao mudar o titulo");
        }
    }    
    
    public void addElement(Element item, int parentItem, int page, Presentation pres){
        try{
            pres.getSlide(page).addElement(item.getText());
        }
        catch(Exception e){
            System.out.println("Erro ao adicionar tópico");
        }
    }
}
