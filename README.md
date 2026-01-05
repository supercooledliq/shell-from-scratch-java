# Unix-Like Shell (Java)

A minimal Unix-like command-line shell implemented in Java to understand how
shells parse commands, resolve executables via PATH, and execute processes.

This project focuses on core shell mechanics such as built-in commands,
external program execution, and environment variable handling.

---

## Features Implemented

- Interactive REPL (Read–Eval–Print Loop)
- Built-in commands:
  - `echo`
  - `exit`
  - `type`
  - `pwd`
- Resolution of external commands using the system `PATH`
- Execution of external programs with arguments
- Differentiation between built-ins and executables
- OS-agnostic PATH parsing using Java APIs

---

## How It Works

1. Reads user input from standard input
2. Tokenizes commands and arguments
3. Executes built-in commands directly
4. Searches for external executables in directories listed in `PATH`
5. Spawns processes using `ProcessBuilder` and forwards I/O to the terminal

---

## Why This Project

This project was built to gain a deeper understanding of:
- Unix process execution
- Shell command parsing
- PATH-based executable resolution
- Differences between built-in commands and external programs

---

## Limitations

- This is not a fully POSIX-compliant shell yet
- Features such as redirection, piping, and job control are not implemented

---

## Tech Stack

- Java
- Maven
- Unix/Linux process model
