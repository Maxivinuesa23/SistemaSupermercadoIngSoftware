package org.example;

import java.util.HashMap;
import java.util.Map;

public class Supermercado {
    private Map<String, Producto> inventario;

    public Supermercado() {
        this.inventario = new HashMap<>();
    }

    public boolean agregarProductos(Producto p){
        try{
            inventario.put(p.getId(), p);
            System.out.println("Producto: " + p.getNombre() + " ingresado correctamente");
        }catch (Exception e){
            System.out.println("Error: " + e);
            return false;
        }
        return true;
    }

    public boolean eliminarProducto(String idProducto){
        try{
            inventario.remove(idProducto);
        }catch (Exception e){
            System.out.println("Error: " + e);
            return false;
        }
        return true;
    }

    public boolean mostrarInventario(){
        if (inventario.isEmpty()){
            System.out.println("Inventario Vacio.");
            return false;
        }else{
            for (Producto producto : inventario.values()){
                producto.mostrarInformacion();
            }
        }
        return true;
    }

    public Producto buscarProducto(String idProducto){
        try{
            return inventario.get(idProducto);
        }
        catch (Exception e) {
            System.out.println("Error interno o producto no encontrado.");
            return null;
        }
    }
}
