package Viagens;

import java.io.Serializable;

public class Companhias_viagens implements Serializable {
    private String name;
    private String tipo;
    private int id;
    private static int ultimo = 0;

    public Companhias_viagens(String name, String tipo){
        this.name = name;
        this.tipo = tipo;
        this.id = this.ultimo++;
    }

    //setters e getters
    public void setName(String name){
        this.name = name;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setID(int id){  this.id = id; }
    public static void setUltimo(int ultimo){Companhias_viagens.ultimo = ultimo;}

    public String getName(){
        return this.name;
    }
    public String getTipo(){
        return this.tipo;
    }
    public int getID(){
        return this.id;
    }
    public static int getUltimo(){return ultimo;}

    @Override
    public String toString(){
        return "Nome -> "+this.name+ "_ id -> "+this.id;
    }
}
