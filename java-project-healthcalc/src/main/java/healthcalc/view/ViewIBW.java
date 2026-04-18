package healthcalc.view;

import java.awt.event.ActionListener;

public interface ViewIBW {
 
    public String getHeightInput();
    public boolean isMaleSelected();
    public void setResult(String res);
    public void setHeightError(String msg);
    public void clearErrors();
    public void setController(ActionListener ctr);
}

