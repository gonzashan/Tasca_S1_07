package n1exercici1;

public class TreballadorPresencial extends Treballador {

    private static final double BENZINA = 200.90;

    public TreballadorPresencial(String nom, String cognom, double preuHora) {
        super(nom, cognom, preuHora);
    }

    @Override
    public double calcularSou(int horas) {

        return (super.calcularSou(horas) + BENZINA);
    }

}
