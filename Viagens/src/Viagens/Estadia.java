package Viagens;

import java.io.Serializable;

public class Estadia implements Serializable {
    private String car;
    private int cod;
    private static int ultimo = 0;
    private String local;

    private int lotacao;
    private double preco_base;

    public Estadia(String car, int lotacao, double preco_base, String local){
        this.car = car;
        this.local = local;
        this.lotacao = lotacao;
        this.preco_base = preco_base;

        this.cod = this.ultimo++;
    }


    //getters e setters
    public void setCar(String car){
        this.car = car;
    }
    public void setCod(int cod){this.cod = cod; }
    public void setPreco_base(double preco_base) {
        this.preco_base = preco_base;
    }
    public void setLocal(String local){ this.local = local;}
    public void setLotacao_quarto(int lotacao){
        this.lotacao = lotacao;
    }
    public static void setUltimo(int ultimo){Estadia.ultimo = ultimo;}

    public String getCar(){
        return this.car;
    }
    public int getCod(){
        return this.cod;
    }
    public double getPreco_base() { return this.preco_base;}
    public String getLocal() {return this.local;}
    public int getLotacao() { return this.lotacao;}
    public static int getUltimo(){return ultimo;}


    @Override
    public String toString(){
        return car+ " " +cod+ " " +preco_base+ " " +lotacao+ " "+local;
    }
}
