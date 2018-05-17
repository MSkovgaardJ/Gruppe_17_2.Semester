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

    List<Aid> aids();
    
    int getAidNo();

    String getAidDescribsion();

    String getAidName();
    
}
