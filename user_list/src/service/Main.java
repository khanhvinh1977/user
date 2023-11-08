package service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi ban chon");
        System.out.println("1. Dang ky " +
                "2. Dang nhap");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                Scanner input = new Scanner(System.in);
                System.out.println("nhap username");
                String username = input.nextLine();
                System.out.println("nhap password");
                String password = input.nextLine();
                UserService.dangKy(username,password);
            }
            case 2: {
                Scanner input = new Scanner(System.in);
                System.out.println("nhap username");
                String username = input.nextLine();
                System.out.println("nhap password");
                String password = input.nextLine();
                UserService.dangNhap(username,password);
            }
        }
    }
}
