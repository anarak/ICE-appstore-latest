/**
 * 
 */
package org.eclipse.ice.apps.wizard;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

/**
 * @author
 *
 */
public class StartView extends VerticalLayout implements View {

	/* (non-Javadoc)
	 * @see com.vaadin.navigator.View#enter(com.vaadin.navigator.ViewChangeListener.ViewChangeEvent)
	 */
	
	public StartView() {
		setSizeFull();
		
    	final EnvironmentDesign envView = new EnvironmentDesign();
    	final FolderEnvDesign folderView = new FolderEnvDesign();      
        
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		Notification.show("Hi");
		final SpackApps mainView = new SpackApps();
		for (int i=0; i<10; i++) {
			mainView.packageList.addComponent(new Package());
		}
	}

}
