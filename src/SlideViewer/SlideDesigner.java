package SlideViewer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SlideDesigner {

    public String drawSlide(Slide slide, int page, Footer footer) {
        StringBuilder drawAll = new StringBuilder();
        String bordaSup = "---------------------------------------------------------------------------------";
        String corLetra = slide.getStyle().getTextColor();
        String corFundo = slide.getStyle().getBackgroundColor();

        drawAll.append("\n" + corFundo + bordaSup);
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
        drawAll.append(corFundo + bordaSup);

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

        String bordaLat = "|";
        bd.append("\n");

        bd.append(slide.getStyle().getBackgroundColor());
        bd.append(slide.getStyle().getTextColor());

        int contLetras = 0;
        int i = 0;
        for (; i < slide.getElem().numElements; i++) {
            bd.append(slide.getStyle().getBackgroundColor());
            bd.append(slide.getStyle().getTextColor());
            contLetras = slide.getElem(i).toString().length();
            texto = slide.getElem(i).toString();

            bd.append(bordaLat);
            bd.append(texto);

//            if(texto.length() > 73){
//            bd.append(texto.substring(0,73)); }
//            else{ bd.append(texto); }
            if (contLetras < 80 && texto.startsWith("*", 2) == false) {
                for (int j = 0; j < 79 - contLetras; j++) {
                    bd.append(" ");
                }
            }
            //            else if(contLetras > 80){
            //                String temp = texto.substring(73);
            //                bd.append("\n");
            //                bd.append("\t"+ temp);
            //                bd.append(slide.getStyle().getBackgroundColor());
            //                 for(int j =0;j < 73 - contLetras;j++){
            //                bd.append(" ");
            //             }
            //            }
            else {
                for (int j = 0; j < 73 - contLetras; j++) {
                    bd.append(" ");
                }
            }
            bd.append(bordaLat);
            bd.append("\n");
        }

        bd.append(slide.getStyle().getBackgroundColor());
        bd.append(slide.getStyle().getTextColor());
        while (i <= 19) {

            bd.append(bordaLat);
            for (int j = 0; j < 79; j++) {
                bd.append(" ");
            }
            bd.append(bordaLat);
            bd.append("\n");
            bd.append(slide.getStyle().getBackgroundColor());
            bd.append(slide.getStyle().getTextColor());
            i++;
        }

        return bd.toString();
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
