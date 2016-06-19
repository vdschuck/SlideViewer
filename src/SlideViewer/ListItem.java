package SlideViewer;

public class ListItem extends Element {
    private int order;
    int level;
    
    public ListItem(String e, int pos) {
       super(e);
       order = pos;
       adicionarTopico();
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }    
    
    public void adicionarTopico(){
        //Adicionado o valor em uma váriavel para facilitar o manuseio
        String line = super.getText();
        if(line.startsWith("#",0) && line.startsWith(" ",2)){
               char letras = (char)order;
               super.setText(letras + ")" + line.substring(3));
               setLevel(2);
        }
        //Adiciona um recuo para segundo nível.
        else if(line.startsWith(" ",2) && line.startsWith("*",0)){
                setLevel(2);
        }
        
        else if(line.startsWith("#")){
               super.setText(order + ". " + line.substring(1));
        }
    }
 
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        StringBuilder lv = new StringBuilder();
        for(int i = 1; i < level;i++){
            //=\t
            lv.append("        ");
        }
        lv.append(super.getText());
        
        super.setText(lv.toString());
    } 
}

