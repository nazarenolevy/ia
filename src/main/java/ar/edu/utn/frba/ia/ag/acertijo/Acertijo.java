package main.java.ar.edu.utn.frba.ia.ag.acertijo;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.paro.AptitudMinima;

import java.util.logging.Logger;

public class Acertijo {

    public static void main(String[] args) {

        ConfiguracionDefault c = new ConfiguracionDefault();

        c.setCriterioDeParo(new AptitudMinima(200));

        AlgoritmoGenetico ag = new AlgoritmoGenetico(c, Cromosoma.class);

        Individuo individuo = ag.ejecutar();

        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).info("Individuo final: " + individuo.toString());

    }
}


