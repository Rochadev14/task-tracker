import java.util.List;
import java.util.ArrayList;
public class GestorTareas {
    private List<Tareas> tareas;
    public String archivo = "tareas.json"; // Nombre del archivo JSON donde se guardarán las tareas

    public GestorTareas() {
        this.tareas = Jsons.cargarTareas(archivo); // Carga tareas desde el archivo JSON al iniciar
    }


    public void addTarea(String descripcion, int id) {
        int nuevoId = tareas.stream()
                .mapToInt(Tareas::getId)
                .max()
                .orElse(0) + 1;
        this.tareas.add(new Tareas(descripcion, nuevoId));
        Jsons.guardarTareas(tareas, archivo);
    }

    public void updateTarea(int id, String descripcion) {
        for (int i = 0; tareas.size() >i;i++){
            if (tareas.get(i).getId() == id) {
                tareas.get(i).setDescripcion(descripcion);
                tareas.get(i).setActualizadoen();
                Jsons.guardarTareas(tareas, archivo);
                return;
            }
        }

    }

    public void deleteTarea(int id) {
        // Elimina tarea por id y guarda cambios
        for (int i = 0; tareas.size() >i;i++){
            if (tareas.get(i).getId() == id) {
               tareas.remove(i);
               Jsons.guardarTareas(tareas, archivo);

                return;
            }
        }
    }

    public void markInProgress(int id) {
        // Cambia status a "in-progress" y guarda
        for (int i = 0; tareas.size() >i;i++){
            if (tareas.get(i).getId() == id) {
                tareas.get(i).setStatus("in-progress");
                tareas.get(i).setActualizadoen();
                Jsons.guardarTareas(tareas, archivo);

                return;
            }
        }
    }

    public void markDone(int id) {
        // Cambia status a "done" y guarda
        for (int i = 0; tareas.size() >i;i++){
            if (tareas.get(i).getId() == id) {
                tareas.get(i).setStatus("done");
                tareas.get(i).setActualizadoen();
                Jsons.guardarTareas(tareas, archivo);

                return;
            }
        }
    }

    public List<Tareas> listarTodas() {
        // Devuelve la lista completa
        return tareas;
    }

    public List<Tareas> listarPorStatus(String status) {
        // Filtra tareas por estado ("todo", "in-progress", "done")
        return tareas.stream()
                .filter(tarea -> tarea.getStatus().equalsIgnoreCase(status))
                .toList();
    }
}
