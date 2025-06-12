package org.example;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto() {
    }

    public Producto(String id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public void mostrarInformacion(){
        System.out.println("ID DEL PRODUCTO: " + this.id);
        System.out.println("NOMBRE DEL PRODUCTO: " + this.nombre);
        System.out.println("PRECIO DEL PRODUCTO: " + this.precio);
        System.out.println("STOCK DEL PRODUCTO: " + this.stock);
    }

    public boolean reducirStock(int stock){
        if (stock > this.stock){
            System.out.println("Stock no disponible. Ingrese una cantidad valida menor o igual a  ( " + this.stock + " ). Intente nuevamente");
            return false;
        }else{
            this.stock -= stock;
            System.out.println("Operación Exitosa");
            return true;
        }
    }

    public boolean aumentarStock(int cantidad){
        if (cantidad < 0){
            System.out.println("No se puede aumentar una cantidad negativa");
            return false;
        }else{
            this.stock += cantidad;
            System.out.println("Operación Exitosa");
            return true;
        }
    }

    //Getters Y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
