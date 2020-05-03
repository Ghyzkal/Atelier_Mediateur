import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

public class Mediateur {

    private AdaptateurExcel excel;
    private AdaptateurXML xml;
    private AdaptateurAccess access;

    public Mediateur(){
        excel = new AdaptateurExcel();
        xml = new AdaptateurXML();
        access = new AdaptateurAccess();
    }

    public int nbEtudiantsFrance() throws IOException, SAXException, ParserConfigurationException {
        affichageValeurs("nbEtudiantsFrance", excel.nbEtudiantFrance(),xml.nbEtudiantFrance(),access.nbEtudiantFrance());
        return xml.nbEtudiantFrance() + excel.nbEtudiantFrance() + access.nbEtudiantFrance();
    }

    public void NbheuresEns()throws IOException, SAXException, ParserConfigurationException {
        Hashtable hXML ;
        Hashtable hExcel ;
        Hashtable hAccess ;

        hXML = new Hashtable();
        hExcel = new Hashtable();
        hAccess = new Hashtable();

        hXML = xml.nbHeuresEnseignant();
        hExcel = excel.NbheuresEns();
        hAccess = access.NbheuresEns();

        Enumeration XMLval = hXML.elements();
        Enumeration XMLkey = hXML.keys();

        Enumeration excelval = hExcel.elements();
        Enumeration excelkey = hExcel.keys();

        Enumeration accessval = hAccess.elements();
        Enumeration accesskey = hAccess.keys();

        System.out.println("Valeurs contenues dans la source XML:");
        while (XMLval.hasMoreElements() && XMLkey.hasMoreElements()) {
            System.out.println(XMLkey.nextElement().toString() + " " + XMLval.nextElement()+" heures");
        }
        System.out.println("Valeurs contenues dans la source Excel:" );
        while (excelval.hasMoreElements() && excelkey.hasMoreElements()) {
            System.out.println(excelkey.nextElement().toString() +" "+ excelval.nextElement()+" heures");
        }
        System.out.println("Valeurs contenues dans la source Access: ");
        while (accessval.hasMoreElements() && accesskey.hasMoreElements()) {
            System.out.println(accesskey.nextElement().toString() +" "+ accessval.nextElement()+ " heures");
        }
        System.out.println("");
    }

    public int nombreCM() throws IOException, SAXException, ParserConfigurationException
    {
        affichageValeurs("nombreCM", excel.nbCours("CM") , xml.nbCours("CM") , access.nbCours("CM"));
        return access.nbCours("CM") + xml.nbCours("CM") + excel.nbCours("CM");
    }

    public int nombreTD() throws IOException, SAXException, ParserConfigurationException
    {
        affichageValeurs("nombreTD", excel.nbCours("TD") , xml.nbCours("TD") , access.nbCours("TD"));
        return access.nbCours("TD") + xml.nbCours("TD") + excel.nbCours("TD");
    }

    public int nombreTP()throws IOException, SAXException, ParserConfigurationException
    {
        affichageValeurs("nombreTP", excel.nbCours("TP") , xml.nbCours("TP") , access.nbCours("TP"));
        return access.nbCours("TP") + xml.nbCours("TP") + excel.nbCours("TP");
    }

    private void affichageValeurs(String nomFonction, int vExcel, int vXML, int vaccess)
    {
        int resultat = vExcel + vXML + vaccess;
        if (nomFonction.equals("nombreCM"))
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
