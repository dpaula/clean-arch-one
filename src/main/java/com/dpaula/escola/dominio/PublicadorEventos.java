package com.dpaula.escola.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fernando de Lima on 20/08/21
 */
public class PublicadorEventos {

    private final List<Ouvinte> ouvintes = new ArrayList<>();

    public void addOuvinte(final Ouvinte ouvinte) {
        ouvintes.add(ouvinte);
    }

    public void publicar(final Evento evento) {
        ouvintes.forEach(o -> o.processa(evento));
    }
}
