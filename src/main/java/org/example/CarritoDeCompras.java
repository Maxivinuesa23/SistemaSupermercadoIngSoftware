package org.example;

import java.util.ArrayList;

public class CarritoDeCompras {
    ArrayList<ItemCarrito> items = new ArrayList<>();

    public boolean agregarItem(Producto p, int cantidad){
        try{
            if (p == null){
                return false;
            }

            if (cantidad <= 0){
                return false;
            }

            if (p.getStock() < cantidad){
                System.out.println("No hay suficiente Stock");
                return false;
            }

            ItemCarrito itemExistente = null;

            for (ItemCarrito item : items) {
                if (item.getProducto().getId().equals(p.getId())){
                    itemExistente = item;
                    break;
                }
            }

            if (itemExistente != null){
                itemExistente.setCantidad(itemExistente.getCantidad() + cantidad);
                p.reducirStock(cantidad);
                return true;
            }else{
                ItemCarrito nuevoItem = new ItemCarrito(p, cantidad);
                items.add(nuevoItem);
                p.reducirStock(cantidad);
                System.out.println("Producto agregado exitosamente.");
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean eliminarItem(String idProducto){
        for (ItemCarrito item : items){
            if (item.getProducto().getId() == idProducto){
                System.out.println("Producto encontrado, eliminandolo del carrito");
                item.getProducto().aumentarStock(item.getCantidad());
                items.remove(item);
                break;
            }else{
                return false;
            }
        }
        return true;
    }

    public void vaciarCarrito(){
        items.clear();
    }

    public double calcularTotal(){
        double total = 0;
        for (ItemCarrito item : items){
            total += item.calcularSubtotal(item.getCantidad());
        }
        return total;
    }

    public void mostrarCarrito(){
        System.out.println("******************************************************");
        for (ItemCarrito item : items){
            System.out.println("Producto: " + item.getProducto().getNombre());
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("\n");
        }
        System.out.println("******************************************************");
    }
}
