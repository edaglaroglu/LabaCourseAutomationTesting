package OdevOn;

public class GenericValue<T> {

    private T content;

    public T getContent() {
        return content;
    }
    public void setContent(T content) {
        this.content = content;
    }

    public void printContent() {
        if (content instanceof Integer) {
            System.out.println("Integer türünde bir değer aldım: " + content);
        } else if (content instanceof String) {
            System.out.println("String türünde bir değer aldım: \"" + content + "\"");
        } else if (content instanceof Double) {
            System.out.println("Double türünde bir değer aldım: " + content);
        } else {
            System.out.println("Bilinmeyen türde bir değer aldım: " + content);
        }
    }

}
