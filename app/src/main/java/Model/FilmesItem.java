package Model;

public class FilmesItem {
    private  String nomeFilme;
    private int poster;
    private int id;
    private  String sinopse;

    public FilmesItem(String nomeFilme, int poster, int id) {
        this.nomeFilme = nomeFilme;
        this.poster = poster;
        this.id = id;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public FilmesItem(String nomeFilme, int poster, int id, String sinopse) {

        this.nomeFilme = nomeFilme;
        this.poster = poster;
        this.id = id;
        this.sinopse = sinopse;
    }

    public String getNomeFilme() {

        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
