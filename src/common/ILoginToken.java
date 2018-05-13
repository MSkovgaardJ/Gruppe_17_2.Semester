package common;

/**
 *
 * @author magnusm
 */

public interface ILoginToken
{
    public boolean isAdmin();
    public boolean isUser();
    public boolean isCaseHandler();
    public void setClearance(boolean isAdmin, boolean isUser, boolean isCaseHandler);
}
