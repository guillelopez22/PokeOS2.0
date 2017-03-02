package Classes;


import java.util.ArrayList;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jordi Mairena
 */
public class Pokemon {

    private String nombre;
    private String apodo;
    private String descripcion;
    private double altura;
    private String categoria;
    private double peso;
    private String habilidad1;
    private String habilidad2;
    private String habilidad3;
    private String habilidad4;
    private String genero;
    private String tipo1;
    private String tipo2;
    private String debilidad1;
    private String debilidad2;
    private double hp;
    private double ataque;
    private double defensa;
    private double ataque_especial;
    private double velocidad;
    private ArrayList<String> evoluciones = new ArrayList();
    private String image_dir;

    public Pokemon() {
    }

    public Pokemon(String nombre, String apodo, String descripcion, double altura, String categoria, double peso, String habilidad1, String habilidad2, String habilidad3, String habilidad4, String genero, String tipo1, String tipo2, String debilidad1, String debilidad2, double hp, double ataque, double defensa, double ataque_especial, double velocidad, String image_dir) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.descripcion = descripcion;
        this.altura = altura;
        this.categoria = categoria;
        this.peso = peso;
        this.habilidad1 = habilidad1;
        this.habilidad2 = habilidad2;
        this.habilidad3 = habilidad3;
        this.habilidad4 = habilidad4;
        this.genero = genero;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.debilidad1 = debilidad1;
        this.debilidad2 = debilidad2;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataque_especial = ataque_especial;
        this.velocidad = velocidad;
        this.image_dir = image_dir;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getHabilidad1() {
        return habilidad1;
    }

    public void setHabilidad1(String habilidad1) {
        this.habilidad1 = habilidad1;
    }

    public String getHabilidad2() {
        return habilidad2;
    }

    public void setHabilidad2(String habilidad2) {
        this.habilidad2 = habilidad2;
    }

    public String getHabilidad3() {
        return habilidad3;
    }

    public void setHabilidad3(String habilidad3) {
        this.habilidad3 = habilidad3;
    }

    public String getHabilidad4() {
        return habilidad4;
    }

    public void setHabilidad4(String habilidad4) {
        this.habilidad4 = habilidad4;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public String getDebilidad1() {
        return debilidad1;
    }

    public void setDebilidad1(String debilidad1) {
        this.debilidad1 = debilidad1;
    }

    public String getDebilidad2() {
        return debilidad2;
    }

    public void setDebilidad2(String debilidad2) {
        this.debilidad2 = debilidad2;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public double getDefensa() {
        return defensa;
    }

    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    public double getAtaque_especial() {
        return ataque_especial;
    }

    public void setAtaque_especial(double ataque_especial) {
        this.ataque_especial = ataque_especial;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public ArrayList<String> getEvoluciones() {
        return evoluciones;
    }

    public void setEvoluciones(String evolucion) {
        this.evoluciones.add(evolucion);
    }

    public String getImage() {
        return image_dir;
    }

    public void setImage(String image_dir) {
        this.image_dir = image_dir;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "nombre=" + nombre + ", apodo=" + apodo + ", descripcion=" + descripcion + ", altura=" + altura + ", categoria=" + categoria + ", peso=" + peso + ", habilidad1=" + habilidad1 + ", habilidad2=" + habilidad2 + ", habilidad3=" + habilidad3 + ", habilidad4=" + habilidad4 + ", genero=" + genero + ", tipo1=" + tipo1 + ", tipo2=" + tipo2 + ", debilidad1=" + debilidad1 + ", debilidad2=" + debilidad2 + ", hp=" + hp + ", ataque=" + ataque + ", defensa=" + defensa + ", ataque_especial=" + ataque_especial + ", velocidad=" + velocidad + ", evoluciones=" + evoluciones + ", image_dir=" + image_dir + '}';
    }
    

    public String toFile() {
        String evo = "";
        if (evoluciones.isEmpty()) {
            evo = "no tiene evoluciones";
        } else {
            for (int i = 0; i < evoluciones.size(); i++) {
                if (i == evoluciones.size() - 1) {
                    evo = evo + evoluciones.get(i);
                } else {
                    evo = evo + evoluciones.get(i) + "~";
                }
            }
        }

        return nombre + ";" + apodo + ";" + descripcion + ";" + altura + ";" + categoria + ";" + peso + ";" + habilidad1 + ";" + habilidad2 + ";" + habilidad3 + ";" + habilidad4 + ";" + genero + ";" + tipo1 + ";" + tipo2 + ";" + debilidad1 + ";" + debilidad2 + ";" + hp + ";" + ataque + ";" + defensa + ";" + ataque_especial + ";" + velocidad + ";" + image_dir + ";" + evo;
    }
}
// entrenador,password, asd*asd+asd+asd+asd+asd+|
