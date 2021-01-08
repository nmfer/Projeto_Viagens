package Viagens;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Tempo implements Serializable {
    private int hora = 0;
    private int minuto = 0;
    private int dia = 0;
    private int mes = 0;
    private int ano = 0;

    LocalDateTime dataComputer = LocalDateTime.now();
    private int hour_now = dataComputer.getHour();
    private int minute_now = dataComputer.getMinute();
    private int day_now = dataComputer.getDayOfMonth();
    private int month_now = dataComputer.getMonthValue();
    private int year_now = dataComputer.getYear();

    public Tempo(int ano, int mes, int dia, int hora, int min){
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minuto = min;
    }
    public Tempo(){}


    public void setHora(int hora) throws TimeException{
        if((dia <= day_now) && (mes <= month_now) && (ano <= year_now)){
            throw new TimeException("Impossivel introduzir viagem");
        }else {
            if ((hora < 0) || (hora > 23)) {
                throw new TimeException("Introdução tempo incorreta-> introduza entre: 0h-23h");
            } else {
                this.hora = hora;
            }
        }
    }
    public void setMinuto(int minuto) throws TimeException{
        if((dia <= day_now) && (mes <= month_now) && (ano <= year_now)){
            throw new TimeException("Impossivel introduzir viagem");
        }else {
            if ((minuto < 0) || (minuto > 59)) {
                throw new TimeException("Introdução tempo incorreta-> introduza entre: 0min-59min");
            } else {
                this.minuto = minuto;

            }
        }

    }

    //3º definir o dia
    public void setDia(int dia)throws TimeException {
        if ((dia < 1) || (mes > 31)) {
            throw new TimeException("Introdução dia incorreta");
        }
        this.dia = dia;


    }

    //2º definir mes
    public void setMes(int mes) throws TimeException{
        if((mes < 1) || (mes > 12)){
            throw new TimeException("Introdução mês incorreta-> introduza entre: 1(Janeiro)-12(Dezembro");
        }
        this.mes = mes;

    }

    //1º definir ano
    public void setAno(int ano) throws TimeException{
        if(ano < year_now){
            throw new TimeException("Introdução ano incorreta");
        }
        this.ano = ano;
    }
    public void checkDay() throws TimeException{
        if((dia == day_now) && (mes == month_now) && (ano == year_now)) {
            throw new TimeException("Impossivel introduzir viagem no mesmo dia");
        }
        if((dia<day_now) && (mes<month_now) && (ano<year_now)){
            throw new TimeException("Impossível introduzir viagem");
        }
    }



    public int getHora() { return  this.hora;}
    public int getMinuto() { return  this.minuto;}
    public int getDia() { return  this.dia;}
    public int getMes() { return  this.mes;}
    public int getAno() { return  this.ano;}



    public int falta_hora(int hora){
        int f;
        f = hora - hour_now;
        return f;
    }

    public int falta_minuto(int minuto){
        int f;
        f = minuto - minute_now;
        return f;
    }
    public int falta_ano(int ano){
        int f;
        f = ano - year_now;
        return f;
    }
    public int falta_mes(int mes){
        int f;
        f = mes - month_now;
        return f;
    }
    public int falta_dia(int dia){
        int f;
        f = dia - day_now;
        return f;
    }


    public String toString(){
        String s = ano+mes+dia+ " " +hora+minuto;
        return s;
    }
}
