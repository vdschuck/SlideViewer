package SlideViewer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SlideDesigner {

    public String drawSlide(Slide slide, int page, Footer footer) {
        StringBuilder drawAll = new StringBuilder();
        String bordaSup = "---------------------------------------------------------------------------------";
        String corLetra = slide.getStyle().getTextColor();
        String corFundo = slide.getStyle().getBackgroundColor();

        drawAll.append("\n");
        drawAll.append(corFundo);
        drawAll.append(bordaSup);
      
        drawAll.append(drawTitle(slide.getTitle(), slide.getStyle()));

        drawAll.append(corFundo);
        drawAll.append(corLetra);

        drawAll.append(drawBody(slide));
        drawAll.append(drawFooter(footer, page));

        drawAll.append(corLetra);
        drawAll.append(corFundo);

        //Reinicia as corres
        drawAll.append("\u001b[0m");

        drawAll.append("\n");
        drawAll.append(corFundo);
        drawAll.append(bordaSup);

        return drawAll.toString();
    }

    private String drawTitle(Title title, Style s) {
        StringBuilder t = new StringBuilder();

        String bordaLat = "|";
        //Separadores
        t.append("\n");

        //Style e o texto
        t.append(s.getTitleBackColor());
        t.append(s.getTitleTextColor());

        t.append(bordaLat);
        t.append("\t \t \t");
        t.append(title.print());

        //Numero achado por tentativa e erro, para alinhar as coisas;
        //Completa os valores vazio com espaço.
        for (int i = title.print().length(); i < 56; i++) {
            t.append(" ");
        }

        t.append(bordaLat);
        //Fechar os Styles
        t.append(s.getTitleTextColor());
        t.append(s.getTitleBackColor());
        //Adiciar uma barra lateral para fechar.

        //Resetar as cores;
        t.append("\u001b[0m");
        t.append("\u001b[0m");

        return t.toString();
    }

    private String drawBody(Slide slide) {
        StringBuilder bd = new StringBuilder();
        String texto;
        
        bd.append("\n");

        bd.append(slide.getStyle().getBackgroundColor());
        bd.append(slide.getStyle().getTextColor());
        
        Node temp = slide.getElem().head;
        //Passado pelos elementos armazenados no Slide
        while(temp != null){
            bd.append(slide.getStyle().getBackgroundColor());
            bd.append(slide.getStyle().getTextColor());
            texto = temp.getElement().toString();
            
            //Ajusta e adicionar as bordar do texto além de providênciar os respectivos cortes
            bd.append(contLetras(texto));
            
            bd.append(slide.getStyle().getBackgroundColor());
            bd.append(slide.getStyle().getTextColor());
            
            temp = temp.next;
            bd.append("\n");
            
            bd.append(slide.getStyle().getBackgroundColor());
            bd.append(slide.getStyle().getTextColor());
        }
        for(int i = slide.getElem().numElements;i <= 18;i++){
            //Adicionado a borda
            bd.append("|");
            //Colocado os espaços em branco
            for(int j = 0;j <= 9;j++){
                bd.append("\t");
            }
            bd.append("|");
            bd.append("\n");
            
            bd.append(slide.getStyle().getBackgroundColor());
            bd.append(slide.getStyle().getTextColor());
        }
        return bd.toString();
    }
    
    private String contLetras(String texto){
        int contLetras = texto.length();
        StringBuilder fText = new StringBuilder();
        String bar = "|";
        
        if(contLetras <= 79){
            fText.append(bar);
            fText.append(texto);
            for(int i = 0;i < 79 - contLetras;i++){
                fText.append(" ");
            }
            fText.append(bar);
        }
        
        else{
            //Divide o texto no limite da borda do slide e o resto
            String corte1 = texto.substring(0, 78);
            String corte2 = texto.substring(78);
            
            fText.append(bar);
            fText.append(corte1);
            fText.append("-");
            fText.append(bar);
            fText.append("\n");
                
            if(corte1.startsWith(" ")){
                //Chama o método novamente para adicionar os espaços necessários
                fText.append(contLetras("        " + corte2));
            }
            else{
                //Adiciona os espaços
                fText.append(contLetras(corte2));
            }
        }
        return fText.toString();
    }
    
    private String drawFooter(Footer footer, int page) {
        StringBuilder fo = new StringBuilder();
        //3 é o numero de atributos do Footer
        String[] att = new String[3];
        //Validar se as tagas estão em outros espaços
        att[0] = footer.getLeft();
        att[1] = footer.getCenter();
        att[2] = footer.getRight();
        
        for(int i = 0;i < 3;i++){
            if(att[i].startsWith("#date")){
                //Pegando a data atual
                String[] data = att[i].split(";");
                SimpleDateFormat sdf = new SimpleDateFormat(data[1]);
                Date dt = new Date();
                att[i] = sdf.format(dt);
            }           
            else if(att[i].startsWith("#page")){
                att[i] = Integer.toString(page);
            }
        }
        //11 é o  length do data[1];
        int somaLetras = att[0].length() + 11;
        String bordaLat = "|";
        fo.append(bordaLat);
        //Adicionar na direita
        fo.append(att[0]);
        fo.append("\t");
        //Adicionar no centro
        fo.append(att[1]);

        for (int i = somaLetras; i < 70; i++) {
            fo.append(" ");
        }

        fo.append(att[2]);
        fo.append(bordaLat);

        return fo.toString();
    }
}
