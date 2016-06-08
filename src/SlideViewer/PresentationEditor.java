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
    
    public void move(int form, int to, Presentation pres){
       
    }
    
    public void changeTitle(Title title, int page, Presentation pres){
        pres.getSlide(page).setTitle(title);
    }    
    
    public void addElement(Element item, int parentItem, int page, Presentation pres){
        pres.getSlide(page).addElement(item);
    }
}
