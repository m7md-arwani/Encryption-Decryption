package encryptdecrypt;

public class Text {

    private TextActivity act;


    public Text(TextActivity act) {
        this.act = act;
    }

    public void process(String mes, String out, int key, boolean type) {
        this.act.processText(mes, out, key, type);
    }

    public void process(String mes, int key, boolean type) {
        this.act.processText(mes, key, type);
    }

}
