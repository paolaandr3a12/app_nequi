package com.mycompany.nequi_pao;

// Clase abstracta -> SUPERCLASE
public abstract class Cuenta {
    protected String numeroCuenta;
    protected double saldo;
    //constructor
    public Cuenta(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
    //metodos
    public abstract void retirar(double monto);
    public abstract void consignar(double monto);

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }
}