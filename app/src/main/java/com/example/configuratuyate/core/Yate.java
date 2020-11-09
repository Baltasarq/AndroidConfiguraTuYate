package com.example.configuratuyate.core;

public class Yate {

    public Yate()
    {
        this.setMotor( true );
        this.setRadar( true );
        this.setNombre( "La niña" );
    }

    public boolean isMotor() {
        return motor;
    }

    public void setMotor(boolean motor) {
        this.motor = motor;
    }

    public boolean isVelas() {
        return velas;
    }

    public void setVelas(boolean velas) {
        this.velas = velas;
    }

    public boolean isCamperizacion() {
        return camperizacion;
    }

    public void setCamperizacion(boolean camperizacion) {
        this.camperizacion = camperizacion;
    }

    public boolean isLancha() {
        return lancha;
    }

    public void setLancha(boolean lancha) {
        this.lancha = lancha;
    }

    public boolean isCalefaccion() {
        return calefaccion;
    }

    public void setCalefaccion(boolean calefaccion) {
        this.calefaccion = calefaccion;
    }

    public boolean isRadar() {
        return radar;
    }

    public void setRadar(boolean radar) {
        this.radar = radar;
    }

    public String toString()
    {
        StringBuilder toret = new StringBuilder();

        toret.append( "Yate " );
        toret.append( this.getNombre() );
        toret.append( " con:\n" );

        if ( this.isMotor() ) {
            toret.append( "motor\n" );
        }

        if ( this.isVelas() ) {
            toret.append( "velas\n" );
        }

        if ( this.isCamperizacion() ) {
            toret.append( "camperización\n" );
        }

        if ( this.isLancha() ) {
            toret.append( "lancha\n" );
        }

        if ( this.isCalefaccion() ) {
            toret.append( "calefacción\n" );
        }

        if ( this.isRadar() ) {
            toret.append( "radar" );
        }

        return toret.toString();
    }

    public boolean[] getOpciones()
    {
        boolean[] toret = new boolean[6];

        if ( this.isMotor() ) {
            toret[ 0 ] = true;
        }

        if ( this.isVelas() ) {
            toret[ 1 ] = true;
        }

        if ( this.isCamperizacion() ) {
            toret[ 2 ] = true;
        }

        if ( this.isLancha() ) {
            toret[ 3 ] = true;
        }

        if ( this.isCalefaccion() ) {
            toret[ 4 ] = true;
        }

        if ( this.isRadar() ) {
            toret[ 5 ] = true;
        }

        return toret;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private boolean motor;
    private boolean velas;
    private boolean camperizacion;
    private boolean lancha;
    private boolean calefaccion;
    private boolean radar;
    private String nombre;
}
