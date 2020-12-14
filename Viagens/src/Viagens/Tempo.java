package Viagens;

import java.io.Serializable;

public class Tempo implements Serializable {
    private int hora;
    private int minuto;
    private int dia;
    private int mes;
    private int ano;

    //public Tempo(){}
    public Tempo(int hora, int minuto, int dia, int mes, int ano){
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
    }

    public void setHora(int hora){this.hora = hora;}
    public void setMinuto(int minuto){this.minuto = minuto;}
    public void setDia(int dia){this.dia = dia;}
    public void setMes(int mes){this.mes = mes;}
    public void setAno(int ano){this.ano = ano;}

    public int getHora() { return  this.hora;}
    public int getMinuto() { return  this.minuto;}
    public int getDia() { return  this.dia;}
    public int getMes() { return  this.mes;}
    public int getAno() { return  this.ano;}

    /*public String toString(){
        return (""+this.hora + this.minuto + this.dia + this.mes + this.ano);
    }*/
}
