package Classes;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jordi Mairena
 */
public class Entrenador {

    private String nombre;
    private String password;
    private ArrayList<Pokemon> pokemon = new ArrayList();
    private int size =100;

    public Entrenador() {
    }

    public Entrenador(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        size = toFile().getBytes().length;
    }
//    public Entrenador(String nombre, String password, ArrayList pokemon) {
//        this.nombre = nombre;
//        this.password = password;
//        this.pokemon = pokemon;
//    }

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

    public ArrayList<Pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon.add(pokemon);
    }

    public int byteSize() {
        
        return toFile().length();
    }

    @Override
    public String toString() {
        return "Entrenador{" + "nombre=" + nombre + ", password=" + password + ", pokemon=" + pokemon + '}';
    }

    public String toFile() {
        String poke = "";
            for (int i = 0; i < pokemon.size(); i++) {
                if (i == pokemon.size() - 1) {
                    poke = poke + pokemon.get(i).toFile();
                } else {
                    poke = poke + pokemon.get(i).toFile() + "*";
                }
                size = size+50;
            }
        

        return nombre + "," + password + "¿" + poke + "/";
    }

    // entrenador,password, poke1*poke2*poke3|
}
