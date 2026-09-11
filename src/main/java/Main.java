import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.print("$ ");

            String command = scan.nextLine();

            if (command.equals("exit")) {

                break;
            }

            if (command.startsWith("echo ")) {

                System.out.println(command.substring(5));

            } else if (command.startsWith("type ")) {

                String target = command.substring(5);

                if (target.equals("echo")
                        || target.equals("type")
                        || target.equals("exit")) {

                    System.out.println(target + " is a shell builtin");

                } else {

                    String path = System.getenv("PATH");

                    boolean found = false;

                    if (path != null) {

                        String[] directories = path.split(File.pathSeparator);

                        for (String directory : directories) {

                            File file = new File(directory, target);

                            if (file.exists()
                                    && file.isFile()
                                    && file.canExecute()) {

                                System.out.println(
                                        target + " is " + file.getAbsolutePath()
                                );

                                found = true;

                                break;
                            }
                        }
                    }

                    if (!found) {

                        System.out.println(target + ": not found");
                    }
                }

            } else {

                System.out.println(command + ": command not found");
            }
        }

        scan.close();
    }
}