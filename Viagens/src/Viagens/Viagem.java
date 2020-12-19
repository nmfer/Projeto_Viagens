package Viagens;

import java.io.*;
import java.util.ArrayList;

public class Viagem extends Tempo implements Serializable {
    //private String origem;
    //private String destino;

    // Colecao de origens
    private ArrayList<Origem> origem;
    // Colecao de destinos
    private ArrayList <Destino> destino;

    private int duracao;
    private float valorVendas;
    private String companhia = " ";
    private static int ultimo = 0;
    private int cod;
    //ArrayList<Viagem> viagem = new ArrayList<Viagem>();

    //public Viagem(Tempo t){ super();}

    public Viagem(String origem, String destino, int duracao, float valorVendas, Tempo t){
        super();
        this.origem = new ArrayList <Origem>();
        this.destino = new ArrayList <Destino>();
        this.duracao = duracao;
        this.valorVendas = valorVendas;
        this.cod = ultimo++;
    }

    //getters e setters
    public void setCompanhia(String companhia){ this.companhia = companhia;}
    /*public void setOrigem(String origem){
        this.origem = origem;
    }
    public void setDestino(String destino){
        this.destino = destino;
    }*/
    public static void setUltimo(int cod) {Viagem.ultimo = ultimo;}
    public void setCod(int cod){ this.cod = cod;}
    public boolean setDuracao(int horas) {
        if (horas < 1) {
            return false;
        }
        duracao = horas;
        return true;
    }
    public boolean setValorVendas(float valor) {
        if (valor >= 0) {
            valorVendas = valor;
            return true;
        } else {
            return false;
        }
    }

    public String getCompanhia(){ return this.companhia;}
    /*public String getOrigem(){
        return this.origem;
    }
    public String getDestino(){
        return this.destino;
    }*/
    public static int getUltimo() { return ultimo;}
    public int getCod() {return cod;}
    public int getDuracao() {
        return duracao;
    }
    public float getValorVendas() {
        return valorVendas;
    }


    @Override
    public String toString(){
        return cod + " = " + origem+" -> "+destino+" na data: "+ super.getDia()+"/"+super.getMes()+"/"+super.getAno()+" às: "+super.getHora()+":"+super.getMinuto()+" pela companhia " +companhia;
    }

}
