/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lib.brental.model;

/**
 *
 * @author john
 */
public class Lod {
    private LodId id;
    private String typ;
    private int kapacita; // pocet lidi kolik se do ni vejde

    public Lod(LodId id, String typ, int kapacita) {
        this.id = id;
        this.typ = typ;
        this.kapacita = kapacita;
    }

    public LodId getId() {
        return id;
    }

    public String getTyp() {
        return typ;
    }

    public int getKapacita() {
        return kapacita;
    }
}
