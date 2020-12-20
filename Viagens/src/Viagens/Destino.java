package Viagens;

public class Destino {
    private String pais;
    private String cidade;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public boolean equals(Object obj){
        if(obj!=null && this.getClass() == obj.getClass()){
            Destino d = (Destino)obj;
            return this.pais.equals(d.pais) && this.cidade.equals(d.cidade);
        }
        return false;
    }
    @Override
    public String toString() {
        return "Destino{" + "pais=" + pais + ", cidade=" + cidade + '}';
    }

}
