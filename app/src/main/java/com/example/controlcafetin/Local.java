package com.example.controlcafetin;

public class Local {
    private String dui;
    private String nombre;
    private String apellido;
    private String sexo;
    private int idlocal;
    public Local(){
    }
    public Local(String dui, String nombre, String apellido, String sexo) {
        this.dui = dui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
    }
    public String getdui() {
        return dui;
    }
    public void setdui(String dui) {
        this.dui = dui;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public int getidlocal() {
        return idlocal;
    }
    public void setidlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public void setidsucursal(int i) {
    }

    public byte[] getidsucursal() {
        return new byte[0];
    }

    public void setDui(String dui) {
    }

    public void setLocal(String toString) {
    }
}