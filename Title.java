package SlideViewer;

public class Title extends Element{
    private boolean capital = false; 

    public Title(String e) {
        super(e);
        toUperTittle(e);
    }
    
    public void toUperTittle(String tittle){
        if(capital){
        }
        else{
            super.setText(tittle.toUpperCase());
        }
    }
    
    @Override
    public String print(){              
       return super.print();   
    }
}
