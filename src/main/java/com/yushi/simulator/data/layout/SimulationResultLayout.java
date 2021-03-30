package com.yushi.simulator.data.layout;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.yushi.simulator.data.LoadCsvFile;
import com.yushi.simulator.data.data.Column;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;


@SuppressWarnings("serial")
@CssImport(value="./styles/gridStyles.css", themeFor="vaadin-grid")
public class SimulationResultLayout extends VerticalLayout {
	private Grid<Column> stageState;
	private List<Column> columns;
	
	public SimulationResultLayout() {
		/* load csv-file ( file path is written at "config.properties" */
		LoadCsvFile lcf = new LoadCsvFile();
		
		/* VerticalLayout property */
		this.setSizeFull();
		
		/* TreeGrid property */
		this.stageState = new Grid<>();
		this.stageState.removeAllColumns();
		this.stageState.setSizeFull();
		
		/* set data */
		this.columns = lcf.getColumns();
		List<Column> columnsUniq = new ArrayList<Column>(new LinkedHashSet<Column>(this.columns));
		this.stageState.setItems(columnsUniq);
		
		this.stageState.addColumn(Column::getCycle).setWidth("9%");
		this.stageState.addColumn(Column::getStage1).setWidth("13%");
		this.stageState.addColumn(Column::getStage2).setWidth("13%");
		this.stageState.addColumn(Column::getStage3).setWidth("13%");
		this.stageState.addColumn(Column::getStage4).setWidth("13%");
		this.stageState.addColumn(Column::getStage5).setWidth("13%");
		this.stageState.addColumn(Column::getStage6).setWidth("13%");
		this.stageState.addColumn(Column::getStage7).setWidth("13%");
		
		this.stageState.getColumns().get(1).setClassNameGenerator(item -> {
			if(item.getStage1().equals("SEND")) return "rowRed";
			else return "";
		});
		
//		this.stageState.setClassName("g-cell-color-red");
		
		this.add(this.stageState);
	}
}