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
            Navigator<SinglyLinkedList> nav = new Navigator(pp.getSlides());
            System.out.println(sd.drawSlide(pp.getSlide(nav.getCurrent()), nav.getCurrent(), pp.getFoo()));
            PresentationWriter teste = new PresentationWriter();
            teste.save("teste.txt", pp);

            int op = 0;
            do {
                try {
                    op = ReadData.readInt(" 0-Sair\n 1-Anterior\n 2-Proximo\n 3-Especifico\n 4-Editar");
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
                            int sub = ReadData.readIntSub(" 0-Sair\n 1-Adicionar Slide\n 2-Duplicar Slide\n 3-Remover Slide\n 4-Mover Slide\n 5-Alterar Titulo\n 6-Adicionar Texto");
                            PresentationEditor edit = new PresentationEditor();
                            if (sub == 1) {
                                int pos = ReadData.readIntSlide("Posição do slide: ", pp.getSlides().numElements);                                
                                edit.addSlide(pp.getSlide(pos), pos, pp);
                            } else if (sub == 2) {
                                int pos = ReadData.readIntSlide("Duplicar qual slide: ", pp.getSlides().numElements);                                
                                edit.duplica(pos, pp);
                            } else if (sub == 3) {
                                int pos = ReadData.readIntSlide("Remover qual slide: ", pp.getSlides().numElements);
                                edit.remove(pos, pp);
                            } else if (sub == 4) {
                                int pos = ReadData.readIntSlide("Mover qual slide slide: ", pp.getSlides().numElements);
                                int to = ReadData.readIntSlide("Nova posição do slide: ", pp.getSlides().numElements);
                                edit.move(pos, to, pp);
                            } else if (sub == 5) {
                                int pos = ReadData.readIntSlide("Slide que deseja alterar o titulo: ",pp.getSlides().numElements);
                                int title = ReadData.readIntSlide("Novo titulo: ", pp.getSlides().numElements);
                                edit.changeTitle(null, pos, pp);
                            } else if (sub == 6) {
                                int pos = ReadData.readIntSlide("Slide que deseja adicionar texto: ", pp.getSlides().numElements);
                                //edit.addElement(null, n, pos, pp);
                            }
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
