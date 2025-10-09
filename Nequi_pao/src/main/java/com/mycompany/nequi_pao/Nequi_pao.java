package com.mycompany.nequi_pao;

import java.util.Scanner;

public class Nequi_pao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear bancos
        Banco bbva = new Banco("BBVA Colombia");
        Banco falabella = new Banco("Banco Falabella");
        Banco bancolombia = new Banco("Bancolombia");

        System.out.println("Registro de Cliente en Nequi");
        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese su documento: ");
        String documento = sc.nextLine();
        System.out.print("Ingrese saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        // Selección de banco
        System.out.println("\nSeleccione su banco:");
        System.out.println("1. BBVA Colombia");
        System.out.println("2. Banco Falabella");
        System.out.println("3. Bancolombia");
        int opcionBanco = sc.nextInt();

        Banco bancoSeleccionado;
        switch (opcionBanco) {
            case 1: bancoSeleccionado = bbva; break;
            case 2: bancoSeleccionado = falabella; break;
            case 3: bancoSeleccionado = bancolombia; break;
            default:
                System.out.println("Opcion invalida. Se asigna BBVA por defecto.");
                bancoSeleccionado = bbva;
        }

        // Crear cliente
        Cliente cliente = new Cliente(nombre, documento, "NEQ-" + documento, saldoInicial);
        bancoSeleccionado.agregarCliente(cliente);

        // Asociar cajero con banco y mostrar menú
        Cajero cajero = new Cajero(bancoSeleccionado);
        cajero.mostrarMenu(cliente);
    }
}