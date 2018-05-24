package logic;

import common.ICitizen;
import common.IJournal;

/**
 *
 * @author Morten Skovgaard
 */
public class JournalHandler {

    private IJournal activeJournal;
    private ICitizen activeCitizen;

    public IJournal newJournal() {
        IJournal j = new Journal();
        this.activeJournal = j;
        return j;
    }

    public ICitizen newCitizen() {
        ICitizen c = new Citizen();
        this.activeCitizen = c;
        return c;
    }
    public IJournal getActiveJournal()
    {
        return activeJournal;
    }
    public ICitizen getActiveCitizen()
    {
        return activeCitizen;
    }

    public void setActiveJournal(IJournal activeJournal) {
        this.activeJournal = activeJournal;
    }

    public void setActiveCitizen(ICitizen activeCitizen) {
        this.activeCitizen = activeCitizen;
    }

    public void openJournalDiscription() {

    }
}
