package edu.upb.lp.proyectoPrograII;

public class Caballo{
    private String nombre;
    private int posicion;
    private int carril;
    private boolean tieneHabilidad;

    public abstract void usarHabilidad(){

    }

    public Caballo(String nombre, int posicion, int carril){
        this.nombre = nombre;
        this.posicion = posicion;
        this.carril = carril;
    }

    public void avanzar(){

    }

    public void ganar(){

    }
}
}
