package tareal_alexurbina;

public class CuentaBancaria {

    public String numeroCuenta;
    public String titular;
    private double saldo;
    private int totalTransacciones;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        if (saldoInicial < 0) {
            this.saldo = 0.0;
        } else {
            this.saldo = saldoInicial;
        }
        this.totalTransacciones = 0;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getTotalTransacciones() {
        return this.totalTransacciones;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            this.totalTransacciones++;
            System.out.println("Deposito exitoso de L. " + String.format("%.2f", monto) + ". Nuevo saldo: L. " + String.format("%.2f", this.saldo));
        } else {
            System.out.println("Error: El monto a depositar debe ser mayor a cero.");
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && this.saldo >= monto) {
            this.saldo -= monto;
            this.totalTransacciones++;
            System.out.println("Retiro exitoso de L. " + String.format("%.2f", monto) + ". Saldo restante: L. " + String.format("%.2f", this.saldo));
            return true;
        } else {
            System.out.println("Error: Fondos insuficientes o monto invalido para retirar.");
            return false;
        }
    }

    public void mostrarDatos() {
        System.out.println("--- Datos de la Cuenta ---");
        System.out.println("Titular: " + this.titular);
        System.out.println("Numero de Cuenta: " + this.numeroCuenta);
        System.out.println("Saldo Actual: L. " + String.format("%.2f", this.saldo));
        System.out.println("Total de Transacciones: " + this.totalTransacciones);
    }
}