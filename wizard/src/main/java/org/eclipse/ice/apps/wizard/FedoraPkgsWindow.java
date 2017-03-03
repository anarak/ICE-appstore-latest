/**
 * 
 */
package org.eclipse.ice.apps.wizard;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * @author 
 *
 */
public class FedoraPkgsWindow extends Window {
	public FedoraPkgsWindow() {
		super("Fedora package(s) specification");
	
		final VerticalLayout vLayout = new VerticalLayout();
		final HorizontalLayout hLayout = new HorizontalLayout();
		final VerticalLayout repoListVLayout = new VerticalLayout();
		final HorizontalLayout btnsHLayout = new HorizontalLayout();
		final Button btnAddRepo = new Button(FontAwesome.PLUS);
		final Button btnOkRepo = new Button("OK", event -> close());
		final Button btnCancelRepo = new Button("Cancel", event -> close());		
		final TextField txtFieldRepoURL = new TextField();
		
		txtFieldRepoURL.setCaption("Fedora package name:");
		txtFieldRepoURL.setInputPrompt("Enter package name");
		txtFieldRepoURL.setWidth("500px");
	    btnOkRepo.setWidth("130");
	    btnCancelRepo.setWidth("130");
	    
	    btnAddRepo.addClickListener( e -> {
	    	if (!txtFieldRepoURL.getValue().isEmpty()) {
	    		repoListVLayout.addComponent(new Label(txtFieldRepoURL.getValue() 
	    				+ " - is added!"));
	    		txtFieldRepoURL.clear();
	    	}
	    });
	    
//	    btnOkRepo.addClickListener( e -> {
//	    	
//	    });
	    hLayout.addComponents(txtFieldRepoURL, btnAddRepo);
	    hLayout.setComponentAlignment(btnAddRepo, Alignment.BOTTOM_RIGHT);
	    hLayout.setMargin(true);
	    hLayout.setSpacing(true);
	    vLayout.setMargin(true);
	    vLayout.setSpacing(true);
	    repoListVLayout.setMargin(true);
	    repoListVLayout.setSpacing(true);
	    btnsHLayout.setMargin(true);
	    btnsHLayout.setSpacing(true);
	    vLayout.addComponent(hLayout);
	    vLayout.addComponent(repoListVLayout);
	    btnsHLayout.addComponents(btnCancelRepo, btnOkRepo);
	    vLayout.addComponent(btnsHLayout);
	    vLayout.setComponentAlignment(btnsHLayout, Alignment.BOTTOM_RIGHT);
	    center();
	    setContent(vLayout);
	}
	
}
