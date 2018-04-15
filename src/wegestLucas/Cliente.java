/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wegestLucas;

import java.util.ArrayList;

public abstract class Cliente {

    private String codigoCliente;
    private String razonSocial;
    private String direccion;
    private String telefono;
    private ArrayList<Pedido> pedidos;

    public Cliente(String codigoCliente, String razonSocial, String direccion, String telefono) {
        this.codigoCliente = codigoCliente;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pedidos = new ArrayList<>();
    }

    public abstract double getPrioridad();

}

