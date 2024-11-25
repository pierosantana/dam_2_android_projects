package com.example.pizzeria2.modelo.negocio;

import com.example.pizzeria2.modelo.entidad.Usuario;
import com.example.pizzeria2.modelo.persistencia.DaoUsuario;

public class GestorUsuario {
    private DaoUsuario daoUsuario ;

    public Usuario validarUsuario(Usuario u){
        daoUsuario = new DaoUsuario();
        if(daoUsuario.validarUsuarioByName(u)){
            return daoUsuario.getUsuarioByName(u);
        }else{
            return null;
        }



    }

}
