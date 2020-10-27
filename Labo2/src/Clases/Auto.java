package Clases;

import javax.swing.JOptionPane;

/**
 * @author Eber
 */
public class Auto {

    private String placa;
    private double velocidadActual;
    private double velocidadMaxima;
    private double velocidadMinima;
    private boolean estado;

    //Método Constructor por Defecto
    public Auto() {
        this.placa = "RD1234";
        this.velocidadActual = 0;
        this.velocidadMaxima = 150;
        this.velocidadMinima = 0;
        this.estado = false;
    }

    //Métodos de tipo SET y GET
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public void setVelocidadMinima(double velocidadMinima) {
        this.velocidadMinima = velocidadMinima;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getPlaca() {
        return (this.placa);
    }

    public double getVelocidadActual() {
        return (this.velocidadActual);
    }

    public double getVelocidadMaxima() {
        return (this.velocidadMaxima);
    }

    public double getVelocidadMinima() {
        return (this.velocidadMinima);
    }

    public boolean getEstado() {
        return (this.estado);
    }

    //Método Operacionales
    public String devolverEstadoDelAuto() {
        if (getEstado()) {
            return "ENCENDIDO";
        }
        return "APAGADO";
    }

    public void formarMensajeDeSalidaPorConsola(String mensaje) {
        int largo = mensaje.length();
        int i;
        System.out.print("+");
        for (i = 1; i <= largo; i++) {
            System.out.print("-");
        }
        System.out.println("+");

        System.out.println("¦" + mensaje + "¦");

        System.out.print("+");
        for (i = 1; i <= largo; i++) {
            System.out.print("-");
        }
        System.out.println("+");
        System.out.println("");
    }

    public void encenderAuto() {
        if (getEstado()) {
            formarMensajeDeSalidaPorConsola("El Auto YA ESTABA encendido");
        } else {
            setEstado(true);
            formarMensajeDeSalidaPorConsola("El Auto HA SIDO encendido con éxito");
        }
    }

    public void aumentarVelocidadAuto() {
        if (getEstado()) {
            String dato;
            int cantidad;
            try{
                dato = JOptionPane.showInputDialog("Velocidad Actual = "
                        + getVelocidadActual()
                        + "\nIngrese la cantidad a aumentar");
                cantidad = Integer.parseInt(dato);

                if (cantidad>getVelocidadActual()){
                    setVelocidadActual(getVelocidadActual() + cantidad);
                }else{
                    JOptionPane.showMessageDialog(null, "Velocidad máxima es 150");
                }

                formarMensajeDeSalidaPorConsola("Velocidad del Auto Actual = "
                        + getVelocidadActual());
            
            } catch (Exception exception) {
                System.out.println("Operación cancelada");
                dato = "";
            }
        } else {
            formarMensajeDeSalidaPorConsola("El Auto esta APAGADO");
        }
    }
    
    public void reducirVelocidadAuto() {
        if (getEstado()) {
            String dato;
            int cantidad;
            
            dato = JOptionPane.showInputDialog("Velocidad Actual = "
                    + getVelocidadActual()
                    + "\nIngrese la cantidad a reducir");
            cantidad = Integer.parseInt(dato);
            
            if (getVelocidadActual()>cantidad){
                setVelocidadActual(getVelocidadActual() - cantidad);
            }else{
                JOptionPane.showMessageDialog(null, "Usted no puede hacer semejante barbaridad", "Error", JOptionPane.ERROR_MESSAGE);
            }
               
            formarMensajeDeSalidaPorConsola("Velocidad del Auto Actual = "
                    + getVelocidadActual());
        } else {
            formarMensajeDeSalidaPorConsola("El Auto esta APAGADO");
        }
    }
    
    public void cargarTanqueGasolina(){
        if(!getEstado()){
            formarMensajeDeSalidaPorConsola("El tanque de gasolina ha sido cargado");
        }else{
            formarMensajeDeSalidaPorConsola("Por seguuridad primero apague el auto");

        }   
    }
    
    public void cargarTanqueAceite(){
        if(!getEstado()){
            formarMensajeDeSalidaPorConsola("El tanque de aceite ha sido cargado");            
        }else{
            formarMensajeDeSalidaPorConsola("Por seguuridad primero apague el auto");
        }
    }
    
    public void cambiarllanta(){
        if(!getEstado()){
            formarMensajeDeSalidaPorConsola("Las llantas han sido cambiadas");            
        }else{
            formarMensajeDeSalidaPorConsola("Por seguuridad primero apague el auto");
        }
    }
    
    public void detallesAuto() {
        String dato;
        
        if (getEstado()) {
            dato = "Encendido";
        }else{
            dato = "Apagado";
        }
            
        JOptionPane.showMessageDialog(null, "Condicion: " + dato 
                + "\nVelocidad del Auto Actual: " + getVelocidadActual()
                +"\nVelocidad Máxima: " + getVelocidadMaxima()
                +"\nPlaca: " + getPlaca());
    }
    
    public void apagarAuto() {
        if (!getEstado()) {
            formarMensajeDeSalidaPorConsola("El Auto YA ESTABA apagado");
        } else {
            setEstado(false);
            formarMensajeDeSalidaPorConsola("El Auto HA SIDO apagado con éxito");
        }
    }

    public void manejarTableroDeComnadosDelAuto() {
        String arregloDeOpciones[] = {
            "1. Encender Auto",
            "2. Aumentar velocidad",
            "3. Reducir velocidad",
            "4. Cargar Tanque de Gasolina",
            "5. Cargar Tanque de Aceite",
            "6. Mostrar Condiciones del Auto",
            "7. Cambiar llantas",
            "8. Apagar Auto",
            "9. Salir"
        };
        int opcion;

        do {
            System.out.println("******************************");
            System.out.println("* Tablero de Comando del Auto*");
            System.out.println("******************************");
            opcion = Base.pintarMenu(arregloDeOpciones);

            switch (opcion) {
                case 1:
                    encenderAuto();
                    break;
                case 2:
                    aumentarVelocidadAuto();
                    break;
                case 3:
                    reducirVelocidadAuto();
                    break;
                case 4:
                    cargarTanqueGasolina();
                    break;
                case 5:
                    cargarTanqueAceite();
                    break;
                case 6:
                    detallesAuto();
                    break;
                case 7:
                    cambiarllanta();
                    break;
                case 8:
                    apagarAuto();
                    break;
            }
        } while (opcion != arregloDeOpciones.length);
    }

    public static void main(String[] args) {

        Auto OBJ = new Auto();
        
        OBJ.manejarTableroDeComnadosDelAuto();

        }
}
