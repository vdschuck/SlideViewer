package SlideViewer;

import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class SlideViewerApp {

    public static void main(String[] args) {
        try {
            PresentationLoader pl = new PresentationLoader();
            String arquivo = JOptionPane.showInputDialog("Digite o nome do arquivo: ");
            Presentation pp = pl.loader(arquivo);
            SlideDesigner sd = new SlideDesigner();
            Navigator nav = new Navigator(pp.getSlides());
            System.out.println(sd.drawSlide(pp.getSlide(nav.getCurrent()), nav.getCurrent(), pp.getFoo()));
            
            PresentationWriter teste = new PresentationWriter();
            teste.save("teste.txt", pp);
            
            int op = 0;
            do {
                try {
                    op = ReadData.readInt("1-Anterior, 2-Proximo, 3-Especifico, 4-Editar, 0-Sair");
                    switch (op) {
                        case 1:
                            nav.previous();
                            System.out.println(sd.drawSlide(pp.getSlide(nav.getCurrent()), nav.getCurrent(), pp.getFoo()));
                            break;
                        case 2:
                            nav.next();
                            System.out.println(sd.drawSlide(pp.getSlide(nav.getCurrent()), nav.getCurrent(), pp.getFoo()));
                            break;
                        case 3:
                            int num = ReadData.readInt("Numero do slide: ");
                            nav.Goto(num);
                            System.out.println(sd.drawSlide(pp.getSlide(nav.getCurrent()), nav.getCurrent(), pp.getFoo()));
                        case 4:
                            
                        case 0:
                            break;
                    }
                } catch (NumberFormatException ex) {
                    op = 0;
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                    op = -1;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "A apresentação acabou ou slide não existe! ");
                }
            } while (op != 0);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo inválido! ");
        } catch (Exception ex) {
            System.out.println("Erro ao criar a apresentação." + ex);
        }
    }
}
