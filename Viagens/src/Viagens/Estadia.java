package Viagens;

import java.io.Serializable;

public class Estadia implements Serializable {
    private String name;
    //private String tipo;
    private int cod;
    private static int ultimo = 0;
    private int pessoas_quarto;
    //private

    public Estadia(String name){
        this.name = name;
        this.cod = this.ultimo++;

    }
    //getters e setters
    public void setName(String name){
        this.name = name;
    }
    public void setCod(int cod){this.cod = cod; }
    public static void setUltimo(int ultimo){Estadia.ultimo = ultimo;}

    public String getName(){
        return this.name;
    }
    public int getCod(){
        return this.cod;
    }
    public static int getUltimo(){return ultimo;}

    @Override
    public String toString(){
        return name;
    }
}
