package com.example.controlcafetin;

public class Antojitos {
    private String codproducto;
    private String nomproducto;
    private String unidadesval;
    public Antojitos(){
    }
    public Antojitos(String codproducto, String nomproducto, String unidadesval) {
        this.codproducto = codproducto;
        this.nomproducto = nomproducto;
        this.unidadesval = unidadesval;
    }
    public String getCodproducto() {
        return codproducto;
    }
    public void setCodproducto(String codproducto) {
        this.codproducto = codproducto;
    }
    public String getNomproducto() {
        return nomproducto;
    }
    public void setNomproducto(String nomproducto) {
        this.nomproducto = nomproducto;
    }
    public String getUnidadesval() {
        return unidadesval;
    }
    public void setUnidadesval(String unidadesval) {
        this.unidadesval = unidadesval;
    }
}
