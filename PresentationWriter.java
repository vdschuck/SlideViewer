package SlideViewer;

import java.io.*;

public class PresentationWriter {

    public void save(String fileName, Presentation p) throws Exception {
        try {
            File f = new File(fileName);            
            FileWriter fr = new FileWriter(f); 
            PrintWriter out = new PrintWriter(fr, true);            
            
            out.println("presentation");
            out.println(styleWrite(out, p));
            out.println(footerWrite(out, p));
            out.println(slideWrite(out, p));
            out.println("\n /presentation");            

        } catch (Exception e) {
            System.out.println("PresentationWriter ERRO: " + e);
        }   
       
    } 
    
     public String styleWrite(PrintWriter out, Presentation p) {
        StringBuilder buffer = new StringBuilder();       
        
        buffer.append("\n styles");        
        for(int i=0; i<2; i++){
            buffer.append("\n style=");
            buffer.append(p.getStyle(i).getIdColor()).append(";");
            buffer.append(p.getStyle(i).getTextColorWrite()).append(";");
            buffer.append(p.getStyle(i).getBackgroundColorWrite()).append(";");
            buffer.append(p.getStyle(i).getTitleTextColorWrite()).append(";");
            buffer.append(p.getStyle(i).getTitleBackColorWrite()); 
        }        
        buffer.append("\n /styles");       
        
        return buffer.toString();
    }
     
     public String footerWrite(PrintWriter out, Presentation p){
         StringBuilder buffer = new StringBuilder();
         
         buffer.append("\n footer");
         buffer.append("\n left=").append(p.getFoo().getLeft());         
         buffer.append("\n center=").append(p.getFoo().getCenter());         
         buffer.append("\n right=").append(p.getFoo().getRight());        
         buffer.append("\n /footer");
         
         return buffer.toString();
     }
     
     public String slideWrite(PrintWriter out, Presentation p){
         StringBuilder buffer = new StringBuilder();
         
         buffer.append("\n slide");         
         buffer.append("\n title=").append(p.getSlide(1).getTitle());
         buffer.append("\n style=").append(p.getSlide(1).getStyle());
         buffer.append("\n /slide");
         buffer.append("\n content \n");
         buffer.append(p.getSlide(1).getElem());
         buffer.append("\n /content");
         
         return buffer.toString();
     
     }
   
}
