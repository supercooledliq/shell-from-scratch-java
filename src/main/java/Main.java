import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean i = true;
        while (i == true) {
        System.out.print("$ ");
        Scanner sc=new Scanner(System.in);
        String command = sc.nextLine();
        if(command == "exit 0")
        i = false;
        else
        System.out.println(command+": command not found");
        }
       
    }
}
