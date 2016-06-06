package SlideViewer;

public class Footer extends Element {

    private String left;
    private String right;

    public Footer(String left, String right, String center) {
        //Será o center
        super(center);
        this.left = left;
        this.right = right;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public void setCenter(String center) {
        super.setText(center);
    }

    public String getCenter() {
        return super.getText();
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
    
    @Override
    public String print() {
        return "";
    }

}
