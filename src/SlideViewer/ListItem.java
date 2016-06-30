package SlideViewer;

public class ListItem<E> extends Element {
    private int order;
    int level;
    SinglyLinkedList<ListItem> subTopicos;
    
    public ListItem(String e, int pos) {
       super(e);
       order = pos;
       level = 1;
       subTopicos = new SinglyLinkedList();
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }    

    public SinglyLinkedList<ListItem> getSubTopicos() {
        return subTopicos;
    }
    
    public ListItem getLastSupTopico(){
        return subTopicos.tail.getElement();
    }

    public void setSubTopicos(ListItem<E> subTop) {
        subTopicos.insertLast(subTop);
    }
    
    public void adicionarTopico(ListItem item,int pos,String line){
        
        if(line.startsWith("#",0) && line.startsWith(" ",2) || line.startsWith(" ",2) && line.startsWith("*",0)){ 
               String texto = adicionarSupTopico(line,pos);
               ListItem newSubTop = new ListItem(texto, pos);
               newSubTop.setLevel(item.getLevel() + 1);
               item.setSubTopicos(newSubTop);
        }
        else if(line.startsWith("#")){
               item.setText(order + ". " + line.substring(1));
        }
        else{
            item.setText(line);
        }
    }
 
    public String adicionarSupTopico(String line, int pos){
          String textoFinal = line;
          if(line.startsWith("#",0) && line.startsWith(" ",2)){ 
               char letras = (char)pos;
               textoFinal = letras + ")" + line.substring(3);
          }
          else if(line.startsWith(" ",2) && line.startsWith("*",0)){          
                textoFinal = line;
          }
          return textoFinal;
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