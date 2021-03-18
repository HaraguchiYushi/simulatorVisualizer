package com.yushi.simulator.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.router.Route;
import com.yushi.simulator.config.PropertyControl;
import com.yushi.simulator.data.data.Column;

public class LoadCsvFile {
	private File csvFile = null;
	private List<String> text = null;
	private List<Column> columns = new ArrayList<Column>();
	
	public String getAtLine(int index) { return this.text.get(index); }
	public List<String> getAll() { return this.text; }
	public int getTextLength() { return this.text.size(); }
	public List<Column> getColumns() { return this.columns; }
	
	public LoadCsvFile() {
		String filePath = PropertyControl.getObject().get("CSV_FILE_PATH");
		csvFile = new File(filePath);

	    List<String> lines = new ArrayList<String>();
		try (
			BufferedReader reader = new BufferedReader(new FileReader(csvFile))){
		    String str;
		    while ((str = reader.readLine()) != null) lines.add(str);
		    this.text = lines;
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		this.columns = analize(this.text);
	}
	
	private List<Column> analize(List<String> text) {
		List<Column> columns = new ArrayList<>();
		for(int i = 0; i < text.size(); i++) {
			Column line = new Column();
			String[] rows = text.get(i).split(",");
			for(int j = 0; j < rows.length; j++) {
				switch(j) {
					case 0: line.setCycle (rows[j]);
					case 1: line.setStage1(rows[j]);
					case 2: line.setStage2(rows[j]);
					case 3: line.setStage3(rows[j]);
					case 4: line.setStage4(rows[j]);
					case 5: line.setStage5(rows[j]);
					case 6: line.setStage6(rows[j]);
					case 7: line.setStage7(rows[j]);
				}
			}
			columns.add(line);
		}
		return columns;
	}
	
	/* テスト用のメソッド */
	public void printAll() {
		if(this.text == null) return ;
		for(int i = 0; i < this.text.size(); i++) {
			System.out.println(text.get(i));
		}
	}
}