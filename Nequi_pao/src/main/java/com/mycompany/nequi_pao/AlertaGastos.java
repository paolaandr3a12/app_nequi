package com.mycompany.nequi_pao;

public class AlertaGastos {
    private double limite;
    //constructor
    public AlertaGastos (double limite) {
        this.limite = limite;
    }
    //metodo
    public void setLimite(double limite) {
        this.limite = limite;
    }
    //metodo
    public void verificarSaldo(Cuenta cuenta) {
        if (cuenta.getSaldo() < limite) {
            System.out.println("️ Alerta: su saldo está por debajo del límite de " + limite);
        } else {
            System.out.println(" Su saldo está por encima del límite de " + limite);
        }
    }
}