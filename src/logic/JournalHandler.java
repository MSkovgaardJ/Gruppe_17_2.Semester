package logic;

import common.ICitizen;
import common.IJournal;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
        if(activeJournal != null && activeCitizen != null)            
        {
            System.out.println("active journal : "+ activeJournal.getID());
            try
            {
                File f = new File(activeJournal.getJournalLocation());
                if(!f.exists()){
                    System.out.println("no file found, making new. ");
                    String temppath = "journals/JournalTemp.dot";
                    String path = "journals/"+activeCitizen.getSSN()+"-"+activeJournal.getID()+".doc";
                    f = new File(temppath);
                    
                    InputStream is = null;
                    OutputStream os = null;
                 
                    is = new FileInputStream(temppath);
                    os = new FileOutputStream(path);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = is.read(buffer)) > 0) {
                        os.write(buffer, 0, length);
                    }                   
                    is.close();
                    os.close();
                    
                    activeJournal.setJournalLocation(path);
                    f = new File(path);
                    System.out.println("success");
                }
                Desktop.getDesktop().open(f);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
