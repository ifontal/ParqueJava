
/**
 * Write a description of class Parque here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;

public abstract class Parque {
    /**
     * Muestra el menú principal
     *
     */
    private static void mostrarMenu(){
        System.out.println("Escoja la opción deseada\n");
        System.out.println("1. Comprar entradas");
        System.out.println("2. Acceder al parque");
        System.out.println("3. Subirse a atracción");
        System.out.println("4. Mostrar estadísticas");
        System.out.println("5. Mostrar costes trabajadores");
        System.out.println("6. Cambiar atracciones funcionando");
        System.out.println("7. Salir");
    }
    
    /**
     * Muestra el menú principal
     *
     */
    public static void main(){
        int opcion, opcEntrada,opc, opcEstadistica, edad, contador, contadorEntrada;
        double altura;
        boolean esVip, comprarNiño = false, masClientes = false;
        String fecha, tipoEntrada;
        Entrada entrada;
        ArrayList<Entrada> arrayEntradas = FactoriaEntradas.getListaEnt();
        FactoriaAtracciones.constructorAtracciones();
        FactoriaTrabajadores.crearTrabajadores();
        Scanner sc = new Scanner(System.in);
        
        do{
            mostrarMenu();
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                System.out.println("¿Qué tipo de entrada desea?");
                System.out.println("1. Entrada general");
                System.out.println("2. Entrada tardes");
                System.out.println("3. Entrada laborables");
                System.out.println("4. Entrada familiar (tendrá que comprar como mínimo 4 entradas");
                opcEntrada = sc.nextInt();
                switch(opcEntrada){
                    case 1:
                    case 2:
                    case 3:
                    do {
                        System.out.println("¿Qué edad tiene usted?");
                        edad = sc.nextInt();
                        if(edad>12){
                            System.out.println("¿Cúal es su altura?");
                            altura = sc.nextDouble();
                            System.out.println("¿Desea suplemento vip? (S/N)");
                            esVip = false;
                            if(sc.next().toLowerCase().equals("s")){
                                esVip = true;
                            }
                            System.out.println("¿Para qué día desea la entrada? (aaaa-mm-dd)");
                            fecha = sc.next();
                            switch(opcEntrada) {
                                case 1:
                                tipoEntrada = "general";
                                break;
                                case 2:
                                tipoEntrada = "tardes";
                                break;
                                case 3:
                                tipoEntrada = "laborables";
                                break;
                                default:
                                tipoEntrada = "general";
                            }
                            entrada = FactoriaEntradas.getEntrada(tipoEntrada, esVip, fecha, edad, altura);
                            if(entrada != null) {
                                System.out.println("Su precio a pagar es de " + entrada.getPrecioEntrada());
                                arrayEntradas.add(entrada);
                                System.out.println("Va a acompañarle algún niño? (S/N)");
                                if(sc.next().toLowerCase().equals("s")){
                                    comprarNiño = true;
                                }
                            } else {
                                System.out.println("Los datos no son válidos");
                            }
                        } else if(comprarNiño){
                            System.out.println("¿Cúal es su altura?");
                            altura = sc.nextDouble();
                            System.out.println("¿Desea suplemento vip? (S/N)");
                            esVip = false;
                            if(sc.next().toLowerCase().equals("s")){
                                esVip = true;
                            }
                            System.out.println("¿Para qué día desea la entrada? (aaaa/mm/dd)");
                            fecha = sc.next();
                            entrada = FactoriaEntradas.getEntrada("general", esVip, fecha, edad, altura);
                            if (entrada != null) {
                                System.out.println("Su precio a pagar es de " + entrada.getPrecioEntrada());
                                arrayEntradas.add(entrada);
                                System.out.println("Va a haber más niños? (S/N)");
                                if(sc.next().toLowerCase().equals("n")){
                                    comprarNiño = false;
                                }
                            } else {
                                System.out.println("Los datos no son válidos");
                            }
                        } else{
                            System.out.println("Primero debe comprar la entrada un adulto");
                        }
                    } while (comprarNiño);
                    break;
                    case 4:
                    contador = 0;
                    masClientes = false;
                    while(contador < 4 || masClientes){
                        System.out.println("¿Cúal es su edad?");
                        edad = sc.nextInt();
                        if(edad>12){
                            System.out.println("¿Cúal es su altura?");
                            altura = sc.nextDouble();
                            System.out.println("¿Desea suplemento vip? (S/N)");
                            esVip = false;
                            if(sc.next().toLowerCase().equals("s")){
                                esVip = true;
                            }
                            System.out.println("¿Para qué día desea la entrada? (aaaa/mm/dd)");
                            fecha = sc.next();
                            entrada = FactoriaEntradas.getEntrada("general", esVip, fecha, edad, altura);
                            if(entrada != null){
                                arrayEntradas.add(entrada);
                                System.out.println("El precio de su entrada es de " + entrada.getPrecioEntrada());
                            } else {
                                System.out.println("Datos no válidos");
                            }
                            comprarNiño = true;
                            contador ++;
                        } else if(comprarNiño){
                            System.out.println("¿Cúal es su altura?");
                            altura = sc.nextDouble();
                            System.out.println("¿Desea suplemento vip? (S/N)");
                            esVip = false;
                            if(sc.next().toLowerCase().equals("s")){
                                esVip = true;
                            }
                            System.out.println("¿Para qué día desea la entrada? (aaaa-mm-dd)");
                            fecha = sc.next();
                            entrada = FactoriaEntradas.getEntrada("general", esVip, fecha, edad, altura);
                            if(entrada != null){
                                arrayEntradas.add(entrada);
                                System.out.println("El precio de su entrada es de " + entrada.getPrecioEntrada());
                            } else {
                                System.out.println("Datos no válidos");
                            }
                            contador ++;
                        }else{
                            System.out.println("Debe de haber como mínimo un adulto");
                        }
                        if(contador >= 4){
                            System.out.println("Desean comprar más entradas? (S/N)");
                            if(sc.next().toLowerCase().equals("s")){
                                masClientes = true;
                            } else{
                                masClientes = false;
                                comprarNiño = false;
                            }
                        }
                    }
                    break;
                    default:
                    System.out.println("Opción no válida");
                }
                break;
                case 2:
                if(!arrayEntradas.isEmpty()){
                    System.out.println("\t\tLISTA DE ENTRADAS VENDIDAS");
                    contadorEntrada = 1;
                    for(Entrada entr: arrayEntradas){
                        System.out.println("Entrada " + contadorEntrada + " para la fecha " + entr.getFechaInicio());
                        contadorEntrada++;
                    }
                    System.out.println("Qué entrada desea usar?");
                    opcEntrada = sc.nextInt();
                    if(AccesoParque.entradaParque(arrayEntradas.get(opcEntrada-1))){
                        arrayEntradas.remove(opcEntrada-1);
                        System.out.println("El usuario ha entrado al parque");
                    } else{
                        System.out.println("La entrada no es válida en este momento");
                    }
                } else{
                    System.out.println("No hay entradas");
                }
                break;
                case 3:
                SubirseAtraccion.subiseAtraccion();
                break;
                case 4:
                System.out.println("Qué tipo de estadísticas desea que se le muestren?");
                System.out.println("1. Estadísticas de las atracciones");
                System.out.println("2. Estadísticas de los clientes");
                opcEstadistica = sc.nextInt();
                if(opcEstadistica == 1){
                    System.out.println("Desea las estadísticas diarias, semanales, mensuales o anuales?");
                    System.out.println("Introduzca dia, semana, mes o año");
                    String tipoEstadistica = sc.next().toLowerCase();
                    AccesoParque.mostrarEstadistica(tipoEstadistica);
                } else if(opcEstadistica == 2){
                    System.out.println("Desea las estadísticas de clientes y su media diarias, semanales, mensuales o anuales?");
                    System.out.println("Introduzca dia, semana, mes o año");
                    String tipoEstadistica = sc.next().toLowerCase();
                    AccesoParque.estadisticasAtracciones(tipoEstadistica);
                }
                break;
                case 5:
                System.out.println("Desea las estadísticas del sueldo de los trabajadores diarias, semanales, mensuales o anuales?");
                System.out.println("Introduzca dia, semana, mes o año");
                String tipoSueldo = sc.next().toLowerCase();
                System.out.println("El gasto de personal por " + tipoSueldo + " es de " +
                FactoriaTrabajadores.gastoDePersonal(tipoSueldo));
                break;
                case 6:
                System.out.println("Desea activar o desactivar las atracciones?");
                System.out.println("1. Activar");
                System.out.println("2. Desactivar");
                System.out.println("3. Ver las atracciones activas");
                opc = sc.nextInt();
                if(opc == 1){
                    AtraccionesFuncionando.activarAtracciones();
                } else if(opc == 2){
                    AtraccionesFuncionando.desactivarAtracciones();
                } else if(opc == 3){
                    AtraccionesFuncionando.verAtraccionesActivas();
                } else{
                    System.out.println("Opción no válida");
                }
                break;
                case 7:
                System.out.println("Adiós y gracias por su visita");
                break;
                default:
                System.out.println("Opción no válida");
            }
        } while(opcion != 7);
    }
}
