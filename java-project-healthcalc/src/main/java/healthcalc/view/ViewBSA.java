package healthcalc.view;

import java.awt.event.ActionListener;

import healthcalc.exceptions.InvalidHealthDataException;

public interface ViewBSA {

	String get_w_bas();

	String get_h_bas();

	void setResult(String res);

	void setController(ActionListener ctr);

	void setWeightError(String msg);

	void setHeightError(String msg);

	void clearErrors();

	void setGeneralError(String msg);

}
