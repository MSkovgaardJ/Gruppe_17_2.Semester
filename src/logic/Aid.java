package logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Morten Skovgaard
 */

public class Aid
{
    private int aidNo;
    private String aidName;
    private String aidDescription;
    
    public List<Aid> aids()
    {
        List<Aid> aids = new ArrayList<>();
        
        return aids;
    }
    
    public int getAidNo()
    {
        return aidNo;
    }
    
    public String getAidName(int aidNo)
    {
        
        return aidName;
    }
    
    public String getAidDescription(int aidNo)
    {
        
        return aidDescription;
    }

}
