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
public class repoWindow extends Window {
	public repoWindow() {
		super("Remote Package Specification");
	
		final VerticalLayout vLayout = new VerticalLayout();
		final HorizontalLayout hLayout = new HorizontalLayout();
		
		final TextField txtFieldRepoURL = new TextField();
		txtFieldRepoURL.setCaption("Package repository (GitHub):");
		txtFieldRepoURL.setInputPrompt("Enter URL to the repository");
	
	    Button btnAddRepo = new Button(FontAwesome.PLUS);
	    
	    btnAddRepo.addClickListener( e -> {
	    	if (!txtFieldRepoURL.getValue().isEmpty()) {
	    		vLayout.addComponent(new Label(txtFieldRepoURL.getValue() 
	    				+ " - is added!"));
	    		txtFieldRepoURL.clear();
	    	}
	    });
	    
	    hLayout.addComponents(txtFieldRepoURL, btnAddRepo);
	    hLayout.setComponentAlignment(btnAddRepo, Alignment.BOTTOM_RIGHT);
	    hLayout.setMargin(true);
	    hLayout.setSpacing(true);
	    vLayout.setMargin(true);
	    vLayout.setSpacing(true);
	    vLayout.addComponent(hLayout);
	    center();
	    setContent(vLayout);
	}
	
}
