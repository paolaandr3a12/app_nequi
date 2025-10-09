package com.mycompany.nequi_pao;
import java.util.Scanner;

public class PromocionesNequi {
    private final double saldoMinimo;
    private final double bono;

    public PromocionesNequi(double saldoMinimo, double bono) {
        this.saldoMinimo = saldoMinimo;
        this.bono = bono;
    }

    public void aplicarPromocion(Cliente cliente) {
        if (cliente.getCuenta().getSaldo() >= saldoMinimo) {
            cliente.getCuenta().consignar(bono);
            System.out.println(" Promoción aplicada: recibió un bono de " + bono);
        } else {
            System.out.println("No cumple el saldo mínimo de " + saldoMinimo + " para esta promoción.");
        }
    }

    // Método estático para que el cliente elija su promoción
    public static PromocionesNequi elegirPromocion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Elija una promoción que desee:");
        System.out.println("1. Bono de $2000 si tiene más de $10000");
        System.out.println("2. Bono de $5000 si tiene más de $20000");
        System.out.print("Seleccione: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1 -> {
                return new PromocionesNequi(10000, 2000);
            }
            case 2 -> {
                return new PromocionesNequi(20000, 5000);
            }
            default -> {
                System.out.println("Opción inválida, se asigna promoción 1 por defecto.");
                return new PromocionesNequi(10000, 2000);
            }
        }
    }
}

     
    
