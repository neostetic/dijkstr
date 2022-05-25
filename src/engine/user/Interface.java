package engine.user;

import engine.user.languages.English;

import java.util.Objects;
import java.util.Scanner;

public class Interface {

    private Scanner scanner = new Scanner(System.in);
    private English text = new English();

    public Interface() {

    }

    public void start() {
        System.out.println(text.welcome);
        menu();
    }

    private void menu() {
        boolean isAvailable;
        do {
            isAvailable = true;
            String answer = toScanner(text.menu);
            if      (Objects.equals(answer, "1")) createFile();
            else if (Objects.equals(answer, "2")) nodeWriter();
            else if (Objects.equals(answer, "3")) deleteFile();
            else if (Objects.equals(answer, "4")) calculateShortestPath();
            else if (Objects.equals(answer, "5")) isAvailable = false;
        } while (isAvailable);
    }

    private void createFile() {
        boolean isAvailable;
        do {
            String answer = toScanner(text.newFile + text.space + text.yesNo);
            if (Objects.equals(answer, "1")) {
                isAvailable = true;
                // here create file
            } else {
                isAvailable = false;
            }
        } while (isAvailable);
        nodeWriter();
    }

    private void nodeWriter() {
        boolean isAvailable;
        do {
            String answer = toScanner(text.newNode + text.space + text.yesNo);
            if (Objects.equals(answer, "1")) {
                isAvailable = true;
                // here update nodes
            } else {
                isAvailable = false;
            }
        } while (isAvailable);
    }

    private void deleteFile() {
        boolean isAvailable;
        do {
            String answer = toScanner(text.deleteFile + text.space + text.yesNo);
            if (Objects.equals(answer, "1")) {
                isAvailable = true;
                // here delete file
            } else {
                isAvailable = false;
            }
        } while (isAvailable);
    }

    private void calculateShortestPath() {
        boolean isAvailable;
        do {
            String answer = toScanner(text.calculate + text.space + text.yesNo);
            if (Objects.equals(answer, "1")) {
                isAvailable = true;
                // calculate shortest path from file
            } else {
                isAvailable = false;
            }
        } while (isAvailable);
    }

    private String toScanner(String yourText) {
        System.out.println(yourText);
        System.out.print(" - Answer: ");
        String scan = scanner.next();
        clearScreen();
        return scan;
    }

    private void clearScreen() {
        System.out.print("\n[cleared beyond this point]\n\n");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
