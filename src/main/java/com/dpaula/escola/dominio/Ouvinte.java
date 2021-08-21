package com.dpaula.escola.dominio;

/**
 * @author Fernando de Lima on 20/08/21
 */
public abstract class Ouvinte {

    public void processa(final Evento evento) {
        if (deveProcessar(evento)) {
            reageAoEvento(evento);
        }
    }

    protected abstract void reageAoEvento(Evento evento);

    protected abstract boolean deveProcessar(Evento evento);
}
