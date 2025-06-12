package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Supermercado sup1 = new Supermercado();
        Scanner scc = new Scanner(System.in);
        CarritoDeCompras carrito = new CarritoDeCompras();

        int opc;

        do{
            System.out.println("Menu Supermercado");
            System.out.println("[1] Manejar Productos");
            System.out.println("[2] Manejar Carrito");
            System.out.println("[0] Salir.");
            opc = scc.nextInt();

            switch(opc){
                case 1:
                    int opc2;
                    String id;
                    do{
                        System.out.println("Menu Manejo De Productos");
                        System.out.println("[1] Cargar Producto");
                        System.out.println("[2] Eliminar Producto");
                        System.out.println("[3] Aumentar Stock");
                        System.out.println("[4] Reducir Stock");
                        System.out.println("[5] Mostrar Productos Cargados");
                        System.out.println("[6] Buscar Producto");
                        System.out.println("[0] Salir.");
                        opc2 = scc.nextInt();

                        switch(opc2){
                            case 1:
                                scc.nextLine(); //Salto de linea para limpiar el buffer de memoria.
                                System.out.println("Ingrese el id del producto");
                                String idProducto = scc.nextLine();
                                System.out.println("Ingrese el nombre del producto");
                                String nombre = scc.nextLine();
                                System.out.println("Ingrese el precio del producto");
                                double precio = scc.nextDouble();
                                System.out.println("Ingrese el stock disponible del producto");
                                int stock = scc.nextInt();

                                Producto productito = new Producto(idProducto, nombre, precio, stock);
                                sup1.agregarProductos(productito);
                                break;

                            case 2:
                                scc.nextLine();
                                System.out.println("Ingrese el id del producto a eliminar");
                                id = scc.nextLine();
                                sup1.eliminarProducto(id);
                                break;

                            case 3:
                                //Cargar al carrito de compras
                                scc.nextLine();
                                System.out.println("Ingrese el id del producto a cargar al carrito");
                                id = scc.nextLine();
                                System.out.println("Ingrese la cantidad a cargar");
                                int cantidad = scc.nextInt();
                                carrito.agregarItem(sup1.buscarProducto(id), cantidad);
                                break;

                            case 4:
                                //Mostrar carrito
                                System.out.println("Total: " + carrito.calcularTotal());
                                carrito.mostrarCarrito();
                                break;

                            case 5:
                                sup1.mostrarInventario();
                                System.out.println("******************************************************");
                                break;

                            case 6:
                                scc.nextLine();
                                System.out.println("Ingrese el id del producto a buscar");
                                id = scc.nextLine();
                                System.out.println(sup1.buscarProducto(id));
                                break;

                            case 0:
                                //Usuario vuelve al menu anterior
                                break;

                            default:
                                break;
                        }

                    }while (opc2 != 0);
                    break;

                case 2:

                    break;

                case 3:
                    break;

                case 0:
                    //Salida del usuario.
                    break;

                default:
                    break;
            }
        }while (opc != 0);

    }
}