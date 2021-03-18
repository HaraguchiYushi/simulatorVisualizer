package com.yushi.simulator.main;

import org.springframework.beans.factory.annotation.Configurable;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.yushi.simulator.visualizer.MainView;

@Route()
@Theme(value = Lumo.class)
@Configurable
public class RootConf {
	private RouteConfiguration configuration = RouteConfiguration.forSessionScope();

	public RootConf () {
		configuration.removeRoute(MainView.class);
		configuration.setRoute("SimulatorVisualizer", MainView.class);
		UI.getCurrent().navigate("SimulatorVisualizer");
	}
}