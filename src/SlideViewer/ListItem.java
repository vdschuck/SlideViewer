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
        if(line.startsWith("#",1) || line.startsWith("*",1)){ 
               String texto = adicionarSupTopico(line,pos,item.getLevel() + 1);
               ListItem newSubTop = new ListItem(texto, pos);
               newSubTop.level++;
               item.setSubTopicos(newSubTop);
        }
        else if(line.startsWith("#")){
               item.setText(order + ". " + line.substring(1));
        }
        else{
            item.setText(line);
        }
    }
 
    public String adicionarSupTopico(String line, int pos, int nivel){
          StringBuilder textoFinal = new StringBuilder(); 
          textoFinal.append(setLevel(nivel));
          if(line.startsWith("#",1)){ 
               textoFinal.append((char)pos);
               textoFinal.append(")");
               textoFinal.append(line.substring(3));
          }
          else if(line.startsWith("*",1)){          
                textoFinal.append(line);
          }
          return textoFinal.toString();
    }
    
    public int getLevel() {
        return level;
    }

    public String setLevel(int level) {
        StringBuilder lv = new StringBuilder();
        for(int i = 1; i < level;i++){
            //=\t
            lv.append("        ");
        }
        level++;
        return lv.toString();
    } 
}