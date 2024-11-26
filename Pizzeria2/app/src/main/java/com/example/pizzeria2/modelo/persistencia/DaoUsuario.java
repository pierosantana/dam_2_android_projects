package com.example.pizzeria2.modelo.persistencia;

import android.util.Log;

import com.example.pizzeria2.modelo.entidad.Usuario;

import java.util.ArrayList;

public class DaoUsuario {
    static ArrayList<Usuario>listaUsuarios = new ArrayList<Usuario>();;

    public void registraUsuario(Usuario u){

        listaUsuarios.add(u);

    }
    public Boolean validarUsuarioByName(Usuario u){
       for(Usuario user : listaUsuarios){
           if(user.sonIguales(u)){
               return true;
           }
       }
        Log.i("Mensaje de error", "Error el usuario o la contraseña no esta");
       return false;
    }

    public Usuario getUsuarioByName(Usuario u){
        for(Usuario user : listaUsuarios){
            if(user.sonIguales(u)){
                return user;
            }
        }
        Log.i("Mensaje de error", "Error el usuario o la contraseña no esta");
        return null;
    }







}
