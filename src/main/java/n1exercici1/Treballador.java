package n1exercici1;

public class Treballador {

    private String nom, cognom;
    private double preuHora;

    public Treballador(String nom, String cognom, double preuHora) {
        this.nom = nom;
        this.cognom = cognom;
        this.preuHora = preuHora;
    }

    public String getNomCognom(){

        return this.nom + " " + this.cognom;
    }

    public double calcularSou(int horas){

        return this.preuHora * horas;

    }
}
