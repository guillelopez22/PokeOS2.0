package Classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class PokeOS {

    File file = new File("./Pokemon.txt");
    int size = 0;

    ArrayList<Entrenador> entrenadores_existentes = new ArrayList();
    PriorityQueue borrados = new PriorityQueue(20);

    public boolean open() {
        //Guarda el nombre del archivo y lo abre
        String fn = file.getName();
        if (file.isFile()) {
            return true;
        }

        return false;
    }

    public void Agregar(Entrenador entrenador) {
        try {
            System.out.println("///////////////////////////////////////AGREGANDO/////////////////////////////////////////////////////////////");
            ArrayList<Integer> offsets = new ArrayList();
            FileReader fr = new FileReader("./Borrados.txt");
            BufferedReader is = new BufferedReader(fr);
            String code = is.readLine();
            System.out.println("Agregando: " + entrenador.toFile());
            while (code != null) {
                StringTokenizer st_start_end = new StringTokenizer(code, "/");
                while (st_start_end.hasMoreTokens()) {
                    offsets.add(Integer.parseInt(st_start_end.nextToken()));
                }
                code = is.readLine();
            }
            if (offsets.isEmpty()) {
                entrenadores_existentes.add(entrenador);
                write(entrenadores_existentes);
            } else {
                for (int i = 0; i < offsets.size(); i++) {
                    FileReader fr1 = new FileReader("./Pokemon");
                    BufferedReader is1 = new BufferedReader(fr);
                    is1.skip(offsets.get(i));
                    Entrenador ash = null;
                    Pokemon poke = null;
                    String poke_trainer;
                    String user_pass;
                    String user = "";
                    String pass = "";
                    String pokemon_longstring;
                    String pokemon;
                    String nom_pok;
                    String apodo;
                    String descr;
                    double altura;
                    String categ;
                    double peso;
                    String hablidad1;
                    String hablidad2;
                    String hablidad3;
                    String hablidad4;
                    String genero;
                    String tipo1;
                    String tipo2;
                    String debilidad1;
                    String debilidad2;
                    double hp;
                    double ataque;
                    double defensa;
                    double ataq_especial;
                    double velocidad;
                    String imagen;
                    String evoluciones;
                    code = is.readLine();
                    String trainer = "";
                    while (code != null) {
                        StringTokenizer st_entrenadores = new StringTokenizer(code, "/");
                        poke_trainer = st_entrenadores.nextToken();
                        System.out.println(poke_trainer);
                        StringTokenizer st_user_data = new StringTokenizer(poke_trainer, "¿");
                        while (st_user_data.hasMoreTokens()) {
                            user_pass = st_user_data.nextToken();
                            StringTokenizer st_user_pass = new StringTokenizer(user_pass, ",");
                            while (st_user_pass.hasMoreTokens()) {
                                user = st_user_pass.nextToken();
                                pass = st_user_pass.nextToken();
                                System.out.println(user);
                                System.out.println(pass);
                            }
                            ash = new Entrenador(user, pass);
                            pokemon_longstring = st_user_data.nextToken();
                            System.out.println("long string: " + pokemon_longstring);
                            StringTokenizer st_pokemon_long = new StringTokenizer(pokemon_longstring, "*");
                            while (st_pokemon_long.hasMoreTokens()) {
                                pokemon = st_pokemon_long.nextToken();
                                System.out.println(pokemon);
                                StringTokenizer st_pokedata = new StringTokenizer(pokemon, ";");
                                while (st_pokedata.hasMoreTokens()) {
                                    nom_pok = st_pokedata.nextToken();
                                    System.out.println(nom_pok);
                                    apodo = st_pokedata.nextToken();
                                    System.out.println(apodo);
                                    descr = st_pokedata.nextToken();
                                    System.out.println(descr);
                                    altura = Double.parseDouble(st_pokedata.nextToken());
                                    System.out.println(altura);
                                    categ = st_pokedata.nextToken();
                                    System.out.println(categ);
                                    peso = Double.parseDouble(st_pokedata.nextToken());
                                    System.out.println(peso);
                                    hablidad1 = st_pokedata.nextToken();
                                    System.out.println(hablidad1);
                                    hablidad2 = st_pokedata.nextToken();
                                    System.out.println(hablidad2);
                                    hablidad3 = st_pokedata.nextToken();
                                    System.out.println(hablidad3);
                                    hablidad4 = st_pokedata.nextToken();
                                    System.out.println(hablidad4);
                                    genero = st_pokedata.nextToken();
                                    System.out.println(genero);
                                    tipo1 = st_pokedata.nextToken();
                                    System.out.println(tipo1);
                                    tipo2 = st_pokedata.nextToken();
                                    System.out.println(tipo2);
                                    debilidad1 = st_pokedata.nextToken();
                                    System.out.println(debilidad1);
                                    debilidad2 = st_pokedata.nextToken();
                                    System.out.println(debilidad2);
                                    hp = Double.parseDouble(st_pokedata.nextToken());
                                    System.out.println(hp);
                                    ataque = Double.parseDouble(st_pokedata.nextToken());
                                    System.out.println(ataque);
                                    defensa = Double.parseDouble(st_pokedata.nextToken());
                                    System.out.println(defensa);
                                    ataq_especial = Double.parseDouble(st_pokedata.nextToken());
                                    System.out.println(ataq_especial);
                                    velocidad = Double.parseDouble(st_pokedata.nextToken());
                                    System.out.println(velocidad);
                                    imagen = st_pokedata.nextToken();
                                    System.out.println(imagen);
                                    poke = new Pokemon(nom_pok, apodo, descr, altura, categ, peso, hablidad1, hablidad2, hablidad3, hablidad4, genero, tipo1, tipo2, debilidad1, debilidad2, hp, ataque, defensa, ataq_especial, velocidad, imagen);
                                    evoluciones = st_pokedata.nextToken();
                                    System.out.println(evoluciones);
                                    StringTokenizer st_evoluciones = new StringTokenizer(evoluciones, "~");
                                    while (st_evoluciones.hasMoreTokens()) {
                                        poke.setEvoluciones(st_evoluciones.nextToken());
                                    }
                                    ash.setPokemon(poke);
                                }

                            }
                        }
                        System.out.println(borrados.Peek());
                        borrados.insert(ash);
                        code = is.readLine();
                    }
                    if (borrados.isEmpty()) {
                        entrenadores_existentes.add(entrenador);
                        write(entrenadores_existentes);
                    } else if (borrados.Peek().byteSize() < entrenador.byteSize()) {
                        entrenadores_existentes.add(entrenador);
                        write(entrenadores_existentes);
                    } else if (borrados.Peek().byteSize() > entrenador.byteSize()) {
                        Entrenador temp = new Entrenador("¬FREE", "FREE");
                        entrenadores_existentes.add(entrenador);
                        borrados.insert(temp);
                        entrenadores_existentes.add(temp);

                    }
                }
            }
        } catch (Exception e) {
        }
        System.out.println("////////////////////////////////////////////////////////////fin/////////////////////////////////////////////////////////");
    }

    public PokeOS() {

    }

    public void read() {
        //Lee el archivo y almacena s caracteres leidos en buffer
        try {
            FileReader fr = new FileReader(file);
            BufferedReader is = new BufferedReader(fr);
            Entrenador ash = null;
            Pokemon poke = null;
            String code = is.readLine();
            String poke_trainer;
            String user_pass;
            String user = "";
            String pass = "";
            String pokemon_longstring;
            String pokemon;
            String nom_pok;
            String apodo;
            String descr;
            double altura;
            String categ;
            double peso;
            String hablidad1;
            String hablidad2;
            String hablidad3;
            String hablidad4;
            String genero;
            String tipo1;
            String tipo2;
            String debilidad1;
            String debilidad2;
            double hp;
            double ataque;
            double defensa;
            double ataq_especial;
            double velocidad;
            String imagen;
            String evoluciones;

            while (code != null) {
                StringTokenizer st_entrenadores = new StringTokenizer(code, "/");
                while (st_entrenadores.hasMoreTokens()) {
                    poke_trainer = st_entrenadores.nextToken();
                    System.out.println(poke_trainer);
                    StringTokenizer st_user_data = new StringTokenizer(poke_trainer, "¿");
                    while (st_user_data.hasMoreTokens()) {
                        user_pass = st_user_data.nextToken();
                        StringTokenizer st_user_pass = new StringTokenizer(user_pass, ",");
                        while (st_user_pass.hasMoreTokens()) {
                            user = st_user_pass.nextToken();
                            pass = st_user_pass.nextToken();
                            System.out.println(user);
                            System.out.println(pass);
                        }
                        ash = new Entrenador(user, pass);
                        pokemon_longstring = st_user_data.nextToken();
                        System.out.println("long string: " + pokemon_longstring);
                        StringTokenizer st_pokemon_long = new StringTokenizer(pokemon_longstring, "*");
                        while (st_pokemon_long.hasMoreTokens()) {
                            pokemon = st_pokemon_long.nextToken();
                            System.out.println(pokemon);
                            StringTokenizer st_pokedata = new StringTokenizer(pokemon, ";");
                            while (st_pokedata.hasMoreTokens()) {
                                nom_pok = st_pokedata.nextToken();
                                System.out.println(nom_pok);
                                apodo = st_pokedata.nextToken();
                                System.out.println(apodo);
                                descr = st_pokedata.nextToken();
                                System.out.println(descr);
                                altura = Double.parseDouble(st_pokedata.nextToken());
                                System.out.println(altura);
                                categ = st_pokedata.nextToken();
                                System.out.println(categ);
                                peso = Double.parseDouble(st_pokedata.nextToken());
                                System.out.println(peso);
                                hablidad1 = st_pokedata.nextToken();
                                System.out.println(hablidad1);
                                hablidad2 = st_pokedata.nextToken();
                                System.out.println(hablidad2);
                                hablidad3 = st_pokedata.nextToken();
                                System.out.println(hablidad3);
                                hablidad4 = st_pokedata.nextToken();
                                System.out.println(hablidad4);
                                genero = st_pokedata.nextToken();
                                System.out.println(genero);
                                tipo1 = st_pokedata.nextToken();
                                System.out.println(tipo1);
                                tipo2 = st_pokedata.nextToken();
                                System.out.println(tipo2);
                                debilidad1 = st_pokedata.nextToken();
                                System.out.println(debilidad1);
                                debilidad2 = st_pokedata.nextToken();
                                System.out.println(debilidad2);
                                hp = Double.parseDouble(st_pokedata.nextToken());
                                System.out.println(hp);
                                ataque = Double.parseDouble(st_pokedata.nextToken());
                                System.out.println(ataque);
                                defensa = Double.parseDouble(st_pokedata.nextToken());
                                System.out.println(defensa);
                                ataq_especial = Double.parseDouble(st_pokedata.nextToken());
                                System.out.println(ataq_especial);
                                velocidad = Double.parseDouble(st_pokedata.nextToken());
                                System.out.println(velocidad);
                                imagen = st_pokedata.nextToken();
                                System.out.println(imagen);
                                poke = new Pokemon(nom_pok, apodo, descr, altura, categ, peso, hablidad1, hablidad2, hablidad3, hablidad4, genero, tipo1, tipo2, debilidad1, debilidad2, hp, ataque, defensa, ataq_especial, velocidad, imagen);
                                evoluciones = st_pokedata.nextToken();
                                System.out.println(evoluciones);
                                StringTokenizer st_evoluciones = new StringTokenizer(evoluciones, "~");
                                while (st_evoluciones.hasMoreTokens()) {
                                    poke.setEvoluciones(st_evoluciones.nextToken());
                                }
                                ash.setPokemon(poke);
                            }

                        }
                    }
                    entrenadores_existentes.add(ash);
                }
                code = is.readLine();
            }

            is.close();
        } catch (Exception e) {
        }
        for (int i = 0; i < entrenadores_existentes.size(); i++) {
            System.out.println("Lista de entrenadores: " + entrenadores_existentes.get(i));
        }
    }

    public void write(ArrayList<Entrenador> entrenadores) {
        File archivo;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            archivo = new File("./Pokemon.txt");
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < entrenadores.size(); i++) {
                bw.write(entrenadores.get(i).toFile());
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
            }

        }
    }

    public void Borrar(Entrenador entrenador) {
        for (int x = 0; x < entrenadores_existentes.size(); x++) {
            if (!entrenadores_existentes.get(x).toFile().equals(entrenador.toFile())) {
                System.out.println("NO EXISTE");
            } else {
                System.out.println("entra al else");
                Entrenador toFile = null;
                String match = "";
                for (int i = 0; i < entrenadores_existentes.size(); i++) {
                    if (entrenador.getNombre().equals(entrenadores_existentes.get(i).getNombre())) {
                        entrenadores_existentes.get(i).setNombre("¬" + entrenador.getNombre());
                        toFile = entrenadores_existentes.get(i);
                        match = toFile.toFile();
                    }
                }
                write(entrenadores_existentes);
                System.out.println("A borrar: " + match);
                int offset = -1;
                try {
                    FileReader fr = new FileReader("./Pokemon.txt");
                    BufferedReader is = new BufferedReader(fr);
                    Pattern p = Pattern.compile(match, Pattern.CASE_INSENSITIVE);
                    int linecount = 0;
                    String line;
                    int start = -1, end = -1;
                    
                    do {
                        line= is.readLine();
                        System.out.println(line);
                        System.out.println("entra a primer while");
                        linecount++;
                        Matcher m = p.matcher(line);
                        System.out.println("hace matcher");
                        // indicate all matches on the line
                        while (m.find()) {
                            System.out.println("//////////////////////////////////////////////////////////////////////////////////////////");
                            offset = m.start();
                            start = m.start();
                            end = m.end();
                            System.out.println("Word was found at position " + m.start() + " and ends in " + m.end());
                        }
                        System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
                        System.out.println("Pre " + start + " " + end);
                        System.out.println("prueba" + offset);
                        File archivo;
                        FileWriter fw = null;
                        BufferedWriter bw = null;
                        try {
                            archivo = new File("./Borrados.txt");
                            fw = new FileWriter(archivo, true);
                            bw = new BufferedWriter(fw);
                            bw.write("" + start + "/");
                            bw.flush();
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                bw.close();
                                fw.close();
                            } catch (IOException ex) {
                            }

                        }
                    }while ((line = is.readLine()) != null);

                } catch (Exception e) {
                }

                write(entrenadores_existentes);
            }
        }
    }

    public void Compactar() {
        for (int i = 0; i < entrenadores_existentes.size(); i++) {
            if (entrenadores_existentes.get(i).getNombre().contains("¬")) {
                entrenadores_existentes.remove(i);
            }
        }
        File archivo;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            archivo = new File("./Borrados.txt");
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            bw.write("");
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
            }
        }
        borrados.Clear();
        write();
    }
    public void write() {
        File archivo;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            archivo = new File("./Pokemon.txt");
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < entrenadores_existentes.size(); i++) {
                bw.write(entrenadores_existentes.get(i).toFile());
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
            }

        }
    }
    public void clear(){
        entrenadores_existentes.clear();
        File archivo;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            archivo = new File("./Pokemon.txt");
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            bw.write("");
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
            }
        }
    }
}
