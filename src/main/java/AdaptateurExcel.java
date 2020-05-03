import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;


public class AdaptateurExcel {
    private Connection conn;

    private final String[] nomFeuille = {"2006","2007"};
    public AdaptateurExcel()
    {
    }

    public void connexion() throws SQLException, ClassNotFoundException
    {
       
    }

    public void deconnexion()
    {
       
    }
    
    public int nbEtudiantFrance()
    {
return 2;
    }
    
    public int nbCours(String type)
    {
    	return 1;
    }

    public Hashtable NbheuresEns(){
        Hashtable h = new Hashtable();
        h.put("Mme pipi", 5);
        return h;
    }
    
    public int noteMaximal(String type)
    {
    return 1;
    }
    /*
    private ResultSet select(String sql)
    {
    	
    }
    */

    public int nbHeuresEnseignant() {
        return 1;
    }
}
