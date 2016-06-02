package SlideViewer;

public class ListIthem extends Element {
    private boolean numbered;
    private int order;
    int level;
    
    public ListIthem(String e) {
       super(e);
    }
    
    public boolean isNumbered() {
        if(numbered){
            return true;
        }
        else{
            return false;
        }
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }    
    
    public void adicionarTopico(ListIthem item){
        String line = super.getText();
        if(line.startsWith("#",0) && line.startsWith(" ",2)){
               item.setLevel(2);
               char letras = (char)order;
               item.setText(letras + ")" + line.substring(3));
        }
        else if(line.startsWith(" ",2) && line.startsWith("*",0)){
                item.setLevel(2);
                item.setText(line);
        }
        
        else if(line.startsWith("#")){
               item.setText(order + ". " + line.substring(1));
        }
    }
 
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        StringBuilder lv = new StringBuilder();
        for(int i = 0; i <= level;i++){
            lv.append("\t");
        }
        super.setText(lv + super.getText());
    }
    
    
}

