import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

class AdaptateurXML {
    private ArrayList<Etudiant> listeEtudiant;
    private ArrayList<Enseignant> listeEnseignant;
    private ArrayList<Cours> listeCours;
    private String path="C:/Users/Rayan/Desktop/Integration de Données/TD1/src/main/resources/Univ_BD_3.xml";
    private void lire_XML(String path) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException {

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        org.w3c.dom.Document doc = builderFactory.newDocumentBuilder().parse(new FileInputStream(path));
        Element E, E_1;

        listeEtudiant = new ArrayList();
        listeEnseignant=new ArrayList();
        listeCours=new ArrayList();
        NodeList L;

        //liste des etudiants
        NodeList etudiants = ((org.w3c.dom.Document) doc).getElementsByTagName("Etudiant");

        for (int index = 0; index < etudiants.getLength(); index++) {
            // un etudiant
            E = (Element) etudiants.item(index);

            L = E.getElementsByTagName("NumEt");
            E_1 = (Element) L.item(0); // un seul noeud NumEt
            byte numEt= Byte.parseByte(E_1.getTextContent());

            L = E.getElementsByTagName("nom");
            E_1 = (Element) L.item(0);
            String nom  = E_1.getTextContent();

            L = E.getElementsByTagName("Provenance");
            E_1 = (Element) L.item(0);
            String provenance  = E_1.getTextContent();

            L = E.getElementsByTagName("FormationPrecedante");
            E_1 = (Element) L.item(0);
            String formationPrecedente  = E_1.getTextContent();

            L = E.getElementsByTagName("Pays_formation_precedante");
            E_1 = (Element) L.item(0);
            String paysFormationPrecedente  = E_1.getTextContent();

            L = E.getElementsByTagName("AnneeDebut");
            E_1 = (Element) L.item(0);
            short anneeDebut  = Short.parseShort(E_1.getTextContent());


            L = E.getElementsByTagName("dateNaissance");
            E_1 = (Element) L.item(0);
            int age  = Integer.parseInt(E_1.getTextContent().substring(0,4));


            L = E.getElementsByTagName("Niveau_insertion");
            E_1 = (Element) L.item(0);
            String niveauInsertion  = E_1.getTextContent();
            listeEtudiant.add(new Etudiant(numEt, nom,provenance, formationPrecedente,
                    paysFormationPrecedente, anneeDebut, age, niveauInsertion));
        }
        //liste des inscriptions
        NodeList inscription = ((org.w3c.dom.Document) doc).getElementsByTagName("Inscription");
        ArrayList<Inscription> listeinscrit= new ArrayList();

        for (int i = 0 ; i < inscription.getLength(); i++) {

            // uneinsctiptoin
            E = (Element) inscription.item(i);

            L = E.getElementsByTagName("NumEt");
            E_1 = (Element) L.item(0);
            byte numEt = Byte.parseByte(E_1.getTextContent());

            L = E.getElementsByTagName("Annee_universitaire");
            E_1 = (Element) L.item(0);
            short annee = Short.parseShort(E_1.getTextContent());

            L = E.getElementsByTagName("ID_cours");
            E_1 = (Element) L.item(0);
            byte idcours = Byte.parseByte(E_1.getTextContent());

            L = E.getElementsByTagName("Note_cours");
            E_1 = (Element) L.item(0);
            byte note = Byte.parseByte(E_1.getTextContent());

            for (Etudiant aListeEtudiant : listeEtudiant) {
                if (aListeEtudiant.getNumEt() == numEt) {
                    aListeEtudiant.addInscription(idcours, note, annee);
                    break;
                }
            }

            listeinscrit.add(new Inscription(idcours, note,annee));

        }        //liste des enseignant
        NodeList enseignant = ((org.w3c.dom.Document) doc).getElementsByTagName("Enseignant");

        for (int index = 0; index < enseignant.getLength(); index++) {
            // un enseignant
            E = (Element) enseignant.item(index);

            L = E.getElementsByTagName("NumEns");
            E_1 = (Element) L.item(0); // un seul noeud NumEt
            byte numEns = Byte.parseByte(E_1.getTextContent());

            L = E.getElementsByTagName("Nom");
            E_1 = (Element) L.item(0);
            String nom = E_1.getTextContent();

            L = E.getElementsByTagName("Prenom");
            E_1 = (Element) L.item(0);
            String prenom = E_1.getTextContent();

            L = E.getElementsByTagName("adresseMail");
            E_1 = (Element) L.item(0);
            String adresseMail = E_1.getTextContent();

            listeEnseignant.add(new Enseignant(numEns, nom, prenom, adresseMail));
        }
        //liste des enseignement
        NodeList enseigne = ((org.w3c.dom.Document) doc).getElementsByTagName("Enseigne");
        ArrayList<Enseigne> listeenseignement= new ArrayList();

        for (int i = 0 ; i <  enseigne.getLength(); i++) {

            // un enseignement
            E = (Element) enseigne.item(i);

            L = E.getElementsByTagName("ID_Cours");
            E_1 = (Element) L.item(0); // un seul noeud NumEt
            byte idCours = Byte.parseByte(E_1.getTextContent());

            L = E.getElementsByTagName("Annee_universitaire");
            E_1 = (Element) L.item(0);
            short annee = Short.parseShort(E_1.getTextContent());

            L = E.getElementsByTagName("Nb_heures");
            E_1 = (Element) L.item(0);
            byte Nb_heures = Byte.parseByte(E_1.getTextContent());

            L = E.getElementsByTagName("NumEns");
            E_1 = (Element) L.item(0);
            byte numEns = Byte.parseByte(E_1.getTextContent());

            for (int j=0;j<listeEnseignant.size();j++){
                if (listeEnseignant.get(j).getNumEns()==numEns){
                    listeEnseignant.get(j).addEnseigne(idCours,annee,Nb_heures);
                    break;
                }
            }

        }
        //liste des cours
        NodeList cours = ((org.w3c.dom.Document) doc).getElementsByTagName("Cours");
        //index=1pour chainté les balises XML (qui est sous la forme <Cours><Cours></Cours></Cours>
        for (int index = 1; index < cours.getLength(); index++) {
            // un cours
            E = (Element) cours.item(index);

            L = E.getElementsByTagName("ID_cours");
            E_1 = (Element) L.item(0); // un seul noeud NumEt
            byte idCours = Byte.parseByte(E_1.getTextContent());

            L = E.getElementsByTagName("Type");
            E_1 = (Element) L.item(0);
            String type = E_1.getTextContent();

            L = E.getElementsByTagName("Nb_heures");
            E_1 = (Element) L.item(0);
            byte nbheure = Byte.parseByte(E_1.getTextContent());

            L = E.getElementsByTagName("Niveau");
            E_1 = (Element) L.item(0);
            String niveau = E_1.getTextContent();

            listeCours.add(new Cours(idCours, type, niveau, nbheure));


        }
    }

