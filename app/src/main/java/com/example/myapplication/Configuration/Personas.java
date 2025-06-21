package com.example.myapplication.Configuration;

public class Personas {


    private int id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;



    public Personas() {
    }

    public Personas(String correo, String apellidos, int id, String nombres, String telefono) {
        this.correo = correo;
        this.apellidos = apellidos;
        this.id = id;
        this.nombres = nombres;
        this.telefono = telefono;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
