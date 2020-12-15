package viagem;

import java.util.ArrayList;
public class Viagem {
    // Colecao de origens
    private ArrayList<Origem> origem;
    // Colecao de destinos
    private ArrayList <Destino> destino;
    private int data;
    private int hora;
    private String companhia;
    private int duracao;
    private float valorVendas;
    
    // Maquina de Vender Bilhetes

	// Construtor para inicializar a listas
    public Viagem(){
        this.origem = new ArrayList <Origem>();
        this.destino = new ArrayList <Destino>(); 
    }
    public Viagem(int data, int hora, String companhia, int duracao, float valorVendas) {
        
        this.hora = hora;
        this.data = data;
        this.companhia = companhia;
        this.duracao = duracao;
        this.valorVendas = valorVendas;
    }

    public int getDuracao() {
        return duracao;
    }

    public boolean setDuracao(int horas) {
        if (horas < 1) {
            return false;
        }
        duracao = horas;
        return true;
    }

    public float getValorVendas() {
        return valorVendas;
    }

    public boolean setValorVendas(float valor) {
        if (valor >= 0) {
            valorVendas = valor;
            return true;
        } else {
            return false;
        }
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }
 

}
