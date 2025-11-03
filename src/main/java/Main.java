import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean i = true;
        while (i) {
        System.out.print("$ ");
        Scanner sc=new Scanner(System.in);
        String command = sc.nextLine();
        if(command.equals("exit 0"))
        i = false;
        else
        System.out.println(command+": command not found");
        }
       
    }
}
