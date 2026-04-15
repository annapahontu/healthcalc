package healthcalc.view;

import java.awt.event.ActionListener;

public interface ViewBMI {
 
    public String getWeightInput();
    public String getHeightInput();
    public boolean wantsClassification();
    public void setResult(String res);
    public void setWeightError(String msg);
    public void setHeightError(String msg);
    public void clearErrors();
    public void setController(ActionListener ctr);
}

