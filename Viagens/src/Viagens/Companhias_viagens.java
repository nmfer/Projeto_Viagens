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
    public void setTipo(String name){
        this.tipo = tipo;
    }
    public void setID(int id){
        Companhias_viagens.this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public String getTipo(){
        return this.tipo;
    }
    public int getID(){
        return Companhias_viagens.this.id;
    }
    public String toString(){
        return "Nome -> "+this.name+" => Tipo -> "+this.tipo+ " //ID-> "+this.id;
    }
}
