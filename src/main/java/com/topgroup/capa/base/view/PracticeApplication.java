
package com.topgroup.capa.base.view;

import com.topgroup.capa.base.view.screen.PracticeScreen;
import com.vaadin.Application;
import com.vaadin.ui.Window;

public class PracticeApplication extends Application {
	private static final long serialVersionUID = -2719039325987214154L;

	private Window window;

	@Override
	public void init() {
		setTheme("applayout");
		window = new Window("My Vaadin Application");
		setMainWindow(window);
		window.addComponent(new PracticeScreen(window));
	}
}
