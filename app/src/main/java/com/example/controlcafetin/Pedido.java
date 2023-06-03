package com.example.controlcafetin;

public class Pedido {
    private String dui;
    private String codproducto;
    private String local;
    private float cuentafinal;
    public Pedido(){
    }
    public Pedido(String dui, String codproducto, String local, float
            cuentafinal) {
        this.dui = dui;
        this.codproducto = codproducto;
        this.local = local;
        this.cuentafinal = cuentafinal;
    }
    public String getdui() {
        return dui;
    }
    public void setdui(String dui) {
        this.dui = dui;
    }
    public String getCodproducto() {
        return codproducto;
    }
    public void setCodproducto(String codproducto) {
        this.codproducto = codproducto;
    }
    public String getlocal() {
        return local;
    }
    public void setlocal(String local) {
        this.local = local;

    }
    public float getcuentafinal() {
        return cuentafinal;
    }
    public void setcuentafinal(float cuentafinal) {
        this.cuentafinal = cuentafinal;
    }

}
