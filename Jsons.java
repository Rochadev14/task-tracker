import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Jsons {
    // Método para guardar la lista de tareas en un archivo JSON
    public static void guardarTareas(List<Tareas> tareas, String archivo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(tareas, writer);  // Esto está bien, Gson serializa directamente la lista
            System.out.println("Tareas guardadas.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    public static List<Tareas> cargarTareas(String archivo) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(archivo)) {
            Type listType = new TypeToken<List<Tareas>>() {}.getType();
            List<Tareas> tareas = gson.fromJson(reader, listType);
            return tareas != null ? tareas : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo. Se usará una lista vacía.");
            return new ArrayList<>();
        }
    }
}


