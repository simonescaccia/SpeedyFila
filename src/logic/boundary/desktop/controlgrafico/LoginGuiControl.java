package logic.boundary.desktop.controlgrafico;

import logic.boundary.desktop.view.GenericView;
import logic.boundary.desktop.view.LoginGoogleView;
import logic.control.bean.LoginBean;
import logic.control.bean.MessageBean;
import logic.control.controlapplicativo.LoginControl;
import logic.exception.DBFailureException;

public class LoginGuiControl {
	
	private GenericView gV;
	private LoginControl lC;
	
	public LoginGuiControl() {
		lC = new LoginControl();
	}
	
	public LoginControl getLoginControl() {
		return lC;
	}
	
	public void login(GenericView gView) {
		gV = gView;
		LoginGoogleView lGV = new LoginGoogleView();
		lGV.loginDesktop(this);
	}
	
	public void setLoginState(LoginBean lBean) {
		//verificare se l'utente � gi� stato inserito nel database e aggiungere il Park Visitor se non presente nel database 	
		try {
			lC.verifyUserOnDB(lBean.getUserID());
			lC.getLoginBean().setAccessToken(lBean.getAccessToken());
			lC.getLoginBean().setUserID(lBean.getUserID());
			gV.loginOn();
		} catch (DBFailureException e) {
			MessageBean mB = new MessageBean(e.getMessage(), false);
			gV.getGenericGuiControl().showMessage(mB);
		}
	}
	
	public void logout(GenericView gView) {
		
		String aT = lC.getLoginBean().getAccessToken();
		LoginGoogleView lGV = new LoginGoogleView();
		if(lGV.revokeTokenDesktop(aT)){
			lC.getLoginBean().setAccessToken(null);
			lC.getLoginBean().setUserID(null);
			gView.loginOff();
		}
	}
}
