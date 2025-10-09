package com.mycompany.nequi_pao;

import java.util.ArrayList;
import java.util.List;

// Agregación -> El banco puede tener clientes
//Si el banco deja de existir, los clientes pueden existir por separado (No dependen del banco)
public class Banco {
    private String nombreBanco; //Atributos
    private List<Cliente> clientes;

    public Banco(String nombreBanco) { //Constrcutor
        this.nombreBanco = nombreBanco;
        this.clientes = new ArrayList<>();
    }
    //metodo
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public String getNombreBanco() { return nombreBanco; }
    public List<Cliente> getClientes() { return clientes; }
}