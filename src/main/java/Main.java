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
                System.out.println(command.substring(5));
            } else if (command.startsWith("type")) {
                String target = command.substring(5);
                if(target.equals("echo") || target.equals("type") || target.equals("exit") ){
                    System.out.println(target + "is a shell bulletin");
                }
            } else {
                System.out.println(command + ": command not found");
            }
        }
    }
}
