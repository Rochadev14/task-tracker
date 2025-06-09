import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, introduce un comando.");
            return;
        }

        GestorTareas gestor = new GestorTareas();
        String comando = args[0];

        switch (comando) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Uso: add \"descripcion tarea\"");
                    return;
                }
                String descripcion = args[1];
                // Obtener último id
                int maxId = gestor.listarTodas().stream()
                        .mapToInt(Tareas::getId)
                        .max()
                        .orElse(0);
                int nuevoId = maxId + 1;
                gestor.addTarea(descripcion, nuevoId);
                System.out.println("Tarea añadida con ID: " + nuevoId);
                break;

            case "update":
                if (args.length < 3) {
                    System.out.println("Uso: update id \"nueva descripcion\"");
                    return;
                }
                try {
                    int idUpdate = Integer.parseInt(args[1]);
                    String nuevaDesc = args[2];
                    gestor.updateTarea(idUpdate, nuevaDesc);
                    System.out.println("Tarea actualizada con ID: " + idUpdate);
                } catch (NumberFormatException e) {
                    System.out.println("ID debe ser un número.");
                }
                break;

            case "delete":
                if (args.length < 2) {
                    System.out.println("Uso: delete id");
                    return;
                }
                try {
                    int idDelete = Integer.parseInt(args[1]);
                    gestor.deleteTarea(idDelete);
                    System.out.println("Tarea eliminada con ID: " + idDelete);
                } catch (NumberFormatException e) {
                    System.out.println("ID debe ser un número.");
                }
                break;

            case "mark-in-progress":
                if (args.length < 2) {
                    System.out.println("Uso: mark-in-progress id");
                    return;
                }
                try {
                    int idMark = Integer.parseInt(args[1]);
                    gestor.markInProgress(idMark);
                    System.out.println("Tarea marcada como in-progress con ID: " + idMark);
                } catch (NumberFormatException e) {
                    System.out.println("ID debe ser un número.");
                }
                break;

            case "mark-done":
                if (args.length < 2) {
                    System.out.println("Uso: mark-done id");
                    return;
                }
                try {
                    int idMarkDone = Integer.parseInt(args[1]);
                    gestor.markDone(idMarkDone);
                    System.out.println("Tarea marcada como done con ID: " + idMarkDone);
                } catch (NumberFormatException e) {
                    System.out.println("ID debe ser un número.");
                }
                break;

            case "list":
                if (args.length == 1) {
                    // Listar todas las tareas
                    List<Tareas> todas = gestor.listarTodas();
                    if (todas.isEmpty()) {
                        System.out.println("No hay tareas.");
                    } else {
                        for (Tareas t : todas) {
                            System.out.println(t.list());
                        }
                    }
                } else {
                    // Listar por status
                    String status = args[1];
                    List<Tareas> filtradas = gestor.listarPorStatus(status);
                    if (filtradas.isEmpty()) {
                        System.out.println("No hay tareas con status: " + status);
                    } else {
                        for (Tareas t : filtradas) {
                            System.out.println(t.list());
                        }
                    }
                }
                break;

            default:
                System.out.println("Comando no reconocido.");
                break;
        }
    }
}
