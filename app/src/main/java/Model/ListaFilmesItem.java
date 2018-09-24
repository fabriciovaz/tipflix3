package Model;

public class ListaFilmesItem {
    private String nome;
    private int capaListaImg;
    private int idLista;

    public ListaFilmesItem(String nome, int capaListaImg, int idLista) {
        this.nome = nome;
        this.capaListaImg = capaListaImg;
        this.idLista = idLista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapaListaImg() {
        return capaListaImg;
    }

    public void setCapaListaImg(int capaListaImg) {
        this.capaListaImg = capaListaImg;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public ListaFilmesItem(String nome, int idLista) {
        this.nome = nome;
        this.idLista = idLista;
    }
}
