import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tareas {
    private int id =0;
    private String descripcion;
    private String Status;
    private String fechaCreacion;
    private String actualizadoen;

    String aplicarFecha() {
        LocalDateTime now = LocalDateTime.now();
        String formatted = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return formatted;
    }
    public Tareas(String descripcion,int id) {
        this.id =+1;
        this.descripcion = descripcion;
        Status = "todo";
        this.fechaCreacion = aplicarFecha();
        this.actualizadoen = fechaCreacion;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getActualizadoen() {
        return actualizadoen;
    }
    public void setActualizadoen() {
        this.actualizadoen = aplicarFecha();

    }
    public String list() {
        return "ID: " + id + ", Descripcion: " + descripcion + ", Status: " + Status + ", Fecha de Creacion: " + fechaCreacion + ", Actualizado en: " + actualizadoen;
    }

    @Override
    public String toString() {
        return "Tareas{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", Status='" + Status + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", actualizadoen='" + actualizadoen + '\'' +
                '}';
    }
}
