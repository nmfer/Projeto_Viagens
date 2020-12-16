package Viagens;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalDate;

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

    //public Tempo(){}
    public Tempo() {}
       /* //Hora exception
        if((hora < 0) || (hora > 23)){
            throw new TimeException("Introdução tempo incorreta-> introduza entre: 0h-23h");
        }else{
            this.hora = hora;
        }
        //Minuto exception
        if((minuto < 0) || (minuto > 59)){
            throw new TimeException("Introdução tempo incorreta-> introduza entre: 0min-59min");
        }else{
            this.minuto = minuto;
        }
        //Mes exception
        if((mes < 1) || (mes > 12)){
            throw new TimeException("Introdução tempo incorreta-> introduza entre: 1(Janeiro)-12(Dezembro");
        }else{
            this.mes = mes;
        }

        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
    */

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

    public int getHora() { return  this.hora;}
    public int getMinuto() { return  this.minuto;}
    public int getDia() { return  this.dia;}
    public int getMes() { return  this.mes;}
    public int getAno() { return  this.ano;}

    /*public String toString(){
        return (""+this.hora + this.minuto + this.dia + this.mes + this.ano);
    }*/
}
