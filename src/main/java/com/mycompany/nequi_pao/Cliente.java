package com.mycompany.nequi_pao;

// Composición -> Cliente tiene obligatoriamente una CuentaNequi
public class Cliente {
    //Atributos
    private String nombre;
    private String documento;
    private CuentaNequi cuenta;
    //constructor
    public Cliente(String nombre, String documento, String numeroCuenta, double saldoInicial) {
        this.nombre = nombre;
        this.documento = documento;
        //Aqui se crea la cuenta directamente
        this.cuenta = new CuentaNequi(numeroCuenta, saldoInicial);
    }
    //get y set
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public CuentaNequi getCuenta() { return cuenta; }

}