import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Jsons {
    // Método para guardar la lista de tareas en un archivo JSON
    public static void guardarTareas(List<Tareas> tareas,String archivo){
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // Crear un objeto Gson con formato bonito
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(tareas, writer); // Convertir la lista de tareas a JSON y escribirla en el archivo
            System.out.println("Tareas guardadas.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


