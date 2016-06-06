package SlideViewer;

public class Style {

    private int id;
    private String textColor;
    private String backgroundColor;
    private String titleTextColor;
    private String titleBackColor;

    public Style(int id,String textColor, String backgroundColor, String titleTextColor, String titleBackColor) {
        setId(id);
        setTextColor(textColor);
        setBackgroundColor(backgroundColor);
        setTitleTextColor(titleTextColor);
        setTitleBackColor(titleBackColor);               
    }

    //Converte para ASCII
    private String convertTextColor(String cor) {
        if (cor.equalsIgnoreCase("black")) {
            return "\u001b[0;30m";
        } else if (cor.equalsIgnoreCase("blue")) {
            return "\u001B[34m";
        } else if (cor.equalsIgnoreCase("yellow")) {
            return "\u001B[33m";
        } else if (cor.equalsIgnoreCase("white")) {
            return "\u001B[37m";
        } else if (cor.equalsIgnoreCase("dark_blue")) {
            return "\u001B[1;34m";
        } else if (cor.equalsIgnoreCase("dark_gray")) {
            return "\u001B[1;37m";
        } else {
            return "Cor Invalida ";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Converte para ASCII
    private String convertBackColor(String cor) {
        if (cor.equalsIgnoreCase("red")) {
            return "\u001b[41m";
        } else if (cor.equalsIgnoreCase("blue")) {
            return "\u001B[44m";
        } else if (cor.equalsIgnoreCase("yellow")) {
            return "\u001B[43m";
        } else if (cor.equalsIgnoreCase("white")) {
            return "\u001B[47m";
        } else if (cor.equalsIgnoreCase("dark_blue")) {
            return "\u001B[1;44m";
        } else if (cor.equalsIgnoreCase("dark_gray")) {
            return "\u001B[1;47m";
        } else {
            return "Cor Invalida ";
        }
    }
    
    //Converte de ASCII para texto
    private String convertTextColorWrite(String cor) {
        if (cor.equalsIgnoreCase("\u001b[0;30m")) {
            return "black";
        } else if (cor.equalsIgnoreCase("\u001B[34m")) {
            return "blue";
        } else if (cor.equalsIgnoreCase("\u001B[33m")) {
            return "yellow";
        } else if (cor.equalsIgnoreCase("\u001B[37m")) {
            return "white";
        } else if (cor.equalsIgnoreCase("\u001B[1;34m")) {
            return "dark_blue";
        } else if (cor.equalsIgnoreCase("\u001B[1;37m")) {
            return "dark_gray";
        } else {
            return "Cor Invalida ";
        }
    }
    
    //Converte de ASCII para texto
    private String convertBackColorWrite(String cor) {
        if (cor.equalsIgnoreCase("\u001b[41m")) {
            return "red";
        } else if (cor.equalsIgnoreCase("\u001B[44m")) {
            return "blue";
        } else if (cor.equalsIgnoreCase("\u001B[43m")) {
            return "yellow";
        } else if (cor.equalsIgnoreCase("\u001B[47m")) {
            return "white";
        } else if (cor.equalsIgnoreCase("\u001B[1;44m")) {
            return "dark_blue";
        } else if (cor.equalsIgnoreCase("\u001B[1;47m")) {
            return "dark_gray";
        } else {
            return "Cor Invalida ";
        }
    }

    public String getTextColor() {
        return textColor;
    }
    
    public String getTextColorWrite() {
        return convertTextColorWrite(textColor);        
    } 
    
    public void setTextColor(String textColor) {
        this.textColor = convertTextColor(textColor);
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }
     
    public String getBackgroundColorWrite() {
        return convertBackColorWrite(backgroundColor);
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = convertBackColor(backgroundColor);
    }

    public String getTitleTextColor() {
        return titleTextColor;
    }
    
    public String getTitleTextColorWrite() {
        return convertTextColorWrite(titleTextColor);
    }

    public void setTitleTextColor(String titleTextColor) {
        this.titleTextColor = convertTextColor(titleTextColor);
    }

    public String getTitleBackColor() {
        return titleBackColor;
    }
    
    public String getTitleBackColorWrite() {
        return convertBackColorWrite(titleBackColor);
    }

    public void setTitleBackColor(String titleBackColor) {
        this.titleBackColor = convertBackColor(titleBackColor);
    }
}
