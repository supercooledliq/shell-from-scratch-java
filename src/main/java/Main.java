import java.io.File;
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
        String afterCommand=parts[1];

        switch(command)
        {
            case "echo": System.out.println(parts[1]);
            break;

            case "exit": System.exit(0);
            break;

            case "type": String answer= typeBuiltin(afterCommand);
                         System.out.println(answer);
                         break;
                      
            default: System.out.println(command+": command not found");
        }
    }
       
    }
    public static String typeBuiltin(String afterCommand)
    {
        String[] builtin={"echo", "exit", "type"};
        if(java.util.Arrays.asList(builtin).contains(afterCommand))
        return (afterCommand +" is a shell builtin");
        else 
        {
        String Path= System.getenv("PATH");
        String[] dirs= Path.split(java.io.File.pathSeparator);
        for (String dir : dirs) {
            java.io.File file=new File(dir,afterCommand);
            if(file.exists() && file.canExecute())
            {
                return (afterCommand+ " is " +file.getAbsolutePath());
            }
        }
        return (afterCommand+ " : not found");

        }

    }
}
