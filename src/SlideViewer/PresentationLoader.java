package SlideViewer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class PresentationLoader {    
    
    public Presentation loader(String filename) throws Exception{
        
        //Leitura do arquivo
        FileReader fr = new FileReader(filename);
        BufferedReader in;
        in = new BufferedReader(fr);
        String line;
        
        //Quantidade de slides
        Slide slides[] = new Slide[4];
        //Slides que está criando
        int nSlide = 0;
        //Variavel que será montada e retornada pelo método
        Presentation p = null;
        
        try {
            while ((line = in.readLine()) != null) {
                if("".equals(line)) {
                } // pula linha em branco
                else if("/presentation".equals(line)){
                   break;                 
                }
                else if(line.contains("presentation")){
                    p = new Presentation(2,slides);
                }
                //Montando style
                else if("styles".equals(line)){
                    readStyle(in,p);
                }             
                //Montando footer
                else if("footer".equals(line)){
                    readFooter(in,p);
                }
                //Montando slide
                else if("slide".equals(line)){
                   if(nSlide < slides.length){
                    readSlide(in,p,nSlide);
                    nSlide++;
                   }
                }
            
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo \"" + filename + "\" não existe.");
        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo " + filename + "." + e);
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                System.out.println("Presentation Loader ERRO: " + e);
            }
        }
        return p;
    }
    
    public void readStyle(BufferedReader in,Presentation p){
        String lines;
        try{
            while ((lines = in.readLine()) != null){
        
                if("/styles".equals(lines)){
                    break;
                }
                if(lines.startsWith("style=")){
                    lines = lines.substring(6);
                    String[] cores = lines.split(";");
                    Style s = new Style(Integer.parseInt(cores[0]),cores[1], cores[2],cores[3],cores[4]); 
                    p.addStyle(s);
                }
            }
            } catch (IOException e) {
                System.out.println("Presentation Loader ERRO: " + e);
            } 
    }

    public void readFooter(BufferedReader in,Presentation p){
        String lines;
        Footer f = new Footer("","","");
        
        try{
            while ((lines = in.readLine()) != null){
        
                if("/footer".equals(lines)){
                    break;
                }                
                if(lines.startsWith("left=")){
                  f.setLeft(lines.substring(5));
                }
                else if(lines.startsWith("center=")){
                  f.setCenter(lines.substring(7));
                }
                else if(lines.startsWith("right=")){
                  f.setRight(lines.substring(6));
                }
            }
        p.setFoo(f);
        } catch (IOException e) {
                System.out.println("Presentation Loader ERRO: " + e);
        }
    }
    
    public void readSlide(BufferedReader in,Presentation p,int nslide){
        String lines;
        Slide s = new Slide();
        try{
            while ((lines = in.readLine()) != null){
        
                if("/slide".equals(lines)){
                    break;
                }         
                else if(lines.startsWith("title=")){
                    //Retirado o title=
                    Title t = new Title(lines.substring(6));
                    s.setTitle(t);
                }
                else if(lines.startsWith("0") || lines.startsWith("1")){
                    /*Seta o Style de s, pegando os style armazenados no presentation 0 ou 1*/
                    s.setStyle(p.getStyle(Integer.parseInt(lines.substring(7))-1));
                }
                else if("content".equals(lines)){
                    readContend(in,s);
                }
            }
        p.setSlide(s, nslide);
        } catch (IOException e) {
                System.out.println("Presentation Loader ERRO: " + e);
        }
    }
    
    public void readContend(BufferedReader in,Slide s){
        String lines;
        int cont =1;
        //Numero que será usadado pra imprimir as letras, 97 é o ASCII de a.
        int let = 97;
        try{
            while ((lines = in.readLine()) != null){
                if("/content".equals(lines)){
                    break;
                }
                //Quando há letras
                else if(lines.startsWith("#",1)){
                    ListIthem ls = new ListIthem(lines);
                    ls.setOrder(let);
                    ls.adicionarTopico(ls);
                    s.addElement(ls.getText());
                    let++;
                }
                //Apenas numeração
                else{
                    ListIthem ls = new ListIthem(lines);
                    ls.setOrder(cont);
                    ls.adicionarTopico(ls);
                    s.addElement(ls.getText());
                    cont++;
                }

            }
        } catch (IOException e) {
                System.out.println("Presentation Loader ERRO: " + e);
        }
    }
}