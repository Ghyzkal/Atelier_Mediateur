import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AdaptateurXML2 {
    /*
    private String getAttribute(Element E, String attribute)
    {
        
    }
    */
    public int nbEtudiantFrance()
    {
    return 1;
    }
    
    public int nbCours(String type)
    {
    	return 1;
    }

    public int nbHeuresEnseignant() {
        return 1;
    }

    public Hashtable NbheuresEns(){
        Hashtable h = new Hashtable();
        h.put("Monsieur Caca", 3);
        h.put("Monsieur Prout", 5);
        return h;
    }
}

class Etudiant2
{
	
}

class Cours2
{
	
	
	
}
