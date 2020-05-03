import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class AdaptateurAccess {
	private Connection co;
	private Statement st;

    public AdaptateurAccess()
    {

    }

    private void connexion() throws SQLException, ClassNotFoundException
    {
        
    }

    private void deconnexion()
    {
    }

    public Hashtable NbheuresEns(){
        Hashtable h = new Hashtable();

        return h;
    }

    public int nbEtudiantFrance()
    {/*
    	int nombreEtuFrancais = 0;
        ResultSet res = select("SELECT count(*) FROM Etudiant WHERE Pays_Formation_precedente='fr'");
        try {
            res.next();
            nombreEtuFrancais = res.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreEtuFrancais;
        */
        return 1;
    }
    
    public int nbCours(String type)
    {
        return 1;
    }
    
    public int noteMaximal(String type)
    {
    	return 1;
    }
  /*
   private ResultSet select(String sql)
    {
        ResultSet res = null;
        try {
            st = co.createStatement();
            res = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Anomalie lors de l'execution de la requête");
        }
        return res;
    }*/

    public int nbHeuresEnseignant() {
        return 1;
    }
}
