import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args)
    {
            Mediateur m = new Mediateur();
            int menu = 0;

            while(true) {
                System.out.println("Bonjour ! Quelle requête souhaitez-vous lancer ?");
                System.out.println("1 - Afficher pour chaque enseignant, son nombre total d’heures assurées.");
                System.out.println("2 - Retourner le nombre d’étudiants dont le pays de Provenance est la ‘France’.");
                System.out.println("3 - Afficher le nombre de cours par Type (CM, TD ou TP).");
                System.out.println("0 - Quitter.");
                Scanner sc = new Scanner(System.in);
                menu = sc.nextInt();
                switch (menu) {
                    case 1:
                        break;
                    case 2 :
                        m.nbEtudiantsFrance();
                        try {
                            sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3 :
                        m.nombreTP();
                        m.nombreCM();
                        m.nombreTD();
                        try {
                            sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 0:
                        return;
                }
                m.fin();
            }

    }
}
