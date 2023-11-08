package service;

import entity.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
  static List<User> users;
    // Đọc các username trong file
    public static List<User> docUserTuFile() {
        File file = new File("users.txt");
        users = new ArrayList<>();
        Scanner sc;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] info = line.split(",");

                User user = new User();
                user.setUsername(info[0]);
                user.setPassword(info[1]);

                users.add(user);
            }
        } catch (Exception e) {
            System.out.println("bug");
        }
        return users;
    }

    public static void ghi_Usename_password_xuongFile(List<User> userList) {
        FileWriter writer;
        try {
            writer = new FileWriter("users.txt");
            for (User student : userList) {
                writer.write(student.toString()+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Kiểm tra trùng lặp
    public static boolean kiemTraTrungLap(String username) {
        List<User> userList = docUserTuFile();
        for (User user: userList) {
            if (user.getUsername().equals(username)) {
            System.out.println("username cua ban da bi trung lap");
            return true;
            }
        }
        System.out.println("username hop le");
        return false;
    }
//Tim password dua vao username
    public static String getPasswordByUsername(String username) {
        List<User> userList = docUserTuFile();
        for (User user: userList) {
            if (user.getUsername().equals(username)) {
                return user.getPassword();
            }
        }
        return "tai khoan khong tim thay";
    }

    public static void dangKy(String username, String password) {
        if (!kiemTraTrungLap(username)) {
            List<User> userList = docUserTuFile();
            User user = new User(username,password);
            userList.add(user);
            ghi_Usename_password_xuongFile(userList);
        }
    }

    public static void dangNhap(String username,String password) {
        String passwordBenTrongFIle = getPasswordByUsername(username);
        if (passwordBenTrongFIle.equals(password)) {
            System.out.println("dang nhap thanh cong");
        } else {
            System.out.println("Sai Username va mat khau");
        }
    }

}

