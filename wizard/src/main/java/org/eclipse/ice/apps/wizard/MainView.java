package org.eclipse.ice.apps.wizard;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.VerticalLayout;

public class MainView extends EnvironmentDesign implements View {

	private Navigator navigator;
	final FolderEnvironment folderEnv = new FolderEnvironment();
	final DockerEnvironment dockerEnv = new DockerEnvironment();
	
	@Override
	public void enter(ViewChangeEvent event) {
		optionGroupInstallType.addValueChangeListener( e -> {
			if (optionGroupInstallType.getValue().equals("Folder")) {
				envVerticalLayout.addComponent(folderEnv);
				if (dockerEnv.isVisible()) {
					envVerticalLayout.removeComponent(dockerEnv);
				}
			}
			if (optionGroupInstallType.getValue().equals("Docker container")) {
				envVerticalLayout.addComponent(dockerEnv);
				if (folderEnv.isVisible()) {
					envVerticalLayout.removeComponent(folderEnv);					
				}
			}
		});
		
		navigator = getUI().getNavigator();
//        btnEnvBack.addClickListener( e -> {
//        	navigator.navigateTo("");
//       	});             
	}

}
