package hotel;

public class Client {


    private int id_client;
    private String civilite;
    private String nom;
    private String prenom;
    private String adresse;
    private String codePostal;
    private String ville;
    private int id_pays;



    public Client(int id_client, String civilite, String nom, String prenom, String adresse, String codePostal, String ville) {
        this.id_client = id_client;
        this.civilite = civilite;
        this.nom = nom;
        this.id_client = id_client;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.id_pays = id_pays;
    }



    @Override
    public String toString() {
        return   civilite  +" "+ nom+ " "+prenom;

    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getId_pays() {
        return id_pays;
    }

    public void setId_pays(int id_pays) {
        this.id_pays = id_pays;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
}
