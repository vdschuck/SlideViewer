package SlideViewer;

public class Style {

    private String textColor;
    private String backgroundColor;
    private String titleTextColor;
    private String titleBackColor;

    public Style(String textColor, String backgroundColor, String titleTextColor, String titleBackColor) {
        setTextColor(textColor);
        setBackgroundColor(backgroundColor);
        setTitleTextColor(titleTextColor);
        setTitleBackColor(titleBackColor);
    }

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

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = convertTextColor(textColor);
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = convertBackColor(backgroundColor);
    }

    public String getTitleTextColor() {
        return titleTextColor;
    }

    public void setTitleTextColor(String titleTextColor) {
        this.titleTextColor = convertTextColor(titleTextColor);
    }

    public String getTitleBackColor() {
        return titleBackColor;
    }

    public void setTitleBackColor(String titleBackColor) {
        this.titleBackColor = convertBackColor(titleBackColor);
    }
}
