/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.sql.SQLException;
import java.util.List;
import logic.Aid;

/**
 *
 * @author mortenskovgaard
 */
public interface IAid
{
    
    public int getAidNo();
    public String getAidDescribsion();
    public String getAidName();
    public void setAidNo(int aidNo);
    public void setAidName(String aName);
    public void setAidDescribsion(String describsion);    
    public IAid clone();    
}
