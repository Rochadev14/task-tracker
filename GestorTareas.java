import java.util.List;
import java.util.ArrayList;
public class GestorTareas {
    private List<Tareas> tareas;
    public String archivo = "tareas.json"; // Nombre del archivo JSON donde se guardarán las tareas

    public GestorTareas() {
        this.tareas = new ArrayList<>(); // Inicializa la lista de tareas
        // Aquí cargas la lista desde JSON al iniciar (o creas lista vacía si no existe archivo)
    }


    public void addTarea(String descripcion) {
       this.tareas.add(new Tareas(descripcion));

    }

    public void updateTarea(int id, String descripcion) {
        for (int i = 0; tareas.size() >i;i++){
            if (tareas.get(i).getId() == id) {
                tareas.get(i).setDescripcion(descripcion);
                tareas.get(i).setActualizadoen();
                Jsons.guardarTareas(tareas, archivo);
                // Aquí podrías guardar cambios en JSON
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

                // Aquí podrías guardar cambios en JSON
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

                // Aquí podrías guardar cambios en JSON
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

                // Aquí podrías guardar cambios en JSON
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
