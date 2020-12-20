package Viagens;

public class Origem {
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
            Origem o = (Origem)obj;
            return this.pais.equals(o.pais) && this.cidade.equals(o.cidade);
        }
        return false;
    }
    @Override
    public String toString() {
        return "Origem{" + "pais=" + pais + ", cidade=" + cidade + '}';
    }
}
