package com.yushi.simulator.visualizer;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.yushi.simulator.data.layout.SimulationResultLayout;

@Route(value = "SimulatorVisualizer")
public class MainView extends Div {	
	/* メインレイアウト */
	SimulationResultLayout srl = new SimulationResultLayout();

	public MainView () {
		srl.setSizeFull();
		this.setSizeFull();
		this.add(srl);
	}
}