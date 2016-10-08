package main.java.ar.edu.utn.frba.ia.ag.acertijo;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import scala.collection.Seq;

import java.util.*;


public class Cromosoma extends Individuo {

    private Integer juanTrabajo1;
    private Integer juanTrabajo2;

    private Integer joseTrabajo1;
    private Integer joseTrabajo2;

    private Integer jaimeTrabajo1;
    private Integer jaimeTrabajo2;


    public Integer getJuanTrabajo1() {
        return juanTrabajo1;
    }

    public void setJuanTrabajo1(Integer juanTrabajo1) {
        this.juanTrabajo1 = juanTrabajo1;
    }

    public Integer getJuanTrabajo2() {
        return juanTrabajo2;
    }

    public void setJuanTrabajo2(Integer juanTrabajo2) {
        this.juanTrabajo2 = juanTrabajo2;
    }

    public Integer getJoseTrabajo1() {
        return joseTrabajo1;
    }

    public void setJoseTrabajo1(Integer joseTrabajo1) {
        this.joseTrabajo1 = joseTrabajo1;
    }

    public Integer getJoseTrabajo2() {
        return joseTrabajo2;
    }

    public void setJoseTrabajo2(Integer joseTrabajo2) {
        this.joseTrabajo2 = joseTrabajo2;
    }

    public Integer getJaimeTrabajo1() {
        return jaimeTrabajo1;
    }

    public void setJaimeTrabajo1(Integer jaimeTrabajo1) {
        this.jaimeTrabajo1 = jaimeTrabajo1;
    }

    public Integer getJaimeTrabajo2() {
        return jaimeTrabajo2;
    }

    public void setJaimeTrabajo2(Integer jaimeTrabajo2) {
        this.jaimeTrabajo2 = jaimeTrabajo2;
    }

    @Override
    public double aptitud() {
        double total = 0;

        ArrayList<Integer> oficiosJuan = new ArrayList<>(2);
        oficiosJuan.add(this.juanTrabajo1);
        oficiosJuan.add(this.juanTrabajo2);

        ArrayList<Integer> oficiosJose = new ArrayList<>(2);
        oficiosJose.add(this.joseTrabajo1);
        oficiosJose.add(this.joseTrabajo2);

        ArrayList<Integer> oficiosJaime = new ArrayList<>(2);
        oficiosJaime.add(this.jaimeTrabajo1);
        oficiosJaime.add(this.jaimeTrabajo2);

        //Condiciones que se deben cumplir

        //Si la persona es matemático y no musico, se le sumarán 10 puntos al valor de la aptitud.
        if ((oficiosJuan.contains(Oficios.MATEMATICO) && !oficiosJuan.contains(Oficios.MUSICO))
            || (oficiosJaime.contains(Oficios.MATEMATICO) && !oficiosJaime.contains(Oficios.MUSICO))
            || (oficiosJose.contains(Oficios.MATEMATICO) && !oficiosJose.contains(Oficios.MUSICO)))
                total += 30;

        //Si la persona es musico y no jardinero, se le sumaran 10 puntos al valor de la aptitud.
        if (oficiosJuan.contains(Oficios.MUSICO) && !oficiosJuan.contains(Oficios.JARDINERO)
            || (oficiosJaime.contains(Oficios.MUSICO) && !oficiosJaime.contains(Oficios.JARDINERO))
            || (oficiosJose.contains(Oficios.MUSICO) && !oficiosJose.contains(Oficios.JARDINERO)))
                total += 30;

        //Si la persona es pintor y no músico, se le sumaran 10 puntos al valor de la aptitud.
        if (oficiosJuan.contains(Oficios.PINTOR) && !oficiosJuan.contains(Oficios.MUSICO)
            || (oficiosJaime.contains(Oficios.PINTOR) && !oficiosJaime.contains(Oficios.MUSICO))
            || (oficiosJose.contains(Oficios.PINTOR) && !oficiosJose.contains(Oficios.MUSICO)))
                total += 30;

        //Si la persona es matematico y no pintor, se le sumaran 10 puntos al valor de la aptitud.
        if (oficiosJuan.contains(Oficios.MATEMATICO) && !oficiosJuan.contains(Oficios.PINTOR)
            || (oficiosJaime.contains(Oficios.MATEMATICO) && !oficiosJaime.contains(Oficios.PINTOR))
            || (oficiosJose.contains(Oficios.MATEMATICO) && !oficiosJose.contains(Oficios.PINTOR)))
                total += 30;

        //Si la persona es jardinero y no poeta, se le sumarán 10 puntos al valor de la aptitud.
        if (oficiosJuan.contains(Oficios.JARDINERO) && !oficiosJuan.contains(Oficios.POETA)
            || (oficiosJaime.contains(Oficios.JARDINERO) && !oficiosJaime.contains(Oficios.POETA))
            || (oficiosJose.contains(Oficios.JARDINERO) && !oficiosJose.contains(Oficios.POETA)))
                total += 30;

        //Si Jaime no es pintor, se le sumaran 50 puntos al valor de la aptitud.
        if (!oficiosJaime.contains(Oficios.PINTOR))
            total += 50;

        //Si Juan no es jardinero, se le sumaran 50 puntos al valor de la aptitud.
        if (!oficiosJuan.contains(Oficios.JARDINERO))
            total += 50;

        //Si Juan no es musico, se le sumaran 50 puntos al valor de la aptitud.
        if (!oficiosJuan.contains(Oficios.MUSICO))
            total += 50;

        //Si Jose no es pintor, se le sumaran 50 puntos al valor de la aptitud.
        if (!oficiosJose.contains(Oficios.PINTOR))
            total += 50;

        //Si Jose no es poeta, se le sumaran 50 puntos al valor de la aptitud.
        if (!oficiosJose.contains(Oficios.POETA))
            total += 50;

        //Si Jose no es jardinero, se le sumaran 50 puntos al valor de la aptitud.
        if (!oficiosJose.contains(Oficios.JARDINERO))
            total += 50;

        //Si Juan es pintor, se le sumaràn 100 puntos al valor de la aptitud.
        if (oficiosJuan.contains(Oficios.PINTOR))
            total += 100;

        //Si Jaime es jardinero, se le sumaràn 100 puntos al valor de la aptitud.
        if (oficiosJaime.contains(Oficios.JARDINERO))
            total += 100;


        //--------------------
        //Restricciones

        //Si Jaime es pintor, se le restaràn 50 puntos al valor de la aptitud.
        if (oficiosJaime.contains(Oficios.PINTOR))
            total -= 50;

        //Si Jose es pintor, se le restaran 50 puntos al valor de la aptitud.
        if (oficiosJose.contains(Oficios.PINTOR))
            total -= 50;

        //Si Jose es jardinero, se le restaran 50 puntos al valor de la aptitud.
        if (oficiosJose.contains(Oficios.JARDINERO))
            total -= 50;

        //Si Juan es jardinero, se le restarán 50 puntos al valor de la aptitud.
        if (oficiosJuan.contains(Oficios.JARDINERO))
            total -= 50;

        //Si Jose no es poeta, se le restaran 50 puntos al valor de la aptitud.
        if (oficiosJose.contains(Oficios.POETA))
            total -= 50;

        //Si Juan es mùsico, se le restaràn 50 puntos al valor de la aptitud.
        if (oficiosJuan.contains(Oficios.MUSICO))
            total -= 50;

        //Si Juan no es pintor, se le restaràn 100 puntos al valor de la aptitud.
        if (!oficiosJuan.contains(Oficios.PINTOR))
            total -= 100;

        //Si Jaime no es jardinero, se le restaràn 100 puntos al valor de la aptitud.
        if (!oficiosJaime.contains(Oficios.JARDINERO))
            total -= 100;

        //--------------------
        //Combinaciones invalidas

        //Ninguna de las personas pueden tener dos trabajos iguales, en tal caso, se le restarán 100 puntos al valor de la aptitud.
        Set<Integer> setJuan = new HashSet<>(oficiosJuan);
        setJuan.add(this.juanTrabajo1);
        setJuan.add(this.juanTrabajo2);

        Set<Integer> setJose = new HashSet<>(oficiosJose);
        setJose.add(this.joseTrabajo1);
        setJose.add(this.joseTrabajo2);

        Set<Integer> setJaime = new HashSet<>(oficiosJaime);
        setJaime.add(this.jaimeTrabajo1);
        setJaime.add(this.jaimeTrabajo2);


        if (setJuan.size() < 2 || setJose.size() < 2 || setJaime.size() < 2)
            total -= 1000;

        //Si un oficio, aparece en mas de una persona, se le restaràn 20 puntos al valor de la aptitud.
        Set<Integer> todosLosOficions = new HashSet<>(6);
        todosLosOficions.addAll(oficiosJaime);
        todosLosOficions.addAll(oficiosJuan);
        todosLosOficions.addAll(oficiosJose);

        if (todosLosOficions.size() < 6)
            total -= 1000;


        return total;
    }

