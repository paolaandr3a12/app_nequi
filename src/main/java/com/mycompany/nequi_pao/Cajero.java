package com.mycompany.nequi_pao;

import java.util.Scanner;

// Asociación -> El cajero se asocia a un banco
public class Cajero {
    private Banco bancoAsociado;

    public Cajero(Banco bancoAsociado) {
        this.bancoAsociado = bancoAsociado;
    }
   //Menu interactivo para manjear las operaciones del cajero
    public void mostrarMenu(Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n Cajero Nequi - " + bancoAsociado.getNombreBanco());
            System.out.println("Hola, Bienvenido a nuestro cajero nequi " + cliente.getNombre());
            System.out.println("1. Consultar saldo");
            System.out.println("2. Consignar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Configurar/verificar alerta de gastos");
            System.out.println("5. Elegir y aplicar promociones");
            System.out.println("6. Salir");
            
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            //switch como condicion para
            switch (opcion) {
                case 1 -> System.out.println("Su saldo actual es: " + cliente.getCuenta().getSaldo());
                case 2 -> {
                    System.out.print("Ingrese monto a consignar: ");
                    double consigna = sc.nextDouble();
                    cliente.getCuenta().consignar(consigna);
                }
                case 3 -> {
                    System.out.print("Ingrese monto a retirar: ");
                    double retiro = sc.nextDouble();
                    cliente.getCuenta().retirar(retiro);
                }
                case 4 -> {
                    System.out.print("Ingrese el límite de alerta de gastos: ");
                    double limite = sc.nextDouble();
                    
                    AlertaGastos alerta = new AlertaGastos(limite);  // 👈 crear instancia
                    alerta.verificarSaldo(cliente.getCuenta());
                }
                case 5 -> {
                    PromocionesNequi promoElegida = PromocionesNequi.elegirPromocion();
                    promoElegida.aplicarPromocion(cliente);
                }
                case 6 -> {
    FacturaSimple.generarFacturaPdf(cliente, bancoAsociado);
    System.out.println("Gracias por usar nuestra Nequi - " + bancoAsociado.getNombreBanco());
                }
            }
        } while (opcion != 4);
    }
}