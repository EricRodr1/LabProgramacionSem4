package tiendajava;

import java.util.Scanner;

public class TiendaJava {

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter("\n");

        int azucar = 10, avena = 10, trigo = 10, maiz = 10;
        float efectivoCaja = 0.0f;
        int ventasRealizadas = 0;
        int comprasRealizadas = 0;
        float totalVentas = 0.0f;
        float totalCompras = 0.0f;
        float ganancia = 0.0f;
        int cantidadAzucarVendida = 0;
        int cantidadAvenaVendida = 0;
        int cantidadTrigoVendida = 0;
        int cantidadMaizVendida = 0;
        int cantidadTotalVendida = 0;
        String productoEstrella = "";

        int op = 0;

        do {
            System.out.println("\n**** MENU ****");
            System.out.println("1) Abrir Caja");
            System.out.println("2) Ventas");
            System.out.println("3) Compras");
            System.out.println("4) Reportes");
            System.out.println("5) Cierre de caja");
            System.out.println("6) Salir");
            System.out.println("===========================");
            System.out.print("Por favor ingrese una opcion: ");
            op = lea.nextInt();

            if (op > 6 || op < 1) {
                System.out.println("Opcion no valida!!!");
            } else {
                switch (op) {
                    case 1:
                        System.out.print("Por favor ingrese la cantidad de efectivo para abrir la caja: ");
                        float efectivo = lea.nextFloat();

                        if (efectivo <= 0) {
                            System.out.println("El monto debe ser positivo.");
                        } else {
                            efectivoCaja += efectivo;
                            System.out.println("La caja se ha abierto con Lps. " + efectivoCaja);
                        }
                        break;

                    case 2:
                        if (efectivoCaja <= 0) {
                            System.out.println("No hay efectivo suficiente, por favor abra caja!!!");
                            break;
                        }

                        boolean validacion = false;
                        String tipo = "";
                        while (!validacion) {
                            System.out.print("Ingrese tipo de cliente: ");
                            tipo = lea.next();
                            if ((tipo.equals("a") || tipo.equals("A")) ||
                                (tipo.equals("b") || tipo.equals("B")) ||
                                (tipo.equals("c") || tipo.equals("C"))) {
                                validacion = true;
                            } else {
                                System.out.println("Opcion no valida!!!");
                            }
                        }

                        String facturaDetalle = "";
                        double subtotalFactura = 0;
                        boolean compra = false;
                        while (!compra) {
                            System.out.print("Ingrese el codigo del producto: ");
                            int cod = lea.nextInt();
                            String nombreProd = "";
                            double precioProd = 0;
                            boolean puedeComprar = false;

                            // Validar si el cliente puede comprar ese producto
                            if (((tipo.equals("a") || tipo.equals("A")) && (cod == 1 || cod == 2 || cod == 3 || cod == 4)) ||
                                ((tipo.equals("b") || tipo.equals("B")) && (cod == 1 || cod == 2 || cod == 3)) ||
                                ((tipo.equals("c") || tipo.equals("C")) && (cod == 4))) {
                                puedeComprar = true;
                            }

                            // Asignar nombre y precio
                            if (cod == 1) {
                                nombreProd = "Azucar";
                                precioProd = 45;
                            } else if (cod == 2) {
                                nombreProd = "Avena";
                                precioProd = 50;
                            } else if (cod == 3) {
                                nombreProd = "Trigo";
                                precioProd = 50;
                            } else if (cod == 4) {
                                nombreProd = "Maiz";
                                precioProd = 50;
                            } else {
                                puedeComprar = false; // Código no válido
                            }

                            boolean ventaValida = false;
                            int kg = 0;

                            if (puedeComprar) {
                                System.out.println("===============");
                                System.out.println("=" + nombreProd + " " + precioProd + "lps.=");
                                System.out.println("===============");
                                System.out.print("Ingrese los kilogramos: ");
                                kg = lea.nextInt();

                                // Validar stock suficiente
                                if ((cod == 1 && azucar >= kg) ||
                                    (cod == 2 && avena >= kg) ||
                                    (cod == 3 && trigo >= kg) ||
                                    (cod == 4 && maiz >= kg)) {
                                    ventaValida = true;
                                } else {
                                    System.out.println("No hay suficiente stock de " + nombreProd + " para la venta.");
                                }
                            } else {
                                System.out.println("NO PUEDE COMPRAR DICHO PRODUCTO");
                            }

                            if (ventaValida) {
                                // Actualizar stock y totales vendidos
                                if (cod == 1) {
                                    azucar -= kg;
                                    cantidadAzucarVendida += kg;
                                }
                                if (cod == 2) {
                                    avena -= kg;
                                    cantidadAvenaVendida += kg;
                                }
                                if (cod == 3) {
                                    trigo -= kg;
                                    cantidadTrigoVendida += kg;
                                }
                                if (cod == 4) {
                                    maiz -= kg;
                                    cantidadMaizVendida += kg;
                                }

                                double subtotal = kg * precioProd;
                                subtotalFactura += subtotal;

                                // Guardar detalle para factura
                                facturaDetalle += "\nProducto: " + nombreProd + " | Kg: " + kg + " | Precio U: " + precioProd + " | Subtotal: " + subtotal;
                            }
                            // Siempre preguntar si desea agregar otro producto (sin saltar ciclo)
                            System.out.print("¿Desea comprar otro producto? (si/no): ");
                            String sn = lea.next();
                            if (sn.equalsIgnoreCase("no")) {
                                compra = true;
                            }
                        }

                        System.out.println("\n----------- FACTURA -----------");
                        System.out.println(facturaDetalle);
                        System.out.println("Subtotal: " + subtotalFactura + " lps.");

                        double descuento = 0;
                        if (subtotalFactura >= 1000 && subtotalFactura <= 5000) {
                            descuento = subtotalFactura * 0.05;
                        } else if (subtotalFactura > 5000) {
                            descuento = subtotalFactura * 0.10;
                        }
                        if (descuento > 0) {
                            System.out.println("Descuento aplicado: -" + descuento + " lps.");
                        }
                        double subtotalConDesc = subtotalFactura - descuento;
                        double impuesto = subtotalConDesc * 0.07;
                        double totalPagar = subtotalConDesc + impuesto;

                        System.out.println("Impuesto (7%): " + impuesto + " lps.");
                        System.out.println("TOTAL A PAGAR: " + totalPagar + " lps.");
                        System.out.println("-------------------------------");

                        efectivoCaja += totalPagar;
                        totalVentas += totalPagar;
                        ventasRealizadas++;
                        System.out.println("Efectivo en caja ahora: " + efectivoCaja + " lps.");
                        System.out.println("Stock restante - Azucar: " + azucar + "kg, Avena: " + avena + "kg, Trigo: " + trigo + "kg, Maiz: " + maiz + "kg");
                        System.out.println("Regresando a MENU PRINCIPAL...");
                        break;

                    case 3:
                        System.out.println("=== COMPRAS ===");
                        boolean proveedorValido = false;
                        String tipoProv = "";
                        while (!proveedorValido) {
                            System.out.print("Ingrese tipo de proveedor (A/B/C): ");
                            tipoProv = lea.next();
                            if ((tipoProv.equals("A") || tipoProv.equals("a")) ||
                                (tipoProv.equals("B") || tipoProv.equals("b")) ||
                                (tipoProv.equals("C") || tipoProv.equals("c"))) {
                                proveedorValido = true;
                            } else {
                                System.out.println("Opcion no valida!!!");
                            }
                        }

                        System.out.print("Ingrese el código del producto a comprar: ");
                        int codProv = lea.nextInt();
                        boolean puedeComprarProv = false;
                        String nombreProdProv = "";
                        float precioCompra = 0;

                        if (((tipoProv.equals("A") || tipoProv.equals("a")) && (codProv == 1 || codProv == 4)) ||
                            ((tipoProv.equals("B") || tipoProv.equals("b")) && (codProv == 2 || codProv == 3)) ||
                            ((tipoProv.equals("C") || tipoProv.equals("c")) && (codProv == 2))) {
                            puedeComprarProv = true;
                        }

                        if (codProv == 1) {
                            nombreProdProv = "Azucar";
                            precioCompra = 25;
                        } else if (codProv == 2) {
                            nombreProdProv = "Avena";
                            if ((tipoProv.equals("B") || tipoProv.equals("b")) || (tipoProv.equals("C") || tipoProv.equals("c"))) {
                                precioCompra = 20;
                            } else {
                                precioCompra = 25;
                            }
                        } else if (codProv == 3) {
                            nombreProdProv = "Trigo";
                            precioCompra = 30;
                        } else if (codProv == 4) {
                            nombreProdProv = "Maiz";
                            precioCompra = 18;
                        } else {
                            puedeComprarProv = false;
                        }

                        if (puedeComprarProv) {
                            System.out.print("Ingrese la cantidad en kilogramos a comprar: ");
                            int kgProv = lea.nextInt();
                            float totalCompra = kgProv * precioCompra;

                            if (efectivoCaja >= totalCompra) {
                                if (codProv == 1) azucar += kgProv;
                                if (codProv == 2) avena += kgProv;
                                if (codProv == 3) trigo += kgProv;
                                if (codProv == 4) maiz += kgProv;

                                efectivoCaja -= totalCompra;
                                comprasRealizadas++;
                                totalCompras += totalCompra;

                                System.out.println("Compra realizada exitosamente:");
                                System.out.println("Producto: " + nombreProdProv);
                                System.out.println("Precio Compra: Lps. " + precioCompra);
                                System.out.println("Cantidad: " + kgProv + " kg");
                                System.out.println("Total Compra: Lps. " + totalCompra);
                                System.out.println("Efectivo restante en caja: Lps. " + efectivoCaja);
                                System.out.println("Stock actualizado - Azucar: " + azucar + "kg, Avena: " + avena + "kg, Trigo: " + trigo + "kg, Maiz: " + maiz + "kg");
                                System.out.println("Regresando a MENU PRINCIPAL...");
                            } else {
                                System.out.println("No se puede pagar compra. Efectivo insuficiente en caja.");
                            }
                        } else {
                            System.out.println("Proveedor NO vende dicho producto.");
                        }
                        break;

                    case 4:
                        System.out.println("**** REPORTES ****");
                        System.out.println("Cantidad actual en Caja: Lps. " + efectivoCaja);
                        System.out.println("Numero de ventas realizadas: " + ventasRealizadas);
                        System.out.println("Numero de compras realizadas: " + comprasRealizadas);
                        System.out.println("Volumen total de ventas: Lps. " + totalVentas);
                        System.out.println("Volumen total de compras: Lps. " + totalCompras);

                        ganancia = totalVentas - totalCompras;
                        System.out.println("Margen de ganancia: Lps. " + ganancia);

                        float promedioVentas = (ventasRealizadas > 0) ? totalVentas / ventasRealizadas : 0;
                        float promedioCompras = (comprasRealizadas > 0) ? totalCompras / comprasRealizadas : 0;
                        System.out.println("Valor medio de ventas: Lps. " + promedioVentas);
                        System.out.println("Valor medio de compras: Lps. " + promedioCompras);

                        cantidadTotalVendida = cantidadAzucarVendida + cantidadAvenaVendida + cantidadTrigoVendida + cantidadMaizVendida;
                        if (cantidadTotalVendida == 0) {
                            productoEstrella = "Ninguno";
                        } else if (cantidadAzucarVendida >= cantidadAvenaVendida && cantidadAzucarVendida >= cantidadTrigoVendida && cantidadAzucarVendida >= cantidadMaizVendida) {
                            productoEstrella = "Azúcar";
                        } else if (cantidadAvenaVendida >= cantidadTrigoVendida && cantidadAvenaVendida >= cantidadMaizVendida) {
                            productoEstrella = "Avena";
                        } else if (cantidadTrigoVendida >= cantidadMaizVendida) {
                            productoEstrella = "Trigo";
                        } else {
                            productoEstrella = "Maíz";
                        }
                        System.out.println("Producto estrella: " + productoEstrella);
                        break;

                    case 5:
                        System.out.println("=== CIERRE DE CAJA ===");
                        System.out.println("Total efectivo en caja: Lps. " + efectivoCaja);
                        System.out.print("¿Cuanto efectivo desea depositar en el banco? (máx 60%): ");
                        float maxDeposito = efectivoCaja * 0.6f;
                        System.out.println("El maximo permitido a depositar es: Lps. " + maxDeposito);
                        float aDepositar = lea.nextFloat();
                        if (aDepositar > maxDeposito) {
                            System.out.println("No puede depositar mas del 60%. Se depositara el máximo permitido.");
                            aDepositar = maxDeposito;
                        }
                        efectivoCaja -= aDepositar;
                        System.out.println("Efectivo depositado en el banco: Lps. " + aDepositar);
                        System.out.println("Efectivo restante en caja: Lps. " + efectivoCaja);
                        ventasRealizadas = 0;
                        comprasRealizadas = 0;
                        totalVentas = 0;
                        totalCompras = 0;
                        ganancia = 0;
                        cantidadAzucarVendida = 0;
                        cantidadAvenaVendida = 0;
                        cantidadTrigoVendida = 0;
                        cantidadMaizVendida = 0;
                        cantidadTotalVendida = 0;
                        productoEstrella = "";
                        System.out.println("La caja ha sido cerrada. TODOS los contadores han sido REINICIADOS.");
                        System.out.println("Debe abrir la caja para poder operar de nuevo.");
                        break;

                    case 6:
                        System.out.println("Hasta luego!");
                        break;
                }
            }
        } while (op != 6);
    }
}
