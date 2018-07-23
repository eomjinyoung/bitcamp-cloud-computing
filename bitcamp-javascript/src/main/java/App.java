public class App {
    public String getGreeting() {
        return "안녕하세요.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
