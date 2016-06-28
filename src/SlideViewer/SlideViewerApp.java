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
            

            int op = 0;
            do {
                try {
                    op = ReadData.readInt(" 0-Sair\n 1-Anterior\n 2-Proximo\n 3-Especifico\n 4-Editar\n 5-Primeiro slide\n 6-Ultimo Slide");
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
                            break;
                        case 4:
                            int sub = ReadData.readIntSub(" 0-Sair\n 1-Adicionar Slide\n 2-Duplicar Slide\n 3-Remover Slide\n 4-Mover Slide\n 5-Alterar Titulo\n 6-Adicionar Texto\n 7- Salva alterações");
                            PresentationEditor edit = new PresentationEditor();

                            switch (sub) {
                                case 1: {
                                    int pos = ReadData.readIntSlide("Posição do slide: ", pp.getSlides().numElements);
                                    Title nTitulo = new Title(JOptionPane.showInputDialog("Digite o titulo que deseja"));
                                    int estilo = ReadData.readIntSlide("Digite o código do estilo", pp.getStyles().numElements);
                                    
                                    Slide novoSlide = new Slide();
                                    novoSlide.setStyle(pp.getStyle(estilo));
                                    edit.addSlide(novoSlide, pos, pp);
                                    edit.changeTitle(nTitulo, pos, pp);
                                    break;
                                }
                                case 2: {
                                    int pos = ReadData.readIntSlide("Duplicar qual slide: ", pp.getSlides().numElements);
                                    edit.duplica(pos, pp);
                                    break;
                                }
                                case 3: {
                                    int pos = ReadData.readIntSlide("Remover qual slide: ", pp.getSlides().numElements);
                                    edit.remove(pos, pp);
                                    break;
                                }
                                case 4: {
                                    int pos = ReadData.readIntSlide("Mover qual slide: ", pp.getSlides().numElements);
                                    int to = ReadData.readIntSlide("Nova posição do slide: ", pp.getSlides().numElements);
                                    edit.move(pos, to, pp);
                                    break;
                                }
                                case 5: {
                                    int pos = ReadData.readIntSlide("A posição do slide que deseja alterar o titulo: ", pp.getSlides().numElements);
                                    try{
                                        String titulo = JOptionPane.showInputDialog("Digite o titulo que deseja");
                                        Title nTitle = new Title(titulo);
                                        edit.changeTitle(nTitle, pos, pp);
                                    }
                                    catch(Exception e){
                                         JOptionPane.showMessageDialog(null, "Verique as informações digitadas", "Erro na leitura", JOptionPane.ERROR_MESSAGE);
                                    }
                                    break;
                                }
                                case 6: {
                                   int page = ReadData.readIntSlide("Numero do slide para adicionar texto: ", pp.getSlides().numElements);
                                    
                                    String item = JOptionPane.showInputDialog("Texto para adicionar no slide: "); 
                                    
                                    int level = ReadData.readIntTwo("O texto é 1-Item ou 2-Sub-item: ");                                    
                                     
                                    int pagination = ReadData.readIntTwo("O texto é 1-numerado ou 2-simbolos: "); 
                                    
                                    edit.addElement(item, page, pp, level, pagination);
                                    break;
                                }
                                case 7:{
                                    String fileName = JOptionPane.showInputDialog("Nome do arquivo que deseja salvar: "); 
                                    PresentationWriter salvar = new PresentationWriter();
                                    salvar.save(fileName, pp);
                                }
                            }
                            break;
                        case 5:
                            nav.first();
                            System.out.println(sd.drawSlide(pp.getSlide(nav.getCurrent()), nav.getCurrent(), pp.getFoo()));
                            break;
                        case 6:
                            nav.last();
                            System.out.println(sd.drawSlide(pp.getSlide(nav.getCurrent()), nav.getCurrent(), pp.getFoo()));
                            break;
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
