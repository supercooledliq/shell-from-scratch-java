import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean i = true;
        while (i) {

        System.out.print("$ ");
        Scanner sc=new Scanner(System.in);

        // String input = sc.nextLine();
        // String[] parts = input.split(" ", 2);
        // if(parts.length==1)
        // {
        //     System.out.println(input+": command not found");
        // }
        // else{
        // String command = parts[0];
        // String afterCommand=parts[1];
        String input = sc.nextLine().trim();
        String[] parts = input.split("\\s+");
        String command = parts[0];
       // if(parts.length>1)
       // {
             String afterCommand = parts[1];
       // }
  
        String[] cmdargs= java.util.Arrays.copyOfRange(parts,1,parts.length);

        switch(command)
        {
            case "echo": System.out.println(String.join(" ", cmdargs));
                         break;

            case "exit": System.exit(0);
            break;

            case "type": String answer= typeBuiltin(afterCommand);
                         System.out.println(answer);
                         break;
                      
            default: runExternal(command, cmdargs);
                 //System.out.println(command+": command not found");
        }
    }
}
       
 
    public static void runExternal(String command, String[] cmdargs)
    {
        //String args[]= afterCommand.split(" ");
        String Path= System.getenv("PATH");
        String[] dirs= Path.split(java.io.File.pathSeparator);
        for (String dir : dirs) {
            java.io.File file=new File(dir,command);
            if(file.exists() && file.canExecute())
            {
                String[] finalArgs= new String[cmdargs.length+1];
                finalArgs[0] = command;
                System.arraycopy(cmdargs, 0, finalArgs, 1, cmdargs.length);

                ProcessBuilder pb = new ProcessBuilder(finalArgs);
                pb.inheritIO(); //so output prints to the terminal
                try{
                    pb.start().waitFor();
                }catch(Exception e ){}
                return;
            }
    }
    System.out.println(command + ": command not found");
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
        return (afterCommand+ ": not found");

        }

    }
}
