package com.example.pizzeria2.modelo.persistencia;

import android.util.Log;

import com.example.pizzeria2.modelo.entidad.Usuario;

import java.util.ArrayList;

public class DaoUsuario {
    ArrayList<Usuario>listaUsuarios;

    public void registraUsuario(){
        listaUsuarios = new ArrayList<Usuario>();
        Usuario usuario1 = new Usuario("Manolo","1234","Calle_Perico");
        Usuario usuario2 = new Usuario("Pepe","12345","Calle_Doha");
        Usuario usuario3 = new Usuario("Daniel","123456","Calle_Lituania");
        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario3);

    }
    public Boolean validarUsuarioByName(Usuario u){
        registraUsuario();
       for(Usuario user : listaUsuarios){
           if(user.equals(u)){
               return true;
           }
       }
        Log.i("Mensaje de error", "Error el usuario o la contraseña no esta");
       return false;
    }

    public Usuario getUsuarioByName(Usuario u){
        registraUsuario();
        for(Usuario user : listaUsuarios){
            if(user.equals(u)){
                return user;
            }
        }
        Log.i("Mensaje de error", "Error el usuario o la contraseña no esta");
        return null;
    }







}
