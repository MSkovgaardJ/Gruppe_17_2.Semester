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

    @Override
    public void setAidNo(int aidNo)
    {
     this.aidNo = aidNo;
    }

    @Override
    public void setAidName(String aname)
    {
        this.aidName = aname;
    }

    @Override
    public void setAidDescribsion(String describsion)
    {
        this.aidDescription = describsion;
    }
    public IAid clone()
    {
        IAid aid = new Aid();
        aid.setAidDescribsion(aidDescription);
        aid.setAidName(aidName);
        aid.setAidNo(aidNo);
        return aid;
    }

}
