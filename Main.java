package tareal_alexurbina;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pruebas del Sistema Bancario");
        System.out.println("");

        CuentaBancaria cuentaGen = new CuentaBancaria("20262001077", "Alex Urbina", 5000.0);

        // cuentaGen.saldo = 50000;
        System.out.println("1. Prueba de encapsulamiento: La linea que intentaba modificar 'cuentaGen.saldo' directamente esta comentada porque genera error al ser privado.");

        System.out.println("");
        System.out.println("2. Acceso a atributos publicos:");
        System.out.println("Titular: " + cuentaGen.titular);
        System.out.println("Numero de Cuenta: " + cuentaGen.numeroCuenta);

        System.out.println("");
        System.out.println("3. Prueba de Cuenta de Ahorro:");
        CuentaAhorro cuentaAhorro = new CuentaAhorro("20262001077", "Alex Urbina", 3000.0, 5.0);
        cuentaAhorro.mostrarDatos();
        
        System.out.println("");
        System.out.println("Retiro 1:");
        cuentaAhorro.retirarConComision(500.0);
        
        System.out.println("");
        System.out.println("Retiro 2:");
        cuentaAhorro.retirarConComision(500.0);
        
        System.out.println("");
        System.out.println("Retiro 3:");
        cuentaAhorro.retirarConComision(500.0);
        
        System.out.println("");
        System.out.println("Retiro 4:");
        cuentaAhorro.retirarConComision(500.0);

        System.out.println("");
        System.out.println("4. Rendimiento de Ahorro:");
        cuentaAhorro.aplicarInteresMensual();
        System.out.println("Saldo actualizado: L. " + String.format("%.2f", cuentaAhorro.getSaldo()));

        System.out.println("");
        System.out.println("5. Prueba de Cuenta Corriente:");
        CuentaCorriente cuentaEmpresa = new CuentaCorriente("20262001077", "Alex Urbina", 1000.0, "AlexCorp", 5000.0);
        cuentaEmpresa.mostrarDatos();
        System.out.println("Limite de Sobregiro: L. " + String.format("%.2f", cuentaEmpresa.getLimiteSobregiro()));
        
        System.out.println("");
        System.out.println("Intentando retirar L. 3500:");
        cuentaEmpresa.retirarConSobregiro(3500.0);
        System.out.println("Saldo actual: L. " + String.format("%.2f", cuentaEmpresa.getSaldo()));
        System.out.println("Sobregiro utilizado: L. " + String.format("%.2f", cuentaEmpresa.getSobregiroUtilizado()));

        System.out.println("");
        System.out.println("6. Amortizacion de deuda:");
        cuentaEmpresa.pagarSobregiro(2000.0);
        System.out.println("Estado final -> Sobregiro: L. " + String.format("%.2f", cuentaEmpresa.getSobregiroUtilizado()) + " | Saldo: L. " + String.format("%.2f", cuentaEmpresa.getSaldo()));

        System.out.println("");
        System.out.println("Ejecucion finalizada.");
    }
}