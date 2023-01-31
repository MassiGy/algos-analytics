
public class Element {

    private int id;
    private Double content;

    // Builder
    public Element(Double content) {

        this.id = (int) (Math.random() * 1000000);
        this.content = content;
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public Double getContent() {
        return this.content;
    }

    // Setters
    public void setId(int newId) {
        this.id = newId;
    }

    public void setContent(Double newContent) {
        this.content = newContent;
    }

    // toString
    public String toString() {
        String res;
        res = "[ ID : " + this.getId() + "\tContent : " + this.getContent() + " ]";
        return res;
    }
}