package SlideViewer;

import java.io.*;

public class PresentationWriter {

    public PresentationWriter(Presentation p) throws Exception {
        try {
            File f = new File("teste.txt");
            FileWriter fr = new FileWriter(f); //true escrever sem sobrepor 
            PrintWriter out = new PrintWriter(fr, true);
            gravaObjeto(f, p);

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }

    } 
    
    private static void gravaObjeto(File f, Presentation p) {
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(p);
            os.close();
        } catch (IOException e) {
            System.out.println("Erro ao gravar objeto. Erro: " + e);
        }
    }
   
}
