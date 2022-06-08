package n1exercici1;

public class TreballadorOnline extends Treballador {

    private final double TARIFA_INTERNET = 69.30;

    public TreballadorOnline(String nom, String cognom, double preuHora) {
        super(nom, cognom, preuHora);
    }

    @Override
    public double calcularSou(int horas) {

        return (super.calcularSou(horas) + TARIFA_INTERNET);
    }
}
