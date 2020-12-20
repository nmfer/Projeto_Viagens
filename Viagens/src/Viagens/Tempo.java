package Viagens;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Tempo implements Serializable {
    private int hora;
    private int minuto;
    private int dia;
    private int mes;
    private int ano;

    LocalDateTime dataComputer = LocalDateTime.now();
    private int hour_now = dataComputer.getHour();
    private int minute_now = dataComputer.getMinute();
    private int day_now = dataComputer.getDayOfMonth();
    private int month_now = dataComputer.getMonthValue();
    private int year_now = dataComputer.getYear();

    public Tempo(){}


    public void setHora(int hora) throws TimeException{
        if((dia == day_now) && (mes == month_now) && (ano == year_now)){
            throw new TimeException("Impossivel introduzir viagem no mesmo dia");
        }else {
            if ((hora < 0) || (hora > 23)) {
                throw new TimeException("Introdução tempo incorreta-> introduza entre: 0h-23h");
            } else {
                this.hora = hora;
            }
        }
    }
    public void setMinuto(int minuto) throws TimeException{
        if((dia == day_now) && (mes == month_now) && (ano == year_now)){
            throw new TimeException("Impossivel introduzir viagem no mesmo dia");
        }else {
            if ((minuto < 0) || (minuto > 59)) {
                throw new TimeException("Introdução tempo incorreta-> introduza entre: 0min-59min");
            } else {
                this.minuto = minuto;
            }
        }
    }
    public void setDia(int dia)throws TimeException {
        if((dia < 1) || (mes > 30)){
            throw new TimeException("Introdução tempo incorreta-> introduza entre: ahhhh");
        }else{
            this.dia = dia;
        };
    }
    public void setMes(int mes) throws TimeException{
        if((mes < 1) || (mes > 12)){
            throw new TimeException("Introdução tempo incorreta-> introduza entre: 1(Janeiro)-12(Dezembro");
        }else{
            this.mes = mes;
        }
    }
    public void setAno(int ano) throws TimeException{
        if(ano < year_now){
            throw new TimeException("Introdução tempo incorreta-> introduza entre: oof");
        }else{
            this.ano = ano;
        }
    }
    public void checkDay() throws TimeException{
        if((dia == day_now) && (mes == month_now) && (ano == year_now)) {
            throw new TimeException("Impossivel introduzir viagem no mesmo dia");
        }
    }

    /*public void setHora(int hora){
        this.hora = hora;
    }
    public void setMinuto(int minuto){
        this.minuto = minuto;
    }
    public void setDia(int dia){
        this.dia = dia;
    }
    public void setMes(int mes){
        this.mes = mes;
    }
    public void setAno(int ano){
        this.ano = ano;
    }*/
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


}
