/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author magnusm
 */
public interface ILoginToken {
    public boolean isAdmin();
    public boolean isUser();
    public boolean isCaseHandler();
    public void setClearance(boolean isAdmin, boolean isCaseHandler);
}
