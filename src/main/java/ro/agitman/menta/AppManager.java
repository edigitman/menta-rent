package ro.agitman.menta;

import org.mentawai.core.ApplicationManager;
import ro.agitman.menta.action.HelloAction;

public class AppManager extends ApplicationManager {

	public static final String PAGE_INDEX = "/jsp/index.jsp";

	@Override
	public void loadActions() {
		
		action("/Hello", HelloAction.class, "hi")
			.on(SUCCESS, fwd(PAGE_INDEX));
		
	}
	
}