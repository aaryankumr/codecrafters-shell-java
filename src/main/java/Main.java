import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // TODO: Uncomment the code below to pass the first stage
        while(true) {
            System.out.print("$ ");
            Scanner scan = new Scanner(System.in);
            String command = scan.nextLine();
            if (command.equals("exit")) {
                break;
            }
            if(command.startsWith("echo ")) {
                System.out.println(command.substring(6));
            }
                System.out.println(command + " : command not found");

        }
    }
}
