package com.mycompany.nequi_pao;

import java.util.ArrayList;
import java.util.List;
    //hereda por palabra extends
public class CuentaNequi extends Cuenta {
    private List<Movimiento> movimientos;

    public CuentaNequi(String numeroCuenta, double saldo) {
        super(numeroCuenta, saldo);
        movimientos = new ArrayList<>();
    }

    @Override
    public void retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            movimientos.add(new Movimiento("Retiro", monto));
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Fondos insuficientes.");
        }
    }

    @Override
    public void consignar(double monto) {
        saldo += monto;
        movimientos.add(new Movimiento("Consignacion", monto));
        System.out.println("Consignacion exitosa. Nuevo saldo: " + saldo);
    }
    //
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }
}
