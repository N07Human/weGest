/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wegestLucas;

import java.util.*;

public class Pedido {

    private String codPedido;
    private String codCliente;
    private String tipoPedido;
    private String fechaEntrega;
    private String estadoPedido;
    private String codMaquina;
    private String cantidadPedido;
    private int tiempoProceso;
    private int tiempoDisponible;
    private int pedidoHecho;
    private int pedidoEnCola;
    private double prioridad;
    private Date tiempoHistorico;
    private Date pedidoTerminado; // Date en la cual el pedido termino de procesar y paso a TRM.
    private double horaProcesoTermino; // Hora que se demoro en terminar el proceso.
    public double velocidadPedido;

    public Pedido(String codPedido, String codCliente, String tipoPedido, String cantidadPedido, String estadoPedido, String codMaquina, String fechaEntrega, Date tiempoHistorico) {
        this.codPedido = codPedido;
        this.codCliente = codCliente;
        this.tipoPedido = tipoPedido;
        this.cantidadPedido = cantidadPedido;
        this.estadoPedido = estadoPedido;
        this.fechaEntrega = fechaEntrega;
        this.codMaquina = codMaquina;
        this.tiempoHistorico = tiempoHistorico;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String numeroPedido) {
        this.codPedido = numeroPedido;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codigoCliente) {
        this.codCliente = codigoCliente;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getCantidadPedido() {
        return cantidadPedido;
    }

    public void setCantidadPedido(String cantidadPedido) {
        this.cantidadPedido = cantidadPedido;
    }

    public int getTiempoProceso() {
        return tiempoProceso;
    }

    public void setTiempoProceso(int tiempoProceso) {
        this.tiempoProceso = tiempoProceso;
    }

    public int getTiempoDisponible() {
        return tiempoDisponible;
    }

    public void setTiempoDisponible(int tiempoDisponible) {
        this.tiempoDisponible = tiempoDisponible;
    }

    public int getPedidoHecho() {
        return pedidoHecho;
    }

    public void setPedidoHecho(int pedidoHecho) {
        this.pedidoHecho = pedidoHecho;
    }

    public int getPedidoEnCola() {
        return pedidoEnCola;
    }

    public void setPedidoEnCola(int pedidoEnCola) {
        this.pedidoEnCola = pedidoEnCola;
    }

    public double getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(double prioridad) {
        this.prioridad = prioridad;
    }

    public String getCodMaquina() {
        return codMaquina;
    }

    public Date getTiempoHistorico() {
        return tiempoHistorico;
    }

    public void setTiempoHistorico(Date t) {
        tiempoHistorico = t;
    }

    public Date getPedidoTerminado() {
        return pedidoTerminado;
    }

    public void setPedidoTerminado(Date fin) {
        pedidoTerminado = fin;
    }

    public double getHorasProcesoTermino() {
        return horaProcesoTermino;
    }

    public void setHorasProcesoTermino(double hora) { // En el excel hay una celda que dice cuanto se demoro en terminar.
        horaProcesoTermino = hora;
    }
    public double getVelocidadPedido(){
        return velocidadPedido;
    }
    public void setVelocidadPedido(double velocidadNueva){
        velocidadPedido=velocidadNueva;
    }

}
