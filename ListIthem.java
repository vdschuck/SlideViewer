package SlideViewer;

public class ListIthem extends Element {
    private boolean numbered;
    private int order;

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
    
    public String marcadores(){
        String line = super.getText();
            if(line.startsWith("#",0) && line.startsWith(" ",2)){
               char letras = (char)order;
               line = "\t " + letras + ") " + line.substring(3);
            }
            else if(line.startsWith(" ",2) && line.startsWith("*",0)){
                line = "\t " + line;
            }
            else if(line.startsWith("#")){
               line = order + ". " + line.substring(1);
            }
            //Usar a notação ASCCI para obter as lettras, sendo que 65 é "A", podemos ir adicionando de acordo com o order.


            return line;
        }
}

