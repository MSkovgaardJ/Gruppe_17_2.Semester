/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.sql.SQLException;
import java.util.List;
import logik.Aid;

/**
 *
 * @author mortenskovgaard
 */
public interface IAid
{

    List<Aid> aids() throws ClassNotFoundException, SQLException;

    String getAidDescribsion();

    String getAidName();
    
}
