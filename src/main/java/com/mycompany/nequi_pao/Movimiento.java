
package com.mycompany.nequi_pao;

import java.util.Date;

public class Movimiento {
    private String tipo; // "Consignacion" o "Retiro"
    private double monto;
    private Date fecha;

    public Movimiento(String tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = new Date(); // fecha actual
    }

    public String getTipo() { return tipo; }
    public double getMonto() { return monto; }
    public Date getFecha() { return fecha; }
}
