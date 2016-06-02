package SlideViewer;

import java.io.*;

public class PresentationWriter {

    public void save(String fileName, Presentation p) throws Exception {
        try {
            File f = new File("teste.txt");            
            FileWriter fr = new FileWriter(f); //true escrever sem sobrepor 
            PrintWriter out = new PrintWriter(fr, true);
            
            out.print("presentation");
            out.println("\n");
            out.println("styles");
            out.println("style=" + p.getStyle(0).getTextColorWrite()+ ";" + p.getStyle(0).getBackgroundColorWrite() + ";" + p.getStyle(0).getTitleTextColorWrite() + ";" + p.getStyle(0).getTitleBackColorWrite() );
            out.println("style=");
            out.println("/styles");
            out.println("\n");
            

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

    }     
   
}
