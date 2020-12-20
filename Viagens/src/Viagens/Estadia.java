package Viagens;

import java.io.Serializable;

public class Estadia extends Tempo implements Serializable {
    private String name;
    private int cod;
    private String local;
    private static int ultimo = 0;
    private int pessoas_quarto;
    private double preco_base;
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
    public void setPreco_base(double preco_base) {
        this.preco_base = preco_base;
    }
    public void setLocal(String name){ this.local = local;}
    public void setPessoas_quarto(int pessoas_quarto){
        this.pessoas_quarto = pessoas_quarto;
    }
    public static void setUltimo(int ultimo){Estadia.ultimo = ultimo;}

    public String getName(){
        return this.name;
    }
    public int getCod(){
        return this.cod;
    }
    public double getPreco_base() { return this.preco_base;}
    public String getLocal() {return this.local;}
    public int getPessoas_quarto() { return this.pessoas_quarto;}
    public static int getUltimo(){return ultimo;}


    @Override
    public String toString(){
        return name+ " " +cod+ " " +preco_base+ " " +pessoas_quarto;
    }
}
