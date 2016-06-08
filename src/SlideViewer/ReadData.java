package SlideViewer;

import javax.swing.JOptionPane;

public class ReadData {

    public static Integer readInt(String valor) throws Exception {
        String x;
        do {
            try {
                x = JOptionPane.showInputDialog(valor);
                if (x == null) {
                    return 0;
                } else {
                    int j = Integer.valueOf(x);
                    if (j >= 0 && j <= 4) {
                        return j;
                    } else {
                        throw new Exception("Valor inválido! ");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor inválido! ");
            }
        } while (true);
    }
    
    public static Integer readIntSub(String valor) throws Exception {
        String x;
        do {
            try {
                x = JOptionPane.showInputDialog(valor);
                if (x == null) {
                    return 0;
                } else {
                    int j = Integer.valueOf(x);
                    if (j >= 0 && j <= 6) {
                        return j;
                    } else {
                        throw new Exception("Valor inválido! ");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor inválido! ");
            }
        } while (true);
    }
    
    public static Integer readIntSlide(String valor, int p) throws Exception {
        String x;
        do {
            try {
                x = JOptionPane.showInputDialog(valor);
                if (x == null) {
                    return 0;
                } else {
                    int j = Integer.valueOf(x);
                    if (j >= 0 && j <= p) {
                        return j;
                    } else {
                        throw new Exception("Valor inválido! ");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Valor inválido! ");
            }
        } while (true);
    }

}
