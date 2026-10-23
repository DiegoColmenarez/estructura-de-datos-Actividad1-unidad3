package org.com.model;

public enum NivelPrioridad {
    VIP_ESPECIAL(1),
    URGENTE(2),
    NORMAL(3);

    private final int peso;

    NivelPrioridad(int peso) {
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }
}
