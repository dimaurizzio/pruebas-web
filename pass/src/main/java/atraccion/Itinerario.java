package atraccion;

import java.util.LinkedList;

public class Itinerario {

    private Integer id;
    private String nombre;
    private LinkedList<String> compras = new LinkedList<>();

    public Itinerario(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<String> getCompras() {
        return compras;
    }

    public void setCompras(LinkedList<String> compra) {
        this.compras = compra;
    }

    public void addCompra(String atraccion) {
        compras.add(atraccion);
    }

    @Override
    public String toString() {
        return "Itinerario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", compras=" + compras +
                '}';
    }
}
