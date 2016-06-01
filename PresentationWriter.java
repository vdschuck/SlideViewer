package SlideViewer;

import java.io.*;

public class PresentationWriter {

    public PresentationWriter(String filename) throws Exception {

        try {
            File f = new File("Contatos.txt");
            FileWriter fr = new FileWriter(f, true); //true escrever sem sobrepor 
            PrintWriter out = new PrintWriter(fr, true);

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

    }    
   
}
