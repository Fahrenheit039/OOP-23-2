package os;

import java.util.Scanner;

import os.windows.windowsFactory;
import os.linux.linuxFactory;
import os.macos.macosFactory;

public class os {

    public static Factory pick(){
        Scanner scanner;
        try {
            while (true) {
                System.out.print("\n\"windows\" \\ \"linux\" \\ \"macos\"\npick OS : ");
                scanner = new Scanner(System.in);
                String os = scanner.nextLine();
                switch (os) {
                    case "windows": return new windowsFactory();
                    case "linux": return new linuxFactory();
                    case "macos": return new macosFactory();
                }
            }
        } catch(Exception e){
            System.out.println("os pick Exception: " + e.getMessage());
        }
        return null;
    }

}
