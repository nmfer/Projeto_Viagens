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
    public String getName(){
        return this.name;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return this.tipo;
    }


    public void setID(int id){  this.id = id; }
    public int getID(){
        return this.id;
    }

    public static void setUltimo(int ultimo){Companhias_viagens.ultimo = ultimo;}
    public static int getUltimo(){return ultimo;}


    public boolean equals(Object obj){
        if(obj!=null && this.getClass() == obj.getClass()){
            Companhias_viagens c_v = (Companhias_viagens)obj;
            return this.name.equals(c_v.name) && this.tipo.equals(c_v.tipo);
        }
        return false;
    }

    @Override
    public String toString(){
        return this.id + "-> Nome -> "+this.name;
    }
}
