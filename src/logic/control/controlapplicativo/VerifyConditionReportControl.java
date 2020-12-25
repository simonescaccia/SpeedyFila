package logic.control.controlapplicativo;

import logic.entity.model.ParkVisitor;
import logic.entity.model.ParkAttraction;
import logic.boundary.view.ReportGoogleMapsView;

public class VerifyConditionReportControl {

	private ReportGoogleMapsView gm;
	
	public boolean verifyDistance(ParkVisitor user, ParkAttraction attraction) {
		//dummy method
		return true;
	}
	
	public boolean verifyCountDown(ParkVisitor user) {
		//dummy method
		return true;
	}
	
	public void calculateWaitingTime(ParkAttraction attraction, int queuLEN) {
		//dummy method
	}
}