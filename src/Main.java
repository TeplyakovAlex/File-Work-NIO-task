import service.FileReadService;
import service.FileWriteService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner;

    public static void main(String[] args) throws IOException {
        handleChoice(getChoice());
    }

    private static int getChoice() {
        scanner = new Scanner(System.in);
        System.out.println("""
                Make a choice:
                1)  Create and write in file.
                2) Read file
                0) Close app.
                """);
        return scanner.nextInt();
    }

    public static void handleChoice(int choice) throws IOException {
        switch (choice) {
            case 1 -> getOutput(writeFile(getWriteData()));
            case 2 -> getOutput(readFile(getReadData()));
            case 0 -> {
                System.out.println("App closed.");
                System.exit(0);
            }
            default -> System.out.println("Wrong value" + choice);
        }
    }

    public static String[] getWriteData() {
        scanner = new Scanner(System.in);
        System.out.println("Enter you content text : ");
        String text = scanner.nextLine();
        System.out.println("Enter file name : ");
        String name = scanner.nextLine();
        return new String[]{text, name};
    }

    private static String getReadData() {
        scanner = new Scanner(System.in);
        System.out.println(" Enter file name : ");
        return scanner.nextLine();
    }

    private static String writeFile(String[] data) {
        return new FileWriteService().writeFile(data[0], data[1]);
    }

    ;

    private static String readFile(String name) throws IOException {
        return new FileReadService().readFile(name);

    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}


