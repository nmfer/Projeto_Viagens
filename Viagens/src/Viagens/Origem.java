package viagem;

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
    @Override
    public String toString() {
        return "Origem{" + "pais=" + pais + ", cidade=" + cidade + '}';
    }
}
