package logic;

import common.IAid;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Morten Skovgaard
 */

public class Aid implements IAid
{
    private int aidNo;
    private String aidName;
    private String aidDescription;
    
    @Override
    public List<Aid> aids()
    {
        List<Aid> aids = new ArrayList<>();
        
        return aids;
    }
    
    @Override
    public int getAidNo()
    {
        return aidNo;
    }
    
    @Override
    public String getAidDescribsion()
    {
        return aidDescription;
    }

    @Override
    public String getAidName()
    {
        return aidName;
    }

}
