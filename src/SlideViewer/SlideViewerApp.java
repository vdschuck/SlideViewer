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
                            int sub = ReadData.readIntSub(" 0-Sair\n 1-Adicionar Slide\n 2-Duplicar Slide\n 3-Remover Slide\n 4-Mover Slide\n 5-Alterar Titulo\n 6-Adicionar Texto");
                            PresentationEditor edit = new PresentationEditor();

                            switch (sub) {
                                case 1: {
                                    int pos = ReadData.readIntSlide("Posição do slide: ", pp.getSlides().numElements);
                                    edit.addSlide(pp.getSlide(pos), pos, pp);
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
                                    String pos = JOptionPane.showInputDialog("A posição do slide que deseja alterar o titulo: ");
                                    int numPos = Integer.parseInt(pos);
                                    try{
                                        if(numPos > pp.getSlides().numElements){
                                            throw new IndexOutOfBoundsException();
                                        }
                                        else if(numPos < 0){
                                            throw new UnderflowException();
                                        }
                                        else{ 
                                            String titulo = JOptionPane.showInputDialog("Digite o titulo que deseja");
                                            if(titulo.length() > 57){
                                                JOptionPane.showMessageDialog(null, "Digite um número de caracteres válido", "Erro de escrita", JOptionPane.ERROR_MESSAGE); 
                                            }
                                            else{
                                                Title nTitle = new Title(titulo);
                                                edit.changeTitle(nTitle, numPos, pp);
                                            }
                                        }
                                    }                             
                                    catch(IndexOutOfBoundsException e){
                                         JOptionPane.showMessageDialog(null, "O slide escolhido não é válido", "Erro na leitura", JOptionPane.ERROR_MESSAGE);
                                    }
                                    catch(UnderflowException e){
                                        JOptionPane.showMessageDialog(null, "Digite um slide maior", "Erro na leitura", JOptionPane.ERROR_MESSAGE);
                                    }
                                    break;
                                }
                                case 6: {
                                    int pos = ReadData.readIntSlide("Slide que deseja adicionar texto: ", pp.getSlides().numElements);
                                    //edit.addElement(null, n, pos, pp);
                                    break;
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
                    JOptionPane.showMessageDialog(null, "A apresentação acabou ou slide não existe! " + ex);
                }
            } while (op != 0);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo inválido! ");
        } catch (Exception ex) {
            System.out.println("Erro ao criar a apresentação.");
        }
    }
}