    @Override
    public Individuo generarRandom() {
        Cromosoma cromosoma = new Cromosoma();
        Random rn = new Random();

        // Random entre 1 y 6
        // random.nextInt(max - min + 1) + min

        cromosoma.setJaimeTrabajo1(rn.nextInt(6 - 1 + 1) + 1);
        cromosoma.setJaimeTrabajo2(rn.nextInt(6 - 1 + 1) + 1);
        cromosoma.setJoseTrabajo1(rn.nextInt(6 - 1 + 1) + 1);
        cromosoma.setJoseTrabajo2(rn.nextInt(6 - 1 + 1) + 1);
        cromosoma.setJuanTrabajo1(rn.nextInt(6 - 1 + 1) + 1);
        cromosoma.setJuanTrabajo2(rn.nextInt(6 - 1 + 1) + 1);

        return cromosoma;
    }

    @Override
    public String toString() {
        return "\nJuan: " + Oficios.getString(this.getJuanTrabajo1()) + " y " + Oficios.getString(this.getJuanTrabajo2())
                + ".\n"
                + "Jaime: " + Oficios.getString(this.getJaimeTrabajo1()) + " y " + Oficios.getString(this.getJaimeTrabajo2())
                + ".\n"
                + "Jose: " + Oficios.getString(this.getJoseTrabajo1()) + " y " + Oficios.getString(this.getJoseTrabajo2())
                + ".\n"
                + "Aptitud: " + this.aptitud();
    }
}

class Oficios{
    static final Integer MATEMATICO = 1;
    static final Integer POETA = 2;
    static final Integer MUSICO = 3;
    static final Integer PINTOR = 4;
    static final Integer ESCULTOR = 5;
    static final Integer JARDINERO = 6;

    static String getString(Integer intValue){
        switch (intValue) {
            case  1: return "MATEMATICO";
            case  2: return "POETA";
            case  3: return "MUSICO";
            case  4: return "PINTOR";
            case  5: return "ESCULTOR";
            case  6: return "JARDINERO";
            default: return "";
        }
    }
}