    public Hashtable<String, Integer> nbHeuresEnseignant() throws ParserConfigurationException, SAXException, IOException {
        Hashtable<String, Integer> Result=new Hashtable();
        lire_XML(path);
        for(int i=0; i<listeEnseignant.size();i++) {
            Integer cpt_heures=0;
            for (int j = 0; j < listeEnseignant.get(i).getListeEnseignement().size(); j++) {
                cpt_heures += listeEnseignant.get(i).getListeEnseignement().get(j).getNbHeure();
            }
            Result.put(listeEnseignant.get(i).getNom(), cpt_heures);
        }
        return Result;
    }

    public int nbEtudiantFrance() throws ParserConfigurationException, SAXException, IOException {
        lire_XML(path);
        int cpt_etud=0;
        for(int i=0; i<listeEtudiant.size();i++){
            if (listeEtudiant.get(i).getProvenance().equals("France")) {
                cpt_etud++;
            }
        }
        return cpt_etud;
    }

    public int nbCours(String type) throws ParserConfigurationException, SAXException, IOException {
        lire_XML(path);
        if (type.equals("TD")) type="Travaux diriges";
        else if(type.equals("CM")) type="Cours Magistral";
        else return 0;
        int cpt=0;
        for(int i=0; i<listeCours.size(); i++){
            if (listeCours.get(i).getType().equals(type)) cpt++;
        }
        return cpt;
    }
}

class Etudiant {
    private byte numEt;
    private String nom;
    private String provenance;
    private String formationPrecedente;
    private String paysFormationPrecedente;
    private short anneeDebut;
    private int age;
    private String niveauInsertion;
    ArrayList<Inscription> listeInscription;
    public Etudiant(byte NumEt,String nom, String provenance, String formationPrecedente,
                    String paysFormationPrecedente,short anneeDebut,int age, String niveauInsertion){
        this.numEt=NumEt;
        this.nom=nom;
        this.provenance=provenance;
        this.formationPrecedente=formationPrecedente;
        this.paysFormationPrecedente=paysFormationPrecedente;
        this.anneeDebut=anneeDebut;
        this.age=age;
        this.niveauInsertion=niveauInsertion;
        this.listeInscription=new ArrayList();

    }

    public void addInscription(byte idCours, byte note_cours, short annee){
        listeInscription.add(new Inscription(idCours,note_cours,annee));
    }

    public byte getNumEt() {
        return numEt;
    }

    public String getProvenance() {
        return provenance;
    }

}

class Enseignant {
    private byte numEns;
    private String nom;
    private String prenom;
    private String adresseMail;
    private ArrayList<Enseigne> listeEnseignement;
    public Enseignant(byte numEns, String nom, String prenom, String adresseMail){
        this.numEns=numEns;
        this.nom=nom;
        this.prenom=prenom;
        this.adresseMail=adresseMail;
        this.listeEnseignement= new ArrayList();
    }
    public void addEnseigne(byte idCours, short annee, byte nbHeure){
        listeEnseignement.add(new Enseigne(idCours,annee,nbHeure));
    }

    public byte getNumEns() {
        return numEns;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Enseigne> getListeEnseignement() {
        return listeEnseignement;
    }
}

class Cours{
    private byte idCours;
    private String type;
    private String niveau;
    private byte nbHeure;

    public Cours(byte idCours, String type, String niveau, byte nbHeure){
        this.idCours=idCours;
        this.type=type;
        this.niveau=niveau;
        this.nbHeure=nbHeure;
    }

    public Cours(byte idCours, String niveau, byte nb_heures) {
        this.idCours=idCours;
        this.niveau=niveau;
        this.nbHeure=nbHeure;
    }

    public String getType() {
        return type;
    }
}

class Inscription{
    private byte idCours;
    private byte note_cours;
    private short annee;

    public Inscription(byte idCours, byte note_cours, short annee){
        this.idCours=idCours;
        this.note_cours=note_cours;
        this.annee=annee;
    }
}

class Enseigne{
    byte idCours;
    private short annee;
    private byte nbHeure;

    public Enseigne( byte idCours, short annee, byte nbHeure){
        this.idCours=idCours;
        this.annee=annee;
        this.nbHeure=nbHeure;
    }

    byte getNbHeure() {
        return nbHeure;
    }
}


