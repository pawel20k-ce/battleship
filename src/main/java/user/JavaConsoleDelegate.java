package user;

import java.util.Scanner;

public class JavaConsoleDelegate {
        private Scanner scanner;

    public JavaConsoleDelegate() {
        scanner = new Scanner(System.in);
    }

    void printToConsole(String text){
        System.out.println(text);
    }

    String readFromConsole(){

        return scanner.next();

    }
}
