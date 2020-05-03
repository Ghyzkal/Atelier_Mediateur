public class Mediateur {

    private AdaptateurExcel excel;
    private AdaptateurXML xml;
    private AdaptateurOracle oracle;

    public Mediateur(){
        excel = new AdaptateurExcel();
        xml = new AdaptateurXML();
        oracle = new AdaptateurOracle();
    }


    public int nbEtudiantsFrance(){
        affichageValeurs("nbEtudiantsFrance", excel.nbEtudiantFrance(),xml.nbEtudiantFrance(),oracle.nbEtudiantFrance());
        return xml.nbEtudiantFrance() + excel.nbEtudiantFrance() + oracle.nbEtudiantFrance();
    }

    public int nbHeuresEnseignant()
    {
        affichageValeurs("nbHeuresEnseignant", excel.nbHeuresEnseignant(),xml.nbHeuresEnseignant(),oracle.nbHeuresEnseignant());
        return xml.nbHeuresEnseignant() + excel.nbHeuresEnseignant() + oracle.nbHeuresEnseignant();
    }

    public int nombreCM()
    {
        affichageValeurs("nombreCM", excel.nbCours("CM") , xml.nbCours("CM") , oracle.nbCours("CM"));
        return oracle.nbCours("CM") + xml.nbCours("CM") + excel.nbCours("CM");
    }

    public int nombreTD()
    {
        affichageValeurs("nombreTD", excel.nbCours("TD") , xml.nbCours("TD") , oracle.nbCours("TD"));
        return oracle.nbCours("TD") + xml.nbCours("TD") + excel.nbCours("TD");
    }

    public int nombreTP()
    {
        affichageValeurs("nombreTP", excel.nbCours("TP") , xml.nbCours("TP") , oracle.nbCours("TP"));
        return oracle.nbCours("TP") + xml.nbCours("TP") + excel.nbCours("TP");
    }

    private void affichageValeurs(String nomFonction, int vExcel, int vXML, int vOracle)
    {
        int resultat = vExcel + vXML + vOracle;
        if (nomFonction.equals("nbHeuresEnseignant")){

        }
        else if (nomFonction.equals("nombreCM"))
            System.out.println("Nombre d'heures de CM : " + resultat);
        else if (nomFonction.equals("nombreTD"))
            System.out.println("Nombre d'heures de TD : " + resultat);
        else if (nomFonction.equals("nombreTP"))
            System.out.println("Nombre d'heures de TP : " + resultat);
        else if (nomFonction.equals("nbEtudiantsFrance"))
            System.out.println("Nombre d'étudiants provenant de France : " + resultat);
        else if (nomFonction.equals("nbHeuresEnseignant"))
            System.out.println("Nombre d'étudiants provenant de France : " + resultat);
    }

    public void fin()
    {
        excel.deconnexion();
    }
}
