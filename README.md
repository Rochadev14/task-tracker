# Task CLI Manager

A simple command-line task manager application written in Java.  
It allows you to add, update, delete, list, and change the status of tasks, saving the data as JSON files using Gson.

## Features

- Add new tasks with unique IDs
- Update task descriptions
- Delete tasks by ID
- Mark tasks as "in-progress" or "done"
- List all tasks or filter tasks by status
- Persist tasks to JSON files for easy data storage and retrieval

## Requirements

- Java 8 or higher
- [Gson library](https://github.com/google/gson)

## Setup

1. Clone this repository:

```bash
git clone https://github.com/yourusername/task-cli-manager.git
cd task-cli-manager
Download and add the Gson library to your project dependencies.
If using Maven, add this to your pom.xml:

xml
Copiar
Editar
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
Compile the project:

bash
Copiar
Editar
javac -cp gson-2.10.1.jar *.java
Run the application with commands:

bash
Copiar
Editar
java -cp .:gson-2.10.1.jar Main add "My first task"
java -cp .:gson-2.10.1.jar Main list
(On Windows, replace : with ; in classpath.)

Usage
Commands available:

add "task description" — Adds a new task

update <id> "new description" — Updates the task description by ID

delete <id> — Deletes the task by ID

mark-in-progress <id> — Marks the task as in-progress

mark-done <id> — Marks the task as done

list [status] — Lists all tasks or tasks filtered by status (todo, in-progress, done)

Example
bash
Copiar
Editar
java -cp .:gson-2.10.1.jar Main add "Finish homework"
java -cp .:gson-2.10.1.jar Main mark-in-progress 1
java -cp .:gson-2.10.1.jar Main list done
