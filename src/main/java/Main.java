import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean i = true;
        while (i) {
            
        System.out.print("$ ");
        Scanner sc=new Scanner(System.in);

        String input = sc.nextLine();
        String[] parts = input.split(" ", 2);
        String command = parts[0];

        switch(command)
        {
            case "echo": System.out.println(parts[1]);
            break;

            case "exit": System.exit(0);
            break;

            default: System.out.println(command+": command not found");
        }
    }
       
    }
}
