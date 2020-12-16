package Viagens;

import java.io.*;
import java.util.ArrayList;

public class Viagem extends Tempo implements Serializable {
    private String origem;
    private String destino;
    private String companhia = " ";
    private static int ultimo = 0;
    private int cod;
    //ArrayList<Viagem> viagem = new ArrayList<Viagem>();

    public Viagem(Tempo t){ super();}

    public Viagem(String origem, String destino, Tempo t){
        super();
        this.origem = origem;
        this.destino = destino;
        this.cod = ultimo++;
    }

    //getters e setters
    public void setCompanhia(String companhia){ this.companhia = companhia;}
    public void setOrigem(String origem){
        this.origem = origem;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }
    public static void setUltimo(int cod) {Viagem.ultimo = ultimo;}
    public void setCod(int cod){ this.cod = cod;}

    public String getCompanhia(){ return this.companhia;}
    public String getOrigem(){
        return this.origem;
    }
    public String getDestino(){
        return this.destino;
    }
    public static int getUltimo() { return ultimo;}
    public int getCod() {return cod;}

    @Override
    public String toString(){
        return cod + " = " + origem+" -> "+destino+" na data: "+ super.getDia()+"/"+super.getMes()+"/"+super.getAno()+" às: "+super.getHora()+":"+super.getMinuto()+" pela companhia " +companhia;
    }

}
