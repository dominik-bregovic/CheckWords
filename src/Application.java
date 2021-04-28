public class Application {

    public static void main(String[] args) {

        Write writting = new Write();
        writting.writeString();
        Reader reader = new Reader();

        System.out.println(reader.reader("firstText.txt"));
    }
}
