package com.example.pizzeria2.modelo.entidad;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {
    private String nombre;

    private String username;
    private String password;
    private String direccion;
    private Pizza pizza;



    public Usuario() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", direccion='" + direccion + '\'' +
                ", pizza=" + pizza +
                ", username='" + username + '\'' +
                '}';
    }

    public boolean sonIguales(Object o) {
        Usuario usuario = (Usuario) o;
        if(usuario.getUsername().equalsIgnoreCase(username) && usuario.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, password, direccion, pizza, username);
    }
}
