package hotel;

public class Pays {
    private int id;
    private String nom;

    public Pays(int id,String nom){
        this.id=id;
        this.nom=nom;

    }

    public Pays(String text) {
    }

    @Override
    public String toString() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
