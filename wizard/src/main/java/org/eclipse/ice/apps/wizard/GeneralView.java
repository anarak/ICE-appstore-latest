package org.eclipse.ice.apps.wizard;

import com.vaadin.navigator.View;

import org.eclipse.ice.apps.wizard.MyUI.MyUIServlet;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.declarative.Design;

public class GeneralView extends SpackApps implements View {
	private Navigator navigator;
	final EnvironmentDesign env = new EnvironmentDesign();	
	final FolderEnvironment folderEnv = new FolderEnvironment();
	final DockerEnvironment dockerEnv = new DockerEnvironment();
	private int chkBoxCounter = 0;
	
	public GeneralView() {
		for (int i=0; i<10; i++) {
			final Package pkg = new Package();
			this.packageList.addComponent(pkg);
			pkg.chkBoxPackages.addValueChangeListener( e -> {
				if(pkg.chkBoxPackages.getValue() == true) {
					pkg.lblDependantPackage.setVisible(true);
					this.btnInstall.setEnabled(true);
					chkBoxCounter++;
				}
				if(pkg.chkBoxPackages.getValue() == false) {
					pkg.lblDependantPackage.setVisible(false);
					chkBoxCounter--;
					if (chkBoxCounter == 0) {
						this.btnInstall.setEnabled(false);
					}
				}
			});
		}
		btnAddFromRepo.addClickListener( e -> {        	
	    	getUI();
			UI.getCurrent().addWindow(new repoWindow());
	    });
				
		this.btnAdvanced.setIcon(FontAwesome.CARET_RIGHT);
		this.btnAdvanced.addClickListener( e -> {
			if (btnAdvanced.getIcon().equals(FontAwesome.CARET_RIGHT)) {
				vlayoutEnvironment.addComponent(env);
				this.btnAdvanced.setIcon(FontAwesome.CARET_DOWN);
			}
			else if (btnAdvanced.getIcon().equals(FontAwesome.CARET_DOWN)) {
				vlayoutEnvironment.removeComponent(env);
				this.btnAdvanced.setIcon(FontAwesome.CARET_RIGHT);
			}
		});
		env.optionGroupInstallType.select("Docker container");
		env.envVerticalLayout.addComponent(dockerEnv);
		env.optionGroupInstallType.setItemCaption("Docker container", "Docker");
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		navigator = getUI().getNavigator();
		env.optionGroupInstallType.addValueChangeListener( e -> {
			if (env.optionGroupInstallType.getValue().equals("Folder")) {
				if (dockerEnv.isVisible()) {
					env.envVerticalLayout.addComponent(folderEnv);
					env.envVerticalLayout.removeComponent(dockerEnv);
				}
			}
			if (env.optionGroupInstallType.getValue().equals("Docker container")) {
				if (folderEnv.isVisible() || !dockerEnv.isVisible()) {
					env.envVerticalLayout.addComponent(dockerEnv);
					env.envVerticalLayout.removeComponent(folderEnv);					
				}
			}
		});
		
		navigator = getUI().getNavigator();
//        env.btnEnvBack.addClickListener( e -> {
//        	navigator.navigateTo("");
//       	});             
	}

}
