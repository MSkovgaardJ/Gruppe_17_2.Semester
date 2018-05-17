package logic;

import common.IAid;
import common.IDBCom;
import data.SQLGet;
import data.postgreSQLCom;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Morten Skovgaard
 */

public class Aid
{
    private int aidID;
    private String aidName;
    private String aidDescription;
    
    public Aid()
    {
        
    }
    
    public List<Aid> aids()
    {
        List<Aid> aids = new ArrayList<>();
        
        return aids;
    }
    
    public String getAidName(int aidID)
    {
        
        return aidName;
    }
    
    public String getAidDescription(int aidID)
    {
        
        return aidDescription;
    }

}
