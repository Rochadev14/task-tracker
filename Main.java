import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();

        if (args.length == 0) {
            System.out.println("Debes introducir un comando. Usa: add, list, update, delete, done, inprogress");
            return;
        }

        String comando = args[0].toLowerCase();

        switch (comando) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Debes proporcionar una descripción para la tarea.");
                } else {
                    String descripcion = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
                    gestor.addTarea(descripcion);
                    System.out.println("Tarea añadida.");
                }
                break;

            case "list":
                List<Tareas> tareas = gestor.listarTodas();
                if (tareas.isEmpty()) {
                    System.out.println("No hay tareas.");
                } else {
                    for (Tareas tarea : tareas) {
                        System.out.println(tarea);
                    }
                }
                break;

            case "update":
                if (args.length < 3) {
                    System.out.println("Debes proporcionar el ID y la nueva descripción de la tarea.");
                } else {
                    try {
                        int id = Integer.parseInt(args[1]);
                        String descripcion = String.join(" ", Arrays.copyOfRange(args, 2, args.length));
                        gestor.updateTarea(id, descripcion);
                        System.out.println("Tarea actualizada.");
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido. Debe ser un número.");
                    }
                }
                break;

            case "delete":
                if (args.length < 2) {
                    System.out.println("Debes proporcionar el ID de la tarea a eliminar.");
                } else {
                    try {
                        int id = Integer.parseInt(args[1]);
                        gestor.deleteTarea(id);
                        System.out.println("Tarea eliminada.");
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido. Debe ser un número.");
                    }
                }
                break;

            case "done":
                if (args.length < 2) {
                    System.out.println("Debes proporcionar el ID de la tarea a marcar como completada.");
                } else {
                    try {
                        int id = Integer.parseInt(args[1]);
                        gestor.markDone(id);
                        System.out.println("Tarea marcada como completada.");
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido. Debe ser un número.");
                    }
                }
                break;

            case "inprogress":
                if (args.length < 2) {
                    System.out.println("Debes proporcionar el ID de la tarea a marcar como en progreso.");
                } else {
                    try {
                        int id = Integer.parseInt(args[1]);
                        gestor.markInProgress(id);
                        System.out.println("Tarea marcada como en progreso.");
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido. Debe ser un número.");
                    }
                }
                break;

            default:
                System.out.println("Comando no reconocido. Usa: add, list, update, delete, done, inprogress");
        }
    }
}
