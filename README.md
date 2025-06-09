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
````
Compile the project:
```bash
javac -cp gson-2.10.1.jar *.java
````
Run the application with commands:
```bash

java -cp .:gson-2.10.1.jar Main add "My first task"
java -cp .:gson-2.10.1.jar Main list
```

(On Windows, replace : with ; in classpath.)
Example on Windows
```bash

java -cp ".;gson-2.10.1.jar" Main.java mark-in-progress 2
```
Usage
Commands available:
```bash


add "task description" — Adds a new task

update <id> "new description" — Updates the task description by ID

delete <id> — Deletes the task by ID

mark-in-progress <id> — Marks the task as in-progress

mark-done <id> — Marks the task as done

list [status] — Lists all tasks or tasks filtered by status (todo, in-progress, done)
```
Example
```bash
java -cp .:lib/gson-2.10.1.jar Main.java add "Finish homework"
```

#  Español
#  Administrador de Tareas por Línea de Comandos

Una aplicación sencilla en Java para gestionar tareas desde la línea de comandos.  
Permite añadir, actualizar, eliminar, listar y cambiar el estado de tareas, almacenando los datos en archivos JSON usando la biblioteca Gson.

---

##  Funcionalidades

- Añadir nuevas tareas con ID único
- Actualizar la descripción de una tarea
- Eliminar tareas por ID
- Marcar tareas como "in-progress" (en progreso) o "done" (hecha)
- Listar todas las tareas o filtrar por estado
- Persistencia de tareas en archivo JSON

---

##  Requisitos

- Java 8 o superior
- Biblioteca [Gson](https://github.com/google/gson)

---

##  Instalación y uso

### 1. Clona este repositorio

```bash
git clone https://github.com/tuusuario/task-cli-manager.git
cd task-cli-manager
```
2. Compila el proyecto
```bash
javac -cp lib/gson-2.10.1.jar *.java
```
3. Ejecuta comandos
Linux 
```bash
java -cp .:lib/gson-2.10.1.jar Main add "Hacer la tarea"
java -cp .:lib/gson-2.10.1.jar Main list
```
Windows
```bash
java -cp ".;lib/gson-2.10.1.jar" Main add "Hacer la tarea"
```
Comandos disponibles
add "descripción" — Añade una nueva tarea

update <id> "nueva descripción" — Actualiza la descripción de una tarea por ID

delete <id> — Elimina una tarea por ID

mark-in-progress <id> — Marca una tarea como en progreso

mark-done <id> — Marca una tarea como hecha

list [estado] — Lista todas las tareas o filtra por estado (todo, in-progress, done)
Ejemplo
```bash
java -cp .:lib/gson-2.10.1.jar Main add "Terminar deberes"
java -cp .:lib/gson-2.10.1.jar Main list
java -cp .:lib/gson-2.10.1.jar Main mark-in-progress 1
```

