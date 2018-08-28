package hotel;

public class Chambre {
    private int id;
    private int capacite;
    private String exposition;
    private int douche;
    private int etage;
    private int idTarif;
    private double prix;

    public Chambre(int id, int capacite, String exposition, int douche, int etage, int idTarif, double prix) {
        this.id = id;
        this.capacite = capacite;
        this.exposition = exposition;
        this.douche = douche;
        this.etage = etage;
        this.idTarif = idTarif;
        this.prix = prix;
    }

    public Chambre() {

    }

    @Override
    public String toString() {
        return  "Chambre{" +
                "id=" + id +
                ", capacite=" + capacite +
                ", exposition='" + exposition + '\'' +
                ", douche=" + douche +
                ", etage=" + etage +
                ", idTarif=" + idTarif +
                ", prix="+ prix +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getExposition() {
        return exposition;
    }

    public void setExposition(String exposition) {
        this.exposition = exposition;
    }

    public int getDouche() {
        return douche;
    }

    public void setDouche(int douche) {
        this.douche = douche;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public int getIdTarif() {
        return idTarif;
    }

    public void setIdTarif(int idTarif) {
        this.idTarif = idTarif;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

}
