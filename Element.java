
public class Element {

    public int id;
    public Double content;

    // Constructor
    public Element(Double content) {
        /**
         * NOTE: do not make the random numbers interval huge when using the
         * countingSort
         * to avoid having to declare and occurence store with a huge length
         */
        this.id = (int) (Math.random() * 1000);
        this.content = content;
    }

    // toString
    public String toString() {
        String res;
        res = "[ ID : " + this.id + "\tContent : " + this.content + "\t]";
        return res;
    }
}