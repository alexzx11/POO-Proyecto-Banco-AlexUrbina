package tareal_alexurbina;

public class CuentaAhorro extends CuentaBancaria {

    public double tasaInteresAnual;
    private int retirosRealizadosMes;
    private double comisionPorExceso;

    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteresAnual = tasaInteresAnual;
        this.retirosRealizadosMes = 0;
        this.comisionPorExceso = 20.0;
    }

    public void retirarConComision(double monto) {
        if (this.retirosRealizadosMes >= 3) {
            double montoTotal = monto + this.comisionPorExceso;
            System.out.println("Aviso: Ha superado o alcanzado los 3 retiros mensuales. Se aplicara una comision de L. " + String.format("%.2f", this.comisionPorExceso));
            if (super.retirar(montoTotal)) {
                this.retirosRealizadosMes++;
                System.out.println("Retiro con comision realizado con exito. Retiros este mes: " + this.retirosRealizadosMes);
            }
        } else {
            if (super.retirar(monto)) {
                this.retirosRealizadosMes++;
                System.out.println("Retiro normal realizado sin comision. Retiros este mes: " + this.retirosRealizadosMes);
            }
        }
    }

    public void aplicarInteresMensual() {
        double interesMes = (getSaldo() * (this.tasaInteresAnual / 100)) / 12;
        System.out.println("Aplicando interes mensual de L. " + String.format("%.2f", interesMes));
        depositar(interesMes);
    }
}