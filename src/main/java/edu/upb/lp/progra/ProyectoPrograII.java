package edu.upb.lp.progra;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import edu.upb.lp.progra.adapterFiles.AndroidLibrary;

public class ProyectoPrograII {

    private AndroidLibrary lib;
    private Caballo[] caballos = new Caballo[5];
    private int turno = 0;
    private Random rnd = new Random();

    public ProyectoPrograII(AndroidLibrary lib) {
        this.lib = lib;
        for(int i=0;i<5;i++) caballos[i] = new Caballo("Caballo"+(i+1));
        caballos[0].habilidad="Doble Avance"; 
        caballos[1].habilidad="Retroceder Rival";
        caballos[2].habilidad="Doble Avance"; 
        caballos[3].habilidad="Retroceder Rival";
        caballos[4].cola = new LinkedList<>();
        dibujarTablero();
    }

    class Caballo {
        String nombre;
        int pos = 0;
        String habilidad;
        boolean usada=false;
        Queue<String> cola;
        
        Caballo(String nombre) {
            this.nombre = nombre;
        }

        public void avanzar() { 
            pos++; 
        }

        public void usarHabilidad() {
            if(!usada && habilidad!=null){
                lib.showTemporaryMessage(nombre+" usa "+habilidad);
                usada=true;
                if(cola!=null) cola.add(habilidad);
            }
        }
    }

    public void dibujarTablero() {
        lib.configureScreen(5,10,10,10,true,0.2);
        for(int i=0;i<5;i++) lib.setTextOnCell(i, caballos[i].pos, "🐎");
    }

    void turno() {
        int c = rnd.nextInt(5);
        caballos[c].avanzar();
        if(caballos[c].pos>=10){
            lib.showTemporaryMessage(caballos[c].nombre+" ganó!");
            return;
        }
        if(turno==0) caballos[0].usarHabilidad();
        else caballos[2].usarHabilidad();
        if(!caballos[4].cola.isEmpty()){
            String h = ((LinkedList<String>)caballos[4].cola)
                    .remove(rnd.nextInt(caballos[4].cola.size()));
            lib.showTemporaryMessage(caballos[4].nombre+" usa habilidad aleatoria: "+h);
        }
        turno = 1 - turno;
        dibujarTablero();
    }
}
