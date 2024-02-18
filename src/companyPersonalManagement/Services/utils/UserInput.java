package companyPersonalManagement.Services.utils;

import java.util.Scanner;

public class UserInput {


    public static int inputInt(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextInt();
    }
    public static String inputString(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}
