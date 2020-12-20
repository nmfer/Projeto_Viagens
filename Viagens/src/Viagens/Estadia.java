package Viagens;

import java.io.Serializable;

public class Estadia extends Tempo implements Serializable {
    private String name;
    //private String tipo;
    private int cod;
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
    public int getPessoas_quarto() { return this.pessoas_quarto;}
    public static int getUltimo(){return ultimo;}

    //custo da estadia tendo em conta a data de compra da mesma
    public double preco_viagem(){
        double preco_final = preco_base;
        //determinar o preco da viagem tendo em conta a data/data de compra
        if(falta_ano(super.getAno()) >= 1 && falta_mes(super.getMes()) >= 12){
            preco_final = this.preco_base - (this.preco_base * 0.30);
            return preco_final;
        }if(falta_ano(super.getAno()) < 1){
            if(falta_mes(super.getMes()) < 12 && falta_mes(super.getMes()) > 6){
                preco_final = this.preco_base - (this.preco_base * 0.20);
                return preco_final;
            }
            if(falta_mes(super.getMes()) == 6){
                preco_final = this.preco_base - (this.preco_base * 0.15);
                return preco_final;
            }
            if(falta_mes(super.getMes()) < 6 && falta_mes(super.getMes()) >= 4){
                preco_final = this.preco_base - (this.preco_base * 0.1);
                return preco_final;
            }
            if(falta_mes(super.getMes()) < 4 && falta_mes(super.getMes()) >= 3){
                preco_final = this.preco_base - (this.preco_base * 0.05);
                return preco_final;
            }
            if(falta_mes(super.getMes()) < 3 && falta_mes(super.getMes()) >= 1){
                preco_final = this.preco_base + (this.preco_base * 0.1);
                return preco_final;
            }
            if(falta_mes(super.getMes()) < 1){
                if(falta_dia(super.getDia()) < 27 && falta_dia(super.getDia()) >= 15){
                    preco_final = this.preco_base + (this.preco_base * 0.2);
                    return preco_final;
                }
                if(falta_dia(super.getDia()) < 15 && falta_dia(super.getDia()) >= 7){
                    preco_final = this.preco_base + (this.preco_base * 0.35);
                    return preco_final;
                }
                if(falta_dia(super.getDia()) < 7 && falta_dia(super.getDia()) > 1){
                    preco_final = this.preco_base + (this.preco_base * 0.5);
                    return preco_final;
                }
                if(falta_dia(super.getDia()) == 1){
                    preco_final = this.preco_base + (this.preco_base * 0.75);
                    return preco_final;
                }

            }

        }
        if(falta_ano(super.getAno()) == 0 && falta_mes(super.getMes()) == 0 && super.getDia() == 0){
            if(falta_dia(super.getDia()) < 7){
                preco_final = 2 * this.preco_base;
                return preco_final;
            }
        }
        return preco_final;
    }
    @Override
    public String toString(){
        return name+ " " +cod+ " " +preco_base+ " " +pessoas_quarto;
    }
}
