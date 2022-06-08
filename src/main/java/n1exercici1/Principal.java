package n1exercici1;

public class Principal {

    public static void main(String[] args) {


        TreballadorOnline treballadorOnline =
                new TreballadorOnline("Julian","Muñoz",300.0);

        TreballadorPresencial treballadorPresencial =
                new TreballadorPresencial("Isabel", "Pantoja", 154.99);


        // Printing results
        System.out.println("\n" +
                "\n" +
                "  /$$$$$$              /$$     /$$             /$$                        \n" +
                " /$$__  $$            | $$    |__/            | $$                        \n" +
                "| $$  \\ $$  /$$$$$$  /$$$$$$   /$$  /$$$$$$$ /$$$$$$    /$$$$$$   /$$$$$$$\n" +
                "| $$$$$$$$ /$$__  $$|_  $$_/  | $$ /$$_____/|_  $$_/   |____  $$ /$$_____/\n" +
                "| $$__  $$| $$  \\__/  | $$    | $$|  $$$$$$   | $$      /$$$$$$$|  $$$$$$ \n" +
                "| $$  | $$| $$        | $$ /$$| $$ \\____  $$  | $$ /$$ /$$__  $$ \\____  $$\n" +
                "| $$  | $$| $$        |  $$$$/| $$ /$$$$$$$/  |  $$$$/|  $$$$$$$ /$$$$$$$/\n" +
                "|__/  |__/|__/         \\___/  |__/|_______/    \\___/   \\_______/|_______/ \n" +
                "                                                                          \n" +
                "\n");
        System.out.printf("%-28s %-20s  %-5s\n%s", "Object", "calcularSou()", "Class",
                "-----------------------------------------------------------------------\n");
        System.out.printf("%-28s : %-12.2f : %-5s\n",treballadorPresencial.getNomCognom() + " cobrará"
                ,treballadorPresencial.getNomCognom(),treballadorPresencial.getClass().getSimpleName() );
        System.out.printf("%-28s : %-12.2f : %-5s\n",treballadorOnline.getNomCognom() + " cobrará"
                ,treballadorOnline.calcularSou(10),treballadorOnline.getClass().getSimpleName() );

    }
}
