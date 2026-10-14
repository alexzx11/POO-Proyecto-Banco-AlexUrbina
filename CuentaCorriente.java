package tareal_alexurbina;

public class CuentaCorriente extends CuentaBancaria {

    public String nombreEmpresa;
    private double limiteSobregiro;
    private double sobregiroUtilizado;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, double limiteSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
        this.sobregiroUtilizado = 0.0;
    }

    public double getLimiteSobregiro() {
        return this.limiteSobregiro;
    }

    public double getSobregiroUtilizado() {
        return this.sobregiroUtilizado;
    }

    public void retirarConSobregiro(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a retirar debe ser mayor a cero.");
            return;
        }

        double saldoActual = getSaldo();
        double sobregiroDisponible = this.limiteSobregiro - this.sobregiroUtilizado;

        if (monto <= saldoActual) {
            super.retirar(monto);
        } else if (monto <= (saldoActual + sobregiroDisponible)) {
            double deficit = monto - saldoActual;
            double deficitConRecargo = deficit * 1.03;

            super.retirar(saldoActual);
            this.sobregiroUtilizado += deficitConRecargo;
            
            System.out.println("Retiro con sobregiro exitoso.");
            System.out.println("Se uso el saldo completo y L. " + String.format("%.2f", deficit) + " de sobregiro (con 3% de recargo = L. " + String.format("%.2f", deficitConRecargo) + ").");
            System.out.println("Sobregiro total utilizado: L. " + String.format("%.2f", this.sobregiroUtilizado));
        } else {
            System.out.println("Error: El monto excede el saldo disponible y el limite de sobregiro autorizado.");
        }
    }

    public void pagarSobregiro(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto para pagar el sobregiro debe ser mayor a cero.");
            return;
        }

        if (this.sobregiroUtilizado > 0) {
            if (monto <= this.sobregiroUtilizado) {
                this.sobregiroUtilizado -= monto;
                System.out.println("Se abonaron L. " + String.format("%.2f", monto) + " al sobregiro. Sobregiro restante: L. " + String.format("%.2f", this.sobregiroUtilizado));
            } else {
                double excedente = monto - this.sobregiroUtilizado;
                this.sobregiroUtilizado = 0.0;
                System.out.println("Se pago todo el sobregiro. Sobregiro actual: L. 0.00");
                System.out.println("Abonando el excedente de L. " + String.format("%.2f", excedente) + " al saldo de la cuenta...");
                depositar(excedente);
            }
        } else {
            System.out.println("No hay deuda de sobregiro pendiente. El monto de L. " + String.format("%.2f", monto) + " se depositara directamente al saldo.");
            depositar(monto);
        }
    }
}